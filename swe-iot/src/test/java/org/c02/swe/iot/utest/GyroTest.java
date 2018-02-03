/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.c02.swe.iot.utest;

import java.io.IOException;
import org.c02.swe.iot.Button;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author joshke
 */
public class GyroTest {
    @Test
    
    
    public void GyroTest()
    {
          IParticleApi api = new IParticleApi() {
            public String lastFunctionCall = "";

            @Override
            public int callMethod(String method, String parameter) throws ParticleException {
             return 0;
            }

            public String getLastFunctionCall() {
                return lastFunctionCall;
            }

            @Override
            public int readVariable(String variable) throws IOException {
                if(variable.equals("xValue"))
                    return 50;
                 if(variable.equals("yValue"))
                    return 70;
                  if(variable.equals("zValue"))
                    return -50;
                  return 0;

            }

        };

        Button btn =new Button(api);
        assertEquals(btn.getDirectionValue(IButton.axes.x),50);
         assertEquals(btn.getDirectionValue(IButton.axes.y),70);
          assertEquals(btn.getDirectionValue(IButton.axes.z),-50);
          
          System.out.println(btn.getDirectionValue(IButton.axes.z));
    }
}
