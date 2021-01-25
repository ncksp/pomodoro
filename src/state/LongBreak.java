package state;

import java.awt.Color;

public class LongBreak extends PomodoroState{
	@Override
	protected int getMinute() {
		return 15;
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
		return new Work(1);
	}
}
