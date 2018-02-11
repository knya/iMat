package iMat.controllers;


import iMat.controllers.tabs.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import sun.plugin.javascript.navig.Anchor;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Tab controller for Tab pane.
 */
public class TabController implements Initializable {

    @FXML private AnchorPane shopTab;
    @FXML private AnchorPane myPagesTab;
    @FXML private AnchorPane orderTab;
    @FXML private AnchorPane searchTab;
    @FXML private AnchorPane orderHistoryTab;

    @FXML private Tab search;
    @FXML private Tab orderHistory;

    private MainController mainController;

    @FXML private ShopTabController shopTabController;
    @FXML private MyPagesTabController myPagesTabController;
    @FXML private OrderTabController orderTabController;
    @FXML private SearchTabController searchTabController;
    @FXML private OrderHistoryTabController orderHistoryTabController;


    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        shopTabController.inject(this);
        myPagesTabController.inject(this);
        orderTabController.inject(this);
        searchTabController.inject(this);
        orderHistoryTabController.inject(this);
    }

    public ShopTabController getShopTabController() {
        return shopTabController;
    }

    public SearchTabController getSearchTabController() {
        return searchTabController;
    }

    public Tab getSearchTab() {
        return search;
    }

    public Tab getOrderHistoryTab() {
        return orderHistory;
    }
}
