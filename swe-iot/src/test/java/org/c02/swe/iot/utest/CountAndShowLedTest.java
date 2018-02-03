/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.c02.swe.iot.utest;


import java.io.IOException;
import org.c02.swe.iot.Button;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.behaviour.CountAndShowLed;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author joshke
 */
public class CountAndShowLedTest {
 
    @Test
    public void countandshowTest() throws IOException
    {
           
   
            IParticleApi api = new IParticleApi() {
                public  String lastFunctionCall="";
               
                @Override
                public int readVariable(String variable) throws IOException {
                    if(variable.equals("countButton1"))
                    {
                        return 5;
                    }
                    if(lastFunctionCall.length()>5)
                    return Integer.parseInt(lastFunctionCall.substring(4,5));
                    else
                        return -1;
                }

                @Override
                public int callMethod(String method, String parameter) throws ParticleException {
                    if(parameter!=null){
                        lastFunctionCall = method + parameter;
                     System.out.println("called " + method+parameter);
                    }
                    else{
                        lastFunctionCall = method;
                    System.out.println("called " + method);
                    }
                    return 0;
                }
                
                public String getLastFunctionCall() {
                    return lastFunctionCall;
                }
                
                
            };
            
            Button btn=new Button(api);
            int clickcount=btn.getButtonClickCounter(IButton.ButtonDirection.North);
            CountAndShowLed casl = new CountAndShowLed(btn);
            casl.run();
            int btnnum=clickcount%12;
            
          System.out.println("btn pressed"+api.readVariable("")+"btn num: "+btnnum);
          assertEquals(api.readVariable(""),btnnum);
            
            
    }
    }
