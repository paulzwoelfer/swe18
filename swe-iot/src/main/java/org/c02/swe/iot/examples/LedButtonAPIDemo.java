package org.c02.swe.iot.examples;

import java.awt.Color;
import java.io.IOException;

import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.Button;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;

public class LedButtonAPIDemo {

	static IParticleApi api = new ParticleApi(new ButtonConnection());
	
	public static void main(String[] args) throws IOException {

		IButton button = new Button(api);
		button.setLed(2, Color.ORANGE);
		
	}

}
