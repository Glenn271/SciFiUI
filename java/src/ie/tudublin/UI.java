package ie.tudublin;

import processing.core.*;
import processing.data.*;
import java.util.ArrayList;
public class UI extends PApplet
{
    Button b;
    MovingCircle mc;
    Radar r;
    SidePanel s1;
    SidePanel s2;
    IOBox iob;

    private ArrayList<Weapon> weapons = new ArrayList<Weapon>();


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
        size(800, 800);
        // Use fullscreen instead of size to make your interface fullscreen
        //fullScreen(); 
    }

    public void setup()
    {
        b = new Button(this, 50, 50, 100, 50, "I am a button");
        mc = new MovingCircle(this, width / 2, height / 2, 50);
        r = new Radar(this,width/2,height/2, 400);
        s1 = new SidePanel(this, width, height/2, width/3, height);
        s2 = new SidePanel(this, 0, height/2, (width/3), height);
        iob = new IOBox(this, (width/2)-200, height *0.8f,400,100);
    }

 
    public void loadData() {
        Table table = loadTable("weapons.csv", "header");

        for (TableRow row : table.rows()) {
            Weapon w = new Weapon(row);
            weapons.add(w);
        }
    }

    public void printWeapons() {
        for (Weapon w : weapons) {
            System.out.println(w);
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

        s1.render();
        s2.render();

        s1.update();
        s2.update();

        iob.render();

 /*       s1.update();
        s2.update();
*/
        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }
    }
}

