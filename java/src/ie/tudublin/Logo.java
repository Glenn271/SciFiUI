package ie.tudublin;

import processing.core.*;

public class Logo
{
    private float x;
    private float y;
    PApplet ui;
    private float size;
    public Logo(PApplet ui, float x, float y, float size)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.size = size;
    }

  /*  void setup()
    {
        rectMode(CENTER);
    }
*/
    
    float angle;
    float jitter;
    float low = (float) -0.1;
    float high = (float) 0.1;

    public void render() {
        ui.fill(255,0,0);
        ui.rect(x, y, size,size);   
      }

    public void update()
    {
        ui.rotate(PApplet.radians(60));
    }
      


}