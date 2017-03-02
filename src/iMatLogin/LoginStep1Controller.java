package iMatLogin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by JOHAN on 2017-03-02.
 */
public class LoginStep1Controller implements Initializable {

    private LoginController loginController;

    @FXML private Button createAccountButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void inject(LoginController loginController) {
        this.loginController = loginController;
    }
}
