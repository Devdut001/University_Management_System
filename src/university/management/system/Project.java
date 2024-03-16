package university.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project extends JFrame implements ActionListener{
    
    Project(){
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920, 1650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        JMenuBar mb = new JMenuBar();
        
        //new Information
        
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.black);
        mb.add(newInformation);
        
        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.white);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);
        
        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.white);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);
        
        //Details
        
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.black);
        mb.add(details);
        
        JMenuItem facultyDetails = new JMenuItem("View Faculty Details");
        facultyDetails.setBackground(Color.white);
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);
        
        JMenuItem studentDetails = new JMenuItem("View Student Details");
        studentDetails.setBackground(Color.white);
        studentDetails.addActionListener(this);
        details.add(studentDetails);
        
        //Leave
        
        JMenu applyLeave = new JMenu("Apply Leave");
        applyLeave.setForeground(Color.black);
        mb.add(applyLeave);
        
        JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
        facultyLeave.setBackground(Color.white);
        facultyLeave.addActionListener(this);
        applyLeave.add(facultyLeave);
        
        JMenuItem studentLeave = new JMenuItem("Student Leave");
        studentLeave.setBackground(Color.white);
        studentLeave.addActionListener(this);
        applyLeave.add(studentLeave);
        
        //Leave Details
        
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.black);
        mb.add(leaveDetails);
        
        JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.setBackground(Color.white);
        facultyLeaveDetails.addActionListener(this);
        leaveDetails.add(facultyLeaveDetails);
        
        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
        studentLeaveDetails.setBackground(Color.white);
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);
        
        //Exams
        
        JMenu examination = new JMenu("Examination");
        examination.setForeground(Color.black);
        mb.add(examination);
        
        JMenuItem examinationResults = new JMenuItem("Examination Results");
        examinationResults.setBackground(Color.white);
        examinationResults.addActionListener(this);
        examination.add(examinationResults);
        
        JMenuItem enterMarks = new JMenuItem("Enter Marks");
        enterMarks.setBackground(Color.white);
        enterMarks.addActionListener(this);
        examination.add(enterMarks);
        
        //Update Details
        
        JMenu updateDetails = new JMenu("Update Details");
        updateDetails.setForeground(Color.black);
        mb.add(updateDetails);
        
        JMenuItem updateFacultyDetails = new JMenuItem("Update Faculty Details");
        updateFacultyDetails.setBackground(Color.white);
        updateFacultyDetails.addActionListener(this);
        updateDetails.add(updateFacultyDetails);
        
        JMenuItem updateStudentDetails = new JMenuItem("Update Student Details");
        updateStudentDetails.setBackground(Color.white);
        updateStudentDetails.addActionListener(this);
        updateDetails.add(updateStudentDetails);
        
        //Fees
        
        JMenu feeDetails = new JMenu("Fee Details");
        feeDetails.setForeground(Color.black);
        mb.add(feeDetails);
        
        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        feeStructure.setBackground(Color.white);
        feeStructure.addActionListener(this);
        feeDetails.add(feeStructure);
        
        JMenuItem studentFeesForm = new JMenuItem("Student Fee Form");
        studentFeesForm.setBackground(Color.white);
        studentFeesForm.addActionListener(this);
        feeDetails.add(studentFeesForm);
        
        //Utility
        
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.black);
        mb.add(utility);
        
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.white);
        notepad.addActionListener(this);
        utility.add(notepad);
        
        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setBackground(Color.white);
        calculator.addActionListener(this);
        utility.add(calculator);
        
        JMenuItem webBrowser = new JMenuItem("Web Browser");
        webBrowser.setBackground(Color.white);
        webBrowser.addActionListener(this);
        utility.add(webBrowser);
        
        //Exit
        
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.black);
        mb.add(exit);
        
        JMenuItem seeYouLater = new JMenuItem("See You Later.");
        seeYouLater.setBackground(Color.white);
        seeYouLater.addActionListener(this);
        exit.add(seeYouLater);
                
        setJMenuBar(mb);
        
        
        
        setSize(1920,1080);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        
        if(msg.equals("See You Later.")){
            System.exit(0);
        } else if (msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e){}
        } else if (msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e){}
        } else if (msg.equals("Web Browser")){
            try{
                Runtime.getRuntime().exec("chrome.exe");
            } catch (Exception e){}
        } else if (msg.equals("New Faculty Information")){
            new AddTeacher();
        } else if (msg.equals("New Student Information")){
            new AddStudent();
        } else if (msg.equals("Faculty Leave")){
            new TeacherLeave();
        } else if (msg.equals("Student Leave")){
            new StudentLeave();
        } else if (msg.equals("View Faculty Details")){
            new TeacherDetails();
        } else if (msg.equals("View Student Details")){
            new StudentDetails();
        } else if (msg.equals("Faculty Leave Details")){
            new TeacherLeaveDetails();
        } else if (msg.equals("Student Leave Details")){
            new StudentLeaveDetails();
        } else if (msg.equals("Update Student Details")){
            new UpdateStudent();
        } else if (msg.equals("Update Faculty Details")){
            new UpdateTeacher();
        } else if (msg.equals("Enter Marks")){
            new EnterMarks();
        } else if (msg.equals("Examination Results")){
            new ExaminationDetails();
        } else if (msg.equals("Fee Structure")){
            new FeeStructure();
        } else if (msg.equals("Student Fee Form")){
            new StudentFeeForm();
        }
        
    }
    
    public static void main(String args[]){
        new Project();
    }
}
