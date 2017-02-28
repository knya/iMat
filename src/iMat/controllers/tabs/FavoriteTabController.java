package iMat.controllers.tabs;

import iMat.cells.FavoriteProductCell;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import se.chalmers.ait.dat215.project.Product;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Johan on 2017-02-28.
 */
public class FavoriteTabController implements Initializable {

    @FXML private ListView<Product> favoriteProductList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {



//        favoriteProductList.setItems();
        favoriteProductList.setCellFactory(favoriteProductList -> new FavoriteProductCell());
    }
}
