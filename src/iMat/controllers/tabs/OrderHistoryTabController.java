package iMat.controllers.tabs;

import iMat.controllers.TabController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for OrderHistoryTab.
 */
public class OrderHistoryTabController implements Initializable {

    private TabController tabController;

    @FXML private AnchorPane orderHistoryPane;
    @FXML private TableView<Order> orderHistoryTableView;
    @FXML private TableView<ShoppingItem> orderProductTableView;
    @FXML private TableColumn<Order, String> orderNumberColumn;
    @FXML private TableColumn<Order, String> dateColumn;

    @FXML private TableColumn<ShoppingItem, String> productNameColumn;
    @FXML private TableColumn<ShoppingItem, String> amountProductColumn;
    @FXML private TableColumn<ShoppingItem, String> sumProductColumn;

    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        orderHistoryTableView.setItems(refreshOrderTableView());
        orderNumberColumn.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getOrderNumber())));
        dateColumn.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getDate())));

        productNameColumn.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getProduct().getName())));
        amountProductColumn.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getAmount() + " "
                + c.getValue().getProduct().getUnitSuffix())));
        sumProductColumn.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getTotal())));
//        productOrderColumn.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getItems().size())));

        orderHistoryTableView.getSelectionModel().selectedIndexProperty().addListener(((observable, oldValue, newValue) -> {
            orderProductTableView.setItems(refreshOrderItemsTableView());
            orderProductTableView.refresh();
        }));

        dataHandler.getShoppingCart().addShoppingCartListener(cartEvent -> {
            orderHistoryTableView.setItems(refreshOrderTableView());
            orderHistoryTableView.refresh();

//            orderProductTableView.setItems(refreshOrderItemsTableView());
//            orderHistoryTableView.refresh();
        });
    }

    public void inject(TabController tabController) {
        this.tabController = tabController;
    }

    private ObservableList<Order> refreshOrderTableView() {
        ObservableList<Order> orderHistoryObservableList = FXCollections.observableArrayList();
        orderHistoryObservableList.addAll(dataHandler.getOrders());

        return orderHistoryObservableList;
    }

    private ObservableList<ShoppingItem> refreshOrderItemsTableView() {
        ObservableList<ShoppingItem> orderShoppingItemList = FXCollections.observableArrayList();
        int index = orderHistoryTableView.getSelectionModel().getFocusedIndex();
        for (ShoppingItem i : dataHandler.getOrders().get(index).getItems()) {
            orderShoppingItemList.add(i);
        }

        return orderShoppingItemList;
    }
}
