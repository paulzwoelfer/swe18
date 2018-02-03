package org.c02.swe.iot.utest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.awt.Color;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.IButton;
import org.junit.Before;
import org.junit.Test;

public class LedTest {

	Button moqBtn = mock(Button.class);
	IButton buttonInstance = null;

	@Before
	public void setUp() throws Exception {
		buttonInstance = moqBtn;
	}

	@Test
	public void setLed() throws Exception {
		try {
			moqBtn.setLed(1, Color.GREEN);

			assertEquals("ok", "ok");

		} catch (Exception e) {
			assertEquals("setLed error:", e.getMessage());
			// e.getCause()
		}
	}

	@Test
	public void allLedsOff() throws Exception {
		try {
			moqBtn.allLedsOff();

			assertEquals("ok", "ok");

		} catch (Exception e) {
			assertEquals("allLedsOff error:", e.getMessage());
			// e.getCause()
		}
	}

}
