package iMat.controllers;

import iMat.cells.ProductCategoryCell;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import se.chalmers.ait.dat215.project.ProductCategory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static se.chalmers.ait.dat215.project.ProductCategory.*;

/**
 * Controller for ProductCategory
 */
public class CategoriesController implements Initializable {

    @FXML private ListView<List<ProductCategory>> productCategoryListView;
    private ObservableList<List<ProductCategory>> productCategoryListObservableList;

    private MainController mainController;

    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        List<ProductCategory> fruitCategory = new ArrayList<>();
        fruitCategory.add(CITRUS_FRUIT);
        fruitCategory.add(EXOTIC_FRUIT);

        productCategoryListObservableList = FXCollections.observableArrayList();
        productCategoryListObservableList.add(fruitCategory);

        productCategoryListView.setItems(productCategoryListObservableList);
        productCategoryListView.setCellFactory(productCategoryListView -> new ProductCategoryCell());

        productCategoryListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<List<ProductCategory>>() {
            @Override
            public void changed(ObservableValue<? extends List<ProductCategory>> observable, List<ProductCategory> oldValue, List<ProductCategory> newValue) {
                if (newValue != null) {
                    mainController.getTabController().getShopTabController().setProductCategoryObservableList(newValue);
                    mainController.getTabPane().getSelectionModel().select(1);
                }
            }
        });
    }
}