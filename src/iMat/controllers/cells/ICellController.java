package iMat.controllers.cells;

import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Johan on 2017-02-23.
 */
public interface ICellController extends Initializable {
    AnchorPane getAnchorPane();
    void setLabels();

    void inject(ProductCategory productCategory);
    void inject(ShoppingItem shoppingItem);
//    void inject(Product product);


}
