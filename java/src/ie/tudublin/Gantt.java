package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	int width = 800;
	int height = 600;
	float mouseLock = 0;
	float border = width * 0.10f;

	public ArrayList<Task>tasks = new ArrayList<Task>();	
	//tasks array for storing task names, start number and end number
	

	public void settings()
	{
		size(width, height);		//size of the screen
		
	}

	public void loadTasks()
	{
		Table t = loadTable("tasks.csv", "header");
		for(TableRow row:t.rows())
		{
			Task x = new Task(row);				//add the tasks to the task array
			tasks.add(x);
		}
		
	}

	public void printTasks()
	{
		for(Task t:tasks)
		{
			println(t);						//print the tasks to 
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
		float taskStart; 
		float taskEnd;
		for(Task t: tasks)
		{
			
			taskStart = map(t.getStart(), 1, 30, border + 20, width - border);
			taskEnd = map(t.getEnd(), 1, 30, border + 20, width - border);

			float taskWidth = taskEnd - taskStart;

		
			float y = map(i,0, tasks.size(), 100, height - 100);	//grand

			noStroke();
			colorMode(HSB);
			fill(i*t.getEnd(), 255,255);	//colour the rectangles
			
			rect(taskStart,y - 10, taskWidth, 30);
		
			fill(255);
			textAlign(CENTER, CENTER);
			text(t.getTask(), 50, y);
			i++;
		}
		
		
	}
	
	
	public void mousePressed()
	{		
	
		mouseLock = 0;	//prevents L or R being printed more than once at a time
		
		for( int i = 0; i<tasks.size();i++)
		{
			Task t = tasks.get(i);
			float l_click = map(t.getStart(), 1, 30, border+20, width - border);	
			float r_click = map(t.getEnd(), 1, 30, border + 20, width - border);	
			float y = map(i,0, tasks.size(), border+20, height - 100);	//grand

			if(mouseX > border+20 && mouseX < (width-70) && mouseLock == 0)	//check if outside of chart
			{
				//println("INSIDE GRID");
								 
				if(mouseX > l_click && mouseX < l_click + 20 && mouseY < y + 30 && mouseY > y)	//is mouse x between 20 pix of x position
				{																		
					println("L pressed");
					mouseLock = 1;
						
				}
				else if(mouseX > r_click - 20 && mouseX < r_click && mouseY < y + 30 && mouseY > y)
				{
					println("R pressed");
					mouseLock = 1;
				}

				/*
						Every odd numbered rectangle registers a left or right press
						
				*/
					
			}
			
			i++;
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
