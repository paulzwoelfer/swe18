package org.c02.swe.iot.utest;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.IButton.ButtonDirection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class ButtonPressedTest {

	@Test 
	public void testResetButtonCount() throws Exception {
		//setup
		Button bt = mock(Button.class);
		int countN = bt.getButtonClickCounter(ButtonDirection.North);
		int countE = bt.getButtonClickCounter(ButtonDirection.East);
		int countS = bt.getButtonClickCounter(ButtonDirection.South);
		int countW = bt.getButtonClickCounter(ButtonDirection.West);
		bt.resetButtonClickCounters();
		
		assertTrue(countN>=0&&countS>=0&&countW>=0&&countE>=0);
		
		assertEquals(0,countN);
		assertEquals(0,countE);
		assertEquals(0,countS);
		assertEquals(0,countW);
		
	}
	
}
