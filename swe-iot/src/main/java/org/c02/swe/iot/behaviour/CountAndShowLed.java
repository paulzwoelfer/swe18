package org.c02.swe.iot.behaviour;

import java.awt.Color;

import org.c02.swe.iot.IButton;
import org.c02.swe.iot.IButton.ButtonDirection;

public class CountAndShowLed extends AbstractBehaviour {

	public CountAndShowLed(IButton buttonInstance) {
		super(buttonInstance);
	}

	@Override
	public void run() {
		int buttonCounter = button.getButtonClickCounter(ButtonDirection.North);
		button.setLed(buttonCounter, Color.GREEN);
	}

}
