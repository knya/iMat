package iMat.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import se.chalmers.ait.dat215.project.IMatDataHandler;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Search controller for search function.
 */
public class SearchController implements Initializable {

    private IMatDataHandler dataHandler;
    private String searchText;

    @FXML private TextField searchTextField;
    @FXML private Button searchButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dataHandler = IMatDataHandler.getInstance();
        addSearchInputListener();
    }

    private void addSearchInputListener() {
        searchTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null && !newValue.isEmpty()) {
                    searchText = newValue;
                }
            }
        });
    }

    @FXML
    private void searchButtonActionPerformed(ActionEvent event){
        dataHandler.findProducts(searchText);
    }
}
