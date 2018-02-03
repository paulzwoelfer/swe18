package org.c02.swe.iot.behaviour;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;

import java.awt.*;

/**
 * @author pzwoelfe
 */
public class GyroValueShowLed extends AbstractBehaviour  {

    public GyroValueShowLed(IButton buttonInstance) {
        super(buttonInstance);
    }

    private boolean redOnly = false;

    @Override
    public void run() {
        if (redOnly) {
            runRedOnly();
        } else {
            runAll();
        }

    }

    private void runRedOnly() {
        int i = 1;
        while (i <= 11) {
            int red = Math.abs(button.getDirectionValue(IButton.axes.x));

            button.setLed(i, red, 0, 0);
            i++;
        }
    }

    private void runAll() {
        int i = 1;
        while (i <= 11) {
            int red = Math.abs(button.getDirectionValue(IButton.axes.x));
            int green = Math.abs(button.getDirectionValue(IButton.axes.y));
            int blue = Math.abs(button.getDirectionValue(IButton.axes.z));

            button.setLed(i, red, green, blue);
            i++;
        }
    }

    public static void main(String[] args) {
        IParticleApi api = new ParticleApi(new ButtonConnection());
        org.c02.swe.iot.Button bt = new Button(api);
        GyroValueShowLed casl = new GyroValueShowLed(bt);
        casl.run();
    }

}
