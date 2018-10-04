package Windows.Login;

import POJO.LoginAccount;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;

public class mainWindowController {
    private static LoginAccount userAccount = new LoginAccount("coolman", "Mike Hanson", "password");
    private static String passwordHint = "It's literally \"" + userAccount.getPassword() + "\"";
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginSuccess;
    @FXML
    private Label hint;

    public void initialize(){
        // disable the login button by default
        loginButton.setDisable(true);
    }

    public void handleKeyRelease_Login(){
        String username = usernameField.getText(), password = passwordField.getText();
        final int MIN_LENGTH = 5;
        boolean isDisabled = (username.trim().isEmpty() || username.isEmpty() || username.trim().length() < MIN_LENGTH) ||
                (password.trim().isEmpty() || password.isEmpty() || password.trim().length() < MIN_LENGTH); // if any of the fields are empty, or their trim is empty, set the boolean value to true
        loginButton.setDisable(isDisabled);
    }

    public void passwordHint(){
        if(hint.getText().isEmpty()) {
            hint.setText("Hint: " + passwordHint);
        }else{
            hint.setText("");
        }
    }

    /** Allows a user to login */
    public void login(){
        if(usernameField.getText().toLowerCase().equals(userAccount.getUsername()) && passwordField.getText().toLowerCase().equals(userAccount.getPassword())){
            loginSuccess.setTextFill(Paint.valueOf("green"));
            loginSuccess.setText("Login successful.");

            // Clear the fields
            usernameField.setText("");
            passwordField.setText("");
            // disable the button
            loginButton.setDisable(true);

            Parent root;
            try{
                root = FXMLLoader.load(getClass().getClassLoader().getResource("Windows/AccountInfo/AccountInfo.fxml"));
                Stage stage = new Stage();
                stage.setTitle(userAccount.getFirstName() + " " + userAccount.getLastName() +  "'s Account");
                stage.setScene(new Scene(root, 400, 400));
                stage.show();
            }catch (IOException e){
                System.out.println("Exception thrown! File doesn't exist.");
            }
        }else {
            loginSuccess.setTextFill(Paint.valueOf("red"));
            loginSuccess.setText("Login failed.");
        }
    }
}
