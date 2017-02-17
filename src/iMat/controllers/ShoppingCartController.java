package iMat.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import se.chalmers.ait.dat215.project.Product;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for shopping cart.
 */
public class ShoppingCartController implements Initializable {

    @FXML private ListView shoppingCartList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addShoppingCartListener();
    }

    private void addShoppingCartListener() {
        shoppingCartList.setCellFactory(shoppingCartList -> new ListCell<Product>() {
            //TODO
        });
    }
}
