package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	public ArrayList<Task>tasks = new ArrayList<Task>();

	
	public void settings()
	{
		size(800, 600);
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
		int y = 60;
		int x = 30;
		for(int i = 0; i< tasks.size();i++)
		{
			Task t = tasks.get(i);
			textAlign(LEFT, CENTER);
			fill(255);
			text(t.getTask(), x, y);
			y+=40;
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
