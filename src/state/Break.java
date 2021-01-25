package state;

import java.awt.Color;

public class Break extends PomodoroState{
	private int position; 
	
	public Break(int pos) {
		this.position = pos;
	}
	
	@Override
	protected int getMinute() {
		return 1;
	}

	@Override
	protected Color getBackgroundColor() {
		return new Color(0, 139, 139);
	}

	@Override
	protected boolean isBreak() {
		return true;
	}

	@Override
	protected PomodoroState next() {
		return new Work(position + 1);
	}
}
