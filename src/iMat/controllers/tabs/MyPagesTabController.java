package iMat.controllers.tabs;

import iMat.controllers.TabController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    @FXML private AnchorPane myPagesPersonal;
    @FXML private AnchorPane myPagesDelivery;

    @FXML private TextField socialSecurityNumberField;
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField phoneNumberField;
    @FXML private TextField mobilePhoneNumberField;

    @FXML private TextField addressField;
    @FXML private TextField postCodeField;
    @FXML private TextField cityField;

    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setLabels();

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

        addressField.textProperty().addListener((observable, oldValue, newValue) -> {
            dataHandler.getCustomer().setAddress(newValue);
        });

        postCodeField.textProperty().addListener((observable, oldValue, newValue) -> {
            dataHandler.getCustomer().setPostCode(newValue);
        });

        cityField.textProperty().addListener((observable, oldValue, newValue) -> {
            dataHandler.getCustomer().setPostAddress(newValue);
        });
    }

    private void setLabels() {
        socialSecurityNumberField.setText(dataHandler.getUser().getUserName());
        firstNameField.setText(dataHandler.getCustomer().getFirstName());
        lastNameField.setText(dataHandler.getCustomer().getLastName());
        phoneNumberField.setText(dataHandler.getCustomer().getPhoneNumber());
        mobilePhoneNumberField.setText(dataHandler.getCustomer().getMobilePhoneNumber());
        addressField.setText(dataHandler.getCustomer().getAddress());
        postCodeField.setText(dataHandler.getCustomer().getPostCode());
        cityField.setText(dataHandler.getCustomer().getPostAddress());
    }

    public void inject(TabController tabController) {
        this.tabController = tabController;
    }
}
