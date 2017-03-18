package iMatLogin;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import se.chalmers.ait.dat215.project.IMatDataHandler;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller for the third step in creating an account.
 */
public class CreateAccountPaymentController implements Initializable {

    private LoginController loginController;

    @FXML private AnchorPane emptyPaymentPane;
    @FXML private RadioButton creditCardRadioButton;
    @FXML private RadioButton invoiceRadioButton;

    //CreditCardPane
    @FXML private AnchorPane creditCardPane;
    @FXML private CheckBox holdersNameCheckBox;
    @FXML private TextField holdersNameField;
    @FXML private TextField cardNumberField;
    @FXML private TextField validMonthField;
    @FXML private TextField validYearField;
    @FXML private TextField verificationCodeField;

    @FXML private Label cardNumberErrorLabel;

    //InvoicePane
    @FXML private AnchorPane invoicePane;

    @FXML private Button createAccountButton;
    @FXML private Button goBackwardButton;

    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clearErrorLabels();
        emptyPaymentPane.toFront();

        ToggleGroup group = new ToggleGroup();
        creditCardRadioButton.setToggleGroup(group);
        invoiceRadioButton.setToggleGroup(group);

        group.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (group.getSelectedToggle() == creditCardRadioButton) {
                creditCardPane.toFront();
                addCreditCardInputListener();
            }

            if (group.getSelectedToggle() == invoiceRadioButton) {
                invoicePane.toFront();
                addInvoiceInputListener();
            }
        });
    }

    private void clearErrorLabels() {
        cardNumberErrorLabel.setText("");
    }

    public void inject(LoginController loginController) {
        this.loginController = loginController;
    }

    private void addCreditCardInputListener() {
        holdersNameField.textProperty().addListener((observable, oldValue, newValue) -> {
            loginController.getNewCreditCard().setHoldersName(newValue);
        });

        cardNumberField.textProperty().addListener((observable, oldValue, newValue) -> {
            loginController.getNewCreditCard().setCardNumber(newValue);

            if (!newValue.matches("^[0-9]+$")) {
                cardNumberErrorLabel.setText("Kortnumret får endast innehålla siffror.");
            } else {
                cardNumberErrorLabel.setText("");
            }
        });

        validMonthField.textProperty().addListener(((observable, oldValue, newValue) -> {
            loginController.getNewCreditCard().setValidMonth(Integer.valueOf(newValue));
        }));

        validYearField.textProperty().addListener(((observable, oldValue, newValue) -> {
            loginController.getNewCreditCard().setValidYear(Integer.valueOf(newValue));
        }));

        verificationCodeField.textProperty().addListener(((observable, oldValue, newValue) -> {
            loginController.getNewCreditCard().setValidYear(Integer.valueOf(newValue));
        }));
    }

    private void addInvoiceInputListener() {

    }

    @FXML
    private void goBackwardActionPerformed(ActionEvent event) {
        loginController.getDeliveryPane().toFront();
    }

    @FXML
    private void cancelAccountCreationActionPerformed(ActionEvent event) {
        loginController.getLoginPane().toFront();
        loginController.clearAllTextFields();
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

    public void clearTextFields() {
        holdersNameField.clear();
        cardNumberField.clear();
        validMonthField.clear();
        validYearField.clear();
        verificationCodeField.clear();
    }
}
