package iMat.controllers.cells;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.ProductCategory;

import java.util.List;


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
        nameLabel.setText("hej");
    }

    public void inject(List<ProductCategory> productCategoryList) {
        this.productCategoryList = productCategoryList;
    }
}
