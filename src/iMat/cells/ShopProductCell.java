package iMat.cells;

import iMat.controllers.cells.ICellController;
import iMat.controllers.cells.ShopProductCellController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import se.chalmers.ait.dat215.project.Product;

import java.io.IOException;

/**
 * Created by Johan on 2017-02-22.
 */
public class ShopProductCell extends ListCell<Product> {

    private ICellController cellController;
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
        cellController = fxmlLoader.getController();
    }

    @Override
    protected void updateItem(Product product, boolean empty) {
        super.updateItem(product, empty);

        if(empty || product == null) {
            setGraphic(null);
        } else {
            setGraphic(cellController.getAnchorPane());
            cellController.inject(product);
            cellController.setLabels();
        }
    }
}
