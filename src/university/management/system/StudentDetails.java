package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;  // result class is under sql package
import net.proteanit.sql.DbUtils;  //  "DButils" is used to directly add the values in the table . "Dbutils" comes from an external package " rs2xml.jar".
import java.awt.event.*;  

public class StudentDetails extends JFrame implements ActionListener {

    Choice crollno;
    JTable table;
    JButton search, print, update, add, cancel;
    
    StudentDetails() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20, 20, 150, 20);
        add(heading); 
        
        crollno = new Choice();   // creating a drop-down  to store roll numbers using choice class
        crollno.setBounds(180, 20, 150, 20);
        add(crollno);
        
        try {
            sql_server_connection c = new sql_server_connection();  // To Hit the query with mysql we have created a connection with the help of connection class 
            ResultSet rs = c.s.executeQuery("select * from student");  // storing the result(rs) of the query in the "ResultSet" 
            while(rs.next()) {  // kiya rs me values han ?
                crollno.add(rs.getString("rollno"));  //  rs.getString(" column_name ") : sirf roll_numbers ko retrieve krwayega database se. 
                // "crollno. add()" : onko "crollono" me store krdega jb tk values khatam nhi hojati  
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
                sql_server_connection c = new sql_server_connection();  // To Hit the query with mysql we have created a connection with the help of connection class 
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs)); // data can be passed directly into the table in the frame not in the database..  
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);  //creating an object of "JscrollPane" to create a "scroll bar".
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        add = new JButton("Add");
        add.setBounds(220, 70, 80, 20);
        add.addActionListener(this);
        add(add);
        
        update = new JButton("Update");
        update.setBounds(320, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(420, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from student where rollno = '"+crollno.getSelectedItem()+"'";  // "select * from student where rollno" returns only the roll numbers . 
            try {                         //   "crollno.getSelectedItem()":Retrieves the currently selected item from the crollno component.    
            
                sql_server_connection c = new sql_server_connection();  // To Hit the query with mysql we have created a connection with the help of connection class 
                ResultSet rs = c.s.executeQuery(query);             // ".resultSetToTableModel() " pass  the object of the resultSet which contains the query..
                table.setModel(DbUtils.resultSetToTableModel(rs));  // now used Dbutlis here to pass data directly to the table in the frame.
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();    // opens the real print commands
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == add) {
            setVisible(false);
            new AddStudent();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateStudent();
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentDetails();
    }
}
