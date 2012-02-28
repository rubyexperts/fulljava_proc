using System;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Net;
using System.Data;
using System.ComponentModel;
using System.Diagnostics;
using System.Web.Services;
using System.Web.Services.Protocols;
using System.Xml.Serialization;
using MySql.Data;
using MySql.Data.MySqlClient;
//using System.Data.Odbc;
namespace TNControls
{
      public class TNMySqlGridControl : Control
      {
          
private int  websiteConfigID_ = 568; 
private string connection1_ =null;
private string connection2_ =null;
private string connection3_ =null;
private System.Nullable<int>  numberOfEvents_  =  null;
private System.Nullable<int>  eventID_  =   null ;
private string eventName_= null;
private string errorName_= null;
private System.Nullable<DateTime> eventDate_=   null ; 
private System.Nullable<DateTime> beginDate_=   null ; 
System.Nullable<DateTime> endDate_=   null ; 
System.Nullable<int>  venueID_=   null ; 
string venueName_     =null; 
string stateProvince_ =null;
System.Nullable<int>  stateProvinceID_ = null;
string cityZip_=null; 
string nearZip_=null; 
System.Nullable<int>  parentCategoryID_=null ; 
System.Nullable<int>  childCategoryID_=null ; 
System.Nullable<int>  grandchildCategoryID_=   null ; 
System.Nullable<int>  performerID_=   null ; 
string performerName_= null;  
System.Nullable<bool> noPerformers_=   null ; 
System.Nullable<decimal> lowPrice_=   null ; 
System.Nullable<decimal> highPrice_=   null ; 
string sortColumn_=  null; 
System.Nullable<bool> sortDescending_=   null ; 
string mandatoryCreditCard_=null ; 
System.DateTime? modificationDate_=  null ; 
System.Nullable<bool> onlyMine_  =  null  ;
string location_ = null;
string viewTicketsUrl_ = null;
bool useProxy_ = false;
string proxyHost_ = null;
string proxyPort_ = null;
DataGrid TicketDataGrid = null;


public virtual String eventName{
    get{
        return eventName_;
    }
    set{
        if(value == "") value = null;
        eventName_ = value;
    }
}
public virtual String errorName{
    get{
        return errorName_;
    }
    set{
        if(value == "") value = null;
        errorName_ = value;
    }
}            
public virtual String performerName{
    get{
        return performerName_;
    }
    set{
        if(value == "") value = null;
        performerName_ = value;
    }
}  
public virtual String stateProvince{
    get{
        return stateProvince_;
    }
    set{
        if(value == "") value = null;
        stateProvince_ = value;
    }
}        
public virtual String venue{
    get{
        return venueName_;
    }
    set{
        if(value == "") value = null;
        venueName_ = value;
    }
}  
public virtual String city{
    get{
        return location_;
    }
    set{
        if(value == "") value = null;
        location_ = value;
    }
}  
public virtual String numReturned{
    
    set{
        if(value == null) numberOfEvents_ = null;
        if(value == ""){
               numberOfEvents_ = null; 
}else{

        numberOfEvents_ = Convert.ToInt32(value);
}    
}
} 
public virtual String ParentCategoryID{
    
    set{
        if(value == null) parentCategoryID_ = null;
        if(value == ""){
               parentCategoryID_ = null; 
}else{

        parentCategoryID_ = Convert.ToInt32(value);
}    
}
}       
public virtual String ChildCategoryID{
    
    set{
        if(value == null) childCategoryID_ = null;
        if(value == ""){
               childCategoryID_ = null; 
}else{

        childCategoryID_ = Convert.ToInt32(value);
}    
}
}       
public virtual String GrandchildCategoryID{
    
    set{
        if(value == null) grandchildCategoryID_ = null;
        if(value == ""){
               parentCategoryID_ = null; 
}else{

        grandchildCategoryID_ = Convert.ToInt32(value);
}    
}
}       





public virtual String BeginDate{
  
    set{
       if(value == null) value = "";
        if(value == ""){beginDate_ = null;}else{
	 if((value).Trim(' ')== "today"){
         beginDate_ = DateTime.Now;
}else{
         beginDate_ = Convert.ToDateTime(value);
}
        
} 
       
    }
}   
         
public virtual String EndDate{
  
    set{
         if(value == null) value = "";
        if(value == ""){endDate_ = null;}else{
	 if((value).Trim(' ')== "today"){
         endDate_ = DateTime.Now;
}else{
         endDate_ = Convert.ToDateTime(value);
}
        
} 
       
    }
}   
public virtual String buyNowURL{
    get{
        return viewTicketsUrl_;
    }
    set{
        if(value == "") value = null;
        viewTicketsUrl_  = value;
    }
}   
public virtual String connection1{
    get{
        return connection1_;
    }
    set{
        if(value == "") value = null;
        connection1_ = value;
    }
}             
public virtual String connection2{
    get{
        return connection2_;
    }
    set{
        if(value == "") value = null;
        connection2_ = value;
    }
}   

public virtual String connection3{
    get{
        return connection3_;
    }
    set{
        if(value == "") value = null;
        connection3_ = value;
    }
}                        
protected override void Render( HtmlTextWriter writer){
DataGrid TicketDataGrid = new DataGrid();

   DataRow dr;
        DataTable dt = new DataTable();
        dt.Columns.Add(new DataColumn("Event", typeof(string)));
        dt.Columns.Add(new DataColumn("Venue", typeof(string)));
        dt.Columns.Add(new DataColumn("Date/Time", typeof(string)));
        dt.Columns.Add(new DataColumn(" ", typeof(string)));
String strSQL = "select * from events where true ";
try{
   //     MySqlConnection myConnection = new MySqlConnection("server=localhost;port=1378;user id=harry;password=hjs6a41;database=jproj;");
    

if(eventName_ != null){
eventName_ = eventName_.Replace("'","\\'");
strSQL += " and Name like '%"+eventName_+"%' ";

}
if(performerName_ != null){
performerName_ = performerName_.Replace("'","\\'");
strSQL += " and Name like '%"+performerName_+"%' ";

}
if(venueName_ != null){
venueName_ = venueName_.Replace("'","\\'");
strSQL += " and Venue='"+venueName_+"' ";

}
if(location_ != null){
location_ = location_.Replace("'","\\'");
strSQL += " and City='"+location_+"' ";

}
if(stateProvince_ != null){
stateProvince_ = stateProvince_.Replace("'","\\'");
strSQL += " and StateProvince='"+stateProvince_+"' ";

}

if(parentCategoryID_ != null){

strSQL += " and ParentCategoryID="+parentCategoryID_+" ";

}

if(childCategoryID_ != null){

strSQL += " and ChildCategoryID="+childCategoryID_+" ";

}

if(grandchildCategoryID_ != null){
strSQL += " and GrandchildCategoryID="+grandchildCategoryID_+" ";
}
if(beginDate_ != null){
DateTime bdt =  (DateTime)beginDate_;
strSQL += " and DATE >= STR_TO_DATE('"+bdt.ToString("MM/dd/yyyy")+"','%m/%d/%Y') ";
}
if(endDate_ != null){
DateTime edt =  (DateTime)endDate_;
strSQL += " and DATE <= STR_TO_DATE('"+edt.ToString("MM/dd/yyyy")+"','%m/%d/%Y') ";
}
strSQL += " order by Date ";
if(numberOfEvents_ != null){

strSQL += " LIMIT "+numberOfEvents_+" ";

}


    DataSet myDataSet = new DataSet();
  MySqlConnection conn = null;
//OdbcConnection conn= null;
bool connected = false;
int attempts_to_connect = 0;
if(!connected){
try{
attempts_to_connect++;
    //conn= new OdbcConnection(connection1_);
    conn = new MySqlConnection(connection1_);
    conn.Open();
    connected=true;
}catch(Exception ce){
    conn = null;
}
}
if(!connected){
try{
attempts_to_connect++;
    conn = new MySqlConnection(connection2_);
    //conn= new OdbcConnection(connection2_);
     conn.Open();
    connected=true;
}catch(Exception ce){
conn = null;
}

}
if(!connected){
try{
attempts_to_connect++;
   // conn= new OdbcConnection(connection3_);
       conn = new MySqlConnection(connection3_);
 conn.Open();
    connected=true;
}catch(Exception ce){
conn = null;
}

}

//dt.Columns.Add(new DataColumn(" "+attempts_to_connect, typeof(string)));
// strSQL ="Select * from events where Name like '%rush%'";
    //conn.Open();
    //OdbcDataAdapter da = new OdbcDataAdapter(strSQL, conn);
    MySqlDataAdapter da = new MySqlDataAdapter(strSQL, conn);
    da.Fill(myDataSet, "Events");
    conn.Close();


     int eventCount =0;
     foreach ( DataTable table in myDataSet.Tables )
		{
			// Repeat for each row in the table.
			foreach ( DataRow row in table.Rows )
			{
				dr = dt.NewRow();
           DateTime date_time = (DateTime)row["Date"];
           string time_string = date_time.ToString("h:mm tt");
           if(time_string == "3:30 AM") {time_string = "TBA";}
           dr[0] = row["Name"].ToString();
           dr[1] = row["Venue"].ToString() + "<br>" + row["City"].ToString() + "," + row["StateProvince"].ToString() + " ";
           dr[2] = date_time.DayOfWeek + "<br>" + date_time.Month +"/" + date_time.Day + "/" +date_time.Year + "<br>" + time_string;
           dr[3] =  "<a href=\"" + viewTicketsUrl_ + row["ID"].ToString() + "\"><div align=center>View<BR>Tickets</div></a>";
          
        
	            
           eventCount++;
           dt.Rows.Add(dr);
				
				
			}
		}     
      	            

         	
       if(eventCount==0){
            //no events
             dt = new DataTable();
             dt.Columns.Add(new DataColumn("Event", typeof(string)));
             dt.Columns.Add(new DataColumn("Venue", typeof(string)));
             dt.Columns.Add(new DataColumn("Date/Time", typeof(string)));
             dt.Columns.Add(new DataColumn(" ", typeof(string)));
            
             String spaces = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
             dr = dt.NewRow();
             dr[0] = "Sorry, no events found at this time." + spaces;
             dr[1] = spaces+spaces+spaces;
             dr[2] = spaces+spaces+spaces;
             dr[3] = spaces;
            dt.Rows.Add(dr);
         }

        }catch(Exception event_request_exception){
            //something went wrong.
             dt = new DataTable();
             dt.Columns.Add(new DataColumn("Event", typeof(string)));
             dt.Columns.Add(new DataColumn("Venue", typeof(string)));
             dt.Columns.Add(new DataColumn("Date/Time", typeof(string)));
             dt.Columns.Add(new DataColumn(" ", typeof(string)));
        
             
             String spaces = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
             dr = dt.NewRow();
             dr[0] = "Sorry, an error occured while processing your request.<br>Please try again later.";
             dr[1] = spaces+spaces+spaces;
             dr[2] = spaces+spaces+spaces;
             dr[3] = spaces;
          
             dt.Rows.Add(dr);
            
        }

        DataView dv = new DataView(dt);
        //TicketDataGrid.Width = 600;
      //TicketDataGrid.Height= 400;
            TicketDataGrid.BorderColor=System.Drawing.Color.Black;
         TicketDataGrid.BorderWidth=1;
         TicketDataGrid.GridLines=GridLines.Both;
         TicketDataGrid.CellPadding=3;
         TicketDataGrid.CellSpacing=0;
         TicketDataGrid.Font.Name="Verdana";
         TicketDataGrid.Font.Size=8;
         TicketDataGrid.HeaderStyle.BackColor=System.Drawing.ColorTranslator.FromHtml("#aaaadd");
        TicketDataGrid.DataSource = dv;
        TicketDataGrid.DataBind();
        TicketDataGrid.RenderControl(writer);
      
}//end of render
      
} //end of class
}//end of namespace