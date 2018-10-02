import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login/main.fxml"));
        // set the title of this window
        primaryStage.setTitle("Home");
        // load the file from our root object
        primaryStage.setScene(new Scene(root, 400, 400));
        // display the window
        primaryStage.show();
        // hello
    }

    public static void main(String[] args){
        launch(args);
    }
}
