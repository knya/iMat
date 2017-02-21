package iMat.cells;

import iMat.controllers.ShoppingCartController;
import iMat.controllers.ShoppingItemCellController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.io.IOException;

/**
 * Created by Johan on 2017-02-20.
 */
public class ShoppingItemCell extends ListCell<ShoppingItem> {

//    @FXML private Label nameLabel;
//    @FXML private Button removeButton;
//    @FXML private AnchorPane shoppingItemPane;

    private ShoppingItemCellController shoppingItemCellController;

    private FXMLLoader fxmlLoader;

    public ShoppingItemCell() {
        if (fxmlLoader == null) {
            fxmlLoader = new FXMLLoader(getClass().getResource("/iMat/fxmls/ShoppingItemCell.fxml"));


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
            shoppingItemCellController.setLabels(shoppingItem);
            setGraphic(shoppingItemCellController.getAnchorPane());
        }
    }

}
