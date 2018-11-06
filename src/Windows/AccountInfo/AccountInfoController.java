package Windows.AccountInfo;

import POJO.LoginAccount;
import POJO.Task;
import POJO.TaskList;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.GregorianCalendar;

public class AccountInfoController {
    private static LoginAccount userAccount = new LoginAccount("coolman", "Mike Hanson", "password");
    private static TaskList tasks = new TaskList();

    @FXML
    private TextArea textArea;
    @FXML
    private String descriptionOfTask;
    @FXML
    private String nameOfTask;

    // Initialize values
    public void initialize(){
        tasks.add("Get homework done", "Finish up homework");
        tasks.add("Get homework done", "Finish up homework");
        tasks.add("Get homework done", "Finish up homework");
        tasks.add("Get homework done", "Finish up homework");
        tasks.add("Get homework done", "Finish up homework");
        tasks.add("Get homework done", "Finish up homework");
        tasks.add("Get homework done", "Finish up homework");
        tasks.add("Get homework done", "Finish up homework");
    }

    /** Writes account info the the text area */
    public void viewAccountInfo(){
        textArea.setText("Username: " + userAccount.getUsername() +
                        "\n\nPassword: " + userAccount.getPassword() +
                        "\n\nFirst name: " + userAccount.getFirstName() +
                        "\n\nLast name: " + userAccount.getLastName());
    }

    /** Writes random data to the text area */
    public void viewRandom(){
        String writeString = "";
        final int TIMES_RUN = 10;
        for(int i = 0; i < TIMES_RUN; i++){
            writeString += "Random String!\n";
        }

        textArea.setText(writeString);
    }

    /** Writes out the tasks */
    public void viewTasks(){
        String writeToString = "";
        if(tasks.getTaskList().get(0) == null)
            textArea.setText("Nothing to display.");
        int count = 0;
        // iterate through every task
        for(Task task : tasks.getTaskList()){
            count++;
            writeToString += count + "\n\tName: " + task.getName() + "\n\tDescription: " + task.getDescription() + "\n";
        }

        textArea.setText(writeToString);
    }

    /** Adds a new item to the list of things to-do */
    public void addNewTodoItem(){
        tasks.add(nameOfTask, descriptionOfTask);
    }
}
