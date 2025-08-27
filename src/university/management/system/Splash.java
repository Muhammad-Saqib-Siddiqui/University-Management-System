package university.management.system;

                                        // Creating a MAIN class 


import javax.swing.*;   // the extended (java"x") swing package includes the Jframe class 
import java.awt.*;      // image class awt package ke ander hoti h .
import  java.util.*;

public class Splash extends JFrame  implements Runnable{   //runnable is used for the multi-threading concept,(thread.sleep(7000)..

    Thread t;
    
    Splash(){
    
//  the  frame opens by defaut from the top left of the screen / its the orign of the Frame ...
 
//    creating an object to set the image on the frame...
        ImageIcon I1 = new ImageIcon (ClassLoader.getSystemResource("icons/first.jpg" ));          // classLoader :"system se image uthao".     
                                                                                                   // .getSystemResource(address of image)  : "is location se image uthao".
        
// to scale the image we use the    ".getScaledInstance(width,height,SCALE_DEFAULT)"   function which scales the image.
// Image class is inherited from java.awt package. 
// I1 wali image ko edit krna ha so we used  I1.getImage(). mtlb I1 ki image ko scale kro...

        Image i2 = I1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);                                                                                           
        
//        Image class object ko ap direct JLabel me pass nhi kr sakte ,thats why we have again creted ImageIcon class object(I3) and passed Image(I2) in it . 
        ImageIcon I3  = new ImageIcon(i2);                                     
        
//    image cant be passed directly to the "add()" function 
//    to pass the image we create an object of the "JLabel class"  
    
      JLabel image = new  JLabel(I3);  
    
//    now passing the object "image" to the add() which sets the image on the screen.. 
      add(image);
      
t = new Thread(this);  // current class ka object (this) pass kiya.
t.start();  // run method ko call karega 
      
        setVisible(true);      // sets the visiblility of the Frame to true.. which is false by default.
        setLocation(150,50);  // sets the location of the frame by taking 2 arguments 
//                              (distance from the left , distance from the top)

        setSize(1100,650);     // sets the size of taking 2 parameters (length , width)  of  the frame .. 
        
    int x = 1;
        for (int i = 2; i <= 600; i+=4, x+=1) {
            setLocation(500 - ((i + x)/2), 330 - (i/2));
            setSize(i + 3*x, i + x/2);
            
            try {
                Thread.sleep(10);
            } catch (Exception e) {}
        }        
    }
    
    


    @Override
    public void run(){  // Overriden the abstract method of the interface runnable.. 
    try{
        System.out.println("Splash screen started");
        Thread.sleep(5000);      //  5 seconds tk screen visible rahegi
        System.out.println("Splash screen ended");
        setVisible(false);      //   screen  ki visibilty false krdo after 7 seconds
  
        
    // NextFrame
       new Login();   // login class ka object define kiya h because object create hote hi class ka constructor call hoga jis me sari coding h Login ki.. 
    }
    catch(Exception e ){
        e.printStackTrace();
    }
}


    public static void main(String[] args) {


//        creating a object of the class

        Splash sp = new Splash();   //the constructor  is called 
//        sp.run();
    }
}
