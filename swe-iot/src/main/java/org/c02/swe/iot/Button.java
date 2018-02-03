package org.c02.swe.iot;

import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

public class Button implements IButton {

	IParticleApi wrapper;
	static IParticleApi api = new ParticleApi(new ButtonConnection());

	public Button(IParticleApi wrapperInstance) {
		api = wrapperInstance;
	}

        @Override
	public int getButtonClickCounter(ButtonDirection button) {
	   try {
					if(button==ButtonDirection.North){
					 return api.readVariable("countButton1");
					}
					 if(button==ButtonDirection.East){
					 return api.readVariable("countButton2");
					}
					  if(button==ButtonDirection.West){
					 return api.readVariable("countButton4");
					}
					   if(button==ButtonDirection.South){
					 return api.readVariable("countButton3");
					}

			  } catch (IOException ex) {
				  Logger.getLogger(Button.class.getName()).log(Level.SEVERE, null, ex);
			  }

	return 0;
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
	public void setLed(int postition, int red, int green, int blue) {
		try {


			String R = String.format("%03d", red);

			String G = String.format("%03d", green);

			String B = String.format("%03d", blue);
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
		try {
			api.callMethod("reset", null);
		} catch (ParticleException e) {
			e.printStackTrace();
		}

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

	@Override
	public int getDirectionValue(axes direction) {
		int gyro = 0;
		try {
			gyro = api.readVariable(direction.name() + "Value");
			System.out.println(direction.name() + "Value" + " gyro: " + gyro);

/*			System.out.println("x: " + api.readVariable("xValue"));
			System.out.println("y: " + api.readVariable("yValue"));
			System.out.println("z: " + api.readVariable("zValue"));*/
		} catch (IOException e) {
			e.printStackTrace();
		}
		return gyro;
	}
}
