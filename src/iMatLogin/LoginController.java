package iMatLogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import se.chalmers.ait.dat215.project.IMatDataHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

/**
 * Created by JOHAN on 2017-03-02.
 */
public class LoginController implements Initializable {

    @FXML private AnchorPane loginScenePane;
    @FXML private StackPane createAccountPane;
    @FXML private AnchorPane loginPane;
    @FXML private AnchorPane userPane;
    @FXML private AnchorPane personalPane;
    @FXML private AnchorPane deliveryPane;
    @FXML private AnchorPane paymentPane;

    @FXML private TextField userNameField;
    @FXML private TextField passwordField;

    @FXML private Label loginErrorLabel;

    @FXML private CreateAccountUserController createAccountUserController;
    @FXML private CreateAccountPersonalController createAccountPersonalController;
    @FXML private CreateAccountDeliveryController createAccountDeliveryController;
    @FXML private CreateAccountPaymentController createAccountPaymentController;

    private NewUser newUser;
    private NewCustomer newCustomer;
    private NewCreditCard newCreditCard;

    private String username = "";
    private String password = "";

    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        clearErrorLabel();

        if (!dataHandler.getUser().getUserName().isEmpty()) {
            userNameField.setText(dataHandler.getUser().getUserName());
            username = dataHandler.getUser().getUserName();
        }

        createAccountUserController.inject(this);
        createAccountPersonalController.inject(this);
        createAccountDeliveryController.inject(this);
        createAccountPaymentController.inject(this);

        userNameField.textProperty().addListener(((observable, oldValue, newValue) -> {
            username = newValue;
        }));

        passwordField.textProperty().addListener(((observable, oldValue, newValue) -> {
            password = newValue;
        }));
    }

    @FXML
    private void changeSceneContent(ActionEvent event) throws IOException {

        if (!dataHandler.getUser().getUserName().isEmpty() && !dataHandler.getUser().getPassword().isEmpty()) {
            if (!username.isEmpty() && !password.isEmpty()) {
                if (username.equals(dataHandler.getUser().getUserName())
                        && password.equals(dataHandler.getUser().getPassword())) {
                    Stage stage = (Stage) loginScenePane.getScene().getWindow();

                    Parent mainScene = FXMLLoader.load(getClass().getResource("/iMat/fxmls/Main.fxml"));
                    stage.setScene(new Scene(mainScene));
                    stage.setTitle("iMat");
                    stage.setX(0);
                    stage.setY(0);
                } else {
                    loginErrorLabel.setText("Felaktigt användarnamn eller lösenord");
                }
            } else {
                loginErrorLabel.setText("Användarnamn eller lösenord ej ifyllt");
            }
        } else {
            loginErrorLabel.setText("Du har inte skapat en användare ännu");
        }
    }

    private void clearErrorLabel() {
        loginErrorLabel.setText("");
    }

    @FXML
    private void createButtonActionPerformed(ActionEvent event) {
        userNameField.clear();
        passwordField.clear();
        clearErrorLabel();

        userPane.toFront();

        newUser = new NewUser();
        newCustomer = new NewCustomer();
        newCreditCard = new NewCreditCard();
    }

    public TextField getUserNameField() {
        return userNameField;
    }

    public AnchorPane getUserPane() {
        return userPane;
    }

    public AnchorPane getPersonalPane() {
        return personalPane;
    }

    public AnchorPane getDeliveryPane() {
        return deliveryPane;
    }

    public AnchorPane getPaymentPane() {
        return paymentPane;
    }

    public AnchorPane getLoginPane() {
        return loginPane;
    }

    public NewUser getNewUser() {
        return newUser;
    }

    public NewCustomer getNewCustomer() {
        return newCustomer;
    }

    public NewCreditCard getNewCreditCard() {
        return newCreditCard;
    }

    public void clearAllTextFields() {
        createAccountUserController.clearTextFields();
        createAccountPersonalController.clearTextFields();
        createAccountDeliveryController.clearTextFields();
        createAccountPaymentController.clearTextFields();
    }
}
