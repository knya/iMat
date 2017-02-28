package iMat.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML private AnchorPane search;
    @FXML private AnchorPane categories;
    @FXML private TabPane tab;
    @FXML private AnchorPane shopping;
    @FXML private AnchorPane tabsAnchorPane;

    @FXML private SearchController searchController;
    @FXML private ShoppingCartController shoppingCartController;
    @FXML private TabController tabController;
    @FXML private CategoriesController categoriesController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        searchController.injectMainController(this);
        shoppingCartController.injectMainController(this);
        tabController.injectMainController(this);
        categoriesController.injectMainController(this);
        search.setMinHeight(100);
        search.setMaxHeight(100);
        categories.setMinWidth(250);
        categories.setMaxWidth(250);
        shopping.setMinWidth(250);
        shopping.setMaxWidth(250);
        tabsAnchorPane.setMinSize(524,608);
    }

    public TabController getTabController() {
        return tabController;
    }

    public TabPane getTabPane() {
        return tab;
    }

}
