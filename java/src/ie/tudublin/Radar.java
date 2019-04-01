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
        this.x = (float)(ui.width-diameter);
        this.y = (float)(ui.height/6-diameter);
        this.diameter = diameter;
        radius = diameter / 2;
        this.x2 = 0;
        this.y2 = radius;
    }

    public void render()
    {
        x2 = (float) (Math.sin(theta)* (radius)) + x;
        y2 = (float) (-Math.cos(theta)* (radius)) + y;
        ui.stroke(0,255,0);
        ui.noFill();

        float circleGap = diameter/3;
        for (int i = 0; i <=2; i++)
        {
            ui.ellipse(x,y, diameter - (circleGap*i), diameter - (circleGap*i));
        }
        ui.fill(255);
        ui.line(x,y,x2,y2);
    }

    public void update()
    {
        theta += 0.05;
    }
}