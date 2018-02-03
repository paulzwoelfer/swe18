package org.c02.swe.iot.cloud.examples;

import java.io.IOException;

import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

public class LedAndPlayDemo {

	static IParticleApi api = new ParticleApi(new ButtonConnection());

	public static void main(String[] args) throws IOException, ParticleException {

		api.callMethod("ledsOff", null); // Schaltet die LEDs aus
		// nn = Position 01-12
		// rrr = rot
		// ggg = grün
		// bbb = blau
		// nnrrrgggbbb
		api.callMethod("led", "01255255255");
		api.callMethod("led", "05255000000");
		api.callMethod("led", "06000255000");
		api.callMethod("led", "07000000255");
		api.callMethod("led", "11000255255");

		api.callMethod("play", null); // Spielt einen melodie ab

		api.callMethod("ledsOff", null);

	}

}
