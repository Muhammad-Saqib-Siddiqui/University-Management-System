package university.management.system;

import com.toedter.calendar.JDateChooser;  // dob comes from "com.toedter.calendar" package but its not avaliable in java so are we first added the library of it in thre projects Library. then used "JDateChooser" to get the calander
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class AddStudent extends JFrame implements ActionListener{
    
    // Declaring all  the variables globally because we need all these in ation Listner also..
    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfx, tfxii, tfcnic;
    JLabel labelrollno;
    JDateChooser dcdob;
    JComboBox cbcourse, cbbranch;
    JButton submit, cancel;
    
     Random ran = new Random();   // using the random class to auto - generate  the roll numbers .. 
       long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L); 
// 1. ran.nextLong(): Generates a random long value that could be positive or negative.
// 2. ran.nextLong() % 9000L: Limits the random number to the range -8999 to 8999.
// 3. + 1000L: Shifts the range to 1000 to 9999.
// 4. Math.abs(): Ensures the number is always positive.
    
    
    AddStudent() {
        
        setSize(900, 700);
        setLocation(350, 50);
        
        setLayout(null);
        
        JLabel heading = new JLabel("New Student Details");  // creating a title named as "heading" 
        heading.setBounds(310, 30, 500, 50);   // setting the distance of the font .
        heading.setFont(new Font("serif", Font.BOLD, 30));   // setting the font of the Layout  
        add(heading);
        
        JLabel lblname = new JLabel("Name");  
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);
        
        tfname = new JTextField();             // creating a  textfield for "Name"
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
        JLabel lblfname = new JLabel("Father's Name");    // creating a title named as "heading" 
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);
        
        tffname = new JTextField();                      // creating a  textfield for "Name"
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);
        
        JLabel lblrollno = new JLabel("Roll Number");       // creating a  title named as  "Name"
        lblrollno.setBounds(50, 200, 200, 30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollno);
        
        labelrollno = new JLabel("1533"+first4);  // concatinating the auto-generated roll_number with 1533 " 
        labelrollno.setBounds(200, 200, 200, 30);
        labelrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(labelrollno);
        
        JLabel lbldob = new JLabel("Date of Birth");        // creating a  title named as  "Date of Birth"
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);
        
        dcdob = new JDateChooser();   // created the object of JDateChooser class.. and the calander is created automtically.   
        dcdob.setBounds(600, 200, 150, 30);
        add(dcdob);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        JLabel lblx = new JLabel("Matriculation (%)");
        lblx.setBounds(400, 300, 200, 30);
        lblx.setFont(new Font("serif", Font.BOLD, 20));
        add(lblx);
        
        tfx = new JTextField();
        tfx.setBounds(600, 300, 150, 30);
        add(tfx);
        
        JLabel lblxii = new JLabel("Intermediate (%)");
        lblxii.setBounds(50, 350, 200, 30);
        lblxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lblxii);
        
        tfxii = new JTextField();
        tfxii.setBounds(200, 350, 150, 30);
        add(tfxii);
        
        JLabel lblcnic = new JLabel("CNIC Number");
        lblcnic.setBounds(400, 350, 200, 30);
        lblcnic.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcnic);
        
        tfcnic = new JTextField();
        tfcnic.setBounds(600, 350, 150, 30);
        add(tfcnic);
        
        JLabel lblcourse = new JLabel("Course");  
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);
        
        String course[] = {"B.Tech", "BBA", "BCA", "Bsc", "Msc", "MBA", "MCA", "MCom", "MA", "BA"}; // Adding values to the drop-down by using the array.
        cbcourse = new JComboBox(course);  //  created a "Drop-Down" which is empty initaially.
        cbcourse.setBounds(200, 400, 150, 30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);
        
        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);
        
        String branch[] = {"Computer Science", "Electronics", "Mechanical", "Civil", "IT"};   //adding vaalues to the drop-down 
        cbbranch = new JComboBox(branch);      // creating another drop-down for branch of the course 
        cbbranch.setBounds(600, 400, 150, 30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
        
        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
    
    
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String rollno = labelrollno.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();   // ".getDateEditor().getUiComponent" returns the date 
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String x = tfx.getText();
            String xii = tfxii.getText();
            String cnic = tfcnic.getText();
            
        //    .getSelectedItem() : returns an object so type  casting it to string 
            String course = (String) cbcourse.getSelectedItem();  // "course_comma_box (cbcourse)" ke ander jo value select ki h osko return karega ..eg(BBA , BSC etc)
            String branch = (String) cbbranch.getSelectedItem();   // selected branch ko return karega.
             
            try {
//      synatax of query:  insert into "table name" values ();"         
//     varchar sytax in database is : varchar(' "value" ') ,  so the values are to be inserted in ('') always.. 

  // synatax of query:  insert into "table name" values ();"         
        String query = "insert into student values('"+name+"', '"+fname+"', '"+rollno+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+x+"', '"+xii+"', '"+cnic+"', '"+course+"', '"+branch+"')";

                sql_server_connection c = new sql_server_connection();  // To Hit the query with mysql we have created a connection with the help of connection class 
                c.s.executeUpdate(query);     // .executeUpdate() : executes the query  / insert commands
                
                JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");  //  "if query executed" then "JOptionPane.showMessageDialog()"  shows a pop-up message of a specific statement like "Student Details Inserted Successfully"...
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new AddStudent();
    }
}

