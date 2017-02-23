package iMat.controllers;

import iMat.cells.ProductCategoryCell;
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

import static se.chalmers.ait.dat215.project.ProductCategory.FISH;

/**
 * Created by Johan on 2017-02-23.
 */
public class FilterController implements Initializable {

    @FXML private ListView<ProductCategory> productCategoryListView;
    private ObservableList<ProductCategory> productCategoryObservableList;

    private MainController mainController;

    private IMatDataHandler dataHandler;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dataHandler = IMatDataHandler.getInstance();


        productCategoryObservableList = FXCollections.observableArrayList();
        productCategoryObservableList.add(FISH);

        productCategoryListView.setItems(productCategoryObservableList);
        productCategoryListView.setCellFactory(productCategoryListView -> new ProductCategoryCell());
    }
}
