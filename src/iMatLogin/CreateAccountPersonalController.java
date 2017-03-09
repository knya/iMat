package iMatLogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import se.chalmers.ait.dat215.project.IMatDataHandler;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller for the first step in creating an account.
 */
public class CreateAccountPersonalController implements Initializable {

    private LoginController loginController;

    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField phoneNumberField;
    @FXML private TextField mobilePhoneNumberField;
    @FXML private TextField confirmPhoneField;
    @FXML private TextField confirmMobileField;

    @FXML private Button goForwardButton;
    @FXML private Button backToLogin;

    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        firstNameField.textProperty().addListener((observable, oldValue, newValue) -> {
            loginController.getNewCustomer().setFirstName(newValue);
        });

        lastNameField.textProperty().addListener((observable, oldValue, newValue) -> {
            loginController.getNewCustomer().setLastName(newValue);
        });

        phoneNumberField.textProperty().addListener((observable, oldValue, newValue) -> {
            loginController.getNewCustomer().setPhoneNumber(newValue);
        });

        mobilePhoneNumberField.textProperty().addListener((observable, oldValue, newValue) -> {
            loginController.getNewCustomer().setMobilePhoneNumber(newValue);
        });

        confirmPhoneField.textProperty().addListener((observable, oldValue, newValue) -> {
            //TODO
        });

        confirmMobileField.textProperty().addListener((observable, oldValue, newValue) -> {
            //TODO
        });

    }

    public void inject(LoginController loginController) {
        this.loginController = loginController;
    }

    @FXML
    private void goForwardActionPerformed(ActionEvent event) {
        if(checkIfOnlyNumbers(phoneNumberField) && checkIfOnlyNumbers(mobilePhoneNumberField)
                && confirmPhoneField.getText().equals(phoneNumberField.getText())
                && mobilePhoneNumberField.getText().equals(confirmMobileField.getText())){
            loginController.getDeliveryPane().toFront();
        } else {
            triggerSamePageErrorMessage();
        }


    }

    @FXML
    private void backToLoginActionPerformed(ActionEvent event) {
        loginController.getLoginPane().toFront();
    }

    private void triggerSamePageErrorMessage() {

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
