package ie.tudublin;

import processing.data.TableRow;

public class Task {
    private String Task;        //private fields
    private int Start;
    private int End;

    public Task(String task, int start, int end) {
        Task = task;                       //constructors
        Start = start;
        End = end;
    }


  

    @Override
    public String toString() {
        return "Task [End=" + End + ", Start=" + Start + ", Task=" + Task + "]";    //toString method
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        Task = task;
    }
                                            //getters and setters
    public int getStart() {
        return Start;
    }

    public void setStart(int start) {
        Start = start;
    }

    public int getEnd() {
        return End;
    }

    public void setEnd(int end) {
        End = end;
    }

}