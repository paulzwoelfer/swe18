package org.c02.swe.iot.demos;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;

/**
 * @author pzwoelfe
 */
public class AccelerationDemo {

    static IParticleApi api = new ParticleApi(new ButtonConnection());

    public static void main(String[] args) {
        Button bt = new Button(api);
        bt.getDirectionValue(IButton.axes.x);
    }
}
