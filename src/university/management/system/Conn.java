package university.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;       // mysql  me "Connection" Interface ha jis ka refrence variable (c) create kiya .
    Statement s;

    // my sql is an external entity and there are chances for exceptions to occur so using try & catch
    
    Conn () {
        try {                                 
//          Step#1 : Register the Driver Class                      // "com.mysql.cj.jdbc" : yeh hamara package name ha.
            Class.forName("com.mysql.cj.jdbc.Driver");              //  "Driver" : hamari class ha.

//          Step#2 : Creating the Connection String : mtlb jis database se connect krne wale ho oski information mention kro. like here we are connecting to mysql database

//    Driver Manager ik "class" ha jis me .getConnection() "method" hota ha jis connection string ka "URL" pass krte han. 

// Syntax of Connection String:

//   2a.   Write the method by which we are connecting our project with database.here we are using  "jdbc".
//   2b.   then ":" and then write the name of the database to which we are connecting for here it is: "mysql"

//   2c.   then ":///:" the write the name of the address where my mysql is runninig.
//        Here it is running on "universitymanagementsystem"
//
//   2d.   then the name of the default username. here it is "root" , by deafult.
//   2e.   then the password of the username .here it is "waqarriasat30" ,this is to be set when setting up your mysql for the first time 
            
//            c = DriverManager.getConnection("jdbc:mysql:///universitymanagementsystem", "root", "waqarriast30");
c = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/universitymanagementsystem", "root", "waqarriasat30");

//          3.Creating the statement : used to execute myqsl quries
            s = c.createStatement();
            
        } catch (Exception e) {
            e.printStackTrace();   //  if exception occured  then print it.
        }
    }
} 
