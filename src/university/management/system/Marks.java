
package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Marks extends JFrame {
    
    String rollno;
    
    Marks(String rollno){
        this.rollno = rollno;
        
        setLayout(null);
        
        JLabel heading = new JLabel("GMIT");
        heading.setBounds(200,10,500,25);
        heading.setFont(new Font("tahoma", Font.BOLD, 20));
        add(heading);
        
        JLabel subheading = new JLabel("Result of Examination 2024");
        subheading.setBounds(100,50,500,20);
        subheading.setFont(new Font("tahoma", Font.BOLD, 18));
        add(subheading);
        
        JLabel lblrollno = new JLabel("Roll No  "+rollno);
        lblrollno.setBounds(60,100,500,20);
        lblrollno.setFont(new Font("tahoma", Font.PLAIN, 18));
        add(lblrollno);

        JLabel lblsemester = new JLabel();
        lblsemester.setBounds(60,130,500,20);
        lblsemester.setFont(new Font("tahoma", Font.PLAIN, 18));
        add(lblsemester);
        
        JLabel sub1 = new JLabel();
        sub1.setBounds(100,200,500,20);
        sub1.setFont(new Font("tahoma", Font.PLAIN, 18));
        add(sub1);
        
        JLabel sub2 = new JLabel();
        sub2.setBounds(100,230,500,20);
        sub2.setFont(new Font("tahoma", Font.PLAIN, 18));
        add(sub2);
        
        JLabel sub3 = new JLabel();
        sub3.setBounds(100,260,500,20);
        sub3.setFont(new Font("tahoma", Font.PLAIN, 18));
        add(sub3);
        
        JLabel sub4 = new JLabel();
        sub4.setBounds(100,290,500,20);
        sub4.setFont(new Font("tahoma", Font.PLAIN, 18));
        add(sub4);
        
        JLabel sub5 = new JLabel();
        sub5.setBounds(100,320,500,20);
        sub5.setFont(new Font("tahoma", Font.PLAIN, 18));
        add(sub5);
        
        try{
            Conn c = new Conn();
            ResultSet rs1 = c.s.executeQuery("select * from subject where Roll_No = '"+rollno+"'");
            while (rs1.next()){
                sub1.setText(rs1.getString("Subject1"));
                sub2.setText(rs1.getString("Subject2"));
                sub3.setText(rs1.getString("Subject3"));
                sub4.setText(rs1.getString("Subject4"));
                sub5.setText(rs1.getString("Subject5"));
            }
            ResultSet rs2 = c.s.executeQuery("select * from marks where Roll_No = '"+rollno+"'");
            while (rs2.next()){
                sub1.setText(sub1.getText()+"-----------------"+ rs2.getString("Marks1"));
                sub2.setText(sub2.getText()+"-----------------"+ rs2.getString("Marks2"));
                sub3.setText(sub3.getText()+"-----------------"+ rs2.getString("Marks3"));
                sub4.setText(sub4.getText()+"-----------------"+ rs2.getString("Marks4"));
                sub5.setText(sub5.getText()+"-----------------"+ rs2.getString("Marks5"));
                lblsemester.setText("Semester  " + rs2.getString("Semester")); 
            }
        } catch (Exception e){
            System.out.println(e);
        }
        
        getContentPane().setBackground(Color.white);
        setSize(500,600);
        setLocation(350,50);
        setVisible(true);
        
    }
    public static void main(String args[]){
        new Marks("");
    }
    
}
