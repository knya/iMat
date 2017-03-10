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

    private String username;
    private String password;

    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        clearErrorLabel();

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


        if (newUser != null && dataHandler.getUser().getUserName() != null) {
            if (newUser.getUserName().equals(dataHandler.getUser().getUserName())
                    && newUser.getPassword().equals(dataHandler.getUser().getPassword())
                    && username.equals(newUser.getUserName())
                    && username.equals(dataHandler.getUser().getUserName())
                    && password.equals(newUser.getPassword())
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
            loginErrorLabel.setText("Användare ej registrerad ännu");
        }

        /*
        Stage stage = (Stage) loginScenePane.getScene().getWindow();

        Parent mainScene = FXMLLoader.load(getClass().getResource("/iMat/fxmls/Main.fxml"));
        stage.setScene(new Scene(mainScene));
        stage.setTitle("iMat");
        stage.setX(0);
        stage.setY(0);
        */

    }

    private void clearErrorLabel() {
        loginErrorLabel.setText("");
    }

    @FXML
    private void createButtonActionPerformed(ActionEvent event) {
        userPane.toFront();

        newUser = new NewUser();
        newCustomer = new NewCustomer();
        newCreditCard = new NewCreditCard();
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

}
