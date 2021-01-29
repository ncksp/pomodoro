package main;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import state.Pomodoro;

public class Main {
	private final int SECOND = 60;
	private boolean pause = false;
	private Timer timer;
	private Pomodoro pomodoro = new Pomodoro();
	String absolutePath = Paths.get("").toAbsolutePath().toString();
	int min, sec = SECOND;
	private MainUI ui;
	
	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		ui = new MainUI();
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
		ui.initialize();
		ui.pauseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pausePlayButton((JButton) e.getSource(), absolutePath);	
			}
		});		
		ui.skipButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				min = sec = 0;
			}
		});		
		
		start();
	}

	private void start() {
		min = pomodoro.getMinute() - 1;
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(min <= 0 && sec == 0) {
					pomodoro.next();
					min = pomodoro.getMinute();
					
					if(!pomodoro.isBreak())
						ui.initializeWorkState(pomodoro.getBackgroundColor());
					
					if(pomodoro.isBreak())
						ui.initializeBreakState(pomodoro.getBackgroundColor());
				}
				
				if(sec == 0) {
					sec = SECOND;
					min --;
				}
				
				sec --;
				ui.setTimer(min, sec);
			}
		});
		
		timer.start();
	}
}
