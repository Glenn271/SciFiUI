package ie.tudublin;

import processing.core.*;
import processing.core.PVector;

public class Radar {
    private float x;
    private float y;
    private float diameter;
    private float radius;
    private float theta;
    private float x2;
    private float y2;
    PApplet ui;

    public Radar(PApplet ui, float x, float y, float diameter)
    {
        this.ui = ui;
        this.theta = 0;
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        radius = diameter / 2;
        this.x2 = 0;
        this.y2 = radius;
    }

    public void render()
    {
        x = ui.width/2;
        y = ui.height/2;
        x2 = (float) (Math.sin(theta)* (radius)) + x;
        y2 = (float) (-Math.cos(theta)* (radius)) + y;
        ui.stroke(255);
        ui.noFill();
        ui.ellipse(x,y, diameter, diameter);
        ui.fill(255);
        ui.line(x,y,x2,y2);


    }

    public void update()
    {
        theta += 0.01;
    }
}