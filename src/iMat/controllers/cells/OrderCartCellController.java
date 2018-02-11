package iMat.controllers.cells;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Johan on 2017-02-28.
 */
public class OrderCartCellController extends AbstractCellController {

    @FXML private Label nameLabel;
    @FXML private Label priceLabel;
    @FXML private Label amountLabel;
    @FXML private Label sumLabel;
    @FXML private AnchorPane shoppingItemCellPane;

    private ShoppingItem shoppingItem;

    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();

    public void inject(ShoppingItem shoppingItem) {
        this.shoppingItem = shoppingItem;
    }

    public AnchorPane getAnchorPane() {
        return shoppingItemCellPane;
    }

    public void setLabels() {
        nameLabel.setText(shoppingItem.getProduct().getName());
        amountLabel.setText(String.valueOf(shoppingItem.getAmount()) + " " + shoppingItem.getProduct().getUnitSuffix());
        priceLabel.setText(String.valueOf(shoppingItem.getProduct().getPrice()));
        sumLabel.setText(String.valueOf(shoppingItem.getTotal()));
    }
}
