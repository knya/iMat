package iMat.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller for search function.
 */
public class SearchController implements Initializable {

    private MainController mainController;

    private IMatDataHandler dataHandler;
    private String searchText;
    private List<Product> productList;

    @FXML private TextField searchTextField;
    @FXML private Button searchButton;

    protected void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

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
        productList = dataHandler.findProducts(searchText);
    }
}
