package iMatLogin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.IMatDataHandler;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for the third step in creating an account.
 */
public class CreateAccountStep3Controller implements Initializable {

    private LoginController loginController;

    @FXML private AnchorPane emptyPaymentPane;

    //CreditCardPane
    @FXML private AnchorPane creditCardPane;
    @FXML private ComboBox<String> paymentComboBox;
    @FXML private CheckBox holdersNameCheckBox;
    @FXML private TextField holdersNameField;
    @FXML private TextField cardNumberField;
    @FXML private TextField validMonthField;
    @FXML private TextField validYearField;

    //InvoicePane
    @FXML private AnchorPane invoicePane;

    @FXML private Button createAccountButton;
    @FXML private Button goBackwardButton;

    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();

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
            if (newValue.equals("Kreditkort")) {
                creditCardPane.toFront();
                addCreditCardInputListener();
            }

            if (newValue.equals("Faktura")) {
                invoicePane.toFront();
                addInvoiceInputListener();
            }

            if (newValue.equals("< Betalsätt >")) {
                emptyPaymentPane.toFront();
            }
        });
    }

    public void inject(LoginController loginController) {
        this.loginController = loginController;
    }

    private void addCreditCardInputListener() {
        holdersNameField.textProperty().addListener((observable, oldValue, newValue) -> {
            //TODO
        });

        cardNumberField.textProperty().addListener(((observable, oldValue, newValue) -> {
            //TODO
        }));

        validMonthField.textProperty().addListener(((observable, oldValue, newValue) -> {
            //TODO
        }));

        validYearField.textProperty().addListener(((observable, oldValue, newValue) -> {
            //TODO
        }));
    }

    private void addInvoiceInputListener() {

    }

    @FXML
    private void goBackwardActionPerformed(ActionEvent event) {
        loginController.getCreateAccountStep2().toFront();
    }

    @FXML
    private void holdersNameCheckBoxActionPerformed(ActionEvent event) {
        if (holdersNameCheckBox.isSelected()) {
            holdersNameField.setDisable(true);
            holdersNameField.setText(loginController.getNewCustomer().getFirstName().toUpperCase() + " "
                    + loginController.getNewCustomer().getLastName().toUpperCase());
        } else {
            holdersNameField.setDisable(false);
            holdersNameField.setText("");
        }
    }

    @FXML
    private void createAccountActionPerformed(ActionEvent event) {
        loginController.getLoginPane().toFront();

        dataHandler.getUser().setUserName(loginController.getNewUser().getUserName());
        dataHandler.getUser().setPassword(loginController.getNewUser().getPassword());

        dataHandler.getCustomer().setFirstName(loginController.getNewCustomer().getFirstName());
        dataHandler.getCustomer().setLastName(loginController.getNewCustomer().getLastName());
        dataHandler.getCustomer().setPhoneNumber(loginController.getNewCustomer().getPhoneNumber());
        dataHandler.getCustomer().setMobilePhoneNumber(loginController.getNewCustomer().getMobilePhoneNumber());
        dataHandler.getCustomer().setAddress(loginController.getNewCustomer().getAddress());
        dataHandler.getCustomer().setPostCode(loginController.getNewCustomer().getPostCode());
        dataHandler.getCustomer().setPostAddress(loginController.getNewCustomer().getPostAddress());

        dataHandler.getCreditCard().setCardNumber(loginController.getNewCreditCard().getCardNumber());
        dataHandler.getCreditCard().setHoldersName(loginController.getNewCreditCard().getHoldersName());
        dataHandler.getCreditCard().setValidMonth(loginController.getNewCreditCard().getValidMonth());
        dataHandler.getCreditCard().setValidYear(loginController.getNewCreditCard().getValidYear());
        dataHandler.getCreditCard().setVerificationCode(loginController.getNewCreditCard().getValidYear());
    }
}
