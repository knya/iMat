package iMatLogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import se.chalmers.ait.dat215.project.IMatDataHandler;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for the first step in creating an account.
 */
public class CreateAccountStep1Controller implements Initializable {

    private LoginController loginController;

    @FXML private TextField userNameField;
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
        userNameField.textProperty().addListener((observable, oldValue, newValue) -> {
            dataHandler.getUser().setUserName(newValue);
            System.out.println(dataHandler.getUser().getUserName());
        });

        firstNameField.textProperty().addListener((observable, oldValue, newValue) -> {
            dataHandler.getCustomer().setFirstName(newValue);
        });

        lastNameField.textProperty().addListener((observable, oldValue, newValue) -> {
            dataHandler.getCustomer().setLastName(newValue);
        });

        phoneNumberField.textProperty().addListener((observable, oldValue, newValue) -> {
            dataHandler.getCustomer().setPhoneNumber(newValue);
        });

        mobilePhoneNumberField.textProperty().addListener((observable, oldValue, newValue) -> {
            dataHandler.getCustomer().setMobilePhoneNumber(newValue);
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
        loginController.getCreateAccountStep2().toFront();
    }

    @FXML
    private void backToLoginActionPerformed(ActionEvent event) {
        loginController.getLoginPane().toFront();
    }
}
