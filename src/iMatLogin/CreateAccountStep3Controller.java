package iMatLogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by JOHAN on 2017-03-02.
 */
public class CreateAccountStep3Controller implements Initializable {

    private LoginController loginController;

    @FXML private Button createAccountButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void inject(LoginController loginController) {
        this.loginController = loginController;
    }

    @FXML
    protected void createAccountActionPerformed(ActionEvent event) {

    }

    @FXML
    protected void goBackwardActionPerformed(ActionEvent event) {
        loginController.getCreateAccountStep2().toFront();
    }
}
