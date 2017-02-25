package iMat.controllers.tabs;

import iMat.controllers.TabController;
import javafx.fxml.Initializable;
import se.chalmers.ait.dat215.project.IMatDataHandler;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for My Pages tab.
 */
public class MyPagesTabController implements Initializable {

    private TabController tabController;

    private IMatDataHandler dataHandler;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dataHandler = IMatDataHandler.getInstance();
    }

    public void injectTabController(TabController tabController) {
        this.tabController = tabController;
    }
}
