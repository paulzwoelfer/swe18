package org.c02.swe.iot.demos;

import java.awt.Color;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;

public class LedDemoApp {

	static IParticleApi api = new ParticleApi(new ButtonConnection());

	public static void main(String[] args) {
		Button bt = new Button(api);

		for (int i = 6; i < args.length; i++) {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			bt.setLed(i, Color.green);
		}

		// bt.allLedsOff();

		for (int i = 6; i < args.length; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			bt.setLed(i, Color.green);
		}

		bt.allLedsOff();

	}

}
