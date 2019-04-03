package ie.tudublin;

import processing.core.*;
import processing.data.*;
import java.util.ArrayList;

public class UI extends PApplet
{
    ArrayList<Button> buttons = new ArrayList<Button>();
    Button b;
    MovingCircle mc;
    Radar r;


    boolean[] keys = new boolean[1024];

    public void keyPressed()
    {
        keys[keyCode] = true;
    }
    
    public void keyReleased()
    {
        keys[keyCode] = true;
    }

    public boolean checkKey(int c)
    {
        return keys[c] || keys [Character.toUpperCase(c)];
    }
    

    public void settings()
    {
        //size(800, 800);
        // Use fullscreen instead of size to make your interface fullscreen
        fullScreen(); 
    }

    void loadButtons()
    {
        Table table = loadTable("cafe.csv", "header");
        for (TableRow tr:table.rows())
        {
            Button b = new Button(tr);
            buttons.add(b);
        }
    }

    public void setup()
    {
       // b = new Button(this, 50, 50, 100, 50, "I am a button");
        mc = new MovingCircle(this, width / 2, height / 2, 50);
        r = new Radar(this,width/2,width/2,100);
    }

    float border = 20;
    float buttonWidth = 200;
    float buttonHeight = 50;
    float gap = 20;

    void drawProductButtons()
    {
        
        for(int i = 0 ; i <buttons.size() ; i ++)
        {
            Button b = buttons.get(i);
            float y = border + (i * (buttonHeight + gap));
            float x = border;
            noFill();
            stroke(0);
            rect(x, y, buttonWidth, buttonHeight);
            textAlign(CENTER, CENTER);
            fill(0);
            text("I am a button",  x + buttonWidth * 0.5f, y + buttonHeight * 0.5f);
        }
    }

    public void draw()
    {
        background(0);


        b.render();

        mc.update();
        mc.render();
    
        r.render();
        r.update();

        drawProductButtons();

 

        

        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }
    }
}

