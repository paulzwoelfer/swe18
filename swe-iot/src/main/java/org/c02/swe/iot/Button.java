package org.c02.swe.iot;

import java.awt.Color;
import java.io.IOException;

import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

public class Button implements IButton {

	IParticleApi wrapper;
	static IParticleApi api = new ParticleApi(new ButtonConnection());

	public Button(IParticleApi wrapperInstance) {
		wrapper = wrapperInstance;
	}

	public int getButtonClickCounter(ButtonDirection button) {
		int counter = -1;
		try {
			counter = api.readVariable("countButton" + getButtonDirectionToInt(button));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return counter;
	}

	public void setLed(int postition, Color color) {
		// TODO Auto-generated method stub
	}

	public void allLedsOff() {
		// TODO Auto-generated method stub

	}

	public void playSound() {
		try {
			api.callMethod("play", null);
		} catch (ParticleException e) {
			e.printStackTrace();
		}

	}

	public void resetButtonClickCounters() {
		// TODO Auto-generated method stub
		
	}

	private static int getButtonDirectionToInt (ButtonDirection buttonDirection) {
		switch (buttonDirection) {
			case North: return 1;
			case East: return 3;
			case West: return 4;
			case South: return 2;
			default: return -1;
		}
	}
}
