package main;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import observer.Log;
import state.Pomodoro;

public class Main {
	private final int SECOND = 60;
	private boolean pause = false;
	private Timer timer;
	private Pomodoro pomodoro = new Pomodoro();
	private Log logging = new Log();
	private ViewStats stats = null;
	String absolutePath = Paths.get("").toAbsolutePath().toString();
	int min, sec = SECOND;
	
	private MainUI ui;
	
	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		ui = new MainUI();
		logging.addObserver(new Logger());
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
		
		ui.viewStatsButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				stats = null;
				showStats();
			}
		});
		start();
	}
	
	private void showStats() {
		stats = ViewStats.getInstance();
		stats.initialize();
		
		logging.addObserver(stats);
	}
	
	private void start() {
		min = pomodoro.getMinute() - 1;
		timer = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(min <= 0 && sec == 0) {
					pomodoro.next();
					min = pomodoro.getMinute();
					
					if(!pomodoro.isBreak())
						ui.initializeWorkState(pomodoro.getBackgroundColor());
					
					if(pomodoro.isBreak()) {
						logging.broadcast(new Date());
						ui.initializeBreakState(pomodoro.getBackgroundColor());
					}
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
