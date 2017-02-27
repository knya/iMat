package iMat.controllers;

import iMat.cells.ShoppingItemCell;
import iMat.controllers.cells.ShoppingItemCellController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import se.chalmers.ait.dat215.project.*;

import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for shopping cart.
 */
public class ShoppingCartController implements Initializable {

    private MainController mainController;
    private ShoppingItemCellController shoppingItemCellController;

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
    synchronized public void initialize(URL location, ResourceBundle resources) {
        dataHandler = IMatDataHandler.getInstance();
        shoppingCart = dataHandler.getShoppingCart();

        shoppingCart.addProduct(dataHandler.getProduct(1));
        shoppingCart.addProduct(dataHandler.getProduct(2));
        shoppingCart.addProduct(dataHandler.getProduct(3));


        totalLabel.setText(String.valueOf(shoppingCart.getTotal()) + ":-");









//        shoppingItemObservableList = FXCollections.observableArrayList();
//        shoppingItemObservableList.addAll(shoppingCart.getItems());

        shoppingItemListView.setItems(refreshItemListView());
        shoppingItemListView.setCellFactory(shoppingItemListView -> new ShoppingItemCell());

        shoppingCart.addShoppingCartListener(cartEvent -> {
            totalLabel.setText(String.valueOf(shoppingCart.getTotal()) + ":-");
            shoppingItemListView.setItems(refreshItemListView());
        });
    }

    private ObservableList<ShoppingItem> refreshItemListView() {
        ObservableList<ShoppingItem> shoppingItemObservableList = FXCollections.observableArrayList();
        shoppingItemObservableList.addAll(shoppingCart.getItems());

        return shoppingItemObservableList;
    }

    @FXML
    private void goToCartActionPerformed(ActionEvent event) {
        //TODO
    }


}
