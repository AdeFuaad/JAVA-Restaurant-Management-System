import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.*;
import javax.swing.*;

public class Add {
  public Add() {
  JFrame frame=new JFrame("Add");
  frame.setSize(400, 400);
  
  JPanel panel=new JPanel();
  panel.setLayout(null);
  
  JLabel label = new JLabel("Please input the following info:");
  label.setBounds(70, 20, 230 , 25);
  panel.add(label);
  
  JLabel NameLabel=new JLabel("First Name:");
  NameLabel.setBounds(30, 60, 130, 25);
  panel.add(NameLabel);
  
  JTextField NameLabelTF =new JTextField();
  NameLabelTF.setBounds(170, 60, 150, 25);
  panel.add(NameLabelTF);
  
  JLabel LnameLabel=new JLabel("Last Name:");
  LnameLabel.setBounds(30, 90, 130, 25);
  panel.add(LnameLabel);
  
  JTextField LnameLabelTF =new JTextField();
  LnameLabelTF.setBounds(170, 90, 150, 25);
  panel.add(LnameLabelTF);
  
  JLabel EmLabel=new JLabel("Email address:");
  EmLabel.setBounds(30, 122, 130, 25);
  panel.add(EmLabel);
  
  JTextField EmLabelTF =new JTextField();
  EmLabelTF.setBounds(170, 122, 150, 25);
  panel.add(EmLabelTF);
  
  JLabel PhNoLabel=new JLabel("Phone Number:");
  PhNoLabel.setBounds(30, 150, 100, 25);
  panel.add(PhNoLabel);
   
  JTextField PhNoLabelTF =new JTextField();
  PhNoLabelTF.setBounds(170, 150, 150, 25);
  panel.add(PhNoLabelTF);
  
  JLabel DateLabel=new JLabel("Date:");
  DateLabel.setBounds(30, 210, 50, 25);
  panel.add(DateLabel);
  
  JTextField DateLabelTF =new JTextField();
  DateLabelTF.setBounds(170, 210, 150, 25);
  panel.add(DateLabelTF);
  
  JLabel NoguestLabel=new JLabel("Guests num:");
  NoguestLabel.setBounds(30, 180, 100, 25);
  panel.add(NoguestLabel);
  
  JTextField NoguestLabelTF=new JTextField();
  NoguestLabelTF.setBounds(170, 180, 150, 25);
  panel.add(NoguestLabelTF);
  
  JButton button=new JButton("Done");
  button.setBounds(140, 255, 80, 30);
  panel.add(button);
  
  class DoneButtonListener implements ActionListener{
   public void actionPerformed(ActionEvent e) {
    frame.setVisible(false);
    
    String FirstName = NameLabelTF.getText();
    String LastName = LnameLabelTF.getText();
    String EmailAddress = EmLabelTF.getText();
    String PhoneNumber = PhNoLabelTF.getText();
    String Date = DateLabelTF.getText();
    String NoOfGuests = NoguestLabelTF.getText();
    
    String s = FirstName + "," + LastName + "," + EmailAddress + "," + PhoneNumber + "," + Date + "," + NoOfGuests;

		   
		   try {
			   File restaurant_info = new File("restaurant_infor.txt");
			   FileWriter fw = new FileWriter(restaurant_info, true);
			   BufferedWriter bw = new BufferedWriter(fw);
			   bw.write(s);
			   bw.write("\r\n");
			   bw.close();
			   fw.close();
		   } catch(IOException e1) {
			   e1.printStackTrace();
		   }
		   
		   new Succeed();
		   frame.setVisible(false);
	   }
   }
   
   button.addActionListener(new DoneButtonListener());
   
   JButton ret=new JButton("Return");
   ret.setBounds(140, 290, 80, 30);
   panel.add(ret);
   
   class ReturnButtonListener implements ActionListener{
	   public void actionPerformed(ActionEvent e) {
		   frame.setVisible(false);
		   new Options();
	   }
   };
   
   ret.addActionListener(new ReturnButtonListener());
   
   frame.add(panel);
   frame.setLocationRelativeTo(null);
   frame.setVisible(true);
   
   NameLabelTF.addKeyListener(new KeyAdapter(){
	   public void keyPressed(KeyEvent e) {
			   char c=e.getKeyChar();
			   if(Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c))
			   {
				   NameLabelTF.setEditable(true);
			   }
			   else {
				   NameLabelTF.setEditable(false);
				   JOptionPane.showMessageDialog(frame,"Input only characters!","Error",JOptionPane.WARNING_MESSAGE); 
				   NameLabelTF.setText("");
			   }
	   }
   });

   LnameLabelTF.addKeyListener(new KeyAdapter(){
	   public void keyPressed(KeyEvent e) {
			   char c=e.getKeyChar();
			   if(Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c))
			   {
				   LnameLabelTF.setEditable(true);
			   }
			   else {
				   LnameLabelTF.setEditable(false);
				   JOptionPane.showMessageDialog(frame,"Input only characters!","Error",JOptionPane.WARNING_MESSAGE); 
				   LnameLabelTF.setText("");
			   }
	   }
   });
   
   PhNoLabelTF.addKeyListener(new KeyAdapter() {
	   public void keyReleased(KeyEvent e) {
		   try {
			   int i=Integer.parseInt(PhNoLabelTF.getText());
		   }catch(NumberFormatException e1) {
			   JOptionPane.showMessageDialog(null, "Input only digits!","Error", JOptionPane.INFORMATION_MESSAGE);
			   PhNoLabelTF.setText("");
		   }
	   }
   });
   
   NoguestLabelTF.addKeyListener(new KeyAdapter() {
	   public void keyReleased(KeyEvent e) {
		   try {
			   int i=Integer.parseInt(NoguestLabelTF.getText());
		   }catch(NumberFormatException e1) {
			   JOptionPane.showMessageDialog(null, "Input only digits!","Error", JOptionPane.INFORMATION_MESSAGE);
			   NoguestLabelTF.setText("");
		   }
	   }
   });
 
   
  } 
}
