package iMat;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import se.chalmers.ait.dat215.project.IMatDataHandler;


public class Main extends Application {

    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../iMatLogin/fxmls/Login.fxml"));
        primaryStage.setTitle("iMat");
        primaryStage.setScene(new Scene(root, 362, 400));
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(362);
        primaryStage.show();

        primaryStage.setOnCloseRequest(event -> dataHandler.shutDown());
//        dataHandler.resetFirstRun();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
