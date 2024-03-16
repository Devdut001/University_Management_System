package university.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class EnterMarks extends JFrame implements ActionListener {
    
    Choice rollno2;
    JComboBox semester;
    JTextField sub1, sub2, sub3, sub4, sub5, marks1, marks2, marks3, marks4, marks5;
    JButton submit, cancel;
    
    EnterMarks(){
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,40,400,300);
        add(image);
        
        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50,0,500,50);
        heading.setFont(new Font("tahoma", Font.BOLD, 20));
        add(heading);
        
        //roll no search
        
        JLabel heading2 = new JLabel("Search by Roll Number:");
        heading2.setBounds(50,70,150,20);
        add(heading2);
        
        //adding roll no
        
        rollno2 = new Choice();
        rollno2.setBounds(200,70,150,20);
        add(rollno2);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()){
                rollno2.add(rs.getString("Roll_No"));
            }
        } catch (Exception e){
            System.out.println(e);
        }
        
        //semester selection
        
        JLabel lblsemester = new JLabel("Select Semester:");
        lblsemester.setBounds(50,110,150,20);
        add(lblsemester);
        
        String sSemester[]={"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"};
        semester = new JComboBox(sSemester);
        semester.setBounds(200,110,150,20);
        semester.setBackground(Color.white);
        add(semester);
        
        //subject selection
        
        JLabel lblentersubject = new JLabel("Enter Suject");
        lblentersubject.setBounds(100,150,200,40);
        add(lblentersubject);
        
        JLabel lblentermarks = new JLabel("Enter Marks");
        lblentermarks.setBounds(320,150,200,40);
        add(lblentermarks);
        
        //putting values
        
        sub1 = new JTextField();
        sub1.setBounds(50,200,200,20);
        add(sub1);
        
        sub2 = new JTextField();
        sub2.setBounds(50,230,200,20);
        add(sub2);
        
        sub3 = new JTextField();
        sub3.setBounds(50,260,200,20);
        add(sub3);
        
        sub4 = new JTextField();
        sub4.setBounds(50,290,200,20);
        add(sub4);
        
        sub5 = new JTextField();
        sub5.setBounds(50,320,200,20);
        add(sub5);
        
        marks1 = new JTextField();
        marks1.setBounds(250,200,200,20);
        add(marks1);
        
        marks2 = new JTextField();
        marks2.setBounds(250,230,200,20);
        add(marks2);
        
        marks3 = new JTextField();
        marks3.setBounds(250,260,200,20);
        add(marks3);
        
        marks4 = new JTextField();
        marks4.setBounds(250,290,200,20);
        add(marks4);
        
        marks5 = new JTextField();
        marks5.setBounds(250,320,200,20);
        add(marks5);
        
        //buttons
        
        submit = new JButton("Submit");
        submit.setBounds(70,360, 150,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(280,360, 150,30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        
        getContentPane().setBackground(Color.white);
        setSize(1000,500);
        setLocation(150,50);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            try{
                Conn c = new Conn();
                String query1 = "insert into subject values('"+rollno2.getSelectedItem()+"', '"+semester.getSelectedItem()+"', '"+sub1.getText()+"', '"+sub2.getText()+"', '"+sub3.getText()+"', '"+sub4.getText()+"', '"+sub5.getText()+"')";
                String query2 = "insert into marks values('"+rollno2.getSelectedItem()+"', '"+semester.getSelectedItem()+"', '"+marks1.getText()+"', '"+marks2.getText()+"', '"+marks3.getText()+"', '"+marks4.getText()+"', '"+marks5.getText()+"')";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Marks Inserted Successfully.");
                setVisible(false);
            } catch (Exception e){
                System.out.println(e);
            }
        } else {
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new EnterMarks();
    }
}
