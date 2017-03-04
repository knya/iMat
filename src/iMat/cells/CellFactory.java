package iMat.cells;

import javafx.scene.control.ListCell;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.util.List;

/**
 * Created by JOHAN on 2017-03-04.
 */
public class CellFactory {

    public ListCell<ShoppingItem> createOrderCartCell() {
        return new OrderCartCell();
    }

    public ListCell<List<ProductCategory>> createProductCategoryCell() {
        return new ProductCategoryCell();
    }

    public ListCell<Product> createShopProductCell() {
        return new ShopProductCell();
    }
}
