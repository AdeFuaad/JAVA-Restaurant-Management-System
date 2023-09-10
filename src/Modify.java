

import java.awt.GridLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

import java.io.BufferedReader;

import java.io.File;

import java.io.FileReader;

import java.io.FileWriter;

import java.io.IOException;



import javax.swing.*;



public class Modify {

  public Modify() {

  JFrame frame=new JFrame("Modify");

  frame.setSize(800, 400);

  

JPanel panel = new JPanel();

panel.setLayout(null);



JLabel label = new JLabel("Please input the customer's phnum:");

label.setBounds(70, 20, 230, 25);

panel.add(label);



JLabel NameLabel = new JLabel("Phone num:");

NameLabel.setBounds(30, 90, 100, 25);

panel.add(NameLabel);



JTextField NameTf = new JTextField();

NameTf.setBounds(150, 90, 150, 25);

panel.add(NameTf);



JButton button = new JButton("OK");

button.setBounds(125, 195, 80, 30);

panel.add(button);





//JSeparator sep = new JSeparator();

//sep.setOrientation(SwingConstants.VERTICAL);

    //panel.add(sep);



JLabel label2 = new JLabel("Please input the following information:");

label2.setBounds(450, 20, 230 , 25);

panel.add(label2);

  

JLabel NameLabel1=new JLabel("Firstname:");

NameLabel1.setBounds(400, 60, 130, 25);

panel.add(NameLabel1);

   

JTextField NameTF =new JTextField();

NameTF.setBounds(550, 60, 150, 25);

panel.add(NameTF);

   

JLabel LnameLabel=new JLabel("Lastname:");

LnameLabel.setBounds(400, 90, 130, 25);

panel.add(LnameLabel);

   

JTextField LnameLabelTF =new JTextField();

LnameLabelTF.setBounds(550, 90, 150, 25);

panel.add(LnameLabelTF);

   

JLabel EmLabel=new JLabel("Email Address:");

EmLabel.setBounds(400, 122, 130, 25);

panel.add(EmLabel);

   

JTextField EmLabelTF =new JTextField();

EmLabelTF.setBounds(550, 122, 150, 25);

panel.add(EmLabelTF);

   

JLabel PhNoLabel=new JLabel("Phone Number:");

PhNoLabel.setBounds(400, 150, 100, 25);

panel.add(PhNoLabel);

   

JTextField PhNoLabelTF =new JTextField();

PhNoLabelTF.setBounds(550, 150, 150, 25);

panel.add(PhNoLabelTF);

   

JLabel DateLabel=new JLabel("Date:");

DateLabel.setBounds(400, 180, 100, 25);

panel.add(DateLabel);

   

JTextField DateLabelTF=new JTextField();

DateLabelTF.setBounds(550, 180, 150, 25);

panel.add(DateLabelTF);

   

JLabel NoguestLabel=new JLabel("Num of Guests:");

NoguestLabel.setBounds(400, 210, 50, 25);

panel.add(NoguestLabel);

   

JTextField NoguestLabelTF =new JTextField();

NoguestLabelTF.setBounds(550, 210, 150, 25);

panel.add(NoguestLabelTF);



 //panel.setLayout(new GridLayout(1,0));



class OKButtonListener implements ActionListener{

public void actionPerformed(ActionEvent e) {

String Name = NameTf.getText();



int i=0;

String t = null;



try {

FileReader f1 = new FileReader("restaurant_infor.txt");

BufferedReader br = new BufferedReader(f1);

while((t = br.readLine())!=null) {

String [] s=t.split(",");

if(s[3].equals(Name)) {

i=0;

NameTF.setText(s[0]);

LnameLabelTF.setText(s[1]);

EmLabelTF.setText(s[2]);

PhNoLabelTF.setText(s[3]);

DateLabelTF.setText(s[4]);

NoguestLabelTF.setText(s[5]);

break;

}

else {

i=1;

//System.out.println("name not found!, please recheck");

}

}

if(i==1)

JOptionPane.showMessageDialog(null, " not found!");

//NameTf.setText("");

f1.close();

br.close();

} catch(IOException e1) {

e1.printStackTrace();

}

}

}

button.addActionListener(new OKButtonListener());





   

   JButton button2=new JButton("Done");

   button2.setBounds(520, 255, 80, 30);

   panel.add(button2);

   

   class DoneButtonListener implements ActionListener{

   public void actionPerformed(ActionEvent e) {

   frame.setVisible(false);

   

   String Firstname = NameTF.getText();

   String LastName = LnameLabelTF.getText();

   String Emailaddress = EmLabelTF.getText();

   String PhoneNumber = PhNoLabelTF.getText();

   String Date = DateLabelTF.getText();

   String Numofguests = NoguestLabelTF.getText();

   

  

   String s = Firstname + "," + LastName + "," + Emailaddress + "," + PhoneNumber + "," + Date + "," + Numofguests;

   String Name = NameTf.getText();

   String t=null;

   String oldString="";
   

   if(Firstname.isEmpty()||LastName.isEmpty()||Emailaddress.isEmpty()|| PhoneNumber.isEmpty()||Date.isEmpty()||Numofguests.isEmpty()){

   frame.setVisible(true);

   JOptionPane.showMessageDialog(frame, "please fill in the complete information","Error",JOptionPane.WARNING_MESSAGE); 

  }

   else {

   try {

FileReader f1 = new FileReader("restaurant_infor.txt");

BufferedReader br = new BufferedReader(f1);

while((t = br.readLine())!=null) {

String [] r=t.split(",");

if(r[3].equals(Name)) {

oldString=r[0]+","+r[1]+","+r[2]+","+r[3]+","+r[4]+","+r[5];

modifyFile("restaurant_infor.txt", oldString, s);

break;

}

}

f1.close();

br.close();

   }catch(IOException e1) {

e1.printStackTrace();

   } 

   frame.setVisible(true);

   int a=JOptionPane.showConfirmDialog(frame,"modified succesfully! Do you want to continue to modify?","Modificatiion successful",JOptionPane.YES_NO_OPTION); 

   if(a==JOptionPane.NO_OPTION){  

   new Options();

   }

   else 

       new Modify();

       frame.setVisible(false);

   }

   } 

   }

   button2.addActionListener(new DoneButtonListener());

   

   

   

   JButton ret=new JButton("Return");

   ret.setBounds(520, 290, 80, 30);

   panel.add(ret);

   

   class ReturnButtonListener implements ActionListener{

   public void actionPerformed(ActionEvent e) {

   int a=JOptionPane.showConfirmDialog(frame, "Unsaved data will be lost if you return. Are you sure you want to continue?","Message",JOptionPane.YES_NO_OPTION);      

   if(a==JOptionPane.YES_OPTION){  

   new Options();

   frame.setVisible(false);

   }

   else 

   JOptionPane.getRootFrame().dispose();

   }

   };

   

   ret.addActionListener(new ReturnButtonListener());

   

   frame.add(panel);

   frame.setLocationRelativeTo(null);

   frame.setVisible(true);

   

   

    NameTF.addKeyListener(new KeyAdapter(){

   public void keyPressed(KeyEvent e) {

   char c=e.getKeyChar();

   if(Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c))

   {

   NameTF.setEditable(true);

   }

   else {

	   NameTF.setEditable(false);

   JOptionPane.showMessageDialog(frame,"input only character!","Error",JOptionPane.WARNING_MESSAGE); 

   NameTF.setText("");

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

   JOptionPane.showMessageDialog(frame,"input only character!","Error",JOptionPane.WARNING_MESSAGE); 

   LnameLabelTF.setText("");

   }

   }

   });

   
   
   

   PhNoLabelTF.addKeyListener(new KeyAdapter() {

   public void keyReleased(KeyEvent e) {

   try {

   Integer.parseInt(PhNoLabelTF.getText());

   }catch(NumberFormatException e1) {

   JOptionPane.showMessageDialog(null, "Input only digits!","Error", JOptionPane.INFORMATION_MESSAGE);

   PhNoLabelTF.setText("");

   }

   }

   });

 

   NoguestLabelTF.addKeyListener(new KeyAdapter() {

	   public void keyReleased(KeyEvent e) {

	   try {

	   Integer.parseInt(NoguestLabelTF.getText());

	   }catch(NumberFormatException e1) {

	   JOptionPane.showMessageDialog(null, "Input only digits!","Error", JOptionPane.INFORMATION_MESSAGE);

	   NoguestLabelTF.setText("");

	   }

	   }

	   });
   
   
   
  } 


   

 static void modifyFile(String filePath, String oldString, String newString){

     File fileToBeModified = new File("restaurant_infor.txt");    

     String oldContent = "";    

     BufferedReader reader = null;    

     FileWriter writer = null;     

     try {

         reader = new BufferedReader(new FileReader(fileToBeModified));      

         //Reading all the lines of input text file into oldContent    

         String line = reader.readLine();    

         while (line != null) {

             oldContent = oldContent + line + System.lineSeparator();      

             line = reader.readLine();

         }  

         //Replacing oldString with newString in the oldContent   

         String newContent = oldContent.replaceAll(oldString, newString);    

         //Rewriting the input text file with newContent    

         writer = new FileWriter(fileToBeModified);   

         writer.write(newContent);

     }

     catch (IOException e){

         e.printStackTrace();

     }

     finally{

         try{

             //Closing the resources              

             reader.close();               

             writer.close();

         } 

         catch (IOException e) {

             e.printStackTrace();

         }

     }

 }

  

  

}





