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
    @FXML private Label productAmountLabel;
    @FXML private ImageView productImageView;
    @FXML private AnchorPane shopProductCellPane;
    @FXML private Button addToCartButton;
    @FXML private Button addToFavoritesButton;
    @FXML private Button increaseButton;
    @FXML private Button decreaseButton;
    @FXML private ImageView favoriteButtonImage;

    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();
    private ShoppingCart shoppingCart = dataHandler.getShoppingCart();

    private Image fullStar = new Image("/iMat/Images/FullStar.png");
    private Image emptyStar = new Image("/iMat/Images/EmptyStar.png");

    private Product product;
    private double quantity = 1.0;

    public void setLabels() {
        productNameLabel.setText(product.getName());
        productImageView.setImage(dataHandler.getFXImage(product));
        productPriceLabel.setText(String.valueOf(product.getPrice()) + ":-");
        productAmountLabel.setText(String.valueOf(1.0));

        if (dataHandler.isFavorite(product)) {
            favoriteButtonImage.setImage(fullStar);
        } else {
            favoriteButtonImage.setImage(emptyStar);
        }

        if (getProductsInShoppingCart().contains(product)) {
            disableButtons(true);
        } else {
            disableButtons(false);
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
        shoppingCart.addProduct(product, quantity);
        productAmountLabel.setText(String.valueOf(1.0));
        disableButtons(true);
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

    @FXML
    private void increaseButtonActionPerformed(ActionEvent event) {
        quantity = quantity + 1.0;
        productAmountLabel.setText(String.valueOf(quantity));
    }

    @FXML
    private void decreaseButtonActionPerformed(ActionEvent event) {
        if(quantity > 1.0) {
            quantity = quantity - 1;
        }
        productAmountLabel.setText(String.valueOf(quantity));
    }

    private void disableButtons(boolean b) {
        addToCartButton.setDisable(b);
        increaseButton.setDisable(b);
        decreaseButton.setDisable(b);
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
