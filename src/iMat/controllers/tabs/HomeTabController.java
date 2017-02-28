package iMat.controllers.tabs;

import iMat.controllers.TabController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for Home tab
 */
public class HomeTabController implements Initializable {

    private TabController tabController;

    @FXML private Label kampanjLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        kampanjLabel.setText("Hem");
    }

    public void injectTabController(TabController tabController) {
        this.tabController = tabController;
    }
}
