import java.io.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Delete{
  public Delete(){
  JFrame frame=new JFrame("Restaurant Booking Infomation Management");
   frame.setSize(450, 250);
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
   JPanel panel=new JPanel();
   panel.setLayout(null);
   
   JLabel label=new JLabel("Please enter the customer's phone num");
   label.setBounds(90, 20, 250, 25);
   panel.add(label);
   
   JLabel NameLabel=new JLabel("Phone num:");
   NameLabel.setBounds(30, 60, 50, 25);
   panel.add(NameLabel);
   
   JTextField NameTf =new JTextField();
   NameTf.setBounds(150, 60, 150, 25);
   panel.add(NameTf);
   
   JButton button=new JButton("OK");
   button.setBounds(175, 125, 80, 30);
   panel.add(button);
   
   class ButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent e) {
        String Name = NameTf.getText();

   try {
       File inputFile = new File("restaurant_infor.txt");
       if (!inputFile.isFile()) {
           System.out.println("File does not exist");
           return;
       }
       //Construct the new file that will later be renamed to the original filename.
       File tempFile = new File("restaurantTemp_infor.txt");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
       BufferedReader br = new BufferedReader(new FileReader("restaurant_infor.txt"));
       PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
       String line = null;
       String lineToTrim=null;
       int i=1;

       //Read from the original file and write to the new
       //unless content matches data to be removed.
       while ((line = br.readLine()) != null) {
         String [] s=line.split(",");
      if(s[3].equals(Name)) {
        i=0;
        lineToTrim=s[0] + "," + s[1] + "," + s[2] + "," + s[3] + "," + s[4] + "," + s[5];
        }

        if (!line.trim().equals(lineToTrim)) {
          pw.println(line);
          pw.flush();
          //JOptionPane.showMessageDialog(null, "Successfully deleted!");
          //new Options();
        }
           }
       pw.close();
       br.close();
       
       if(i==0) {
         JOptionPane.showMessageDialog(null, "Successfully deleted!");
         frame.setVisible(false);
         new Options();
       }
     
   
       else{//if(i==1) {
       //JOptionPane.showMessageDialog(null, "Successfully deleted!");
       //new Options();
       JOptionPane.showMessageDialog(null, "no match!","Error", JOptionPane.INFORMATION_MESSAGE);
       NameTf.setText("");
     }
      
       //else {
      //   JOptionPane.showMessageDialog(null, "no match!","Error", JOptionPane.INFORMATION_MESSAGE);
      //   NameTf.setText("");
       //}
       //Delete the original file
       if (!inputFile.delete()) {
           System.out.println("Could not delete file");
           return;
       }

       //Rename the new file to the filename the original file had.
       if (!tempFile.renameTo(inputFile))
           System.out.println("Could not rename file");
       }
   catch (FileNotFoundException ex) {
       ex.printStackTrace();
   }catch (IOException ex) {
       ex.printStackTrace();
   }
}
}
   
button.addActionListener(new ButtonListener());


JButton ret=new JButton("Return");
ret.setBounds(175, 160, 80, 30);
panel.add(ret);

class ReturnButtonListener implements ActionListener{
     public void actionPerformed(ActionEvent e) {
       int a=JOptionPane.showConfirmDialog(frame, "Are you sure you want to return?","Message",JOptionPane.YES_NO_OPTION);      
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
  }}



