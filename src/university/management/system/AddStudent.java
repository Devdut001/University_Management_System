package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddStudent extends JFrame implements ActionListener {
    
    JTextField name, fathername, address, phnnumber, email, classx, classxii, aadharno;
    JComboBox course, branch;
    JLabel rollno;
    JDateChooser dob;
    JButton submit, cancel;
    
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L)+1000L);
    
    
    AddStudent(){
        
        setLayout(null);
        
        //heading
        
        JLabel heading = new JLabel("New Student Information");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif", Font.BOLD, 18));
        add(heading);
        
        //name
        
        JLabel lblname = new JLabel("Name:");
        lblname.setBounds(50,150,50,30);
        lblname.setFont(new Font("serif", Font.BOLD, 16));
        add(lblname);
        
        name = new JTextField();
        name.setBounds(120,150,250,30);
        add(name);
        
        //father's name
        
        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("serif", Font.BOLD, 16));
        add(fname);
        
        fathername = new JTextField();
        fathername.setBounds(550,150,250,30);
        add(fathername);
        
        //Roll No
        
        JLabel lblrollno = new JLabel("Roll No:");
        lblrollno.setBounds(50,220,100,30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 16));
        add(lblrollno);
        
        rollno = new JLabel("1980"+first4);
        rollno.setBounds(150,220,150,30);
        rollno.setFont(new Font("serif", Font.BOLD, 20));
        add(rollno);
        
        // DOB
        
        JLabel lbldob = new JLabel("Date of Birth:");
        lbldob.setBounds(400,220,150,30);
        lbldob.setFont(new Font("serif", Font.BOLD, 16));
        add(lbldob);
        
        dob = new JDateChooser();
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
        add(email);
        
        //class ten marks
        
        JLabel lbltenmarks = new JLabel("Class X (%):");
        lbltenmarks.setBounds(400,360,150,30);
        lbltenmarks.setFont(new Font("serif", Font.BOLD, 16));
        add(lbltenmarks);
        
        classx = new JTextField();
        classx.setBounds(550,360,250,30);
        classx.setFont(new Font("serif", Font.BOLD, 16));
        add(classx);
        
        //class twelve marks
        
        JLabel lbltwelvemarks = new JLabel("Class XII:");
        lbltwelvemarks.setBounds(50,430,100,30);
        lbltwelvemarks.setFont(new Font("serif", Font.BOLD, 16));
        add(lbltwelvemarks);
        
        classxii = new JTextField();
        classxii.setBounds(120,430,250,30);
        add(classxii);
        
        //aadhaar no
        
        JLabel lblaadharno = new JLabel("Aadhar No:");
        lblaadharno.setBounds(400,430,150,30);
        lblaadharno.setFont(new Font("serif", Font.BOLD, 16));
        add(lblaadharno);
        
        aadharno = new JTextField();
        aadharno.setBounds(550,430,250,30);
        aadharno.setFont(new Font("serif", Font.BOLD, 16));
        add(aadharno);
        
        //course
        
        JLabel lblcourse = new JLabel("Course:");
        lblcourse.setBounds(50,500,100,30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 16));
        add(lblcourse);
        
        String scourse[] = {"B.Tech", "BBA", "BCA", "Bcom", "MCom", "BA", "MBA", "MA"};
        course = new JComboBox(scourse);
        course.setBounds(120,500,250,30);
        add(course);
        
        
        // branch
        
        JLabel lblbranch = new JLabel("Branch:");
        lblbranch.setBounds(400,500,150,30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 16));
        add(lblbranch);
        
        String sbranch[] = {"CSE", "ECE", "EE", "ME", "IT", "CIVIL"};
        branch = new JComboBox(sbranch);
        branch.setBounds(550,500,250,30);
        add(branch);
        
        
        submit = new JButton("Submit");
        submit.setBounds(250,550, 120,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450,550, 120,30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.white);
        setSize(900,700);
        setLocation(220,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == cancel){
            setVisible(false);
        } else {
            String sname = name.getText();
            String sfathername = fathername.getText();
            String srollno = rollno.getText();
            String sdob = ((JTextField) dob.getDateEditor().getUiComponent()).getText();
            String saddress = address.getText();
            String sphnnumber = phnnumber.getText();
            String semail = email.getText();
            String sclassx = classx.getText();
            String sclassxii = classxii.getText();
            String saadharno = aadharno.getText();
            String scourse = (String) course.getSelectedItem();
            String sbranch = (String) branch.getSelectedItem();
            
            try{
                String query = "insert into student values('"+sname+"', '"+sfathername+"', '"+srollno+"', '"+sdob+"', '"+saddress+"', '"+sphnnumber+"', '"+semail+"', '"+sclassx+"', '"+sclassxii+"', '"+saadharno+"', '"+scourse+"', '"+sbranch+"')";
                
                Conn conn = new Conn();
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Student Details Inserted successfully.");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public static void main(String args[]){
        
        new AddStudent();
    }
    
}
