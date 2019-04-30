package ie.tudublin;

import processing.core.*;
import processing.data.*;
import java.util.ArrayList;
import ddf.minim.AudioInput;
import ddf.minim.AudioSample;
import ddf.minim.*;
import ddf.minim.analysis.FFT;

public class UI extends PApplet
{
    Button b;
    MovingCircle mc;
    Radar r;
    SidePanel s1;
    SidePanel s2;
    IOBox iob;
    Logo l;
    Grid g;
    boolean[] keys = new boolean[1024];
    IOBox iob2;

    AudioPlayer music1;
    AudioPlayer music2;
    AudioPlayer music3;
    AudioPlayer music4;
    AudioPlayer music5;
    AudioPlayer music6;
    AudioPlayer music7;
    AudioPlayer music8;
    AudioPlayer music9;
    AudioPlayer music10;
    AudioPlayer music11;
    AudioInput ai;
    FFT fft;
    Minim minim;
    public static final int FRAME_SIZE = 1024;
    public static final int SAMPLE_RATE = 44100;
    public static final int BITS_PER_SAMPLE = 16;

    public int jukebox = 0;

    private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
    public ArrayList<Sprite> sprites = new ArrayList<Sprite>();

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
       minim = new Minim(this);
        ai = minim.getLineIn(Minim.MONO, FRAME_SIZE, SAMPLE_RATE, BITS_PER_SAMPLE);
        fft = new FFT(FRAME_SIZE, SAMPLE_RATE);
    }

    public void setup()
    {
       // Minim minim = new Minim(this);
        music1 = minim.loadFile("track1.mp3");
        music2 = minim.loadFile("track2.mp3");
        music3 = minim.loadFile("track3.mp3");
        music4 = minim.loadFile("track4.mp3");
        music5 = minim.loadFile("track5.mp3");
        music6 = minim.loadFile("track6.mp3");
        music7 = minim.loadFile("track7.mp3");
        music8 = minim.loadFile("track8.mp3");
        music9 = minim.loadFile("track9.mp3");
        music10 = minim.loadFile("track10.mp3");
        music11 = minim.loadFile("track11.mp3");

        PFont fnt = createFont("HADES.otf",40);
        textFont(fnt);

        b = new Button(this, 50, height*0.6f, 100, 50, "JUKEBOX");
        mc = new MovingCircle(this, width / 2, height / 2, 50);
        r = new Radar(this,width/2,height/2, 350);
        s1 = new SidePanel(this, width, height/2, 150, 150);
        s2 = new SidePanel(this, 0, height/2, 150, 150);
        iob = new IOBox(this, (width/2)-250, height *0.8f,500,200);
        l = new Logo(this,0, 0, width,height/5, "BENATAR 2.0");
        g = new Grid(this, 100, height * 0.25f, 200,200);
        iob2 = new IOBox(this, width-540, height*0.8f, 500,200);

        for (int i = 0; i <= 5; i++)
        sprites.add(new Planet(this));

        for (int i = 0; i <= 100; i++)
        sprites.add(new Star(this));

        loadData();
        printWeapons();
    }

    public void mousePressed() {
        float x = 50;
        float y = height*0.6f;
        float w = 100;
        float h = 50;
        if (mouseX > x && mouseX < x + w 
        && mouseY > y && mouseY < y + h)
        {
            jukebox++;
            System.out.println(jukebox);
            jukeboxPlay();
        }
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

    public void jukeboxPlay()
    {
        if (jukebox == 1)
        {
            music1.play();
        }

        if (jukebox == 2){
          music1.pause();
          music2.play();  
        }

        if (jukebox ==3){
            music2.pause();
            music3.play();  
        }

          if (jukebox ==4){
            music3.pause();
            music4.play();  
        }

          if (jukebox ==5){
            music4.pause();
            music5.play();  
        }

        if (jukebox ==6){
            music5.pause();
            music6.play();  
        }

        if (jukebox ==7){
            music6.pause();
            music7.play();  
        }

        if (jukebox == 8)
        {
            music7.pause();
            music8.play();
        }

        if (jukebox == 9)
        {
            music8.pause();
            music9.play();
        }

        if (jukebox == 10)
        {
            music9.pause();
            music10.play();
        }

        if (jukebox == 11)
        {
            music10.pause();
            music11.play();
        }
        
        if (jukebox > 11)
        {
            music11.pause();
            jukebox =0;
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
        iob2.render();


        drawWeapons();

        l.render();
        g.render();

        ellipse(mouseX,mouseY, 40,40);
        ellipse(mouseX, mouseY,1,1);
        noCursor();

// START AUDIOVIS HERE
        stroke(0,255,0);
        float audioHeight = height*0.9f;
        float gap = 20;
        float audioWidth = ai.bufferSize()/2;
        float middle = audioHeight; 

        rect(gap, height *0.8f,audioWidth,200);
        textSize(30);
        text("Primary Radio", audioWidth/2, height * 0.78f);

        for(int i = 0 ; i < audioWidth ; i ++)
        {
            stroke(map(i, 0, ai.bufferSize(), 0, 255), 255, 255); 
            line(i+gap, middle, i+gap, middle + ai.left.get(i) *middle/2);
        }

        fft.forward(ai.left);
//END AUDIOVIS HERE

        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }
    }
}

