package iMat.controllers;

import iMat.cells.CellFactory;
import iMat.cells.ProductCategoryCell;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import se.chalmers.ait.dat215.project.ProductCategory;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import static se.chalmers.ait.dat215.project.ProductCategory.*;

/**
 * Controller for ProductCategory
 */
public class CategoriesController implements Initializable {

    @FXML private ListView<List<ProductCategory>> productCategoryListView;
    private ObservableList<List<ProductCategory>> productCategoryListObservableList;

    @FXML private Button escapeHatch;

    private Image Logo = new Image("/Imat/Images/TestLogo.jpg");


    private List<ProductCategory> allCategories = new ArrayList<>(Arrays.asList(
            ProductCategory.values()
    ));

    private List<ProductCategory> fruitAndBerriesCategory = new ArrayList<>(Arrays.asList(
            CITRUS_FRUIT, EXOTIC_FRUIT, MELONS, FRUIT, BERRY
    ));

    private List<ProductCategory> breadCategory = new ArrayList<>(Arrays.asList(
            BREAD
    ));

    private List<ProductCategory> vegetablesCategory = new ArrayList<>(Arrays.asList(
            CABBAGE, VEGETABLE_FRUIT, ROOT_VEGETABLE, HERB, POD
    ));

    private List<ProductCategory> meatCategory = new ArrayList<>(Arrays.asList(
        FISH, MEAT
    ));

    private List<ProductCategory> pantryCategory = new ArrayList<>(Arrays.asList(
            HOT_DRINKS, FLOUR_SUGAR_SALT, NUTS_AND_SEEDS
    ));

    private List<ProductCategory> dairyCategory = new ArrayList<>(Arrays.asList(
            DAIRIES
    ));

    private List<ProductCategory> drinksCategory = new ArrayList<>(Arrays.asList(
            COLD_DRINKS
    ));

    private List<ProductCategory> sweetsCategory = new ArrayList<>(Arrays.asList(
            SWEET
    ));

    private List<ProductCategory> carbsCategory = new ArrayList<>(Arrays.asList(
                PASTA, POTATO_RICE
    ));

    private MainController mainController;

    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        productCategoryListObservableList = FXCollections.observableArrayList();
        productCategoryListObservableList.addAll(
                allCategories, fruitAndBerriesCategory, breadCategory, vegetablesCategory,
                meatCategory, pantryCategory, dairyCategory, drinksCategory, sweetsCategory,
                carbsCategory
        );

        escapeHatch.setGraphic(new ImageView(Logo));
//        escapeHatch.setMaxWidth(Logo.getWidth());
//        escapeHatch.setMaxHeight((Logo.getHeight()));

        productCategoryListView.setItems(productCategoryListObservableList);
        productCategoryListView.setCellFactory(productCategoryListView -> new CellFactory().createProductCategoryCell());

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

    @FXML
    protected void escapeHatchActionPerformed(ActionEvent event) {
        //TODO
    }
}