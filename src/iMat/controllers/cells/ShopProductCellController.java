package iMat.controllers.cells;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for ProductCells in Shop tab.
 */
public class ShopProductCellController extends AbstractCellController {

    @FXML private Label productNameLabel;
    @FXML private ImageView productImageView;
    @FXML private AnchorPane shopProductCellPane;
    @FXML private Button addToCartButton;
    @FXML private Button addToFavoritesButton;

    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();
    private ShoppingCart shoppingCart = dataHandler.getShoppingCart();

    private Product product;

    public void setLabels() {
        productNameLabel.setText(product.getName());
        productImageView.setImage(dataHandler.getFXImage(product));
        addToFavoritesButton.setGraphic(new ImageView("/Imat/Images/EmptyStar.png"));
    }

    public AnchorPane getAnchorPane() {
        return shopProductCellPane;
    }

    public void inject(Product product) {
        this.product = product;
    }

    @FXML
    private void addToCartActionPerformed(ActionEvent event) {
        if (getProductsInShoppingCart().contains(product)) {
            increaseQuantity(product);
        } else {
            shoppingCart.addProduct(product);
        }
    }

    @FXML
    private void addToFavoritesActionPerformed(ActionEvent event) {
        if (!dataHandler.isFavorite(product)) {
            dataHandler.addFavorite(product);
            addToFavoritesButton.setText("Ta bort från favoriter");
            addToFavoritesButton.setGraphic(new ImageView("/Imat/Images/Fullstar.png"));
        } else {
            dataHandler.removeFavorite(product);
            addToFavoritesButton.setText("Lägg till som favorit");
            addToFavoritesButton.setGraphic(new ImageView(("/Imat/Images/EmptyStar.png")));
        }



    }

    private void increaseQuantity(Product product) {
        shoppingCart.getItems().get(getIndex(product)).setAmount(shoppingCart.getItems().get(getIndex(product)).getAmount() + 1);
    }

    private int getIndex(Product product) {
        int index = 0;
        List<ShoppingItem> shoppingItemList = shoppingCart.getItems();

        for (int i = 0; i < shoppingItemList.size(); i++) {
            if (shoppingItemList.get(i).getProduct().equals(product)) {
                index = i;
            }
        }
        return index;
    }

    private List<Product> getProductsInShoppingCart() {
        List<Product> productList = new ArrayList<>();

        for (ShoppingItem i : shoppingCart.getItems()) {
            productList.add(i.getProduct());
        }
        return productList;
    }
}
