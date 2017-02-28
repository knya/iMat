package iMat.controllers.cells;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for ProductCells in Shop tab.
 */
public class ShopProductCellController extends AbstractCellController {

    @FXML private Label productNameLabel;
    @FXML private Label productPriceLabel;
    @FXML private ImageView productImageView;
    @FXML private AnchorPane shopProductCellPane;
    @FXML private Button addToCartButton;
    @FXML private Button addToFavoritesButton;
    @FXML private ImageView favoriteButtonImage;

    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();
    private ShoppingCart shoppingCart = dataHandler.getShoppingCart();

    private Image fullStar = new Image("/iMat/Images/FullStar.png");
    private Image emptyStar = new Image("/iMat/Images/EmptyStar.png");

    private Product product;

    public void setLabels() {
        productNameLabel.setText(product.getName());
        productImageView.setImage(dataHandler.getFXImage(product));
        productPriceLabel.setText(String.valueOf(product.getPrice()) + ":-");

        if (dataHandler.isFavorite(product)) {
            favoriteButtonImage.setImage(fullStar);
        } else {
            favoriteButtonImage.setImage(emptyStar);
        }

        if (getProductsInShoppingCart().contains(product)) {
            addToCartButton.setDisable(true);
        } else {
            addToCartButton.setDisable(false);
        }
    }

    public AnchorPane getAnchorPane() {
        return shopProductCellPane;
    }

    public void inject(Product product) {
        this.product = product;
    }

    @FXML
    private void addToCartActionPerformed(ActionEvent event) {
        shoppingCart.addProduct(product);
        addToCartButton.setDisable(true);

//        if (getProductsInShoppingCart().contains(product)) {
//            addToCartButton.setDisable(false);
//        } else {
//            shoppingCart.addProduct(product);
//            addToCartButton.setDisable(true);
//        }
    }

    @FXML
    private void addToFavoritesActionPerformed(ActionEvent event) {
        if (!dataHandler.isFavorite(product)) {
            dataHandler.addFavorite(product);
            favoriteButtonImage.setImage(fullStar);
        } else {
            dataHandler.removeFavorite(product);
            favoriteButtonImage.setImage(emptyStar);
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
