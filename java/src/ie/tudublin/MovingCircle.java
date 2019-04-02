package ie.tudublin;

import processing.core.PApplet;

public class MovingCircle
{
    private float x;
    private float dx = 5;
    private float dy = 5;
    private float y;
    private float diameter;
    private float radius;
    private int hit = 1;
    UI ui;

    public MovingCircle(UI ui, float x, float y, float diameter)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        radius = diameter / 2;
    }
    
    public void render()
    {
        if (hit == -1)
        ui.stroke(ui.random(0,255),ui.random(0,255),ui.random(0,255));
        else
        ui.stroke(255);
        ui.noFill();
        ui.ellipse(x, y, diameter, diameter);
        ui.fill(255);
        // Static field
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.text("I am a moving circle", x, y);

    }

    public void update()
    {
        x += dx;
        y += dy;
        if ((x > ui.width - radius) || (x < radius))
        {
            dx *= -1;
            hit *= -1;
        }

        if ((y > ui.height - radius) || (y < radius))
        {
            dy *= -1;
            hit *= -1;
        }
    }
}
