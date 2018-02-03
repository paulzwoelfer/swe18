package org.c02.swe.iot.cloud.examples;

import java.io.IOException;

import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

public class ButtonDemo {

	static IParticleApi api = new ParticleApi(new ButtonConnection());

	public static void main(String[] args) throws IOException, InterruptedException, ParticleException {

		// auslesen der Tastendrucke von Button 1 (1 Punkt) countButton2 mit 2
		// Punkten usw...
		System.out.println(api.readVariable("countButton1"));
		System.out.println(api.readVariable("countButton2"));
		System.out.println(api.readVariable("countButton3"));
		System.out.println(api.readVariable("countButton4"));

		Thread.sleep(2000);

		System.out.println(api.readVariable("countButton1"));
		System.out.println(api.readVariable("countButton2"));
		System.out.println(api.readVariable("countButton3"));
		System.out.println(api.readVariable("countButton4"));


		api.callMethod("reset",null);

		System.out.println(api.readVariable("countButton1"));
		System.out.println(api.readVariable("countButton2"));
		System.out.println(api.readVariable("countButton3"));
		System.out.println(api.readVariable("countButton4"));
	}

}
