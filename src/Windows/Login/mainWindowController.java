package Windows.Login;

import POJO.LoginAccount;
import POJO.LoginAccountCollection;
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
    private static LoginAccountCollection users = new LoginAccountCollection();
    private static LoginAccount userLoggedIn;

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Button loginButton;
    @FXML private Label loginSuccess;
    @FXML private Label hint;

    @FXML private Button registerButton;
    @FXML private TextField register_username;
    @FXML private TextField register_firstName;
    @FXML private TextField register_lastName;
    @FXML private PasswordField register_password;
    @FXML private PasswordField register_re_entry_password;
    @FXML private Label registerSuccess;

    public void initialize(){
        // disable the login and register button by default
        loginButton.setDisable(true);
        registerButton.setDisable(true);

        LoginAccount userAccount_1 = new LoginAccount("coolman", "Mike Hanson", "password");
        LoginAccount userAccount_2 = new LoginAccount("geniadude", "Mike Hanson", "password");
        users.add(userAccount_1);
        users.add(userAccount_2);
    }

    // LOGIN methods
    /** Login button functionality */
    public void handleKeyRelease_Login(){
        String username = usernameField.getText(), password = passwordField.getText();
        final int MIN_LENGTH = 5;
        boolean isDisabled = (username.trim().isEmpty() || username.trim().length() < MIN_LENGTH) ||
                (password.trim().isEmpty() || password.trim().length() < MIN_LENGTH); // if any of the fields are empty, or their trim is empty, set the boolean value to true
        loginButton.setDisable(isDisabled);
    }
    public void passwordHint(){
        if(userLoggedIn == null){
            hint.setText("No user selected.");
        }else{
            if(hint.getText().isEmpty()) {
                hint.setText("Hint: " + userLoggedIn.getPassword());
            }else{
                hint.setText("");
            }
        }
    }
    /** Allows a user to login */
    public void login(){
        LoginAccount accountToSearchFor = new LoginAccount(usernameField.getText(), null, passwordField.getText());
        LoginAccount foundAccount = users.findAccount(accountToSearchFor);
        if(foundAccount != null){
            userLoggedIn = foundAccount;

            if(usernameField.getText().toLowerCase().equals(userLoggedIn.getUsername().toLowerCase()) && passwordField.getText().toLowerCase().equals(userLoggedIn.getPassword().toLowerCase())){
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
                    stage.setTitle(userLoggedIn.getFirstName() + " " + userLoggedIn.getLastName() +  "'s Account");
                    stage.setScene(new Scene(root, 800, 800));
                    stage.show();
                }catch (IOException e){
                    System.out.println("Exception thrown! File doesn't exist.");
                }
            }else {
                loginSuccess.setTextFill(Paint.valueOf("red"));
                loginSuccess.setText("Login failed.");
            }
        }else{
            loginSuccess.setText("Login failed.");
        }
    }

    // REGISTER methods
    /** Register button functionality */
    public void handleKeyRelease_Register(){
        String username = register_username.getText(), firstName = register_firstName.getText(),
                lastName = register_lastName.getText(), password = register_password.getText(),
                re_enter_password = register_re_entry_password.getText();
        final int MIN_LENGTH = 5;
        // check all of the values. Passwords must be equal, and names must not be empty
        boolean isDisabled = (username.trim().isEmpty() || username.isEmpty() || username.trim().length() < MIN_LENGTH)
                || (password.trim().isEmpty() || password.trim().length() < MIN_LENGTH) || (re_enter_password.trim().isEmpty()
                || re_enter_password.trim().length() < MIN_LENGTH) || !(password.equals(re_enter_password)
                || (firstName.trim().isEmpty()) || (lastName.trim().isEmpty()));
    }
    public void register(){
        // TODO: Implement
    }
}
