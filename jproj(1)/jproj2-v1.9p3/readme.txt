

to use the preprocessor type:

java preprocess input_filename cols delimiter type outfile numlines-to-skip
-----
input_filename   = the name (with full or partial path) of the file to process.
cols             = the number of columns of data.
delimiter        = the char that seperates cols in the input file.
type             = s for sports, t for theatre, c for concerts, m for misc. i.e., everything else.
outfile          = the name of the file that output will be written to.
numlines-to-skip = the number of lines to skip in the input file before beginning to process it.  Can be 0 or more.
For example, in our standart tickets file the first line is 
"EventID","Event","Venue","City","State","DateTime","TicketsYN","URLLink"
so numlines-to-skip is set to 1 so that the col name line is not processed.

note, cols = 8 in this case and the seperator is a comma.
So, to preprocess the standard tickets file we would type:

c:\java preprocess tickets.csv 8 , s test.csv 1

for sports or

C:\jproj>java preprocess tickets.csv 8 , c test.csv 1

for concerts and

C:\jproj>java preprocess tickets.csv 8 , t test.csv 1

for theatre.
In each case the first line of tickets.csv would be skipped, the output would go to test.csv and the delimiter
would be a ",".  8 cols of data would be expected,

Once the preprocessor has run you can just type
java jproj 
using the included jproj.ini.
The output will go to c:\temp


For example, to generate test-s.csv and test-t.csv I ran
java preprocess tickets.csv 8 , t test-t.csv 1
and
java preprocess tickets.csv 8 , s test-s.csv 1

I didn't bother doing c since, for now, the output is the same as t.
Note also that I messed with the time column before processing to verify that the time bug is fixed...


then i modified jproj.ini so that the input file was test-s.csv or test-t.csv
and ran
java jproj
once each.
the output went to c:\temp 
all of it is included...

UPDATES TO PREPROCESS-------5-20-07

preprocess now uses an ini file too, preprocess.ini
its format is (given line by line with extra lines ignored):

number of cols in the input csv file
csv delimiter, usually a comma
type of output file
outfile
number of rows to skip, usually 1 because the first row contains col titles
url
url extension
"Tickets" string
key processing method



an example:
8
,
s
1
www.h.com
asp
Tickets
1


The command line arguments have changed:
to invoke preprocess 
either use:

1) java preprocess input_file output_file
this case assumes that a file called preprocess.ini is in the same directory that you are running in
or 
2) java preprocess input_file output_file settings_file
here you can specify an alternate settings file.
For example you might want one that handles sports events with dates
and another for the same but without dates.
eg. 
preproc-sports-no-date.ini
would have:
8
,
s
1
www.h.com
asp
Tickets
1

preproc-sports-with-date.ini
would have (note this is what's in the included sample preprocess.ini file):
8
,
sd
1
www.h.com
asp
Tickets
1


3) finally, preprocess can be invoked with most options on the command line as:

java preprocess input_file output_file raw_cols delimiter type numlines-to-skip url url_extension
eg.
java preprocess tickets.csv test.csv 8 , sd 1 www.h.com asp

Note: in this case the default values 
are assumed for the tickets string (= Tickets) and the key processing method (=1).
FYI: Generally you won't change the key processing method unless you change the input file source.



Putting it all together:

to process the example file tickets.csv using the supplied ini files (jproj.ini and preprocess.ini) run:

java preprocess tickets.csv test.csv
java jproj

the output will be placed in c:\temp
the files are preprocessed using type sd so the dates will be used.
I did this for the sample to insure that each input csv file line corrosponds to one output file.

We also have new processing types:
Types of files in preprocess (note: The type determines the contents of the first column):
				s = sports tickets (no date)
				sd = sports tickets + date
				t = theatre tickets (no date)
				td  = theatre tickets + date
				c = concert tickets (no date)
				cd = concert tickets + date
				r = raw  (no date, no tickets string)
				rd = raw + date (no tickets string)
			        rtd = raw tickets + date
				if an invalid type is specified, eg. d, the system will default to
				raw + tickets string.

Note the tickets string is by default "Tickets" it can be changed only when using a settings file. 
it can not be changed when the settings are specified on the command line.

Creation of TN Classes:

Default:
wsimport -keep -extension http://webservices2-test.ticketnetwork.com/R2/TNServices.asmx?wsdl

StringInputs Version:
wsimport -keep -extension http://webservices2-test.ticketnetwork.com/R2/TNServicesStringInputs.asmx?wsdl

We currently use the String Inputs version

