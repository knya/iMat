package iMat.cells;

import iMat.controllers.cells.ShopProductCellController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Johan on 2017-02-22.
 */
public class ShopProductCell extends ListCell<Product> {

    private ShopProductCellController shopProductCellController;

    private FXMLLoader fxmlLoader;

    public ShopProductCell() {
        if (fxmlLoader == null) {
            fxmlLoader = new FXMLLoader(getClass().getResource("/iMat/fxmls/ShopProductCell.fxml"));
//            fxmlLoader.setController(this);

            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        shopProductCellController = fxmlLoader.getController();
    }

    @Override
    protected void updateItem(Product product, boolean empty) {
        super.updateItem(product, empty);

        if(empty || product == null) {
            setGraphic(null);
        } else {
            setGraphic(shopProductCellController.getAnchorPane());
            shopProductCellController.injectProduct(product);
            shopProductCellController.setLabels(product);
        }

    }
}
