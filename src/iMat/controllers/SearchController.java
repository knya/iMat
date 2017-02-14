package iMat.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by Johan on 2017-02-14.
 */
public class SearchController {

    private MainController mainController;

    @FXML private TextField searchTextField;
    @FXML private Button searchButton;

    public void init(MainController mainController) {
        this.mainController = mainController;
    }
}
