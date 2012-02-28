
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.lang.*;
import java.lang.String;
import java.lang.Integer;
import java.lang.reflect.Array;

public class preprocess {

    public static void main(String[] args) throws Exception {
        try {
            int numArgs = Array.getLength(args);

            if (numArgs == 0) {
                System.out.println("Preprocess invoked with 0 arguments.");
                System.out.println("Run: java preprocess -h  for help.");
                return;
            }

            //System.out.println("Preprocessor received " + numArgs + " args");
            if (args[0].compareTo("-h") == 0) {
                System.out.println("Usage: java preprocess input_filename output_filename || input_filename output_filename settings_filename || input_filename output_filename raw_cols delimiter type numlines-to-skip url url_extension");
                return;
            }

            //move on to processing args

            //set the default type of processing output for col 0 of output file
            //it's set to: raw tickets with no date, default case in if-else chain (meaning the else case)
            String type = "rt";
            String settings_filename = "preprocess.ini";
            String tickets_string = "Tickets";
            int keyProcessingMethod = 1;
            String input_filename;
            String output_filename;
            int raw_cols = 8;
            String delimiter = ",";
            int rows_to_skip = 1;
            String url;
            String url_extension = "asp";


            if (numArgs == 2) {
                input_filename = args[0].trim();
                output_filename = args[1].trim();
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
                    in.close();
                } catch (IOException e) {
                    System.out.println("Error reading in settings file: " + e);
                    return;
                }

            } else if (numArgs == 3) {
                input_filename = args[0].trim();
                output_filename = args[1].trim();
                settings_filename = args[2].trim();
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
                    in.close();
                } catch (IOException e) {
                    System.out.println("Error reading in settings file: " + e);
                    return;
                }

            } else if (numArgs == 8) {
                input_filename = args[0].trim();
                output_filename = args[1].trim();
                raw_cols = Integer.parseInt(args[2].trim(), 10);
                delimiter = args[3].trim();
                type = args[4].trim();
                rows_to_skip = Integer.parseInt(args[5].trim(), 10);
                url = args[6].trim();
                url_extension = args[7].trim();

            } else {
                System.out.println("Error in number of arguments passed to preprocess");
                System.out.println("Run: java preprocess -h  for help.");
                return;
            }


            ///check the arguments
            System.out.println("Preprocessor arguments:");
            System.out.println("input_filename: " + input_filename);
            System.out.println("output file: " + output_filename);
            System.out.println("settings_filename: " + settings_filename);
            System.out.println("cols: " + raw_cols);
            System.out.println("delimiter: " + delimiter);
            System.out.println("type: " + type);
            System.out.println("num lines to skip: " + rows_to_skip);
            System.out.println("url: " + url);
            System.out.println("url extension: " + url_extension);
            System.out.println("tickets string: " + tickets_string);
            System.out.println("Key Processing method: " + keyProcessingMethod);


            //setup some variables
            String[][] keys;
            int i, j, rows, cols;
            //row is the number of key vectors and cols = number of cols in output file, currently raw_cols + 2

            rows = 0;
            cols = raw_cols + 2;

            //set up the "space" finder
            Pattern space_pattern = Pattern.compile("[\\p{Space}]+[\\s]*");
            Matcher space_matcher = space_pattern.matcher(" ");

            //open the csv file and read in the raw data.  
            //put the raw data in the same col as it is in the inputfile, we'll move them later if needed.

            CSVReader reader = new CSVReader(new FileReader(input_filename), delimiter.charAt(0), (char) 34, rows_to_skip);
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
            reader = new CSVReader(new FileReader(input_filename), delimiter.charAt(0), (char) 34, rows_to_skip);

            i = 0;
            while ((nextLine = reader.readNext()) != null) {

                space_matcher.reset(nextLine[0]);
                if (space_matcher.matches()) {
                //blank 
                } else {
                    j = 0;
                    while (j < cols && j < Array.getLength(nextLine)) {
                        keys[i][j] = nextLine[j];
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

            //we have the raw data in the same col order and number as in the raw input file (thereforew
            // the last 2 cols are empty since they did not exist in the input file)
            //now we modify it...

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


                //fix time/date here
                String raw_date = "date";
                try {

                    String date_time = new String(keys[k][5]);
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
                    if (hour < 12) {
                        am_or_pm = "a.m.";
                    } else {
                        am_or_pm = "p.m.";
                        hour = hour - 12;
                    }
                    if (hour == 0) {
                        hour = 12;
                    }
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
                    if (min > 9) {
                        time_string = hour + ":" + min + " " + am_or_pm;
                    } else {
                        time_string = hour + ":0" + min + " " + am_or_pm;
                    }
                    date_string = month_string + " " + day + ", " + year;

                    keys[k][5] = new String(date_string);
                    keys[k][6] = new String(time_string);



                } catch (Exception e) {

                    System.out.println("something went wrong while taking care of the date-time " + e);
                    System.out.println("info:  " + keys[k][0] + " " + keys[k][5]);


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

                if (type.compareTo("r") == 0) {
                    keys[k][0] = keys[k][0];
                } else if (type.compareTo("rtd") == 0) {
                    keys[k][0] = keys[k][0] + " " + tickets_string + " " + raw_date;
                } else if (type.compareTo("s") == 0) {
                    keys[k][0] = processTeamName(keys[k][0]) + " " + tickets_string;
                } else if (type.compareTo("c") == 0) {
                    keys[k][0] = keys[k][0] + " " + keys[k][3] + " " + tickets_string;
                } else if (type.compareTo("t") == 0) {
                    keys[k][0] = keys[k][0] + " " + keys[k][3] + " " + tickets_string;
                } else if (type.compareTo("sd") == 0) {

                    keys[k][0] = processTeamName(keys[k][0]) + " " + tickets_string + " " + raw_date;
                } else if (type.compareTo("cd") == 0) {
                    keys[k][0] = keys[k][0] + " " + keys[k][3] + " " + tickets_string + " " + raw_date;
                } else if (type.compareTo("td") == 0) {
                    keys[k][0] = keys[k][0] + " " + keys[k][3] + " " + tickets_string + " " + raw_date;
                } else //raw name with Tickets appended.
                {
                    keys[k][0] = keys[k][0] + " " + tickets_string;
                }


                k++;

            }


            //okay, write the output file
            CSVWriter writer = new CSVWriter(new FileWriter(output_filename), delimiter.charAt(0), (char) 34);
            k = 0;
            while (k < rows) {
                writer.writeNext(keys[k]);
                k++;
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("something went wrong in preprocess " + e);

        }


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

    public static String processRawKey(String key, int method) {
        String processedKey;
        //comon processing done on all keys
        //$'s cause problems in the pattern matching replaceAll for some reason
        if (method == 0) {
            //keep raw key
            return key;
        } else if (method == 1) {
            //trimmed key
            return (key.replace('$', ' ')).trim();
        } else if (method == 2) {
            //remove quotes ("'s)  in a delimited file that permits quotes around strings
            //and then trim
            processedKey = (key.replace('$', ' ')).trim();
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
}
		




