
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Logout {
	public Logout() {

		JFrame frame = new JFrame("Logout");
		frame.setSize(350, 230);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel label = new JLabel("Are you sure you want to log out?");
		label.setBounds(70, 30, 230, 25);
		panel.add(label);
		
		class YesButtonListener implements ActionListener{
		      
		    public void actionPerformed(ActionEvent e) {
		      frame.setVisible(false);
		      new Login();
		      
		    }
		    }
		  
		JButton Yes=new JButton("Yes");
		Yes.setBounds(130, 95, 80, 30);
		panel.add(Yes);
						
	   Yes.addActionListener(new YesButtonListener());
	   
	   class NoButtonListener implements ActionListener{
		      
		    public void actionPerformed(ActionEvent e) {
		      frame.setVisible(false);
		      new Options();
		      
		    }
		    }
		  
		JButton No=new JButton("No");
		No.setBounds(130, 130, 80, 30);
		panel.add(No);
		
		No.addActionListener(new NoButtonListener());
						   
	   frame.add(panel);
	   frame.setLocationRelativeTo(null);
	   frame.setVisible(true);
		  

	}

}
