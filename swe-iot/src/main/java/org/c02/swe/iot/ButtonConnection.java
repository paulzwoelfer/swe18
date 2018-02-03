package org.c02.swe.iot;

import java.io.IOException;
import java.util.Properties;

public class ButtonConnection {
	private String deviceId;
	private String accessToken;

	public ButtonConnection() {
		Properties temp = new Properties();
		try {
			temp.load(getClass().getClassLoader().getResourceAsStream("device.properties"));

			deviceId = temp.getProperty("deviceId");
			accessToken = temp.getProperty("accessToken");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ButtonConnection(String deviceId, String accessToken) {
		super();
		this.deviceId = deviceId;
		this.accessToken = accessToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getDeviceId() {
		return deviceId;
	}
}
