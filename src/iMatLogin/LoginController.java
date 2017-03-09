package iMatLogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    @FXML private CreateAccountUserController createAccountUserController;
    @FXML private CreateAccountPersonalController createAccountPersonalController;
    @FXML private CreateAccountDeliveryController createAccountDeliveryController;
    @FXML private CreateAccountPaymentController createAccountPaymentController;

    private NewUser newUser;
    private NewCustomer newCustomer;
    private NewCreditCard newCreditCard;

    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createAccountUserController.inject(this);
        createAccountPersonalController.inject(this);
        createAccountDeliveryController.inject(this);
        createAccountPaymentController.inject(this);

        userNameField.textProperty().addListener(((observable, oldValue, newValue) -> {
            if (dataHandler.getUser().getUserName() != null) {
                userNameField.setText(dataHandler.getUser().getUserName());
            }
        }));
    }

    @FXML
    private void changeSceneContent(ActionEvent event) throws IOException {

        /*
        if (newUser != null) {
            if (newUser.getUserName().equals(dataHandler.getUser().getUserName())
                    && newUser.getPassword().equals(dataHandler.getUser().getPassword())) {
                Stage stage = (Stage) loginScenePane.getScene().getWindow();

                Parent mainScene = FXMLLoader.load(getClass().getResource("/iMat/fxmls/Main.fxml"));
                stage.setScene(new Scene(mainScene));
                stage.setTitle("iMat");
                stage.setX(0);
                stage.setY(0);
            }
        }
        */

        Stage stage = (Stage) loginScenePane.getScene().getWindow();

        Parent mainScene = FXMLLoader.load(getClass().getResource("/iMat/fxmls/Main.fxml"));
        stage.setScene(new Scene(mainScene));
        stage.setTitle("iMat");
        stage.setX(0);
        stage.setY(0);

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
