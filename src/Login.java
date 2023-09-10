
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
public class Login{
  public Login(){
  
  JFrame frame = new JFrame("Restaurant Booking Infomation Management");
  frame.setSize(400, 230);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  JPanel panel = new JPanel();
  panel.setLayout(null);
  
  JLabel label=new JLabel("Login");
  label.setBounds(180, 20, 200, 25);
  panel.add(label);
  
  JLabel userLabel = new JLabel("Username:");
  userLabel.setBounds (70, 60, 100, 25);
  panel.add(userLabel);
  
  JTextField userTf = new JTextField();
  userTf.setBounds (150, 60, 150, 25);
  panel.add(userTf);
  
  JLabel pwLabel = new JLabel("Password:");
  pwLabel.setBounds (70, 90, 100, 25);
  panel.add(pwLabel);

   
   JPasswordField pwTF= new JPasswordField();
   pwTF.setBounds(150, 90, 150, 25);
   panel.add(pwTF);
   
   
     class ButtonListener implements ActionListener{
      
    public void actionPerformed(ActionEvent e) {
      String user=userTf.getText();
      String password=pwTF.getText();
      
      if(user.equals("admin")&&password.equals("123")) {
        System.out.println("Login Success");
        frame.setVisible(false);
        new Options();
      }
      
      else {
        System.out.println("wrong");
      frame.setVisible(false);
      Retry er=new Retry();}
    }
 }
     
    JButton button=new JButton("Login");
     button.setBounds(160, 145, 80, 30);
     panel.add(button);
     button.addActionListener(new ButtonListener());
     
     frame.add(panel);
     frame.setLocationRelativeTo(null);
     frame.setVisible(true);
    }
 
  public static void main(String[] args) {
    new Login();
  }
}