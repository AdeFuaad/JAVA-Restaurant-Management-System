	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;

	public class Help {
		public Help() {

			JFrame frame = new JFrame("Help");
			frame.setSize(400, 230);
			
			JPanel panel = new JPanel();
			panel.setLayout(null);
			
			JLabel label = new JLabel("Email : adesholafuaad@gmail.com");
			label.setBounds(60, 30, 230, 25);
			panel.add(label);
			
			JLabel label1 = new JLabel("Phone number : 13143748795");
			label1.setBounds(60, 60, 230, 25);
			panel.add(label1);
			
			
			class ReturnButtonListener implements ActionListener{
				
				   public void actionPerformed(ActionEvent e) {
					   frame.setVisible(false);
					   new Options();
				   }
			       }
			
			JButton ret = new JButton("Return");
			ret.setBounds(130, 135, 80, 30);
			panel.add(ret);
			
			ret.addActionListener(new ReturnButtonListener());
					
			   
		   frame.add(panel);
		   frame.setLocationRelativeTo(null);
		   frame.setVisible(true);
			  

		}

	}

