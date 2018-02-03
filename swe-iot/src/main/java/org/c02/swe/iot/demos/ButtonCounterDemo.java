/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.c02.swe.iot.demos;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;

/**
 *
 * @author joshke
 */
public class ButtonCounterDemo {
     static IParticleApi api = new ParticleApi(new ButtonConnection());

    public static void main(String[] args) {
        Button bt = new Button(api);
        int count=bt.getButtonClickCounter(IButton.ButtonDirection.North);
        System.out.println(count);
    }
}
