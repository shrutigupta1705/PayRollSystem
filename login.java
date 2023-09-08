package payroll_system;

import java.awt.*;// for graphical user interface
import java.awt.event.*;// for event handling over the buttons
import javax.swing.*;// for better graphical user interface
import java.sql.*;// for connecting with database

public class login extends JFrame implements ActionListener{
    JLabel l1,l2; // storing username and password
    JTextField t1; // storing entered value form the user which is username
    JPasswordField t2; // storing the entered value form the user which is password 
    JButton b1,b2; // b1 -> login, b2 -> closing and canceling purpose
    
    login(){
        super("Login Page");// frame heading
        setLayout(new BorderLayout());
        t2 = new JPasswordField(10);
        t1 = new JTextField(10);
        JLabel l = new JLabel(new ImageIcon(ClassLoader.getSystemResource("payroll_system\\icon\\defaultpic.png")));
        
        b1 = new JButton("Submit", new ImageIcon(ClassLoader.getSystemResource("payroll_system\\icon\\login.png")));
        b2 = new JButton("Cancel", new ImageIcon(ClassLoader.getSystemResource("payroll_system\\icon\\Cancel.png")));
        
        b1.addActionListener(this);
        b2.addActionListener(this);

        JPanel p1,p2,p3,p4;
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p4=new JPanel();


 
        add(l,BorderLayout.WEST);// l is storing the image and we set the location of the image in frame as west


        p2.add(new JLabel("User Name  ")); // inside panel p2 we are adding new lable which is user name
        p2.add(t1);// aadding the text filed 
        p2.add(new JLabel("Password ")); //inside panel p2 we are adding new lable which is password
        p2.add(t2); // adding the text filed 
        add(p2,BorderLayout.CENTER); 

        p4.add(b1); // adding button in the panel 
        p4.add(b2); // adding button in the panel

        add(p4,BorderLayout.SOUTH);// added the panle in the frame 

      
        setSize(400,250);// size of frame
        setLocation(600,400);// location of frame	
        setVisible(true);// show

    }
    public void actionPerformed(ActionEvent ae){
        try
        {
            Conn c1=new Conn(); // intialize the connection with the db
            String u=t1.getText();//it will take the text entered by the user(username) and stored it in the u 
            String v=t2.getText();// it will take the text entered by the user(password) and stored it in  the v
            
            String q="select * from login where username='"+u+"' and password='"+v+"'";// creating the query, which checks if there is any person in the db which has same username an dpassword, if any then it will retrive the data from the db and taking the control of the program into the new window which is new Project. 
            
            ResultSet rs=c1.s.executeQuery(q); // query execute
            if(rs.next())// it will fetch the record for the particular username and password if if match  if it does not match then it will retuen null so if it retune null the if block is not executed
            {
                new project().setVisible(true);
                setVisible(false);// setting the visiblty of current window as false
            }else // if the password and username does not match
            {
                JOptionPane.showMessageDialog(null, "Invalid login");
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args){
        new login();
    }
}// after the successful login of user project class will be appare

