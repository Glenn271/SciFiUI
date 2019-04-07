package ie.tudublin;

import processing.core.*;
import processing.data.*;
import java.util.Arrays;

public class SidePanel {
    private float x;
    private float y;
    float diameter;
    PApplet ui;

    public SidePanel(PApplet ui, float x, float y, float diameter) {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.diameter = diameter;
    }

    public void render() {
        ui.stroke(0, 255, 0);
        ui.fill(0,255,0);  
        ui.ellipse(x, y, x/3, diameter);
    }


}