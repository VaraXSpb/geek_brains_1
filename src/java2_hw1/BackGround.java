package java2_hw1;

import java.awt.*;

public class BackGround {

    MainCanvas canvas;
    byte counter = 0;
    final static byte CHANGE_SLOW=127;
    final static byte CHANGE_NORMAL=101;
    final static byte CHANGE_FAST=51;

    private Color color = new Color(
            (int) (Math.random() * 255),
            (int) (Math.random() * 255),
            (int) (Math.random() * 255)
    );

    BackGround(MainCanvas canvas) {
        this.canvas = canvas;
    }

    public void update(byte speed) {
        canvas.setBackground(color);
        counter++;
        if (counter % speed == 0) {
            color = new Color(
                    (int) (Math.random() * 255),
                    (int) (Math.random() * 255),
                    (int) (Math.random() * 255)
            );
            counter=0;
        }
    }

}
