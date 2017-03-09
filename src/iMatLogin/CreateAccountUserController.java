package iMatLogin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Johan on 2017-03-09.
 */
public class CreateAccountUserController implements Initializable {

    private LoginController loginController;

    @FXML private TextField userNameField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userNameField.textProperty().addListener((observable, oldValue, newValue) -> {
            loginController.getNewUser().setUserName(newValue);
        });

        passwordField.textProperty().addListener(((observable, oldValue, newValue) -> {
            loginController.getNewUser().setPassword(newValue);
        }));
    }

    public void inject(LoginController loginController) {
        this.loginController = loginController;
    }
}
