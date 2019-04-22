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
    public ArrayList<Sprite> sprites = new ArrayList<Sprite>();


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

    public void setup()
    {
        b = new Button(this, 50, 50, 100, 50, "I am a button");
        mc = new MovingCircle(this, width / 2, height / 2, 50);
        r = new Radar(this,width/2,height/2, 350);
        s1 = new SidePanel(this, width, height/2, width/3, height);
        s2 = new SidePanel(this, 0, height/2, (width/3), height);
        iob = new IOBox(this, (width/2)-250, height *0.8f,500,200);

        for (int i = 0; i <= 5; i++)
        sprites.add(new Planet(this));

        loadData();
        printWeapons();

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

    public void drawWeapons()
    {
        int i = 0;
        textSize(20);
        textAlign(LEFT,CENTER);
        for (Weapon w : weapons)
        {
            text("Weapon Name:    "+ w.getWeaponName(),(width/2)-100,height *0.81f);
            text("Mag Size:    " +w.getMagSize(),(width/2)-100, height *0.84f);
            text("Damage:    " +w.getDamage(),(width/2)-100, height *0.87f);
            text("Description:    " +w.getDesc(),(width/2)-100, height *0.9f);
            
            i++;
            if (i == 1) break;
            
        }
    }


    public float timeDelta;
    private float last;

    public void draw()
    {
        background(0);

        float now = millis();
        timeDelta = (now - last) / 1000.0f;
        last = now;
        
        fill(0);
        for(int i= sprites.size() - 1; i >= 0; i--)
        {
            Sprite s = sprites.get(i);
            s.render();
            s.update();

        }

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

        drawWeapons();

        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }
    }
}

