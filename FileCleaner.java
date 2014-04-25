import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;


public class FileCleaner extends JFrame {
	public FileCleaner(){
		this.setVisible(true);
		this.setTitle("DupCleaner");
		this.setLocation(100, 100);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		
		
		final DefaultListModel<String> flist = new DefaultListModel<String>();
		final ArrayList<File> fileList = new ArrayList<File>();
		JList files = new JList(flist);
		files.setBounds(10, 10, 600, 550);
		this.add(files);
		
		JButton scan = new JButton("Scan Files");
		scan.setBounds(620, 10, 160, 30);
		scan.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				flist.clear();
				fileList.clear();
				JFileChooser chooser = new JFileChooser();
				
				chooser.setDialogTitle("Select Folder");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
				
				chooser.showOpenDialog(getParent());
				String path = chooser.getSelectedFile().toString();
				
				System.out.println(path);
				
				ArrayList<File> files = new ArrayList<File>();
				queryFiles(files, path);
				
				ProgressWindow w = new ProgressWindow();
				
				for (int i=0; i<files.size(); i++){
					flist.addElement(files.get(i).getAbsolutePath());
					System.out.println(files.get(i).getAbsolutePath());
					
					fileList.add(files.get(i));
					w.countUp();
				}
				
				w.close();
				
			}
			
			
			
		});
		this.add(scan);
		
		JButton report = new JButton("Generate Report");
		report.setBounds(620, 50, 160, 30);
		report.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				final ArrayList<File> firstGroup = new ArrayList<File>();
				final ArrayList<File> secondGroup = new ArrayList<File>();
				
				String report = "Duplicate Files: \n\n";
				
				for (int i=0; i<flist.size(); i++){
					for (int j=0; j<i; j++){
						if (fileList.get(i).getName().equals(fileList.get(j).getName())){
							firstGroup.add(fileList.get(i));
							secondGroup.add(fileList.get(j));
							report += (fileList.get(i).getAbsolutePath() + "\n" +
									   fileList.get(j).getAbsolutePath() + "\n\n");
						}
					}
				}
				
				report += "\n" + "End of Report";
				
				new ReportViewer(report, "Duplicate Files");
			}
			
		});
		this.add(report);
		
		
		
		this.repaint();
	}
	
	public void queryFiles(ArrayList<File> files, String path){
		File directory = new File(path);
		
		File[] f = directory.listFiles();
		for (int i=0; i<f.length; i++){
			if (f[i].isFile()){
				files.add(f[i]);
			} else if (f[i].isDirectory()){
				queryFiles(files, f[i].getAbsolutePath());
			}
		}
	}
	
}
