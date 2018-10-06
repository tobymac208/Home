import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        String name = "Home";
        String version = "v1.0";
        String windowTitle = name + " " + version;

        Parent root = FXMLLoader.load(getClass().getResource("Windows/Login/main.fxml"));
        // set the title of this window
        primaryStage.setTitle(windowTitle);
        // load the file from our root object
        primaryStage.setScene(new Scene(root, 400, 400));
        // display the window
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
