/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.c02.swe.iot.utest;

import java.awt.Color;
import java.io.IOException;
import org.c02.swe.iot.Button;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.c02.swe.iot.demos.ClickSoundDemo;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;

/**
 *
 * @author joshke
 */
public class ClickSoundTest {
   @Test 
	public void testmusicPlay() throws Exception {
           
            
            
            IParticleApi api = new IParticleApi() {
                public  String lastFunctionCall="";
               
                @Override
                public int readVariable(String variable) throws IOException {
                if(variable.equals("countButton1"))
                {
                    return 5;
                }
                if(variable.equals("countButton2"))
                {
                    return 8;
                }
                if(variable.equals("countButton3"))
                {
                    return 1;
                }
                if(variable.equals("countButton4"))
                {
                    return 10;
                }
                if(variable.equals("playcalled"))
                {
                    System.out.println("check if play called = status "+this.getLastFunctionCall());
                    if( this.getLastFunctionCall().equals("play"))
                    return 1;
                    else
                    return 0;
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
		//setup 
                //test when any button has been 10 times pressed play sound 
		Button bt = new Button(api);
		int countN = bt.getButtonClickCounter(IButton.ButtonDirection.North);
		int countE = bt.getButtonClickCounter(IButton.ButtonDirection.East);
		int countS = bt.getButtonClickCounter(IButton.ButtonDirection.South);
		int countW = bt.getButtonClickCounter(IButton.ButtonDirection.West);
               
                // to doCall Play sound function
                ClickSoundDemo csd=new ClickSoundDemo();
               csd.PlaySound(bt);
                
                //validate if played
                if((countN%10==0&&countN>0)||(countS%10==0&&countS>0)||(countE%10==0&&countE>0)||(countW%10==0&&countW>0))
                {
                    assertEquals(1,api.readVariable("playcalled"));
                }
		
	
		
	}
}
