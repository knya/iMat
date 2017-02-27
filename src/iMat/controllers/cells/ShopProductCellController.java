package iMat.controllers.cells;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.ShoppingItem;

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

    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();
    private ShoppingCart shoppingCart = dataHandler.getShoppingCart();

    private Product product;

    public void setLabels() {
        productNameLabel.setText(product.getName());
        productImageView.setImage(dataHandler.getFXImage(product));
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
