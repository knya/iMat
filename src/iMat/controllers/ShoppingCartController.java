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
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller for shopping cart.
 */
public class ShoppingCartController implements Initializable {

    private MainController mainController;
    private ShoppingItemCellController shoppingItemCellController;

    @FXML private ListView<ShoppingItem> shoppingItemListView;
    @FXML private Button goToCartButton;
    @FXML private Label totalLabel;


    private ObservableList<ShoppingItem> shoppingItemObservableList;

    private ShoppingCart shoppingCart;
    private IMatDataHandler dataHandler;
    private Image shoppingCartImage = new Image("/iMat/Images/ShoppingCart.png");

    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    synchronized public void initialize(URL location, ResourceBundle resources) {
        dataHandler = IMatDataHandler.getInstance();
        shoppingCart = dataHandler.getShoppingCart();
        goToCartButton.setGraphic(new ImageView(shoppingCartImage));

        shoppingCart.addProduct(dataHandler.getProduct(1));
        shoppingCart.addProduct(dataHandler.getProduct(2));
        shoppingCart.addProduct(dataHandler.getProduct(3));

        totalLabel.setText(String.valueOf(shoppingCart.getTotal()) + ":-");


        shoppingItemListView.setItems(refreshItemListView());
        shoppingItemListView.setCellFactory(shoppingItemListView -> new ShoppingItemCell());

        shoppingCart.addShoppingCartListener(cartEvent -> {
            totalLabel.setText(String.valueOf(shoppingCart.getTotal()) + ":-");
            shoppingItemListView.setItems(refreshItemListView());
        });
    }

    private ObservableList<ShoppingItem> refreshItemListView() {
        ObservableList<ShoppingItem> shoppingItemObservableList = FXCollections.observableArrayList();
        shoppingItemObservableList.addAll(shoppingCart.getItems());

        return shoppingItemObservableList;
    }

    @FXML
    private void goToCartActionPerformed(ActionEvent event) {
        mainController.getTabPane().getSelectionModel().select(3);
    }
}
