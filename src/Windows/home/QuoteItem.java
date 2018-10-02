package Windows.home;

import java.time.LocalDate;

/**
 * Created by Nik on 6/23/2017.
 */
public class QuoteItem {
    private String name;
    private String description;
    private LocalDate dateCreated;

    public QuoteItem(String name, String description, LocalDate dateCreated) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
    }

    public String getName() {return name;}
    public String getDescription() {return description;}
    public LocalDate getDateCreated() {return dateCreated;}

    @Override
    public String toString(){
        return name;
    }
}
