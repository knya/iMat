package iMat.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML private AnchorPane search;
    @FXML private AnchorPane filter;
    @FXML private TabPane feature;
    @FXML private AnchorPane shoppingCart;

    @FXML private SearchController searchController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        searchController.injectMainController(this);
    }
}
