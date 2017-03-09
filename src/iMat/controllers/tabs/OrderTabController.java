package iMat.controllers.tabs;

import iMat.controllers.TabController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by JOHAN on 2017-02-25.
 */
public class OrderTabController implements Initializable {

    private TabController tabController;

    // OrderCartPane
    @FXML private AnchorPane orderCartPane;
    @FXML private TableView<ShoppingItem> shoppingItemTableView;
    @FXML private TableColumn<ShoppingItem, String> nameColumn;
    @FXML private TableColumn<ShoppingItem, String> amountColumn;
    @FXML private TableColumn<ShoppingItem, String> priceColumn;
    @FXML private TableColumn<ShoppingItem, String> sumColumn;

    //OrderHistoryPane
    @FXML private AnchorPane orderHistoryPane;
    @FXML private TableView<Order> orderHistoryTableView;
    @FXML private TableColumn<Order, String> orderNumberColumn;
    @FXML private TableColumn<Order, String> dateColumn;
    @FXML private TableColumn<Order, String> productOrderColumn;
    @FXML private TableColumn<Order, String> sumOrderColumn;

    @FXML private Button placeOrderButton;
    @FXML private Button orderHistoryButton;
    @FXML private Button backToCartButton;

    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setPlaceOrderButton();

        shoppingItemTableView.setItems(refreshItemTableView());
        nameColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getProduct().getName()));
        amountColumn.setCellValueFactory(c -> new SimpleStringProperty(
                String.valueOf(c.getValue().getAmount() + " " + c.getValue().getProduct().getUnitSuffix()))
        );
        priceColumn.setCellValueFactory(c -> new SimpleStringProperty(
                String.valueOf(c.getValue().getProduct().getPrice() + ":-"))
        );
        sumColumn.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getTotal() + ":-")));

        orderHistoryTableView.setItems(refreshOrderTableView());
        orderNumberColumn.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getOrderNumber())));
        dateColumn.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getDate())));
        productOrderColumn.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getItems().size())));
//        sumOrderColumn.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf()));

        dataHandler.getShoppingCart().addShoppingCartListener(cartEvent -> {
            shoppingItemTableView.setItems(refreshItemTableView());
            shoppingItemTableView.refresh();
            orderHistoryTableView.setItems(refreshOrderTableView());
            orderHistoryTableView.refresh();
            setPlaceOrderButton();
        });
    }

    private void setPlaceOrderButton() {
        if (dataHandler.getShoppingCart().getItems().isEmpty()) {
            placeOrderButton.setDisable(true);
        } else {
            placeOrderButton.setDisable(false);
        }
    }

    public void inject(TabController tabController) {
        this.tabController = tabController;
    }

    private ObservableList<ShoppingItem> refreshItemTableView() {
        ObservableList<ShoppingItem> shoppingItemObservableList = FXCollections.observableArrayList();
        shoppingItemObservableList.addAll(dataHandler.getShoppingCart().getItems());

        return shoppingItemObservableList;
    }

    private ObservableList<Order> refreshOrderTableView() {
        ObservableList<Order> orderHistoryObservableList = FXCollections.observableArrayList();
        orderHistoryObservableList.addAll(dataHandler.getOrders());

        return orderHistoryObservableList;
    }

    @FXML
    private void placeOrderActionPerformed(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/iMat/fxmls/stages/ConfirmationStage.fxml"));
        Stage confirmationStage = new Stage();
        confirmationStage.setScene(new Scene(root));

        confirmationStage.setTitle("Bekräfta beställning");
        confirmationStage.setResizable(false);
        confirmationStage.showAndWait();
    }

    @FXML
    private void orderHistoryButtonActionPerformed(ActionEvent event) {
        orderHistoryPane.toFront();
    }

    @FXML
    private void backToCartActionPerformed(ActionEvent event) {
        orderCartPane.toFront();
    }
}
