package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherDetails extends JFrame implements ActionListener {
    
    Choice employeeID;
    JTable table;
    JButton search, print, update, add, cancel;
    
    TeacherDetails(){
        
        setLayout(null);
        
        //heading
        
        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(40,40,150,20);
        add(heading);
        
        //adding roll no
        
        employeeID = new Choice();
        employeeID.setBounds(220,40,150,20);
        add(employeeID);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()){
                employeeID.add(rs.getString("Employee_ID"));
            }
        } catch (Exception e){
            System.out.println(e);
        }
        
        //table view
        
        table = new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
            System.out.println(e);
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,150,900,600);
        add(jsp);
        
        //buttons
        
        search = new JButton("Search");
        search.setBounds(40,90,80,20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(140,90,80,20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(240,90,80,20);
        update.addActionListener(this);
        add(update);
        
        add = new JButton("Add");
        add.setBounds(340,90,80,20);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(440,90,80,20);
        cancel.addActionListener(this);
        add(cancel);
    
        //display details
        
        getContentPane().setBackground(Color.white);
        setSize(900,700);
        setLocation(220,10);
        setVisible(true);
    }
    
    //button works
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == cancel){
            setVisible(false);
        } else if (ae.getSource() == search){
            String query = "select * from teacher where Employee_ID = '"+employeeID.getSelectedItem()+"'";
            try{
                Conn conn = new Conn();
                ResultSet rs2 = conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs2));
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == print){
            try{
                table.print();
            } catch(Exception e){
                System.out.println(e);
            }
        } else if (ae.getSource() == update){
            setVisible(false);
            new UpdateTeacher();
        } else if (ae.getSource() == add){
            setVisible(false);
            new AddTeacher();
        }
    }
    
    public static void main(String args[]){
        new TeacherDetails();
    }
}
