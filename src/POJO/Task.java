package POJO;

import java.util.GregorianCalendar;

public class Task {
    private String name;
    private String description;
    private GregorianCalendar dateCreated;

    public Task(String name, String description, GregorianCalendar dateCreated){
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
    }

    // Getters and setters
    // name
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    // description
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    // calendar
    public GregorianCalendar getDateCreated() {return dateCreated;}
    public void setDateCreated(GregorianCalendar dateCreated) {this.dateCreated = dateCreated;}
    // ------------- End of getters and setters -------------

    /** Return a string representation of this object */
    @Override
    public String toString(){
        return "Name: " + name + ", description:" + description + ", date created: " +
                dateCreated.get(GregorianCalendar.MONTH) + "/" + dateCreated.get(GregorianCalendar.DAY_OF_MONTH) + "/"
                + dateCreated.get(GregorianCalendar.YEAR);
    }
}
