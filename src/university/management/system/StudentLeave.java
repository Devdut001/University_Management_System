package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class StudentLeave extends JFrame implements ActionListener {
    
    Choice rollno, timeduration;
    JDateChooser dob;
    JButton submit, cancel;
    
    StudentLeave(){
        
        setLayout(null);
        
        JLabel heading = new JLabel("Apply Leave (Student)");
        heading.setBounds(150,20,300,30);
        heading.setFont(new Font("serif", Font.BOLD, 20));
        add(heading);
        
        //search roll no
        
        JLabel heading2 = new JLabel("Search by Roll Number:");
        heading2.setBounds(40,80,200,30);
        heading2.setFont(new Font("tahoma", Font.BOLD, 16));
        add(heading2);
        
        rollno = new Choice();
        rollno.setBounds(280,85,150,30);
        heading2.setFont(new Font("tahoma", Font.BOLD, 16));
        add(rollno);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()){
                rollno.add(rs.getString("Roll_No"));
            }
        } catch (Exception e){
            System.out.println(e);
        }
        
        //date
        
        JLabel lbldob = new JLabel("Date:");
        lbldob.setBounds(40,160,150,30);
        lbldob.setFont(new Font("tahoma", Font.BOLD, 16));
        add(lbldob);
        
        dob = new JDateChooser();
        dob.setBounds(280,160,150,25);
        dob.setFont(new Font("tahoma", Font.BOLD, 16));
        add(dob);
        
        //time duration
        
        JLabel lbltimeduration = new JLabel("Time Duration:");
        lbltimeduration.setBounds(40,240,150,30);
        lbltimeduration.setFont(new Font("tahoma", Font.BOLD, 16));
        add(lbltimeduration);
        
        timeduration = new Choice();
        timeduration.setBounds(280,240,150,30);
        timeduration.add("Full Day");
        timeduration.add("Half Day");
        add(timeduration);
        
        //buttons
        
        submit = new JButton("Submit");
        submit.setBounds(100,350, 120,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(270,350, 120,30);
        cancel.addActionListener(this);
        add(cancel);
        
        //display 
        
        getContentPane().setBackground(Color.white);
        setSize(500,500);
        setLocation(350,30);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            String srollno = rollno.getSelectedItem();
            String sdate = ((JTextField) dob.getDateEditor().getUiComponent()).getText();
            String sduration = timeduration.getSelectedItem();
            
            String query = "insert into studentleave values('"+srollno+"', '"+sdate+"', '"+sduration+"')";
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed.");
            } catch (Exception e){
                System.out.println(e);
            }
        } else {
            setVisible(false);
        }
        
    }
            
    
    public static void main(String args[]){
        
        new StudentLeave();
    }
}
