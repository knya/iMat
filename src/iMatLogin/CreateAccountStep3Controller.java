package iMatLogin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for the third step in creating an account.
 */
public class CreateAccountStep3Controller implements Initializable {

    private LoginController loginController;

    @FXML private ComboBox<String> paymentComboBox;
    @FXML private Button createAccountButton;
    @FXML private AnchorPane creditCardPane;
    @FXML private AnchorPane invoicePane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> paymentList = FXCollections.observableArrayList(
                "< Betalsätt >",
                "Kreditkort",
                "Faktura"
        );

        paymentComboBox.setItems(paymentList);
        paymentComboBox.getSelectionModel().selectFirst();

        paymentComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == "Kreditkort") {
                creditCardPane.toFront();
            }

            if (newValue == "Faktura") {
                invoicePane.toFront();
            }
        });
    }

    public void inject(LoginController loginController) {
        this.loginController = loginController;
    }

    @FXML
    private void createAccountActionPerformed(ActionEvent event) {
        loginController.getLoginPane();
    }

    @FXML
    private void goBackwardActionPerformed(ActionEvent event) {
        loginController.getCreateAccountStep2().toFront();
    }
}
