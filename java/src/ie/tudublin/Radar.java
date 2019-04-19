package ie.tudublin;

import processing.core.*;
import java.util.Arrays;

public class Radar {
    private float x;
    private float y;
    float diameter;
    private float radius;
    private float theta;
    private float x2;
    private float y2;
    PApplet ui;
    public float gap;

    public Radar(PApplet ui, float x, float y, float diameter) {
        this.ui = ui;
        this.theta = 0;
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        radius = diameter / 2;
        this.x2 = 0;
        this.y2 = radius;
        this.gap = ui.height * 0.8f;
    }

    public void render() {
        x2 = (float) (Math.sin(theta) * (radius)) + x;
        y2 = (float) (-Math.cos(theta) * (radius)) + y;
        ui.stroke(0, 255, 0);
        ui.noFill();

        float circleGap = diameter / 3;
        for (int i = 0; i <= 2; i++) {
            ui.ellipse(x, y, diameter - (circleGap * i), diameter - (circleGap * i));
        }
        ui.fill(0,255,0);
        PFont tnr = ui.createFont("Times New Roman", 32);
        ui.textFont(tnr);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.textSize(50);
        ui.text("SCANNING FOR TARGET", x, y- radius - 100);
        ui.line(x,y,x2,y2);
        ui.noFill();

    }

    public void update()
    {
        theta += 0.05;

        float disX = x - ui.mouseX;
        float disY = y - ui.mouseY;

    }

}