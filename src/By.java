import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;

public class By {
	public By() {
		
		JFrame frame = new JFrame("Search by");
		frame.setSize(400, 230);
		/*frame.setSize(350, 230);
		 */
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel label = new JLabel("Select one");
		label.setBounds(165, 30, 230, 25);
		panel.add(label);
		
		
		//Return to the Options class
		
		JButton ret = new JButton("Return");
		ret.setBounds(162, 150, 80, 30);
		panel.add(ret);
		
		class ReturnButtonListener implements ActionListener{
			
			   public void actionPerformed(ActionEvent e) {
				   frame.setVisible(false);
				   new Options();
			   }
		       }
		
		
		ret.addActionListener(new ReturnButtonListener());
				
		   
		//Search by Email
		
		JButton em = new JButton("Email");
		em.setBounds(230, 90, 80, 30);
		panel.add(em);
		
		class EmailButtonListener implements ActionListener{
			
			   public void actionPerformed(ActionEvent e) {
				   frame.setVisible(false);
				   new Searchem();
			   }
		       }

		
		em.addActionListener(new EmailButtonListener());

		
		//Search by Phone number
		
		JButton phnum = new JButton("Phone");
		phnum.setBounds(90, 90, 80, 30);
		panel.add(phnum);
		
		class PhonumButtonListener implements ActionListener{
			
			   public void actionPerformed(ActionEvent e) {
				   frame.setVisible(false);
				   new Searchphnum();
			   }
		       }
		
		phnum.addActionListener(new PhonumButtonListener());

		
		
	   frame.add(panel);
	   frame.setLocationRelativeTo(null);
	   frame.setVisible(true);
		
		
	}
}
