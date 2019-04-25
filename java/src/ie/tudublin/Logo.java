package ie.tudublin;

import processing.core.*;

public class Logo
{
    private float x;
    private float y;
    PApplet ui;
    private float size;
    private float rectWidth;
    private float rectHeight;
    private String txt;
    public Logo(PApplet ui, float x, float y, float rectWidth, float rectHeight, String txt)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.rectWidth = rectWidth;
        this.rectHeight = rectHeight;
        this.txt = txt;
    }

    public void render() {
        ui.noFill();
        ui.stroke(0,255,0);
        ui.rect(x,y,rectWidth,rectHeight);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.textSize(100);
        ui.text(txt, (ui.width/2), rectHeight * 0.33f);

      }
      


}