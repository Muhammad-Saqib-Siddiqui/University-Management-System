package university.management.system;

import com.toedter.calendar.JDateChooser;  // dob comes from "com.toedter.calendar" package but its not avaliable in java so are we first added the library of it in thre projects Library. then used "JDateChooser" to get the calander
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;

public class registration extends JFrame implements ActionListener{
    
    // Declaring all  the variables globally because we need all these in Action Listner also..
    JTextField tfname, tffname, tfaddress, tfphone, tfemail,  tfcnic , tfnation;
    JLabel lblnation;
    JDateChooser dcdob;
    JButton submit, cancel;

    JLabel imageLabel;       // To show selected image preview
    JButton btnChooseImage;  // Button to choose image
    File selectedImageFile;  // To store the chosen image file


    
     Random ran = new Random();   // using the random class to auto - generate  the roll numbers .. 
       long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L); 

// 1. ran.nextLong(): Generates a random long value that could be positive or negative.
// 2. ran.nextLong() % 9000L: Limits the random number to the range -8999 to 8999.
// 3. + 1000L: Shifts the range to 1000 to 9999.
// 4. Math.abs(): Ensures the number is always positive.
    
       
//    System.load("C:\\Users\\kk\\OneDrive\\Desktop\\4 th semester\\Database  Project\\Java-Projects-master\\opencv\\build\\java\\x64 \\opencv_java4110.dll");

    
    registration() {
        
        setSize(900, 500);
        setLocation(350, 50);
        setLayout(null);
        
        JLabel heading = new JLabel("Registration Page");  // creating a title named as "heading" 
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
        
        
        JLabel lbldob = new JLabel("Date of Birth");        // creating a  title named as  "Date of Birth"
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);
        
        dcdob = new JDateChooser();   // created the object of JDateChooser class.. and the calander is created automtically.   
        dcdob.setBounds(600, 200, 150, 30);
        add(dcdob);


        JLabel lblnation = new JLabel("Nationality");
        lblnation.setBounds(50, 200, 200, 30);
        lblnation.setFont(new Font("serif", Font.BOLD, 20));
        add(lblnation);
        
        tfnation = new JTextField();
        tfnation.setBounds(200, 200, 150, 30);
        add(tfnation);
        
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
        
        JLabel lblcnic = new JLabel("CNIC Number");
        lblcnic.setBounds(400, 300, 200, 30);
        lblcnic.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcnic);


        tfcnic = new JTextField();
        tfcnic.setBounds(600, 300, 150, 30);
        add(tfcnic);
        
        submit = new JButton("Submit");
        submit.setBounds(250, 400, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 400, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        
          // --- Image Upload Section Start ---

        JLabel lblImage = new JLabel("Upload Image");
        lblImage.setBounds(50, 350, 150, 30);
        lblImage.setFont(new Font("serif", Font.BOLD, 20));
        add(lblImage);

        // Button to open file chooser dialog
        btnChooseImage = new JButton("Choose Image");
        btnChooseImage.setBounds(200, 350, 150, 30);
        btnChooseImage.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnChooseImage.addActionListener(new ActionListener() {
    
            
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Select Profile Image");
                fileChooser.setAcceptAllFileFilterUsed(false);
                // Filter only image files
                fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif"));

                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedImageFile = fileChooser.getSelectedFile();
                    // Image preview set karna (resize karke)
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon(selectedImageFile.getAbsolutePath())
                        .getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
                    imageLabel.setIcon(imageIcon);
                }
            }
        });
        add(btnChooseImage);

        // Label to show image preview
        imageLabel = new JLabel();
        imageLabel.setBounds(400, 330, 120, 120);
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(imageLabel);
        
        
        
        setVisible(true);
    }
    
public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == submit) {
        String name = tfname.getText();
        String fname = tffname.getText();
        String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
        String address = tfaddress.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String cnic = tfcnic.getText();
        String nationality = tfnation.getText();

        try {
            Conn con = new Conn();

            // Image null check
            if (selectedImageFile == null) {
                JOptionPane.showMessageDialog(null, "Please select an image before submitting.");
                return;
            }

            // Prepare FileInputStream for image
            FileInputStream fis = new FileInputStream(selectedImageFile);

            String query = "INSERT INTO registration(name, fname, dob, address, phone, email, nationality, cnic, image) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.c.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, fname);
            ps.setString(3, dob);
            ps.setString(4, address);
            ps.setString(5, phone);
            ps.setString(6, email);
            ps.setString(7, nationality);
            ps.setString(8, cnic);
            ps.setBinaryStream(9, fis, (int) selectedImageFile.length());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registered Successfully");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        setVisible(false);
    }
}
    public static void main(String[] args) {
        new registration();
    }
}


