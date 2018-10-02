package Windows.home;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Controller {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button login;

    @FXML
    private Label currentAccount;

    @FXML
    private TextField username_reg;
    @FXML
    private PasswordField password_reg;
    @FXML
    private PasswordField password_reg_verify;
    @FXML
    private Button register;

    @FXML
    private Label registerError;

    @FXML
    private Label currentDate;
    private Date date = Calendar.getInstance().getTime();
    private SimpleDateFormat df = new SimpleDateFormat("MM.dd.yyyy");
    private String stringFormatOfDate = df.format(date);

    private File file = new File("login.txt");

    public void initialize(){
        login.setDisable(true);
        register.setDisable(true);

        currentDate.setText(stringFormatOfDate);

        currentAccount.setText("Not logged in");
    }

    public void keyReleased_Login(){
        String un = username.getText();
        String pw = password.getText();
        boolean fileExists = !file.exists();

        boolean isDisabled = (un.isEmpty() || un.trim().isEmpty() || fileExists) || (pw.isEmpty() || pw.trim().isEmpty() || fileExists);

        login.setDisable(isDisabled);
    }

    public void keyReleased_Register(){
        String un = username_reg.getText();
        String pw = password_reg.getText();
        String pw_verify = password_reg_verify.getText();
        boolean fileExists = file.exists();

        boolean isDisabled = (un.isEmpty() || un.trim().isEmpty()) || (pw.isEmpty() || pw.trim().isEmpty()) || (pw_verify.isEmpty() || pw_verify.trim().isEmpty()) || fileExists;

        register.setDisable(isDisabled);
    }

    public void login(){
        if(file.exists()) {
            String[] account;
            String un;
            String pw;
            try (Scanner scanner = new Scanner(file)) {
                account = scanner.nextLine().split("\t");
                un = account[0];
                pw = account[1];

                System.out.println(un + " " + pw);

                /*f(un.equals(username) && pw.equals(password)){
                    System.out.println("Welcome back, " + un);
                    currentAccount.setText(un);
                    login.setDisable(true);
                }*/
            } catch (FileNotFoundException e) {}
        }
        else{System.out.println("There are no accounts yet.");}
    }

    public void register(){
        String un = username_reg.getText();
        String pw = password_reg.getText();
        String pw_verify = password_reg_verify.getText();

        if(pw.equals(pw_verify)){
            try(PrintWriter printer = new PrintWriter(file)){ // new PrintWriter(new FileWriter(file, true))){
                printer.print(String.format("%s\t%s", un, pw));
                printer.println();

                Paint paint = Paint.valueOf("green");
                registerError.setTextFill(paint);
                registerError.setText("Success!");

                register.setDisable(true);
            } catch(FileNotFoundException e){} catch(IOException e){}
        }
        else{
            registerError.setText("Passwords don't match!");
        }
    }

    public void deleteAllAccounts(){
        if(file.exists()){
            file.delete();
            login.setDisable(true);
            currentAccount.setText("Not");
        }
    }
}
