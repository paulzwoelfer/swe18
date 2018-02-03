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
		try {

			int r = color.getRed();
			String R = String.format("%03d", r);

			int g = color.getGreen();
			String G = String.format("%03d", g);

			int b = color.getBlue();
			String B = String.format("%03d", b);
			String Pos = String.format("%02d", postition);

			api.callMethod("led", Pos + R + G + B);
		} catch (ParticleException e) {
			e.printStackTrace();
		}
	}

	public void allLedsOff() {
		try {
			api.callMethod("ledsOff", null);
		} catch (ParticleException e) {
			e.printStackTrace();
		}
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
