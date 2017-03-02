package iMatLogin;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by JOHAN on 2017-03-02.
 */
public class CreateAccountStep2Controller implements Initializable {

    private LoginController loginController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void inject(LoginController loginController) {
        this.loginController = loginController;
    }
}
