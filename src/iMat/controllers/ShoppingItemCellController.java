package iMat.controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.CartEvent;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Johan on 2017-02-21.
 */

public class ShoppingItemCellController implements Initializable {

    @FXML private Label nameLabel;
    @FXML private Label amountLabel;
    @FXML private Button removeButton;
    @FXML private Button increaseButton;
    @FXML private Button decreaseButton;
    @FXML private AnchorPane shoppingItemPane;

    private IMatDataHandler dataHandler;

    private ShoppingItem shoppingItem;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dataHandler = IMatDataHandler.getInstance();
    }

    public void injectShoppingItem(ShoppingItem shoppingItem) {
        this.shoppingItem = shoppingItem;
    }

    @FXML
    private void removeButtonActionPerformed(ActionEvent event) {
        dataHandler.getShoppingCart().removeItem(shoppingItem);
    }

    @FXML
    private void increaseButtonActionPerformed(ActionEvent event) {
        shoppingItem.setAmount(shoppingItem.getAmount() + 1);
        amountLabel.setText(String.valueOf(shoppingItem.getAmount()));

        notifyShoppingCart(shoppingItem,true);
    }

    @FXML
    private void decreaseButtonActionPerformed(ActionEvent event) {
        if (shoppingItem.getAmount() > 1.0) {
            shoppingItem.setAmount(shoppingItem.getAmount() - 1);
        }
        amountLabel.setText(String.valueOf(shoppingItem.getAmount()));

        notifyShoppingCart(shoppingItem,true);
    }

    public AnchorPane getAnchorPane() {
        return shoppingItemPane;
    }

    public void setLabels(ShoppingItem shoppingItem) {
        nameLabel.setText(shoppingItem.getProduct().getName());
        amountLabel.setText(String.valueOf(shoppingItem.getAmount()));
    }

    private void notifyShoppingCart(ShoppingItem shoppingItem, boolean addEvent) {
        dataHandler.getShoppingCart().fireShoppingCartChanged(shoppingItem, addEvent);
    }
}

