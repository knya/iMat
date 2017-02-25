package iMat.controllers;

import iMat.cells.ProductCategoryCell;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;

import java.net.URL;
import java.util.ResourceBundle;

import static se.chalmers.ait.dat215.project.ProductCategory.BREAD;
import static se.chalmers.ait.dat215.project.ProductCategory.FISH;

/**
 * Controller for ProductCategory
 */
public class CategoriesController implements Initializable {

    @FXML private ListView<ProductCategory> productCategoryListView;
    private ObservableList<ProductCategory> productCategoryObservableList;

    private MainController mainController;

    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        productCategoryObservableList = FXCollections.observableArrayList();

        productCategoryObservableList.addAll(ProductCategory.values());

        productCategoryListView.setItems(productCategoryObservableList);
        productCategoryListView.setCellFactory(productCategoryListView -> new ProductCategoryCell());

        productCategoryListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ProductCategory>() {
            @Override
            public void changed(ObservableValue<? extends ProductCategory> observable, ProductCategory oldValue, ProductCategory newValue) {
                if (newValue != null) {
                    mainController.getTabController().getShopTabController().setProductObservableList(newValue);
                    mainController.getTabPane().getSelectionModel().select(1);
                }
            }
        });
    }
}
