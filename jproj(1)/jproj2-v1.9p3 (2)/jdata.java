
import java.security.Security;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.lang.*;
import com.ticketnetwork.webservices2.*;
import javax.xml.*;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.util.*;
import java.util.Properties;
import java.util.regex.*;
import java.lang.*;
import javax.xml.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.mail.*;
import javax.mail.internet.*;
//need to switch order of loops - move loop over dbs inside. loop iver conns create stmt arrays to loop over.  will cut down mem use
public class jdata {

    static String num_high_sales_performers_in_Category_to_return = "1000";  //the default set by TN is 20.
//= DriverManager.getConnection("jdbc:"+driver+"://"+server+":"+port+"/"+db+"?user="+username+"&password="+password);                   
    public static void main(String[] args) throws Exception {
        boolean gotException = false;
        ByteArrayOutputStream email = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(email);
        PrintStream log = null;
        String smtp_server = "";
        String smtp_port = "25";
        String email_from = "";
        String email_to = "";
        String smtpUsername = "";
        String smtpPassword = "";
        String useSMTPAuth = "false";
        boolean sendMail = false;
        try {

            Properties props = new Properties();
            props.load(new FileInputStream("jdata.ini"));
            Hashtable<String, Object> data_hash = new Hashtable<String, Object>();
            String[] databases = delimitedStringToArray(props.getProperty("DatabaseFiles"), ",");
            String logfile_name = props.getProperty("logfile");
            sendMail = Boolean.valueOf(props.getProperty("sendMail"));
            smtp_server = props.getProperty("smtp_server");
            smtp_port = (props.getProperty("smtp_port")).trim();
            email_from = props.getProperty("email_from");
            email_to = props.getProperty("email_to");
            useSMTPAuth = props.getProperty("useSMTPAuth");
            smtpUsername = props.getProperty("smtpUsername");
            smtpPassword = props.getProperty("smtpPassword");
            boolean appendLog = Boolean.valueOf(props.getProperty("appendLog"));
            log = new PrintStream(new FileOutputStream("jdata.log", appendLog));
            out.println("############################################################################");
            log.println("############################################################################");
            System.out.println("############################################################################");
            out.println("--------------------------------------------------------------------");
            out.println("-----Begin-JData-Run------------------------------------------------");
            out.println("Jdata Global Settings");
            out.println("Events BeginDate: " + props.getProperty("BeginDate"));
            out.println("Events EndDate: " + props.getProperty("EndDate"));
            out.println("sendMail: " + sendMail);
            if (sendMail) {
                out.println("smtp_server: " + smtp_server);
                out.println("smtp_port: " + smtp_port);
                out.println("email_to: " + email_to);
                out.println("email_from: " + email_from);
                out.println("useSMTPAuth: " + useSMTPAuth);
                out.println("SMTP username: " + smtpUsername);
            }
            out.println("logfile: " + logfile_name);
            out.println("appendLog: " + appendLog);
            out.println("DatabaseFiles: " + props.getProperty("DatabaseFiles"));
            out.println("ParentCategories: " + props.getProperty("ParentCategories"));
            out.println("-----Beginning loop over databases at: " + new java.util.Date() + "-");
            System.out.println("--------------------------------------------------------------------");
            System.out.println("-----Begin-JData-Run------------------------------------------------");
            System.out.println("Jdata Global Settings");
            System.out.println("Events BeginDate: " + props.getProperty("BeginDate"));
            System.out.println("Events EndDate: " + props.getProperty("EndDate"));
            System.out.println("sendMail: " + sendMail);
            if (sendMail) {
                System.out.println("smtp_server: " + smtp_server);
                System.out.println("smtp_port: " + smtp_port);
                System.out.println("email_to: " + email_to);
                System.out.println("email_from: " + email_from);
                System.out.println("useSMTPAuth: " + useSMTPAuth);
                System.out.println("SMTP username: " + smtpUsername);
            }
            System.out.println("logfile: " + logfile_name);
            System.out.println("appendLog: " + appendLog);
            System.out.println("DatabaseFiles: " + props.getProperty("DatabaseFiles"));
            System.out.println("ParentCategories: " + props.getProperty("ParentCategories"));
            System.out.println("-----Beginning loop over databases at: " + new java.util.Date() + "-");
            log.println("--------------------------------------------------------------------");
            log.println("-----Begin-JData-Run------------------------------------------------");
            log.println("Jdata Global Settings");
            log.println("Events BeginDate: " + props.getProperty("BeginDate"));
            log.println("Events EndDate: " + props.getProperty("EndDate"));
            log.println("sendMail: " + sendMail);
            if (sendMail) {
                log.println("smtp_server: " + smtp_server);
                log.println("smtp_port: " + smtp_port);
                log.println("email_to: " + email_to);
                log.println("email_from: " + email_from);
                log.println("useSMTPAuth: " + useSMTPAuth);
                log.println("SMTP username: " + smtpUsername);
            }
            log.println("logfile: " + logfile_name);
            log.println("appendLog: " + appendLog);
            log.println("DatabaseFiles: " + props.getProperty("DatabaseFiles"));
            log.println("ParentCategories: " + props.getProperty("ParentCategories"));
            log.println("-----Beginning loop over databases at: " + new java.util.Date() + "-");

            int k = 0;
            //loop over each db in list
            while (k < databases.length) {
                Properties db_props = new Properties();
                out.println("Reading properties for DB " + (k + 1));
                log.println("Reading properties for DB " + (k + 1));
                System.out.println("Reading properties for DB " + (k + 1));

                db_props.load(new FileInputStream(databases[k]));
                try {

                    //Class.forName("com.mysql.jdbc.Driver");
                    String driver = db_props.getProperty("driver");
                    String option = db_props.getProperty("option");
                    String server = db_props.getProperty("server");
                    String db = db_props.getProperty("db");
                    String dbport = db_props.getProperty("dbport");
                    String username = db_props.getProperty("username");
                    String password = db_props.getProperty("password");
                    boolean restoreFromBackup = Boolean.valueOf(db_props.getProperty("restoreFromBackup"));
                    boolean deleteOldEntries = Boolean.valueOf((db_props.getProperty("deleteOldEntries")).trim());

                    out.println("driver: " + driver);
                    out.println("server: " + server);
                    out.println("port: " + dbport);
                    out.println("db: " + db);
                    out.println("option: " + option);
                    out.println("username: " + username);
                    out.println("restoreFromBackup: " + restoreFromBackup);
                    out.println("deleteOldEntries: " + deleteOldEntries);

                    System.out.println("driver: " + driver);
                    System.out.println("server: " + server);
                    System.out.println("port: " + dbport);
                    System.out.println("db: " + db);
                    System.out.println("option: " + option);
                    System.out.println("username: " + username);
                    System.out.println("restoreFromBackup: " + restoreFromBackup);
                    System.out.println("deleteOldEntries: " + deleteOldEntries);

                    log.println("driver: " + driver);
                    log.println("server: " + server);
                    log.println("port: " + dbport);
                    log.println("db: " + db);
                    log.println("option: " + option);
                    log.println("username: " + username);
                    log.println("restoreFromBackup: " + restoreFromBackup);
                    log.println("deleteOldEntries: " + deleteOldEntries);

                    Connection conn = null;
                    Statement stmt = null;
                    ResultSet rs;

                    Properties systemSettings = System.getProperties();
                    systemSettings.put("http.proxyHost", "");
                    systemSettings.put("http.proxyPort", "");
                    System.setProperties(systemSettings);
                    conn = DriverManager.getConnection("jdbc:" + driver + "://" + server + ":" + dbport + "/" + db + "?user=" + username + "&password=" + password + "&Option=" + option);
                    String create_events_table = "CREATE TABLE events(" + "ID       INTEGER NOT NULL," + "PRIMARY KEY (ID)," + "Name          TEXT NOT NULL, " + "Date         DATETIME, " + "DisplayDate     TEXT, " + "Venue          TEXT, " + "City         TEXT, " + "StateProvince        TEXT, " + "ParentCategoryID        INTEGER, " + "ChildCategoryID          INTEGER, " + "GrandchildCategoryID          INTEGER, " + "MapURL     TEXT, " + "VenueID   INTEGER, " + "StateProvinceID  INTEGER, " + "VenueConfigurationID  INTEGER, " + "Clicks  INTEGER, " + "IsWomensEvent          BOOL)";
                    String create_performers_table = "CREATE TABLE performers(" + "ID       INTEGER NOT NULL," + "Name          VARCHAR(767) NOT NULL, " + "ParentCategoryDescription     TEXT, " + "ChildCategoryDescription          TEXT, " + "GrandchildCategoryDescription         TEXT, " + "ParentCategoryID        INTEGER, " + "ChildCategoryID          INTEGER, " + "GrandchildCategoryID          INTEGER," + " PRIMARY KEY(ID, Name, ParentCategoryID,ChildCategoryID,GrandchildCategoryID))";
                    String create_categories_table = "CREATE TABLE categories(" + "ParentCategoryDescription     TEXT, " + "ChildCategoryDescription          TEXT, " + "GrandchildCategoryDescription         TEXT, " + "ParentCategoryID        INTEGER, " + "ChildCategoryID          INTEGER, " + "GrandchildCategoryID          INTEGER," + " PRIMARY KEY(ParentCategoryID,ChildCategoryID,GrandchildCategoryID))";
                    String create_venues_table = "CREATE TABLE venues(" + "ID       INTEGER NOT NULL," + "PRIMARY KEY (ID)," + "Name          TEXT NOT NULL, " + "URL          TEXT, " + "Notes          TEXT, " +
                            "Street1          TEXT, " + "Street2          TEXT, " + "City          TEXT, " + "StateProvince          TEXT, " + "ZipCode          TEXT, " + "Capacity          TEXT, " + "Directions          TEXT, " + "Parking          TEXT, " + "PublicTransportation          TEXT, " + "BoxOfficePhone          TEXT, " + "WillCall          TEXT, " + "Rules          TEXT, " +
                            "ChildRules          TEXT, " + "Country          TEXT)";
                    String create_sales_table = "CREATE TABLE sales(" + "ID       INTEGER NOT NULL," + "Name           VARCHAR(767) NOT NULL, " + "percent          FLOAT, " + "ParentCategoryDescription     TEXT, " + "ChildCategoryDescription          TEXT, " + "GrandchildCategoryDescription         TEXT, " + "ParentCategoryID        INTEGER, " + "ChildCategoryID          INTEGER, " + "GrandchildCategoryID          INTEGER," + " PRIMARY KEY(ID, Name, ParentCategoryID,ChildCategoryID,GrandchildCategoryID))";



                    String create_temp_events_table = "CREATE TABLE tempevents(" + "ID       INTEGER NOT NULL," + "PRIMARY KEY (ID)," + "Name          TEXT NOT NULL, " + "Date         DATETIME, " + "DisplayDate     TEXT, " + "Venue          TEXT, " + "City         TEXT, " + "StateProvince        TEXT, " + "ParentCategoryID        INTEGER, " + "ChildCategoryID          INTEGER, " + "GrandchildCategoryID          INTEGER, " + "MapURL     TEXT, " + "VenueID   INTEGER, " + "StateProvinceID  INTEGER, " + "VenueConfigurationID  INTEGER, " + "Clicks  INTEGER, " + "IsWomensEvent          BOOL)";
                    String create_temp_performers_table = "CREATE TABLE tempperformers(" + "ID       INTEGER NOT NULL," + "Name          VARCHAR(767) NOT NULL, " + "ParentCategoryDescription     TEXT, " + "ChildCategoryDescription          TEXT, " + "GrandchildCategoryDescription         TEXT, " + "ParentCategoryID        INTEGER, " + "ChildCategoryID          INTEGER, " + "GrandchildCategoryID          INTEGER," + " PRIMARY KEY(ID, Name, ParentCategoryID,ChildCategoryID,GrandchildCategoryID))";
                    String create_temp_categories_table = "CREATE TABLE tempcategories(" + "ParentCategoryDescription     TEXT, " + "ChildCategoryDescription          TEXT, " + "GrandchildCategoryDescription         TEXT, " + "ParentCategoryID        INTEGER, " + "ChildCategoryID          INTEGER, " + "GrandchildCategoryID          INTEGER," + " PRIMARY KEY(ParentCategoryID,ChildCategoryID,GrandchildCategoryID))";
                    String create_temp_venues_table = "CREATE TABLE tempvenues(" + "ID       INTEGER NOT NULL," + "PRIMARY KEY (ID)," + "Name          TEXT NOT NULL, " + "URL          TEXT, " + "Notes          TEXT, " +
                            "Street1          TEXT, " + "Street2          TEXT, " + "City          TEXT, " + "StateProvince          TEXT, " + "ZipCode          TEXT, " + "Capacity          TEXT, " + "Directions          TEXT, " + "Parking          TEXT, " + "PublicTransportation          TEXT, " + "BoxOfficePhone          TEXT, " + "WillCall          TEXT, " + "Rules          TEXT, " +
                            "ChildRules          TEXT, " + "Country          TEXT)";
                    String create_temp_sales_table = "CREATE TABLE tempsales(" + "ID       INTEGER NOT NULL," + "Name           VARCHAR(767) NOT NULL, " + "percent          FLOAT, " + "ParentCategoryDescription     TEXT, " + "ChildCategoryDescription          TEXT, " + "GrandchildCategoryDescription         TEXT, " + "ParentCategoryID        INTEGER, " + "ChildCategoryID          INTEGER, " + "GrandchildCategoryID          INTEGER," + " PRIMARY KEY(ID, Name, ParentCategoryID,ChildCategoryID,GrandchildCategoryID))";

                    String create_backup_events_table = "CREATE TABLE backup_events(" + "ID       INTEGER NOT NULL," + "PRIMARY KEY (ID)," + "Name          TEXT NOT NULL, " + "Date         DATETIME, " + "DisplayDate     TEXT, " + "Venue          TEXT, " + "City         TEXT, " + "StateProvince        TEXT, " + "ParentCategoryID        INTEGER, " + "ChildCategoryID          INTEGER, " + "GrandchildCategoryID          INTEGER, " + "MapURL     TEXT, " + "VenueID   INTEGER, " + "StateProvinceID  INTEGER, " + "VenueConfigurationID  INTEGER, " + "Clicks  INTEGER, " + "IsWomensEvent          BOOL)";
                    String create_backup_performers_table = "CREATE TABLE backup_performers(" + "ID       INTEGER NOT NULL," + "Name          VARCHAR(767) NOT NULL, " + "ParentCategoryDescription     TEXT, " + "ChildCategoryDescription          TEXT, " + "GrandchildCategoryDescription         TEXT, " + "ParentCategoryID        INTEGER, " + "ChildCategoryID          INTEGER, " + "GrandchildCategoryID          INTEGER," + " PRIMARY KEY(ID, Name, ParentCategoryID,ChildCategoryID,GrandchildCategoryID))";
                    String create_backup_categories_table = "CREATE TABLE backup_categories(" + "ParentCategoryDescription     TEXT, " + "ChildCategoryDescription          TEXT, " + "GrandchildCategoryDescription         TEXT, " + "ParentCategoryID        INTEGER, " + "ChildCategoryID          INTEGER, " + "GrandchildCategoryID          INTEGER," + " PRIMARY KEY(ParentCategoryID,ChildCategoryID,GrandchildCategoryID))";
                    String create_backup_venues_table = "CREATE TABLE backup_venues(" + "ID       INTEGER NOT NULL," + "PRIMARY KEY (ID)," + "Name          TEXT NOT NULL, " + "URL          TEXT, " + "Notes          TEXT, " +
                            "Street1          TEXT, " + "Street2          TEXT, " + "City          TEXT, " + "StateProvince          TEXT, " + "ZipCode          TEXT, " + "Capacity          TEXT, " + "Directions          TEXT, " + "Parking          TEXT, " + "PublicTransportation          TEXT, " + "BoxOfficePhone          TEXT, " + "WillCall          TEXT, " + "Rules          TEXT, " +
                            "ChildRules          TEXT, " + "Country          TEXT)";
                    String create_backup_sales_table = "CREATE TABLE backup_sales(" + "ID       INTEGER NOT NULL," + "Name           VARCHAR(767) NOT NULL, " + "percent          FLOAT, " + "ParentCategoryDescription     TEXT, " + "ChildCategoryDescription          TEXT, " + "GrandchildCategoryDescription         TEXT, " + "ParentCategoryID        INTEGER, " + "ChildCategoryID          INTEGER, " + "GrandchildCategoryID          INTEGER," + " PRIMARY KEY(ID, Name, ParentCategoryID,ChildCategoryID,GrandchildCategoryID))";

                    if (restoreFromBackup) {

                        try {
                            stmt = conn.createStatement();
                            stmt.executeUpdate("DROP TABLE IF EXISTS categories");
                            stmt.executeUpdate(create_categories_table);
                            stmt.executeUpdate("insert into categories select * from backup_categories");
                            stmt.executeUpdate("DROP TABLE IF EXISTS venues");
                            stmt.executeUpdate(create_venues_table);
                            stmt.executeUpdate("insert into venues select * from backup_venues");
                            stmt.executeUpdate("DROP TABLE IF EXISTS events");
                            stmt.executeUpdate(create_events_table);
                            stmt.executeUpdate("insert into events select * from backup_events");
                            stmt.executeUpdate("DROP TABLE IF EXISTS performers");
                            stmt.executeUpdate(create_performers_table);
                            stmt.executeUpdate("insert into performers select * from backup_performers");
                            stmt.executeUpdate("DROP TABLE IF EXISTS sales");
                            stmt.executeUpdate(create_sales_table);
                            stmt.executeUpdate("insert into sales select * from backup_sales");
                            stmt.close();
                            conn.close();
                            k++;
                            continue;


                        } catch (Exception e) {
                            System.out.println("Error while restoring from backup: " + e);
                            out.println("Error while restoring from backup: " + e);
                            log.println("Error while restoring from backup: " + e);
                            gotException = true;


                        }
                    } else if (!restoreFromBackup && !deleteOldEntries) {
                        try {
                            stmt = conn.createStatement();
                            stmt.executeUpdate("DROP TABLE IF EXISTS backup_categories");
                            stmt.executeUpdate(create_backup_categories_table);
                            stmt.executeUpdate("insert into backup_categories select * from categories");
                            stmt.executeUpdate("DROP TABLE IF EXISTS backup_venues");
                            stmt.executeUpdate(create_backup_venues_table);
                            stmt.executeUpdate("insert into backup_venues select * from venues");
                            stmt.executeUpdate("DROP TABLE IF EXISTS backup_events");
                            stmt.executeUpdate(create_backup_events_table);
                            stmt.executeUpdate("insert into backup_events select * from events");
                            stmt.executeUpdate("DROP TABLE IF EXISTS backup_performers");
                            stmt.executeUpdate(create_backup_performers_table);
                            stmt.executeUpdate("insert into backup_performers select * from performers");
                            stmt.executeUpdate("DROP TABLE IF EXISTS backup_sales");
                            stmt.executeUpdate(create_backup_sales_table);
                            stmt.executeUpdate("insert into backup_sales select * from sales");
                            stmt.close();



                        } catch (Exception e) {

                            System.out.println("Error while creating backups: " + e);
                            out.println("Error while creating backups: " + e);
                            log.println("Error while creating backups: " + e);
                            gotException = true;
                        }


                    } else {

                    //do nothing backups will be made after the tables are populated 
                    }
                    try {
                        stmt = conn.createStatement();


                        try {  //create the events table
                            if (deleteOldEntries) {
                                stmt.executeUpdate(create_temp_events_table);
                            //stmt.executeUpdate("DROP TABLE IF EXISTS events");
                            }
                            stmt.executeUpdate(create_events_table);
                        } catch (Exception e) {

                        }
                        try { //create the performers table
                            if (deleteOldEntries) {
                                stmt.executeUpdate(create_temp_performers_table);
                            // stmt.executeUpdate("DROP TABLE IF EXISTS performers");
                            }
                            stmt.executeUpdate(create_performers_table);
                        } catch (Exception e) {

                        }
                        try { //create the high sales performers table
                            if (deleteOldEntries) {
                                stmt.executeUpdate(create_temp_sales_table);
                            //stmt.executeUpdate("DROP TABLE IF EXISTS sales");
                            }
                            stmt.executeUpdate(create_sales_table);
                        } catch (Exception e) {

                        }
                        try { //create the venues table
                            if (deleteOldEntries) {
                                stmt.executeUpdate(create_temp_venues_table);
                            //stmt.executeUpdate("DROP TABLE IF EXISTS venues");
                            }
                            stmt.executeUpdate(create_venues_table);
                        } catch (Exception e) {

                        }
                        try {
                            if (deleteOldEntries) {
                                stmt.executeUpdate(create_temp_categories_table);
                            //stmt.executeUpdate("DROP TABLE IF EXISTS categories");
                            }
                            stmt.executeUpdate(create_categories_table);
                        } catch (Exception e) {

                        }



                    } catch (Exception e) {
                        System.out.println("Error while creating tables: " + e);
                        out.println("Error while creating tables: " + e);
                        log.println("Error while creating tables: " + e);
                        gotException = true;
                    }



                    System.out.println("Updating categories");
                    out.println("Updating categories");
                    log.println("Updating categories");
                    try {
                        PreparedStatement psi = null;
                        PreparedStatement psu = null;
                        if (deleteOldEntries) {
                            psi = conn.prepareStatement("INSERT INTO tempcategories (ParentCategoryID, ChildCategoryID, GrandchildCategoryID,ParentCategoryDescription,ChildCategoryDescription,GrandchildCategoryDescription) VALUES (?,?,?,?,?,?)");
                            psu = conn.prepareStatement("UPDATE tempcategories SET ParentCategoryDescription=?,ChildCategoryDescription=?,GrandchildCategoryDescription=? WHERE (ParentCategoryID=? and ChildCategoryID=? and GrandchildCategoryID=? )");
                        } else {
                            psi = conn.prepareStatement("INSERT INTO categories (ParentCategoryID, ChildCategoryID, GrandchildCategoryID,ParentCategoryDescription,ChildCategoryDescription,GrandchildCategoryDescription) VALUES (?,?,?,?,?,?)");
                            psu = conn.prepareStatement("UPDATE categories SET ParentCategoryDescription=?,ChildCategoryDescription=?,GrandchildCategoryDescription=? WHERE (ParentCategoryID=? and ChildCategoryID=? and GrandchildCategoryID=? )");


                        }
                        String websiteConfigIDString = props.getProperty("websiteConfigID");
                        String useProxy = props.getProperty("useProxy");
                        String proxyHost = props.getProperty("proxyHost");
                        String proxyPort = props.getProperty("proxyPort");
                        if (Boolean.valueOf(useProxy)) {
                            systemSettings = System.getProperties();
                            systemSettings.put("http.proxyHost", proxyHost);
                            systemSettings.put("http.proxyPort", proxyPort);
                            System.setProperties(systemSettings);

                        }

                        Category[] Category_array = null;
                        if (data_hash.containsKey("categories")) {
                            Category_array = (Category[]) data_hash.get("categories");
                            System.out.println("Categories in Hash");

                        } else {
                            TNServicesStringInputs tns = new TNServicesStringInputs();
                            TNServicesStringInputsSoap tnss = tns.getTNServicesStringInputsSoap();


                            ArrayOfCategory array_of_categories = tnss.getCategoriesMasterList(websiteConfigIDString);
                            if (array_of_categories == null) {
                                gotException = true;
                                throw new Exception("Error - no Categories found");

                            }

                            java.util.List<Category> Category_list = array_of_categories.getCategory();
                            Category_array = Category_list.toArray(new Category[0]);
                            data_hash.put("categories", Category_array);
                            System.out.println("Categories NOT in Hash");
                        }


                        int rows = Category_array.length;
                        if (rows == 0) {
                            gotException = true;
                            throw new Exception("Error - no Categories found");

                        }
                        int i = 0;
                        int inserts = 0;
                        int updates = 0;
                        while (i < rows) {


                            String parent = Category_array[i].getParentCategoryDescription();
                            String child = Category_array[i].getChildCategoryDescription();
                            String grand_child = Category_array[i].getGrandchildCategoryDescription();
                            int parentID = Category_array[i].getParentCategoryID();
                            int childID = Category_array[i].getChildCategoryID();
                            int grand_childID = Category_array[i].getGrandchildCategoryID();




                            psi.setInt(1, parentID);
                            psi.setInt(2, childID);
                            psi.setInt(3, grand_childID);
                            psi.setString(4, parent);
                            psi.setString(5, child);
                            psi.setString(6, grand_child);


                            try {

                                psi.executeUpdate();
                                //System.out.println((i + 1) + " of " + rows + "  Category insert " + parent);
                                inserts++;
                            } catch (SQLException sse) {
                                psu.setInt(4, parentID);
                                psu.setInt(5, childID);
                                psu.setInt(6, grand_childID);
                                psu.setString(1, parent);
                                psu.setString(2, child);
                                psu.setString(3, grand_child);

                                psu.executeUpdate();
                                //System.out.println((i + 1) + " of " + rows + "  Category update " + parent);
                                updates++;
                            }

                            i++;

                        }
                        System.out.println("Performed " + inserts + " inserts and " + updates + " updates on " + rows);
                        out.println("Performed " + inserts + " inserts and " + updates + " updates on " + rows);
                        log.println("Performed " + inserts + " inserts and " + updates + " updates on " + rows);

                    } catch (Exception e) {

                        System.out.println("Exception while updating Category table: " + e);
                        out.println("Exception while updating Category table: " + e);
                        log.println("Exception while updating Category table: " + e);
                        gotException = true;
                    }

                    try {
                        if (deleteOldEntries) {
                            //stmt.executeUpdate("DROP TABLE IF EXISTS categories");
                            //stmt.executeUpdate("RENAME TABLE tempcategories TO categories;");

                            stmt.executeUpdate("RENAME TABLE categories TO del_categories, tempcategories TO categories;");
                            stmt.executeUpdate("DROP TABLE IF EXISTS del_categories");
                        }




                    } catch (Exception e) {
                        System.out.println("Exception while renaming temp Category table: " + e);
                        out.println("Exception while renaming temp Category table: " + e);
                        log.println("Exception while renaming temp Category table: " + e);
                        gotException = true;
                    }

                    System.out.println("Updating venues");
                    out.println("Updating venues");
                    log.println("Updating venues");
                    try {
                        PreparedStatement psi = null;
                        PreparedStatement psu = null;
                        if (deleteOldEntries) {
                            psi = conn.prepareStatement("INSERT INTO tempvenues (ID, Name, URL, Notes, Street1, Street2,City,StateProvince,ZipCode,Capacity,Directions,Parking,PublicTransportation,BoxOfficePhone,WillCall,Rules,ChildRules,Country) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                            psu = conn.prepareStatement("UPDATE tempvenues SET Name=?, URL=?, Notes=?, Street1=?, Street2=?,City=?,StateProvince=?,ZipCode=?,Capacity=?,Directions=?,Parking=?,PublicTransportation=?,BoxOfficePhone=?,WillCall=?,Rules=?,ChildRules=?,Country=? WHERE ID=?");
                        } else {
                            psi = conn.prepareStatement("INSERT INTO venues (ID, Name, URL, Notes, Street1, Street2,City,StateProvince,ZipCode,Capacity,Directions,Parking,PublicTransportation,BoxOfficePhone,WillCall,Rules,ChildRules,Country) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                            psu = conn.prepareStatement("UPDATE venues SET Name=?, URL=?, Notes=?, Street1=?, Street2=?,City=?,StateProvince=?,ZipCode=?,Capacity=?,Directions=?,Parking=?,PublicTransportation=?,BoxOfficePhone=?,WillCall=?,Rules=?,ChildRules=?,Country=? WHERE ID=?");


                        }
                        String venueID = "";
                        String websiteConfigIDString = props.getProperty("websiteConfigID");
                        String useProxy = props.getProperty("useProxy");
                        String proxyHost = props.getProperty("proxyHost");
                        String proxyPort = props.getProperty("proxyPort");
                        if (Boolean.valueOf(useProxy)) {
                            systemSettings = System.getProperties();
                            systemSettings.put("http.proxyHost", proxyHost);
                            systemSettings.put("http.proxyPort", proxyPort);
                            System.setProperties(systemSettings);

                        }
                        Venue[] venue_array = null;
                        if (data_hash.containsKey("venues")) {
                            venue_array = (Venue[]) data_hash.get("venues");
                            System.out.println("Venues in Hash");

                        } else {
                            TNServicesStringInputs tns = new TNServicesStringInputs();
                            TNServicesStringInputsSoap tnss = tns.getTNServicesStringInputsSoap();
                            ArrayOfVenue array_of_venues = tnss.getVenue(websiteConfigIDString, venueID);
                            if (array_of_venues == null) {
                                System.out.println("No Venues Found. Returning empty keyset.");
                                gotException = true;
                                throw new Exception("Error - no Venues found");

                            }
                            java.util.List<Venue> venue_list = array_of_venues.getVenue();
                            venue_array = venue_list.toArray(new Venue[0]);
                            data_hash.put("venues", venue_array);
                            System.out.println("Venues NOT in Hash");
                        }


                        int rows = venue_array.length;
                        if (rows == 0) {
                            //System.out.println("No Venues Found. Returning empty keyset.");
                            gotException = true;
                            throw new Exception("Error - no Venues found");

                        }
                        int i = 0;
                        int inserts = 0;
                        int updates = 0;
                        //conn.setAutoCommit(false);
                        while (i < rows) {


                            String name = venue_array[i].getName();
                            int id = venue_array[i].getID();
                            String city = venue_array[i].getCity();
                            String StateProvince = venue_array[i].getStateProvince();
                            String Country = venue_array[i].getCountry();
                            String URL = venue_array[i].getURL();

                            String notes = venue_array[i].getNotes();
                            String street1 = venue_array[i].getStreet1();
                            String street2 = venue_array[i].getStreet2();
                            String zipcode = venue_array[i].getZipCode();
                            String capacity = "" + venue_array[i].getCapacity();
                            String directions = venue_array[i].getDirections();
                            String parking = venue_array[i].getParking();
                            String publictransportation = venue_array[i].getPublicTransportation();

                            String boxofficephone = venue_array[i].getBoxOfficePhone();
                            String willcall = venue_array[i].getWillCall();
                            String rules = venue_array[i].getRules();
                            String childrules = venue_array[i].getChildRules();
                            psi.setInt(1, id);
                            psi.setString(2, name);
                            psi.setString(3, URL);
                            psi.setString(4, notes);
                            psi.setString(5, street1);
                            psi.setString(6, street2);
                            psi.setString(7, city);
                            psi.setString(8, StateProvince);
                            psi.setString(9, zipcode);
                            psi.setString(10, capacity);
                            psi.setString(11, directions);
                            psi.setString(12, parking);
                            psi.setString(13, publictransportation);
                            psi.setString(14, boxofficephone);
                            psi.setString(15, willcall);
                            psi.setString(16, rules);
                            psi.setString(17, childrules);
                            psi.setString(18, Country);


                            try {

                                psi.executeUpdate();
                                //System.out.println((i + 1) + " of " + rows + "  venue insert " + name);
                                inserts++;
                            } catch (SQLException sse) {

                                psu.setInt(18, id);
                                psu.setString(1, name);
                                psu.setString(2, URL);
                                psu.setString(3, notes);
                                psu.setString(4, street1);
                                psu.setString(5, street2);
                                psu.setString(6, city);
                                psu.setString(7, StateProvince);
                                psu.setString(8, zipcode);
                                psu.setString(9, capacity);
                                psu.setString(10, directions);
                                psu.setString(11, parking);
                                psu.setString(12, publictransportation);
                                psu.setString(13, boxofficephone);
                                psu.setString(14, willcall);
                                psu.setString(15, rules);
                                psu.setString(16, childrules);
                                psu.setString(17, Country);

                                psu.executeUpdate();
                                //System.out.println((i + 1) + " of " + rows + "  venue update " + name);
                                updates++;
                            }

                            i++;

                        }
                        // conn.commit();
                        System.out.println("Performed " + inserts + " inserts and " + updates + " updates on " + rows);
                        out.println("Performed " + inserts + " inserts and " + updates + " updates on " + rows);
                        log.println("Performed " + inserts + " inserts and " + updates + " updates on " + rows);

                    } catch (Exception e) {
                        System.out.println("Exception while updating venues table: " + e);
                        out.println("Exception while updating venues table: " + e);
                        log.println("Exception while updating venues table: " + e);
                        gotException = true;

                    }
                    //conn.setAutoCommit(true);
                    try {
                        if (deleteOldEntries) {
                            //stmt.executeUpdate("DROP TABLE IF EXISTS venues");
                            //stmt.executeUpdate("RENAME TABLE tempvenues TO venues;");

                            stmt.executeUpdate("RENAME TABLE venues TO del_venues, tempvenues TO venues;");
                            stmt.executeUpdate("DROP TABLE IF EXISTS del_venues");
                        }

                    } catch (Exception e) {

                        System.out.println("Exception while renaming temp venues table: " + e);
                        out.println("Exception while renaming temp venues table: " + e);
                        log.println("Exception while renaming temp venues table: " + e);
                        gotException = true;

                    }
                    System.out.println("Updating performers");
                    out.println("Updating performers");
                    log.println("Updating performers");
                    try {
                        PreparedStatement psi = null;
                        PreparedStatement psu = null;
                        if (deleteOldEntries) {
                            psi = conn.prepareStatement("INSERT INTO tempperformers (ID, Name,ParentCategoryID, ChildCategoryID, GrandchildCategoryID,ParentCategoryDescription,ChildCategoryDescription,GrandchildCategoryDescription) VALUES (?,?,?,?,?,?,?,?)");
                            psu = conn.prepareStatement("UPDATE tempperformers SET ParentCategoryDescription=?,ChildCategoryDescription=?,GrandchildCategoryDescription=? WHERE (ID=? and Name=? and ParentCategoryID=? and ChildCategoryID=? and GrandchildCategoryID=? )");
                        } else {
                            psi = conn.prepareStatement("INSERT INTO performers (ID, Name,ParentCategoryID, ChildCategoryID, GrandchildCategoryID,ParentCategoryDescription,ChildCategoryDescription,GrandchildCategoryDescription) VALUES (?,?,?,?,?,?,?,?)");
                            psu = conn.prepareStatement("UPDATE performers SET ParentCategoryDescription=?,ChildCategoryDescription=?,GrandchildCategoryDescription=? WHERE (ID=? and Name=? and ParentCategoryID=? and ChildCategoryID=? and GrandchildCategoryID=? )");

                        }
                        String websiteConfigIDString = props.getProperty("websiteConfigID");
                        String hasEvent = "";
                        String numReturned = "";
                        String parentCategoryID = "";
                        String childCategoryID = "";
                        String grandchildCategoryID = "";
                        String useProxy = props.getProperty("useProxy");
                        String proxyHost = props.getProperty("proxyHost");
                        String proxyPort = props.getProperty("proxyPort");
                        if (Boolean.valueOf(useProxy)) {
                            systemSettings = System.getProperties();
                            systemSettings.put("http.proxyHost", proxyHost);
                            systemSettings.put("http.proxyPort", proxyPort);
                            System.setProperties(systemSettings);

                        }

                        Performer[] performer_array = null;
                        if (data_hash.containsKey("performers")) {
                            performer_array = (Performer[]) data_hash.get("performers");
                            System.out.println("performers in Hash");

                        } else {
                            TNServicesStringInputs tns = new TNServicesStringInputs();
                            TNServicesStringInputsSoap tnss = tns.getTNServicesStringInputsSoap();


                            ArrayOfPerformer array_of_performers = tnss.getPerformerByCategory(websiteConfigIDString, parentCategoryID, childCategoryID, grandchildCategoryID, hasEvent);
                            if (array_of_performers == null) {
                                gotException = true;
                                throw new Exception("Error - no Venues found");

                            }

                            java.util.List<Performer> performer_list = array_of_performers.getPerformer();
                            performer_array = performer_list.toArray(new Performer[0]);
                            data_hash.put("performers", performer_array);
                            System.out.println("Performers NOT in Hash");
                        }


                        int rows = performer_array.length;
                        if (rows == 0) {
                            gotException = true;
                            throw new Exception("Error - no Performers found");
                        }
                        int i = 0;
                        int inserts = 0;
                        int updates = 0;
                        while (i < rows) {


                            String name = performer_array[i].getDescription();
                            int id = performer_array[i].getID();
                            Category cat = performer_array[i].getCategory();
                            String ParentCategoryDescription = "" + cat.getParentCategoryDescription();
                            String ChildCategoryDescription = "" + cat.getChildCategoryDescription();
                            String GrandchildCategoryDescription = "" + cat.getGrandchildCategoryDescription();
                            int parentID = cat.getParentCategoryID();
                            int childID = cat.getChildCategoryID();
                            int grand_childID = cat.getGrandchildCategoryID();



                            psi.setInt(1, id);
                            psi.setString(2, name);
                            psi.setInt(3, parentID);
                            psi.setInt(4, childID);
                            psi.setInt(5, grand_childID);
                            psi.setString(6, ParentCategoryDescription);
                            psi.setString(7, ChildCategoryDescription);
                            psi.setString(8, GrandchildCategoryDescription);

                            try {

                                psi.executeUpdate();
                                //System.out.println((i + 1) + " of " + rows + "  performer insert " + name);
                                inserts++;
                            } catch (SQLException sse) {
                                psu.setInt(4, id);
                                psu.setString(5, name);
                                psu.setInt(6, parentID);
                                psu.setInt(7, childID);
                                psu.setInt(8, grand_childID);
                                psu.setString(1, ParentCategoryDescription);
                                psu.setString(2, ChildCategoryDescription);
                                psu.setString(3, GrandchildCategoryDescription);


                                psu.executeUpdate();
                                //System.out.println((i + 1) + " of " + rows + "  performer update " + name);
                                updates++;
                            }

                            i++;

                        }
                        System.out.println("Performed " + inserts + " inserts and " + updates + " updates" + " on " + rows);
                        out.println("Performed " + inserts + " inserts and " + updates + " updates" + " on " + rows);
                        log.println("Performed " + inserts + " inserts and " + updates + " updates" + " on " + rows);


                    } catch (Exception e) {
                        gotException = true;
                        System.out.println("Exception while updating performers table: " + e);
                        out.println("Exception while updating performers table: " + e);
                        log.println("Exception while updating performers table: " + e);

                    }

                    try {
                        if (deleteOldEntries) {
                            //stmt.executeUpdate("DROP TABLE IF EXISTS performers");
                            //stmt.executeUpdate("RENAME TABLE tempperformers TO performers;");

                            stmt.executeUpdate("RENAME TABLE performers TO del_performers, tempperformers TO performers;");
                            stmt.executeUpdate("DROP TABLE IF EXISTS del_performers");
                        }

                    } catch (Exception e) {
                        gotException = true;
                        System.out.println("Exception while renaming temp performers table: " + e);
                        out.println("Exception while renaming temp performers table: " + e);
                        log.println("Exception while renaming temp performers table: " + e);

                    }


                    System.out.println("Updating high sales performers");
                    out.println("Updating high sales performers");
                    log.println("Updating high sales performers");
                    try {
                        PreparedStatement psi = null;
                        PreparedStatement psu = null;
                        if (deleteOldEntries) {
                            psi = conn.prepareStatement("INSERT INTO tempsales (ID, Name,percent,ParentCategoryID, ChildCategoryID, GrandchildCategoryID,ParentCategoryDescription,ChildCategoryDescription,GrandchildCategoryDescription) VALUES (?,?,?,?,?,?,?,?,?)");
                            psu = conn.prepareStatement("UPDATE tempsales SET percent=?,ParentCategoryDescription=?,ChildCategoryDescription=?,GrandchildCategoryDescription=? WHERE (ID=? and Name=? and ParentCategoryID=? and ChildCategoryID=? and GrandchildCategoryID=? )");
                        } else {
                            psi = conn.prepareStatement("INSERT INTO sales (ID, Name,percent,ParentCategoryID, ChildCategoryID, GrandchildCategoryID,ParentCategoryDescription,ChildCategoryDescription,GrandchildCategoryDescription) VALUES (?,?,?,?,?,?,?,?,?)");
                            psu = conn.prepareStatement("UPDATE sales SET percent=?,ParentCategoryDescription=?,ChildCategoryDescription=?,GrandchildCategoryDescription=? WHERE (ID=? and Name=? and ParentCategoryID=? and ChildCategoryID=? and GrandchildCategoryID=? )");


                        }
                        String websiteConfigIDString = props.getProperty("websiteConfigID");
                        String numReturned = num_high_sales_performers_in_Category_to_return;
                        String parentCategoryID = "";
                        String childCategoryID = "";
                        String grandchildCategoryID = "";
                        String useProxy = props.getProperty("useProxy");
                        String proxyHost = props.getProperty("proxyHost");
                        String proxyPort = props.getProperty("proxyPort");
                        if (Boolean.valueOf(useProxy)) {
                            systemSettings = System.getProperties();
                            systemSettings.put("http.proxyHost", proxyHost);
                            systemSettings.put("http.proxyPort", proxyPort);
                            System.setProperties(systemSettings);

                        }



                        String[] ParentCategories = delimitedStringToArray(props.getProperty("ParentCategories"), ",");
                        int j = 0;
                        int inserts = 0;
                        int updates = 0;
                        int tot_inserts = 0;
                        int tot_updates = 0;
                        while (j < ParentCategories.length) {
                            parentCategoryID = ParentCategories[j];
                            PerformerPercent[] performer_array = null;
                            if (data_hash.containsKey("sales" + ParentCategories[j])) {
                                performer_array = (PerformerPercent[]) data_hash.get("sales" + ParentCategories[j]);
                                System.out.println("high sales performers in Hash");

                            } else {
                                TNServicesStringInputs tns = new TNServicesStringInputs();
                                TNServicesStringInputsSoap tnss = tns.getTNServicesStringInputsSoap();

                                ArrayOfPerformerPercent array_of_performers = tnss.getHighSalesPerformers(websiteConfigIDString, numReturned, parentCategoryID, childCategoryID, grandchildCategoryID);
                                if (array_of_performers == null) {
                                    j++;
                                    System.out.println("No high sales performers for cat " + ParentCategories[j - 1]);
                                    out.println("No high sales performers for cat " + ParentCategories[j - 1]);
                                    log.println("No high sales performers for cat " + ParentCategories[j - 1]);
                                    continue;

                                }
                                java.util.List<PerformerPercent> performer_list = array_of_performers.getPerformerPercent();
                                performer_array = performer_list.toArray(new PerformerPercent[0]);
                                data_hash.put("sales" + ParentCategories[j], performer_array);
                                System.out.println("high Performers NOT in Hash");
                            }


                            int rows = performer_array.length;
                            if (rows == 0) {
                                j++;
                                System.out.println("No high sales performers for cat " + ParentCategories[j - 1]);
                                out.println("No high sales performers for cat " + ParentCategories[j - 1]);
                                log.println("No high sales performers for cat " + ParentCategories[j - 1]);

                                continue;
                            }
                            int i = 0;
                            inserts = 0;
                            updates = 0;
                            while (i < rows) {

                                Performer performer = performer_array[i].getPerformer();
                                String name = performer.getDescription();
                                int id = performer.getID();
                                Category cat = performer.getCategory();
                                String ParentCategoryDescription = "" + cat.getParentCategoryDescription();
                                String ChildCategoryDescription = "" + cat.getChildCategoryDescription();
                                String GrandchildCategoryDescription = "" + cat.getGrandchildCategoryDescription();
                                float percent = 0.0f;
                                try {
                                    percent = ((performer_array[i]).getPercent()).floatValue();
                                } catch (Exception e) {
                                    percent = 0.0f;
                                }
                                int parentID = cat.getParentCategoryID();
                                int childID = cat.getChildCategoryID();
                                int grand_childID = cat.getGrandchildCategoryID();



                                psi.setInt(1, id);
                                psi.setString(2, name);
                                psi.setFloat(3, percent);
                                psi.setInt(4, parentID);
                                psi.setInt(5, childID);
                                psi.setInt(6, grand_childID);
                                psi.setString(7, ParentCategoryDescription);
                                psi.setString(8, ChildCategoryDescription);
                                psi.setString(9, GrandchildCategoryDescription);


                                try {

                                    psi.executeUpdate();
                                    //System.out.println((i + 1) + " of " + rows + "  high sales performer insert " + name);
                                    inserts++;
                                    tot_inserts++;
                                } catch (SQLException sse) {
                                    psu.setInt(5, id);
                                    psu.setString(6, name);
                                    psu.setFloat(1, percent);
                                    psu.setInt(7, parentID);
                                    psu.setInt(8, childID);
                                    psu.setInt(9, grand_childID);
                                    psu.setString(2, ParentCategoryDescription);
                                    psu.setString(3, ChildCategoryDescription);
                                    psu.setString(4, GrandchildCategoryDescription);

                                    psu.executeUpdate();
                                    //System.out.println((i + 1) + " of " + rows + " high sales performer update " + name);
                                    updates++;
                                    tot_updates++;
                                }

                                i++;

                            }
                            System.out.println("Performed " + inserts + " inserts and " + updates + " updates on " + rows + " for ParentCategoryID: " + ParentCategories[j]);
                            out.println("Performed " + inserts + " inserts and " + updates + " updates on " + rows + " for ParentCategoryID: " + ParentCategories[j]);
                            log.println("Performed " + inserts + " inserts and " + updates + " updates on " + rows + " for ParentCategoryID: " + ParentCategories[j]);


                            j++;
                        }
                        System.out.println("Performed " + tot_inserts + " inserts and " + tot_updates + " updates total on high sales performers");
                        out.println("Performed " + tot_inserts + " inserts and " + tot_updates + " updates total on high sales performers");
                        log.println("Performed " + tot_inserts + " inserts and " + tot_updates + " updates total on high sales performers");


                    } catch (Exception e) {
                        gotException = true;
                        System.out.println("Exception while updating high sales performers table: " + e);
                        out.println("Exception while updating high sales performers table: " + e);
                        log.println("Exception while updating high sales performers table: " + e);

                    }
                    try {
                        if (deleteOldEntries) {
                            //stmt.executeUpdate("DROP TABLE IF EXISTS sales");
                            //stmt.executeUpdate("RENAME TABLE tempsales TO sales;");

                            stmt.executeUpdate("RENAME TABLE sales TO del_sales, tempsales TO sales;");
                            stmt.executeUpdate("DROP TABLE IF EXISTS del_sales");
                        }

                    } catch (Exception e) {
                        gotException = true;
                        System.out.println("Exception while renaming temp high sales performers table: " + e);
                        out.println("Exception while renaming temp high sales performers table: " + e);
                        log.println("Exception while renaming temp high sales performers table: " + e);

                    }


                    System.out.println("Updating events");
                    out.println("Updating events");
                    log.println("Updating events");
                    try {
                        PreparedStatement psi = null;
                        PreparedStatement psu = null;
                        if (deleteOldEntries) {
                            psi = conn.prepareStatement("INSERT INTO tempevents (ID,Name,Date,DisplayDate,Venue,City,StateProvince,ParentCategoryID,ChildCategoryID,GrandchildCategoryID,MapURL,VenueID,StateProvinceID,VenueConfigurationID,Clicks,isWomensEvent) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                            psu = conn.prepareStatement("UPDATE tempevents SET Name=?,Date=?,DisplayDate=?,Venue=?,City=?,StateProvince=?,ParentCategoryID=?,ChildCategoryID=?,GrandchildCategoryID=?,MapURL=?,VenueID=?,StateProvinceID=?,VenueConfigurationID=?,Clicks=?,isWomensEvent=? WHERE ID=?");
                        } else {
                            psi = conn.prepareStatement("INSERT INTO events (ID,Name,Date,DisplayDate,Venue,City,StateProvince,ParentCategoryID,ChildCategoryID,GrandchildCategoryID,MapURL,VenueID,StateProvinceID,VenueConfigurationID,Clicks,isWomensEvent) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                            psu = conn.prepareStatement("UPDATE events SET Name=?,Date=?,DisplayDate=?,Venue=?,City=?,StateProvince=?,ParentCategoryID=?,ChildCategoryID=?,GrandchildCategoryID=?,MapURL=?,VenueID=?,StateProvinceID=?,VenueConfigurationID=?,Clicks=?,isWomensEvent=? WHERE ID=?");


                        }


                        String websiteConfigIDString = props.getProperty("websiteConfigID");
                        String beginDate = props.getProperty("beginDate");
                        String endDate = props.getProperty("endDate");

                        String eventID = "";
                        String eventName = "";
                        String eventDate = "";
                        String venueID = "";
                        String venueName = "";
                        String stateProvince = "";
                        String stateProvinceID = "";
                        String cityZip = "";
                        String nearZip = "";
                        String parentCategoryID = "";
                        String childCategoryID = "";
                        String grandchildCategoryID = "";
                        String performerID = "";
                        String performerName = "";
                        String noPerformers = "";
                        String lowPrice = "";
                        String highPrice = "";
                        String sortColumn = "";
                        String sortDescending = "";
                        String mandatoryCreditCard = "";
                        String modificationDate = "";
                        String onlyMine = "";
                        String numberOfEvents = "";
                        String useProxy = props.getProperty("useProxy");
                        String proxyHost = props.getProperty("proxyHost");
                        String proxyPort = props.getProperty("proxyPort");
                        if (Boolean.valueOf(useProxy)) {
                            systemSettings = System.getProperties();
                            systemSettings.put("http.proxyHost", proxyHost);
                            systemSettings.put("http.proxyPort", proxyPort);
                            System.setProperties(systemSettings);

                        }
                        if (beginDate != null) {

                            if (beginDate.compareToIgnoreCase("today") == 0) {
                                try {
                                    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                                    java.util.Date date = new java.util.Date();
                                    String datetime = dateFormat.format(date);
                                    //System.out.println("Today : " + datetime);
                                    beginDate = datetime;
                                    props.setProperty("beginDate", beginDate);

                                } catch (Exception e) {
                                    gotException = true;
                                    System.out.println("something went wrong in processing BeginDate in events: " + e);
                                    out.println("something went wrong in processing BeginDate in events: " + e);
                                    log.println("something went wrong in processing BeginDate in events: " + e);

                                }
                            }
                        }


                        String[] ParentCategories = delimitedStringToArray(props.getProperty("ParentCategories"), ",");
                        int j = 0;
                        int inserts = 0;
                        int updates = 0;
                        int tot_updates = 0;
                        int tot_inserts = 0;
                        while (j < ParentCategories.length) {
                            parentCategoryID = ParentCategories[j];

                            Event[] event_array = null;
                            if (data_hash.containsKey("events" + ParentCategories[j])) {
                                event_array = (Event[]) data_hash.get("events" + ParentCategories[j]);
                                System.out.println("Events in Hash");

                            } else {
                                TNServicesStringInputs tns = new TNServicesStringInputs();
                                TNServicesStringInputsSoap tnss = tns.getTNServicesStringInputsSoap();
                                ArrayOfEvent array_of_events = tnss.getEvents(websiteConfigIDString, numberOfEvents, eventID, eventName, eventDate, beginDate, endDate, venueID, venueName, stateProvince, stateProvinceID, cityZip, nearZip, parentCategoryID, childCategoryID, grandchildCategoryID, performerID, performerName, noPerformers, lowPrice, highPrice, sortColumn, sortDescending, mandatoryCreditCard, modificationDate, onlyMine);
                                if (array_of_events == null) {
                                    j++;
                                    System.out.println("No events for cat " + ParentCategories[j - 1]);
                                    out.println("No events for cat " + ParentCategories[j - 1]);
                                    log.println("No events for cat " + ParentCategories[j - 1]);

                                    continue;

                                }
                                java.util.List<Event> event_list = array_of_events.getEvent();
                                event_array = event_list.toArray(new Event[0]);
                                data_hash.put("events" + ParentCategories[j], event_array);
                                System.out.println("Events NOT in Hash");
                            }


                            int rows = event_array.length;
                            if (rows == 0) {
                                j++;
                                System.out.println("No events for cat " + ParentCategories[j - 1]);
                                out.println("No events for cat " + ParentCategories[j - 1]);
                                log.println("No events for cat " + ParentCategories[j - 1]);

                                continue;
                            }

                            int i = 0;
                            //conn.setAutoCommit(false);
                            updates = 0;
                            inserts = 0;
                            while (i < rows) {

                                int id = event_array[i].getID();
                                String name = event_array[i].getName();
                                //System.out.println(replaceStringWithString("" + event_array[i].getDate() + "", "T", " "));
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                                java.util.Date date1 = sdf.parse(replaceStringWithString("" + event_array[i].getDate() + "", "T", " "));
                                java.sql.Timestamp date = new java.sql.Timestamp(date1.getTime());
                                //System.out.println(date.toString());
                                String displaydate = event_array[i].getDisplayDate();
                                String venue = event_array[i].getVenue();
                                String city = event_array[i].getCity();
                                String StateProvince = event_array[i].getStateProvince();
                                int parentID = event_array[i].getParentCategoryID();
                                int childID = event_array[i].getChildCategoryID();
                                int grand_childID = event_array[i].getGrandchildCategoryID();
                                String mapURL = event_array[i].getMapURL();
                                int venueid = event_array[i].getVenueID();
                                int StateProvinceID = event_array[i].getStateProvinceID();
                                int venueConfigurationID = event_array[i].getVenueConfigurationID();
                                int clicks = event_array[i].getClicks();
                                boolean isWomensEvent = event_array[i].isIsWomensEvent();
                                psi.setInt(1, id);
                                psi.setString(2, name);
                                psi.setTimestamp(3, date);
                                psi.setString(4, displaydate);
                                psi.setString(5, venue);
                                psi.setString(6, city);
                                psi.setString(7, StateProvince);
                                psi.setInt(8, parentID);
                                psi.setInt(9, childID);
                                psi.setInt(10, grand_childID);
                                psi.setString(11, mapURL);
                                psi.setInt(12, venueid);
                                psi.setInt(13, StateProvinceID);
                                psi.setInt(14, venueConfigurationID);
                                psi.setInt(15, clicks);
                                psi.setBoolean(16, isWomensEvent);

                                try {
                                    psi.executeUpdate();
                                    //System.out.println((i + 1) + " of " + rows + "  event insert " + name + " " + ParentCategories[j]);
                                    inserts++;
                                    tot_inserts++;
                                } catch (SQLException sse) {
                                    psu.setInt(16, id);
                                    psu.setString(1, name);
                                    psu.setTimestamp(2, date);
                                    psu.setString(3, displaydate);
                                    psu.setString(4, venue);
                                    psu.setString(5, city);
                                    psu.setString(6, StateProvince);
                                    psu.setInt(7, parentID);
                                    psu.setInt(8, childID);
                                    psu.setInt(9, grand_childID);
                                    psu.setString(10, mapURL);
                                    psu.setInt(11, venueid);
                                    psu.setInt(12, StateProvinceID);
                                    psu.setInt(13, venueConfigurationID);
                                    psu.setInt(14, clicks);
                                    psu.setBoolean(15, isWomensEvent);
                                    psu.executeUpdate();
                                    //System.out.println((i + 1) + " of " + rows + "  event update " + name + " " + ParentCategories[j]);
                                    updates++;
                                    tot_updates++;
                                }

                                i++;

                            }
                            //conn.commit();

                            System.out.println("Performed " + inserts + " inserts and " + updates + " updates on " + rows + " for ParentCategoryID: " + ParentCategories[j]);
                            out.println("Performed " + inserts + " inserts and " + updates + " updates on " + rows + " for ParentCategoryID: " + ParentCategories[j]);
                            log.println("Performed " + inserts + " inserts and " + updates + " updates on " + rows + " for ParentCategoryID: " + ParentCategories[j]);

                            j++;
                        }



                        System.out.println("Performed " + tot_inserts + " inserts and " + tot_updates + " updates total on events");
                        out.println("Performed " + tot_inserts + " inserts and " + tot_updates + " updates total on events");
                        log.println("Performed " + tot_inserts + " inserts and " + tot_updates + " updates total on events");


                    } catch (Exception e) {
                        gotException = true;
                        System.out.println("Exception while updating events table: " + e);
                        out.println("Exception while updating events table: " + e);
                        log.println("Exception while updating events table: " + e);


                    }
                    //conn.setAutoCommit(true);
                    try {
                        if (deleteOldEntries) {
                            //stmt.executeUpdate("DROP TABLE IF EXISTS events");
                            //stmt.executeUpdate("RENAME TABLE tempevents TO events;");

                            stmt.executeUpdate("RENAME TABLE events TO del_events, tempevents TO events;");
                            stmt.executeUpdate("DROP TABLE IF EXISTS del_events");
                        }

                    } catch (Exception e) {
                        gotException = true;
                        System.out.println("Exception while renaming temp events table: " + e);
                        out.println("Exception while renaming temp events table: " + e);
                        log.println("Exception while renaming temp events table: " + e);

                    }

                    if (deleteOldEntries) {
                        try {

                            stmt.executeUpdate("DROP TABLE IF EXISTS backup_categories");
                            stmt.executeUpdate(create_backup_categories_table);
                            stmt.executeUpdate("insert into backup_categories select * from categories");
                            stmt.executeUpdate("DROP TABLE IF EXISTS backup_venues");
                            stmt.executeUpdate(create_backup_venues_table);
                            stmt.executeUpdate("insert into backup_venues select * from venues");
                            stmt.executeUpdate("DROP TABLE IF EXISTS backup_events");
                            stmt.executeUpdate(create_backup_events_table);
                            stmt.executeUpdate("insert into backup_events select * from events");
                            stmt.executeUpdate("DROP TABLE IF EXISTS backup_performers");
                            stmt.executeUpdate(create_backup_performers_table);
                            stmt.executeUpdate("insert into backup_performers select * from performers");
                            stmt.executeUpdate("DROP TABLE IF EXISTS backup_sales");
                            stmt.executeUpdate(create_backup_sales_table);
                            stmt.executeUpdate("insert into backup_sales select * from sales");
                            stmt.close();



                        } catch (Exception e) {
                            gotException = true;
                            System.out.println("Error while creating backups: " + e);
                            out.println("Error while creating backups: " + e);
                            log.println("Error while creating backups: " + e);
                        }


                    }
                    stmt.close();
                    conn.close();
                } catch (Exception e) {
                    gotException = true;
                    System.out.println("Error while updating database: " + (k + 1) + " exception: " + e);
                    out.println("Error while updating database: " + (k + 1) + " exception: " + e);
                    log.println("Error while updating database: " + (k + 1) + " exception: " + e);
                }
                out.println("Processing of database: " + (k + 1) + " complete" + "----------------------------");
                log.println("Processing of database: " + (k + 1) + " complete" + "----------------------------");
                System.out.println("Processing of database: " + (k + 1) + " complete" + "----------------------------");
                k++;
            }//end of loop over dbs
            out.println("---Completed-loop-over-databases-at: " + new java.util.Date() + "-");
            System.out.println("---Completed-loop-over-databases-at: " + new java.util.Date() + "-");
            log.println("---Completed-loop-over-databases-at: " + new java.util.Date() + "-");

        } catch (Exception endex) {
            gotException = true;
            out.println("Exception in main loop: " + endex);
            log.println("Exception in main loop: " + endex);
            System.out.println("Exception in main loop: " + endex);

        }
        out.println("-----End---JData-Run------------------------------------------------");
        out.println("--------------------------------------------------------------------");
        out.println("############################################################################");
        if (sendMail) {
            try {
                out.flush();
                out.close();
                String subject = "JData Update ";
                if (gotException) {
                    subject = subject + "has Exceptions ";
                } else {
                    subject = subject + "Successful ";
                }
                subject = subject + (new java.util.Date());
                Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                sendMessage(email_to, subject, email.toString(), email_from, smtp_server, smtp_port, useSMTPAuth, smtpUsername, smtpPassword);
            //System.out.println("Email sent.");
            } catch (Exception e) {

                log.println("Exception while sending jdata email: " + e);
                System.out.println("Exception while sending jdata email: " + e);
            }
        }
        log.println("-----End---JData-Run------------------------------------------------");
        log.println("--------------------------------------------------------------------");
        log.println("############################################################################");

        log.flush();
        log.close();
        System.out.println("-----End---JData-Run------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("############################################################################");


    } //end of main

    public static String replaceStringWithString(String s, String p, String r) {

        StringTokenizer st = new StringTokenizer(s, p, false);
        String t = "";
        boolean beginning = true;
        while (st.hasMoreElements()) {
            if (beginning) {
                t += st.nextElement();
                beginning =
                        false;
            } else {
                t += r;
                t +=
                        st.nextElement();
            }

        }
        return t;
    }

    public static String replaceSpaces(String s, String r) {
        StringTokenizer st = new StringTokenizer(s, " ", false);
        String t = "";
        boolean beginning = true;
        while (st.hasMoreElements()) {
            if (beginning) {
                t += st.nextElement();
                beginning =
                        false;
            } else {
                t += r;
                t +=
                        st.nextElement();
            }

        }
        return t;
    }//end of removeSpaces
    public static String removeSpaces(String s) {
        StringTokenizer st = new StringTokenizer(s, " ", false);
        String t = "";

        while (st.hasMoreElements()) {

            t += st.nextElement();



        }

        return t;
    } //end of removeSpaces

    public static String replaceString(Properties p, String s) {
        String temp = p.getProperty(s.trim());
        if (temp == null) {
            temp = "";
        }
        return temp.trim();


    }//end replace string
    public static String replaceStringOrKeepSame(Properties p, String s) {
        String temp = p.getProperty(s.trim());
        if (temp == null) {
            return s;
        }
        return temp.trim();


    }//end replace string or keep same
    public static String[] delimitedStringToArray(String s, String delimiter) {
        //System.out.println("Parsing: " + s );
        //System.out.println("Delimiter " + delimiter );
        StringTokenizer st = new StringTokenizer(s, delimiter, false);
        int i = 0;
        while (st.hasMoreElements()) {
            String temp = (String) st.nextElement();

            i++;

        }
        //System.out.println("Getting ready to tokenize1" );
        if (i == 0) {
            return (new String[0]);
        }
//System.out.println("Getting ready to tokenize2" );
        String[] array = new String[i];
        st =
                new StringTokenizer(s, delimiter, false);
        i =
                0;
        while (st.hasMoreElements()) {
            array[i] = (String) st.nextElement();
            i++;

        }


        return array;


    } //end of delimitedStringToArray

    public static String[][] doubleDelimitedStringToArray(String s, String outer_delimiter, String inner_delimiter) {

        StringTokenizer ost = new StringTokenizer(s, outer_delimiter, false);
        //System.out.println("Parsing: " + s );
        //System.out.println("Delimiter " + outer_delimiter );
        int i = 0;
        while (ost.hasMoreElements()) {
            String temp = (String) ost.nextElement();
            //System.out.println("" +i + " th String: "  + temp );
            i++;

        }


        if (i == 0) {
            return (new String[0][0]);
        }

        ost = new StringTokenizer(s, outer_delimiter, false);
        String array[][] = new String[i][];
        i =
                0;
        //System.out.println("Entering loop");
        while (ost.hasMoreElements()) {
            String temp = (String) ost.nextElement();
            // System.out.println("" +i + " th String in 2nd loop: "  + temp.trim() );
            array[i] = delimitedStringToArray(temp.trim(), inner_delimiter);
            //System.out.println("" + i + " " + array[i][0] + " , " + array[i][1]);
            i++;

        }

        return array;


    } //end of doubledelimitedStringToArray

    public static void sendMessage(String recipient, String subject, String message, String from, String SMTP_HOST_NAME, String SMTP_PORT, String useAuth, final String username, final String password) throws MessagingException {

        if (useAuth.compareTo("true") == 0) {
            boolean debug = true;
            String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

            Properties props = new Properties();
            props.put("mail.smtp.host", SMTP_HOST_NAME);
            //props.put("mail.debug", "true");
            props.put("mail.smtp.auth", useAuth);
            props.put("mail.smtp.port", SMTP_PORT);
            props.put("mail.smtp.socketFactory.port", SMTP_PORT);
            props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.put("mail.smtp.socketFactory.fallback", "false");

            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {

                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

            //session.setDebug(debug);

            Message msg = new MimeMessage(session);
            InternetAddress addressFrom = new InternetAddress(from);
            msg.setFrom(addressFrom);

            String[] recipients = delimitedStringToArray(recipient, ",");
            InternetAddress[] addressTo = new InternetAddress[recipients.length];

            for (int i = 0; i < recipients.length; i++) {
                addressTo[i] = new InternetAddress(recipients[i]);
            }
            msg.setRecipients(Message.RecipientType.TO, addressTo);
            //InternetAddress addressTo = new InternetAddress(recipient);
            //msg.setRecipient(Message.RecipientType.TO, addressTo);

            // Setting the Subject and Content Type
            msg.setSubject(subject);
            msg.setContent(message, "text/plain");
            Transport.send(msg);
        } else {
            boolean debug = true;

            Properties props = new Properties();
            props.put("mail.smtp.host", SMTP_HOST_NAME);
            props.put("mail.smtp.port", SMTP_PORT);
            props.put("mail.smtp.socketFactory.port", SMTP_PORT);

            props.put("mail.smtp.socketFactory.fallback", "false");

            Session session = Session.getDefaultInstance(props);




            Message msg = new MimeMessage(session);
            InternetAddress addressFrom = new InternetAddress(from);
            msg.setFrom(addressFrom);


            String[] recipients = delimitedStringToArray(recipient, ",");
            InternetAddress[] addressTo = new InternetAddress[recipients.length];

            for (int i = 0; i < recipients.length; i++) {
                addressTo[i] = new InternetAddress(recipients[i]);
            }
            msg.setRecipients(Message.RecipientType.TO, addressTo);
            //InternetAddress addressTo = new InternetAddress(recipient);
            //msg.setRecipient(Message.RecipientType.TO, addressTo);

            // Setting the Subject and Content Type
            msg.setSubject(subject);
            msg.setContent(message, "text/plain");
            Transport.send(msg);
        }
    }//end of sendMessage
    } //end of jdata class

