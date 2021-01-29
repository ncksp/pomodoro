package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainUI {
	private JFrame frmPomodoro = new JFrame();
	private JPanel dotsPanel = new JPanel();
	private int workPos = 0;
	JLabel TimerText = new JLabel("");
	JButton skipButton = new JButton("");
	JButton pauseButton = new JButton("");
	JButton viewStatsButton =new JButton("view stats");
	String absolutePath = Paths.get("").toAbsolutePath().toString();
	
	int[][] dotCoordinates = {
		{153,188,18,18}, {183,188,18,18}, {213,188,18,18},{243,188,18,18},
	}; 
	
	public MainUI() {
		this.frmPomodoro.setVisible(true);
		this.frmPomodoro.setResizable(false);
	}
	
	void initializeBreakState(Color color) {
		skipButton.setVisible(true);
		pauseButton.setBounds(105, 110, 81, 57);
		frmPomodoro.getContentPane().setBackground(color);

		dotsPanel.setBackground(color);
	}
	
	 void initializeWorkState(Color color) {
		workPos++;
		skipButton.setVisible(false);
		pauseButton.setBounds(163, 110, 81, 57);
		frmPomodoro.getContentPane().setBackground(color);
		
		if(workPos >= 4) workPos = 0;
			
		generateDots(color);
	}
	
	private void generateDots(Color color) {
		dotsPanel.removeAll();
		dotsPanel.setBackground(color);
		dotsPanel.setBounds(150, 188, 100, 25);
		
		for (int i = 0; i < dotCoordinates.length; i++) {
			JLabel dot = new JLabel("");
			if(i <= workPos)
				dot.setIcon(new ImageIcon(absolutePath+"/res/twotone_dot.png"));
			else
				dot.setIcon(new ImageIcon(absolutePath+"/res/outline_dot.png"));
			
			dot.setBounds(dotCoordinates[i][0], dotCoordinates[i][1], dotCoordinates[i][2], dotCoordinates[i][3]);
			dotsPanel.add(dot);
		}
		
		frmPomodoro.add(dotsPanel);
	}
	
	protected void initialize() {
		frmPomodoro.setLocationRelativeTo(null);
		frmPomodoro.getContentPane().setBackground(Color.RED);
		frmPomodoro.getContentPane().setLayout(null);
		
		TimerText.setBounds(170, 50, 115, 25);
		TimerText.setFont(new Font(TimerText.getFont().getName(),TimerText.getFont().getStyle(),30));
		frmPomodoro.getContentPane().add(TimerText);
		
		generateDots(Color.RED);
		
		pauseButton.setBackground(Color.RED);
		pauseButton.setIcon(new ImageIcon(absolutePath+"/res/pause.png"));
		pauseButton.setBounds(163, 110, 81, 57);
		frmPomodoro.add(pauseButton);
		
		skipButton.setBackground(new Color(0, 139, 139));
		skipButton.setIcon(new ImageIcon(absolutePath+"/res/skip.png"));
		skipButton.setBounds(221, 110, 81, 57);
		skipButton.setVisible(false);
		frmPomodoro.add(skipButton);
		
		viewStatsButton.setBackground(Color.RED);
		viewStatsButton.setBounds(317, 228, 115, 25);	
		frmPomodoro.add(viewStatsButton);
	
		frmPomodoro.setTitle("Pomodoro");
		frmPomodoro.setIconImage(Toolkit.getDefaultToolkit().getImage(absolutePath+"/res/tomato.png"));
		frmPomodoro.setSize(450, 300);
		frmPomodoro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmPomodoro.setLocation(dim.width/2-frmPomodoro.getSize().width/2, dim.height/2-frmPomodoro.getSize().height/2);

	}
	
	void setTimer(int minutes, int second){
		this.TimerText.setText(minutes+":"+second);
	}
}
