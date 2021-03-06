package org.c02.swe.iot.behaviour;

import java.awt.Color;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.IButton.ButtonDirection;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;

public class CountAndShowLedExtended extends AbstractBehaviour {

	public CountAndShowLedExtended(Button buttonInstance) {
		super(buttonInstance);
                bt=buttonInstance;
	}

	private static Button bt;
	int buttonPos = 0;
	int buttonOldPos = 0;
	int counter = 0;
	int rgb = 0;
	public static boolean run = false;
        public boolean start = false;

	private void startup() {
		bt.resetButtonClickCounters();
		System.out.println("init\n");
		SetAllLedsWhite();
		counter = 0;
	}

	private void shutdown() {
		counter = 0;
	}

	public int DoubleLighter() {
		try {
			if (start|| run) {
				startup();
			}
			start = false;
                        run = false;

			int pos = CheckCountIfClick();
			System.out.println(CheckCountIfClick() + "BitCode");
			if (pos == 5) {
				System.out.println("NORD_SUD klick");
				counter++;
				if (rgb == 250)
					shutdown();
				rgb = rgb + 10;

				System.out.println("Value=" + rgb);
				RaiseAllLeds(rgb);
			}

			if (pos == 10) {
				System.out.println("West_OST klick");
				counter++;
				if (rgb == 250)
					shutdown();
				rgb = rgb + 10;
				System.out.println("Value=" + rgb);
				RaiseAllLeds(rgb);
			}

			if (pos != 0)
				bt.resetButtonClickCounters();

			if (counter == 25) {
				rgb = 0;
			}
			return rgb;
		} catch (Exception ex) {
			return 0;
		}
	}

	@Override
	public void run() {
		DoubleLighter();
	}

	private static int CheckCountIfClick() {
		int n, s, e, w, ret = 0;

		try {

			n = bt.getButtonClickCounter(ButtonDirection.North); // 1
			e = bt.getButtonClickCounter(ButtonDirection.East); // 2
			s = bt.getButtonClickCounter(ButtonDirection.South); // 4
			w = bt.getButtonClickCounter(ButtonDirection.West); // 8

			if (n > 1)
				ret = ret + 1;
			if (e > 1)
				ret = ret + 2;
			if (s > 1)
				ret = ret + 4;
			if (w > 1)
				ret = ret + 8;

			return ret;
		} catch (Exception ex) {
			return 0;
		}
	}

	private void SetAllLedsWhite() {
		try {
			for (int i = 0; i < 12; i++) {
				button.setLed(i, Color.black);
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}

	private void RaiseAllLeds(int value) {
		try {
			Color color = new Color(Color.black.getRed() + value, Color.black.getGreen(), Color.black.getBlue());

			for (int i = 0; i < 12; i++) {
				button.setLed(i, color);
			}

		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}

	public static void main(String[] args) {
		IParticleApi api = new ParticleApi(new ButtonConnection());
		bt = new Button(api);
		run = true;

		System.out.println("started...");

		while (true) {
			CountAndShowLedExtended casl = new CountAndShowLedExtended(bt);
			casl.run();

			if (CheckCountIfClick() == 15) {
				System.out.println("stopped");

				bt.allLedsOff();
				break;
			}
		}
	}
}
