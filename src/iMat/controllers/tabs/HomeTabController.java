package iMat.controllers.tabs;

import iMat.controllers.FeatureTabController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for Home tab
 */
public class HomeTabController implements Initializable {

    private FeatureTabController featureTabController;

    @FXML private Label kampanjLabel;

    public void injectTabController(FeatureTabController featureTabController) {
        this.featureTabController = featureTabController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        kampanjLabel.setText("testar");
    }
}
