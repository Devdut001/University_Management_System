package university.management.system;

import javax.swing.*;
import java.awt.*;

public class GMIT extends JFrame implements Runnable{
    
    Thread t;
    GMIT(){
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        
        t = new Thread(this);
        t.start();
        
        
        setVisible(true);
        
        int x = 1;
        for(int i=2; i<= 600; i+=4, x+=1){
            setSize(i+3*x,i+x/2);
            setLocation(420-((i+1)/2),300-((i+1)/2));
            
            try{
                Thread.sleep(10);
            } catch (Exception e){}
        }   
    }
    
    public void run(){
        try{
            Thread.sleep(7000);
            setVisible(false);
            new Login().setVisible(true);
            
        } catch (Exception e){}
        
    }
    public static void main (String args[]){
        new GMIT();
    }
    
}
