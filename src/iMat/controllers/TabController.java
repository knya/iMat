package iMat.controllers;


import iMat.controllers.tabs.HomeTabController;
import iMat.controllers.tabs.MyPagesTabController;
import iMat.controllers.tabs.ShopTabController;
import iMat.controllers.tabs.OrderTabController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Tab controller for Tab pane.
 */
public class TabController implements Initializable {

    @FXML private AnchorPane homeTab;
    @FXML private AnchorPane shopTab;
    @FXML private AnchorPane myPagesTab;
    @FXML private AnchorPane shoppingCartTab;

    private MainController mainController;

    @FXML private HomeTabController homeTabController;
    @FXML private ShopTabController shopTabController;
    @FXML private MyPagesTabController myPagesTabController;
    @FXML private OrderTabController orderTabController;


    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        homeTabController.inject(this);
        shopTabController.inject(this);
        myPagesTabController.inject(this);
        orderTabController.inject(this);
    }

    public ShopTabController getShopTabController() {
        return shopTabController;
    }
}
