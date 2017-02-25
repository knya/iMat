package iMat.cells;

import javafx.scene.control.ListCell;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 * Created by Johan on 2017-02-23.
 */
public interface ICell {
//    void updateItem(T t, boolean empty);
    void updateItem(ProductCategory productCategory, boolean empty);
    void updateItem(ShoppingItem shoppingItem, boolean empty);
    void updateItem(Product product, boolean empty);
}
