package main;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import state.Pomodoro;

import javax.swing.JLabel;

public class Main {

	public JFrame frmPomodoro = new JFrame();
	private boolean pause = false;
	private Timer timer;
	private Pomodoro pomodoro = new Pomodoro();
	private int workPos = 1;
	JLabel TimerText = new JLabel("");
	JButton skipButton = new JButton("");
	JButton pauseButton = new JButton("");
	String absolutePath = Paths.get("").toAbsolutePath().toString();
	
	int min ,sec = 10;
	int[][] dotCoordinates = {
		{153,188,18,18}, {183,188,18,18}, {213,188,18,18},{243,188,18,18},
	}; 
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmPomodoro.setVisible(true);
					window.frmPomodoro.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}
	
	private void pausePlayButton(JButton button, String Path) {
		if(!pause) {			
			button.setIcon(new ImageIcon(Path+"/res/play.png"));
			timer.stop();
		}
		else {			
			button.setIcon(new ImageIcon(Path+"/res/pause.png"));
			timer.start();
		}
		
		pause = !pause;
	}
	
	private void initializeBreakState(Color color) {
		skipButton.setVisible(true);
		pauseButton.setBounds(105, 110, 81, 57);
		frmPomodoro.getContentPane().setBackground(color);
	}
	
	private void initializeWorkState(Color color) {
		workPos++;
		skipButton.setVisible(false);
		pauseButton.setBounds(163, 110, 81, 57);
		frmPomodoro.getContentPane().setBackground(color);
		
		if(workPos > 4) workPos = 1;
		
		generateDots();
	}
	
	private void generateDots() {
		for (int i = 0; i < dotCoordinates.length; i++) {
			JLabel dot = new JLabel("");
			
			if(i < workPos)
				dot.setIcon(new ImageIcon(absolutePath+"/res/twotone_dot.png"));
			else
				dot.setIcon(new ImageIcon(absolutePath+"/res/outline_dot.png"));
			
			dot.setBounds(dotCoordinates[i][0], dotCoordinates[i][1], dotCoordinates[i][2], dotCoordinates[i][3]);
			frmPomodoro.getContentPane().add(dot);
		}
	}

	private void initialize() {
		frmPomodoro.getContentPane().setBackground(Color.RED);
		frmPomodoro.getContentPane().setLayout(null);
		
		pauseButton.setBackground(Color.RED);
		pauseButton.setIcon(new ImageIcon(absolutePath+"/res/pause.png"));
		
		pauseButton.setBounds(163, 110, 81, 57);
		
		pauseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pausePlayButton(pauseButton, absolutePath);	
			}
		});		
		frmPomodoro.getContentPane().add(pauseButton);
		
		
		skipButton.setBackground(new Color(0, 139, 139));
		skipButton.setIcon(new ImageIcon(absolutePath+"/res/skip.png"));
		skipButton.setBounds(221, 110, 81, 57);
		skipButton.setVisible(false);
		
		frmPomodoro.getContentPane().add(skipButton);
		
		TimerText.setBounds(170, 50, 115, 25);
		TimerText.setFont(new Font(TimerText.getFont().getName(),TimerText.getFont().getStyle(),30));
		frmPomodoro.getContentPane().add(TimerText);
		
		generateDots();
		
		JButton btnNewButton_1 = new JButton("view stats");
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setBounds(317, 228, 115, 25);
		frmPomodoro.getContentPane().add(btnNewButton_1);
		
		frmPomodoro.setTitle("Pomodoro");
		frmPomodoro.setIconImage(Toolkit.getDefaultToolkit().getImage(absolutePath+"/res/tomato.png"));
		frmPomodoro.setBounds(100, 100, 450, 300);
		frmPomodoro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		start();
	}

	private void start() {
		min = pomodoro.getMinute() - 1;
		timer = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(min <= 0 && sec == 0) {
					pomodoro.next();
					min = pomodoro.getMinute();
				}
				
				if(!pomodoro.isBreak())
					initializeWorkState(pomodoro.getBackgroundColor());
				
				if(pomodoro.isBreak())
					initializeBreakState(pomodoro.getBackgroundColor());

				if(sec == 0) {
					sec = 60;
					min --;
				}
				sec --;
				TimerText.setText(min+":"+sec);
			}
		});
		
		timer.start();
	}
}
