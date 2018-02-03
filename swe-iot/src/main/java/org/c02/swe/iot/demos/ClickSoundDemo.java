package org.c02.swe.iot.demos;

import java.util.concurrent.TimeUnit;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;



public class ClickSoundDemo {
	
	static IParticleApi api = new ParticleApi(new ButtonConnection());

	public static boolean CountButtonPressed (Button bt) {
		int countN = bt.getButtonClickCounter(IButton.ButtonDirection.North);
		int countS = bt.getButtonClickCounter(IButton.ButtonDirection.South);
		int countW = bt.getButtonClickCounter(IButton.ButtonDirection.West);
		int countE = bt.getButtonClickCounter(IButton.ButtonDirection.East);
		if((countN%10==0 && countN > 0) || 
				(countS%10==0&& countS > 0) || 
				(countE%10==0&& countE > 0)  || 
				(countW%10==0&& countW > 0) ) 
		{
			return true;
		}
		return false;
	}
	
	public  void PlaySound (Button bt) {
		try {
			
			for(int i = 0; i<=10;	i++ ) {
			
			
			System.out.println("North"+bt.getButtonClickCounter(IButton.ButtonDirection.North));
	        System.out.println("South"+bt.getButtonClickCounter(IButton.ButtonDirection.South));
	        System.out.println("West"+bt.getButtonClickCounter(IButton.ButtonDirection.West));
	        System.out.println("East"+bt.getButtonClickCounter(IButton.ButtonDirection.East));
	        

	        if(CountButtonPressed(bt) == true) {
	        	bt.playSound();
	        }
	        if(i<10) {
	        	System.out.println("------GO TO SLEEP FOR 1 SECOND------");
				TimeUnit.SECONDS.sleep(1);
	        }
	        else {
	        	System.out.println("------DONE------");
	        }
				
			}
			bt.resetButtonClickCounters();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        
	}
	
	public static void main(String[] args) {
		Button bt = new Button(api);
		ClickSoundDemo cs = new ClickSoundDemo();
		cs.PlaySound(bt);
		
    }
}


