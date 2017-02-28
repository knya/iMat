package iMat.controllers.cells;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 * Created by Johan on 2017-02-28.
 */
public class ShoppingItemCartCellController extends AbstractCellController {

    @FXML private Label nameLabel;
    @FXML private AnchorPane shoppingItemCellPane;

    private ShoppingItem shoppingItem;

    public void inject(ShoppingItem shoppingItem) {
        this.shoppingItem = shoppingItem;
    }

    public AnchorPane getAnchorPane() {
        return shoppingItemCellPane;
    }

    public void setLabels() {
        nameLabel.setText(shoppingItem.getProduct().getName());
    }
}
