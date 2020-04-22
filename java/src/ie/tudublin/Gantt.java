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

	public void displayTasks()
	{

		for(int i = 0; i< tasks.size();i++)
		{
			Task t = tasks.get(i);

			
		//	float x = PApplet.map(i,0,tasks.size(),80,height-150);
			float y = PApplet.map(i,0,tasks.size(),80,height -150);
			noStroke();
			fill(255);
			textAlign(CENTER, CENTER);
			text(t.getTask(), 50, y);
			
		}


	}
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	/*public void mouseDragged()
	{
		println("Mouse dragged");
	}*/

	
	
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
