package iMat.controllers;


import iMat.controllers.HomeTabController;
import iMat.controllers.ShopTabController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Tab controller for Feature pane.
 */


public class FeatureTabController implements Initializable {

    @FXML private AnchorPane homeTab;
    @FXML private AnchorPane shopTab;

    private MainController mainController;

    @FXML private HomeTabController homeTabController;
    @FXML private ShopTabController shopTabController;

    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        homeTabController.injectTabController(this);
//        shopTabController.injectTabController(this);
    }
}
