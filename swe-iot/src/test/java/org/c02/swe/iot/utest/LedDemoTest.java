/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.c02.swe.iot.utest;

import java.awt.Color;
import java.io.IOException;
import org.c02.swe.iot.Button;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author joshke
 */
public class LedDemoTest {

    @Test
    public void testLed() throws Exception {

        IParticleApi api = new IParticleApi() {
            public String lastFunctionCall = "";

            @Override
            public int callMethod(String method, String parameter) throws ParticleException {
                if(parameter!=null)
                lastFunctionCall = method + parameter;
                else
                     lastFunctionCall = method;
                System.out.println("called " + method);
                return 0;
            }

            public String getLastFunctionCall() {
                return lastFunctionCall;
            }

            @Override
            public int readVariable(String variable) throws IOException {
                if (variable.equals(lastFunctionCall)) {
                    return 1;
                } else {
                    return 0;
                }
            }

        };

        Button btn = new Button(api);
        btn.setLed(1, Color.GREEN);

        int r = Color.GREEN.getRed();
        String R = String.format("%03d", r);

        int g = Color.GREEN.getGreen();
        String G = String.format("%03d", g);

        int b = Color.GREEN.getBlue();
        String B = String.format("%03d", b);
        String Pos = String.format("%02d", 1);

        String methodcall = "led" + Pos + R + G + B;
        
        assertEquals(api.readVariable(methodcall),1);
        
        btn.allLedsOff();
        assertEquals(api.readVariable("ledsOff"),1);
    }

}
