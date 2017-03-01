package iMat.controllers.cells;

import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Abstract class for Cell Controllers
 */
public abstract class AbstractCellController implements ICellController {

    private ICellController cellController;

    private List<ProductCategory> productCategoryList;
    private ShoppingItem shoppingItem;
    private Product product;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public abstract AnchorPane getAnchorPane();

    @Override
    public abstract void setLabels();

    @Override
    public void inject(List<ProductCategory> productCategoryList) {
        this.productCategoryList = productCategoryList;
    }

    @Override
    public void inject(ShoppingItem shoppingItem) {
        this.shoppingItem = shoppingItem;
    }

    @Override
    public void inject(Product product) {
        this.product = product;
    }
}
