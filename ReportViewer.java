import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;


public class ReportViewer extends JFrame {

	
	public static String report;
	public static String title;
	

	public ReportViewer(String r, String t){
		this.report = r;
		this.title = t;
		this.setTitle(this.title);
		this.setSize(600, 400);
		this.setLocation(150, 150);
		this.setVisible(true);
		this.setLayout(null);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setResizable(false);
		
		JTextArea txtReport = new JTextArea(report);
		txtReport.setBounds(10, 10, 580, 380);
		txtReport.setEditable(false);
		txtReport.setFont(new Font("Courier New", Font.PLAIN, 14));
		this.add(txtReport);
		
		this.repaint();
	}
	
	
}
