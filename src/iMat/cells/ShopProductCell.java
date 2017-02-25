package iMat.cells;

import iMat.controllers.cells.ShopProductCellController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import se.chalmers.ait.dat215.project.Product;

import java.io.IOException;

/**
 * Created by Johan on 2017-02-22.
 */
public class ShopProductCell extends ListCell<Product> {

    private ShopProductCellController shopProductCellController;

    private FXMLLoader fxmlLoader;

    public ShopProductCell() {
        if (fxmlLoader == null) {
            fxmlLoader = new FXMLLoader(getClass().getResource("/iMat/fxmls/cells/ShopProductCell.fxml"));
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
