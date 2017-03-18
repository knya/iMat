package iMat.controllers.tabs;

import iMat.controllers.TabController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.IMatDataHandler;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for My Pages tab.
 */
public class MyPagesTabController implements Initializable {

    private TabController tabController;

    @FXML private AnchorPane personalDetailsPane;
    @FXML private AnchorPane changeDeliveryAddressPane;
    @FXML private AnchorPane creditCardDetailsPane;

    // PersonalDetailsPane
    @FXML private TextField usernameField;
    @FXML private TextField nameField;
    @FXML private TextField phoneNumberField;
    @FXML private TextField mobilePhoneNumberField;
    @FXML private TextField fullAddressField;

    //CreditCardDetailsPane
    @FXML private TextField holdersNameField;
    @FXML private TextField maskedCardNumberField;
    @FXML private Label expiryDateLabel;

    //ChangeAddressDeliveryPane
    @FXML private TextField currentFullAddressField;
    @FXML private TextField newAddressField;
    @FXML private TextField newPostCodeField;
    @FXML private TextField newCityField;
    private String newAddress = "";
    private String newPostCode = "";
    private String newCity = "";

    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        personalDetailsPane.toFront();
        setLabels();
    }

    private void setLabels() {
        holdersNameField.setText(dataHandler.getCustomer().getFirstName().toUpperCase()
                + " " + dataHandler.getCustomer().getLastName().toUpperCase());
        maskedCardNumberField.setText(dataHandler.getCreditCard().getCardNumber());
        expiryDateLabel.setText(dataHandler.getCreditCard().getValidMonth() + " / " + dataHandler.getCreditCard().getValidYear());

        //PersonalDetailsPane
        usernameField.setText(dataHandler.getUser().getUserName());
        nameField.setText(dataHandler.getCustomer().getFirstName() + " " + dataHandler.getCustomer().getLastName());
        phoneNumberField.setText(dataHandler.getCustomer().getPhoneNumber());
        mobilePhoneNumberField.setText(dataHandler.getCustomer().getMobilePhoneNumber());
        fullAddressField.setText(dataHandler.getCustomer().getAddress()
                + ", " + dataHandler.getCustomer().getPostCode()
                + ", " + dataHandler.getCustomer().getPostAddress()
        );

        //ChangeDeliveryAddressPane
        currentFullAddressField.setText(dataHandler.getCustomer().getAddress()
                + ", " + dataHandler.getCustomer().getPostCode()
                + ", " + dataHandler.getCustomer().getPostAddress());
    }

    public void inject(TabController tabController) {
        this.tabController = tabController;
    }

    @FXML
    private void changeDeliveryAddressPaneActionPerformed(ActionEvent event) {
        changeDeliveryAddressPane.toFront();
        addDeliveryChangeListener();
    }

    private void addDeliveryChangeListener() {
        newAddressField.textProperty().addListener((observable, oldValue, newValue) -> {
            newAddress = newValue;
        });

        newPostCodeField.textProperty().addListener((observable, oldValue, newValue) -> {
            newPostCode = newValue;
        });

        newCityField.textProperty().addListener((observable, oldValue, newValue) -> {
            newCity = newValue;
        });
    }

    @FXML
    private void cancelDeliveryChangesActionPerformed(ActionEvent event) {
        personalDetailsPane.toFront();
        clearFields();
    }

    @FXML
    private void saveDeliveryChangesActionPerformed(ActionEvent event) {
        personalDetailsPane.toFront();
        dataHandler.getCustomer().setAddress(newAddress);
        dataHandler.getCustomer().setPostCode(newPostCode);
        dataHandler.getCustomer().setPostAddress(newCity);
        setLabels();
    }

    @FXML
    private void personalDetailsPaneActionPerformed(ActionEvent event) {
        personalDetailsPane.toFront();
        clearFields();
    }

    @FXML
    private void creditCardDetailsPaneActionPerformed(ActionEvent event) {
        creditCardDetailsPane.toFront();
    }

    private void clearFields() {
        newAddressField.clear();
        newPostCodeField.clear();
        newCityField.clear();
    }
}
