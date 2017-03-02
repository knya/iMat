package iMatLogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by JOHAN on 2017-03-02.
 */
public class LoginController implements Initializable {

    @FXML private AnchorPane loginScenePane;
    @FXML private StackPane createAccountPane;

    @FXML private CreateAccountStep1Controller createAccountStep1Controller;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createAccountStep1Controller.inject(this);
    }

    @FXML
    protected void changeSceneContent(ActionEvent event) throws IOException {
        Stage stage = (Stage) loginScenePane.getScene().getWindow();

        Parent mainScene = FXMLLoader.load(getClass().getResource("/iMat/fxmls/Main.fxml"));
        stage.setScene(new Scene(mainScene));
        stage.setTitle("iMat");
    }

    @FXML protected void createButtonActionPerformed(ActionEvent event) {
        createAccountPane.setVisible(true);
    }
}
