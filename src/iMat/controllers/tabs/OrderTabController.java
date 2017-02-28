package iMat.controllers.tabs;

import iMat.cells.OrderCartCell;
import iMat.controllers.TabController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by JOHAN on 2017-02-25.
 */
public class OrderTabController implements Initializable {

    private TabController tabController;

    @FXML private ListView<ShoppingItem> shoppingItemListView;
    @FXML private Button placeOrderButton;

    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        shoppingItemListView.setItems(refreshItemListView());
        shoppingItemListView.setCellFactory(shoppingItemListView -> new OrderCartCell());

        dataHandler.getShoppingCart().addShoppingCartListener(cartEvent -> {
            shoppingItemListView.setItems(refreshItemListView());
        });
    }

    public void inject(TabController tabController) {
        this.tabController = tabController;
    }

    private ObservableList<ShoppingItem> refreshItemListView() {
        ObservableList<ShoppingItem> shoppingItemObservableList = FXCollections.observableArrayList();
        shoppingItemObservableList.addAll(dataHandler.getShoppingCart().getItems());

        return shoppingItemObservableList;
    }

    @FXML
    private void placeOrderActionPerformed(ActionEvent event) {
        dataHandler.placeOrder(true);
    }
}
