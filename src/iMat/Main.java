package iMat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../iMatLogin/fxmls/Login.fxml"));
        primaryStage.setTitle("iMat");
        primaryStage.setScene(new Scene(root, 1024, 768));
        primaryStage.setMinHeight(768);
        primaryStage.setMinWidth(1024);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

    }
}
