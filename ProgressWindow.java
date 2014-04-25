import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class ProgressWindow extends JFrame {
	
	public static JLabel txtCounter;
	public static int count;
	
	public ProgressWindow(){
		this.setVisible(true);
		this.setTitle("Progress");
		this.setSize(400, 150);
		this.setLocation(300, 200);
		this.setLayout(null);
		this.setResizable(false);
		
		txtCounter = new JLabel("Loaded 0 files.");
		txtCounter.setFont(new Font("Courier New", Font.BOLD, 15));
		txtCounter.setBounds(100, 50, 200, 35);
		this.add(txtCounter);
		
		this.repaint();
	}
	
	public void countUp(){
		count++;
		txtCounter.setText("Loaded " + count + " files.");
	}
	
	public void close(){
		this.setVisible(false);
	}
	
	public static void main(String[] args){
		new ProgressWindow();
	}
	
}
