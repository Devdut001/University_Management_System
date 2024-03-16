package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FeeStructure extends JFrame{
    
    JTable table;
    
    FeeStructure(){
        
        
        setLayout(null);
        
        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(50,10,400,30);
        heading.setFont(new Font("tahoma", Font.BOLD, 24));
        add(heading);
        
        table = new JTable();
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,60,1000,700);
        add(jsp);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e){
            System.out.print(e);
        }
        
        getContentPane().setBackground(Color.white);
        setSize(1000,700);
        setLocation(200,50);
        setVisible(true);
    }
    public static void main(String args[]){
        new FeeStructure();
    }
}
