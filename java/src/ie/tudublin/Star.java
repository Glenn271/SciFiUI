package ie.tudublin;

import processing.core.*;

public class Star extends Sprite
{
    public int mph = 50;
    public int pressed = 0;

    public Star(UI ui)
    {
        
        super(ui, ui.random((ui.width/2)-1, (ui.width/2)+1)
        ,ui.random((ui.height/2)-1, (ui.height/2)+1)
        , 0, 5);

        System.out.println(pressed);

        if (pos.x < ui.width/2)
        {
            forward.x = -1;
            forward.y = ui.random(-1,1);
        }

        if (pos.x > ui.width/2)
        {
            forward.x = 1;
            forward.y = ui.random(-1,1);
        }

        if (pos.x == ui.width/2)
        {
            forward.x = 0;
            forward.y = ui.random((float)-1,(float)1);
        }

        forward.normalize();


      
    }

    @Override
    public void update() {
        //pos =+ forward * speed;
        pos.add(PVector.mult(forward, speed));
        rotation += 0.01f;
        
        if (ui.keyPressed)
        {
            if (ui.key == 's' || ui.key == 'S')
            {
                this.speed = 10;
                mph = 100;
                System.out.println("Speed = "+ this.speed);
            }

            else{
                this.speed = 5;
                mph = 50;
             }
        }


        // float disX = 0 - ui.mouseX;
        // float disY = ui.height/2 - ui.mouseY;
        // if(PApplet.sqrt((disX * disX) + (disY * disY)) < 150) {
        //   this.speed = 10;
        // } 
    
        // else {
        //   this.speed = 5;
        // }



         if (pos.x < 0)
         {
             pos.x = ui.width/2 - 1;
             pos.y = ui.height/2;
         }

         if (pos.x > ui.width)
         {
             pos.x = ui.width/2 + 1;
             pos.y = ui.height/2;
         }

        if (pos.y < 0)
        {
            pos.x = ui.width/2;
            pos.y = ui.height/2 -1;

        }
        if (pos.y > ui.height)
        {
            pos.x = ui.width/2;
            pos.y = ui.height/2 +1;
        }
    } 

    public void drawText()
    {
       ui.stroke(0,255,0);
       ui.textSize(30);
       ui.text("Speedometer", ui.width-300, ui.height * 0.78f);
       ui.textSize(50);
       ui.text(mph + " MPH", ui.width-450, ui.height*0.85f);
    }

    int size = 1;

    

    @Override
    public void render() {
        ui.noStroke();
        ui.pushMatrix();
        ui.translate(pos.x, pos.y);
        ui.rotate(rotation);
        ui.fill(255);
        ui.ellipse(-size / 2, -size / 2,5,5);
        ui.popMatrix();
        drawText();
    }
}