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
public class ShoppingCartController implements Initializable, ShoppingCartListener {

    private MainController mainController;

    @FXML private ListView<ShoppingItem> shoppingItemListView;
    @FXML private Button goToCart;

//    private ShoppingCart shoppingCart;
//    private ShoppingCartListener shoppingCartListener;

    private IMatDataHandler dataHandler;

    private ObservableList<ShoppingItem> shoppingItemObservableList;

    protected void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        dataHandler = IMatDataHandler.getInstance();
        ShoppingItem shoppingItem = new ShoppingItem(dataHandler.getProduct(1));

        shoppingItemObservableList = FXCollections.observableArrayList();
        shoppingItemObservableList.add(shoppingItem);

        System.out.println(shoppingItemObservableList.get(0));


        shoppingItemListView.setItems(shoppingItemObservableList);
        shoppingItemListView.setCellFactory(shoppingItemListView -> new ShoppingItemCell());

//        shoppingCart.addShoppingCartListener(shoppingCartListener);
    }

    @Override
    public void shoppingCartChanged(CartEvent cartEvent) {

    }
}
