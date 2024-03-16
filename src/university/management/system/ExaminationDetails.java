package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;



public class ExaminationDetails extends JFrame implements ActionListener {
    
    JTextField search;
    JButton submit, cancel;
    JTable table;
    
    ExaminationDetails(){
        
        setLayout(null);
        
        //heading
        
        JLabel heading = new JLabel("Check Result");
        heading.setBounds(80,15,400,50);
        heading.setFont(new Font("tahoma", Font.BOLD, 24));
        add(heading);
        
        
        search = new JTextField();
        search.setBounds(80,90,200,30);
        search.setFont(new Font("tahoma", Font.PLAIN, 18));
        add(search);
        
        submit = new JButton("Result");
        submit.setBounds(300,90, 120,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Back");
        cancel.setBounds(440,90, 120,30);
        cancel.addActionListener(this);
        add(cancel);
        
        table = new JTable();
        table.setFont(new Font("tahoma", Font.PLAIN, 16));
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,130,1000,310);
        add(jsp);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
            System.out.println(e);
        }
        
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 2).toString());
            }
        });
        
        getContentPane().setBackground(Color.white);
        setSize(1000,475);
        setLocation(200,100);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            setVisible(false);
            new Marks(search.getText());
            
        } else {
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new ExaminationDetails();
    }
    
}
