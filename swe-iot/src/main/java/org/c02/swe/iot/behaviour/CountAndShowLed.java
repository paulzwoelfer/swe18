package org.c02.swe.iot.behaviour;

import java.awt.Color;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.IButton.ButtonDirection;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;

public class CountAndShowLed extends AbstractBehaviour {

	public CountAndShowLed(IButton buttonInstance) {
		super(buttonInstance);
	}

	@Override
	public void run() {
		int buttonCounter = button.getButtonClickCounter(ButtonDirection.North);
		System.out.println("buttonCounter: " + buttonCounter);

		buttonCounter = (buttonCounter) % 12;
		System.out.println("buttonCounter2: " + buttonCounter);
		button.setLed(buttonCounter, Color.GREEN);
	}

	public static void main(String[] args) {
		IParticleApi api = new ParticleApi(new ButtonConnection());
		Button bt = new Button(api);
		CountAndShowLed casl = new CountAndShowLed(bt);
		casl.run();

	}
}
