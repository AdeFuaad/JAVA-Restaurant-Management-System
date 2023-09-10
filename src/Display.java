import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Display {
  public Display() {
    JFrame frame = new JFrame("Display");
    frame.setSize(900, 450);
    
    JPanel panel = new JPanel();
    panel.setLayout(null);
    
    JLabel label = new JLabel("The restaurant information display");
    label.setBounds(290, 20, 280, 25);
    panel.add(label);
    
    JButton button=new JButton("Return");
    button.setBounds(390, 350, 80, 30);
    panel.add(button);
    
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

    button.addActionListener(new ReturnButtonListener());
      
          try {
            FileReader file = new FileReader("restaurant_infor.txt");
            BufferedReader br = new BufferedReader(file);
             
              JTable jTable1=new JTable();
              JScrollPane scroll=new JScrollPane(jTable1);
              scroll.setBounds(70, 60, 750, 250);
              
              // set columns name to the jtable1 model
              Object[] columnsName= {"Firstname","Lastname","Email Address","Phone Number","Date","Num of guests"};
              
              DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
              model.setColumnIdentifiers(columnsName);
             
              
              // get lines from txt file
              Object[] tableLines = br.lines().toArray();
              
              // extract data from lines
              // set data to jtable1 model
              for(int i = 0; i < tableLines.length; i++)
              {
                  String line = tableLines[i].toString().trim();
                  String[] dataRow = line.split(",");
                  model.addRow(dataRow);
                  
                  jTable1.setModel(model);
                frame.add(scroll);
              }
              br.close();
              
          } catch (Exception e1) {
            e1.printStackTrace();
            }
    
    frame.add(panel);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    
  }

}