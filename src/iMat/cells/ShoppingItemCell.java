package iMat.cells;

import iMat.controllers.cells.ShoppingItemCellController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import se.chalmers.ait.dat215.project.ShoppingItem;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by Johan on 2017-02-20.
 */
public class ShoppingItemCell extends ListCell<ShoppingItem> {

//    private ListView<ShoppingItem> shoppingItemListView;
//    private ObservableList<ShoppingItem> shoppingItemObservableList;

    private ShoppingItemCellController shoppingItemCellController;

    private FXMLLoader fxmlLoader;

    public ShoppingItemCell() {
        if (fxmlLoader == null) {
            fxmlLoader = new FXMLLoader(getClass().getResource("/iMat/fxmls/ShoppingItemCell.fxml"));
//            fxmlLoader.setController(this);

            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        shoppingItemCellController = fxmlLoader.getController();
    }

    @Override
    protected void updateItem(ShoppingItem shoppingItem, boolean empty) {

        super.updateItem(shoppingItem, empty);

        if(empty || shoppingItem == null) {
            setGraphic(null);
        } else {
            setGraphic(shoppingItemCellController.getAnchorPane());
            shoppingItemCellController.setLabels(shoppingItem);
            shoppingItemCellController.injectShoppingItem(shoppingItem);
//            shoppingItemCellController.setLabels(shoppingItem);
//            shoppingItemCellController.addButtonEventHandlers(shoppingItem);

//            addButtonEventHandlers(shoppingItem);
        }
    }
}
