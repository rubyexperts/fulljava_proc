
import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.util.*;
import java.util.Properties;
import java.util.regex.*;
import java.lang.*;
import com.ticketnetwork.webservices2.*;
import javax.xml.*;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.xml.*;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.util.*;
import java.util.Properties;
import java.util.regex.*;
import java.lang.*;
import com.ticketnetwork.webservices2.*;
import javax.xml.*;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class jproj {

    public static int filename_title_col = 13; //this is set in processEvents
    public static int categories_col = 14; //this is set in processEvennts
    public static int dirname_title_col = 4; //this is set in processEvents
    public static boolean useDataBase = false;
    public static String db_ini_filename = "jdata.ini";
    public static boolean useParentCategoryDirName = false;
    public static boolean useChildCategoryDirName = false;
    public static boolean useGrandchildCategoryDirName = false;
    public static String resultsGeneralReplacement = "/ResultsGeneral.asp?stype=0&kwds=";
    public static boolean useLowerCaseFilenames = false;
    public static boolean useLowerCaseDirnames = false;
    public static String switchlinks_ticket_string = "";

    public static void main(String[] args) throws Exception {
        try {

            String settings_filename = "jproj.ini";
            String preprocessor_filename = "preprocess.ini";
            String url;
            String path;
            String filename_extension;
            String key_filename;
            String template_filename;
            String output_directory;
            int numKeyWords;
            String delimiter = ",";
            String out_dir_slash;
            String url_dir_slash;
            String url_filename_space = "";
            boolean flatlinks = true;
            int keyProcessingMethod = 0;
            String input_type = "csv";  //can also be tnws for ticket network web service
            boolean useProxy = false;
            String proxyPort;
            String proxyHost;
            int websiteConfigID = 0;
            String urlLink;
            Properties query = new Properties();
            boolean useStaticKeys = false;
            String static_key_filename = "";
            int numStaticKeyWords = 0;
            String staticKeyWordDelimiter = ",";
            //end of input variables
            boolean useKeyWordMappings = false;
            String temp_string = "";
            String view_tickets_url = "";
            boolean switchlinks = false;
            boolean fixingDuplicates = false;
            //System.out.println("Raw args: ");
            //for (String s: args) {
            // 	System.out.println(s);
            //




            int numArgs = Array.getLength(args);

            if (numArgs > 0) //check to see if -h or --help, help, is being requested.  if so, print out usage info and terminate
            {
                if (args[0].compareToIgnoreCase("-h") == 0 || args[0].compareToIgnoreCase("--help") == 0 || args[0].compareToIgnoreCase("-help") == 0) {
                    System.out.println("Usage: java jproj ");  //in this case jproj.ini must be in same dir as the exe	
                    System.out.println("Usage: java jproj settings_file"); //can just specify an alternate settings file location

                    return;
                }
            }


            //okay, we're really running
            System.out.println("Processing arguments");
            if (numArgs <= 1) {
                if (numArgs == 1) {
                    settings_filename = args[0];
                }
                try {
                    BufferedReader in = new BufferedReader(new FileReader(settings_filename));
                    String str;

                    url = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    path = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    filename_extension = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    key_filename = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    template_filename = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    output_directory = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    numKeyWords = Integer.parseInt(((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim()), 10);
                    delimiter = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    out_dir_slash = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    url_dir_slash = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    url_filename_space = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    flatlinks = Boolean.valueOf((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim());
                    switchlinks = Boolean.valueOf((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim());
                    keyProcessingMethod = Integer.parseInt(((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim()), 10);
                    input_type = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    useProxy = Boolean.valueOf((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim());
                    proxyHost = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    proxyPort = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    websiteConfigID = Integer.parseInt(((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim()), 10);
                    urlLink = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    resultsGeneralReplacement = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    useStaticKeys = Boolean.valueOf((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim());
                    static_key_filename = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    numStaticKeyWords = Integer.parseInt(((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim()), 10);
                    staticKeyWordDelimiter = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    useDataBase = Boolean.valueOf((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim());
                    db_ini_filename = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    useParentCategoryDirName = Boolean.valueOf((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim());
                    useChildCategoryDirName = Boolean.valueOf((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim());
                    useGrandchildCategoryDirName = Boolean.valueOf((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim());
                    useLowerCaseFilenames = Boolean.valueOf((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim());
                    useLowerCaseDirnames = Boolean.valueOf((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim());

                    //close the settings file
                    in.close();
                    //now get preprocessor info
                    in = new BufferedReader(new FileReader(preprocessor_filename));
                    Integer.parseInt(((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim()), 10);
                    (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    Integer.parseInt(((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim()), 10);
                    (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    switchlinks_ticket_string = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    Integer.parseInt(((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim()), 10);
                    in.close();
                } catch (IOException e) {
                    System.out.println("Error reading settings file: " + e);
                    return;
                }

            } else {

                System.out.println("Error in command line arguments or settings file.");
                return;

            } //end of arguments
    /* Do a little input validation and clean up*/
            //check that last char of out_dir matches out_dir_slash
            //check that first and last char of path matches url_dir_slash 
            //and that last char of url does not
            while (url.endsWith(url_dir_slash)) {
                url = url.substring(0, url.length() - 1);
            }
            if (!path.endsWith(url_dir_slash)) {
                path = path + url_dir_slash;
            }





            if (!path.startsWith(url_dir_slash)) {
                path = url_dir_slash + path;
            }





            if (!output_directory.endsWith(out_dir_slash)) {
                output_directory = output_directory + out_dir_slash;
            }

            Pattern r = Pattern.compile("[\\p{Space}]+");
            Matcher m = r.matcher(url_filename_space);
            if (m.matches()) {
                System.out.println("Invalid url filename spacer.  Replacing " + url_filename_space + " with = ");
                url_filename_space = "";
            }
            if (input_type.compareToIgnoreCase(
                    "csv") == 0) {
                //process it the old way - it's a csv file
                useKeyWordMappings = false;
            } else if (input_type.compareToIgnoreCase(
                    "tnws") == 0) {
                numKeyWords = -1;
                useKeyWordMappings = true;
            //using
            } else {

                System.out.println("Error  " + input_type + " not a recognized input type.");
                return;

            }
            view_tickets_url = url + urlLink;


            ///check the arguments
            System.out.println("-----------------");

            System.out.println("jproj settings:");

            System.out.println("-----------------");

            System.out.println("url: " + url);
            System.out.println(
                    "path: " + path);
            System.out.println(
                    "filenameext: " + filename_extension);
            System.out.println(
                    "keyfile: " + key_filename);
            System.out.println(
                    "tempfile: " + template_filename);
            System.out.println(
                    "outdir: " + output_directory);




            if (numKeyWords == -1) {
                System.out.println("num keywords will be set after tnws query");
            } else {
                System.out.println("num keywords: " + numKeyWords);
            }

            System.out.println("delim: " + delimiter);
            System.out.println(
                    "outslash: " + out_dir_slash);
            System.out.println(
                    "urlslash: " + url_dir_slash);
            System.out.println(
                    "url_filename_space: " + url_filename_space);
            System.out.println(
                    "Use flatlinks: " + flatlinks);
            System.out.println(
                    "Use switchlinks: " + switchlinks);
            System.out.println(
                    "Use LowerCase Filenames: " + useLowerCaseFilenames);
            System.out.println(
                    "Use LowerCase Directory Names: " + useLowerCaseDirnames);
            System.out.println(
                    "Key Processing method: " + keyProcessingMethod);
            System.out.println(
                    "Input Type: " + input_type);
            System.out.println(
                    "Use Database: " + useDataBase);




            if (useDataBase) {
                System.out.println("Database ini filename: " + db_ini_filename);
                System.out.println("Use Parent/Country Directory Names: " + useParentCategoryDirName);
                System.out.println("Use Child/State Directory Names " + useChildCategoryDirName);
                System.out.println("Use Grandchild/City Directory Names: " + useGrandchildCategoryDirName);

            }

            System.out.println("UseProxy: " + useProxy);
            System.out.println(
                    "ProxyHost: " + proxyHost);
            System.out.println(
                    "ProxyPort: " + proxyPort);
            System.out.println(
                    "Website ConfigID: " + websiteConfigID);
            System.out.println(
                    "Buy Now: " + urlLink);
            System.out.println(
                    "Duplicate event Buy Now: " + resultsGeneralReplacement);
            System.out.println(
                    "View Tickets url: " + view_tickets_url);
            System.out.println(
                    "Use Static Keys: " + useStaticKeys);
            System.out.println(
                    "Static Key File: " + static_key_filename);
            System.out.println(
                    "Num Static Keys: " + numStaticKeyWords);
            System.out.println(
                    "Static Key Delimiter: " + staticKeyWordDelimiter);
            System.out.println(
                    "Use Keyword Mappings: " + useKeyWordMappings);


            KeySet static_ks = null;
            if (useStaticKeys) {
                System.out.println("-----------------");
                System.out.println("Creating Static KeySet Object:");
                System.out.println("-----------------");
                static_ks = new KeySet(static_key_filename, numStaticKeyWords, staticKeyWordDelimiter);
                System.out.println("Done.  " + static_ks.numKeys() + " Static Keys found.");

            }
            if (input_type.compareToIgnoreCase(
                    "tnws") == 0) {

                System.out.println("-----------------");
                System.out.println("Internal preprocessor settings:");
                System.out.println("-----------------");
                Preprocessor.printSettings();
            }

            System.out.println("-----------------");

            System.out.println("Creating KeySet object");

            System.out.println("-----------------");
            //a lot of action happens here..  we read in the input csv file and populate a data structure containing
            //all of the "keyword" data
            KeySet ks;
            try {
                if (input_type.compareToIgnoreCase("csv") == 0) {
                    //process it the old way - it's a csv file
                    ks = new KeySet(url, path, filename_extension, key_filename, numKeyWords, delimiter, url_dir_slash, url_filename_space, flatlinks, keyProcessingMethod, urlLink, switchlinks);
                    System.out.println("CSV KeySet object Created");
                } else if (input_type.compareToIgnoreCase("tnws") == 0) {
                    //using ticketnet
                    ks = new KeySet(url, path, filename_extension, key_filename, numKeyWords, delimiter, url_dir_slash, url_filename_space, flatlinks, keyProcessingMethod, input_type, useProxy, proxyHost, proxyPort, websiteConfigID, urlLink, switchlinks);
                    System.out.println("TicketNetwork WebService KeySet object Created");
                } else {

                    System.out.println("Error Creating KeySet object.  " + input_type + " not a recognized input type.");
                    return;

                }

            } catch (Exception e) {

                System.out.println("Error Creating KeySet object: " + e);
                return;
            }
            query = ks.query;

            System.out.println("number of keys: " + ks.numKeys());
            System.out.println(
                    "-----------------");
            /*
            //do a little checking on the keys
            int k,l;
            k = l = 0;
            while(k < ks.numKeys()){
            System.out.println("link " + k + " : " + ks.links[k]);
            l= 0; 
            while(l < ks.numKeyWords()){
            System.out.println("key " + k + "," + l + " : " + ks.keys[k][l]);
            l++;
            }
            k++;
            }
             */
            System.out.println(
                    "Perparing files and directories.");
            System.out.println(
                    "-----------------");
            System.out.println(
                    "Opening template...");
            //now we open the template file
            String template = file2String(template_filename);

            //now verify the output directory is okay
            System.out.println(
                    "Checking output directory...");






            try {
                File dir = new File(output_directory);
                dir.mkdir();
            } catch (Exception e) {
                System.out.println("Problem creating or accessing output dir: " + e);
                return;
            }
            Hashtable<String, ExternalLinkSet> els_hash = new Hashtable<String, ExternalLinkSet>();

            System.out.println("-----------------");
            //and here we go, we go row by row using the key words to replace the tags in the template
            int i = 0;

            System.out.println("Begin processing...");

            System.out.println("----------------------------------");
            while (i < ks.numKeys()) {


                String temp = new String(template);
                String original = new String("");
                System.out.println("Processing key vector " + i + ": " + ks.keys[i][0]);
                System.out.println("-----------------");
                while (original.compareTo(temp) != 0) {  //keep processing until no further changes occur
                    original = new String(temp);

                    temp = processInserts(temp);
                    temp = processUrl(temp, ks);
                    temp = processPath(temp, ks);

                    try {
                        if (useKeyWordMappings) {
                            temp = processCapsKeys(temp, ks, i);
                            temp = processLowerKeys(temp, ks, i);
                            temp = processPuncKeys(temp, ks, i);
                            temp = processKeys(temp, ks, i);
                            temp = processStateAbbrvKey(temp, ks, i);
                            temp = processKeys(temp, ks, i, query);
                            temp = processGenericKeywordPattern("VIEWTICKETSURL", temp, view_tickets_url);
                        } else {
                            temp = processCapsKeys(temp, ks, i);
                            temp = processLowerKeys(temp, ks, i);
                            temp = processPuncKeys(temp, ks, i);
                            temp = processStateAbbrvKey(temp, ks, i);
                            temp = processKeys(temp, ks, i);
                            temp = processGenericKeywordPattern("VIEWTICKETSURL", temp, view_tickets_url);
                        }
                        if (useStaticKeys) {
                            temp = processStaticKeys(temp, static_ks);
                        }
                        //temp = processSynonyms(temp);
                        temp = processExternalLinks(temp, ks, els_hash);
                        temp = processExternalFootLinks(temp, ks, els_hash);
                        temp = processExternalHeadLinks(temp, ks, els_hash);
                        temp = processExternalAlphaLinks(temp, ks, els_hash);
                        temp = processExternalAlphaFootLinks(temp, ks, els_hash);
                        temp = processExternalAlphaHeadLinks(temp, ks, els_hash);


                    } catch (Exception e) {
                        System.out.println("Problem processing keys, Inserts or external links for key " + i + ": " + e);
                    //return;

                    }

                    try {

                        temp = processLinks(temp, ks);
                        temp = processAlphaLinks(temp, ks);
                        temp = processFootLinks(temp, ks);
                        temp = processAlphaFootLinks(temp, ks);
                        temp = processHeadLinks(temp, ks);
                        temp = processAlphaHeadLinks(temp, ks);
                        temp = processMTLinks(temp, ks);
                        temp = processMTFootLinks(temp, ks);
                        temp = processMTHeadLinks(temp, ks);
                        temp = processAlphaMTLinks(temp, ks);
                        temp = processAlphaMTFootLinks(temp, ks);
                        temp = processAlphaMTHeadLinks(temp, ks);

                    } catch (Exception e) {
                        System.out.println("Problem processing links for key " + i + ": " + e);
                    //return;

                    }
                    try {
                        temp = processUrl(temp, ks);
                        temp = processPath(temp, ks);
                        if (useKeyWordMappings) {
                            temp = processCapsKeys(temp, ks, i);
                            temp = processLowerKeys(temp, ks, i);
                            temp = processPuncKeys(temp, ks, i);
                            temp = processStateAbbrvKey(temp, ks, i);
                            temp = processKeys(temp, ks, i);
                            temp = processKeys(temp, ks, i, query);
                            temp = processGenericKeywordPattern("VIEWTICKETSURL", temp, view_tickets_url);
                        } else {
                            temp = processCapsKeys(temp, ks, i);
                            temp = processLowerKeys(temp, ks, i);
                            temp = processPuncKeys(temp, ks, i);
                            temp = processStateAbbrvKey(temp, ks, i);
                            temp = processKeys(temp, ks, i);
                            temp = processGenericKeywordPattern("VIEWTICKETSURL", temp, view_tickets_url);

                        }
                        if (useStaticKeys) {
                            temp = processStaticKeys(temp, static_ks);
                        }
                        if (useKeyWordMappings) {
                            temp = processCapsKeys(temp, ks, i);
                            temp = processLowerKeys(temp, ks, i);
                            temp = processPuncKeys(temp, ks, i);
                            temp = processStateAbbrvKey(temp, ks, i);
                            temp = processKeys(temp, ks, i);
                            temp = processKeys(temp, ks, i, query);
                            temp = processGenericKeywordPattern("VIEWTICKETSURL", temp, view_tickets_url);
                        } else {
                            temp = processCapsKeys(temp, ks, i);
                            temp = processLowerKeys(temp, ks, i);
                            temp = processPuncKeys(temp, ks, i);
                            temp = processStateAbbrvKey(temp, ks, i);
                            temp = processKeys(temp, ks, i);
                            temp = processGenericKeywordPattern("VIEWTICKETSURL", temp, view_tickets_url);
                        }
                        if (useStaticKeys) {
                            temp = processStaticKeys(temp, static_ks);
                        }
                        temp = processSynonyms(temp);

                    } catch (Exception e) {
                        System.out.println("Problem processing keywords and synonyms for key " + i + ": " + e);
                    //return;

                    }

                    try {

                        temp = processQueryLinks(temp, ks, els_hash);
                        temp = processQueryHeadLinks(temp, ks, els_hash);
                        temp = processQueryFootLinks(temp, ks, els_hash);
                        temp = processQueryAlphaLinks(temp, ks, els_hash);
                        temp = processQueryAlphaFootLinks(temp, ks, els_hash);
                        temp = processQueryAlphaHeadLinks(temp, ks, els_hash);


                    } catch (Exception e) {
                        System.out.println("Problem processing query links for key " + i + ": " + e);
                    //return;
                    }


                } //end of while loop

                System.out.println("Processing of key " + i + " complete.");
                System.out.println("writing output for key " + i);

                try {

                    String outfile;
                    String query_type = null;
                    if (query != null) {
                        query_type = query.getProperty("query_type");
                    }

                    try {
                        outfile = getOutputFileName(ks.keys[i], input_type, query_type, flatlinks, output_directory, filename_extension, url_filename_space, out_dir_slash);
                    } catch (Exception e) {

                        throw new Exception("Problem in getOutputFilename: " + e);
                    }
                    string2File(temp, outfile);
                    System.out.println("Output written to: " + outfile);
                    System.out.println("-----------------");
                    System.out.println("key " + i + " complete");
                    System.out.println("----------------------------------");

                } catch (Exception e) {
                    System.out.println("Problem writing output for key " + i + ": " + e);
                    System.out.println("-----------------");
                    System.out.println("key " + i + " complete");
                    System.out.println("----------------------------------");
                //return;

                }

                i++;  //increment the counter to move on to the next row of keys

            } //end of main key processing loop
        } catch (Exception e) {
            System.out.println("something went wrong in the main routine: " + e);
        }





    } //end of main

    static public class KeySet {
        //the keyset object stores a copy of the keys and settings used to create links.
        //if a large csv is being used it may be ness to run java with a request for lots of memeory and
        //possibly with the jit enabled for performance
        int rows; //rows = number of key word vectors
        int cols; // cols = number of keywords eg. if 2 the KEYWORD and KEYWORD1 are keywords
        String filename_extension = "htm";
        String url_dir_slash = "/";
        String url;
        String path;
        String key_filename;
        String delimiter;
        String url_filename_space;
        String[][] keys;
        String[] links;
        String[] link_order;
        boolean flatlinks;
        public boolean switchlinks = false;
        int keyProcessingMethod = 0;
        // 0 =raw
        // 1 = trim only
        // 2 = remove leading and trailing " then trim
        String input_type = "csv";  //can also be tnws for ticket network web service
        boolean useProxy = false;
        String proxyPort;
        String proxyHost;
        int websiteConfigID = 0;
        String urlLink;
        String old_path = "{PATH}";
        Properties query = null;

        public KeySet(String _key_filename, int _numKeyWords, String _delimiter) {
            key_filename = _key_filename;
            cols = _numKeyWords;
            delimiter = _delimiter;
            try {



                Pattern space_pattern = Pattern.compile("[\\p{Space}]+[\\s]*");
                Matcher space_matcher = space_pattern.matcher(" ");

                int i, j;
                CSVReader reader = new CSVReader(new FileReader(key_filename), delimiter.charAt(0), (char) 34, 0);
                String[] nextLine;

                rows = 0;
                while ((nextLine = reader.readNext()) != null) {

                    space_matcher.reset(nextLine[0]);
                    if (space_matcher.matches()) {
                    //blank 
                    } else {
                        rows++;
                    }


                }

                keys = new String[rows][cols];
                reader.close();
                reader = new CSVReader(new FileReader(key_filename), delimiter.charAt(0), (char) 34, 0);
                i = 0;
                while ((nextLine = reader.readNext()) != null) {

                    space_matcher.reset(nextLine[0]);
                    if (space_matcher.matches()) {
                    //blank 
                    } else {
                        j = 0;
                        while (j < cols && j < Array.getLength(nextLine)) {
                            keys[i][j] = new String(nextLine[j]);
                            j++;
                        }
                        j = 0;
                        while (j < cols) {
                            if (keys[i][j] == null) {
                                keys[i][j] = "";
                            }
                            keys[i][j] = processRawKey(keys[i][j], keyProcessingMethod);
                            j++;
                        }
                        i++;
                    }


                }

                reader.close();




            } catch (Exception e) {
                System.out.println("something went wrong in keyset() " + e);
            }


        }// end of keyset STATIC csv constructor
        public KeySet(String _url, String _path, String _filename_extension, String _key_filename, int _numKeyWords, String _delimiter, String _url_dir_slash, String _url_filename_space, boolean _flatlinks, int _keyprocmeth, String _urlLink, boolean _switchlinks) {
            flatlinks = _flatlinks;
            cols = _numKeyWords;
            url = _url;
            path = _path;
            filename_extension = _filename_extension;
            key_filename = _key_filename;
            delimiter = _delimiter;
            url_filename_space = _url_filename_space;
            url_dir_slash = _url_dir_slash;
            keyProcessingMethod = _keyprocmeth;
            urlLink = _urlLink;
            switchlinks = _switchlinks;
            try {



                Pattern space_pattern = Pattern.compile("[\\p{Space}]+[\\s]*");
                Matcher space_matcher = space_pattern.matcher(" ");

                int i, j;
                CSVReader reader = new CSVReader(new FileReader(key_filename), delimiter.charAt(0), (char) 34, 0);
                String[] nextLine;

                rows = 0;
                while ((nextLine = reader.readNext()) != null) {

                    space_matcher.reset(nextLine[0]);
                    if (space_matcher.matches()) {
                    //blank 
                    } else {
                        rows++;
                    }


                }

                keys = new String[rows][cols];
                reader.close();
                reader = new CSVReader(new FileReader(key_filename), delimiter.charAt(0), (char) 34, 0);
                i = 0;
                while ((nextLine = reader.readNext()) != null) {

                    space_matcher.reset(nextLine[0]);
                    if (space_matcher.matches()) {
                    //blank 
                    } else {
                        j = 0;
                        while (j < cols && j < Array.getLength(nextLine)) {
                            keys[i][j] = new String(nextLine[j]);
                            j++;
                        }
                        j = 0;
                        while (j < cols) {
                            if (keys[i][j] == null) {
                                keys[i][j] = "";
                            }
                            keys[i][j] = processRawKey(keys[i][j], keyProcessingMethod);
                            j++;
                        }
                        i++;
                    }


                }

                reader.close();
                link_order = new String[rows];
                links = new String[rows];
                i = 0;
                while (i < rows) {
                    link_order[i] = (" " + i + " ").trim();
                    if (flatlinks) {
                        links[i] = key2FlatLink(keys[i], filename_extension, url_dir_slash, url_filename_space, old_path, "csv", switchlinks);
                    } else {
                        links[i] = key2Link(keys[i], filename_extension, url_dir_slash, url_filename_space, old_path, "csv", switchlinks);
                    }
                    i++;
                }






            } catch (Exception e) {
                System.out.println("something went wrong in keyset() " + e);
            }


        }// end of keyset csv constructor
        public KeySet(String _url, String _path, String _filename_extension, String _key_filename, int _numKeyWords, String _delimiter, String _url_dir_slash, String _url_filename_space, boolean _flatlinks, int _keyprocmeth, String _input_type, boolean _useProxy, String _proxyHost, String _proxyPort, int _websiteConfigID, String _urlLink, boolean _switchlinks) {
            flatlinks = _flatlinks;
            switchlinks = _switchlinks;
            cols = _numKeyWords;
            url = _url;
            path = _path;
            filename_extension = _filename_extension;
            key_filename = _key_filename;
            delimiter = _delimiter;
            url_filename_space = _url_filename_space;
            url_dir_slash = _url_dir_slash;
            keyProcessingMethod = _keyprocmeth;
            input_type = _input_type;
            useProxy = _useProxy;
            proxyHost = _proxyHost;
            proxyPort = _proxyPort;
            websiteConfigID = _websiteConfigID;
            urlLink = _urlLink;

            try {

                query = null;

                BufferedReader in = new BufferedReader(new FileReader(key_filename));
                String query_type = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                in.close();
                if (query_type.compareToIgnoreCase("query_type=event") == 0) {
                    Properties query_defaults = new Properties();
                    query_defaults.load(new FileInputStream("event_query_defaults.ini"));
                    query = new Properties(query_defaults);
                    query.load(new FileInputStream(key_filename));


                } else if (query_type.compareToIgnoreCase("query_type=venue") == 0) {
                    Properties query_defaults = new Properties();
                    query_defaults.load(new FileInputStream("venue_query_defaults.ini"));
                    query = new Properties(query_defaults);
                    query.load(new FileInputStream(key_filename));

                } else if (query_type.compareToIgnoreCase("query_type=performer") == 0) {
                    Properties query_defaults = new Properties();
                    query_defaults.load(new FileInputStream("performer_query_defaults.ini"));
                    query = new Properties(query_defaults);
                    query.load(new FileInputStream(key_filename));

                } else {
                    System.out.println("Invaild Query Type: " + query_type);
                    rows = 0;
                    cols = 0;
                    return;

                }
                query_type = query.getProperty("query_type");
                keys = getQueryData(query, url, urlLink, keyProcessingMethod, url_filename_space);


                if (keys == null) {
                    rows = 0;
                    cols = 0;
                    System.out.println("No data returned in keyset.");
                    return;
                }
                rows = keys.length;
                if (rows == 0) {
                    cols = 0;
                    System.out.println("No data returned in keyset.");
                    return;
                }
                cols = (keys[0]).length;
                if (cols == 0) {
                    System.out.println("" + rows + " Empty keys returned in keyset.");
                    rows = 0;
                    return;

                }

                link_order = new String[rows];
                links = new String[rows];
                int i = 0;
                while (i < rows) {
                    link_order[i] = (" " + i + " ").trim();
                    if (flatlinks) {

                        links[i] = key2FlatLink(keys[i], filename_extension, url_dir_slash, url_filename_space, old_path, query_type, switchlinks);
                    } else {
                        links[i] = key2Link(keys[i], filename_extension, url_dir_slash, url_filename_space, old_path, query_type, switchlinks);
                    }
                    i++;
                }



            } catch (Exception e) {
                System.out.println("something went wrong in keyset() " + e);
            }


        }// end of keyset soap constructor
        public String[] getRandomLinks(int num_links) {

            int n = num_links;
            Collections.shuffle(Arrays.asList(link_order));
            if (n <= 0 || n > rows) {
                n = rows;
            }
            String[] array = new String[n];
            int i = 0;
            while (i < n) {
                array[i] = new String(links[Integer.parseInt(link_order[i], 10)]);
                i++;
            }
            return array;
        }

        public String[] getAlphaRandomLinks(int num_links) {

            int n = num_links;
            Collections.shuffle(Arrays.asList(link_order));
            if (n <= 0 || n > rows) {
                n = rows;
            }
            String[] array = new String[n];
            int i = 0;
            while (i < n) {
                array[i] = new String(links[Integer.parseInt(link_order[i], 10)]);
                i++;
            }

            Collections.sort(Arrays.asList(array), String.CASE_INSENSITIVE_ORDER);
            return array;
        }

        public String getLinksString(int num_links) {

            String linkString = "<ul> ";
            String[] link = getRandomLinks(num_links);
            for (String s : link) {
                linkString = linkString + "<li>" + s + "</li>";
            }
            linkString = linkString + "</ul>";
            return linkString;

        }

        public String getAlphaLinksString(int num_links) {

            String linkString = "<ul> ";
            String[] link = getAlphaRandomLinks(num_links);
            for (String s : link) {
                linkString = linkString + "<li>" + s + "</li>";
            }
            linkString = linkString + "</ul>";
            return linkString;

        }

        public String getFootLinksString(int num_links) {

            String linkString = "";
            String[] link = getRandomLinks(num_links);
            int i = 0;
            for (String s : link) {
                if (i == 0) {
                    linkString = linkString + "&nbsp;" + s;
                } else {
                    linkString = linkString + "&nbsp;" + "| " + s;
                }
                i++;
            }
            return linkString;

        }

        public String getAlphaFootLinksString(int num_links) {

            String linkString = "";
            String[] link = getAlphaRandomLinks(num_links);
            int i = 0;
            for (String s : link) {
                if (i == 0) {
                    linkString = linkString + "&nbsp;" + s;
                } else {
                    linkString = linkString + "&nbsp;" + "| " + s;
                }
                i++;
            }
            return linkString;

        }

        public String getHeadLinksString(int num_links) {

            String linkString = "";
            String[] link = getRandomLinks(num_links);
            int i = 0;
            for (String s : link) {
                if (i == 0) {
                    linkString = linkString + "&nbsp;" + s;
                } else {
                    linkString = linkString + "&nbsp;" + "| " + s;
                }
                i++;
            }
            return linkString;

        }

        public String getMTLinksString(int num_links) {

            String linkString = "";
            String[] link = getRandomLinks(num_links);
            for (String s : link) {
                linkString = linkString + "<li>" + s;
            }
            return linkString;

        }

        public String getMTFootLinksString(int num_links) {

            String linkString = "";
            String[] link = getRandomLinks(num_links);
            for (String s : link) {
                linkString = linkString + "&nbsp;" + s;
            }
            return linkString;

        }

        public String getMTHeadLinksString(int num_links) {

            String linkString = "";
            String[] link = getRandomLinks(num_links);
            for (String s : link) {
                linkString = linkString + "&nbsp;" + s;
            }
            return linkString;

        }

        public String getAlphaHeadLinksString(int num_links) {

            String linkString = "";
            String[] link = getAlphaRandomLinks(num_links);
            int i = 0;
            for (String s : link) {
                if (i == 0) {
                    linkString = linkString + "&nbsp;" + s;
                } else {
                    linkString = linkString + "&nbsp;" + "| " + s;
                }
                i++;
            }
            return linkString;

        }

        public String getAlphaMTLinksString(int num_links) {

            String linkString = "";
            String[] link = getAlphaRandomLinks(num_links);
            for (String s : link) {
                linkString = linkString + "<li>" + s;
            }
            return linkString;

        }

        public String getAlphaMTFootLinksString(int num_links) {

            String linkString = "";
            String[] link = getAlphaRandomLinks(num_links);
            for (String s : link) {
                linkString = linkString + "&nbsp;" + s;
            }
            return linkString;

        }

        public String getAlphaMTHeadLinksString(int num_links) {

            String linkString = "";
            String[] link = getAlphaRandomLinks(num_links);
            for (String s : link) {
                linkString = linkString + "&nbsp;" + s;
            }
            return linkString;

        }

        public int numKeys() {
            return rows;
        }

        public int numKeyWords() {
            return cols;
        }
    } //end of KeySet class

    static String file2String(String filename) {

        try {
            StringBuffer data = new StringBuffer(1000);
            BufferedReader reader = new BufferedReader(
                    new FileReader(filename));
            char[] buf = new char[1024];
            int numRead = 0;
            while ((numRead = reader.read(buf)) != -1) {
                String readData = String.valueOf(buf, 0, numRead);
                data.append(readData);
                buf =
                        new char[1024];
            }

            reader.close();
            return data.toString();
        } catch (Exception e) {
            System.out.println("something went wrong in file2string " + e);
        }

        return "";
    } //end of file2string

    static boolean string2File(String data, String filename) {


        try {

            FileWriter output = new FileWriter(filename);
            output.write(data);
            output.close();
            return true;


        } catch (IOException e) {

            System.out.println("something went wrong in string2file " + e);
        }

        return false;


    }//end of string2file
    public static String[] createRandomArray(String[] a) {


        String[] array = a.clone();
        Collections.shuffle(Arrays.asList(array));
        return array;



    }//end of createrandomarray	
    public static String processLinks(String data, KeySet ks) {

        String copy_of_data = new String(data);
        String linkString = "";
        String pattern = "(?i)\\{[\\p{Blank}]*LINKS[\\p{Blank}]*\\}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(copy_of_data);
        if (m.find()) {
            linkString = ks.getLinksString(0);
            copy_of_data =
                    m.replaceAll(fixSlash(linkString));
        }

        String pattern_with_numbers = "(?i)\\{[\\p{Blank}]*[0-9]+[\\p{Blank}]*LINKS[\\p{Blank}]*\\}";
        Pattern pattern2 = Pattern.compile(pattern_with_numbers);
        Matcher m2 = pattern2.matcher(copy_of_data);
        while (m2.find()) {
            String matching_group = m2.group();
            String numberpat = "[0-9]+";
            Pattern number_pattern = Pattern.compile(numberpat);
            Matcher number_matcher = number_pattern.matcher(matching_group);
            //move forward to the first instance of a number, there better be one!
            number_matcher.find();
            String num = (number_matcher.group()).trim();
            int n = Integer.valueOf(num).intValue();
            String npattern = "(?i)\\{[\\p{Blank}]*" + n + "[\\p{Blank}]*LINKS[\\p{Blank}]*\\}";
            Pattern final_replacement_pattern = Pattern.compile(npattern);
            Matcher n_matcher = final_replacement_pattern.matcher(copy_of_data);
            if (n < 0) {
                copy_of_data = n_matcher.replaceAll(fixSlash(linkString));
            } else {
                String nLinksString = new String(ks.getLinksString(n));
                copy_of_data =
                        n_matcher.replaceAll(fixSlash(nLinksString));
            }

            m2.reset(copy_of_data);
        }

        return copy_of_data;


    }

    public static String processAlphaLinks(String data, KeySet ks) {

        String copy_of_data = new String(data);
        String linkString = "";
        String pattern = "(?i)\\{[\\p{Blank}]*ALPHALINKS[\\p{Blank}]*\\}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(copy_of_data);
        if (m.find()) {
            linkString = ks.getAlphaLinksString(0);
            copy_of_data =
                    m.replaceAll(fixSlash(linkString));
        }

        String pattern_with_numbers = "(?i)\\{[\\p{Blank}]*[0-9]+[\\p{Blank}]*ALPHALINKS[\\p{Blank}]*\\}";
        Pattern pattern2 = Pattern.compile(pattern_with_numbers);
        Matcher m2 = pattern2.matcher(copy_of_data);
        while (m2.find()) {
            String matching_group = m2.group();
            String numberpat = "[0-9]+";
            Pattern number_pattern = Pattern.compile(numberpat);
            Matcher number_matcher = number_pattern.matcher(matching_group);
            //move forward to the first instance of a number, there better be one!
            number_matcher.find();
            String num = (number_matcher.group()).trim();
            int n = Integer.valueOf(num).intValue();
            String npattern = "(?i)\\{[\\p{Blank}]*" + n + "[\\p{Blank}]*ALPHALINKS[\\p{Blank}]*\\}";
            Pattern final_replacement_pattern = Pattern.compile(npattern);
            Matcher n_matcher = final_replacement_pattern.matcher(copy_of_data);
            if (n < 0) {
                copy_of_data = n_matcher.replaceAll(fixSlash(linkString));
            } else {
                String nLinksString = new String(ks.getAlphaLinksString(n));
                copy_of_data =
                        n_matcher.replaceAll(fixSlash(nLinksString));
            }

            m2.reset(copy_of_data);
        }

        return copy_of_data;


    }

    public static String processFootLinks(String data, KeySet ks) {



        String copy_of_data = new String(data);
        String linkString = "";
        String pattern = "(?i)\\{[\\p{Blank}]*FOOTLINKS[\\p{Blank}]*\\}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(copy_of_data);
        if (m.find()) {
            linkString = ks.getFootLinksString(0);
            copy_of_data =
                    m.replaceAll(fixSlash(linkString));
        }

        String pattern_with_numbers = "(?i)\\{[\\p{Blank}]*[0-9]+[\\p{Blank}]*FOOTLINKS[\\p{Blank}]*\\}";
        Pattern pattern2 = Pattern.compile(pattern_with_numbers);
        Matcher m2 = pattern2.matcher(copy_of_data);
        while (m2.find()) {
            String matching_group = m2.group();
            String numberpat = "[0-9]+";
            Pattern number_pattern = Pattern.compile(numberpat);
            Matcher number_matcher = number_pattern.matcher(matching_group);
            //move forward to the first instance of a number, there better be one!
            number_matcher.find();
            String num = (number_matcher.group()).trim();
            int n = Integer.valueOf(num).intValue();
            String npattern = "(?i)\\{[\\p{Blank}]*" + n + "[\\p{Blank}]*FOOTLINKS[\\p{Blank}]*\\}";
            Pattern final_replacement_pattern = Pattern.compile(npattern);
            Matcher n_matcher = final_replacement_pattern.matcher(copy_of_data);
            if (n < 0) {
                copy_of_data = n_matcher.replaceAll(fixSlash(linkString));
            } else {
                String nLinksString = new String(ks.getFootLinksString(n));
                copy_of_data =
                        n_matcher.replaceAll(fixSlash(nLinksString));
            }

            m2.reset(copy_of_data);
        }

        return copy_of_data;

    }

    public static String processHeadLinks(String data, KeySet ks) {

        String copy_of_data = new String(data);
        String linkString = "";
        String pattern = "(?i)\\{[\\p{Blank}]*HEADLINKS[\\p{Blank}]*\\}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(copy_of_data);
        if (m.find()) {
            linkString = ks.getHeadLinksString(0);
            copy_of_data =
                    m.replaceAll(fixSlash(linkString));
        }

        String pattern_with_numbers = "(?i)\\{[\\p{Blank}]*[0-9]+[\\p{Blank}]*HEADLINKS[\\p{Blank}]*\\}";
        Pattern pattern2 = Pattern.compile(pattern_with_numbers);
        Matcher m2 = pattern2.matcher(copy_of_data);
        while (m2.find()) {
            String matching_group = m2.group();
            String numberpat = "[0-9]+";
            Pattern number_pattern = Pattern.compile(numberpat);
            Matcher number_matcher = number_pattern.matcher(matching_group);
            //move forward to the first instance of a number, there better be one!
            number_matcher.find();
            String num = (number_matcher.group()).trim();
            int n = Integer.valueOf(num).intValue();
            String npattern = "(?i)\\{[\\p{Blank}]*" + n + "[\\p{Blank}]*HEADLINKS[\\p{Blank}]*\\}";
            Pattern final_replacement_pattern = Pattern.compile(npattern);
            Matcher n_matcher = final_replacement_pattern.matcher(copy_of_data);
            if (n < 0) {
                copy_of_data = n_matcher.replaceAll(fixSlash(linkString));
            } else {
                String nLinksString = new String(ks.getHeadLinksString(n));
                copy_of_data =
                        n_matcher.replaceAll(fixSlash(nLinksString));
            }

            m2.reset(copy_of_data);
        }

        return copy_of_data;

    }

    public static String processMTLinks(String data, KeySet ks) {

        String copy_of_data = new String(data);
        String linkString = "";
        String pattern = "(?i)\\{[\\p{Blank}]*MTLINKS[\\p{Blank}]*\\}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(copy_of_data);
        if (m.find()) {
            linkString = ks.getMTLinksString(0);
            copy_of_data =
                    m.replaceAll(fixSlash(linkString));
        }

        String pattern_with_numbers = "(?i)\\{[\\p{Blank}]*[0-9]+[\\p{Blank}]*MTLINKS[\\p{Blank}]*\\}";
        Pattern pattern2 = Pattern.compile(pattern_with_numbers);
        Matcher m2 = pattern2.matcher(copy_of_data);
        while (m2.find()) {
            String matching_group = m2.group();
            String numberpat = "[0-9]+";
            Pattern number_pattern = Pattern.compile(numberpat);
            Matcher number_matcher = number_pattern.matcher(matching_group);
            //move forward to the first instance of a number, there better be one!
            number_matcher.find();
            String num = (number_matcher.group()).trim();
            int n = Integer.valueOf(num).intValue();
            String npattern = "(?i)\\{[\\p{Blank}]*" + n + "[\\p{Blank}]*MTLINKS[\\p{Blank}]*\\}";
            Pattern final_replacement_pattern = Pattern.compile(npattern);
            Matcher n_matcher = final_replacement_pattern.matcher(copy_of_data);
            if (n < 0) {
                copy_of_data = n_matcher.replaceAll(fixSlash(linkString));
            } else {
                String nLinksString = new String(ks.getMTLinksString(n));
                copy_of_data =
                        n_matcher.replaceAll(fixSlash(nLinksString));
            }

            m2.reset(copy_of_data);
        }

        return copy_of_data;

    }

    public static String processMTFootLinks(String data, KeySet ks) {
        String copy_of_data = new String(data);
        String linkString = "";
        String pattern = "(?i)\\{[\\p{Blank}]*MTFOOTLINKS[\\p{Blank}]*\\}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(copy_of_data);
        if (m.find()) {
            linkString = ks.getMTFootLinksString(0);
            copy_of_data =
                    m.replaceAll(fixSlash(linkString));
        }

        String pattern_with_numbers = "(?i)\\{[\\p{Blank}]*[0-9]+[\\p{Blank}]*MTFOOTLINKS[\\p{Blank}]*\\}";
        Pattern pattern2 = Pattern.compile(pattern_with_numbers);
        Matcher m2 = pattern2.matcher(copy_of_data);
        while (m2.find()) {
            String matching_group = m2.group();
            String numberpat = "[0-9]+";
            Pattern number_pattern = Pattern.compile(numberpat);
            Matcher number_matcher = number_pattern.matcher(matching_group);
            //move forward to the first instance of a number, there better be one!
            number_matcher.find();
            String num = (number_matcher.group()).trim();
            int n = Integer.valueOf(num).intValue();
            String npattern = "(?i)\\{[\\p{Blank}]*" + n + "[\\p{Blank}]*MTFOOTLINKS[\\p{Blank}]*\\}";
            Pattern final_replacement_pattern = Pattern.compile(npattern);
            Matcher n_matcher = final_replacement_pattern.matcher(copy_of_data);
            if (n < 0) {
                copy_of_data = n_matcher.replaceAll(fixSlash(linkString));
            } else {
                String nLinksString = new String(ks.getMTFootLinksString(n));
                copy_of_data =
                        n_matcher.replaceAll(fixSlash(nLinksString));
            }

            m2.reset(copy_of_data);
        }

        return copy_of_data;

    }

    public static String processMTHeadLinks(String data, KeySet ks) {

        String copy_of_data = new String(data);
        String linkString = "";
        String pattern = "(?i)\\{[\\p{Blank}]*MTHEADLINKS[\\p{Blank}]*\\}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(copy_of_data);
        if (m.find()) {
            linkString = ks.getMTHeadLinksString(0);
            copy_of_data =
                    m.replaceAll(fixSlash(linkString));
        }

        String pattern_with_numbers = "(?i)\\{[\\p{Blank}]*[0-9]+[\\p{Blank}]*MTHEADLINKS[\\p{Blank}]*\\}";
        Pattern pattern2 = Pattern.compile(pattern_with_numbers);
        Matcher m2 = pattern2.matcher(copy_of_data);
        while (m2.find()) {
            String matching_group = m2.group();
            String numberpat = "[0-9]+";
            Pattern number_pattern = Pattern.compile(numberpat);
            Matcher number_matcher = number_pattern.matcher(matching_group);
            //move forward to the first instance of a number, there better be one!
            number_matcher.find();
            String num = (number_matcher.group()).trim();
            int n = Integer.valueOf(num).intValue();
            String npattern = "(?i)\\{[\\p{Blank}]*" + n + "[\\p{Blank}]*MTHEADLINKS[\\p{Blank}]*\\}";
            Pattern final_replacement_pattern = Pattern.compile(npattern);
            Matcher n_matcher = final_replacement_pattern.matcher(copy_of_data);
            if (n < 0) {
                copy_of_data = n_matcher.replaceAll(fixSlash(linkString));
            } else {
                String nLinksString = new String(ks.getMTHeadLinksString(n));
                copy_of_data =
                        n_matcher.replaceAll(fixSlash(nLinksString));
            }

            m2.reset(copy_of_data);
        }

        return copy_of_data;

    }

    public static String processAlphaFootLinks(String data, KeySet ks) {



        String copy_of_data = new String(data);
        String linkString = "";
        String pattern = "(?i)\\{[\\p{Blank}]*ALPHAFOOTLINKS[\\p{Blank}]*\\}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(copy_of_data);
        if (m.find()) {
            linkString = ks.getAlphaFootLinksString(0);
            copy_of_data =
                    m.replaceAll(fixSlash(linkString));
        }

        String pattern_with_numbers = "(?i)\\{[\\p{Blank}]*[0-9]+[\\p{Blank}]*ALPHAFOOTLINKS[\\p{Blank}]*\\}";
        Pattern pattern2 = Pattern.compile(pattern_with_numbers);
        Matcher m2 = pattern2.matcher(copy_of_data);
        while (m2.find()) {
            String matching_group = m2.group();
            String numberpat = "[0-9]+";
            Pattern number_pattern = Pattern.compile(numberpat);
            Matcher number_matcher = number_pattern.matcher(matching_group);
            //move forward to the first instance of a number, there better be one!
            number_matcher.find();
            String num = (number_matcher.group()).trim();
            int n = Integer.valueOf(num).intValue();
            String npattern = "(?i)\\{[\\p{Blank}]*" + n + "[\\p{Blank}]*ALPHAFOOTLINKS[\\p{Blank}]*\\}";
            Pattern final_replacement_pattern = Pattern.compile(npattern);
            Matcher n_matcher = final_replacement_pattern.matcher(copy_of_data);
            if (n < 0) {
                copy_of_data = n_matcher.replaceAll(fixSlash(linkString));
            } else {
                String nLinksString = new String(ks.getAlphaFootLinksString(n));
                copy_of_data =
                        n_matcher.replaceAll(fixSlash(nLinksString));
            }

            m2.reset(copy_of_data);
        }

        return copy_of_data;

    }

    public static String processAlphaHeadLinks(String data, KeySet ks) {

        String copy_of_data = new String(data);
        String linkString = "";
        String pattern = "(?i)\\{[\\p{Blank}]*ALPHAHEADLINKS[\\p{Blank}]*\\}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(copy_of_data);
        if (m.find()) {
            linkString = ks.getAlphaHeadLinksString(0);
            copy_of_data =
                    m.replaceAll(fixSlash(linkString));
        }

        String pattern_with_numbers = "(?i)\\{[\\p{Blank}]*[0-9]+[\\p{Blank}]*ALPHAHEADLINKS[\\p{Blank}]*\\}";
        Pattern pattern2 = Pattern.compile(pattern_with_numbers);
        Matcher m2 = pattern2.matcher(copy_of_data);
        while (m2.find()) {
            String matching_group = m2.group();
            String numberpat = "[0-9]+";
            Pattern number_pattern = Pattern.compile(numberpat);
            Matcher number_matcher = number_pattern.matcher(matching_group);
            //move forward to the first instance of a number, there better be one!
            number_matcher.find();
            String num = (number_matcher.group()).trim();
            int n = Integer.valueOf(num).intValue();
            String npattern = "(?i)\\{[\\p{Blank}]*" + n + "[\\p{Blank}]*ALPHAHEADLINKS[\\p{Blank}]*\\}";
            Pattern final_replacement_pattern = Pattern.compile(npattern);
            Matcher n_matcher = final_replacement_pattern.matcher(copy_of_data);
            if (n < 0) {
                copy_of_data = n_matcher.replaceAll(fixSlash(linkString));
            } else {
                String nLinksString = new String(ks.getAlphaHeadLinksString(n));
                copy_of_data =
                        n_matcher.replaceAll(fixSlash(nLinksString));
            }

            m2.reset(copy_of_data);
        }

        return copy_of_data;

    }

    public static String processAlphaMTLinks(String data, KeySet ks) {

        String copy_of_data = new String(data);
        String linkString = "";
        String pattern = "(?i)\\{[\\p{Blank}]*ALPHAMTLINKS[\\p{Blank}]*\\}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(copy_of_data);
        if (m.find()) {
            linkString = ks.getAlphaMTLinksString(0);
            copy_of_data =
                    m.replaceAll(fixSlash(linkString));
        }

        String pattern_with_numbers = "(?i)\\{[\\p{Blank}]*[0-9]+[\\p{Blank}]*ALPHAMTLINKS[\\p{Blank}]*\\}";
        Pattern pattern2 = Pattern.compile(pattern_with_numbers);
        Matcher m2 = pattern2.matcher(copy_of_data);
        while (m2.find()) {
            String matching_group = m2.group();
            String numberpat = "[0-9]+";
            Pattern number_pattern = Pattern.compile(numberpat);
            Matcher number_matcher = number_pattern.matcher(matching_group);
            //move forward to the first instance of a number, there better be one!
            number_matcher.find();
            String num = (number_matcher.group()).trim();
            int n = Integer.valueOf(num).intValue();
            String npattern = "(?i)\\{[\\p{Blank}]*" + n + "[\\p{Blank}]*ALPHAMTLINKS[\\p{Blank}]*\\}";
            Pattern final_replacement_pattern = Pattern.compile(npattern);
            Matcher n_matcher = final_replacement_pattern.matcher(copy_of_data);
            if (n < 0) {
                copy_of_data = n_matcher.replaceAll(fixSlash(linkString));
            } else {
                String nLinksString = new String(ks.getAlphaMTLinksString(n));
                copy_of_data =
                        n_matcher.replaceAll(fixSlash(nLinksString));
            }

            m2.reset(copy_of_data);
        }

        return copy_of_data;

    }

    public static String processAlphaMTFootLinks(String data, KeySet ks) {
        String copy_of_data = new String(data);
        String linkString = "";
        String pattern = "(?i)\\{[\\p{Blank}]*ALPHAMTFOOTLINKS[\\p{Blank}]*\\}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(copy_of_data);
        if (m.find()) {
            linkString = ks.getAlphaMTFootLinksString(0);
            copy_of_data =
                    m.replaceAll(fixSlash(linkString));
        }

        String pattern_with_numbers = "(?i)\\{[\\p{Blank}]*[0-9]+[\\p{Blank}]*ALPHAMTFOOTLINKS[\\p{Blank}]*\\}";
        Pattern pattern2 = Pattern.compile(pattern_with_numbers);
        Matcher m2 = pattern2.matcher(copy_of_data);
        while (m2.find()) {
            String matching_group = m2.group();
            String numberpat = "[0-9]+";
            Pattern number_pattern = Pattern.compile(numberpat);
            Matcher number_matcher = number_pattern.matcher(matching_group);
            //move forward to the first instance of a number, there better be one!
            number_matcher.find();
            String num = (number_matcher.group()).trim();
            int n = Integer.valueOf(num).intValue();
            String npattern = "(?i)\\{[\\p{Blank}]*" + n + "[\\p{Blank}]*ALPHAMTFOOTLINKS[\\p{Blank}]*\\}";
            Pattern final_replacement_pattern = Pattern.compile(npattern);
            Matcher n_matcher = final_replacement_pattern.matcher(copy_of_data);
            if (n < 0) {
                copy_of_data = n_matcher.replaceAll(fixSlash(linkString));
            } else {
                String nLinksString = new String(ks.getAlphaMTFootLinksString(n));
                copy_of_data =
                        n_matcher.replaceAll(fixSlash(nLinksString));
            }

            m2.reset(copy_of_data);
        }

        return copy_of_data;

    }

    public static String processAlphaMTHeadLinks(String data, KeySet ks) {

        String copy_of_data = new String(data);
        String linkString = "";
        String pattern = "(?i)\\{[\\p{Blank}]*ALPHAMTHEADLINKS[\\p{Blank}]*\\}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(copy_of_data);
        if (m.find()) {
            linkString = ks.getAlphaMTHeadLinksString(0);
            copy_of_data =
                    m.replaceAll(fixSlash(linkString));
        }

        String pattern_with_numbers = "(?i)\\{[\\p{Blank}]*[0-9]+[\\p{Blank}]*ALPHAMTHEADLINKS[\\p{Blank}]*\\}";
        Pattern pattern2 = Pattern.compile(pattern_with_numbers);
        Matcher m2 = pattern2.matcher(copy_of_data);
        while (m2.find()) {
            String matching_group = m2.group();
            String numberpat = "[0-9]+";
            Pattern number_pattern = Pattern.compile(numberpat);
            Matcher number_matcher = number_pattern.matcher(matching_group);
            //move forward to the first instance of a number, there better be one!
            number_matcher.find();
            String num = (number_matcher.group()).trim();
            int n = Integer.valueOf(num).intValue();
            String npattern = "(?i)\\{[\\p{Blank}]*" + n + "[\\p{Blank}]*ALPHAMTHEADLINKS[\\p{Blank}]*\\}";
            Pattern final_replacement_pattern = Pattern.compile(npattern);
            Matcher n_matcher = final_replacement_pattern.matcher(copy_of_data);
            if (n < 0) {
                copy_of_data = n_matcher.replaceAll(fixSlash(linkString));
            } else {
                String nLinksString = new String(ks.getAlphaMTHeadLinksString(n));
                copy_of_data =
                        n_matcher.replaceAll(fixSlash(nLinksString));
            }

            m2.reset(copy_of_data);
        }

        return copy_of_data;

    }

    public static String processGenericKeywordPattern(String pat, String data, String replacement_data) {
        try {
            String out = new String(data);
            String pattern = "(?i)\\{[\\p{Blank}]*" + pat + "[\\p{Blank}]*\\}";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(out);
            return m.replaceAll(fixSlash(replacement_data));
        } catch (Exception e) {
            System.out.println("Error while processing geneic keyword: " + pat + " Replacement key: " + replacement_data + " Exception thrown: " + e);
            return data;
        }

    }

    public static String processUrl(String data, KeySet ks) {


        String pattern = "(?i)\\{[\\p{Blank}]*URL[\\p{Blank}]*\\}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(data);
        return m.replaceAll(fixSlash(ks.url));

    }

    public static String processPath(String data, KeySet ks) {


        String pattern = "(?i)\\{[\\p{Blank}]*PATH[\\p{Blank}]*\\}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(data);
        return m.replaceAll(ks.path);

    }

    public static String processKeys(String data, KeySet ks, int i) {

        String out = new String(data);
        int j = ks.numKeyWords() - 1;
        while (j >= 0) {
            String pattern;
            if (j != 0) {
                pattern = "(?i)\\{[\\p{Blank}]*KEYWORD" + j + "[\\p{Blank}]*\\}";
            } else {
                pattern = "(?i)\\{[\\p{Blank}]*KEYWORD[\\p{Blank}]*\\}";
            }

            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(out);

            try {

                //out = m.replaceAll(ks.keys[i][j]);
                //had to "fix" the slash problem
                out = m.replaceAll(fixSlash(ks.keys[i][j]));

            } catch (Exception e) {
                System.out.println("Error while processing keyword: " + ks.keys[i][j] + " Exception thrown: " + e);
            }

            j--;
        }

        return out;
    }

    public static String processStateAbbrvKey(String data, KeySet ks, int i) {

        String out = new String(data);

        String pattern = "(?i)\\{[\\p{Blank}]*STATE2[\\p{Blank}]*\\}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(out);
        try {
            //out = m.replaceAll(ks.keys[i][j]);
            //had to "fix" the slash problem
            String state = ks.keys[i][3];
            Properties reverse_string_mappings = new Properties();
            reverse_string_mappings.load(new FileInputStream("reverse_string_mappings.ini"));
            state = replaceStringOrKeepSame(reverse_string_mappings, state);
            out = m.replaceAll(fixSlash(state));

        } catch (Exception e) {
            System.out.println("Error while processing State Abbrv on Key " + i + " for state: " + ks.keys[i][3] + "  Exception thrown: " + e);
        }



        return out;
    }

    public static String processKeys(String data, KeySet ks, int i, Properties query) {

        String out = new String(data);
        int j = ks.numKeyWords() - 1;
        while (j >= 0) {
            String pattern;
            String keyword = "";
            if (j == 0) {
                keyword = query.getProperty("keyword");
            } else {
                keyword = query.getProperty("keyword" + j);
            }

            pattern = "(?i)\\{[\\p{Blank}]*" + keyword + "[\\p{Blank}]*\\}";

            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(out);

            try {

                //out = m.replaceAll(ks.keys[i][j]);
                //had to "fix" the slash problem
                out = m.replaceAll(fixSlash(ks.keys[i][j]));

            } catch (Exception e) {
                System.out.println("Error while processing mapped keyword: " + ks.keys[i][j] + " Exception thrown: " + e);
            }

            j--;
        }

        return out;
    }

    public static String processStaticKeys(String data, KeySet static_ks) {
        int k = 0;
        String out = new String(data);
        int i = static_ks.numKeys() - 1;
        int j = static_ks.numKeyWords() - 1;
        while (i >= 0) {

            j = static_ks.numKeyWords() - 1;
            while (j >= 1) {
                String pattern;
                k =
                        j - 1;
                if (k != 0) {
                    pattern = "(?i)\\{[\\p{Blank}]*" + static_ks.keys[i][0] + "[\\p{Blank}]*" + k + "[\\p{Blank}]*\\}";
                } else {
                    pattern = "(?i)\\{[\\p{Blank}]*" + static_ks.keys[i][0] + "[\\p{Blank}]*\\}";
                }

                Pattern r = Pattern.compile(pattern);
                Matcher m = r.matcher(out);

                try {

                    //out = m.replaceAll(ks.keys[i][j]);
                    //had to "fix" the slash problem
                    out = m.replaceAll(fixSlash(static_ks.keys[i][j]));

                } catch (Exception e) {
                    System.out.println("Error while processing keyword: " + static_ks.keys[i][j] + " Exception thrown: " + e);
                }

                j--;
            }

            i--;
        }

        return out;
    }

    public static String processCapsKeys(String data, KeySet ks, int i) {

        String out = new String(data);
        int j = ks.numKeyWords() - 1;
        while (j >= 0) {
            String pattern;
            if (j != 0) {
                pattern = "(?i)\\{[\\p{Blank}]*KEYWORD" + j + "CAPS[\\p{Blank}]*\\}";
            } else {
                pattern = "(?i)\\{[\\p{Blank}]*KEYWORDCAPS[\\p{Blank}]*\\}";
            }

            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(out);
            out =
                    m.replaceAll(((ks.keys[i][j])).toUpperCase());
            j--;

        }


        return out;
    }

    public static String processLowerKeys(String data, KeySet ks, int i) {

        String out = new String(data);
        int j = ks.numKeyWords() - 1;
        while (j >= 0) {
            String pattern;
            if (j != 0) {
                pattern = "(?i)\\{[\\p{Blank}]*KEYWORD" + j + "LOWER[\\p{Blank}]*\\}";
            } else {
                pattern = "(?i)\\{[\\p{Blank}]*KEYWORDLOWER[\\p{Blank}]*\\}";
            }

            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(out);
            out =
                    m.replaceAll((ks.keys[i][j]).toLowerCase());
            j--;

        }


        return out;
    }

    public static String processPuncKeys(String data, KeySet ks, int i) {

        String out = new String(data);
        int j = ks.numKeyWords() - 1;
        while (j >= 0) {
            String pattern;
            if (j != 0) {
                pattern = "(?i)\\{[\\p{Blank}]*KEYWORD" + j + "PUNC[\\p{Blank}]*\\}";
            } else {
                pattern = "(?i)\\{[\\p{Blank}]*KEYWORDPUNC[\\p{Blank}]*\\}";
            }

            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(out);
            String replacement = new String((ks.keys[i][j]));

            if (replacement.length() > 0) {
                replacement = replacement.toLowerCase();
                out =
                        m.replaceAll((replacement.substring(0, 1)).toUpperCase() + replacement.substring(1, replacement.length()));
            } else {
                out = m.replaceAll((ks.keys[i][j]).toUpperCase());
            }

            j--;
        }

        return out;
    }

    public static String processSynonyms(String data) {
        /*
        process syn handles strings of the form { a | b | c}
        it randomizes which of a,b,c replaces the string.
         */
        String copy_of_data = new String(data);
        String pattern = "(?i)\\{\\{[[^\\|\\}\\{]+\\|\\|]+[^\\}\\|\\{]*\\}\\}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(data);
        while (m.find()) {
            String matching_group = m.group();
            String pipe_delim_set = matching_group.substring(2, matching_group.length() - 2);
            StringTokenizer st = new StringTokenizer(pipe_delim_set, "\\|", false);
            int i = 0;
            int n = st.countTokens();
            String syns[] = new String[n];

            while (st.hasMoreTokens()) {
                syns[i] = new String(st.nextToken().trim());
                //System.out.println(syns[i]);
                i++;

            }



            Collections.shuffle(Arrays.asList(syns));

            /*
            i = 0;
            while(i < n){
            System.out.println(syns[i]);
            i++;
            }
            System.out.println(pipe_delim_set);
             */
            copy_of_data =
                    m.replaceFirst(syns[0]);
            m.reset(copy_of_data);
        }

        return copy_of_data;


    }

    public static String processInserts(String data) {

        String copy_of_data = new String(data);

        String pattern = "(?i)\\{[\\p{Blank}]*INSERT[^\\}\\{]+\\}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(copy_of_data);

        while (m.find()) {

            String matching_group = m.group();
            matching_group =
                    ((matching_group.substring(1, matching_group.length() - 1)).trim());
            String filename = new String((matching_group.substring(6, matching_group.length())).trim());
            String text = file2String(filename);
            /* some funny stuff is going on here when we try to replace stuff with c:\... in it..
             * the \'s are stripped.  so, to work around it im using \\ b/c it's some sort of strange escape thing 
             * */

            text =
                    fixSlash(text);
            copy_of_data =
                    m.replaceFirst(text);


            m.reset(copy_of_data);
        }

        return copy_of_data;


    }

    static public class ExternalLinkSet {

        int rows; //rows = number of key word vectors
        int cols; // cols = number of keywords eg. if 2 the KEYWORD and KEYWORD1 are keywords
        String url_dir_slash = "/";
        String url;
        String urlLink;
        String keyset_filename_extension = ".htm";
        String key_filename;
        String delimiter;
        String url_filename_space;
        String[] links;
        String[] link_order;
        String location;
        int location_col_num = 2;
        boolean flatlinks;
        public boolean switchlinks = false;
        int keyProcessingMethod = 0;
        // 0 =raw
        // 1 = trim only
        // 2 = remove leading and trailing " then trim
        String hash_string = "";
        String path = "";

        public ExternalLinkSet(KeySet ks, String _key_filename, String _location) {
            String[][] keys;
            String[] locations;
            urlLink = ks.urlLink;
            flatlinks = ks.flatlinks;
            cols = ks.cols;
            url = ks.url;
            // path = is the last column in the keyfile
            keyset_filename_extension = ks.filename_extension;
            key_filename = _key_filename;
            delimiter = ks.delimiter;
            url_filename_space = ks.url_filename_space;
            url_dir_slash = ks.url_dir_slash;
            switchlinks = ks.switchlinks;
            keyProcessingMethod = ks.keyProcessingMethod;
            location = (_location.trim()).toLowerCase();
            urlLink = ks.urlLink;
            path = ks.path;
            String filename_extension = ks.filename_extension;
            hash_string = key_filename + " " + location;
            String query_type = "";

            try {

                cols = 10; //fix
                cols = cols + 2; //+2 because added 2: path from old jprojs and file extension
                Pattern space_pattern = Pattern.compile("[\\p{Space}]+[\\s]*");
                Matcher space_matcher = space_pattern.matcher(" ");

                int i, j;
                CSVReader reader = new CSVReader(new FileReader(key_filename), delimiter.charAt(0), (char) 34, 0);
                String[] nextLine;

                rows = 0;
                while ((nextLine = reader.readNext()) != null) {

                    space_matcher.reset(nextLine[0]);
                    if (space_matcher.matches()) {
                    //blank 
                    } else {
                        rows++;
                    }


                }

                keys = new String[rows][cols];
                locations = new String[rows];

                reader.close();
                reader = new CSVReader(new FileReader(key_filename), delimiter.charAt(0), (char) 34, 0);
                i = 0;
                int loccount = 0;
                while ((nextLine = reader.readNext()) != null) {

                    space_matcher.reset(nextLine[0]);
                    if (space_matcher.matches()) {
                    //blank 
                    } else {
                        j = 0;
                        while (j < cols && j < Array.getLength(nextLine)) {
                            keys[i][j] = new String(nextLine[j]);
                            j++;
                        }
                        j = 0;
                        while (j < cols) {
                            if (keys[i][j] == null) {
                                keys[i][j] = "";
                            }
                            keys[i][j] = processRawKey(keys[i][j], keyProcessingMethod);
                            j++;
                        }
                        locations[i] = ((new String(keys[i][location_col_num])).trim()).toLowerCase();
                        if (location.compareTo(locations[i]) == 0) {
                            loccount++;
                        }
                        i++;
                    }

                }

                reader.close();

                link_order = new String[loccount];
                links = new String[loccount];
                i = 0;
                int ii = 0;
                while (i < rows && ii < loccount) {
                    if (location.compareTo(locations[i]) == 0) {
                        link_order[ii] = (" " + ii + " ").trim();
                        path = (keys[i][cols - 2]).trim();
                        filename_extension = (keys[i][cols - 1]).trim();
                        if ((filename_extension.trim()).compareTo("") == 0) {
                            filename_extension = keyset_filename_extension;
                        }
                        if (!path.endsWith(url_dir_slash)) {
                            path = path + url_dir_slash;
                        }
                        if (!path.startsWith(url_dir_slash)) {
                            path = url_dir_slash + path;
                        }
                        if (flatlinks) {

                            links[ii] = key2FlatLink(keys[i], filename_extension, url_dir_slash, url_filename_space, path, "csv", switchlinks);
                        } else {
                            links[ii] = key2Link(keys[i], filename_extension, url_dir_slash, url_filename_space, path, "csv", switchlinks);
                        }
                        ii++;
                    }
                    i++;
                }
                rows = loccount;

                return;


            } catch (Exception e) {
                System.out.println("something went wrong in csv based external links setup: " + e);
                rows = 0;
                return;
            }

        }

        public ExternalLinkSet(KeySet ks, Properties props) {
            String[][] keys;
            String[] locations;
            urlLink = ks.urlLink;
            flatlinks = ks.flatlinks;
            cols = ks.cols;
            url = ks.url;
            // path = is the last column in the keyfile
            keyset_filename_extension = ks.filename_extension;
            path = ks.path;
            delimiter = ks.delimiter;
            url_filename_space = ks.url_filename_space;
            url_dir_slash = ks.url_dir_slash;
            keyProcessingMethod = ks.keyProcessingMethod;
            switchlinks = Boolean.valueOf((props.getProperty("switchlinks")).trim());
            location = props.getProperty("location");
            String query_type = props.getProperty("query_type");
            hash_string = props.toString();

            //System.out.println("Hash: " + hash_string);
            try {


                keys = getQueryData(props, url, urlLink, keyProcessingMethod, url_filename_space);


                if (keys == null) {
                    rows = 0;
                    cols = 0;
                    System.out.println("No data returned in keyset.");
                    return;
                }
                rows = keys.length;
                if (rows == 0) {
                    cols = 0;
                    System.out.println("No data returned in keyset.");
                    return;
                }
                cols = (keys[0]).length;
                if (cols == 0) {
                    System.out.println("" + rows + " Empty keys returned in keyset.");
                    rows = 0;
                    return;

                }


                link_order = new String[rows];
                links = new String[rows];
                int i = 0;
                while (i < rows) {
                    link_order[i] = (" " + i + " ").trim();
                    if (flatlinks) {

                        links[i] = key2FlatLink(keys[i], keyset_filename_extension, url_dir_slash, url_filename_space, path, query_type, switchlinks);
                    } else {
                        links[i] = key2Link(keys[i], keyset_filename_extension, url_dir_slash, url_filename_space, path, query_type, switchlinks);
                    }
                    i++;
                }



            } catch (Exception e) {
                System.out.println("something went wrong in keyset() " + e);
            }


        }

        public String hashString() {
            return hash_string;
        }

        public String getHashString() {
            return hash_string;
        }

        public String[] getRandomLinks(int num_links) {

            int n = num_links;
            Collections.shuffle(Arrays.asList(link_order));
            if (n <= 0 || n > rows) {
                n = rows;
            }
            String[] array = new String[n];
            int i = 0;
            while (i < n) {
                array[i] = new String(links[Integer.parseInt(link_order[i], 10)]);
                i++;
            }
            return array;
        }

        public String[] getAlphaRandomLinks(int num_links) {

            int n = num_links;
            Collections.shuffle(Arrays.asList(link_order));
            if (n <= 0 || n > rows) {
                n = rows;
            }
            String[] array = new String[n];
            int i = 0;
            while (i < n) {
                array[i] = new String(links[Integer.parseInt(link_order[i], 10)]);
                i++;
            }

            Collections.sort(Arrays.asList(array), String.CASE_INSENSITIVE_ORDER);
            return array;
        }

        public String getLinksString(int num_links) {

            String linkString = "<ul> ";
            String[] link = getRandomLinks(num_links);
            for (String s : link) {
                linkString = linkString + "<li>" + s + "</li>";
            }
            linkString = linkString + "</ul>";
            return linkString;

        }

        public String getAlphaLinksString(int num_links) {

            String linkString = "<ul> ";
            String[] link = getAlphaRandomLinks(num_links);
            for (String s : link) {
                linkString = linkString + "<li>" + s + "</li>";
            }
            linkString = linkString + "</ul>";
            return linkString;

        }

        public String getFootLinksString(int num_links) {

            String linkString = "";
            String[] link = getRandomLinks(num_links);
            int i = 0;
            for (String s : link) {
                if (i == 0) {
                    linkString = linkString + "&nbsp;" + s;
                } else {
                    linkString = linkString + "&nbsp;" + "| " + s;
                }
                i++;
            }
            return linkString;

        }

        public String getAlphaFootLinksString(int num_links) {

            String linkString = "";
            String[] link = getAlphaRandomLinks(num_links);
            int i = 0;
            for (String s : link) {
                if (i == 0) {
                    linkString = linkString + "&nbsp;" + s;
                } else {
                    linkString = linkString + "&nbsp;" + "| " + s;
                }
                i++;
            }
            return linkString;

        }

        public String getHeadLinksString(int num_links) {

            String linkString = "";
            String[] link = getRandomLinks(num_links);
            int i = 0;
            for (String s : link) {
                if (i == 0) {
                    linkString = linkString + "&nbsp;" + s;
                } else {
                    linkString = linkString + "&nbsp;" + "| " + s;
                }
                i++;
            }
            return linkString;

        }

        public String getMTLinksString(int num_links) {

            String linkString = "";
            String[] link = getRandomLinks(num_links);
            for (String s : link) {
                linkString = linkString + "<li>" + s;
            }
            return linkString;

        }

        public String getMTFootLinksString(int num_links) {

            String linkString = "";
            String[] link = getRandomLinks(num_links);
            for (String s : link) {
                linkString = linkString + "&nbsp;" + s;
            }
            return linkString;

        }

        public String getMTHeadLinksString(int num_links) {

            String linkString = "";
            String[] link = getRandomLinks(num_links);
            for (String s : link) {
                linkString = linkString + "&nbsp;" + s;
            }
            return linkString;

        }

        public String getAlphaHeadLinksString(int num_links) {

            String linkString = "";
            String[] link = getAlphaRandomLinks(num_links);
            int i = 0;
            for (String s : link) {
                if (i == 0) {
                    linkString = linkString + "&nbsp;" + s;
                } else {
                    linkString = linkString + "&nbsp;" + "| " + s;
                }
                i++;
            }
            return linkString;

        }

        public String getAlphaMTLinksString(int num_links) {

            String linkString = "";
            String[] link = getAlphaRandomLinks(num_links);
            for (String s : link) {
                linkString = linkString + "<li>" + s;
            }
            return linkString;

        }

        public String getAlphaMTFootLinksString(int num_links) {

            String linkString = "";
            String[] link = getAlphaRandomLinks(num_links);
            for (String s : link) {
                linkString = linkString + "&nbsp;" + s;
            }
            return linkString;

        }

        public String getAlphaMTHeadLinksString(int num_links) {

            String linkString = "";
            String[] link = getAlphaRandomLinks(num_links);
            for (String s : link) {
                linkString = linkString + "&nbsp;" + s;
            }
            return linkString;

        }

        public int numKeys() {
            return rows;
        }

        public int numKeyWords() {
            return cols;
        }
    } //end of ExternalLinkSet class

    public static String processQueryLinks(String data, KeySet ks, Hashtable els_hash) throws Exception {
        try {
            String copy_of_data = new String(data);
            ExternalLinkSet els;

            String pattern = "(?i)\\{[\\p{Blank}]*QUERYLINKS[^\\}]+\\}";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(copy_of_data);


            while (m.find()) {

                String stuff = m.group();
                stuff =
                        stuff.substring(1, stuff.length() - 1);
                stuff =
                        stuff.trim();
                //System.out.println("Stuff from extern links");
                //System.out.println("Stuff: " + stuff);
                String[][] array = doubleDelimitedStringToArray(stuff, ",", "=");
                Properties props = new Properties();

                String query_type = array[0][1].trim();

                if (query_type.compareToIgnoreCase("event") == 0) {
                    props.load(new FileInputStream("event_query_defaults.ini"));
                    props.setProperty("query_type", "event");

                } else if (query_type.compareToIgnoreCase("venue") == 0) {
                    props.load(new FileInputStream("venue_query_defaults.ini"));
                    props.setProperty("query_type", "venue");

                } else if (query_type.compareToIgnoreCase("performer") == 0) {
                    props.load(new FileInputStream("performer_query_defaults.ini"));
                    props.setProperty("query_type", "performer");

                }

                int i = 1; //skip the query_type = something pair
                while (i < array.length) {
                    if((array[i]).length < 2){
                        if(i > 1){
                            int kk = i;
                            while((array[kk]).length < 2){
                                kk--;
                            }
                            array[kk][1] = array[kk][1] + ", " + array[i][0];
                            //System.out.println("fixed "+ (kk) + " " + array[kk][0].trim() + "  " + array[kk][1].trim());  
                            props.setProperty(array[kk][0].trim(), array[kk][1].trim());
                        }
                        
                    }else{
                        props.setProperty(array[i][0].trim(), array[i][1].trim());
                        //System.out.println(""+i + " " + array[i][0].trim() + "  " + array[i][1].trim());
                    }
                    //System.out.println(""+i + " " + array[i][0].trim() + "  " + array[i][1].trim());
                    i++;

                }





                String location = props.getProperty("location");

                String hash_string = props.toString();

                if (els_hash.containsKey(hash_string)) {
                    els = (ExternalLinkSet) els_hash.get(hash_string);
                    System.out.println("queryELS retrieved from hash");
                } else {
                    els = new ExternalLinkSet(ks, props);
                    els_hash.put(els.hashString(), els);
                    System.out.println("queryELS not in hash");
                }

                String linkString;
                if (els.numKeys() == 0) {
                    linkString = "";
                } else {
                    linkString = new String(els.getLinksString(0));
                }

                copy_of_data = m.replaceFirst(fixSlash(linkString));
                m.reset(copy_of_data);


            }

            String numberpat = "[0-9]+";
            Pattern number_pattern = Pattern.compile(numberpat);
            String pattern_with_numbers = "(?i)\\{[\\p{Blank}]*[0-9]+[\\p{Blank}]*QUERYLINKS[^\\}]+\\}";
            Pattern pattern2 = Pattern.compile(pattern_with_numbers);
            Matcher m2 = pattern2.matcher(copy_of_data);
            while (m2.find()) {
                
                String stuff = m2.group();
                stuff =
                        stuff.substring(1, stuff.length() - 1);
                stuff =
                        stuff.trim();
                        

                String[][] array = doubleDelimitedStringToArray(stuff, ",", "=");
                Properties props = new Properties();

                String query_type = array[0][1].trim();
                String query_key = array[0][0].trim();
                Matcher number_matcher = number_pattern.matcher(query_key);
                number_matcher.find();
                String num = (number_matcher.group()).trim();
                int n = Integer.valueOf(num).intValue();
                
                if (query_type.compareToIgnoreCase("event") == 0) {
                    props.load(new FileInputStream("event_query_defaults.ini"));
                    props.setProperty("query_type", "event");

                } else if (query_type.compareToIgnoreCase("venue") == 0) {
                    props.load(new FileInputStream("venue_query_defaults.ini"));
                    props.setProperty("query_type", "venue");

                } else if (query_type.compareToIgnoreCase("performer") == 0) {
                    props.load(new FileInputStream("performer_query_defaults.ini"));
                    props.setProperty("query_type", "performer");

                }

                int i = 1;  //skip the # query_type = something pair

                while (i < array.length) {
                    if((array[i]).length < 2){
                        if(i > 1){
                            int kk = i;
                            while((array[kk]).length < 2){
                                kk--;
                            }
                            array[kk][1] = array[kk][1] + ", " + array[i][0];
                            //System.out.println("fixed "+ (kk) + " " + array[kk][0].trim() + "  " + array[kk][1].trim());  
                            props.setProperty(array[kk][0].trim(), array[kk][1].trim());
                        }
                        
                    }else{
                        props.setProperty(array[i][0].trim(), array[i][1].trim());
                        //System.out.println(""+i + " " + array[i][0].trim() + "  " + array[i][1].trim());
                    }
                    //System.out.println(""+i + " " + array[i][0].trim() + "  " + array[i][1].trim());
                    i++;

                }




                String location = props.getProperty("location");

                String hash_string = props.toString();

                if (els_hash.containsKey(hash_string)) {
                    els = (ExternalLinkSet) els_hash.get(hash_string);
                    System.out.println("queryELS retrieved from hash");
                } else {
                    els = new ExternalLinkSet(ks, props);
                    els_hash.put(els.hashString(), els);
                    System.out.println("queryELS not in hash");
                }

                String linkString;
                if (els.numKeys() == 0) {
                    linkString = "";
                } else {
                    linkString = new String(els.getLinksString(n));
                }

                copy_of_data = m2.replaceFirst(fixSlash(linkString));
                m2.reset(copy_of_data);

            }

            return copy_of_data;
        } catch (Exception e) {
            throw (e);

        }

    }

    public static String processQueryFootLinks(String data, KeySet ks, Hashtable els_hash) throws Exception {
        try {
            String copy_of_data = new String(data);
            ExternalLinkSet els;

            String pattern = "(?i)\\{[\\p{Blank}]*QUERYFOOTLINKS[^\\}]+\\}";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(copy_of_data);


            while (m.find()) {

                String stuff = m.group();
                stuff =
                        stuff.substring(1, stuff.length() - 1);
                stuff =
                        stuff.trim();
                //System.out.println("Stuff from extern links");
                //System.out.println("Stuff: " + stuff);
                String[][] array = doubleDelimitedStringToArray(stuff, ",", "=");
                Properties props = new Properties();

                String query_type = array[0][1].trim();

                if (query_type.compareToIgnoreCase("event") == 0) {
                    props.load(new FileInputStream("event_query_defaults.ini"));
                    props.setProperty("query_type", "event");

                } else if (query_type.compareToIgnoreCase("venue") == 0) {
                    props.load(new FileInputStream("venue_query_defaults.ini"));
                    props.setProperty("query_type", "venue");

                } else if (query_type.compareToIgnoreCase("performer") == 0) {
                    props.load(new FileInputStream("performer_query_defaults.ini"));
                    props.setProperty("query_type", "performer");

                }

                int i = 1; //skip the query_type = something pair
                while (i < array.length) {
                    if((array[i]).length < 2){
                        if(i > 1){
                            int kk = i;
                            while((array[kk]).length < 2){
                                kk--;
                            }
                            array[kk][1] = array[kk][1] + ", " + array[i][0];
                            //System.out.println("fixed "+ (kk) + " " + array[kk][0].trim() + "  " + array[kk][1].trim());  
                            props.setProperty(array[kk][0].trim(), array[kk][1].trim());
                        }
                        
                    }else{
                        props.setProperty(array[i][0].trim(), array[i][1].trim());
                        //System.out.println(""+i + " " + array[i][0].trim() + "  " + array[i][1].trim());
                    }
                    //System.out.println(""+i + " " + array[i][0].trim() + "  " + array[i][1].trim());
                    i++;

                }





                String location = props.getProperty("location");

                String hash_string = props.toString();

                if (els_hash.containsKey(hash_string)) {
                    els = (ExternalLinkSet) els_hash.get(hash_string);
                    System.out.println("queryELS retrieved from hash");
                } else {
                    els = new ExternalLinkSet(ks, props);
                    els_hash.put(els.hashString(), els);
                    System.out.println("queryELS not in hash");
                }

                String linkString;
                if (els.numKeys() == 0) {
                    linkString = "";
                } else {
                    linkString = new String(els.getFootLinksString(0));
                }

                copy_of_data = m.replaceFirst(fixSlash(linkString));
                m.reset(copy_of_data);


            }

            String numberpat = "[0-9]+";
            Pattern number_pattern = Pattern.compile(numberpat);
            String pattern_with_numbers = "(?i)\\{[\\p{Blank}]*[0-9]+[\\p{Blank}]*QUERYFOOTLINKS[^\\}]+\\}";
            Pattern pattern2 = Pattern.compile(pattern_with_numbers);
            Matcher m2 = pattern2.matcher(copy_of_data);
            while (m2.find()) {
                String stuff = m2.group();
                stuff =
                        stuff.substring(1, stuff.length() - 1);
                stuff =
                        stuff.trim();


                String[][] array = doubleDelimitedStringToArray(stuff, ",", "=");
                Properties props = new Properties();

                String query_type = array[0][1].trim();
                String query_key = array[0][0].trim();
                Matcher number_matcher = number_pattern.matcher(query_key);
                number_matcher.find();
                String num = (number_matcher.group()).trim();

                int n = Integer.valueOf(num).intValue();
                if (query_type.compareToIgnoreCase("event") == 0) {
                    props.load(new FileInputStream("event_query_defaults.ini"));
                    props.setProperty("query_type", "event");

                } else if (query_type.compareToIgnoreCase("venue") == 0) {
                    props.load(new FileInputStream("venue_query_defaults.ini"));
                    props.setProperty("query_type", "venue");

                } else if (query_type.compareToIgnoreCase("performer") == 0) {
                    props.load(new FileInputStream("performer_query_defaults.ini"));
                    props.setProperty("query_type", "performer");

                }

                int i = 1;  //skip the # query_type = something pair

             while (i < array.length) {
                    if((array[i]).length < 2){
                        if(i > 1){
                            int kk = i;
                            while((array[kk]).length < 2){
                                kk--;
                            }
                            array[kk][1] = array[kk][1] + ", " + array[i][0];
                            //System.out.println("fixed "+ (kk) + " " + array[kk][0].trim() + "  " + array[kk][1].trim());  
                            props.setProperty(array[kk][0].trim(), array[kk][1].trim());
                        }
                        
                    }else{
                        props.setProperty(array[i][0].trim(), array[i][1].trim());
                        //System.out.println(""+i + " " + array[i][0].trim() + "  " + array[i][1].trim());
                    }
                    //System.out.println(""+i + " " + array[i][0].trim() + "  " + array[i][1].trim());
                    i++;

                }





                String location = props.getProperty("location");

                String hash_string = props.toString();

                if (els_hash.containsKey(hash_string)) {
                    els = (ExternalLinkSet) els_hash.get(hash_string);
                    System.out.println("queryELS retrieved from hash");
                } else {
                    els = new ExternalLinkSet(ks, props);
                    els_hash.put(els.hashString(), els);
                    System.out.println("queryELS not in hash");
                }

                String linkString;
                if (els.numKeys() == 0) {
                    linkString = "";
                } else {
                    linkString = new String(els.getFootLinksString(n));
                }

                copy_of_data = m2.replaceFirst(fixSlash(linkString));
                m2.reset(copy_of_data);

            }

            return copy_of_data;
        } catch (Exception e) {
            throw (e);

        }

    }

    public static String processQueryHeadLinks(String data, KeySet ks, Hashtable els_hash) throws Exception {
        try {
            String copy_of_data = new String(data);
            ExternalLinkSet els;

            String pattern = "(?i)\\{[\\p{Blank}]*QUERYHEADLINKS[^\\}]+\\}";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(copy_of_data);


            while (m.find()) {

                String stuff = m.group();
                stuff =
                        stuff.substring(1, stuff.length() - 1);
                stuff =
                        stuff.trim();
                //System.out.println("Stuff from extern links");
                //System.out.println("Stuff: " + stuff);
                String[][] array = doubleDelimitedStringToArray(stuff, ",", "=");
                Properties props = new Properties();

                String query_type = array[0][1].trim();

                if (query_type.compareToIgnoreCase("event") == 0) {
                    props.load(new FileInputStream("event_query_defaults.ini"));
                    props.setProperty("query_type", "event");

                } else if (query_type.compareToIgnoreCase("venue") == 0) {
                    props.load(new FileInputStream("venue_query_defaults.ini"));
                    props.setProperty("query_type", "venue");

                } else if (query_type.compareToIgnoreCase("performer") == 0) {
                    props.load(new FileInputStream("performer_query_defaults.ini"));
                    props.setProperty("query_type", "performer");

                }

                int i = 1; //skip the query_type = something pair
                while (i < array.length) {
                    if((array[i]).length < 2){
                        if(i > 1){
                            int kk = i;
                            while((array[kk]).length < 2){
                                kk--;
                            }
                            array[kk][1] = array[kk][1] + ", " + array[i][0];
                            //System.out.println("fixed "+ (kk) + " " + array[kk][0].trim() + "  " + array[kk][1].trim());  
                            props.setProperty(array[kk][0].trim(), array[kk][1].trim());
                        }
                        
                    }else{
                        props.setProperty(array[i][0].trim(), array[i][1].trim());
                        //System.out.println(""+i + " " + array[i][0].trim() + "  " + array[i][1].trim());
                    }
                    //System.out.println(""+i + " " + array[i][0].trim() + "  " + array[i][1].trim());
                    i++;

                }





                String location = props.getProperty("location");

                String hash_string = props.toString();

                if (els_hash.containsKey(hash_string)) {
                    els = (ExternalLinkSet) els_hash.get(hash_string);
                    System.out.println("queryELS retrieved from hash");
                } else {
                    els = new ExternalLinkSet(ks, props);
                    els_hash.put(els.hashString(), els);
                    System.out.println("queryELS not in hash");
                }

                String linkString;
                if (els.numKeys() == 0) {
                    linkString = "";
                } else {
                    linkString = new String(els.getHeadLinksString(0));
                }

                copy_of_data = m.replaceFirst(fixSlash(linkString));
                m.reset(copy_of_data);


            }

            String numberpat = "[0-9]+";
            Pattern number_pattern = Pattern.compile(numberpat);
            String pattern_with_numbers = "(?i)\\{[\\p{Blank}]*[0-9]+[\\p{Blank}]*QUERYHEADLINKS[^\\}]+\\}";
            Pattern pattern2 = Pattern.compile(pattern_with_numbers);
            Matcher m2 = pattern2.matcher(copy_of_data);
            while (m2.find()) {
                String stuff = m2.group();
                stuff =
                        stuff.substring(1, stuff.length() - 1);
                stuff =
                        stuff.trim();


                String[][] array = doubleDelimitedStringToArray(stuff, ",", "=");
                Properties props = new Properties();

                String query_type = array[0][1].trim();
                String query_key = array[0][0].trim();
                Matcher number_matcher = number_pattern.matcher(query_key);
                number_matcher.find();
                String num = (number_matcher.group()).trim();
                int n = Integer.valueOf(num).intValue();

                if (query_type.compareToIgnoreCase("event") == 0) {
                    props.load(new FileInputStream("event_query_defaults.ini"));
                    props.setProperty("query_type", "event");

                } else if (query_type.compareToIgnoreCase("venue") == 0) {
                    props.load(new FileInputStream("venue_query_defaults.ini"));
                    props.setProperty("query_type", "venue");

                } else if (query_type.compareToIgnoreCase("performer") == 0) {
                    props.load(new FileInputStream("performer_query_defaults.ini"));
                    props.setProperty("query_type", "performer");

                }

                int i = 1;  //skip the # query_type = something pair

                while (i < array.length) {
                    if((array[i]).length < 2){
                        if(i > 1){
                            int kk = i;
                            while((array[kk]).length < 2){
                                kk--;
                            }
                            array[kk][1] = array[kk][1] + ", " + array[i][0];
                            //System.out.println("fixed "+ (kk) + " " + array[kk][0].trim() + "  " + array[kk][1].trim());  
                            props.setProperty(array[kk][0].trim(), array[kk][1].trim());
                        }
                        
                    }else{
                        props.setProperty(array[i][0].trim(), array[i][1].trim());
                        //System.out.println(""+i + " " + array[i][0].trim() + "  " + array[i][1].trim());
                    }
                    //System.out.println(""+i + " " + array[i][0].trim() + "  " + array[i][1].trim());
                    i++;

                }




                String location = props.getProperty("location");

                String hash_string = props.toString();

                if (els_hash.containsKey(hash_string)) {
                    els = (ExternalLinkSet) els_hash.get(hash_string);
                    System.out.println("queryELS retrieved from hash");
                } else {
                    els = new ExternalLinkSet(ks, props);
                    els_hash.put(els.hashString(), els);
                    System.out.println("queryELS not in hash");
                }

                String linkString;
                if (els.numKeys() == 0) {
                    linkString = "";
                } else {
                    linkString = new String(els.getHeadLinksString(n));
                }

                copy_of_data = m2.replaceFirst(fixSlash(linkString));
                m2.reset(copy_of_data);

            }

            return copy_of_data;
        } catch (Exception e) {
            throw (e);

        }

    }

    public static String processQueryAlphaLinks(String data, KeySet ks, Hashtable els_hash) throws Exception {
        try {
            String copy_of_data = new String(data);
            ExternalLinkSet els;

            String pattern = "(?i)\\{[\\p{Blank}]*QUERYALPHALINKS[^\\}]+\\}";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(copy_of_data);


            while (m.find()) {

                String stuff = m.group();
                stuff =
                        stuff.substring(1, stuff.length() - 1);
                stuff =
                        stuff.trim();
                //System.out.println("Stuff from extern links");
                //System.out.println("Stuff: " + stuff);
                String[][] array = doubleDelimitedStringToArray(stuff, ",", "=");
                Properties props = new Properties();

                String query_type = array[0][1].trim();

                if (query_type.compareToIgnoreCase("event") == 0) {
                    props.load(new FileInputStream("event_query_defaults.ini"));
                    props.setProperty("query_type", "event");

                } else if (query_type.compareToIgnoreCase("venue") == 0) {
                    props.load(new FileInputStream("venue_query_defaults.ini"));
                    props.setProperty("query_type", "venue");

                } else if (query_type.compareToIgnoreCase("performer") == 0) {
                    props.load(new FileInputStream("performer_query_defaults.ini"));
                    props.setProperty("query_type", "performer");

                }

                int i = 1; //skip the query_type = something pair
                while (i < array.length) {
                    if((array[i]).length < 2){
                        if(i > 1){
                            int kk = i;
                            while((array[kk]).length < 2){
                                kk--;
                            }
                            array[kk][1] = array[kk][1] + ", " + array[i][0];
                            //System.out.println("fixed "+ (kk) + " " + array[kk][0].trim() + "  " + array[kk][1].trim());  
                            props.setProperty(array[kk][0].trim(), array[kk][1].trim());
                        }
                        
                    }else{
                        props.setProperty(array[i][0].trim(), array[i][1].trim());
                        //System.out.println(""+i + " " + array[i][0].trim() + "  " + array[i][1].trim());
                    }
                    //System.out.println(""+i + " " + array[i][0].trim() + "  " + array[i][1].trim());
                    i++;

                }




                String location = props.getProperty("location");

                String hash_string = props.toString();

                if (els_hash.containsKey(hash_string)) {
                    els = (ExternalLinkSet) els_hash.get(hash_string);
                    System.out.println("queryELS retrieved from hash");
                } else {
                    els = new ExternalLinkSet(ks, props);
                    els_hash.put(els.hashString(), els);
                    System.out.println("queryELS not in hash");
                }

                String linkString;
                if (els.numKeys() == 0) {
                    linkString = "";
                } else {
                    linkString = new String(els.getAlphaLinksString(0));
                }

                copy_of_data = m.replaceFirst(fixSlash(linkString));
                m.reset(copy_of_data);


            }

            String numberpat = "[0-9]+";
            Pattern number_pattern = Pattern.compile(numberpat);
            String pattern_with_numbers = "(?i)\\{[\\p{Blank}]*[0-9]+[\\p{Blank}]*QUERYALPHALINKS[^\\}]+\\}";
            Pattern pattern2 = Pattern.compile(pattern_with_numbers);
            Matcher m2 = pattern2.matcher(copy_of_data);
            while (m2.find()) {
                String stuff = m2.group();
                stuff =
                        stuff.substring(1, stuff.length() - 1);
                stuff =
                        stuff.trim();


                String[][] array = doubleDelimitedStringToArray(stuff, ",", "=");
                Properties props = new Properties();

                String query_type = array[0][1].trim();
                String query_key = array[0][0].trim();
                Matcher number_matcher = number_pattern.matcher(query_key);
                number_matcher.find();
                String num = (number_matcher.group()).trim();
                int n = Integer.valueOf(num).intValue();

                if (query_type.compareToIgnoreCase("event") == 0) {
                    props.load(new FileInputStream("event_query_defaults.ini"));
                    props.setProperty("query_type", "event");

                } else if (query_type.compareToIgnoreCase("venue") == 0) {
                    props.load(new FileInputStream("venue_query_defaults.ini"));
                    props.setProperty("query_type", "venue");

                } else if (query_type.compareToIgnoreCase("performer") == 0) {
                    props.load(new FileInputStream("performer_query_defaults.ini"));
                    props.setProperty("query_type", "performer");

                }

                int i = 1;  //skip the # query_type = something pair

                while (i < array.length) {
                    if((array[i]).length < 2){
                        if(i > 1){
                            int kk = i;
                            while((array[kk]).length < 2){
                                kk--;
                            }
                            array[kk][1] = array[kk][1] + ", " + array[i][0];
                            //System.out.println("fixed "+ (kk) + " " + array[kk][0].trim() + "  " + array[kk][1].trim());  
                            props.setProperty(array[kk][0].trim(), array[kk][1].trim());
                        }
                        
                    }else{
                        props.setProperty(array[i][0].trim(), array[i][1].trim());
                        //System.out.println(""+i + " " + array[i][0].trim() + "  " + array[i][1].trim());
                    }
                    //System.out.println(""+i + " " + array[i][0].trim() + "  " + array[i][1].trim());
                    i++;

                }




                String location = props.getProperty("location");

                String hash_string = props.toString();

                if (els_hash.containsKey(hash_string)) {
                    els = (ExternalLinkSet) els_hash.get(hash_string);
                    System.out.println("queryELS retrieved from hash");
                } else {
                    els = new ExternalLinkSet(ks, props);
                    els_hash.put(els.hashString(), els);
                    System.out.println("queryELS not in hash");
                }

                String linkString;
                if (els.numKeys() == 0) {
                    linkString = "";
                } else {
                    linkString = new String(els.getAlphaLinksString(n));
                }

                copy_of_data = m2.replaceFirst(fixSlash(linkString));
                m2.reset(copy_of_data);

            }

            return copy_of_data;
        } catch (Exception e) {
            throw (e);

        }

    }

    public static String processQueryAlphaFootLinks(String data, KeySet ks, Hashtable els_hash) throws Exception {
        try {
            String copy_of_data = new String(data);
            ExternalLinkSet els;

            String pattern = "(?i)\\{[\\p{Blank}]*QUERYALPHAFOOTLINKS[^\\}]+\\}";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(copy_of_data);


            while (m.find()) {

                String stuff = m.group();
                stuff =
                        stuff.substring(1, stuff.length() - 1);
                stuff =
                        stuff.trim();
                //System.out.println("Stuff from extern links");
                //System.out.println("Stuff: " + stuff);
                String[][] array = doubleDelimitedStringToArray(stuff, ",", "=");
                Properties props = new Properties();

                String query_type = array[0][1].trim();

                if (query_type.compareToIgnoreCase("event") == 0) {
                    props.load(new FileInputStream("event_query_defaults.ini"));
                    props.setProperty("query_type", "event");

                } else if (query_type.compareToIgnoreCase("venue") == 0) {
                    props.load(new FileInputStream("venue_query_defaults.ini"));
                    props.setProperty("query_type", "venue");

                } else if (query_type.compareToIgnoreCase("performer") == 0) {
                    props.load(new FileInputStream("performer_query_defaults.ini"));
                    props.setProperty("query_type", "performer");

                }

                int i = 1; //skip the query_type = something pair
                while (i < array.length) {
                    if((array[i]).length < 2){
                        if(i > 1){
                            int kk = i;
                            while((array[kk]).length < 2){
                                kk--;
                            }
                            array[kk][1] = array[kk][1] + ", " + array[i][0];
                            //System.out.println("fixed "+ (kk) + " " + array[kk][0].trim() + "  " + array[kk][1].trim());  
                            props.setProperty(array[kk][0].trim(), array[kk][1].trim());
                        }
                        
                    }else{
                        props.setProperty(array[i][0].trim(), array[i][1].trim());
                        //System.out.println(""+i + " " + array[i][0].trim() + "  " + array[i][1].trim());
                    }
                    //System.out.println(""+i + " " + array[i][0].trim() + "  " + array[i][1].trim());
                    i++;

                }





                String location = props.getProperty("location");

                String hash_string = props.toString();

                if (els_hash.containsKey(hash_string)) {
                    els = (ExternalLinkSet) els_hash.get(hash_string);
                    System.out.println("queryELS retrieved from hash");
                } else {
                    els = new ExternalLinkSet(ks, props);
                    els_hash.put(els.hashString(), els);
                    System.out.println("queryELS not in hash");
                }

                String linkString;
                if (els.numKeys() == 0) {
                    linkString = "";
                } else {
                    linkString = new String(els.getAlphaFootLinksString(0));
                }

                copy_of_data = m.replaceFirst(fixSlash(linkString));
                m.reset(copy_of_data);


            }

            String numberpat = "[0-9]+";
            Pattern number_pattern = Pattern.compile(numberpat);
            String pattern_with_numbers = "(?i)\\{[\\p{Blank}]*[0-9]+[\\p{Blank}]*QUERYALPHAFOOTLINKS[^\\}]+\\}";
            Pattern pattern2 = Pattern.compile(pattern_with_numbers);
            Matcher m2 = pattern2.matcher(copy_of_data);
            while (m2.find()) {
                String stuff = m2.group();
                stuff =
                        stuff.substring(1, stuff.length() - 1);
                stuff =
                        stuff.trim();


                String[][] array = doubleDelimitedStringToArray(stuff, ",", "=");
                Properties props = new Properties();

                String query_type = array[0][1].trim();
                String query_key = array[0][0].trim();
                Matcher number_matcher = number_pattern.matcher(query_key);
                number_matcher.find();
                String num = (number_matcher.group()).trim();
                int n = Integer.valueOf(num).intValue();

                if (query_type.compareToIgnoreCase("event") == 0) {
                    props.load(new FileInputStream("event_query_defaults.ini"));
                    props.setProperty("query_type", "event");

                } else if (query_type.compareToIgnoreCase("venue") == 0) {
                    props.load(new FileInputStream("venue_query_defaults.ini"));
                    props.setProperty("query_type", "venue");

                } else if (query_type.compareToIgnoreCase("performer") == 0) {
                    props.load(new FileInputStream("performer_query_defaults.ini"));
                    props.setProperty("query_type", "performer");

                }

                int i = 1;  //skip the # query_type = something pair

                while (i < array.length) {
                    if((array[i]).length < 2){
                        if(i > 1){
                            int kk = i;
                            while((array[kk]).length < 2){
                                kk--;
                            }
                            array[kk][1] = array[kk][1] + ", " + array[i][0];
                            //System.out.println("fixed "+ (kk) + " " + array[kk][0].trim() + "  " + array[kk][1].trim());  
                            props.setProperty(array[kk][0].trim(), array[kk][1].trim());
                        }
                        
                    }else{
                        props.setProperty(array[i][0].trim(), array[i][1].trim());
                        //System.out.println(""+i + " " + array[i][0].trim() + "  " + array[i][1].trim());
                    }
                    //System.out.println(""+i + " " + array[i][0].trim() + "  " + array[i][1].trim());
                    i++;

                }




                String location = props.getProperty("location");

                String hash_string = props.toString();

                if (els_hash.containsKey(hash_string)) {
                    els = (ExternalLinkSet) els_hash.get(hash_string);
                    System.out.println("queryELS retrieved from hash");
                } else {
                    els = new ExternalLinkSet(ks, props);
                    els_hash.put(els.hashString(), els);
                    System.out.println("queryELS not in hash");
                }

                String linkString;
                if (els.numKeys() == 0) {
                    linkString = "";
                } else {
                    linkString = new String(els.getAlphaFootLinksString(n));
                }

                copy_of_data = m2.replaceFirst(fixSlash(linkString));
                m2.reset(copy_of_data);

            }

            return copy_of_data;
        } catch (Exception e) {
            throw (e);

        }

    }

    public static String processQueryAlphaHeadLinks(String data, KeySet ks, Hashtable els_hash) throws Exception {
        try {
            String copy_of_data = new String(data);
            ExternalLinkSet els;

            String pattern = "(?i)\\{[\\p{Blank}]*QUERYALPHAHEADLINKS[^\\}]+\\}";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(copy_of_data);


            while (m.find()) {

                String stuff = m.group();
                stuff =
                        stuff.substring(1, stuff.length() - 1);
                stuff =
                        stuff.trim();
                //System.out.println("Stuff from extern links");
                //System.out.println("Stuff: " + stuff);
                String[][] array = doubleDelimitedStringToArray(stuff, ",", "=");
                Properties props = new Properties();

                String query_type = array[0][1].trim();

                if (query_type.compareToIgnoreCase("event") == 0) {
                    props.load(new FileInputStream("event_query_defaults.ini"));
                    props.setProperty("query_type", "event");

                } else if (query_type.compareToIgnoreCase("venue") == 0) {
                    props.load(new FileInputStream("venue_query_defaults.ini"));
                    props.setProperty("query_type", "venue");

                } else if (query_type.compareToIgnoreCase("performer") == 0) {
                    props.load(new FileInputStream("performer_query_defaults.ini"));
                    props.setProperty("query_type", "performer");

                }

                int i = 1; //skip the query_type = something pair
                while (i < array.length) {
                    if((array[i]).length < 2){
                        if(i > 1){
                            int kk = i;
                            while((array[kk]).length < 2){
                                kk--;
                            }
                            array[kk][1] = array[kk][1] + ", " + array[i][0];
                            //System.out.println("fixed "+ (kk) + " " + array[kk][0].trim() + "  " + array[kk][1].trim());  
                            props.setProperty(array[kk][0].trim(), array[kk][1].trim());
                        }
                        
                    }else{
                        props.setProperty(array[i][0].trim(), array[i][1].trim());
                       // System.out.println(""+i + " " + array[i][0].trim() + "  " + array[i][1].trim());
                    }
                    //System.out.println(""+i + " " + array[i][0].trim() + "  " + array[i][1].trim());
                    i++;

                }




                String location = props.getProperty("location");

                String hash_string = props.toString();

                if (els_hash.containsKey(hash_string)) {
                    els = (ExternalLinkSet) els_hash.get(hash_string);
                    System.out.println("queryELS retrieved from hash");
                } else {
                    els = new ExternalLinkSet(ks, props);
                    els_hash.put(els.hashString(), els);
                    System.out.println("queryELS not in hash");
                }

                String linkString;
                if (els.numKeys() == 0) {
                    linkString = "";
                } else {
                    linkString = new String(els.getAlphaHeadLinksString(0));
                }

                copy_of_data = m.replaceFirst(fixSlash(linkString));
                m.reset(copy_of_data);


            }

            String numberpat = "[0-9]+";
            Pattern number_pattern = Pattern.compile(numberpat);
            String pattern_with_numbers = "(?i)\\{[\\p{Blank}]*[0-9]+[\\p{Blank}]*QUERYALPHAHEADLINKS[^\\}]+\\}";
            Pattern pattern2 = Pattern.compile(pattern_with_numbers);
            Matcher m2 = pattern2.matcher(copy_of_data);
            while (m2.find()) {
                String stuff = m2.group();
                stuff =
                        stuff.substring(1, stuff.length() - 1);
                stuff =
                        stuff.trim();


                String[][] array = doubleDelimitedStringToArray(stuff, ",", "=");
                Properties props = new Properties();

                String query_type = array[0][1].trim();
                String query_key = array[0][0].trim();
                Matcher number_matcher = number_pattern.matcher(query_key);
                number_matcher.find();
                String num = (number_matcher.group()).trim();
                int n = Integer.valueOf(num).intValue();

                if (query_type.compareToIgnoreCase("event") == 0) {
                    props.load(new FileInputStream("event_query_defaults.ini"));
                    props.setProperty("query_type", "event");

                } else if (query_type.compareToIgnoreCase("venue") == 0) {
                    props.load(new FileInputStream("venue_query_defaults.ini"));
                    props.setProperty("query_type", "venue");

                } else if (query_type.compareToIgnoreCase("performer") == 0) {
                    props.load(new FileInputStream("performer_query_defaults.ini"));
                    props.setProperty("query_type", "performer");

                }

                int i = 1;  //skip the # query_type = something pair

               while (i < array.length) {
                    if((array[i]).length < 2){
                        if(i > 1){
                            int kk = i;
                            while((array[kk]).length < 2){
                                kk--;
                            }
                            array[kk][1] = array[kk][1] + ", " + array[i][0];
                            //System.out.println("fixed "+ (kk) + " " + array[kk][0].trim() + "  " + array[kk][1].trim());  
                            props.setProperty(array[kk][0].trim(), array[kk][1].trim());
                        }
                        
                    }else{
                        props.setProperty(array[i][0].trim(), array[i][1].trim());
                        //System.out.println(""+i + " " + array[i][0].trim() + "  " + array[i][1].trim());
                    }
                    //System.out.println(""+i + " " + array[i][0].trim() + "  " + array[i][1].trim());
                    i++;

                }


                String location = props.getProperty("location");

                String hash_string = props.toString();

                if (els_hash.containsKey(hash_string)) {
                    els = (ExternalLinkSet) els_hash.get(hash_string);
                    System.out.println("queryELS retrieved from hash");
                } else {
                    els = new ExternalLinkSet(ks, props);
                    els_hash.put(els.hashString(), els);
                    System.out.println("queryELS not in hash");
                }

                String linkString;
                if (els.numKeys() == 0) {
                    linkString = "";
                } else {
                    linkString = new String(els.getAlphaHeadLinksString(n));
                }

                copy_of_data = m2.replaceFirst(fixSlash(linkString));
                m2.reset(copy_of_data);

            }

            return copy_of_data;
        } catch (Exception e) {
            throw (e);

        }

    }

    public static String processExternalLinks(String data, KeySet ks, Hashtable els_hash) {

        String copy_of_data = new String(data);

        ExternalLinkSet els;

        String pattern = "(?i)\\{[\\p{Blank}]*EXTERNLINKS[^\\}]+\\}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(copy_of_data);


        while (m.find()) {




            String stuff = m.group();
            stuff =
                    stuff.substring(1, stuff.length() - 1);
            stuff =
                    stuff.trim();
            String keyword_string = (stuff.substring(0, stuff.indexOf(','))).trim();
            String filename_string = (stuff.substring(stuff.indexOf(',') + 1, stuff.indexOf(',', stuff.indexOf(',') + 1))).trim();
            String location_string = ((stuff.substring(stuff.lastIndexOf(',') + 1, stuff.length())).trim()).toLowerCase();
            //System.out.println("Stuff from extern links");
            //System.out.println("Stuff: " + stuff);
            //System.out.println("Stuff: " + keyword_string);
            //System.out.println("Stuff: " + filename_string);
            //System.out.println("Stuff: " + location_string );

            String location = (location_string.trim()).toLowerCase();
            String external_links_filename = filename_string;
            String hash_string = external_links_filename + " " + location;

            if (els_hash.containsKey(hash_string)) {
                els = (ExternalLinkSet) els_hash.get(hash_string);
            //System.out.println("ELS retrieved from hash");
            } else {
                els = new ExternalLinkSet(ks, external_links_filename, location);
                els_hash.put(els.hashString(), els);
            //System.out.println("ELS not in hash");
            }

            String linkString = new String(els.getLinksString(0));
            copy_of_data =
                    m.replaceFirst(fixSlash(linkString));
            m.reset(copy_of_data);


        }

        String pattern_with_numbers = "(?i)\\{[\\p{Blank}]*[0-9]+[\\p{Blank}]*EXTERNLINKS[^\\}]+\\}";
        Pattern pattern2 = Pattern.compile(pattern_with_numbers);
        Matcher m2 = pattern2.matcher(copy_of_data);
        while (m2.find()) {

            String stuff = m2.group();
            stuff =
                    stuff.substring(1, stuff.length() - 1);
            stuff =
                    stuff.trim();
            String keyword_string = (stuff.substring(0, stuff.indexOf(','))).trim();
            String filename_string = (stuff.substring(stuff.indexOf(',') + 1, stuff.indexOf(',', stuff.indexOf(',') + 1))).trim();
            String location_string = ((stuff.substring(stuff.lastIndexOf(',') + 1, stuff.length())).trim()).toLowerCase();
            //System.out.println("Stuff from number extern links");
            //System.out.println("Stuff: " + stuff);
            //System.out.println("Stuff: " + keyword_string);
            //System.out.println("Stuff: " + filename_string);
            //System.out.println("Stuff: " + location_string );
            String numberpat = "[0-9]+";
            Pattern number_pattern = Pattern.compile(numberpat);
            Matcher number_matcher = number_pattern.matcher(keyword_string);

            number_matcher.find();
            String num = (number_matcher.group()).trim();
            int n = Integer.valueOf(num).intValue();
            //System.out.println("Stuff: " + n );


            String location = (location_string.trim()).toLowerCase();
            String external_links_filename = filename_string;
            String hash_string = external_links_filename + " " + location;

            if (els_hash.containsKey(hash_string)) {
                els = (ExternalLinkSet) els_hash.get(hash_string);
            //System.out.println("ELS retrieved from hash");
            } else {
                els = new ExternalLinkSet(ks, external_links_filename, location);
                els_hash.put(els.hashString(), els);
            //System.out.println("ELS not in hash");
            }

            String linkString = new String(els.getLinksString(n));


            copy_of_data =
                    m2.replaceFirst(fixSlash(linkString));
            m2.reset(copy_of_data);
        }

        return copy_of_data;


    }

    public static String processExternalFootLinks(String data, KeySet ks, Hashtable els_hash) {

        String copy_of_data = new String(data);

        ExternalLinkSet els;

        String pattern = "(?i)\\{[\\p{Blank}]*EXTERNFOOTLINKS[^\\}]+\\}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(copy_of_data);


        while (m.find()) {




            String stuff = m.group();
            stuff =
                    stuff.substring(1, stuff.length() - 1);
            stuff =
                    stuff.trim();
            String keyword_string = (stuff.substring(0, stuff.indexOf(','))).trim();
            String filename_string = (stuff.substring(stuff.indexOf(',') + 1, stuff.indexOf(',', stuff.indexOf(',') + 1))).trim();
            String location_string = ((stuff.substring(stuff.lastIndexOf(',') + 1, stuff.length())).trim()).toLowerCase();
            //System.out.println("Stuff from extern links");
            //System.out.println("Stuff: " + stuff);
            //System.out.println("Stuff: " + keyword_string);
            //System.out.println("Stuff: " + filename_string);
            //System.out.println("Stuff: " + location_string );

            String location = (location_string.trim()).toLowerCase();
            String external_links_filename = filename_string;
            String hash_string = external_links_filename + " " + location;

            if (els_hash.containsKey(hash_string)) {
                els = (ExternalLinkSet) els_hash.get(hash_string);
            //System.out.println("ELS retrieved from hash");
            } else {
                els = new ExternalLinkSet(ks, external_links_filename, location);
                els_hash.put(els.hashString(), els);
            //System.out.println("ELS not in hash");
            }

            String linkString = new String(els.getFootLinksString(0));
            copy_of_data =
                    m.replaceFirst(fixSlash(linkString));
            m.reset(copy_of_data);


        }

        String pattern_with_numbers = "(?i)\\{[\\p{Blank}]*[0-9]+[\\p{Blank}]*EXTERNFOOTLINKS[^\\}]+\\}";
        Pattern pattern2 = Pattern.compile(pattern_with_numbers);
        Matcher m2 = pattern2.matcher(copy_of_data);
        while (m2.find()) {

            String stuff = m2.group();
            stuff =
                    stuff.substring(1, stuff.length() - 1);
            stuff =
                    stuff.trim();
            String keyword_string = (stuff.substring(0, stuff.indexOf(','))).trim();
            String filename_string = (stuff.substring(stuff.indexOf(',') + 1, stuff.indexOf(',', stuff.indexOf(',') + 1))).trim();
            String location_string = ((stuff.substring(stuff.lastIndexOf(',') + 1, stuff.length())).trim()).toLowerCase();
            //System.out.println("Stuff from number extern links");
            //System.out.println("Stuff: " + stuff);
            //System.out.println("Stuff: " + keyword_string);
            //System.out.println("Stuff: " + filename_string);
            //System.out.println("Stuff: " + location_string );
            String numberpat = "[0-9]+";
            Pattern number_pattern = Pattern.compile(numberpat);
            Matcher number_matcher = number_pattern.matcher(keyword_string);

            number_matcher.find();
            String num = (number_matcher.group()).trim();
            int n = Integer.valueOf(num).intValue();
            //System.out.println("Stuff: " + n );


            String location = (location_string.trim()).toLowerCase();
            String external_links_filename = filename_string;
            String hash_string = external_links_filename + " " + location;

            if (els_hash.containsKey(hash_string)) {
                els = (ExternalLinkSet) els_hash.get(hash_string);
            //System.out.println("ELS retrieved from hash");
            } else {
                els = new ExternalLinkSet(ks, external_links_filename, location);
                els_hash.put(els.hashString(), els);
            //System.out.println("ELS not in hash");
            }

            String linkString = new String(els.getFootLinksString(n));


            copy_of_data =
                    m2.replaceFirst(fixSlash(linkString));
            m2.reset(copy_of_data);
        }

        return copy_of_data;


    }

    public static String processExternalHeadLinks(String data, KeySet ks, Hashtable els_hash) {

        String copy_of_data = new String(data);

        ExternalLinkSet els;

        String pattern = "(?i)\\{[\\p{Blank}]*EXTERNHEADLINKS[^\\}]+\\}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(copy_of_data);


        while (m.find()) {




            String stuff = m.group();
            stuff =
                    stuff.substring(1, stuff.length() - 1);
            stuff =
                    stuff.trim();
            String keyword_string = (stuff.substring(0, stuff.indexOf(','))).trim();
            String filename_string = (stuff.substring(stuff.indexOf(',') + 1, stuff.indexOf(',', stuff.indexOf(',') + 1))).trim();
            String location_string = ((stuff.substring(stuff.lastIndexOf(',') + 1, stuff.length())).trim()).toLowerCase();
            //System.out.println("Stuff from extern links");
            //System.out.println("Stuff: " + stuff);
            //System.out.println("Stuff: " + keyword_string);
            //System.out.println("Stuff: " + filename_string);
            //System.out.println("Stuff: " + location_string );

            String location = (location_string.trim()).toLowerCase();
            String external_links_filename = filename_string;
            String hash_string = external_links_filename + " " + location;

            if (els_hash.containsKey(hash_string)) {
                els = (ExternalLinkSet) els_hash.get(hash_string);
                System.out.println("ELS retrieved from hash");
            } else {
                els = new ExternalLinkSet(ks, external_links_filename, location);
                els_hash.put(els.hashString(), els);
                System.out.println("ELS not in hash");
            }

            String linkString = new String(els.getHeadLinksString(0));
            copy_of_data =
                    m.replaceFirst(fixSlash(linkString));
            m.reset(copy_of_data);


        }

        String pattern_with_numbers = "(?i)\\{[\\p{Blank}]*[0-9]+[\\p{Blank}]*EXTERNHEADLINKS[^\\}]+\\}";
        Pattern pattern2 = Pattern.compile(pattern_with_numbers);
        Matcher m2 = pattern2.matcher(copy_of_data);
        while (m2.find()) {

            String stuff = m2.group();
            stuff =
                    stuff.substring(1, stuff.length() - 1);
            stuff =
                    stuff.trim();
            String keyword_string = (stuff.substring(0, stuff.indexOf(','))).trim();
            String filename_string = (stuff.substring(stuff.indexOf(',') + 1, stuff.indexOf(',', stuff.indexOf(',') + 1))).trim();
            String location_string = ((stuff.substring(stuff.lastIndexOf(',') + 1, stuff.length())).trim()).toLowerCase();
            //System.out.println("Stuff from number extern links");
            //System.out.println("Stuff: " + stuff);
            //System.out.println("Stuff: " + keyword_string);
            //System.out.println("Stuff: " + filename_string);
            //System.out.println("Stuff: " + location_string );
            String numberpat = "[0-9]+";
            Pattern number_pattern = Pattern.compile(numberpat);
            Matcher number_matcher = number_pattern.matcher(keyword_string);

            number_matcher.find();
            String num = (number_matcher.group()).trim();
            int n = Integer.valueOf(num).intValue();
            //System.out.println("Stuff: " + n );


            String location = (location_string.trim()).toLowerCase();
            String external_links_filename = filename_string;
            String hash_string = external_links_filename + " " + location;

            if (els_hash.containsKey(hash_string)) {
                els = (ExternalLinkSet) els_hash.get(hash_string);
                System.out.println("ELS retrieved from hash");
            } else {
                els = new ExternalLinkSet(ks, external_links_filename, location);
                els_hash.put(els.hashString(), els);
                System.out.println("ELS not in hash");
            }

            String linkString = new String(els.getHeadLinksString(n));


            copy_of_data =
                    m2.replaceFirst(fixSlash(linkString));
            m2.reset(copy_of_data);
        }

        return copy_of_data;


    }

    public static String processExternalAlphaLinks(String data, KeySet ks, Hashtable els_hash) {

        String copy_of_data = new String(data);

        ExternalLinkSet els;

        String pattern = "(?i)\\{[\\p{Blank}]*EXTERNALPHALINKS[^\\}]+\\}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(copy_of_data);


        while (m.find()) {




            String stuff = m.group();
            stuff =
                    stuff.substring(1, stuff.length() - 1);
            stuff =
                    stuff.trim();
            String keyword_string = (stuff.substring(0, stuff.indexOf(','))).trim();
            String filename_string = (stuff.substring(stuff.indexOf(',') + 1, stuff.indexOf(',', stuff.indexOf(',') + 1))).trim();
            String location_string = ((stuff.substring(stuff.lastIndexOf(',') + 1, stuff.length())).trim()).toLowerCase();
            //System.out.println("Stuff from extern links");
            //System.out.println("Stuff: " + stuff);
            //System.out.println("Stuff: " + keyword_string);
            //System.out.println("Stuff: " + filename_string);
            //System.out.println("Stuff: " + location_string );

            String location = (location_string.trim()).toLowerCase();
            String external_links_filename = filename_string;
            String hash_string = external_links_filename + " " + location;

            if (els_hash.containsKey(hash_string)) {
                els = (ExternalLinkSet) els_hash.get(hash_string);
            //System.out.println("ELS retrieved from hash");
            } else {
                els = new ExternalLinkSet(ks, external_links_filename, location);
                els_hash.put(els.hashString(), els);
            //System.out.println("ELS not in hash");
            }

            String linkString = new String(els.getAlphaLinksString(0));
            copy_of_data =
                    m.replaceFirst(fixSlash(linkString));
            m.reset(copy_of_data);


        }

        String pattern_with_numbers = "(?i)\\{[\\p{Blank}]*[0-9]+[\\p{Blank}]*EXTERNALPHALINKS[^\\}]+\\}";
        Pattern pattern2 = Pattern.compile(pattern_with_numbers);
        Matcher m2 = pattern2.matcher(copy_of_data);
        while (m2.find()) {

            String stuff = m2.group();
            stuff =
                    stuff.substring(1, stuff.length() - 1);
            stuff =
                    stuff.trim();
            String keyword_string = (stuff.substring(0, stuff.indexOf(','))).trim();
            String filename_string = (stuff.substring(stuff.indexOf(',') + 1, stuff.indexOf(',', stuff.indexOf(',') + 1))).trim();
            String location_string = ((stuff.substring(stuff.lastIndexOf(',') + 1, stuff.length())).trim()).toLowerCase();
            //System.out.println("Stuff from number extern links");
            ///System.out.println("Stuff: " + stuff);
            //System.out.println("Stuff: " + keyword_string);
            //System.out.println("Stuff: " + filename_string);
            //System.out.println("Stuff: " + location_string );
            String numberpat = "[0-9]+";
            Pattern number_pattern = Pattern.compile(numberpat);
            Matcher number_matcher = number_pattern.matcher(keyword_string);

            number_matcher.find();
            String num = (number_matcher.group()).trim();
            int n = Integer.valueOf(num).intValue();
            //System.out.println("Stuff: " + n );


            String location = (location_string.trim()).toLowerCase();
            String external_links_filename = filename_string;
            String hash_string = external_links_filename + " " + location;

            if (els_hash.containsKey(hash_string)) {
                els = (ExternalLinkSet) els_hash.get(hash_string);
            //	System.out.println("ELS retrieved from hash");
            } else {
                els = new ExternalLinkSet(ks, external_links_filename, location);
                els_hash.put(els.hashString(), els);
            //	System.out.println("ELS not in hash");
            }

            String linkString = new String(els.getAlphaLinksString(n));


            copy_of_data =
                    m2.replaceFirst(fixSlash(linkString));
            m2.reset(copy_of_data);
        }

        return copy_of_data;


    }

    public static String processExternalAlphaFootLinks(String data, KeySet ks, Hashtable els_hash) {

        String copy_of_data = new String(data);

        ExternalLinkSet els;

        String pattern = "(?i)\\{[\\p{Blank}]*EXTERNALPHAFOOTLINKS[^\\}]+\\}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(copy_of_data);


        while (m.find()) {




            String stuff = m.group();
            stuff =
                    stuff.substring(1, stuff.length() - 1);
            stuff =
                    stuff.trim();
            String keyword_string = (stuff.substring(0, stuff.indexOf(','))).trim();
            String filename_string = (stuff.substring(stuff.indexOf(',') + 1, stuff.indexOf(',', stuff.indexOf(',') + 1))).trim();
            String location_string = ((stuff.substring(stuff.lastIndexOf(',') + 1, stuff.length())).trim()).toLowerCase();
            //System.out.println("Stuff from extern links");
            //System.out.println("Stuff: " + stuff);
            //System.out.println("Stuff: " + keyword_string);
            //System.out.println("Stuff: " + filename_string);
            //System.out.println("Stuff: " + location_string );

            String location = (location_string.trim()).toLowerCase();
            String external_links_filename = filename_string;
            String hash_string = external_links_filename + " " + location;

            if (els_hash.containsKey(hash_string)) {
                els = (ExternalLinkSet) els_hash.get(hash_string);
            //	System.out.println("ELS retrieved from hash");
            } else {
                els = new ExternalLinkSet(ks, external_links_filename, location);
                els_hash.put(els.hashString(), els);
            //	System.out.println("ELS not in hash");
            }

            String linkString = new String(els.getAlphaFootLinksString(0));
            copy_of_data =
                    m.replaceFirst(fixSlash(linkString));
            m.reset(copy_of_data);


        }

        String pattern_with_numbers = "(?i)\\{[\\p{Blank}]*[0-9]+[\\p{Blank}]*EXTERNALPHAFOOTLINKS[^\\}]+\\}";
        Pattern pattern2 = Pattern.compile(pattern_with_numbers);
        Matcher m2 = pattern2.matcher(copy_of_data);
        while (m2.find()) {

            String stuff = m2.group();
            stuff =
                    stuff.substring(1, stuff.length() - 1);
            stuff =
                    stuff.trim();
            String keyword_string = (stuff.substring(0, stuff.indexOf(','))).trim();
            String filename_string = (stuff.substring(stuff.indexOf(',') + 1, stuff.indexOf(',', stuff.indexOf(',') + 1))).trim();
            String location_string = ((stuff.substring(stuff.lastIndexOf(',') + 1, stuff.length())).trim()).toLowerCase();
            //System.out.println("Stuff from number extern links");
            //System.out.println("Stuff: " + stuff);
            //System.out.println("Stuff: " + keyword_string);
            //System.out.println("Stuff: " + filename_string);
            ///System.out.println("Stuff: " + location_string );
            String numberpat = "[0-9]+";
            Pattern number_pattern = Pattern.compile(numberpat);
            Matcher number_matcher = number_pattern.matcher(keyword_string);

            number_matcher.find();
            String num = (number_matcher.group()).trim();
            int n = Integer.valueOf(num).intValue();
            //System.out.println("Stuff: " + n );


            String location = (location_string.trim()).toLowerCase();
            String external_links_filename = filename_string;
            String hash_string = external_links_filename + " " + location;

            if (els_hash.containsKey(hash_string)) {
                els = (ExternalLinkSet) els_hash.get(hash_string);
            //System.out.println("ELS retrieved from hash");
            } else {
                els = new ExternalLinkSet(ks, external_links_filename, location);
                els_hash.put(els.hashString(), els);
            //System.out.println("ELS not in hash");
            }

            String linkString = new String(els.getAlphaFootLinksString(n));


            copy_of_data =
                    m2.replaceFirst(fixSlash(linkString));
            m2.reset(copy_of_data);
        }

        return copy_of_data;


    }

    public static String processExternalAlphaHeadLinks(String data, KeySet ks, Hashtable els_hash) {

        String copy_of_data = new String(data);

        ExternalLinkSet els;

        String pattern = "(?i)\\{[\\p{Blank}]*EXTERNALPHAHEADLINKS[^\\}]+\\}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(copy_of_data);


        while (m.find()) {




            String stuff = m.group();
            stuff =
                    stuff.substring(1, stuff.length() - 1);
            stuff =
                    stuff.trim();
            String keyword_string = (stuff.substring(0, stuff.indexOf(','))).trim();
            String filename_string = (stuff.substring(stuff.indexOf(',') + 1, stuff.indexOf(',', stuff.indexOf(',') + 1))).trim();
            String location_string = ((stuff.substring(stuff.lastIndexOf(',') + 1, stuff.length())).trim()).toLowerCase();
            //System.out.println("Stuff from extern links");
            //System.out.println("Stuff: " + stuff);
            //System.out.println("Stuff: " + keyword_string);
            //System.out.println("Stuff: " + filename_string);
            //System.out.println("Stuff: " + location_string );

            String location = (location_string.trim()).toLowerCase();
            String external_links_filename = filename_string;
            String hash_string = external_links_filename + " " + location;

            if (els_hash.containsKey(hash_string)) {
                els = (ExternalLinkSet) els_hash.get(hash_string);
            //System.out.println("ELS retrieved from hash");
            } else {
                els = new ExternalLinkSet(ks, external_links_filename, location);
                els_hash.put(els.hashString(), els);
            //System.out.println("ELS not in hash");
            }

            String linkString = new String(els.getAlphaHeadLinksString(0));
            copy_of_data =
                    m.replaceFirst(fixSlash(linkString));
            m.reset(copy_of_data);


        }

        String pattern_with_numbers = "(?i)\\{[\\p{Blank}]*[0-9]+[\\p{Blank}]*EXTERNALPHAHEADLINKS[^\\}]+\\}";
        Pattern pattern2 = Pattern.compile(pattern_with_numbers);
        Matcher m2 = pattern2.matcher(copy_of_data);
        while (m2.find()) {

            String stuff = m2.group();
            stuff =
                    stuff.substring(1, stuff.length() - 1);
            stuff =
                    stuff.trim();
            String keyword_string = (stuff.substring(0, stuff.indexOf(','))).trim();
            String filename_string = (stuff.substring(stuff.indexOf(',') + 1, stuff.indexOf(',', stuff.indexOf(',') + 1))).trim();
            String location_string = ((stuff.substring(stuff.lastIndexOf(',') + 1, stuff.length())).trim()).toLowerCase();
            //System.out.println("Stuff from number extern links");
            //System.out.println("Stuff: " + stuff);
            //System.out.println("Stuff: " + keyword_string);
            //System.out.println("Stuff: " + filename_string);
            //	System.out.println("Stuff: " + location_string );
            String numberpat = "[0-9]+";
            Pattern number_pattern = Pattern.compile(numberpat);
            Matcher number_matcher = number_pattern.matcher(keyword_string);

            number_matcher.find();
            String num = (number_matcher.group()).trim();
            int n = Integer.valueOf(num).intValue();
            //System.out.println("Stuff: " + n );


            String location = (location_string.trim()).toLowerCase();
            String external_links_filename = filename_string;
            String hash_string = external_links_filename + " " + location;

            if (els_hash.containsKey(hash_string)) {
                els = (ExternalLinkSet) els_hash.get(hash_string);
            //System.out.println("ELS retrieved from hash");
            } else {
                els = new ExternalLinkSet(ks, external_links_filename, location);
                els_hash.put(els.hashString(), els);
            //System.out.println("ELS not in hash");
            }

            String linkString = new String(els.getAlphaHeadLinksString(n));


            copy_of_data =
                    m2.replaceFirst(fixSlash(linkString));
            m2.reset(copy_of_data);
        }

        return copy_of_data;


    }

    public static String fixSlash(String string) {
        //System.out.println("in : " + string);
        String pattern2 = "\\\\";
        String replacement = pattern2 + pattern2;
        Pattern r2 = Pattern.compile(pattern2);
        Matcher m2 = r2.matcher(string);
        String fixed = m2.replaceAll(replacement);
        //System.out.println("out : " + fixed);
        return fixed;

    }

    static public class Preprocessor {

        public static void printSettings() {

            //it's set to: raw tickets with no date, default case in if-else chain (meaning the else case)
            String type = "rt";
            String settings_filename = "preprocess.ini";
            String tickets_string = "Tickets";
            int keyProcessingMethod = 1;
            int raw_cols = 0;
            String delimiter = ",";
            int rows_to_skip = 0;
            String url = "";
            String url_extension = "asp";
            boolean fixDuplicates = false;

            try {

                BufferedReader in = new BufferedReader(new FileReader(settings_filename));
                raw_cols = Integer.parseInt(((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim()), 10);
                delimiter = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                type = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                rows_to_skip = Integer.parseInt(((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim()), 10);
                url = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                url_extension = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                tickets_string = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                keyProcessingMethod = Integer.parseInt(((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim()), 10);
                fixDuplicates = Boolean.valueOf((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim());
                in.close();
            } catch (IOException e) {
                System.out.println("Error reading in preprocessor settings file: " + e);

            }

            rows_to_skip = 0;


            ///check the arguments

            System.out.println("settings_filename: " + settings_filename);
            System.out.println("cols: " + raw_cols);
            System.out.println("delimiter: " + delimiter);
            System.out.println("type: " + type);
            System.out.println("num lines to skip: " + rows_to_skip);
            System.out.println("url: " + url);
            System.out.println("url extension: " + url_extension);
            System.out.println("tickets string: " + tickets_string);
            System.out.println("Key Processing method: " + keyProcessingMethod);
            System.out.println("Fix Duplicate Filenames: " + fixDuplicates);
            return;



        }

        public String[][] processEvents(String[][] input_keys, String space, String _url) throws Exception {

            String[][] keys;
            try {
                //row is the number of key vectors and cols = number of cols in output file, currently raw_cols + 2
                int rows = input_keys.length;
                if (rows == 0) {
                    throw new Exception("0 rows in keyset object passed to preprocessor!!  Serious Error");
                }
                int raw_cols = input_keys[0].length;
                if (raw_cols == 0) {
                    throw new Exception("0 cols in keyset object passed to preprocessor!!  Serious Error");
                }
                int cols = raw_cols + 2;
                keys = new String[rows][cols];
                filename_title_col = cols - 3;
                //set the default type of processing output for col 0 of output file
                //it's set to: raw tickets with no date, default case in if-else chain (meaning the else case)
                String type = "rt";
                String settings_filename = "preprocess.ini";
                String tickets_string = "Tickets";
                int keyProcessingMethod = 1;

                String delimiter = ",";
                int rows_to_skip = 0;
                String url;
                String url_extension = "asp";
                boolean fixDuplicates = false;
                String[] raw_dates;
                try {

                    BufferedReader in = new BufferedReader(new FileReader(settings_filename));
                    raw_cols = Integer.parseInt(((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim()), 10);
                    delimiter = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    type = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    rows_to_skip = Integer.parseInt(((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim()), 10);
                    url = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    url_extension = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    tickets_string = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    keyProcessingMethod = Integer.parseInt(((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim()), 10);
                    fixDuplicates = Boolean.valueOf((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim());
                    in.close();
                } catch (IOException e) {
                    System.out.println("Error reading in event preprocessor settings file: " + e);
                    return (String[][]) null;
                }

                rows_to_skip = 0;
                raw_cols = input_keys[0].length;

                ///check the arguments
                /*
                System.out.println("Preprocessor arguments:");
                System.out.println("settings_filename: " + settings_filename);
                System.out.println("cols: " + raw_cols);
                System.out.println("delimiter: " + delimiter);
                System.out.println("type: " + type);
                System.out.println("num lines to skip: " + rows_to_skip);
                System.out.println("url: " + url);
                System.out.println("url extension: " + url_extension);
                System.out.println("tickets string: " + tickets_string);
                System.out.println("Key Processing method: " + keyProcessingMethod);
                 */

                //setup some variables

                int i, j;



                //set up the "space" finder
                Pattern space_pattern = Pattern.compile("[\\p{Space}]+[\\s]*");
                Matcher space_matcher = space_pattern.matcher(" ");
                raw_dates = new String[rows];
                i = 0;
                while (i < rows) {
                    j = 0;
                    while (j < raw_cols) {
                        keys[i][j] = input_keys[i][j];
                        //System.out.println("raw key " + i + " " + j + " : " + keys[i][j]);
                        j++;
                    }
                    raw_dates[i] = "";
                    i++;
                }

                i = 0;
                while (i < rows) {
                    j = 0;
                    while (j < cols) {
                        if (keys[i][j] == null) {
                            keys[i][j] = "";
                        }
                        keys[i][j] = processRawKey(keys[i][j], keyProcessingMethod);
                        //System.out.println("in key " + i + " " + j + " : " + keys[i][j]);
                        j++;
                    }
                    i++;
                }



                //we have the raw data in the same col order and number as in the raw input file (thereforew
                // the last 2 cols are empty since they did not exist in the input file)
                //now we modify it...
                String raw_date = "date";
                int k;
                k = 0;
                while (k < rows) {

                    //move the event id to the last col
                    keys[k][cols - 1] = new String(keys[k][0]);
                    //move the Y/N col to second to last
                    keys[k][cols - 2] = new String(keys[k][6]);
                    //change the url extension in the raw col
                    keys[k][cols - 3] = new String((keys[k][7]).replaceFirst("aspx", url_extension));
                    keys[k][cols - 3] = (keys[k][cols - 3]).replaceFirst("www.bestshowticketslasvegas.com", url);

                    //set up the title and time/date cols for further processing
                    keys[k][6] = new String(keys[k][5]);
                    keys[k][0] = new String(keys[k][1]);

                    String date_time = new String(keys[k][5]);
                    //fix time/date here
                    raw_date = "date";
                    try {


                        if (!date_time.contains("TBA")) {
                            String date_pattern_str = "[0-9]+/[0-9]+/[0-9]+";
                            String time_pattern_str = "[0-9]+:[0-9]+";

                            Pattern date_pattern = Pattern.compile(date_pattern_str);
                            Pattern time_pattern = Pattern.compile(time_pattern_str);

                            Matcher date_matcher = date_pattern.matcher(date_time);
                            Matcher time_matcher = time_pattern.matcher(date_time);

                            date_matcher.find();
                            time_matcher.find();

                            raw_date = date_matcher.group();
                            String raw_time = time_matcher.group();
                            String date[] = raw_date.split("/");
                            String time[] = raw_time.split(":");
                            String time_string = "";
                            String date_string = "";
                            String am_or_pm = "";

                            int hour = Integer.parseInt(time[0].trim(), 10);
                            int min = Integer.parseInt(time[1].trim(), 10);
                            int month = Integer.parseInt(date[0].trim(), 10);
                            int day = Integer.parseInt(date[1].trim(), 10);
                            int year = Integer.parseInt(date[2].trim(), 10);


                            String month_string = " ";
                            switch (month) {
                                case 1:
                                    month_string = "January";
                                    break;
                                case 2:
                                    month_string = "February";
                                    break;
                                case 3:
                                    month_string = "March";
                                    break;
                                case 4:
                                    month_string = "April";
                                    break;
                                case 5:
                                    month_string = "May";
                                    break;
                                case 6:
                                    month_string = "June";
                                    break;
                                case 7:
                                    month_string = "July";
                                    break;
                                case 8:
                                    month_string = "August";
                                    break;
                                case 9:
                                    month_string = "September";
                                    break;
                                case 10:
                                    month_string = "October";
                                    break;
                                case 11:
                                    month_string = "November";
                                    break;
                                case 12:
                                    month_string = "December";
                                    break;
                                default:
                                    month_string = "Invalid month.";
                                    break;
                            }



                            if (date_time.contains("AM")) {
                                am_or_pm = "a.m.";
                                if (min > 9) {
                                    time_string = hour + ":" + min + " " + am_or_pm;
                                } else {
                                    time_string = hour + ":0" + min + " " + am_or_pm;
                                }
                            } else if (date_time.contains("PM")) {
                                am_or_pm = "p.m.";
                                if (min > 9) {
                                    time_string = hour + ":" + min + " " + am_or_pm;
                                } else {
                                    time_string = hour + ":0" + min + " " + am_or_pm;
                                }

                            } else {
                                time_string = "unknown";
                            }


                            date_string = month_string + " " + day + ", " + year;
                            if (time_string.equalsIgnoreCase("3:00 a.m.") || time_string.equalsIgnoreCase("3:30 a.m.")) {

                                time_string = "TBA";
                            //System.out.println("**GOT A 3am TBA**");

                            }
                            keys[k][5] = new String(date_string);
                            keys[k][6] = new String(time_string);
                        } else {

                            String date_pattern_str = "[0-9]+/[0-9]+/[0-9]+";


                            Pattern date_pattern = Pattern.compile(date_pattern_str);


                            Matcher date_matcher = date_pattern.matcher(date_time);


                            date_matcher.find();


                            raw_date = date_matcher.group();

                            String date[] = raw_date.split("/");

                            String time_string = "TBA";
                            String date_string = "";

                            int month = Integer.parseInt(date[0].trim(), 10);
                            int day = Integer.parseInt(date[1].trim(), 10);
                            int year = Integer.parseInt(date[2].trim(), 10);

                            String month_string = " ";
                            switch (month) {
                                case 1:
                                    month_string = "January";
                                    break;
                                case 2:
                                    month_string = "February";
                                    break;
                                case 3:
                                    month_string = "March";
                                    break;
                                case 4:
                                    month_string = "April";
                                    break;
                                case 5:
                                    month_string = "May";
                                    break;
                                case 6:
                                    month_string = "June";
                                    break;
                                case 7:
                                    month_string = "July";
                                    break;
                                case 8:
                                    month_string = "August";
                                    break;
                                case 9:
                                    month_string = "September";
                                    break;
                                case 10:
                                    month_string = "October";
                                    break;
                                case 11:
                                    month_string = "November";
                                    break;
                                case 12:
                                    month_string = "December";
                                    break;
                                default:
                                    month_string = "Invalid month.";
                                    break;
                            }




                            //System.out.println("**GOT A TBA**");
                            date_string = month_string + " " + day + ", " + year;

                            keys[k][5] = new String(date_string);
                            keys[k][6] = new String(time_string);



                        }



                    } catch (Exception e) {

                        System.out.println("something went wrong while taking care of the date-time " + e);
                        System.out.println("info:  " + keys[k][0] + " " + keys[k][5]);
                        System.out.println("Using returned date-time");
                        keys[k][5] = date_time;
                        keys[k][6] = "";


                    }

                    //type determines contents of the first, 0 indexed, column
                    //s = sports tickets no date
                    //sd is sports tickets + date
                    //t = theatre tickets
                    //td theatre tickets + date
                    //c = concert tickets
                    //cd = concert tickets + date
                    // r = raw
                    // rd = raw with date
                    // rtd = raw tickets + date
                    // no type specified is raw tickets 
                    String date_spacer = " ";

                    keys[k][filename_title_col] = keys[k][0];
                    raw_date = replaceStringWithString(raw_date, "/", "-");
                    raw_date = replaceSpaces(raw_date, "-");
                    if (fixDuplicates) {
                        raw_dates[k] = raw_date;
                    }
                    if (type.compareTo("r") == 0) {
                        keys[k][0] = keys[k][0];
                    } else if (type.compareTo("rtd") == 0) {
                        keys[k][0] = keys[k][0] + " " + tickets_string;
                    } else if (type.compareTo("s") == 0) {
                        keys[k][0] = processTeamName(keys[k][0]) + " " + tickets_string;
                    } else if (type.compareTo("c") == 0) {
                        keys[k][0] = keys[k][0] + " " + keys[k][3] + " " + tickets_string;
                    } else if (type.compareTo("t") == 0) {
                        keys[k][0] = keys[k][0] + " " + keys[k][3] + " " + tickets_string;
                    } else if (type.compareTo("sd") == 0) {

                        keys[k][0] = processTeamName(keys[k][0]) + " " + tickets_string + date_spacer + replaceSpaces(raw_date, "-");
                    } else if (type.compareTo("cd") == 0) {
                        keys[k][0] = keys[k][0] + " " + keys[k][3] + " " + tickets_string + date_spacer + replaceSpaces(raw_date, "-");
                    } else if (type.compareTo("td") == 0) {
                        keys[k][0] = keys[k][0] + " " + keys[k][3] + " " + tickets_string + date_spacer + replaceSpaces(raw_date, "-");
                    } else //raw name with Tickets appended.
                    {
                        keys[k][0] = keys[k][0] + " " + tickets_string;
                    }


                    if (space.compareTo("") == 0 || space.compareTo(" ") == 0) {
                        date_spacer = "-";
                    }

                    if (type.compareTo("r") == 0) {
                        keys[k][filename_title_col] = keys[k][filename_title_col];
                    } else if (type.compareTo("rtd") == 0) {
                        keys[k][filename_title_col] = keys[k][filename_title_col] + " " + tickets_string;
                    } else if (type.compareTo("s") == 0) {
                        keys[k][filename_title_col] = processTeamName(keys[k][filename_title_col]) + " " + tickets_string;
                    } else if (type.compareTo("c") == 0) {
                        keys[k][filename_title_col] = keys[k][filename_title_col] + " " + keys[k][3] + " " + tickets_string;
                    } else if (type.compareTo("t") == 0) {
                        keys[k][filename_title_col] = keys[k][filename_title_col] + " " + keys[k][3] + " " + tickets_string;
                    } else if (type.compareTo("sd") == 0) {

                        keys[k][filename_title_col] = processTeamName(keys[k][filename_title_col]) + " " + tickets_string + date_spacer + replaceSpaces(raw_date, "-");
                    } else if (type.compareTo("cd") == 0) {
                        keys[k][filename_title_col] = keys[k][filename_title_col] + " " + keys[k][3] + " " + tickets_string + date_spacer + replaceSpaces(raw_date, "-");
                    } else if (type.compareTo("td") == 0) {
                        keys[k][filename_title_col] = keys[k][filename_title_col] + " " + keys[k][3] + " " + tickets_string + date_spacer + replaceSpaces(raw_date, "-");
                    } else //raw name with Tickets appended.
                    {
                        keys[k][filename_title_col] = keys[k][filename_title_col] + " " + tickets_string;
                    }


                    //and now we reorder some of them
                    //we want
                   /* 1 venue
                     * 2 city
                     * 3 state
                     */
                    String temp_name = keys[k][1];
                    keys[k][1] = keys[k][2];
                    keys[k][2] = keys[k][3];
                    keys[k][3] = keys[k][4];
                    keys[k][4] = temp_name;
                    dirname_title_col = 4;


                    k++;

                }

                try {
                    if (fixDuplicates) {
                        i = 0;
                        while (i < keys.length) {
                            j = i;
                            while (j < keys.length) {
                                if ((i != j) && keys[i][0].equalsIgnoreCase(keys[j][0])) {
                                    keys = dropKey(j, keys);

                                    keys[i][5] = "";
                                    keys[i][6] = "";
                                    keys[i][7] = _url + resultsGeneralReplacement + replaceSpaces(keys[i][4], "%20");

                                } else {
                                    j++;
                                }
                            }
                            i++;
                        }
                    } //end of fix duplicates
                } catch (Exception e) {

                    System.out.println("something went wrong while fixing dups: " + e);

                }
            /*
            if (fixDuplicates) {
            i = 0;
            j = 0;
            boolean[] hasAMatch = new boolean[rows];
            while (i < rows) {
            hasAMatch[i] = false;
            i++;
            }
            i = 0;
            while (i < rows) {
            j = 0;
            while (j < rows) {
            if ((i != j) && keys[i][0].equalsIgnoreCase(keys[j][0])) {
            hasAMatch[i] = true;
            hasAMatch[j] = true;
            }
            j++;
            }
            i++;
            }
            i = 0;
            while (i < rows) {
            if (hasAMatch[i]) {
            //  old way: add date - but we want to eliminate dups
            //String date_spacer = " ";
            //keys[i][0] = keys[i][0] + date_spacer + raw_dates[i];
            //if (space.compareTo("") == 0 || space.compareTo(" ") == 0) {
            //date_spacer = "-";
            // }
            //keys[i][filename_title_col] = keys[i][filename_title_col] + date_spacer + raw_dates[i];
            //keys[i][6] = url + "/ResultsTicket.asp?event="+keys[i][4];
            //keys[i][12] = url + "/ResultsTicket.asp?event="+keys[i][4];
            keys[i][5] = "";
            keys[i][6] = "";
            keys[i][7] = _url + resultsGeneralReplacement + replaceSpaces(keys[i][4], "%20");
            }
            i++;
            }
            } //end of fixDuplicates
             */
            /*
            i = 0;
            while (i < rows) {
            j = 0;
            while (j < cols) {
            System.out.println("out key " + i + " " + j + " : " + keys[i][j]);
            j++;
            }
            i++;
            }
             */

            } catch (Exception e) {
                System.out.println("something went wrong in event preprocess " + e);
                return (String[][]) null;
            }

            return keys;
        }

        public String[][] processVenues(String[][] input_keys, String space, String _url) throws Exception {

            String[][] keys;
            try {

                int rows = input_keys.length;
                if (rows == 0) {
                    throw new Exception("0 rows in keyset object passed to venue preprocessor!!  Serious Error");
                }
                int raw_cols = input_keys[0].length;
                if (raw_cols == 0) {
                    throw new Exception("0 cols in keyset object passed to venue preprocessor!!  Serious Error");
                }
                int cols = raw_cols;
                keys = new String[rows][cols];

                String type = "rt";
                String settings_filename = "preprocess.ini";
                String tickets_string = "Tickets";
                int keyProcessingMethod = 1;
                String delimiter = ",";
                int rows_to_skip = 0;
                String url;
                String url_extension = "asp";
                boolean fixDuplicates = false;
                String[] raw_dates;
                try {

                    BufferedReader in = new BufferedReader(new FileReader(settings_filename));
                    raw_cols = Integer.parseInt(((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim()), 10);
                    delimiter = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    type = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    rows_to_skip = Integer.parseInt(((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim()), 10);
                    url = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    url_extension = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    tickets_string = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    keyProcessingMethod = Integer.parseInt(((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim()), 10);
                    fixDuplicates = Boolean.valueOf((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim());
                    in.close();
                } catch (IOException e) {
                    System.out.println("Error reading in preprocessor settings file: " + e);
                    return (String[][]) null;
                }
                raw_cols = input_keys[0].length;
                rows_to_skip = 0;



                int i, j;
                i = 0;
                while (i < rows) {
                    j = 0;
                    while (j < cols) {
                        if (j > 0) {
                            keys[i][j] = input_keys[i][j];
                        } else {
                            keys[i][j] = input_keys[i][j] + " " + tickets_string;
                        }

                        j++;
                    }

                    i++;
                }

            } catch (Exception e) {
                System.out.println("something went wrong in venues preprocessing " + e);
                return (String[][]) null;
            }

            return keys;
        }

        public String[][] processPerformers(String[][] input_keys, String space, String _url) throws Exception {

            String[][] keys;
            try {

                int rows = input_keys.length;
                if (rows == 0) {
                    throw new Exception("0 rows in keyset object passed to performer preprocessor!!  Serious Error");
                }
                int raw_cols = input_keys[0].length;
                if (raw_cols == 0) {
                    throw new Exception("0 cols in keyset object passed to performer preprocessor!!  Serious Error");
                }
                int cols = raw_cols;
                keys = new String[rows][cols];

                String type = "rt";
                String settings_filename = "preprocess.ini";
                String tickets_string = "Tickets";
                int keyProcessingMethod = 1;
                String delimiter = ",";
                int rows_to_skip = 0;
                String url;
                String url_extension = "asp";
                boolean fixDuplicates = false;
                String[] raw_dates;
                try {

                    BufferedReader in = new BufferedReader(new FileReader(settings_filename));
                    raw_cols = Integer.parseInt(((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim()), 10);
                    delimiter = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    type = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    rows_to_skip = Integer.parseInt(((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim()), 10);
                    url = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    url_extension = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    tickets_string = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    keyProcessingMethod = Integer.parseInt(((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim()), 10);
                    fixDuplicates = Boolean.valueOf((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim());
                    in.close();
                } catch (IOException e) {
                    System.out.println("Error reading in preprocessor settings file: " + e);
                    return (String[][]) null;
                }

                raw_cols = input_keys[0].length;
                rows_to_skip = 0;



                int i, j;
                i = 0;
                while (i < rows) {
                    j = 0;
                    while (j < cols) {
                        if (j > 0) {
                            keys[i][j] = input_keys[i][j];
                        } else {
                            keys[i][j] = processTeamName(input_keys[i][j]) + " " + tickets_string;
                        }

                        j++;
                    }

                    i++;
                }

            } catch (Exception e) {
                System.out.println("something went wrong in performers preprocessing " + e);
                return (String[][]) null;
            }

            return keys;
        }

        public String[][] processHighSalesPerformers(String[][] input_keys, String space, String _url) throws Exception {

            String[][] keys;
            try {

                int rows = input_keys.length;
                if (rows == 0) {
                    throw new Exception("0 rows in keyset object passed to performer preprocessor!!  Serious Error");
                }
                int raw_cols = input_keys[0].length;
                if (raw_cols == 0) {
                    throw new Exception("0 cols in keyset object passed to performer preprocessor!!  Serious Error");
                }
                int cols = raw_cols;
                keys = new String[rows][cols];

                String type = "rt";
                String settings_filename = "preprocess.ini";
                String tickets_string = "Tickets";
                int keyProcessingMethod = 1;
                String delimiter = ",";
                int rows_to_skip = 0;
                String url;
                String url_extension = "asp";
                boolean fixDuplicates = false;
                String[] raw_dates;
                try {

                    BufferedReader in = new BufferedReader(new FileReader(settings_filename));
                    raw_cols = Integer.parseInt(((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim()), 10);
                    delimiter = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    type = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    rows_to_skip = Integer.parseInt(((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim()), 10);
                    url = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    url_extension = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    tickets_string = (((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim();
                    keyProcessingMethod = Integer.parseInt(((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim()), 10);
                    fixDuplicates = Boolean.valueOf((((in.readLine()).replace('\n', ' ')).replace('\r', ' ')).trim());
                    in.close();
                } catch (IOException e) {
                    System.out.println("Error reading in preprocessor settings file: " + e);
                    return (String[][]) null;
                }

                raw_cols = input_keys[0].length;
                rows_to_skip = 0;



                int i, j;
                i = 0;
                while (i < rows) {
                    j = 0;
                    while (j < cols) {
                        if (j > 0) {
                            keys[i][j] = input_keys[i][j];
                        } else {
                            keys[i][j] = input_keys[i][j] + " " + tickets_string;
                        }

                        j++;
                    }

                    i++;
                }

            } catch (Exception e) {
                System.out.println("something went wrong in performers preprocessing " + e);
                return (String[][]) null;
            }

            return keys;
        }

        public static String processTeamName(String in) {
            String key = new String(in);

            try {
                Properties team_name_mappings = new Properties();
                team_name_mappings.load(new FileInputStream("team_name_mappings.ini"));
                Enumeration keys = team_name_mappings.keys();
                while (keys.hasMoreElements()) {

                    String k = (String) keys.nextElement();
                    if (key.contains(k)) {
                        key = key.replaceAll(k, team_name_mappings.getProperty(k));

                    }

                }


            } catch (Exception e) {
                System.out.println("Error reading in sports team name mappings file: " + e);
            }

            return key.trim();
        }
    }

    public static String processRawKey(String key, int method) {
        String processedKey;
        //comon processing done on all keys
        //$'s cause problems in the pattern matching replaceAll for some reason
        if (method == 0) {
            //keep raw key
            return key;
        } else if (method == 1) {
            //trimmed key
            if (key == null) {
                key = "";
            }

            key = key.trim();
            return key;
        } else if (method == 2) {
            //remove quotes ("'s)  in a delimited file that permits quotes around strings
            //and then trim
            if (key == null) {
                key = "";
            }

            processedKey = key.trim();
            int len = processedKey.length();
            if (len == 0) {
                return processedKey;
            }

            if ((processedKey.substring(0, 1)).compareTo("\"") == 0) {
                processedKey = processedKey.substring(1, len);
            }

            len = processedKey.length();
            if (len == 0) {
                return processedKey;
            }

            if ((processedKey.substring(len - 1, len)).compareTo("\"") == 0) {
                processedKey = processedKey.substring(0, len - 1);
            }

            processedKey = processedKey.trim();
            return processedKey;
        } else {
            System.out.println("Error in key processing: method " + method + " undefined.");
            System.out.println("Using default (raw) method instead.");
            return key;
        }

    }

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

    public static String[][] getQueryData(Properties props, String url, String urlLink, int keyProcessingMethod, String space) {


        //System.out.println("Running query: "+props.toString());
        String[][] keys = null;

        if (useDataBase) {
            keys = getQueryDataFromDB(props, url, urlLink, keyProcessingMethod, space, db_ini_filename);
            return keys;

        }

        int rows = 0;
        int cols = 0;
        try {

            String query_type = props.getProperty("query_type");

            if (query_type.compareToIgnoreCase("event") == 0) {
                Properties string_mappings = new Properties();
                string_mappings.load(new FileInputStream("string_mappings.ini"));
                String websiteConfigIDString = props.getProperty("websiteConfigID");
                String numberOfEvents = props.getProperty("numberOfEvents");
                String eventID = props.getProperty("eventID");
                String eventName = props.getProperty("eventName");
                String eventDate = props.getProperty("eventDate");
                String beginDate = props.getProperty("beginDate");
                String endDate = props.getProperty("endDate");
                String venueID = props.getProperty("venueID");
                String venueName = props.getProperty("venueName");
                String stateProvince = props.getProperty("stateProvince");
                String stateProvinceID = props.getProperty("stateProvinceID");
                String cityZip = props.getProperty("cityZip");
                String nearZip = props.getProperty("nearZip");
                String parentCategoryID = props.getProperty("parentCategoryID");
                String childCategoryID = props.getProperty("childCategoryID");
                String grandchildCategoryID = props.getProperty("grandchildCategoryID");
                String performerID = props.getProperty("performerID");
                String performerName = props.getProperty("performerName");
                String noPerformers = props.getProperty("noPerformers");
                String lowPrice = props.getProperty("lowPrice");
                String highPrice = props.getProperty("highPrice");
                String sortColumn = props.getProperty("sortColumn");
                String sortDescending = props.getProperty("sortDescending");
                String mandatoryCreditCard = props.getProperty("mandatoryCreditCard");
                String modificationDate = props.getProperty("modificationDate");
                String onlyMine = props.getProperty("onlyMine");
                String useProxy = props.getProperty("useProxy");
                String proxyHost = props.getProperty("proxyHost");
                String proxyPort = props.getProperty("proxyPort");
                String location = props.getProperty("location");
                Properties reverse_string_mappings = new Properties();
                reverse_string_mappings.load(new FileInputStream("reverse_string_mappings.ini"));
                //System.out.println("State before mapping: " + stateProvince);

                stateProvince =
                        replaceStringOrKeepSame(reverse_string_mappings, stateProvince);

                //System.out.println("State after mapping: " + stateProvince);

                if (Boolean.valueOf(useProxy)) {
                    Properties systemSettings = System.getProperties();
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
                            beginDate =
                                    datetime;
                            props.setProperty("beginDate", beginDate);

                        } catch (Exception e) {
                            System.out.println("something went wrong in the main routine: " + e);
                        }

                    }
                }

                TNServicesStringInputs tns = new TNServicesStringInputs();
                TNServicesStringInputsSoap tnss = tns.getTNServicesStringInputsSoap();
                ArrayOfEvent array_of_events = tnss.getEvents(websiteConfigIDString, numberOfEvents, eventID, eventName, eventDate, beginDate, endDate, venueID, venueName, stateProvince, stateProvinceID, cityZip, nearZip, parentCategoryID, childCategoryID, grandchildCategoryID, performerID, performerName, noPerformers, lowPrice, highPrice, sortColumn, sortDescending, mandatoryCreditCard, modificationDate, onlyMine);
                if (array_of_events == null) {
                    System.out.println("No Events Found. Returning empty keyset.");
                    return keys;
                }

                java.util.List<Event> event_list = array_of_events.getEvent();
                Event[] event_array = event_list.toArray(new Event[0]);
                rows =
                        event_array.length;
                if (rows == 0) {
                    System.out.println("No Events Found. Returning empty keyset.");
                    return keys;
                }

                cols = 14;

                int i = 0;
                int counter = 0;

                if (location.compareToIgnoreCase("") == 0) {

                    keys = new String[rows][cols];
                    i =
                            0;
                    while (i < rows) {

                        keys[i][0] = "" + event_array[i].getID();
                        keys[i][1] = event_array[i].getName();
                        keys[i][2] = event_array[i].getVenue();
                        keys[i][3] = event_array[i].getCity();
                        String state = replaceString(string_mappings, event_array[i].getStateProvince());
                        if ((state.trim()).compareToIgnoreCase("") == 0) {
                            keys[i][4] = event_array[i].getStateProvince();
                        } else {
                            keys[i][4] = state;

                        }

                        keys[i][5] = event_array[i].getDisplayDate();
                        keys[i][6] = "YN";
                        keys[i][7] = url + urlLink + ("" + event_array[i].getID()).trim();
                        keys[i][8] = event_array[i].getStateProvince();
                        keys[i][9] = event_array[i].getMapURL();
                        keys[i][10] = "" + event_array[i].getGrandchildCategoryID();
                        keys[i][11] = "" + event_array[i].getChildCategoryID();
                        keys[i][12] = "" + event_array[i].getParentCategoryID();
                        keys[i][13] = url + urlLink + ("" + event_array[i].getID()).trim();
                        System.out.println("Event " + i + " " + event_array[i].getName() + " " + event_array[i].getDisplayDate() + " " + event_array[i].getCity());
                        i++;

                    }





                } else {

                    i = 0;
                    counter =
                            0;
                    while (i < rows) {


                        if ((event_array[i].getCity()).compareToIgnoreCase(location) == 0) {
                            counter++;
                        }

                        i++;
                    }

                    rows = counter;

                    if (rows == 0) {
                        System.out.println("No Events in location: " + location + " Found. Returning empty keyset.");
                        return keys;
                    }

                    keys = new String[rows][cols];
                    i =
                            0;
                    counter =
                            0;
                    while (counter < rows) {

                        if ((event_array[i].getCity()).compareToIgnoreCase(location.trim()) == 0) {
                            keys[counter][0] = "" + event_array[i].getID();
                            keys[counter][1] = event_array[i].getName();
                            keys[counter][2] = event_array[i].getVenue();
                            keys[counter][3] = event_array[i].getCity();
                            String state = replaceString(string_mappings, event_array[i].getStateProvince());
                            if ((state.trim()).compareToIgnoreCase("") == 0) {
                                keys[counter][4] = event_array[i].getStateProvince();
                            } else {
                                keys[counter][4] = state;

                            }

                            keys[counter][5] = event_array[i].getDisplayDate();
                            keys[counter][6] = "YN";
                            keys[counter][7] = url + urlLink + ("" + event_array[i].getID()).trim();
                            keys[counter][8] = event_array[i].getStateProvince();
                            keys[counter][9] = event_array[i].getMapURL();
                            keys[counter][10] = "" + event_array[i].getGrandchildCategoryID();
                            keys[counter][11] = "" + event_array[i].getChildCategoryID();
                            keys[counter][12] = "" + event_array[i].getParentCategoryID();
                            keys[counter][13] = url + urlLink + ("" + event_array[i].getID()).trim();
                            System.out.println("Event " + counter + " " + event_array[i].getName() + " " + event_array[i].getDisplayDate() + " " + event_array[i].getCity());

                            counter++;

                        }


                        i++;
                    }

                }


                Preprocessor prep = new Preprocessor();
                keys =
                        prep.processEvents(keys, space, url);
                rows =
                        keys.length;
                cols =
                        keys[0].length;

                i =
                        0;
                while (i < rows) {

                    System.out.println("PostProcessingEvent " + i + " " + keys[i][0] + " " + keys[i][5] + " " + keys[i][2]);
                    i++;

                }




                int j = 0;
                i =
                        0;
                while (i < rows) {
                    j = 0;
                    while (j < cols) {
                        if (keys[i][j] == null) {
                            keys[i][j] = "";
                        }

                        keys[i][j] = processRawKey(keys[i][j], keyProcessingMethod);
                        j++;

                    }




                    i++;
                }

                return keys;

            } else if (query_type.compareToIgnoreCase("venue") == 0) {


                String venueID = props.getProperty("venueID");
                String websiteConfigIDString = props.getProperty("websiteConfigID");
                String useProxy = props.getProperty("useProxy");
                String proxyHost = props.getProperty("proxyHost");
                String proxyPort = props.getProperty("proxyPort");
                String location = props.getProperty("location");

                if (Boolean.valueOf(useProxy)) {
                    Properties systemSettings = System.getProperties();
                    systemSettings.put("http.proxyHost", proxyHost);
                    systemSettings.put("http.proxyPort", proxyPort);
                    System.setProperties(systemSettings);

                }

                TNServicesStringInputs tns = new TNServicesStringInputs();
                TNServicesStringInputsSoap tnss = tns.getTNServicesStringInputsSoap();
                ArrayOfVenue array_of_venues = tnss.getVenue(websiteConfigIDString, venueID);
                if (array_of_venues == null) {
                    System.out.println("No Venues Found. Returning empty keyset.");
                    return keys;
                }

                java.util.List<Venue> venue_list = array_of_venues.getVenue();
                Venue[] venue_array = venue_list.toArray(new Venue[0]);
                rows =
                        venue_array.length;
                if (rows == 0) {
                    System.out.println("No Venues Found. Returning empty keyset.");
                    return keys;
                }

                cols = 7;






                int i = 0;
                int counter = 0;

                if (location.compareToIgnoreCase("") == 0) {


                    keys = new String[rows][cols];
                    i =
                            0;
                    while (i < rows) {
                        keys[i][0] = venue_array[i].getName() + " " + venue_array[i].getCity();
                        keys[i][1] = venue_array[i].getName();
                        keys[i][4] = "" + venue_array[i].getID();
                        keys[i][2] = venue_array[i].getCity();
                        keys[i][3] = venue_array[i].getStateProvince();
                        keys[i][5] = venue_array[i].getCountry();
                        keys[i][6] = venue_array[i].getURL();
                        System.out.println("Venue " + i + " " + venue_array[i].getName());
                        i++;

                    }





                } else {

                    i = 0;
                    counter =
                            0;
                    while (i < rows) {


                        if ((venue_array[i].getCity()).compareToIgnoreCase(location) == 0) {
                            counter++;
                        }

                        i++;
                    }

                    rows = counter;

                    if (rows == 0) {
                        System.out.println("No Venues in location: " + location + " Found. Returning empty keyset.");
                        return keys;
                    }

                    keys = new String[rows][cols];
                    i =
                            0;
                    counter =
                            0;
                    while (counter < rows) {

                        if ((venue_array[i].getCity()).compareToIgnoreCase(location.trim()) == 0) {
                            keys[counter][0] = venue_array[i].getName() + " " + venue_array[i].getCity();
                            keys[counter][1] = venue_array[i].getName();
                            keys[counter][4] = "" + venue_array[i].getID();
                            keys[counter][2] = venue_array[i].getCity();
                            keys[counter][3] = venue_array[i].getStateProvince();
                            keys[counter][5] = venue_array[i].getCountry();
                            keys[counter][6] = venue_array[i].getURL();
                            System.out.println("Venue " + counter + " " + venue_array[i].getName() + " " + venue_array[i].getCity());
                            counter++;

                        }


                        i++;
                    }

                }


                Preprocessor prep = new Preprocessor();
                keys =
                        prep.processVenues(keys, space, url);
                rows =
                        keys.length;
                cols =
                        keys[0].length;
                int j = 0;
                i =
                        0;
                while (i < rows) {
                    j = 0;
                    while (j < cols) {
                        if (keys[i][j] == null) {
                            keys[i][j] = "";
                        }

                        keys[i][j] = processRawKey(keys[i][j], keyProcessingMethod);
                        j++;

                    }




                    i++;
                }

                return keys;

            } else if (query_type.compareToIgnoreCase("performer") == 0) {
                int performer_query_type = 0;


                String performer_query_type_string = props.getProperty("performer_query_type");
                if (performer_query_type_string.compareToIgnoreCase("all") == 0) {

                    performer_query_type = 1;

                } else if (performer_query_type_string.compareToIgnoreCase("category") == 0) {
                    performer_query_type = 0;

                } else if (performer_query_type_string.compareToIgnoreCase("sales") == 0) {
                    performer_query_type = 2;

                } else if (performer_query_type_string.compareToIgnoreCase("inventory") == 0) {
                    performer_query_type = 3;

                } else {

                    System.out.println("Error: Invalid or unsupported Performer Query type: " + performer_query_type_string);
                    return keys;
                }

                String websiteConfigIDString = props.getProperty("websiteConfigID");
                String hasEvent = props.getProperty("hasEvent");
                String numReturned = props.getProperty("numReturned");
                String parentCategoryID = props.getProperty("parentCategoryID");
                String childCategoryID = props.getProperty("childCategoryID");
                String grandchildCategoryID = props.getProperty("grandchildCategoryID");
                String useProxy = props.getProperty("useProxy");
                String proxyHost = props.getProperty("proxyHost");
                String proxyPort = props.getProperty("proxyPort");
                if (Boolean.valueOf(useProxy)) {
                    Properties systemSettings = System.getProperties();
                    systemSettings.put("http.proxyHost", proxyHost);
                    systemSettings.put("http.proxyPort", proxyPort);
                    System.setProperties(systemSettings);

                }

                TNServicesStringInputs tns = new TNServicesStringInputs();
                TNServicesStringInputsSoap tnss = tns.getTNServicesStringInputsSoap();
                if (performer_query_type == 0) {

                    ArrayOfPerformer array_of_performers = tnss.getPerformerByCategory(websiteConfigIDString, parentCategoryID, childCategoryID, grandchildCategoryID, hasEvent);
                    if (array_of_performers == null) {
                        System.out.println("No Performers Found. Returning empty keyset.");
                        return keys;
                    }

                    java.util.List<Performer> performer_list = array_of_performers.getPerformer();
                    Performer[] performer_array = performer_list.toArray(new Performer[0]);


                    rows =
                            performer_array.length;
                    if (rows == 0) {
                        System.out.println("No Performers Found. Returning empty keyset.");
                        return keys;
                    }

                    cols = 6;
                    keys =
                            new String[rows][cols];
                    int i = 0;
                    while (i < rows) {
                        keys[i][0] = performer_array[i].getDescription();
                        keys[i][1] = performer_array[i].getDescription();
                        Category cat = performer_array[i].getCategory();
                        keys[i][2] = "" + cat.getParentCategoryDescription();
                        keys[i][3] = "" + cat.getChildCategoryDescription();
                        keys[i][4] = "" + cat.getGrandchildCategoryDescription();
                        keys[i][5] = "" + performer_array[i].getID();

                        System.out.println("Performer " + i + " " + performer_array[i].getDescription());

                        i++;

                    }




                    Preprocessor prep = new Preprocessor();
                    keys =
                            prep.processPerformers(keys, space, url);
                    rows =
                            keys.length;
                    cols =
                            keys[0].length;
                    int j = 0;
                    i =
                            0;
                    while (i < rows) {
                        j = 0;
                        while (j < cols) {
                            if (keys[i][j] == null) {
                                keys[i][j] = "";
                            }

                            keys[i][j] = processRawKey(keys[i][j], keyProcessingMethod);
                            j++;

                        }




                        i++;
                    }

                    return keys;


                } else if (performer_query_type == 1) {

                    System.out.println("Error: Invalid or unsupported Performer Query type: " + performer_query_type);

                    return keys;
                } else if (performer_query_type == 2) {
                    ArrayOfPerformerPercent array_of_performers = tnss.getHighSalesPerformers(websiteConfigIDString, numReturned, parentCategoryID, childCategoryID, grandchildCategoryID);
                    if (array_of_performers == null) {
                        System.out.println("No High Sales Performers Found. Returning empty keyset.");
                        return keys;
                    }

                    java.util.List<PerformerPercent> performer_list = array_of_performers.getPerformerPercent();
                    PerformerPercent[] performer_array = performer_list.toArray(new PerformerPercent[0]);


                    rows =
                            performer_array.length;
                    if (rows == 0) {
                        System.out.println("No High Sales Performers Found. Returning empty keyset.");
                        return keys;
                    }

                    cols = 7;
                    keys =
                            new String[rows][cols];
                    int i = 0;
                    while (i < rows) {
                        Performer performer = performer_array[i].getPerformer();
                        keys[i][0] = performer.getDescription();
                        keys[i][1] = performer.getDescription();
                        Category cat = performer.getCategory();
                        keys[i][2] = "" + cat.getParentCategoryDescription();
                        keys[i][3] = "" + cat.getChildCategoryDescription();
                        keys[i][4] = "" + cat.getGrandchildCategoryDescription();
                        keys[i][5] = "" + performer.getID();
                        keys[i][6] = (performer_array[i].getPercent()).toString();


                        System.out.println("High Sales Performer " + i + " " + performer.getDescription() + " " + (performer_array[i].getPercent()).toString() + "%");

                        i++;

                    }




                    Preprocessor prep = new Preprocessor();
                    keys =
                            prep.processHighSalesPerformers(keys, space, url);
                    rows =
                            keys.length;
                    cols =
                            keys[0].length;
                    int j = 0;
                    i =
                            0;
                    while (i < rows) {
                        j = 0;
                        while (j < cols) {
                            if (keys[i][j] == null) {
                                keys[i][j] = "";
                            }

                            keys[i][j] = processRawKey(keys[i][j], keyProcessingMethod);
                            j++;

                        }




                        i++;
                    }

                    return keys;

                } else if (performer_query_type == 3) {
                    System.out.println("Error: Invalid or unsupported Performer Query type: " + performer_query_type);

                    return keys;

                } else {

                    System.out.println("Error: Invalid or unsupported Performer Query type: " + performer_query_type);

                    return keys;
                }

            } else if (query_type.compareToIgnoreCase("city") == 0) {
                System.out.println("Error: Invalid Query type: " + query_type);
                return keys;

            } else {
                System.out.println("Error: Invalid Query type: " + query_type);
                return keys;
            }

        } catch (Exception e) {
            System.out.println("Error in get Query Data: " + e + "\nReturning empty dataset");
            return keys;

        }

    }//end get query data
    public static String[][] getQueryDataFromDB(Properties props, String url, String urlLink, int keyProcessingMethod, String space, String database_ini_filename) {


        System.out.println("Running db query: " + props.toString());
        String[][] keys = null;
        Properties db_props = null;
        String[] databases = null;
        Properties db1_props = null;
        Properties string_mappings = new Properties();
        Properties reverse_string_mappings = new Properties();


        try {
            string_mappings.load(new FileInputStream("string_mappings.ini"));
            reverse_string_mappings.load(new FileInputStream("reverse_string_mappings.ini"));
            db_props =
                    new Properties();
            db_props.load(new FileInputStream(database_ini_filename));
            databases =
                    delimitedStringToArray(db_props.getProperty("DatabaseFiles"), ",");
            if (databases == null) {
                System.out.println("Error in getQueryDataFromDB: no databases specified");
                return keys;
            }

            if (databases.length == 0) {
                System.out.println("Error in getQueryDataFromDB: no databases specified");
                return keys;
            }

        } catch (Exception e) {
            System.out.println("Error in getQueryDataFromDB: problems with ini files");
            return keys;

        }

        Connection conn = null;

        int dbs = 0;
        boolean connected = false;
        while (dbs < databases.length && (connected == false)) {
            try {
                db1_props = new Properties();
                db1_props.load(new FileInputStream(databases[dbs]));
            } catch (Exception e) {
                db1_props = null;
                System.out.println("Error in getQueryDataFromDB opening DB ini file for db " + dbs + " in list. " + e);
                dbs++;

                continue;

            }


            String driver = db1_props.getProperty("driver");
            String server = db1_props.getProperty("server");
            String db = db1_props.getProperty("db");
            String dbport = db1_props.getProperty("dbport");
            String username = db1_props.getProperty("username");
            String password = db1_props.getProperty("password");
            Properties systemSettings = System.getProperties();
            systemSettings.put("http.proxyHost", "");
            systemSettings.put("http.proxyPort", "");
            System.setProperties(systemSettings);
            int attempts = 0;
            int max_tries = 10;

            while (attempts < max_tries && connected == false) {
                try {
                    conn = DriverManager.getConnection("jdbc:" + driver + "://" + server + ":" + dbport + "/" + db + "?user=" + username + "&password=" + password);
                    System.out.println("Connected to DB at: " + server);
                    connected =
                            true;
                } catch (Exception e) {
                    attempts++;
                }

            }//end of attemps at current db while loop
            if (connected) {
                break;
            }

            dbs++;
        } //end of connection while loop

        if (!connected) {
            System.out.println("Error in getQueryDataFromDB: Could not connect to db");
            return keys;
        }

        int rows = 0;
        int cols = 0;
        try {

            String query_type = props.getProperty("query_type");

            if (query_type.compareToIgnoreCase("event") == 0) {
                System.out.println("Connected.  Preparing to create events query");
                String websiteConfigIDString = props.getProperty("websiteConfigID");
                String numberOfEvents = props.getProperty("numberOfEvents");
                String eventID = props.getProperty("eventID");
                String eventName = props.getProperty("eventName");
                String eventDate = props.getProperty("eventDate");
                String beginDate = props.getProperty("beginDate");
                String endDate = props.getProperty("endDate");
                String venueID = props.getProperty("venueID");
                String venueName = props.getProperty("venueName");
                String stateProvince = props.getProperty("stateProvince");
                String stateProvinceID = props.getProperty("stateProvinceID");
                String cityZip = props.getProperty("cityZip");
                String nearZip = props.getProperty("nearZip");
                String parentCategoryID = props.getProperty("parentCategoryID");
                String childCategoryID = props.getProperty("childCategoryID");
                String grandchildCategoryID = props.getProperty("grandchildCategoryID");
                String performerID = props.getProperty("performerID");
                String performerName = props.getProperty("performerName");
                String noPerformers = props.getProperty("noPerformers");
                String lowPrice = props.getProperty("lowPrice");
                String highPrice = props.getProperty("highPrice");
                String sortColumn = props.getProperty("sortColumn");
                String sortDescending = props.getProperty("sortDescending");
                String mandatoryCreditCard = props.getProperty("mandatoryCreditCard");
                String modificationDate = props.getProperty("modificationDate");
                String onlyMine = props.getProperty("onlyMine");
                String useProxy = props.getProperty("useProxy");
                String proxyHost = props.getProperty("proxyHost");
                String proxyPort = props.getProperty("proxyPort");
                String location = props.getProperty("location");
                //System.out.println("State before mapping: " + stateProvince);

                stateProvince =
                        replaceStringOrKeepSame(reverse_string_mappings, stateProvince);
                location =
                        replaceStringOrKeepSame(reverse_string_mappings, location);
                //System.out.println("State after mapping: " + stateProvince);


                if (Boolean.valueOf(useProxy)) {
                    Properties systemSettings = System.getProperties();
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
                            beginDate =
                                    datetime;
                            props.setProperty("beginDate", beginDate);

                        } catch (Exception e) {
                            System.out.println("something went wrong in the main routine: " + e);
                        }

                    }
                }



                String select = "select events.*,categories.ParentCategoryDescription,categories.ChildCategoryDescription,categories.GrandchildCategoryDescription from events,categories WHERE events.ParentCategoryID = categories.ParentCategoryID and events.ChildCategoryID=categories.ChildCategoryID and events.GrandchildCategoryID=categories.GrandchildCategoryID ";
                boolean needWhere = false;
                //String select = "select * from events ";
                //boolean needWhere =  true;

                if (eventID.compareToIgnoreCase("") != 0) {
                    if (needWhere) {
                        select = select + " WHERE true ";
                        needWhere =
                                false;
                    }

                    select = select + "and events.ID=" + eventID + " ";
                }

                if (eventName.compareToIgnoreCase("") != 0) {
                    eventName = replaceStringWithString(eventName, "'", "\\'");
                    if (needWhere) {
                        select = select + " WHERE true ";
                        needWhere =
                                false;
                    }

                    select = select + "and events.Name Like '%" + eventName + "%' ";
                }

                if (performerName.compareToIgnoreCase("") != 0) {
                    performerName = replaceStringWithString(performerName, "'", "\\'");
                    if (needWhere) {
                        select = select + " WHERE true ";
                        needWhere =
                                false;
                    }

                    select = select + "and events.Name Like '%" + performerName + "%' ";
                }

                if (venueName.compareToIgnoreCase("") != 0) {
                    venueName = replaceStringWithString(venueName, "'", "\\'");
                    if (needWhere) {
                        select = select + " WHERE true ";
                        needWhere =
                                false;
                    }

                    select = select + "and events.Venue Like '%" + venueName + "%' ";
                }

                if (location.compareToIgnoreCase("") != 0) {
                    location = replaceStringWithString(location, "'", "\\'");
                    if (needWhere) {
                        select = select + " WHERE true ";
                        needWhere =
                                false;
                    }

                    select = select + "and events.City Like '" + location + "' ";
                }

                if (stateProvince.compareToIgnoreCase("") != 0) {
                    stateProvince = replaceStringWithString(stateProvince, "'", "\\'");
                    if (needWhere) {
                        select = select + " WHERE true ";
                        needWhere =
                                false;
                    }

                    select = select + "and events.StateProvince Like '" + stateProvince + "' ";
                }

                if (parentCategoryID.compareToIgnoreCase("") != 0) {
                    if (needWhere) {
                        select = select + " WHERE true ";
                        needWhere =
                                false;
                    }

                    select = select + "and events.ParentCategoryID=" + parentCategoryID + " ";
                }

                if (childCategoryID.compareToIgnoreCase("") != 0) {
                    if (needWhere) {
                        select = select + " WHERE true ";
                        needWhere =
                                false;
                    }

                    select = select + "and events.ChildCategoryID=" + childCategoryID + " ";
                }

                if (grandchildCategoryID.compareToIgnoreCase("") != 0) {
                    if (needWhere) {
                        select = select + " WHERE true ";
                        needWhere =
                                false;
                    }

                    select = select + "and events.GrandchildCategoryID=" + grandchildCategoryID + " ";
                }

                if (venueID.compareToIgnoreCase("") != 0) {
                    if (needWhere) {
                        select = select + " WHERE true ";
                        needWhere =
                                false;
                    }

                    select = select + "and events.VenueID=" + venueID + " ";
                }

                if (stateProvinceID.compareToIgnoreCase("") != 0) {
                    if (needWhere) {
                        select = select + " WHERE true ";
                        needWhere =
                                false;
                    }

                    select = select + "and events.StateProvinceID=" + stateProvinceID + " ";
                }

                if (beginDate.compareToIgnoreCase("") != 0) {
                    if (needWhere) {
                        select = select + " WHERE true ";
                        needWhere = false;
                    }

                    select = select + "and events.DATE >= STR_TO_DATE('"+beginDate+"','%m/%d/%Y') ";
                }
                if (endDate.compareToIgnoreCase("") != 0) {
                    if (needWhere) {
                        select = select + " WHERE true ";
                        needWhere = false;
                    }

                    select = select + "and events.DATE <= STR_TO_DATE('"+endDate+"','%m/%d/%Y') ";
                }
                /* *
                eventDate,     
                cityZip, 
                performerID, 
               
                noPerformers, 
                sortColumn, 
                sortDescending, 
                 * */
                select = select + " ORDER BY RAND() ";
                if (numberOfEvents.compareToIgnoreCase("") != 0) {
                    select = select + "LIMIT " + numberOfEvents + " ";
                }

                System.out.println("Executing: " + select);
                Statement stmt = null;
                ResultSet rs = null;


                try {
                    stmt = conn.createStatement();
                    rs =
                            stmt.executeQuery(select);
                } catch (Exception e) {
                    System.out.println("Error Executing: " + select + "  excpetion: " + e);
                    return keys;
                }

                List<ExtendedEvent> array_list = new ArrayList();

                int num_events = 0;
                try {

                    while (rs.next()) {
                        ExtendedEvent ev = new ExtendedEvent();
                        Event event = new Event();
                        event.setID(rs.getInt("ID"));
                        event.setName(rs.getString("Name"));
                        event.setVenue(rs.getString("Venue"));
                        event.setCity(rs.getString("City"));
                        event.setStateProvince(rs.getString("StateProvince"));
                        event.setDisplayDate(rs.getString("DisplayDate"));
                        event.setMapURL(rs.getString("MapURL"));
                        event.setParentCategoryID(rs.getInt("ParentCategoryID"));
                        event.setChildCategoryID(rs.getInt("ChildCategoryID"));
                        event.setGrandchildCategoryID(rs.getInt("GrandchildCategoryID"));
                        ev.event = event;
                        ev.category = "" + rs.getString("ParentCategoryDescription") + "," + rs.getString("ChildCategoryDescription") + "," + rs.getString("GrandchildCategoryDescription") + "";
                        array_list.add(ev);
                        /*
                        boolean bool = rs.getBoolean("col_boolean");
                        byte b = rs.getByte("col_byte");
                        short s = rs.getShort("col_short");
                        int i = rs.getInt("col_int");
                        long l = rs.getLong("col_long");
                        float f = rs.getFloat("col_float");
                        double d = rs.getDouble("col_double");
                        String str = rs.getString("col_string");
                        java.sql.Date date = rs.getDate("col_date");
                        Time t = rs.getTime("col_time");
                        Timestamp ts = rs.getTimestamp("col_timestamp");
                        InputStream ais = rs.getAsciiStream("col_asciistream");
                        InputStream bis = rs.getBinaryStream("col_binarystream");
                        Blob blob = rs.getBlob("col_blob");
                         */
                        num_events++;

                    }



                } catch (SQLException e) {

                    System.out.println("Error processing resultset: " + e);
                    keys =
                            null;
                    return keys;

                }

                ExtendedEvent[] event_array = array_list.toArray(new ExtendedEvent[0]);
                rows =
                        event_array.length;

                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException sqlEx) { // ignore }
                        rs = null;
                    }

                }
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException sqlEx) { // ignore }
                        stmt = null;
                    }

                }

                if (rows != num_events) {
                    System.out.println("Number of events in array does not match result set. Returning empty keyset.");
                    return keys;
                }

                if (rows == 0) {
                    System.out.println("No Events Found. Returning empty keyset.");
                    return keys;
                }

                cols = 14;

                int i = 0;
                int counter = 0;



                keys =
                        new String[rows][cols];
                i =
                        0;
                while (i < rows) {

                    keys[i][0] = "" + event_array[i].event.getID();
                    keys[i][1] = event_array[i].event.getName();
                    keys[i][2] = event_array[i].event.getVenue();
                    keys[i][3] = event_array[i].event.getCity();
                    keys[i][3] = replaceStringOrKeepSame(string_mappings, keys[i][3]);
                    keys[i][4] = event_array[i].event.getStateProvince();
                    keys[i][4] = replaceStringOrKeepSame(string_mappings, keys[i][4]);
                    keys[i][5] = event_array[i].event.getDisplayDate();
                    keys[i][6] = event_array[i].category;
                    keys[i][7] = url + urlLink + ("" + event_array[i].event.getID()).trim();
                    keys[i][8] = event_array[i].event.getStateProvince();
                    keys[i][9] = event_array[i].event.getMapURL();
                    keys[i][10] = "" + event_array[i].event.getGrandchildCategoryID();
                    keys[i][11] = "" + event_array[i].event.getChildCategoryID();
                    keys[i][12] = "" + event_array[i].event.getParentCategoryID();
                    keys[i][13] = url + urlLink + ("" + event_array[i].event.getID()).trim();
                    System.out.println("Event " + i + " " + event_array[i].event.getName() + " " + event_array[i].event.getDisplayDate() + " " + event_array[i].event.getCity());
                    i++;

                }





                Preprocessor prep = new Preprocessor();
                keys =
                        prep.processEvents(keys, space, url);
                rows =
                        keys.length;
                cols =
                        keys[0].length;



                i =
                        0;
                while (i < rows) {

                    System.out.println("PostProcessingEvent " + i + " " + keys[i][0] + " " + keys[i][5] + " " + keys[i][2]);
                    i++;

                }






                int j = 0;
                i =
                        0;
                while (i < rows) {
                    j = 0;
                    while (j < cols) {
                        if (keys[i][j] == null) {
                            keys[i][j] = "";
                        }

                        keys[i][j] = processRawKey(keys[i][j], keyProcessingMethod);
                        j++;

                    }




                    i++;
                }

                return keys;

            } else if (query_type.compareToIgnoreCase("venue") == 0) {

                System.out.println("Connected.  Preparing to create venue query");
                String websiteConfigIDString = props.getProperty("websiteConfigID");
                String useProxy = props.getProperty("useProxy");
                String proxyHost = props.getProperty("proxyHost");
                String proxyPort = props.getProperty("proxyPort");
                String location = props.getProperty("location");
                String venueID = props.getProperty("venueID");
                String venueName = props.getProperty("venueName");
                String stateProvince = props.getProperty("stateProvince");
                String country = props.getProperty("country");
                String cityZip = props.getProperty("cityZip");

                if (Boolean.valueOf(useProxy)) {
                    Properties systemSettings = System.getProperties();
                    systemSettings.put("http.proxyHost", proxyHost);
                    systemSettings.put("http.proxyPort", proxyPort);
                    System.setProperties(systemSettings);

                }

                stateProvince = replaceStringOrKeepSame(string_mappings, stateProvince);
                location =
                        replaceStringOrKeepSame(reverse_string_mappings, location);
                country =
                        replaceStringOrKeepSame(reverse_string_mappings, country);


                boolean needWhere = true;
                String select = "SELECT * FROM venues";

                if (venueName.compareToIgnoreCase("") != 0) {
                    venueName = replaceStringWithString(venueName, "'", "\\'");
                    if (needWhere) {
                        select = select + " WHERE true ";
                        needWhere =
                                false;
                    }

                    select = select + "and Name Like '%" + venueName + "%' ";
                }

                if (location.compareToIgnoreCase("") != 0) {
                    location = replaceStringWithString(location, "'", "\\'");
                    if (needWhere) {
                        select = select + " WHERE true ";
                        needWhere =
                                false;
                    }

                    select = select + "and City Like '" + location + "' ";
                }

                if (stateProvince.compareToIgnoreCase("") != 0) {
                    stateProvince = replaceStringWithString(stateProvince, "'", "\\'");
                    if (needWhere) {
                        select = select + " WHERE true ";
                        needWhere =
                                false;
                    }

                    select = select + "and StateProvince Like '" + stateProvince + "' ";
                }

                if (venueID.compareToIgnoreCase("") != 0) {
                    if (needWhere) {
                        select = select + " WHERE true ";
                        needWhere =
                                false;
                    }

                    select = select + "and ID=" + venueID + " ";
                }

                if (country.compareToIgnoreCase("") != 0) {
                    country = replaceStringWithString(country, "'", "\\'");
                    if (needWhere) {
                        select = select + " WHERE true ";
                        needWhere =
                                false;
                    }

                    select = select + "and Country Like '" + country + "' ";
                }

//select = select + " ORDER BY RAND() ";
                System.out.println("Executing: " + select);
                Statement stmt = null;
                ResultSet rs = null;


                try {
                    stmt = conn.createStatement();
                    rs =
                            stmt.executeQuery(select);
                } catch (Exception e) {
                    System.out.println("Error Executing: " + select + "  excpetion: " + e);
                    return keys;
                }

                List<Venue> array_list = new ArrayList();

                int num_venues = 0;
                try {

                    while (rs.next()) {
                        Venue venue = new Venue();
                        venue.setID(rs.getInt("ID"));
                        venue.setName(rs.getString("Name"));
                        venue.setCity(rs.getString("City"));
                        venue.setStreet1(rs.getString("Street1"));
                        venue.setStreet2(rs.getString("Street2"));
                        venue.setZipCode(rs.getString("ZipCode"));
                        venue.setStateProvince(rs.getString("StateProvince"));
                        venue.setCountry(rs.getString("Country"));
                        venue.setURL(rs.getString("URL"));
                        array_list.add(venue);

                        num_venues++;

                    }



                } catch (SQLException e) {

                    System.out.println("Error processing venue resultset: " + e);
                    keys =
                            null;
                    return keys;

                }

                Venue[] venue_array = array_list.toArray(new Venue[0]);
                rows =
                        venue_array.length;

                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException sqlEx) { // ignore }
                        rs = null;
                    }

                }
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException sqlEx) { // ignore }
                        stmt = null;
                    }

                }

                if (rows != num_venues) {
                    System.out.println("Number of venues in array does not match result set. Returning empty keyset.");
                    return keys;
                }

                if (rows == 0) {
                    System.out.println("No Venues Found. Returning empty keyset.");
                    return keys;
                }

                cols = 10;


                int i = 0;
                int counter = 0;




                keys =
                        new String[rows][cols];
                i =
                        0;
                while (i < rows) {
                    keys[i][0] = venue_array[i].getName() + " " + venue_array[i].getCity();
                    keys[i][1] = venue_array[i].getName();
                    keys[i][4] = "" + venue_array[i].getID();
                    keys[i][2] = venue_array[i].getCity();
                    keys[i][2] = replaceStringOrKeepSame(string_mappings, keys[i][2]);
                    keys[i][3] = venue_array[i].getStateProvince();
                    keys[i][3] = replaceStringOrKeepSame(string_mappings, keys[i][3]);
                    keys[i][5] = venue_array[i].getCountry();
                    keys[i][5] = replaceStringOrKeepSame(string_mappings, keys[i][5]);

                    keys[i][6] = venue_array[i].getURL();
                    keys[i][7] = venue_array[i].getStreet1();
                    keys[i][8] = venue_array[i].getStreet2();
                    keys[i][9] = venue_array[i].getZipCode();
                    System.out.println("Venue " + i + " " + venue_array[i].getName());
                    i++;

                }




                Preprocessor prep = new Preprocessor();
                keys =
                        prep.processVenues(keys, space, url);
                rows =
                        keys.length;
                cols =
                        keys[0].length;

                int j = 0;
                i =
                        0;
                while (i < rows) {
                    j = 0;
                    while (j < cols) {
                        if (keys[i][j] == null) {
                            keys[i][j] = "";
                        }

                        keys[i][j] = processRawKey(keys[i][j], keyProcessingMethod);
                        j++;

                    }




                    i++;
                }

                return keys;

            } else if (query_type.compareToIgnoreCase("performer") == 0) {

                int performer_query_type = 0;
                String performer_query_type_string = props.getProperty("performer_query_type");
                if (performer_query_type_string.compareToIgnoreCase("all") == 0) {
                    performer_query_type = 1;
                } else if (performer_query_type_string.compareToIgnoreCase("category") == 0) {
                    performer_query_type = 0;
                } else if (performer_query_type_string.compareToIgnoreCase("sales") == 0) {
                    performer_query_type = 2;
                } else if (performer_query_type_string.compareToIgnoreCase("inventory") == 0) {
                    performer_query_type = 3;
                } else {
                    System.out.println("Error: Invalid or unsupported Performer Query type: " + performer_query_type_string);
                    return keys;
                }

                System.out.println("Connected.  Preparing to create performer query");
                String websiteConfigIDString = props.getProperty("websiteConfigID");
                String hasEvent = props.getProperty("hasEvent");
                String numReturned = props.getProperty("numReturned");
                String parentCategoryID = props.getProperty("parentCategoryID");
                String childCategoryID = props.getProperty("childCategoryID");
                String grandchildCategoryID = props.getProperty("grandchildCategoryID");
                String performerID = props.getProperty("performerID");
                String performerName = props.getProperty("performerName");
                String useProxy = props.getProperty("useProxy");
                String proxyHost = props.getProperty("proxyHost");
                String proxyPort = props.getProperty("proxyPort");

                if (Boolean.valueOf(useProxy)) {
                    Properties systemSettings = System.getProperties();
                    systemSettings.put("http.proxyHost", proxyHost);
                    systemSettings.put("http.proxyPort", proxyPort);
                    System.setProperties(systemSettings);

                }

                boolean needWhere = true;
                //String select = "SELECT * FROM venues";
                String select = " ";

                if (performerName.compareToIgnoreCase("") != 0) {
                    performerName = replaceStringWithString(performerName, "'", "\\'");
                    if (needWhere) {
                        select = select + " WHERE true ";
                        needWhere =
                                false;
                    }

                    select = select + "and Name Like '%" + performerName + "%' ";
                }

                if (performerID.compareToIgnoreCase("") != 0) {
                    if (needWhere) {
                        select = select + " WHERE true ";
                        needWhere =
                                false;
                    }

                    select = select + "and ID=" + performerID + " ";
                }

                if (parentCategoryID.compareToIgnoreCase("") != 0) {
                    if (needWhere) {
                        select = select + " WHERE true ";
                        needWhere =
                                false;
                    }

                    select = select + "and ParentCategoryID=" + parentCategoryID + " ";
                }

                if (childCategoryID.compareToIgnoreCase("") != 0) {
                    if (needWhere) {
                        select = select + " WHERE true ";
                        needWhere =
                                false;
                    }

                    select = select + "and ChildCategoryID=" + childCategoryID + " ";
                }

                if (grandchildCategoryID.compareToIgnoreCase("") != 0) {
                    if (needWhere) {
                        select = select + " WHERE true ";
                        needWhere =
                                false;
                    }

                    select = select + "and GrandchildCategoryID=" + grandchildCategoryID + " ";
                }

//select = select + " ORDER BY percent DESC ";
//select = select + " ORDER BY RAND() ";
//if (numReturned.compareToIgnoreCase("") != 0) {
//    select = select + "LIMIT " + numReturned + " ";
// }
                if (performer_query_type == 0) {

                    //select = select + " ORDER BY RAND() ";
                    if (numReturned.compareToIgnoreCase("") != 0) {
                        select = select + "LIMIT " + numReturned + " ";
                    }

                    select = "SELECT * FROM performers " + select;
                    System.out.println("Executing: " + select);
                    Statement stmt = null;
                    ResultSet rs = null;


                    try {
                        stmt = conn.createStatement();
                        rs =
                                stmt.executeQuery(select);
                    } catch (Exception e) {
                        System.out.println("Error Executing: " + select + "  excpetion: " + e);
                        return keys;
                    }

                    List<Performer> array_list = new ArrayList();

                    int num_performers = 0;
                    try {

                        while (rs.next()) {
                            Performer performer = new Performer();
                            performer.setID(rs.getInt("ID"));
                            performer.setDescription(rs.getString("Name"));
                            Category cat = new Category();
                            cat.setParentCategoryDescription(rs.getString("ParentCategoryDescription"));
                            cat.setChildCategoryDescription(rs.getString("ChildCategoryDescription"));
                            cat.setGrandchildCategoryDescription(rs.getString("GrandchildCategoryDescription"));
                            cat.setParentCategoryID(rs.getInt("ParentCategoryID"));
                            cat.setChildCategoryID(rs.getInt("ChildCategoryID"));
                            cat.setGrandchildCategoryID(rs.getInt("GrandchildCategoryID"));
                            performer.setCategory(cat);
                            array_list.add(performer);
                            num_performers++;

                        }



                    } catch (SQLException e) {

                        System.out.println("Error processing performer resultset: " + e);
                        keys =
                                null;
                        return keys;

                    }

                    Performer[] performer_array = array_list.toArray(new Performer[0]);
                    rows =
                            performer_array.length;

                    if (rs != null) {
                        try {
                            rs.close();
                        } catch (SQLException sqlEx) { // ignore }
                            rs = null;
                        }

                    }
                    if (stmt != null) {
                        try {
                            stmt.close();
                        } catch (SQLException sqlEx) { // ignore }
                            stmt = null;
                        }

                    }

                    if (rows != num_performers) {
                        System.out.println("Number of performers in array does not match result set. Returning empty keyset.");
                        return keys;
                    }

                    if (rows == 0) {
                        System.out.println("No Performers Found. Returning empty keyset.");
                        return keys;
                    }

                    cols = 9;
                    keys =
                            new String[rows][cols];
                    int i = 0;
                    while (i < rows) {
                        keys[i][0] = performer_array[i].getDescription();
                        keys[i][1] = performer_array[i].getDescription();
                        Category cat = performer_array[i].getCategory();
                        keys[i][6] = "" + cat.getParentCategoryDescription();
                        keys[i][7] = "" + cat.getChildCategoryDescription();
                        keys[i][8] = "" + cat.getGrandchildCategoryDescription();
                        keys[i][5] = "" + performer_array[i].getID();
                        keys[i][2] = "" + cat.getParentCategoryID();
                        keys[i][3] = "" + cat.getChildCategoryID();
                        keys[i][4] = "" + cat.getGrandchildCategoryID();


                        System.out.println("Performer " + i + " " + performer_array[i].getDescription());
                        i++;

                    }




                    Preprocessor prep = new Preprocessor();
                    keys =
                            prep.processPerformers(keys, space, url);
                    rows =
                            keys.length;
                    cols =
                            keys[0].length;
                    int j = 0;
                    i =
                            0;
                    while (i < rows) {
                        j = 0;
                        while (j < cols) {
                            if (keys[i][j] == null) {
                                keys[i][j] = "";
                            }

                            keys[i][j] = processRawKey(keys[i][j], keyProcessingMethod);
                            j++;

                        }


                        i++;
                    }

                    return keys;
                } else if (performer_query_type == 1) {
                    //we want them all here so forget the stuff above
                    select = "SELECT * FROM performers ";
                    if (numReturned.compareToIgnoreCase("") != 0) {
                        select = select + "LIMIT " + numReturned + " ";
                    }


                    System.out.println("Executing: " + select);
                    Statement stmt = null;
                    ResultSet rs = null;


                    try {
                        stmt = conn.createStatement();
                        rs =
                                stmt.executeQuery(select);
                    } catch (Exception e) {
                        System.out.println("Error Executing: " + select + "  excpetion: " + e);
                        return keys;
                    }

                    List<Performer> array_list = new ArrayList();

                    int num_performers = 0;
                    try {

                        while (rs.next()) {
                            Performer performer = new Performer();
                            performer.setID(rs.getInt("ID"));
                            performer.setDescription(rs.getString("Name"));
                            Category cat = new Category();
                            cat.setParentCategoryDescription(rs.getString("ParentCategoryDescription"));
                            cat.setChildCategoryDescription(rs.getString("ChildCategoryDescription"));
                            cat.setGrandchildCategoryDescription(rs.getString("GrandchildCategoryDescription"));
                            cat.setParentCategoryID(rs.getInt("ParentCategoryID"));
                            cat.setChildCategoryID(rs.getInt("ChildCategoryID"));
                            cat.setGrandchildCategoryID(rs.getInt("GrandchildCategoryID"));
                            performer.setCategory(cat);
                            array_list.add(performer);
                            num_performers++;

                        }



                    } catch (SQLException e) {

                        System.out.println("Error processing all performer resultset: " + e);
                        keys =
                                null;
                        return keys;

                    }

                    Performer[] performer_array = array_list.toArray(new Performer[0]);
                    rows =
                            performer_array.length;

                    if (rs != null) {
                        try {
                            rs.close();
                        } catch (SQLException sqlEx) { // ignore }
                            rs = null;
                        }

                    }
                    if (stmt != null) {
                        try {
                            stmt.close();
                        } catch (SQLException sqlEx) { // ignore }
                            stmt = null;
                        }

                    }

                    if (rows != num_performers) {
                        System.out.println("Number of performers in array does not match result set. Returning empty keyset.");
                        return keys;
                    }

                    if (rows == 0) {
                        System.out.println("No Performers Found. Returning empty keyset.");
                        return keys;
                    }

                    cols = 9;
                    keys =
                            new String[rows][cols];
                    int i = 0;
                    while (i < rows) {
                        keys[i][0] = performer_array[i].getDescription();
                        keys[i][1] = performer_array[i].getDescription();
                        Category cat = performer_array[i].getCategory();
                        keys[i][6] = "" + cat.getParentCategoryDescription();
                        keys[i][7] = "" + cat.getChildCategoryDescription();
                        keys[i][8] = "" + cat.getGrandchildCategoryDescription();
                        keys[i][5] = "" + performer_array[i].getID();
                        keys[i][2] = "" + cat.getParentCategoryID();
                        keys[i][3] = "" + cat.getChildCategoryID();
                        keys[i][4] = "" + cat.getGrandchildCategoryID();


                        System.out.println("Performer " + i + " " + performer_array[i].getDescription());
                        i++;

                    }




                    Preprocessor prep = new Preprocessor();
                    keys =
                            prep.processPerformers(keys, space, url);
                    rows =
                            keys.length;
                    cols =
                            keys[0].length;
                    int j = 0;
                    i =
                            0;
                    while (i < rows) {
                        j = 0;
                        while (j < cols) {
                            if (keys[i][j] == null) {
                                keys[i][j] = "";
                            }

                            keys[i][j] = processRawKey(keys[i][j], keyProcessingMethod);
                            j++;

                        }


                        i++;
                    }

                    return keys;
                } else if (performer_query_type == 2) {
                    select = select + " ORDER BY percent DESC ";
                    //select = select + " ORDER BY RAND() ";
                    if (numReturned.compareToIgnoreCase("") != 0) {
                        select = select + "LIMIT " + numReturned + " ";
                    }

                    select = "SELECT * FROM sales " + select;
                    System.out.println("Executing: " + select);
                    Statement stmt = null;
                    ResultSet rs = null;


                    try {
                        stmt = conn.createStatement();
                        rs =
                                stmt.executeQuery(select);
                    } catch (Exception e) {
                        System.out.println("Error Executing: " + select + "  excpetion: " + e);
                        return keys;
                    }

                    List<PerformerPercent> array_list = new ArrayList();

                    int num_performers = 0;
                    try {

                        while (rs.next()) {
                            PerformerPercent pc = new PerformerPercent();
                            Performer performer = new Performer();
                            performer.setID(rs.getInt("ID"));
                            performer.setDescription(rs.getString("Name"));
                            Category cat = new Category();
                            cat.setParentCategoryDescription(rs.getString("ParentCategoryDescription"));
                            cat.setChildCategoryDescription(rs.getString("ChildCategoryDescription"));
                            cat.setGrandchildCategoryDescription(rs.getString("GrandchildCategoryDescription"));
                            cat.setParentCategoryID(rs.getInt("ParentCategoryID"));
                            cat.setChildCategoryID(rs.getInt("ChildCategoryID"));
                            cat.setGrandchildCategoryID(rs.getInt("GrandchildCategoryID"));
                            performer.setCategory(cat);
                            pc.setPerformer(performer);
                            pc.setPercent(new BigDecimal(rs.getFloat("percent")));
                            array_list.add(pc);
                            num_performers++;

                        }



                    } catch (SQLException e) {

                        System.out.println("Error processing performer resultset: " + e);
                        keys =
                                null;
                        return keys;

                    }

                    PerformerPercent[] performer_array = array_list.toArray(new PerformerPercent[0]);
                    rows =
                            performer_array.length;

                    if (rs != null) {
                        try {
                            rs.close();
                        } catch (SQLException sqlEx) { // ignore }
                            rs = null;
                        }

                    }
                    if (stmt != null) {
                        try {
                            stmt.close();
                        } catch (SQLException sqlEx) { // ignore }
                            stmt = null;
                        }

                    }

                    if (rows != num_performers) {
                        System.out.println("Number of performers in array does not match result set. Returning empty keyset.");
                        return keys;
                    }

                    if (rows == 0) {
                        System.out.println("No Performers Found. Returning empty keyset.");
                        return keys;
                    }

                    cols = 10;
                    keys =
                            new String[rows][cols];
                    int i = 0;
                    while (i < rows) {
                        Performer performer = performer_array[i].getPerformer();
                        keys[i][0] = performer.getDescription();
                        keys[i][1] = performer.getDescription();
                        Category cat = performer.getCategory();
                        keys[i][6] = "" + cat.getParentCategoryDescription();
                        keys[i][7] = "" + cat.getChildCategoryDescription();
                        keys[i][8] = "" + cat.getGrandchildCategoryDescription();
                        keys[i][5] = "" + performer.getID();
                        keys[i][2] = "" + cat.getParentCategoryID();
                        keys[i][3] = "" + cat.getChildCategoryID();
                        keys[i][4] = "" + cat.getGrandchildCategoryID();
                        keys[i][9] = (performer_array[i].getPercent()).toString();
                        System.out.println("High Sales Performer " + i + " " + performer.getDescription() + " " + (performer_array[i].getPercent()).toString() + "%");
                        i++;

                    }



                    Preprocessor prep = new Preprocessor();
                    keys =
                            prep.processHighSalesPerformers(keys, space, url);
                    rows =
                            keys.length;
                    cols =
                            keys[0].length;

                    int j = 0;
                    i =
                            0;
                    while (i < rows) {
                        j = 0;
                        while (j < cols) {
                            if (keys[i][j] == null) {
                                keys[i][j] = "";
                            }

                            keys[i][j] = processRawKey(keys[i][j], keyProcessingMethod);
                            j++;

                        }


                        i++;
                    }

                    return keys;
                } else if (performer_query_type == 3) {
                    System.out.println("Error: Invalid or unsupported Performer Query type: " + performer_query_type);
                    return keys;
                } else {
                    System.out.println("Error: Invalid or unsupported Performer Query type: " + performer_query_type);
                    return keys;
                }

            } else if (query_type.compareToIgnoreCase("city") == 0) {
                System.out.println("Error: Invalid Query type: " + query_type);
                return keys;

            } else {
                System.out.println("Error: Invalid Query type: " + query_type);
                return keys;
            }

        } catch (Exception e) {
            System.out.println("Error in get Query Data: " + e + "\nReturning empty dataset");
            return keys;

        }

    }//end get query data from db
    public static String getOutputFileName(String[] ks, String input_type, String query_type, boolean flatlinks, String output_directory, String filename_extension, String url_filename_space, String out_dir_slash) throws Exception {
        String outfile = null;
        String directory_name = null;
        if (input_type.compareToIgnoreCase("csv") == 0) {
            if (flatlinks) {

                outfile = key2UrlFilename(ks[0], filename_extension, url_filename_space);


            } else {

                directory_name = (key2UrlDir(ks[0], url_filename_space)).trim() + out_dir_slash;

                outfile =
                        (key2UrlDir(ks[0], url_filename_space)).trim() + out_dir_slash + key2UrlFilename(ks[0], filename_extension, url_filename_space);

            }

        } else {

            if (query_type.equalsIgnoreCase("event")) {
                if (flatlinks) {

                    outfile = key2UrlFilename(ks[filename_title_col], filename_extension, url_filename_space);


                } else {

                    directory_name = (key2UrlDir(ks[dirname_title_col], url_filename_space)).trim() + out_dir_slash;

                    outfile =
                            (key2UrlDir(ks[dirname_title_col], url_filename_space)).trim() + out_dir_slash + key2UrlFilename(ks[filename_title_col], filename_extension, url_filename_space);

                }

            } else if (query_type.equalsIgnoreCase("performer")) {

                if (flatlinks) {

                    outfile = key2UrlFilename(ks[0], filename_extension, url_filename_space);


                } else {

                    directory_name = (key2UrlDir(ks[1], url_filename_space)).trim() + out_dir_slash;

                    outfile =
                            (key2UrlDir(ks[1], url_filename_space)).trim() + out_dir_slash + key2UrlFilename(ks[0], filename_extension, url_filename_space);

                }

            } else if (query_type.equalsIgnoreCase("venue")) {

                if (flatlinks) {

                    outfile = key2UrlFilename(ks[0], filename_extension, url_filename_space);


                } else {

                    directory_name = (key2UrlDir(ks[1], url_filename_space)).trim() + out_dir_slash;

                    outfile =
                            (key2UrlDir(ks[1], url_filename_space)).trim() + out_dir_slash + key2UrlFilename(ks[0], filename_extension, url_filename_space);

                }

            } else {
                if (flatlinks) {

                    outfile = key2UrlFilename(ks[0], filename_extension, url_filename_space);


                } else {

                    directory_name = (key2UrlDir(ks[1], url_filename_space)).trim() + out_dir_slash;

                    outfile =
                            (key2UrlDir(ks[1], url_filename_space)).trim() + out_dir_slash + key2UrlFilename(ks[0], filename_extension, url_filename_space);

                }

            }

        }

        if (useDataBase) {
            if (query_type.equalsIgnoreCase("event")) {
                String[] category_names = delimitedStringToArray(ks[categories_col], ",");
                if (useGrandchildCategoryDirName) {
                    outfile = (key2UrlDir(category_names[2], url_filename_space)).trim() + out_dir_slash + outfile;
                    directory_name =
                            (key2UrlDir(category_names[2], url_filename_space)).trim() + out_dir_slash + directory_name;
                }

                if (useChildCategoryDirName) {
                    outfile = (key2UrlDir(category_names[1], url_filename_space)).trim() + out_dir_slash + outfile;
                    directory_name =
                            (key2UrlDir(category_names[1], url_filename_space)).trim() + out_dir_slash + directory_name;
                }

                if (useParentCategoryDirName) {
                    outfile = (key2UrlDir(category_names[0], url_filename_space)).trim() + out_dir_slash + outfile;
                    directory_name =
                            (key2UrlDir(category_names[0], url_filename_space)).trim() + out_dir_slash + directory_name;
                }

            } else if (query_type.equalsIgnoreCase("performer")) {

                if (useGrandchildCategoryDirName) {
                    outfile = (key2UrlDir(ks[8], url_filename_space)).trim() + out_dir_slash + outfile;
                    directory_name =
                            (key2UrlDir(ks[8], url_filename_space)).trim() + out_dir_slash + directory_name;
                }

                if (useChildCategoryDirName) {
                    outfile = (key2UrlDir(ks[7], url_filename_space)).trim() + out_dir_slash + outfile;
                    directory_name =
                            (key2UrlDir(ks[7], url_filename_space)).trim() + out_dir_slash + directory_name;
                }

                if (useParentCategoryDirName) {
                    outfile = (key2UrlDir(ks[6], url_filename_space)).trim() + out_dir_slash + outfile;
                    directory_name =
                            (key2UrlDir(ks[6], url_filename_space)).trim() + out_dir_slash + directory_name;
                }

            } else if (query_type.equalsIgnoreCase("venue")) {
                if (useGrandchildCategoryDirName) {
                    outfile = (key2UrlDir(ks[2], url_filename_space)).trim() + out_dir_slash + outfile;
                    directory_name =
                            (key2UrlDir(ks[2], url_filename_space)).trim() + out_dir_slash + directory_name;
                }

                if (useChildCategoryDirName) {
                    outfile = (key2UrlDir(ks[3], url_filename_space)).trim() + out_dir_slash + outfile;
                    directory_name =
                            (key2UrlDir(ks[3], url_filename_space)).trim() + out_dir_slash + directory_name;
                }

                if (useParentCategoryDirName) {
                    outfile = (key2UrlDir(ks[5], url_filename_space)).trim() + out_dir_slash + outfile;
                    directory_name =
                            (key2UrlDir(ks[5], url_filename_space)).trim() + out_dir_slash + directory_name;
                }

            } else {

                throw new Exception("Error in getOutputFilename: trying to set category names for dirs but querytype is not event venue, or performer");

            }

        }

        outfile = output_directory + outfile;
        directory_name =
                output_directory + directory_name;

        outfile =
                replaceStringWithString(outfile, out_dir_slash + out_dir_slash, out_dir_slash);
        directory_name =
                replaceStringWithString(directory_name, out_dir_slash + out_dir_slash, out_dir_slash);
        File dir = new File(directory_name);
        dir.mkdirs();

        return outfile;

    } //end of getFileName

    public static String key2UrlFilename(String key, String extension, String url_filename_space) {


        Pattern r = Pattern.compile("[\\p{Space}]+");
        Matcher m = r.matcher(key.trim());
        //first, set the filename equal to the key with all spaces replaced by the spacer
        if (url_filename_space == null || url_filename_space.compareTo("") == 0) {
            url_filename_space = " ";
        }

        String filename = m.replaceAll(url_filename_space);
        //take care of some chars that shouldn't be in the filename
        filename =
                filename.replace('/', url_filename_space.charAt(0));
        filename =
                filename.replace('.', url_filename_space.charAt(0));
        filename =
                filename.replace(',', url_filename_space.charAt(0));
        filename =
                filename.replace('`', url_filename_space.charAt(0));
        filename =
                filename.replace('\'', url_filename_space.charAt(0));
        filename =
                filename.replace('&', url_filename_space.charAt(0));

        filename =
                filename.replace('\'', url_filename_space.charAt(0));
        //filename = replaceStringWithString(filename, "&", "And");
        filename =
                filename.replace('\\', url_filename_space.charAt(0));
        filename =
                filename.replace('(', url_filename_space.charAt(0));
        filename =
                filename.replace(')', url_filename_space.charAt(0));
        filename =
                filename.replace(':', url_filename_space.charAt(0));
        filename =
                filename.replace('$', url_filename_space.charAt(0));
        filename =
                filename.replace('?', url_filename_space.charAt(0));
        filename =
                filename.replace('!', url_filename_space.charAt(0));
        //handle some others by choice
        //finally add .extension, usually one of: .htm, .html, .asp or .jsp
        filename =
                filename + "." + extension;
        String spacer = url_filename_space;
        filename =
                filename.replaceAll(spacer + "[" + spacer + "]+", spacer);
        //remove . or the filename space if it's the first char to prevent generation of hidden files (sometimes)
        if (url_filename_space.compareTo(" ") == 0) {
            filename = removeSpaces(filename);
            url_filename_space =
                    "";
        } else {
            if (filename.charAt(0) == '.' || filename.charAt(0) == url_filename_space.charAt(0)) {
                filename = filename.substring(1, filename.length());
            }

        }
        if (useLowerCaseFilenames) {
            filename = filename.toLowerCase();
        }

        return filename;


    }

    public static String key2UrlDir(String key, String url_filename_space) {

        Pattern r = Pattern.compile("[\\p{Space}]+");
        Matcher m = r.matcher(key.trim());
        if (url_filename_space == null || url_filename_space.compareTo("") == 0) {
            url_filename_space = " ";
        }

        String dirname = m.replaceAll(url_filename_space);

        dirname =
                dirname.replace('/', url_filename_space.charAt(0));
        dirname =
                dirname.replace('\'', url_filename_space.charAt(0));



        dirname =
                dirname.replace('\'', url_filename_space.charAt(0));
        dirname =
                dirname.replace('`', url_filename_space.charAt(0));
        dirname =
                dirname.replace('-', url_filename_space.charAt(0));

        dirname =
                dirname.replace('\'', url_filename_space.charAt(0));
        //dirname = replaceStringWithString(dirname, "&", "And");
        dirname =
                dirname.replace('&', url_filename_space.charAt(0));
        dirname =
                dirname.replace('.', url_filename_space.charAt(0));
        dirname =
                dirname.replace(',', url_filename_space.charAt(0));
        dirname =
                dirname.replace(':', url_filename_space.charAt(0));
        dirname =
                dirname.replace('\\', url_filename_space.charAt(0));
        dirname =
                dirname.replace('(', url_filename_space.charAt(0));
        dirname =
                dirname.replace(')', url_filename_space.charAt(0));
        dirname =
                dirname.replace('$', url_filename_space.charAt(0));
        dirname =
                dirname.replace('?', url_filename_space.charAt(0));
        dirname =
                dirname.replace('!', url_filename_space.charAt(0));
        //dirname = dirname.replaceAll("-[-]+", "-");
        String spacer = url_filename_space;
        dirname =
                dirname.replaceAll(spacer + "[" + spacer + "]+", spacer);

        if (url_filename_space.compareTo(" ") == 0) {
            dirname = removeSpaces(dirname);
            url_filename_space =
                    "";
        } else {
            if (dirname.charAt(0) == '.' || dirname.charAt(0) == url_filename_space.charAt(0)) {
                dirname = dirname.substring(1, dirname.length());
            }

        }
        if (useLowerCaseDirnames) {
            dirname = dirname.toLowerCase();
        }

        return dirname;


    }

    public static String key2FlatLink(String[] key, String extension, String url_dir_slash, String url_filename_space, String path, String type, boolean switchlinks) {
        if (type.compareToIgnoreCase("event") == 0) {

            String name = key2UrlFilename(key[filename_title_col], extension, url_filename_space);
            if (useDataBase) {
                String[] category_names = delimitedStringToArray(key[categories_col], ",");
                if (useGrandchildCategoryDirName) {
                    name = (key2UrlDir(category_names[2], url_filename_space)).trim() + url_dir_slash + name;
                }

                if (useChildCategoryDirName) {
                    name = (key2UrlDir(category_names[1], url_filename_space)).trim() + url_dir_slash + name;
                }

                if (useParentCategoryDirName) {
                    name = (key2UrlDir(category_names[0], url_filename_space)).trim() + url_dir_slash + name;
                }

            }
            name = replaceStringWithString(name, url_dir_slash + url_dir_slash, url_dir_slash);
            //return ("<a href=\"{URL}" + path + name + "\">" + key[0] + "</a>");
            if (switchlinks) {
                return ("<a href=\"{URL}" + path + name + "\">" + key[2] + " " + key[4] + " " + switchlinks_ticket_string + "</a>");
            } else {
                return ("<a href=\"{URL}" + path + name + "\">" + key[0] + "</a>");
            }



        } else if (type.compareToIgnoreCase("performer") == 0) {
            String name = key2UrlFilename(key[0], extension, url_filename_space);
            if (useDataBase) {
                if (useGrandchildCategoryDirName) {
                    name = (key2UrlDir(key[8], url_filename_space)).trim() + url_dir_slash + name;
                }

                if (useChildCategoryDirName) {
                    name = (key2UrlDir(key[7], url_filename_space)).trim() + url_dir_slash + name;
                }

                if (useParentCategoryDirName) {
                    name = (key2UrlDir(key[6], url_filename_space)).trim() + url_dir_slash + name;
                }

            }
            name = replaceStringWithString(name, url_dir_slash + url_dir_slash, url_dir_slash);
            return ("<a href=\"{URL}" + path + name + "\">" + key[0] + "</a>");
        } else if (type.compareToIgnoreCase("venue") == 0) {
            String name = key2UrlFilename(key[0], extension, url_filename_space);
            if (useDataBase) {
                if (useGrandchildCategoryDirName) {
                    name = (key2UrlDir(key[2], url_filename_space)).trim() + url_dir_slash + name;
                }

                if (useChildCategoryDirName) {
                    name = (key2UrlDir(key[3], url_filename_space)).trim() + url_dir_slash + name;
                }

                if (useParentCategoryDirName) {
                    name = (key2UrlDir(key[5], url_filename_space)).trim() + url_dir_slash + name;
                }

            }
            name = replaceStringWithString(name, url_dir_slash + url_dir_slash, url_dir_slash);
            return ("<a href=\"{URL}" + path + name + "\">" + key[0] + "</a>");
        } else {
            return ("<a href=\"{URL}" + path + key2UrlFilename(key[0], extension, url_filename_space) + "\">" + key[0] + "</a>");
        }

    }

    public static String key2Link(String[] key, String extension, String url_dir_slash, String url_filename_space, String path, String type, boolean switchlinks) {

        if (type.compareToIgnoreCase("event") == 0) {
            String name = key2UrlDir(key[dirname_title_col], url_filename_space) + url_dir_slash + key2UrlFilename(key[filename_title_col], extension, url_filename_space);
            if (useDataBase) {
                String[] category_names = delimitedStringToArray(key[categories_col], ",");
                if (useGrandchildCategoryDirName) {
                    name = (key2UrlDir(category_names[2], url_filename_space)).trim() + url_dir_slash + name;
                }

                if (useChildCategoryDirName) {
                    name = (key2UrlDir(category_names[1], url_filename_space)).trim() + url_dir_slash + name;
                }

                if (useParentCategoryDirName) {
                    name = (key2UrlDir(category_names[0], url_filename_space)).trim() + url_dir_slash + name;
                }

            }
            name = replaceStringWithString(name, url_dir_slash + url_dir_slash, url_dir_slash);
            if (switchlinks) {
                return ("<a href=\"{URL}" + path + name + "\">" + key[2] + " " + key[4] + " " + switchlinks_ticket_string + "</a>");
            } else {
                return ("<a href=\"{URL}" + path + name + "\">" + key[0] + "</a>");
            }

        } else if (type.compareToIgnoreCase("performer") == 0) {
            String name = key2UrlDir(key[1], url_filename_space) + url_dir_slash + key2UrlFilename(key[0], extension, url_filename_space);
            if (useDataBase) {
                if (useGrandchildCategoryDirName) {
                    name = (key2UrlDir(key[8], url_filename_space)).trim() + url_dir_slash + name;
                }

                if (useChildCategoryDirName) {
                    name = (key2UrlDir(key[7], url_filename_space)).trim() + url_dir_slash + name;
                }

                if (useParentCategoryDirName) {
                    name = (key2UrlDir(key[6], url_filename_space)).trim() + url_dir_slash + name;
                }

            }
            name = replaceStringWithString(name, url_dir_slash + url_dir_slash, url_dir_slash);
            return ("<a href=\"{URL}" + path + name + "\">" + key[0] + "</a>");
        } else if (type.compareToIgnoreCase("venue") == 0) {
            String name = key2UrlDir(key[1], url_filename_space) + url_dir_slash + key2UrlFilename(key[0], extension, url_filename_space);
            if (useDataBase) {
                if (useGrandchildCategoryDirName) {
                    name = (key2UrlDir(key[2], url_filename_space)).trim() + url_dir_slash + name;
                }

                if (useChildCategoryDirName) {
                    name = (key2UrlDir(key[3], url_filename_space)).trim() + url_dir_slash + name;
                }

                if (useParentCategoryDirName) {
                    name = (key2UrlDir(key[5], url_filename_space)).trim() + url_dir_slash + name;
                }

            }
            name = replaceStringWithString(name, url_dir_slash + url_dir_slash, url_dir_slash);
            return ("<a href=\"{URL}" + path + name + "\">" + key[0] + "</a>");
        } else if (type.compareToIgnoreCase("csv") == 0) {
            return ("<a href=\"{URL}" + path + key2UrlDir(key[0], url_filename_space) + url_dir_slash + key2UrlFilename(key[0], extension, url_filename_space) + "\">" + key[0] + "</a>");

        } else {
            return ("<a href=\"{URL}" + path + key2UrlDir(key[1], url_filename_space) + url_dir_slash + key2UrlFilename(key[0], extension, url_filename_space) + "\">" + key[0] + "</a>");
        }

    }

    public static String[][] dropKey(int i, String[][] keys) {

        int rows = keys.length;
        int cols = keys[i].length;
        if (rows <= 1) {
            return keys;
        }

        String[][] new_keys = new String[rows - 1][cols];
        int j;
        j =
                0;
        while (j < rows) {

            if (j < i) {
                new_keys[j] = keys[j];
                j++;

            } else if (j == i) {
                j++;
            } else {
                new_keys[j - 1] = keys[j];
                j++;

            }







        }
        return new_keys;

    }
} //end of jproj class
//to do: fix better error message if extlinks file not present possible for kset too

