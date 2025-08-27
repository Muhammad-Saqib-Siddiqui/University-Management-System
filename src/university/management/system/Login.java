package university.management.system;

import javax.swing.*;  
import java.awt.*;        // Color class awt package ke ander hoti h.
import java.awt.event.*;  // awt ko dobara import isliye krna para because "importjava.awt.*"  sirf awt ke ander ki classes ko import karga or awt ki event class ke methods ko import nhi karega .To do so we have used the" events.*" 
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JButton login, cancel;
    JTextField tfusername, tfpassword;
    
    Login () {
        
        getContentPane().setBackground(Color.WHITE);   //getContentPane frame ko select krega then .setBackground(Colour.x)
        setLayout(null);   // if you dont want to use the default layouts of swing then set it to null
        
        // Username .
        JLabel lblusername = new JLabel("Username");   //  main use of Jlabel is to create text on the frame
        lblusername.setBounds(40, 20, 100, 20);        // sets the location by using 4 arguments(distance from left , dis from top, width of txt , height of the txt)
        add(lblusername);
        
        // Text Field for username .
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 20);
        add(tfusername);
        
        //  Password
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 20);
        add(lblpassword);
        
        //  Text Field for password.
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 150, 20);
        add(tfpassword);
        
        // Login Button.
        login = new JButton("Login");              // using the JButton class to create a Login Button 
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);   // colors the text written on the Login Button
        login.addActionListener(this);      // click event ko recognize karega.
        login.setFont(new Font("Tahoma", Font.BOLD, 15));      // set.font takes 3 args: (font_family ,font_type,font_size)
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 140, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);     // click event ko recognize karega . if cancel button is called to "actionPerformed()" method ke pass jao 
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
//        getContentPane().setBackground(Color.decode("#F0F8FF"+ ""));

    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {        // ae.getSource(): check kr rha h ke konsa button call howa ha Login or Cancel.. 
            String username = tfusername.getText();    // if login is called then get  what is entered in  the username . 
            String password = tfpassword.getText();    // if login is called then get  what is entered in  the password .
            
            String query = "select * from login where username='"+username+"' and password='"+password+"'"; //created a mysql query     
            System.out.println("Query: " + query);

            // "select" keyword database me jo  tables create kiye the on me se kuch values ko utha kr layega jo "result"  ke object "rs" me store hongi . 
            try {
                sql_server_connection c = new sql_server_connection();  // To Hit the query with mysql we have created a connection with the help of connection class 
                ResultSet rs = c.s.executeQuery(query);   // executing mysql query by using .executeQuery() and passing the qurey.
                
                if (rs.next()) {  // the .next() function checks whether the value is present in rs or not if is present then returns "True" and executes the if statement.  and if not then it goes to the else statement. 
                    setVisible(false);
                    new Project();   // open the project class.
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");  // if username & password didnt matched then display the message.
                    setVisible(false);
                }
                c.s.close();   // step 5 (optional)
                
                } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}