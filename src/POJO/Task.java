package POJO;

import java.util.GregorianCalendar;

public class Task {
    private String name;
    private String description;

    public Task(String name, String description){
        this.name = name;
        this.description = description;
    }

    // Getters and setters
    // name
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    // description
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

//    public String getMonthDayYear(){
//        return dateCreated.get(GregorianCalendar.MONTH) + "/" + dateCreated.get(GregorianCalendar.DAY_OF_MONTH) + "/"
//            + dateCreated.get(GregorianCalendar.YEAR);}
//    // ------------- End of getters and setters -------------

    /** Return a string representation of this object */
    @Override
    public String toString(){
        return "Name: " + name + ", description:" + description;
    }
}
