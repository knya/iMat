package iMat.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML private AnchorPane search;
    @FXML private AnchorPane filter;
    @FXML private AnchorPane feature;
    @FXML private AnchorPane shoppingCart;

    @FXML private SearchController searchController;
    @FXML private ShoppingCartController shoppingCartController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        searchController.injectMainController(this);
        shoppingCartController.injectMainController(this);
    }
}
