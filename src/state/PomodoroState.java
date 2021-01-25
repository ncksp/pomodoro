package state;

import java.awt.Color;

public abstract class PomodoroState {
	protected abstract int getMinute();
	protected abstract Color getBackgroundColor();
	protected abstract boolean isBreak();
	protected abstract PomodoroState next();
}
