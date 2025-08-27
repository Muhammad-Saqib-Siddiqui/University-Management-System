import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PROJECT extends JFrame implements ActionListener{

    
    PROJECT(){

        setSize(1370,735);
    
        ImageIcon  i1 =  new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1370, 650, Image.SCALE_DEFAULT);
        ImageIcon  i3 = new ImageIcon(i2);
        JLabel  image = new JLabel(i3);
        add(image);
        
        JMenuBar mb = new JMenuBar();              // A menu named "mb" is created by using the class JMenuBar... 
        
        
        JMenu info = new JMenu("new Information"); //  menu(mb) me "new information" ka section banao...
        info.setForeground(Color.BLUE);
        info.addActionListener(this);
        mb.add(info);                              // menu bar me "new informatoin" ko add kro...
        
        
        
        JMenu faculty_info = new JMenu("new Facutly Information"); //  "new faculty Information" ka section create karo...
        faculty_info.setForeground(Color.red);
        faculty_info.addActionListener(this);
        info.add(faculty_info);                    //   info  me " new Faculty Information " ko add kro... 
        
        
        JMenu student_info = new JMenu("new Student Information");
        student_info.setForeground(Color.BLUE);
        student_info.addActionListener(this);
        info.add(student_info);                  //  info  me " new Faculty Information " ko add kro... 
        
        
        
      JMenu details = new JMenu("View Details"); //  menu me "view details" ka section banao...
        info.setForeground(Color.BLUE);

        mb.add(details);                              // menu bar  pr "view details" ko add kro...
        
        
        
        JMenu faculty_detail = new JMenu("view Facutly Details");
        faculty_detail.setForeground(Color.red);
        faculty_detail.addActionListener(this);
        details.add(faculty_detail);
        
 
        JMenu student_detail = new JMenu("view student Details");
        student_detail.setForeground(Color.red);
        student_detail.addActionListener(this);
        details.add(student_detail);
        
        
//      APPLY LEAVE         
        
        JMenu leave = new JMenu("Apply Leave"); //  menu me "new information" ka section banao...
        leave.setForeground(Color.BLUE);
        mb.add(leave);
        
        
        JMenu student_leave = new JMenu("Student Leave");
        student_leave.setForeground(Color.red);
        student_leave.addActionListener(this);
        leave.add(student_leave);
        
        
        JMenu faculty_leave = new JMenu("Faculty Leave");
        faculty_leave.setForeground(Color.red);
        faculty_leave.addActionListener(this);
        leave.add(faculty_leave);
        
        

//      LEAVE DETAILS

        JMenu leave_details = new JMenu("Leave Details"); //  menu me "new information" ka section banao...
        //leave.setForeground(Color.BLUE);
        leave_details.addActionListener(this);
        mb.add(leave_details);
        
        
        JMenu faculty_leave_details = new JMenu("Faculty Leave Details");
        faculty_leave_details.setForeground(Color.red);
        faculty_leave_details.addActionListener(this);
        leave_details.add(faculty_leave_details);
        
        
        JMenu student_leave_details = new JMenu("Student Leave Details");
        student_leave_details.setForeground(Color.red);
        student_leave_details.addActionListener(this);
        leave_details.add(student_leave_details);



//        EXAMINATION

        JMenu exam = new JMenu("Examination"); //  menu me "new information" ka section banao...
        exam.setForeground(Color.BLUE);
        mb.add(exam);
        
        
        JMenu exam_results = new JMenu("Examination Results");
        exam_results.setForeground(Color.red);
        exam_results.addActionListener(this);
        exam.add(exam_results);
        
        
        JMenu enter_marks = new JMenu("Enter Marks");
        enter_marks.setForeground(Color.red);
        enter_marks.addActionListener(this);
        exam.add(enter_marks);

        

        // UPDATE DETAILS      
        
        JMenu update = new JMenu("Update Details"); //  menu me "new information" ka section banao...
        mb.add(update);
        
        
        JMenu update_faculty_det = new JMenu("Update faculty Details");
        update_faculty_det.setForeground(Color.red);
        update_faculty_det.addActionListener(this);
        update.add(update_faculty_det);
        
        
        JMenu update_Student_det = new JMenu("Update Student Details");
        update_Student_det.setForeground(Color.red);
        update_Student_det.addActionListener(this);
        update.add(update_Student_det);

        
        
        
       // FEE DETAILS 
        
        JMenu fees = new JMenu("Fee Details"); 
        fees.setForeground(Color.BLUE);
        fees.addActionListener(this);
        mb.add(fees);
        
        
        JMenu fee_structure = new JMenu("Fee Structure");
        fee_structure.setForeground(Color.red);
        fee_structure.addActionListener(this);
        fees.add(fee_structure);
        
        
        JMenu Fee_Form = new JMenu("Student Fee form");
        Fee_Form.setForeground(Color.red);
        Fee_Form.addActionListener(this);
        fees.add(Fee_Form);
       
        
        


        // Utilities

        JMenu util = new JMenu("Utilities"); 
        //util.setForeground(Color.BLUE);
        mb.add(util);
        
        
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setForeground(Color.red);
        notepad.addActionListener(this);
        util.add(notepad);
        
        
        JMenuItem cal = new JMenuItem("Calculator");
        cal.setForeground(Color.red);
        cal.addActionListener(this);
        util.add(cal);
      
        
      
        // ABOUT  
        
        JMenu about = new JMenu("About"); 
        about.setForeground(Color.BLUE);
        about.addActionListener(this);
        mb.add(about);
        
        
        JMenu us = new JMenu("About Us");
        us.setForeground(Color.red);
        us.addActionListener(this);
        about.add(us);
        
       
        // EXIT
        
        JMenu exit = new JMenu("Exit"); 
        mb.add(exit);
        
        
        JMenuItem end = new JMenuItem("GoodBye");
        end.setForeground(Color.red);
        exit.add(end);
        end.addActionListener(this);
        
        
        setJMenuBar(mb);
        setVisible(true);   //should always be the last statement

    }
    
public void actionPerformed(ActionEvent ae) {
        
    String msg = ae.getActionCommand();
            
        if(msg.equals("GoodBye")){
            setVisible(false);
        }
        else if(msg.equals("Calculator")){
         
            try{                                            // try or catch isliye use kiya h because calcuator hamare project ke ander nhi h. so exceptions ane ke chances boht han.
                Runtime.getRuntime().exec("calc.exe");      // runtime class ke ander .getRuntime() ka function h jo executable files ko run krwayega. like(calculator ki : calc.exec)    
        }
            catch(Exception e){
                
        }
    }
        else if(msg.equals("Notepad")){
         
            try{
                Runtime.getRuntime().exec("notepad.exe");
        }
            catch(Exception e){
        }
    }
}

public static void main(String[]args){
    
    PROJECT p = new PROJECT();
    }
}





