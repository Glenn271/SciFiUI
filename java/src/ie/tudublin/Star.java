package ie.tudublin;

import processing.core.*;

public class Star extends Sprite
{

    public Star(UI ui)
    {
        super(ui, ui.random((ui.width/2)-10, (ui.width/2)+10)
        ,ui.random((ui.height/2)-10, (ui.height/2)+10)
        , 0, 5);
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


        /*forward.x = 1;
        forward.y = ui.random(-1, 1);
        */

        forward.normalize();
      
    }
    @Override
    public void update() {
        //pos =+ forward * speed;
        pos.add(PVector.mult(forward, speed));
        rotation += 0.01f;

        if (pos.x < 0)
        {
            pos.x = ui.width/2 - 10;
            pos.y = ui.height/2;
        }
        if (pos.x > ui.width)
        {
            pos.x = ui.width/2 + 10;
            pos.y = ui.height/2;
        }
        if (pos.y < 0)
        {
            pos.x = ui.width/2;
            pos.y = ui.height/2 -10;

        }
        if (pos.y > ui.height)
        {
            pos.x = ui.width/2;
            pos.y = ui.height/2 +10;
        }
    }

    int size = 5;

    @Override
    public void render() {
        ui.noStroke();
        ui.pushMatrix();
        ui.translate(pos.x, pos.y);
        ui.rotate(rotation);
        ui.fill(255);
        ui.ellipse(-size / 2, -size / 2, size, size);
        ui.popMatrix();
    }
}