package iMat.cells;


import iMat.controllers.cells.ICellController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.io.IOException;

/**
 * Created by Johan on 2017-02-23.
 */
public abstract class AbstractCell extends ListCell implements ICell {

    private ICellController cellController;

    private FXMLLoader fxmlLoader;

    /*
    @Override
    public void updateItem(T t, boolean empty) {

    }
    */


    /*
    public void updateItem(ProductCategory cell, boolean empty) {
        super.updateItem(cell, empty);

        if(empty || cell == null) {
            setGraphic(null);
        } else {
            setGraphic(cellController.getAnchorPane());
            cellController.inject(cell);
        }
    }

    public void updateItem(ShoppingItem cell, boolean empty) {
        super.updateItem(cell, empty);

        if(empty || cell == null) {
            setGraphic(null);
        } else {
            setGraphic(cellController.getAnchorPane());
            cellController.inject(cell);
        }
    }

    public void updateItem(Product cell, boolean empty) {
        super.updateItem(cell, empty);

        if(empty || cell == null) {
            setGraphic(null);
        } else {
            setGraphic(cellController.getAnchorPane());
            cellController.inject(cell);
        }
    }
    */
}
