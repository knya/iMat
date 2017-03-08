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
    @FXML private AnchorPane createAccountStep1Pane;
    @FXML private AnchorPane createAccountStep2Pane;
    @FXML private AnchorPane createAcctionStep3Pane;

    @FXML private TextField userNameField;
    @FXML private TextField passwordField;

    @FXML private CreateAccountStep1Controller createAccountStep1Controller;
    @FXML private CreateAccountStep2Controller createAccountStep2Controller;
    @FXML private CreateAccountStep3Controller createAccountStep3Controller;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String mobileNumber;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createAccountStep1Controller.inject(this);
        createAccountStep2Controller.inject(this);
        createAccountStep3Controller.inject(this);

    }

    @FXML
    protected void changeSceneContent(ActionEvent event) throws IOException {
        Stage stage = (Stage) loginScenePane.getScene().getWindow();

        Parent mainScene = FXMLLoader.load(getClass().getResource("/iMat/fxmls/Main.fxml"));
        stage.setScene(new Scene(mainScene));
        stage.setTitle("iMat");
        stage.setX(0);
        stage.setY(0);
    }

    @FXML
    private void createButtonActionPerformed(ActionEvent event) {
        createAccountStep1Pane.toFront();
    }

    public AnchorPane getCreateAccountStep1() {
        return createAccountStep1Pane;
    }

    public AnchorPane getCreateAccountStep2() {
        return createAccountStep2Pane;
    }

    public AnchorPane getCreateAccountStep3() {
        return createAcctionStep3Pane;
    }

    public AnchorPane getLoginPane() {
        return loginPane;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
