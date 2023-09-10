
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Retry {
	public Retry() {

		JFrame frame = new JFrame("Login Failed");
		frame.setSize(400, 230);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel label = new JLabel("Incorrect username or password. Please re-enter!");
		label.setBounds(50, 30, 350, 25);
		panel.add(label);
		
		class OkButtonListener implements ActionListener{
		      
		    public void actionPerformed(ActionEvent e) {
		      frame.setVisible(false);
		      new Login();
		      
		    }
		    }
		  
		JButton Ok=new JButton("OK");
		Ok.setBounds(140, 135, 80, 30);
		panel.add(Ok);
						
	   Ok.addActionListener(new OkButtonListener());
						   
	   frame.add(panel);
	   frame.setLocationRelativeTo(null);
	   frame.setVisible(true);
		  

	}

}
