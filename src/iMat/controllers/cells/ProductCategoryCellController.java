package iMat.controllers.cells;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.ProductCategory;

import java.util.List;

import static se.chalmers.ait.dat215.project.ProductCategory.*;


/**
 * Created by Johan on 2017-02-23.
 */
public class ProductCategoryCellController extends AbstractCellController {

    @FXML private AnchorPane productCategoryCellPane;
    @FXML private Label nameLabel;

    private List<ProductCategory> productCategoryList;

    public AnchorPane getAnchorPane() {
        return productCategoryCellPane;
    }

    public void setLabels() {
            if (productCategoryList.get(0) == POD) {
                nameLabel.setText("Alla produkter");
            }

            if (productCategoryList.get(0) == CITRUS_FRUIT) {
                nameLabel.setText("Frukt och bär");
            }

            if (productCategoryList.get(0) == BREAD) {
                nameLabel.setText("Bröd");
            }

            if (productCategoryList.get(0) == CABBAGE) {
                nameLabel.setText("Grönsaker");
            }

            if (productCategoryList.get(0) == FISH) {
                nameLabel.setText("Kött och fisk");
            }

            if (productCategoryList.get(0) == HOT_DRINKS) {
                nameLabel.setText("Skafferi");
            }

            if (productCategoryList.get(0) == DAIRIES) {
                nameLabel.setText("Mjölkprodukter");
            }

            if (productCategoryList.get(0) == COLD_DRINKS) {
                nameLabel.setText("Drycker");
            }

            if (productCategoryList.get(0) == SWEET) {
                nameLabel.setText("Godis");
            }

            if (productCategoryList.get(0) == PASTA) {
                nameLabel.setText("Pasta/Ris/Potatis");
            }
    }

    public void inject(List<ProductCategory> productCategoryList) {
        this.productCategoryList = productCategoryList;
    }

}
