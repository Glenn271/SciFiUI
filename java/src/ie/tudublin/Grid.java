package ie.tudublin;

import processing.core.*;

public class Grid
{
    private float x;
    private float y;
    PApplet ui;
    private float gridWidth;
    private float gridHeight;

    public Grid(PApplet ui, float x, float y, float gridWidth, float gridHeight)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;

    }

    public void render()
    {
        float numLines = 11;
		float gap = ui.width /(float) numLines;
		for(int box = 0 ; box < numLines ; box ++)
		{
			ui.line(gap, gridHeight-(gap*box), gridWidth-gap, gridHeight-(gap*box));//x1,y1,x2,y2
			ui.line(gridHeight-(gap*box),gap, gridHeight-(gap*box), gridWidth-gap);
			
		}

    }
}