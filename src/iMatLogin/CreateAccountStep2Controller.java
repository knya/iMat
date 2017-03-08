package iMatLogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for the second step in creating an account.
 */
public class CreateAccountStep2Controller implements Initializable {

    private LoginController loginController;

    @FXML private Button goBackwardButton;

    @FXML private TextField deliveryAddressField;
    @FXML private TextField postCodeField;
    @FXML private TextField cityField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        deliveryAddressField.textProperty().addListener(((observable, oldValue, newValue) -> {
            loginController.getNewCustomer().setAddress(newValue);
        }));

        postCodeField.textProperty().addListener(((observable, oldValue, newValue) -> {
            loginController.getNewCustomer().setPostCode(newValue);
        }));

        cityField.textProperty().addListener(((observable, oldValue, newValue) -> {
            loginController.getNewCustomer().setPostAddress(newValue);
        }));
    }

    public void inject(LoginController loginController) {
        this.loginController = loginController;
    }

    @FXML
    private void goBackwardActionPerformed(ActionEvent event) {
        loginController.getCreateAccountStep1().toFront();
    }

    @FXML
    private void goForwardActionPerformed(ActionEvent event) {
        loginController.getCreateAccountStep3().toFront();
    }
}
