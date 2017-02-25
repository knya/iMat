package iMat.controllers.cells;

import iMat.cells.ICell;
import iMat.cells.ProductCategoryCell;
import iMat.cells.ShopProductCell;
import iMat.cells.ShoppingItemCell;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Johan on 2017-02-23.
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

    @Override
    public ProductCategory getProductCategoryCell() {
        return productCategory;
    }

    @Override
    public ShoppingItem getShoppingItemCell() {
        return shoppingItem;
    }

    @Override
    public Product getProductCell() {
        return product;
    }
}
