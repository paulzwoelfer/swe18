/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.c02.swe.iot.utest;

import java.io.IOException;
import org.c02.swe.iot.Button;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.behaviour.CountAndShowLedExtended;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author joshke
 */
public class CountAndShowLedExtendedTest {
    @Test
            public void testRedButtons(){
            
      IParticleApi api = new IParticleApi() {
                public  String lastFunctionCall="";
               
                @Override
                public int readVariable(String variable) throws IOException {
                if(variable.equals("countButton1"))
                {
                    return 1;
                }
                if(variable.equals("countButton2"))
                {
                    return 2;
                }
                if(variable.equals("countButton3"))
                {
                    return 4;
                }
                if(variable.equals("countButton4"))
                {
                    return 8;
                }
              
                
                return -1;
                }

                @Override
                public int callMethod(String method, String parameter) throws ParticleException {
                    
                    lastFunctionCall=method;
                    System.out.println("called "+method);
                    return 0;
                }
                
                public String getLastFunctionCall() {
                    return lastFunctionCall;
                }
                
                
		};
      Button btn =new Button(api);
      CountAndShowLedExtended cle=new CountAndShowLedExtended(btn);
      cle.start=true;
    assertEquals(cle.DoubleLighter(),0);
      
            }
            
            
}
