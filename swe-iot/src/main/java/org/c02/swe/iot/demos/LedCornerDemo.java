package org.c02.swe.iot.demos;

import java.awt.Color;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;

public class LedCornerDemo {
	
	static IParticleApi api = new ParticleApi(new ButtonConnection());
	
	public void TestButtonCorner(Button bt) {
		bt.ledcorner("100111000000", Color.GREEN);
		
	}

	public static void main(String[] args) {
		Button bt = new Button(api);
		LedCornerDemo lc = new LedCornerDemo();
		lc.TestButtonCorner(bt);
		
    }
}
