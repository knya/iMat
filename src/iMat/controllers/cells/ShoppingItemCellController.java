package iMat.controllers.cells;

import iMat.Main;
import iMat.controllers.ShoppingCartController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for ShoppingItemCells added to ShoppingCart.
 */

public class ShoppingItemCellController extends AbstractCellController {

    @FXML private Label nameLabel;
    @FXML private Label amountLabel;
    @FXML private Label priceLabel;
    @FXML private Button removeButton;
    @FXML private Button increaseButton;
    @FXML private Button decreaseButton;
    @FXML private AnchorPane shoppingItemPane;

    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();

    private ShoppingItem shoppingItem;

    private Image removeIcon = new Image("/iMat/Images/RemoveIconBlack.png");


    private ShopProductCellController shopProductCellController;

    public void inject(ShoppingItem shoppingItem) {
        this.shoppingItem = shoppingItem;
    }

    public AnchorPane getAnchorPane() {
        return shoppingItemPane;
    }



    @Override
    public void setLabels() {
        nameLabel.setText(shoppingItem.getProduct().getName());
        amountLabel.setText(String.valueOf(shoppingItem.getAmount()) + " " + shoppingItem.getProduct().getUnitSuffix());
        priceLabel.setText(String.valueOf(shoppingItem.getTotal()) + ":-");
        removeButton.setGraphic(new ImageView(removeIcon));
    }

    @FXML
    private void removeButtonActionPerformed(ActionEvent event) {
        dataHandler.getShoppingCart().removeItem(shoppingItem);


    }

    @FXML
    private void increaseButtonActionPerformed(ActionEvent event) {
        shoppingItem.setAmount(shoppingItem.getAmount() + 1);
        setLabels();

        notifyShoppingCart(shoppingItem,false);
    }

    @FXML
    private void decreaseButtonActionPerformed(ActionEvent event) {
        if (shoppingItem.getAmount() > 1.0) {
            shoppingItem.setAmount(shoppingItem.getAmount() - 1);
        }
        setLabels();
        notifyShoppingCart(shoppingItem,false);

    }

    private void notifyShoppingCart(ShoppingItem shoppingItem, boolean addEvent) {
        dataHandler.getShoppingCart().fireShoppingCartChanged(shoppingItem, addEvent);
    }

}

