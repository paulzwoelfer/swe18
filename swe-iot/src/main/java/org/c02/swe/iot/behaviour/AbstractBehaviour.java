package org.c02.swe.iot.behaviour;

import org.c02.swe.iot.IButton;

public abstract class AbstractBehaviour implements Runnable {

	protected IButton button;

	public AbstractBehaviour(IButton buttonInstance) {
		button = buttonInstance;
	}

}
