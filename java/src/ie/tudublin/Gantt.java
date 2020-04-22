package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	int width = 800;
	int height = 600;

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
        float border = width * 0.10f;

        stroke(0, 0, 255);
        textAlign(CENTER, CENTER);
        for(int i = 0 ; i <= 30 ; i ++)
        {
            float x = map(i, 1, 30, border, width - border);
            line(x+30, border, x+30, height);
            fill(255);
            text(i, x+30, 20);
        }
    }

	public void displayTasks()
	{
		drawGrid();

		for(int i = 0; i< tasks.size();i++)
		{
			Task t = tasks.get(i);

			
			float x = PApplet.map(i,0,tasks.size(),89,width-100);
			float y = PApplet.map(i,0,tasks.size(),100,height-100);
			noStroke();
			colorMode(HSB);
			fill(i*t.getEnd(), 255,255);
			rect(x, y+10, t.getStart()+t.getEnd(), 30);
			fill(255);
			textAlign(CENTER, CENTER);
			text(t.getTask(), 50, y);
			
		}

	}
	
	
	public void mousePressed()
	{
		println("Mouse pressed");	
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
