import javax.swing.JFrame;
import javax.swing.JLabel;


public class AboutWindow extends JFrame{
	public AboutWindow(){
		this.setVisible(true);
		this.setTitle("About");
		this.setLocation(200, 200);
		this.setSize(500, 300);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		
		String a = "<html>"
				+ "<b>DupCleaner v0.1</b><br>"
				+ "A desktop app that finds duplicate files on the filesystem and helps you clean up.<br>"
				+ "<br>Author: Jim Gao<br>"
				+ "<br><br>Visit: </br>"
				+ "https://github.com/jimthenerd/dupcleaner";
		
		JLabel about = new JLabel(a);
		about.setBounds(10, 10, 480, 180);
		this.add(about);
	}
}
