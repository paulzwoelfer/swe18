package org.c02.swe.iot;

import java.awt.Color;

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
		// TODO Auto-generated method stub
		return 0;
	}

	public void setLed(int postition, Color color) {
		try {
			api.callMethod("led", postition + color.toString());
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

}
