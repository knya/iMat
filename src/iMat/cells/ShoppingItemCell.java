package iMat.cells;

import iMat.controllers.cells.ICellController;
import iMat.controllers.cells.ShoppingItemCellController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.io.IOException;

/**
 * Cell for ShoppingItem in ShoppingCart
 */
public class ShoppingItemCell extends ListCell<ShoppingItem> {

    private ICellController cellController;

    private FXMLLoader fxmlLoader;


    public ShoppingItemCell() {
        if (fxmlLoader == null) {
            fxmlLoader = new FXMLLoader(getClass().getResource("/iMat/fxmls/cells/ShoppingItemCell.fxml"));

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
