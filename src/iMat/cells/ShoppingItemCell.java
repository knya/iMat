package iMat.cells;

import iMat.controllers.ShoppingItemCellController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.ShoppingCartListener;
import se.chalmers.ait.dat215.project.ShoppingItem;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by Johan on 2017-02-20.
 */
public class ShoppingItemCell extends ListCell<ShoppingItem> {

    @FXML private Label nameLabel;
    @FXML private Label amountLabel;
    @FXML private Button increaseButton;
    @FXML private Button decreaseButton;
    @FXML private Button removeButton;
    @FXML private AnchorPane shoppingItemPane;

//    private ListView<ShoppingItem> shoppingItemListView;
//    private ObservableList<ShoppingItem> shoppingItemObservableList;

    private ShoppingItemCellController shoppingItemCellController;

    private IMatDataHandler dataHandler;

    private FXMLLoader fxmlLoader;

    public ShoppingItemCell() {
        dataHandler = IMatDataHandler.getInstance();

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
