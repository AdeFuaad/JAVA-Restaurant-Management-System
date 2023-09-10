import javax.swing.*;    
import java.awt.event.*;    
public class Options implements ActionListener{ 
	
JFrame frame;    
JMenuBar mb;    
JMenu file, edit, search, help, logout;    
JMenuItem add, modify, delete, find, contact, exit, display;    

public Options(){  

	  frame = new JFrame("Restaurant Booking Infomation Management");
	  JPanel panel=new JPanel();
	  panel.setBounds(40, 130, 400, 100);

	  JLabel label=new JLabel("Welcome to Restaurant Booking Information Management");
	  label.setBounds(0, 90, 100 , 25);
	  panel.add(label);
	  
add=new JMenuItem("Add");    
modify=new JMenuItem("Modify");        
find=new JMenuItem("Find");
contact=new JMenuItem("Contact");
delete=new JMenuItem("Delete");
exit=new JMenuItem("Exit");
display=new JMenuItem("Display");

add.addActionListener(this);        
modify.addActionListener(this);    
find.addActionListener(this);
contact.addActionListener(this);
delete.addActionListener(this);
exit.addActionListener(this);
display.addActionListener(this);

mb=new JMenuBar();    
file=new JMenu("File");    
edit=new JMenu("Edit");    
search=new JMenu("Search");  
help=new JMenu("Help");
logout=new JMenu("Logout");

file.add(add);file.add(display);edit.add(modify);edit.add(delete);help.add(contact);search.add(find);logout.add(exit); 
mb.add(file);mb.add(edit);mb.add(help);mb.add(search);mb.add(logout);    
frame.setJMenuBar(mb);  
frame.setLayout(null);    
frame.setSize(500,400);  
frame.add(panel);
frame.setLocationRelativeTo(null);
frame.setVisible(true);   
}     

public void actionPerformed(ActionEvent e) {    
	 frame.setVisible(false);
	    Add ad;
	    Logout lo;
	    By by;
	    Help he;
	    Modify mo;
	    Delete de;
	    Display di;
	    
	    if(e.getSource()==add) 
	     ad=new Add();
	    
	    if(e.getSource()==exit)
	     lo=new Logout();
	    
	    if(e.getSource()==find)
	     by=new By(); 
	    
	    if(e.getSource()==contact)
		 he=new Help(); 
	    
	    if(e.getSource()==modify)
		 mo=new Modify(); 
	    
	    if(e.getSource()==delete)
		 de=new Delete(); 
	   
	    if(e.getSource()==display)
		 di=new Display(); 
}     

}

