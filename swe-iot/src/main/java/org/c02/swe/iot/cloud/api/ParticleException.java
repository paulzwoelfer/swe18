package org.c02.swe.iot.cloud.api;

public class ParticleException extends Exception {

	private static final long serialVersionUID = -3845871457886713756L;

	public ParticleException() {
	}

	public ParticleException(String message) {
		super(message);
	}

	public ParticleException(Throwable cause) {
		super(cause);
	}

	public ParticleException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParticleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
