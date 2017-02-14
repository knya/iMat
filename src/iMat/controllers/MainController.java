package iMat.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML private SearchController searchController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        searchController.init(this);
    }
}
