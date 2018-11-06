package POJO;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList(){
        taskList = new ArrayList<>();
    }

    public ArrayList<Task> getTaskList(){
        return taskList;
    }

    public boolean add(String name, String description){
        for(Task task : taskList){ // check to make sure there aren't any copies.
            if(name.equals(task.getName()) && description.equals(task.getDescription())){
                return false;
            }
        }

        // return the result of adding the object to the list
        taskList.add(new Task(name, description));
        return true;
    }
}
