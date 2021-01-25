package state;

import java.awt.Color;

public class Pomodoro {
	private PomodoroState state;
	
	public Pomodoro() {
		state = new Work(1);
	}

	public void next() {
		state = state.next();
	}
	
	public int getMinute() {
		return state.getMinute();
	}

	public Color getBackgroundColor() {
		return state.getBackgroundColor();
	}
	
	public boolean isBreak() {
		return state.isBreak();
	}
}
