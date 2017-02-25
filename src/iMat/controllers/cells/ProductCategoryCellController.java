package iMat.controllers.cells;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Johan on 2017-02-23.
 */
public class ProductCategoryCellController extends AbstractCellController {

    @FXML private AnchorPane productCategoryCellPane;
    @FXML private Label nameLabel;

    private IMatDataHandler dataHandler;

    private ProductCategory productCategory;
    private ShoppingItem shoppingItem;
    private Product product;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dataHandler = IMatDataHandler.getInstance();
    }

//    public void setLabels(ProductCategory productCategory) {
//        nameLabel.setText(String.valueOf(productCategory));
//    }

//    public void injectProductCategory(ProductCategory productCategory) {
//        this.productCategory = productCategory;
//    }

    public AnchorPane getAnchorPane() {
        return productCategoryCellPane;
    }

    @Override
    public void setLabels() {
        nameLabel.setText(String.valueOf(getProductCategoryCell()));
    }
}
