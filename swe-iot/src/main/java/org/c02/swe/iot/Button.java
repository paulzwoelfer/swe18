package org.c02.swe.iot;

import java.awt.Color;

import org.c02.swe.iot.cloud.api.IParticleApi;

public class Button implements IButton {

	IParticleApi wrapper;

	public Button(IParticleApi wrapperInstance) {
		wrapper = wrapperInstance;
	}

	public int getButtonClickCounter(ButtonDirection button) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setLed(int postition, Color color) {
		// TODO Auto-generated method stub
	}

	public void allLedsOff() {
		// TODO Auto-generated method stub

	}

	public void playSound() {
		// TODO Auto-generated method stub

	}

	public void resetButtonClickCounters() {
		// TODO Auto-generated method stub
		
	}

}
