package iMatLogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Johan on 2017-03-09.
 */
public class CreateAccountUserController implements Initializable {

    private LoginController loginController;

    @FXML private TextField userNameField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private Label userNameErrorLabel;
    @FXML private Label passwordErrorLabel;

    @FXML private Button backToLoginButton;
    @FXML private Button goForwardButton;

    private String confirmPassword = "";


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clearErrorMessages();

        userNameField.textProperty().addListener((observable, oldValue, newValue) -> {
            loginController.getNewUser().setUserName(newValue);
        });

        passwordField.textProperty().addListener(((observable, oldValue, newValue) -> {
            loginController.getNewUser().setPassword(newValue);
        }));

        confirmPasswordField.textProperty().addListener(((observable, oldValue, newValue) -> {
            confirmPassword = newValue;
        }));
    }

    public void inject(LoginController loginController) {
        this.loginController = loginController;
    }

    @FXML
    private void backToLoginActionPerformed(ActionEvent event) {
        loginController.getLoginPane().toFront();
    }

    @FXML
    private void goForwardActionPerformed(ActionEvent event) {
        clearErrorMessages();

        if (checkIfOnlyNumbers(userNameField) && checkPassword()) {
            loginController.getPersonalPane().toFront();
        } else {
            setErrorLabels();
        }
    }

    private void setErrorLabels() {
        if (confirmPassword.isEmpty()) {
            passwordErrorLabel.setText("Fält ej ifyllt.");
        }

        if (userNameField.getText().isEmpty()) {
            userNameErrorLabel.setText("Fält ej ifyllt.");
        }

        if (!checkIfOnlyNumbers(userNameField)) {
            userNameErrorLabel.setText("Personnumret får endast innehålla siffror.");
        }

        if (!checkPassword()) {
            passwordErrorLabel.setText("Lösenordet matchar inte.");
        }
    }

    private void clearErrorMessages() {
        userNameErrorLabel.setText("");
        passwordErrorLabel.setText("");
    }

    private boolean checkPassword() {
        if (confirmPassword.isEmpty() && loginController.getNewUser().getPassword().isEmpty()) {
            return false;
        }
        return confirmPassword.equals(loginController.getNewUser().getPassword());
    }

    private boolean checkIfOnlyNumbers(TextField phoneNumberField){
        List<Character> numbers  = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            numbers.add((char)(i + '0'));
        }
        for(int i = 0; i < phoneNumberField.getText().length(); i++){
            if(!numbers.contains(phoneNumberField.getText().charAt(i))){
                return false;
            }
        }
        return true;
    }
}
