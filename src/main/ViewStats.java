package main;
import javax.swing.JFrame;
import javax.swing.JLabel;

import observer.Observer;
import proxy.ReadLogProxy;

import java.awt.Toolkit;
import java.nio.file.Paths;
import java.util.Date;

public class ViewStats implements Observer {
	
	private JFrame frm = new JFrame();
	private static ViewStats stats;
	private String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
	private int[] counts = {0,0,0,0,0,0,0};
	private int totalData = 0;
	
	public static ViewStats getInstance() {
		if(stats == null) stats = new ViewStats();
		
		return stats;
	}
	
	private ViewStats() {}

	protected void initialize() {
		ReadLogProxy logProxy = new ReadLogProxy();
		int[] result = logProxy.readData(totalData);
		
		if(result != null) {
			counts = result;
			totalData = logProxy.getTotalData();
		}
		
		logProxy = null;
		
		String absolutePath = Paths.get("").toAbsolutePath().toString();
		frm.setVisible(true);
		frm.setResizable(false);
		frm.setIconImage(Toolkit.getDefaultToolkit().getImage(absolutePath+"/res/tomato.png"));
		frm.setTitle("Pomodoro");
		frm.setBounds(100, 100, 450, 150);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.getContentPane().setLayout(null);
		
		int firstX = 12;
		for (int i = 0; i < 7; i++) {
			JLabel lblNewLabel = new JLabel(days[i]);
			JLabel label = new JLabel(String.valueOf(counts[i]));
			
			lblNewLabel.setBounds(firstX, 26, 30, 16);
			label.setBounds(firstX, 43, 30, 16);
			
			frm.getContentPane().add(label);
			frm.getContentPane().add(lblNewLabel);
			
			firstX += 58;
		}
		
		frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void update(Date time) {
		totalData++;
		System.out.println(time);
	}
}
