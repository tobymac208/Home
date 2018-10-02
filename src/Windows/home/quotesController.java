package Windows.home;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Created by Nik on 6/23/2017.
 */
public class quotesController {
    private ArrayList<QuoteItem> quoteList = new ArrayList<>();
    private File file = new File("quotesList.txt");

    @FXML
    private ListView quotesListView;
    @FXML
    private TextArea description;
    @FXML
    private Label dateCreated;

    @FXML
    private TextField quoteName;
    @FXML
    private TextField quoteDescription;
    @FXML
    private Button quoteButton;

    public void initialize(){
        QuoteItem i1 = new QuoteItem("Parent's Computer Build", "Budget computer build", LocalDate.of(2017, 6, 23));
        QuoteItem i2 = new QuoteItem("Dan's Site", "Updates to Dan Myhra's Site", LocalDate.of(2017, 6, 13));
        quoteList.add(i1);
        quoteList.add(i2);

        quotesListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<QuoteItem>() {
            @Override
            public void changed(ObservableValue<? extends QuoteItem> observable, QuoteItem oldValue, QuoteItem newValue) {
                if(newValue != null){
                    QuoteItem item = (QuoteItem)quotesListView.getSelectionModel().getSelectedItem();
                    description.setText(item.getDescription());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    dateCreated.setText(df.format(item.getDateCreated()));
                }
            }
        });

        quotesListView.getItems().setAll(quoteList);
        quotesListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); // allow the user to select one item at a time
        quotesListView.getSelectionModel().selectFirst(); // select the first item by default

        quoteButton.setDisable(true); // disable the button at run-time
    }

    public void createQuote(){
        String name = quoteName.getText();
        String description = quoteDescription.getText();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        String date = df.format(LocalDate.now());

        // create a new QuoteItem
        QuoteItem quoteItem = new QuoteItem(name, description, LocalDate.now());

        // add the item to the ArrayList; store it
        quoteList.add(quoteItem);
        // add item to the ListView
        quotesListView.getItems().add(quoteItem); // add the item to the ListView

        /*** write the information to the quotesList file **/
        try(PrintWriter printWriter = new PrintWriter(file)){
            printWriter.print(String.format("%s\t%\t%s", name, description, date));
            printWriter.println();
        }catch(FileNotFoundException e){System.out.println("File not found.");}
    }

    /*public void loadItems(){
        ListView<QuoteItem> temp = new ListView<>();

        try(Scanner scanner = new Scanner()){

        }catch(FileNotFoundException e){
            System.out.println("Exception: " + e);
        }
    }*/

    public void deleteQuotesFile(){
        file.delete(); // delete the file
    }

    public void onKeyReleased_QuoteCreator(){ // disable the button if the Text Fields are empty
        String one = quoteName.getText();
        String two = quoteDescription.getText();

        boolean isDisabled = (one.isEmpty() || one.trim().isEmpty()) || (two.isEmpty() || one.trim().isEmpty());

        quoteButton.setDisable(isDisabled);
    }
}
