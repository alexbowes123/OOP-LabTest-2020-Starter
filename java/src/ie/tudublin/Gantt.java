package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	int width = 800;
	int height = 600;

	float border = width * 0.10f;

	public ArrayList<Task>tasks = new ArrayList<Task>();

	
	public void settings()
	{
		size(width, height);
		
	}

	public void loadTasks()
	{
		Table t = loadTable("tasks.csv", "header");
		for(TableRow row:t.rows())
		{
			Task x = new Task(row);
			tasks.add(x);
		}
		
	}

	public void printTasks()
	{
		for(Task t:tasks)
		{
			println(t);		
		}
		
	}
	
	public void drawGrid()
    {
       

        stroke(0, 0, 255);
        textAlign(CENTER, CENTER);
        for(int i = 1 ; i <= 30 ; i ++)
        {
            float x = map(i, 1, 30, border + 20, width - border);
            line(x, 35, x, height - border);
            fill(255);
            text(i, x, 20);
        }
    }

	public void displayTasks()
	{
		drawGrid();
		int i = 0;
		float x; 
		float x2;
		for(Task t: tasks)
		{

			x = map(t.getStart(), 1, 30, border + 20, width - border);
			x2 = map(t.getEnd(), 1, 30, border + 20, width - border);
			float taskWidth = x2 - x;

		
			float y = map(i,0, tasks.size(), 100, height - 100);	//grand


			noStroke();
			colorMode(HSB);
			fill(i*t.getEnd(), 255,255);

			
			rect(x,y, taskWidth, 30);
		
			fill(255);
			textAlign(CENTER, CENTER);
			text(t.getTask(), 50, y);
			i++;
		}
		
	}
	
	
	public void mousePressed()
	{		
		if(mouseX > 90 && mouseX < (width-50))
		{
			for(int i = 0; i< tasks.size();i++)
			{
				pushMatrix();
				Task t = tasks.get(i);
				float x = PApplet.map(i,0,tasks.size(),89,width-100);
				float y = PApplet.map(i,0,tasks.size(),100,height-100);
				popMatrix();
				if(dist(mouseX, mouseY, x, y) >20 )
				{
					println("inside grid");
					
				}
				/*
					if mouseX and mouseY are within getStart() + 20 or getEnd() - 20
					select the 

					if getStart() - mouseX  > 20 
					{
						modify getStart()
					}
					if(getEnd() - mouseX
				*/
				
			}
		}
		
	}
	
	public void setup() 
	{
		loadTasks();
		printTasks();
		
	}
	
	public void draw()
	{			
		background(0);
		displayTasks();
	}
}
