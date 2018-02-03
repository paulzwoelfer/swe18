package org.c02.swe.iot.cloud.api;

import java.io.IOException;

public interface IParticleApi {

	int readVariable(String variable) throws IOException;

	int callMethod(String method, String parameter) throws ParticleException;

}