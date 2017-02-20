package iMat.controllers.tabs;

import iMat.controllers.MainController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for Home tab
 */
public class HomeTabController implements Initializable {

    private MainController mainController;

    @FXML private Label kampanjLabel;

    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
