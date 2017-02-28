package iMat.cells;

import iMat.controllers.cells.ICellController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import se.chalmers.ait.dat215.project.Product;

import java.io.IOException;

/**
 * Created by Johan on 2017-02-28.
 */
public class FavoriteProductCell extends ListCell<Product> {

    private FXMLLoader fxmlLoader;

    private ICellController cellController;

    public FavoriteProductCell() {
        if (fxmlLoader == null) {
            fxmlLoader = new FXMLLoader(getClass().getResource("/iMat/fxmls/cells/FavoriteProductCell.fxml"));

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

        if (empty || product == null) {
            setGraphic(null);
        } else {
            setGraphic(cellController.getAnchorPane());
            cellController.inject(product);
            cellController.setLabels();
        }
    }
}
