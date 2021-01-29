package main;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import factory.LogDataFactory;
import observer.Observer;
import proxy.ReadLogProxy;

import java.awt.Toolkit;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ViewStats implements Observer {
	
	private JFrame frm = new JFrame();
	private JPanel counterPanel = new JPanel();
	private static ViewStats stats;
	private String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
	private int[] logs = {0,0,0,0,0,0,0};
	private int totalData = 0;
	
	public static void main(String[] args) {
		new ViewStats();
	}
	public static ViewStats getInstance() {
		if(stats == null) stats = new ViewStats();
		
		return stats;
	}
	
	private ViewStats() {}

	protected void initialize() {
		ReadLogProxy logProxy = new ReadLogProxy();
		int[] result = logProxy.readData(totalData);
		
		if(result != null) {
			logs = result;
			totalData = logProxy.getTotalData();
		}
		
		logProxy = null;
		
		String absolutePath = Paths.get("").toAbsolutePath().toString();
		frm.setVisible(true);
		frm.setResizable(false);
		frm.setIconImage(Toolkit.getDefaultToolkit().getImage(absolutePath+"/res/tomato.png"));
		frm.setTitle("Pomodoro");
		frm.setBounds(100, 100, 450, 150);
		
		generateLogCount();
		
		frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void generateLogCount() {
		counterPanel.setBounds(0, 50, 200, 200);
		counterPanel.removeAll();
		int firstX = 12;
		for (int i = 0; i < 7; i++) {
			JLabel lblNewLabel = new JLabel(days[i]);
			JLabel label = new JLabel(String.valueOf(logs[i]));
			
			lblNewLabel.setBounds(firstX, 26, 30, 16);
			label.setBounds(firstX, 43, 30, 16);
			
			counterPanel.add(label);
			counterPanel.add(lblNewLabel);
			
			firstX += 28;
		}
		frm.repaint();
		frm.add(counterPanel);
	}
	
	@Override
	public void update(Date time) {
		totalData++;
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssX").format(new Timestamp(time.getTime()));
		int index = LogDataFactory.convertToDay(date);
		
		if(index < 0) return;
	
		logs[index] += 1;

		generateLogCount();
	}
}
