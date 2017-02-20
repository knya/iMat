package iMat.cells;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.io.IOException;

/**
 * Created by Johan on 2017-02-20.
 */
public class ShoppingItemCell extends ListCell<ShoppingItem> {

    @FXML private Label nameLabel;
    @FXML private Button removeButton;
    @FXML private AnchorPane cellAnchorPane;

    private FXMLLoader fxmlLoader;

    @Override
    protected void updateItem(ShoppingItem shoppingItem, boolean empty) {

        super.updateItem(shoppingItem, empty);

        if(empty || shoppingItem == null) {
            setText(null);
            setGraphic(null);
        } else {

            /*
            if (fxmlLoader == null) {
                fxmlLoader = new FXMLLoader(getClass().getResource("fxmls/ShoppingItemCell.fxml"));
                fxmlLoader.setController(this);

                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            */

            nameLabel.setText(String.valueOf(shoppingItem.getProduct().getName()));

            setGraphic(cellAnchorPane);
        }
    }
}
