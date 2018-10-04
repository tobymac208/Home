package Windows.AccountInfo;

import POJO.LoginAccount;
import POJO.TaskList;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class AccountInfoController {
    private static LoginAccount userAccount = new LoginAccount("coolman", "Mike Hanson", "password");
    private static TaskList tasks = new TaskList();

    @FXML
    private TextArea textArea;

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
}
