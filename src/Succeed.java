
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Succeed {
	public Succeed() {

		JFrame frame = new JFrame("Success");
		frame.setSize(400, 230);
		/*frame.setSize(350, 230);
		 */
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel label = new JLabel("Information has been added successfully!");
		label.setBounds(60, 30, 230, 25);
		panel.add(label);
		
		class OkButtonListener implements ActionListener{
		      
		    public void actionPerformed(ActionEvent e) {
		      frame.setVisible(false);
		      new Options();
		      
		    }
		    }
		  
		JButton Ok=new JButton("OK");
		Ok.setBounds(130, 135, 80, 30);
		panel.add(Ok);
						
	   Ok.addActionListener(new OkButtonListener());
						   
	   frame.add(panel);
	   frame.setLocationRelativeTo(null);
	   frame.setVisible(true);
		  

	}

}
