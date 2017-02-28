package iMat.cells;

import iMat.controllers.cells.ICellController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.io.IOException;

/**
 * Created by Johan on 2017-02-28.
 */
public class OrderCartCell extends ListCell<ShoppingItem> {

    private ICellController cellController;

    private FXMLLoader fxmlLoader;

    public OrderCartCell() {
        if (fxmlLoader == null) {
            fxmlLoader = new FXMLLoader(getClass().getResource("/iMat/fxmls/cells/OrderCartCell.fxml"));

            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        cellController = fxmlLoader.getController();
    }

    @Override
    protected void updateItem(ShoppingItem shoppingItem, boolean empty) {

        super.updateItem(shoppingItem, empty);

        if(empty || shoppingItem == null) {
            setGraphic(null);
        } else {
            setGraphic(cellController.getAnchorPane());
            cellController.inject(shoppingItem);
            cellController.setLabels();
        }
    }
}
