package payroll_system;

import java.awt.*;
import javax.swing.*;
// created this class  for just better representation 
class splash{
    public static void main(String s[]){
        sframe f1 = new sframe("Payroll System  Free Licence Version 2.0"); 
        f1.setVisible(true); //show
        int i;
        int x=1;
        for(i=2;i<=600;i+=4,x+=1){
            f1.setLocation((800-((i+x)/2) ),500-(i/2)); //open the menu and the window of the frame with sum spped and incremented at some speed 
            f1.setSize(i+x,i); //iterartivly increses the size of the window till the perfect size for that purpose we are using it.
            
            try{
                Thread.sleep(10); //it will close and open the window at every 0.01sec 
            }catch(Exception e) { } // handling any exception if it will occur
        }
    }
}
class sframe extends JFrame implements Runnable{
    Thread t1;
    sframe(String s){
        super(s); // frame title
        setLayout(new FlowLayout()); 
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("payroll_system\\icon\\payroll_system.jpg"));
        Image i1 = c1.getImage().getScaledInstance(730, 550,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        
        JLabel m1 = new JLabel(i2);
        add(m1);
        t1= new Thread(this);
        t1.start(); // start the thread
    }
    public void run(){
        try{
            Thread.sleep(7000);//thread will sleep every 7 sec
            this.setVisible(false);// clsoing the window
            login f1 = new login();// and opening the login window
            
        }catch(Exception e){
            e.printStackTrace(); 
        }
    }
}
//after this class login class will bw appear
