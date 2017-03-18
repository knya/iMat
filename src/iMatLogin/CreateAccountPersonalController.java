package iMatLogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    @FXML private Label firstNameErrorLabel;
    @FXML private Label lastNameErrorLabel;
    @FXML private Label phoneErrorLabel;
    @FXML private Label mobileErrorLabel;

    @FXML private Button goForwardButton;
    @FXML private Button goBackwardButton;
    @FXML private Button cancelAccountCreationButton;

    private String confirmPhone = "";
    private String confirmMobile = "";

    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clearErrorLabels();

        firstNameField.textProperty().addListener((observable, oldValue, newValue) -> {
            loginController.getNewCustomer().setFirstName(newValue);

            if (newValue.isEmpty()) {
                firstNameErrorLabel.setText("Fält ej ifyllt");
            } else {
                firstNameErrorLabel.setText("");
            }
        });

        lastNameField.textProperty().addListener((observable, oldValue, newValue) -> {
            loginController.getNewCustomer().setLastName(newValue);

            if (newValue.isEmpty()) {
                lastNameErrorLabel.setText("Fält ej ifyllt");
            } else {
                lastNameErrorLabel.setText("");
            }
        });

        phoneNumberField.textProperty().addListener((observable, oldValue, newValue) -> {
            loginController.getNewCustomer().setPhoneNumber(newValue);
        });

        mobilePhoneNumberField.textProperty().addListener((observable, oldValue, newValue) -> {
            loginController.getNewCustomer().setMobilePhoneNumber(newValue);
        });

        confirmPhoneField.textProperty().addListener((observable, oldValue, newValue) -> {
            confirmPhone = newValue;
        });

        confirmMobileField.textProperty().addListener((observable, oldValue, newValue) -> {
            confirmMobile = newValue;
        });

    }

    public void inject(LoginController loginController) {
        this.loginController = loginController;
    }

    @FXML
    private void goForwardActionPerformed(ActionEvent event) {
        clearErrorLabels();

        if(checkPhone() && checkMobile()) {
            loginController.getDeliveryPane().toFront();
        } else {
            setErrorLabels();
        }
    }

    @FXML
    private void goBackwardActionPerformed(ActionEvent event) {
        loginController.getUserPane().toFront();
    }

    private void clearErrorLabels() {
        firstNameErrorLabel.setText("");
        lastNameErrorLabel.setText("");
        phoneErrorLabel.setText("");
        mobileErrorLabel.setText("");
    }

    @FXML
    private void cancelAccountCreationActionPerformed(ActionEvent event) {
        loginController.getLoginPane().toFront();
        loginController.clearAllTextFields();
    }

    public void clearTextFields() {
        firstNameField.clear();
        lastNameField.clear();
        phoneNumberField.clear();
        mobilePhoneNumberField.clear();
        confirmPhoneField.clear();
        confirmMobileField.clear();
    }

    private void setErrorLabels() {
        if (firstNameField.getText().isEmpty()) {
            firstNameErrorLabel.setText("Fält ej ifyllt");
        }

        if (lastNameField.getText().isEmpty()) {
            lastNameErrorLabel.setText("Fält ej ifyllt");
        }

        if (phoneNumberField.getText().isEmpty()) {
            phoneErrorLabel.setText("Fält ej ifyllt");
        }

        if (mobilePhoneNumberField.getText().isEmpty()) {
            mobileErrorLabel.setText("Fält ej ifyllt");
        }

        if (!checkPhone()) {
            phoneErrorLabel.setText("Telefonnumret matchar inte");
        }

        if (!checkMobile()) {
            mobileErrorLabel.setText("Mobilnumret matchar inte");
        }
    }

    private boolean checkPhone() {
        if (confirmPhone.isEmpty() && loginController.getNewCustomer().getPhoneNumber().isEmpty()) {
            return false;
        }
        return checkIfOnlyNumbers(phoneNumberField) && confirmPhone.equals(loginController.getNewCustomer().getPhoneNumber());
    }

    private boolean checkMobile() {
        if (confirmMobile.isEmpty() && loginController.getNewCustomer().getMobilePhoneNumber().isEmpty()) {
            return false;
        }
        return checkIfOnlyNumbers(mobilePhoneNumberField) && confirmPhone.equals(loginController.getNewCustomer().getMobilePhoneNumber());
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
