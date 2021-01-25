package state;

import java.awt.Color;

public class Work extends PomodoroState{
	private int position; 
	
	public Work(int pos) {
		this.position = pos;
	}
	
	@Override
	protected int getMinute() {
		return 1;
	}

	@Override
	protected Color getBackgroundColor() {
		return Color.RED;
	}

	@Override
	protected boolean isBreak() {
		return false;
	}
	
	@Override
	protected PomodoroState next() {
		if(position < 3)
			return new Break(position);
		
		return new LongBreak(); 
				
	}
}
