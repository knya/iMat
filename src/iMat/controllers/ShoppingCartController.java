package iMat.controllers;

import iMat.cells.ShoppingItemCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import se.chalmers.ait.dat215.project.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for shopping cart.
 */
public class ShoppingCartController implements Initializable {

    private MainController mainController;

    @FXML private ListView<ShoppingItem> shoppingItemListView;
    @FXML private Button goToCartButton;
    @FXML private Label totalLabel;
    @FXML private Label numberOfItems;
    @FXML private Button orderHistoryButton;

    private int amount;

    private ObservableList<ShoppingItem> shoppingItemObservableList;

    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();
    private Image shoppingCartImage = new Image("/iMat/Images/ShoppingCart.png");

    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dataHandler = IMatDataHandler.getInstance();
        goToCartButton.setGraphic(new ImageView(shoppingCartImage));

        numberOfItems.setText(String.valueOf(dataHandler.getShoppingCart().getItems().size()));

        totalLabel.setText(String.valueOf(dataHandler.getShoppingCart().getTotal()) + ":-");


        shoppingItemListView.setItems(refreshItemListView());
        shoppingItemListView.setCellFactory(shoppingItemListView -> new ShoppingItemCell());

        dataHandler.getShoppingCart().addShoppingCartListener(cartEvent -> {
            totalLabel.setText(String.valueOf(dataHandler.getShoppingCart().getTotal()) + ":-");

            for (int i = 0; i <dataHandler.getShoppingCart().getItems().size(); i++) {
                amount += dataHandler.getShoppingCart().getItems().get(i).getAmount();
            }

            numberOfItems.setText(String.valueOf((int) amount + " st"));
            shoppingItemListView.setItems(refreshItemListView());
            shoppingItemListView.refresh();
            amount = 0;
        });
    }

    private ObservableList<ShoppingItem> refreshItemListView() {
        ObservableList<ShoppingItem> shoppingItemObservableList = FXCollections.observableArrayList();
        shoppingItemObservableList.addAll(dataHandler.getShoppingCart().getItems());

        return shoppingItemObservableList;
    }

    @FXML
    private void goToCartActionPerformed(ActionEvent event) {
        mainController.getTabPane().getSelectionModel().select(2);
//        mainController.getTabController().getOrderTabController().backToCartActionPerformed(event);
    }

    @FXML
    private void orderHistoryButtonActionPerformed(ActionEvent event) {
        Tab orderHistoryTab = mainController.getTabController().getOrderHistoryTab();
        if (mainController.getTabController().getOrderHistoryTab().isSelected()) {
            mainController.getTabPane().getTabs().remove(3);
        }
        mainController.getTabPane().getTabs().add(orderHistoryTab);
        mainController.getTabPane().getSelectionModel().select(3);
    }
}
