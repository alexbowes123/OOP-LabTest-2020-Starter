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
		loadTasks();
		printTasks();
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
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	
	public void setup() 
	{
	}
	
	public void draw()
	{			
		background(0);
	}
}
