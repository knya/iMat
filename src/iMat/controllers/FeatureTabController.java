package iMat.controllers;

import iMat.controllers.tabs.HomeTabController;
import iMat.controllers.tabs.ShopTabController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Tab controller for Feature pane.
 */
public class FeatureTabController implements Initializable {

    private MainController mainController;

    @FXML private HomeTabController homeTabController;
    @FXML private ShopTabController shopTabController;

    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        homeTabController.injectTabController(this);
    }
}
