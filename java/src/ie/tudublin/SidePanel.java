package ie.tudublin;

import processing.core.*;
import processing.data.*;
import java.util.Arrays;

public class SidePanel extends PApplet{
    private float x;
    private float y;
    private float width;
    float diameter;
    PApplet ui;
    int col;

    public SidePanel(PApplet ui, float x, float y, float width, float diameter) {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.diameter = diameter;
        col = 1;
    }

    public void render() {
        ui.stroke(0, 255, 0);
        if (col == 1){
            ui.fill(0,255,0);  
        }
        else {
            ui.fill(255,0,0);  
        }  
        ui.ellipse(x, y, width, diameter);
    }

    public void update() {
        float disX = x - ui.mouseX;
        float disY = y - ui.mouseY;
        if(PApplet.sqrt((disX * disX) + (disY * disY)) < width) {
          col = -1;
        } 
    
        else {
          col = 1;
        }

    }
}