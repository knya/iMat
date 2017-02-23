package iMat.controllers.cells;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.ProductCategory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Johan on 2017-02-23.
 */
public class ProductCategoryCellController implements Initializable {

    @FXML private AnchorPane productCategoryCellPane;
    @FXML private Label nameLabel;

    private IMatDataHandler dataHandler;

    private ProductCategory productCategory;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dataHandler = IMatDataHandler.getInstance();
    }

    public void setLabels(ProductCategory productCategory) {
        nameLabel.setText(String.valueOf(productCategory));
    }

    public void injectProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public AnchorPane getAnchorPane() {
        return productCategoryCellPane;
    }
}
