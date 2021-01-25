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

import javax.swing.JLabel;

public class Work {

	public JFrame frmPomodoro = new JFrame();
	private boolean pause = false;
	private Timer timer;
	JLabel TimerText = new JLabel("");
	int min ,sec;
	int[][] dotCoordinates = {
		{153,188,18,18}, {183,188,18,18}, {213,188,18,18},{243,188,18,18},
	}; 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Work window = new Work();
					window.frmPomodoro.setVisible(true);
					window.frmPomodoro.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Work() {
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

	private void initialize() {
		frmPomodoro.getContentPane().setBackground(Color.RED);
		frmPomodoro.getContentPane().setLayout(null);
		
		String absolutePath = Paths.get("").toAbsolutePath().toString();
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setIcon(new ImageIcon(absolutePath+"/res/pause.png"));
		
		btnNewButton.setBounds(163, 110, 81, 57);
		frmPomodoro.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pausePlayButton(btnNewButton, absolutePath);	
			}
		});
		
		TimerText.setBounds(170, 50, 115, 25);
		TimerText.setFont(new Font(TimerText.getFont().getName(),TimerText.getFont().getStyle(),30));
		frmPomodoro.getContentPane().add(TimerText);
		
		JButton btnNewButton_1 = new JButton("view stats");
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setBounds(317, 228, 115, 25);
		frmPomodoro.getContentPane().add(btnNewButton_1);
		
		for (int i = 0; i < dotCoordinates.length; i++) {
			JLabel dot = new JLabel("");
			dot.setIcon(new ImageIcon(absolutePath+"/res/twotone_dot.png"));
			dot.setBounds(dotCoordinates[i][0], dotCoordinates[i][1], dotCoordinates[i][2], dotCoordinates[i][3]);
			frmPomodoro.getContentPane().add(dot);
		}
		
		frmPomodoro.setTitle("Pomodoro");
		frmPomodoro.setIconImage(Toolkit.getDefaultToolkit().getImage(absolutePath+"/res/tomato.png"));
		frmPomodoro.setBounds(100, 100, 450, 300);
		frmPomodoro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		start();
	}

	private void start() {
		min = 25-1;
		sec = 10;
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(sec == 0) {
					sec = 60;
					min --;
				}
				
				if(min <= 0) {
					timer.stop();
				}
				
				sec --;
				TimerText.setText(min+":"+sec);
			}
		});
		
		timer.start();
	}
}
