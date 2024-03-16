package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateTeacher extends JFrame implements ActionListener {
    
    JTextField address, phnnumber, email, course, branch;
    JLabel rollno;
    Choice rollno2;
    JButton submit, cancel;
    
    UpdateTeacher(){
        
        setLayout(null);
        
        //heading
        
        JLabel heading = new JLabel("Update Teacher Information");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("tahoma", Font.BOLD, 20));
        add(heading);
        
        //roll no search
        
        JLabel heading2 = new JLabel("Search by EmployeeID:");
        heading2.setBounds(50,100,200,20);
        heading2.setFont(new Font("serif", Font.BOLD, 18));
        add(heading2);
        
        //adding roll no
        
        rollno2 = new Choice();
        rollno2.setBounds(270,100,150,20);
        rollno2.setFont(new Font("serif", Font.BOLD, 18));
        add(rollno2);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()){
                rollno2.add(rs.getString("Employee_ID"));
            }
        } catch (Exception e){
            System.out.println(e);
        }
        
        //name
        
        JLabel lblname = new JLabel("Name:");
        lblname.setBounds(50,150,50,30);
        lblname.setFont(new Font("serif", Font.BOLD, 16));
        add(lblname);
        
        JLabel name = new JLabel();
        name.setBounds(120,150,250,30);
        name.setFont(new Font("serif", Font.BOLD, 16));
        add(name);
        
        //father's name
        
        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("serif", Font.BOLD, 16));
        add(fname);
        
        JLabel fathername = new JLabel();
        fathername.setBounds(550,150,250,30);
        fathername.setFont(new Font("serif", Font.BOLD, 16));
        add(fathername);
        
        //Roll No
        
        JLabel lblrollno = new JLabel("EmployeeID:");
        lblrollno.setBounds(50,220,100,30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 16));
        add(lblrollno);
        
        rollno = new JLabel();
        rollno.setBounds(150,220,150,30);
        rollno.setFont(new Font("serif", Font.BOLD, 20));
        add(rollno);
        
        // DOB
        
        JLabel lbldob = new JLabel("Date of Birth:");
        lbldob.setBounds(400,220,150,30);
        lbldob.setFont(new Font("serif", Font.BOLD, 16));
        add(lbldob);
        
        JLabel dob = new JLabel();
        dob.setBounds(550,220,250,30);
        dob.setFont(new Font("serif", Font.BOLD, 16));
        add(dob);
        
        //address
        
        JLabel lbladdress = new JLabel("Address:");
        lbladdress.setBounds(50,290,100,30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 16));
        add(lbladdress);
        
        address = new JTextField();
        address.setBounds(120,290,250,30);
        address.setFont(new Font("serif", Font.BOLD, 16));
        add(address);
        
        //phone number
        
        JLabel lblphnnumber = new JLabel("Phone Number:");
        lblphnnumber.setBounds(400,290,150,30);
        lblphnnumber.setFont(new Font("serif", Font.BOLD, 16));
        add(lblphnnumber);
        
        phnnumber = new JTextField();
        phnnumber.setBounds(550,290,250,30);
        phnnumber.setFont(new Font("serif", Font.BOLD, 16));
        add(phnnumber);
        
        //email
        
        JLabel lblemail = new JLabel("Email Id:");
        lblemail.setBounds(50,360,100,30);
        lblemail.setFont(new Font("serif", Font.BOLD, 16));
        add(lblemail);
        
        email = new JTextField();
        email.setBounds(120,360,250,30);
        email.setFont(new Font("serif", Font.BOLD, 16));
        add(email);
        
        //class ten marks
        
        JLabel lbltenmarks = new JLabel("Class X (%):");
        lbltenmarks.setBounds(400,360,150,30);
        lbltenmarks.setFont(new Font("serif", Font.BOLD, 16));
        add(lbltenmarks);
        
        JLabel classx = new JLabel();
        classx.setBounds(550,360,250,30);
        classx.setFont(new Font("serif", Font.BOLD, 16));
        add(classx);
        
        //class twelve marks
        
        JLabel lbltwelvemarks = new JLabel("Class XII:");
        lbltwelvemarks.setBounds(50,430,100,30);
        lbltwelvemarks.setFont(new Font("serif", Font.BOLD, 16));
        add(lbltwelvemarks);
        
        JLabel classxii = new JLabel();
        classxii.setBounds(120,430,250,30);
        classx.setFont(new Font("serif", Font.BOLD, 16));
        add(classxii);
        
        //aadhaar no
        
        JLabel lblaadharno = new JLabel("Aadhar No:");
        lblaadharno.setBounds(400,430,150,30);
        lblaadharno.setFont(new Font("serif", Font.BOLD, 16));
        add(lblaadharno);
        
        JLabel aadharno = new JLabel();
        aadharno.setBounds(550,430,250,30);
        aadharno.setFont(new Font("serif", Font.BOLD, 16));
        add(aadharno);
        
        //course
        
        JLabel lblcourse = new JLabel("Education:");
        lblcourse.setBounds(50,500,100,30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 16));
        add(lblcourse);
        
        course = new JTextField();
        course.setBounds(120,500,250,30);
        course.setFont(new Font("serif", Font.BOLD, 16));
        add(course);
        
        
        // branch
        
        JLabel lblbranch = new JLabel("Department:");
        lblbranch.setBounds(400,500,150,30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 16));
        add(lblbranch);
        
        branch = new JTextField();
        branch.setBounds(550,500,250,30);
        branch.setFont(new Font("serif", Font.BOLD, 16));
        add(branch);
        
        //showing fix values
        
        try{
            Conn c = new Conn();
            String query = "select * from teacher where Employee_ID = '"+rollno2.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                name.setText(rs.getString("Name"));
                fathername.setText(rs.getString("Father_Name"));
                rollno.setText(rs.getString("Employee_ID"));
                dob.setText(rs.getString("Date_of_Birth"));
                address.setText(rs.getString("Address"));
                phnnumber.setText(rs.getString("Phone_Number"));
                email.setText(rs.getString("Email_ID"));
                classx.setText(rs.getString("Class_Ten"));
                classxii.setText(rs.getString("Class_Twelve"));
                aadharno.setText(rs.getString("Aadhar_No"));
                course.setText(rs.getString("Qualification"));
                branch.setText(rs.getString("Department"));
                        
            }
        } catch (Exception e){
            System.out.println(e);
        }
        
        rollno2.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c = new Conn();
                    String query = "select * from teacher where Employee_ID = '"+rollno2.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        name.setText(rs.getString("Name"));
                        fathername.setText(rs.getString("Father_Name"));
                        rollno.setText(rs.getString("Employee_ID"));
                        dob.setText(rs.getString("Date_of_Birth"));
                        address.setText(rs.getString("Address"));
                        phnnumber.setText(rs.getString("Phone_Number"));
                        email.setText(rs.getString("Email_ID"));
                        classx.setText(rs.getString("Class_Ten"));
                        classxii.setText(rs.getString("Class_Twelve"));
                        aadharno.setText(rs.getString("Aadhar_No"));
                        course.setText(rs.getString("Qualification"));
                        branch.setText(rs.getString("Department"));
                    }
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        });
        
        
        //buttons
        
        submit = new JButton("Update");
        submit.setBounds(250,550, 120,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450,550, 120,30);
        cancel.addActionListener(this);
        add(cancel);
        
        //views
        
        setSize(900,700);
        setLocation(220,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == cancel){
            setVisible(false);
        } else {
            String srollno = rollno.getText();
            String saddress = address.getText();
            String sphnnumber = phnnumber.getText();
            String semail = email.getText();
            String scourse = (String) course.getText();
            String sbranch = (String) branch.getText();
            
            try{
                String query = "update student set Address = '"+saddress+"', Phone_Number = '"+sphnnumber+"', Email_ID = '"+semail+"', Course = '"+scourse+"', Branch = '"+sbranch+"' where Employee_ID = '"+srollno+"'";
                
                Conn conn = new Conn();
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Teacher Details Updated successfully.");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public static void main(String args[]){
        
        new UpdateTeacher();
    }
}
