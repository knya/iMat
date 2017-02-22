package iMat.cells;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.CartEvent;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.ShoppingCartListener;
import se.chalmers.ait.dat215.project.ShoppingItem;

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

    private ListView<ShoppingItem> shoppingItemListView;

    private IMatDataHandler dataHandler;

    private FXMLLoader fxmlLoader;

    public ShoppingItemCell(ListView<ShoppingItem> shoppingItemListView) {
        dataHandler = IMatDataHandler.getInstance();
        this.shoppingItemListView = shoppingItemListView;

        if (fxmlLoader == null) {
            fxmlLoader = new FXMLLoader(getClass().getResource("/iMat/fxmls/ShoppingItemCell.fxml"));
            fxmlLoader.setController(this);

            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        shoppingCartController = fxmlLoader.getController();
    }

    @Override
    protected void updateItem(ShoppingItem shoppingItem, boolean empty) {

        super.updateItem(shoppingItem, empty);

        if(empty || shoppingItem == null) {
            setGraphic(null);
        } else {
            setLabels(shoppingItem);
            setGraphic(shoppingItemPane);

            addButtonEventHandlers(shoppingItem);

//            shoppingItemCellController.setLabels(shoppingItem);
//            setGraphic(shoppingItemCellController.getAnchorPane());
        }
    }

    private void addButtonEventHandlers(ShoppingItem shoppingItem) {
        removeButtonEventHandler(shoppingItem);
        increaseQuantityEventHandler(shoppingItem);
        decreaseQuantityEventHandler(shoppingItem);
    }

    private void setLabels(ShoppingItem shoppingItem) {
        nameLabel.setText(shoppingItem.getProduct().getName());
        amountLabel.setText(String.valueOf(shoppingItem.getAmount()));
    }

    private void removeButtonEventHandler(ShoppingItem shoppingItem) {
        removeButton.addEventHandler(ActionEvent.ACTION, e -> {
            shoppingItemListView.getItems().remove(shoppingItem);
            dataHandler.getShoppingCart().removeItem(shoppingItem);
        });
    }

    private void increaseQuantityEventHandler(ShoppingItem shoppingItem) {
        increaseButton.addEventHandler(ActionEvent.ACTION, e -> {
            shoppingItem.setAmount(shoppingItem.getAmount() + 1);
            amountLabel.setText(String.valueOf(shoppingItem.getAmount()));
        });
    }

    private void decreaseQuantityEventHandler(ShoppingItem shoppingItem) {
        decreaseButton.addEventHandler(ActionEvent.ACTION, e -> {
            if (shoppingItem.getAmount() > 1.0) {
                shoppingItem.setAmount(shoppingItem.getAmount() - 1);
            }
            amountLabel.setText(String.valueOf(shoppingItem.getAmount()));
        });
    }


//    @FXML
//    protected void removeButtonActionPerformed(CartEvent event) {
//        dataHandler.getShoppingCart().removeItem(event.getShoppingItem());
//        System.out.println(dataHandler.getShoppingCart().getItems().size());
//        dataHandler.getShoppingCart().removeItem(0);
//        System.out.println(dataHandler.getShoppingCart().getItems().size());
//    }


}
