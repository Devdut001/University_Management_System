package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField uid;
    JPasswordField password;
    JButton login, cancel;
    
    Login(){
        
        setLayout(null);
        
        
        JLabel user = new JLabel("User ID");
        user.setBounds(50,80,80,30);
        user.setFont(new Font("raleway", Font.BOLD, 16));
        add(user);
        
        uid = new JTextField();
        uid.setBounds(140,80,200,30);
        add(uid);
        
        
        JLabel pass = new JLabel("Password");
        pass.setBounds(50,140,80,30);
        pass.setFont(new Font("raleway", Font.BOLD, 16));
        add(pass);
        
        password = new JPasswordField();
        password.setBounds(140,140,200,30);
        add(password);
        
        
        login = new JButton("Login");
        login.setBounds(50, 220, 130, 35);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.setFont(new Font("tahoma", Font.BOLD, 16));
        login.addActionListener(this);
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(210, 220, 130, 35);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("tahoma", Font.BOLD, 16));
        cancel.addActionListener(this);
        add(cancel);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,40,200,200);
        add(image);
        
        
        
        getContentPane().setBackground(Color.white);
        setSize(650,350);
        setLocation(300,150);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == cancel){
            System.exit(0); 
        } else {
            String susername = uid.getText();
            String spassword = password.getText();
            
            String query = "select * from unilogin where username = '"+susername+"' and password = '"+spassword+"'";
            
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    setVisible(false);
                    new Project().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "invalid user ID or password");
                    setVisible(false);
                }
                c.s.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public static void main(String args[]){
        
        new Login();
        
    }
    
}
