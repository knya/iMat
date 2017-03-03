package iMat.controllers;

import iMat.cells.ShoppingItemCell;
import iMat.controllers.cells.ShoppingItemCellController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import se.chalmers.ait.dat215.project.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller for shopping cart.
 */
public class ShoppingCartController implements Initializable {

    private MainController mainController;

    @FXML private ListView<ShoppingItem> shoppingItemListView;
    @FXML private Button goToCartButton;
    @FXML private Label totalLabel;

    private ObservableList<ShoppingItem> shoppingItemObservableList;

    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();;
    private Image shoppingCartImage = new Image("/iMat/Images/ShoppingCart.png");

    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dataHandler = IMatDataHandler.getInstance();
        goToCartButton.setGraphic(new ImageView(shoppingCartImage));

        dataHandler.getShoppingCart().addProduct(dataHandler.getProduct(1));
        dataHandler.getShoppingCart().addProduct(dataHandler.getProduct(2));
        dataHandler.getShoppingCart().addProduct(dataHandler.getProduct(3));

        totalLabel.setText(String.valueOf(dataHandler.getShoppingCart().getTotal()) + ":-");


        shoppingItemListView.setItems(refreshItemListView());
        shoppingItemListView.setCellFactory(shoppingItemListView -> new ShoppingItemCell());

        dataHandler.getShoppingCart().addShoppingCartListener(cartEvent -> {
            totalLabel.setText(String.valueOf(dataHandler.getShoppingCart().getTotal()) + ":-");
            shoppingItemListView.setItems(refreshItemListView());
            shoppingItemListView.refresh();
        });
    }

    private ObservableList<ShoppingItem> refreshItemListView() {
        ObservableList<ShoppingItem> shoppingItemObservableList = FXCollections.observableArrayList();
        shoppingItemObservableList.addAll(dataHandler.getShoppingCart().getItems());

        return shoppingItemObservableList;
    }

    @FXML
    private void goToCartActionPerformed(ActionEvent event) {
        mainController.getTabPane().getSelectionModel().select(3);
    }
}
