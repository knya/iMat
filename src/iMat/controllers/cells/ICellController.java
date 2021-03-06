package iMat.controllers.cells;

import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.util.List;

/**
 * Interface for Cell Controllers.
 */
public interface ICellController extends Initializable {
    AnchorPane getAnchorPane();
    void setLabels();

    void inject(List<ProductCategory> productCategoryList);
    void inject(ShoppingItem shoppingItem);
    void inject(Product product);
}
