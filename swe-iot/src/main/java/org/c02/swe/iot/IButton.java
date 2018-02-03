package org.c02.swe.iot;

import java.awt.Color;

public interface IButton {

	public enum ButtonDirection {
		// Button:
		//1     2      3     4
		North, South, East, West
	}
	public enum axes {
		x, y, z;
	}

	int getButtonClickCounter(ButtonDirection button);
	
	void resetButtonClickCounters();
	
	void setLed(int postition, Color color);

	void setLed(int postition, int red, int green, int blue);
	
	void allLedsOff();
	
	void playSound();

	int getDirectionValue(axes direction);

}
