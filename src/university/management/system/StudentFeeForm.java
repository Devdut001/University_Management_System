
package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class StudentFeeForm  extends JFrame implements ActionListener{
    
    Choice rollno2;
    JComboBox course, branch, semester;
    JLabel labeltotal;
    JButton submit, cancel, payFee;
    
    StudentFeeForm(){
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);
        
        
        JLabel heading2 = new JLabel("Search by Roll Number:");
        heading2.setBounds(40,60,200,16);
        heading2.setFont(new Font("tahoma", Font.BOLD, 16));
        add(heading2);
        
        //adding roll no
        
        rollno2 = new Choice();
        rollno2.setBounds(250,60,130,16);
        rollno2.setFont(new Font("serif", Font.BOLD, 16));
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
        
        //name
        
        JLabel lblname = new JLabel("Name:");
        lblname.setBounds(40,100,150,20);
        lblname.setFont(new Font("tahoma", Font.BOLD, 16));
        add(lblname);
        
        JLabel name = new JLabel();
        name.setBounds(200,100,150,20);
        name.setFont(new Font("tahoma", Font.PLAIN, 16));
        add(name);
        
        //father's name
        
        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(40,140,150,20);
        fname.setFont(new Font("tahoma", Font.BOLD, 16));
        add(fname);
        
        JLabel fathername = new JLabel();
        fathername.setBounds(200,140,150,20);
        fathername.setFont(new Font("tahoma", Font.PLAIN, 16));
        add(fathername);
        
        try{
            Conn c = new Conn();
            String query = "select * from student where Roll_No = '"+rollno2.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                name.setText(rs.getString("Name"));
                fathername.setText(rs.getString("Father_Name"));
            }
        } catch (Exception e){
            System.out.println(e);
        }
        
        rollno2.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c = new Conn();
                    String query = "select * from student where Roll_No = '"+rollno2.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        name.setText(rs.getString("Name"));
                        fathername.setText(rs.getString("Father_Name"));
                    }
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        });
        
        //course
        
        JLabel lblcourse = new JLabel("Course:");
        lblcourse.setBounds(40,180,150,20);
        lblcourse.setFont(new Font("tahoma", Font.BOLD, 16));
        add(lblcourse);
        
        String scourse[] = {"BTech", "BBA", "BCA", "Bcom", "MCom", "BA", "MBA", "MA"};
        course = new JComboBox(scourse);
        course.setBounds(200,180,150,20);
        add(course);
        
        
        // branch
        
        JLabel lblbranch = new JLabel("Branch:");
        lblbranch.setBounds(40,220,150,20);
        lblbranch.setFont(new Font("serif", Font.BOLD, 16));
        add(lblbranch);
        
        String sbranch[] = {"CSE", "ECE", "EE", "ME", "IT", "CIVIL"};
        branch = new JComboBox(sbranch);
        branch.setBounds(200,220,150,20);
        add(branch);
        
        JLabel lblsemester = new JLabel("Select Semester:");
        lblsemester.setBounds(40,260,150,20);
        lblsemester.setFont(new Font("tahoma", Font.BOLD, 16));
        add(lblsemester);
        
        String sSemester[]={"semester1", "semester2", "semester3", "semester4", "semester5", "semester6", "semester7", "semester8"};
        semester = new JComboBox(sSemester);
        semester.setBounds(200,260,150,20);
        add(semester);
        
        
        JLabel lbltotal = new JLabel("Total Payable:");
        lbltotal.setBounds(40,300,150,20);
        lbltotal.setFont(new Font("tahoma", Font.BOLD, 16));
        add(lbltotal);
        
        labeltotal = new JLabel();
        labeltotal.setBounds(200,300,150,20);
        labeltotal.setFont(new Font("tahoma", Font.BOLD, 16));
        add(labeltotal);
        
        
        submit = new JButton("Update");
        submit.setBounds(30,380, 120,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Back");
        cancel.setBounds(150,380, 120,30);
        cancel.addActionListener(this);
        add(cancel);
        
        payFee = new JButton("Pay Fee");
        payFee.setBounds(270,380, 120,30);
        payFee.addActionListener(this);
        add(payFee);
        
        
        
        getContentPane().setBackground(Color.white);
        setSize(900,500);
        setLocation(200,30);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            String scourse1 = (String) course.getSelectedItem();
            String ssemester1 = (String) semester.getSelectedItem();
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from fee where course = '"+scourse1+"'");
                while(rs.next()){
                    labeltotal.setText(rs.getString(ssemester1));
                }
            } catch (Exception e) {
                
            }
         } else if (ae.getSource() == payFee){
            String scourse1 = (String) course.getSelectedItem();
            String ssemester1 = (String) semester.getSelectedItem();
            String srollno = rollno2.getSelectedItem();
            String sbranch1 = (String) branch.getSelectedItem();
            String stotal = labeltotal.getText();
            
            try{
                Conn c = new Conn();
                String query = "insert into collegefee values('"+srollno+"', '"+scourse1+"', '"+sbranch1+"', '"+ssemester1+"', '"+stotal+"')";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "College Fee Submitted Successfully.");
                setVisible(false);
            } catch (Exception e){}
        } else {
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new StudentFeeForm();    }
}
