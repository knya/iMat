package iMat.controllers.cells;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller for ProductCells in Shop tab.
 */
public class ShopProductCellController implements Initializable {

    @FXML private Label productNameLabel;
    @FXML private ImageView productImageView;
    @FXML private AnchorPane shopProductCellPane;

    @FXML private Button addToCartButton;

    private ShoppingItemCellController shoppingItemCellController;

    private IMatDataHandler dataHandler;
    private ShoppingCart shoppingCart;
    private ShoppingItem shoppingItem;

    private Product product;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dataHandler = IMatDataHandler.getInstance();
        shoppingCart = dataHandler.getShoppingCart();
    }

    public void injectProduct(Product product) {
        this.product = product;
    }

    @FXML
    private void addToCartActionPerformed(ActionEvent event) {
        if (checkIfShoppingCartContainsProduct(product)) {
            increaseQuantity(product);
//            notifyShoppingItem();
        } else {
            shoppingCart.addProduct(product);
        }
    }

    private void increaseQuantity(Product product) {
        shoppingCart.getItems().get(getIndex(product)).setAmount(shoppingCart.getItems().get(getIndex(product)).getAmount() + 1);
    }

    private boolean checkIfShoppingCartContainsProduct(Product product) {
        System.out.println(getProductsInShoppingCart().contains(product));
        return getProductsInShoppingCart().contains(product);
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
        List<Product> productList = new ArrayList<Product>();

        for (ShoppingItem i : shoppingCart.getItems()) {
            productList.add(i.getProduct());
        }
        return productList;
    }

    public void setLabels(Product product) {
        productNameLabel.setText(product.getName());
        productImageView.setImage(dataHandler.getFXImage(product));
    }

    public AnchorPane getAnchorPane() {
        return shopProductCellPane;
    }
}
