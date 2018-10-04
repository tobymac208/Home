package POJO;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList(){
        taskList = new ArrayList<>();
    }

    public ArrayList<Task> getTaskList(){return taskList;}

    public boolean add(String name, String description, GregorianCalendar calendar){
        // return the result of adding the object to the list
        return taskList.add(new Task(name, description, calendar));
    }
}
