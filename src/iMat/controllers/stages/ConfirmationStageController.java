package iMat.controllers.stages;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by JOHAN on 2017-03-01.
 */
public class ConfirmationStageController implements Initializable {


    @FXML private Button confirmOrderButton;
    @FXML private Button cancelOrderButton;

    //FirstConfirmationPane
    @FXML private AnchorPane firstConfirmationPane;
    @FXML private Label presentationLabel;
    @FXML private TableView<ShoppingItem> shoppingItemTableView;
    @FXML private TableColumn<ShoppingItem, String> productColumn;
    @FXML private TableColumn<ShoppingItem, String> amountColumn;
    @FXML private TableColumn<ShoppingItem, String> totalColumn;

    //SecondConfirmationPane
    @FXML private AnchorPane secondConfirmationPane;
    @FXML private TableView<ShoppingItem> shoppingItemTableView2nd;
    @FXML private TableColumn<ShoppingItem, String> productColumn2nd;
    @FXML private TableColumn<ShoppingItem, String> amountColumn2nd;
    @FXML private TableColumn<ShoppingItem, String> totalColumn2nd;

    //ThankYouPane
    @FXML private AnchorPane thankYouPane;
    @FXML private Button finishedButton;


    @FXML private Label totalSum;

    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        presentationLabel.setText("Hej " + dataHandler.getCustomer().getFirstName() + "!");

        ObservableList<ShoppingItem> shoppingItemObservableList = FXCollections.observableArrayList();
        shoppingItemObservableList.addAll(dataHandler.getShoppingCart().getItems());

        productColumn.setCellValueFactory(c -> new SimpleStringProperty(
                String.valueOf(c.getValue().getProduct().getName())
        ));

        amountColumn.setCellValueFactory(c -> new SimpleStringProperty(
                String.valueOf(c.getValue().getAmount())
        ));

        totalColumn.setCellValueFactory(c -> new SimpleStringProperty(
                String.valueOf(c.getValue().getTotal() + ":-")
        ));

        productColumn2nd.setCellValueFactory(c -> new SimpleStringProperty(
                String.valueOf(c.getValue().getProduct().getName())
        ));

        amountColumn2nd.setCellValueFactory(c -> new SimpleStringProperty(
                String.valueOf(c.getValue().getAmount() + " " + c.getValue().getProduct().getUnitSuffix())
        ));

        totalColumn2nd.setCellValueFactory(c -> new SimpleStringProperty(
                String.valueOf(c.getValue().getTotal() + ":-")
        ));

        shoppingItemTableView.setItems(shoppingItemObservableList);
        shoppingItemTableView2nd.setItems(shoppingItemObservableList);

        totalSum.setText(String.valueOf(dataHandler.getShoppingCart().getTotal()) + ":-");
    }

    @FXML
    private void confirmOrderActionPerformed(ActionEvent event) {
        secondConfirmationPane.toFront();
    }

    @FXML
    private void placeOrderActionPerformed(ActionEvent event) {
        dataHandler.placeOrder(true);
        thankYouPane.toFront();
    }

    @FXML
    private void finishedButtonActionPerformed(ActionEvent event) {
        Stage confirmationStage = (Stage) cancelOrderButton.getScene().getWindow();
        confirmationStage.close();
    }

    @FXML
    private void cancelOrderActionPerformed(ActionEvent event) {
        Stage confirmationStage = (Stage) cancelOrderButton.getScene().getWindow();
        confirmationStage.close();
    }
}
