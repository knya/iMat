package iMat.controllers;

import iMat.cells.ShoppingItemCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    @FXML private Label totalLabel;

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

        totalLabel.setText(String.valueOf(shoppingCart.getTotal()));

        shoppingItemObservableList = FXCollections.observableArrayList();
        shoppingItemObservableList.addAll(shoppingCart.getItems());

        shoppingItemListView.setItems(shoppingItemObservableList);
        shoppingItemListView.setCellFactory(shoppingItemListView -> new ShoppingItemCell(shoppingItemListView));

        shoppingCart.addShoppingCartListener(new ShoppingCartListener() {
            @Override
            public void shoppingCartChanged(CartEvent cartEvent) {
                totalLabel.setText(String.valueOf(shoppingCart.getTotal()));
            }
        });
    }


}
