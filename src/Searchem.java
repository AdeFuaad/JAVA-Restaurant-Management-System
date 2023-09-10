
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Searchem {
	public Searchem() {
		JFrame frame = new JFrame("Search");
		frame.setSize(1100, 600);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel label = new JLabel("Please input the keyword:");
		label.setBounds(70, 20, 230, 25);
		panel.add(label);
		
		JLabel KeywordLabel = new JLabel("Email:");
		KeywordLabel.setBounds(30, 90, 100, 25);
		panel.add(KeywordLabel);
		
		JTextField KeywordTf = new JTextField();
		KeywordTf.setBounds(150, 90, 150, 25);
		panel.add(KeywordTf);
		
		JButton button = new JButton("Search");
		button.setBounds(125, 195, 80, 30);
		panel.add(button);
		
		class SearchButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				String Keyword = KeywordTf.getText();
				
				String t = null;
				
				try {
					FileReader f1 = new FileReader("restaurant_infor.txt");
					BufferedReader br = new BufferedReader(f1);
					while((t = br.readLine())!=null ) {
						String [] s=t.split(",");
						//int i = 0;
						if(s[2].equals(Keyword)) {
							System.out.println("Found it! FirstName: " + s[0] + " LastName: " + s[1] +" EmailAddress: " + s[2] + " PhoneNumber: " + s[3] + " Date: "+ s[4] + " NoOfGuests:" + s[5]);
						JScrollPane scroll=new JScrollPane();
					       scroll.setBounds(350, 30, 650, 500);
					       panel.add(scroll);

					       JTable table=new JTable();
					       table.setBackground(new Color(176,196,222));
					       Object[] columns= {"FirstName","LastName","EmailAddress","PhoneNumber","Date","NoOfGuests"};
					       DefaultTableModel model=new DefaultTableModel();
					       Object[] row=new Object[6];
					       model.setColumnIdentifiers(columns);
					       table.setModel(model);
					       scroll.setViewportView(table);
					       
					       row[0]=s[0];
					       row[1]=s[1];
					       row[2]=s[2];
					       row[3]=s[3];
					       row[4]=s[4];
					       row[5]=s[5];
					       model.addRow(row);


					      }
					      else 
					       System.out.println("no match");
					}
					f1.close();
					br.close();
				} catch(IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		button.addActionListener(new SearchButtonListener());
		
		JButton ret = new JButton("Return");
		ret.setBounds(125, 230, 80, 30);
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
	}

}
