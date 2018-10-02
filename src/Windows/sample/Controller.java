package Windows.sample;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField filename;
    @FXML
    private TextField data;

    // ID's for login section
    @FXML
    private TextField username_entry;
    @FXML
    private PasswordField password_entry;
    @FXML
    private Button login_button;

    public void initialize(){
        login_button.setDisable(true);
    }

    public void handleKeyReleased_Login(){
        String username = username_entry.getText(), password = password_entry.getText();
        boolean isDisabled = (username.trim().isEmpty() || username.isEmpty()) || (password.trim().isEmpty() || password.isEmpty()); // if any of the fields are empty, or their trim is empty, set the boolean value to true
        login_button.setDisable(isDisabled); // either enables the button, or disables the button -- dependant on what isDisabled is equal to
    }

    public void login(){}

    /*ArrayList<String> files = new ArrayList<>(); // Array list meant to track the files created in the root of this project
    Scanner scanner = new Scanner(System.in);

    public void createFile(String filename, String data)
    {
        String convertToTxt = filename+".txt";
        File file = new File(convertToTxt);
        try(PrintWriter pw = new PrintWriter(file)){
            pw.println(data);

            files.add(filename);

            System.out.println("File has been successfully created an written to.");
        }catch(FileNotFoundException e){
            System.out.println("There has been an error.");
        }
    }

    public void SubmitInfo(){
        String file, dataVal;

        // Get the text stored in our two text fields
        file = filename.getText();
        dataVal = data.getText();

        if(file.equals("") || dataVal.equals("")){
            System.out.println("You must enter data into both fields!");
        }
        else{
            createFile(file, dataVal);
        }
    }

    public void deleteFile(String filename){
        String convertToTxt = filename+".txt", input;
        File file = new File(convertToTxt);
        if(file.exists()){
            System.out.println("The file was found.");
            System.out.println("Are you sure you want to delete it?");
            input = scanner.nextLine();
        }
    } */

}
