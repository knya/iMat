package iMat.controllers.cells;

import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Abstract class for Cell Controllers
 */
public abstract class AbstractCellController implements ICellController {

    private ICellController cellController;

    private ProductCategory productCategory;
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
    public void inject(ProductCategory productCategory) {
        this.productCategory = productCategory;
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
