package iMat.controllers;


import iMat.controllers.tabs.HomeTabController;
import iMat.controllers.tabs.MyPagesTabController;
import iMat.controllers.tabs.ShopTabController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.Customer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Tab controller for Feature pane.
 */


public class TabController implements Initializable {

    @FXML private AnchorPane homeTab;
    @FXML private AnchorPane shopTab;
    @FXML private AnchorPane myPagesTab;

    private MainController mainController;

    @FXML private HomeTabController homeTabController;
    @FXML private ShopTabController shopTabController;
    @FXML private MyPagesTabController myPagesTabController;








    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        homeTabController.injectTabController(this);
        shopTabController.injectTabController(this);
        myPagesTabController.injectTabController(this);


    }

    public ShopTabController getShopTabController() {
        return shopTabController;
    }







}
