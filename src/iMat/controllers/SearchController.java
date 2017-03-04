package iMat.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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

    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();
    private String searchText;
    private List<Product> productList;

    @FXML private TextField searchTextField;
    @FXML private Button searchButton;

    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
    private void onEnterKeyPressed(KeyEvent key) {
        if(key.getCode().equals(KeyCode.ENTER)) {
            searchForProduct();
        }
    }

    @FXML
    private void searchButtonActionPerformed(ActionEvent event){
        searchForProduct();
    }

    private void searchForProduct() {
        if (searchText == null) {
            productList = dataHandler.findProducts("");
        } else {
            productList = dataHandler.findProducts(searchText);
        }

        mainController.getTabController().getSearchTabController().setProductObservableList(productList);
        Tab searchTab = mainController.getTabController().getSearchTab();
        mainController.getTabPane().getTabs().add(searchTab);
        mainController.getTabPane().getSelectionModel().select(4);
    }
}
