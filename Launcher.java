import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;



public class Launcher extends JFrame{
	public Launcher(){
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("DupCleaner");
		this.setSize(400, 150);
		this.setResizable(false);
		this.setLocation(100, 100);
		this.setLayout(null);
		
		JButton clean = new JButton("Start Cleaning");
		clean.setBounds(10, 20, 380, 50);
		this.add(clean);
		
		JButton about = new JButton("About");
		about.setBounds(10, 80, 190, 30);
		about.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new AboutWindow();
				
			}
			
		});
		this.add(about);
		
		JButton quit = new JButton("Quit");
		quit.setBounds(200, 80, 190, 30);
		quit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		});
		this.add(quit);
	}
	
	public static void main(String[] args){
		new Launcher();
	}
}
