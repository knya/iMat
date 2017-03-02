package iMatLogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by JOHAN on 2017-03-02.
 */
public class CreateAccountStep2Controller implements Initializable {

    private LoginController loginController;

    @FXML private Button goBackwardButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void inject(LoginController loginController) {
        this.loginController = loginController;
    }

    @FXML
    protected void goBackwardActionPerformed(ActionEvent event) {
        loginController.getCreateAccountStep1().toFront();
    }

    @FXML
    protected void goForwardActionPerformed(ActionEvent event) {
        loginController.getCreateAccountStep3().toFront();
    }
}
