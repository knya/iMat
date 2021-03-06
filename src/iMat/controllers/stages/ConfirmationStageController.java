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
import java.time.chrono.Chronology;
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
    @FXML private RadioButton creditCardRadioButton;
    @FXML private RadioButton invoiceRadioButton;
    @FXML private DatePicker deliveryDatePicker;
    @FXML private ToggleGroup paymentGroup;

    //SecondConfirmationPane
    @FXML private AnchorPane secondConfirmationPane;
    @FXML private Label presentationLabel2nd;
    @FXML private Label addressLabel2nd;
    @FXML private TableView<ShoppingItem> shoppingItemTableView2nd;
    @FXML private TableColumn<ShoppingItem, String> productColumn2nd;
    @FXML private TableColumn<ShoppingItem, String> amountColumn2nd;
    @FXML private TableColumn<ShoppingItem, String> totalColumn2nd;
    @FXML private ChoiceBox<String> deliveryAddressChoiceBox;

    //ThankYouPane
    @FXML private AnchorPane thankYouPane;
    @FXML private Button finishedButton;
    @FXML private Label addressLabel3rd;
    @FXML private Label dateLabel;

    @FXML private Label totalSum;

    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        presentationLabel.setText("Hej " + dataHandler.getCustomer().getFirstName() + "!");
        presentationLabel2nd.setText(dataHandler.getCustomer().getFirstName() + ",");
        addressLabel2nd.setText(
                dataHandler.getCustomer().getAddress() + ", "
                + dataHandler.getCustomer().getPostCode() + ", "
                + dataHandler.getCustomer().getPostAddress()
        );
        addressLabel3rd.setText(dataHandler.getCustomer().getAddress() + ", "
                + dataHandler.getCustomer().getPostCode() + ", "
                + dataHandler.getCustomer().getPostAddress()
        );

        ObservableList<String> deliveryAddressObservableList = FXCollections.observableArrayList(
                dataHandler.getCustomer().getAddress() + ", "
                + dataHandler.getCustomer().getPostCode() + ", "
                + dataHandler.getCustomer().getPostAddress()
        );

        deliveryAddressChoiceBox.setItems(deliveryAddressObservableList);

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

        if (deliveryDatePicker != null) {
            dateLabel.setText(String.valueOf(deliveryDatePicker.getValue().getDayOfMonth()
                    + "/" + deliveryDatePicker.getValue().getMonthValue()
                    + "/" + deliveryDatePicker.getValue().getYear()));
        }
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
