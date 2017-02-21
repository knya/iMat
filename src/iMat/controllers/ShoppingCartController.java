package iMat.controllers;

import iMat.cells.ShoppingItemCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import se.chalmers.ait.dat215.project.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for shopping cart.
 */
public class ShoppingCartController implements Initializable {

    private MainController mainController;

    @FXML private ListView<ShoppingItem> shoppingItemListView;
    @FXML private Button goToCartButton;

    private ObservableList<ShoppingItem> shoppingItemObservableList;

    private ShoppingCart shoppingCart;
    private IMatDataHandler dataHandler;

    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dataHandler = IMatDataHandler.getInstance();
        shoppingCart = dataHandler.getShoppingCart();

        shoppingCart.addProduct(dataHandler.getProduct(1));
        shoppingCart.addProduct(dataHandler.getProduct(2));

        shoppingItemObservableList = FXCollections.observableArrayList();
        shoppingItemObservableList.addAll(shoppingCart.getItems());

//        ShoppingItem shoppingItem1 = new ShoppingItem(dataHandler.getProduct(1));
//        ShoppingItem shoppingItem2 = new ShoppingItem(dataHandler.getProduct(2));

//        shoppingItemObservableList = FXCollections.observableArrayList();
//        shoppingItemObservableList.addAll(shoppingItem1, shoppingItem2);

        shoppingItemListView.setItems(shoppingItemObservableList);
        shoppingItemListView.setCellFactory(shoppingItemListView -> new ShoppingItemCell(shoppingItemListView));
    }

    public ListView<ShoppingItem> getShoppingItemListView() {
        return shoppingItemListView;
    }
}
