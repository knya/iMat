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
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by JOHAN on 2017-02-22.
 */
public class ShopProductCellController implements Initializable {

    @FXML private Label productNameLabel;
    @FXML private ImageView productImageView;
    @FXML private AnchorPane shopProductCellPane;

    @FXML private Button addToCartButton;

    private IMatDataHandler dataHandler;

    private Product product;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dataHandler = IMatDataHandler.getInstance();
    }

    public void injectProduct(Product product) {
        this.product = product;
    }

    @FXML
    private void addToCartActionPerformed(ActionEvent event) {
        dataHandler.getShoppingCart().addProduct(product);
    }

    public void setLabels(Product product) {
        productNameLabel.setText(product.getName());
        productImageView.setImage(dataHandler.getFXImage(product));
    }

    public AnchorPane getAnchorPane() {
        return shopProductCellPane;
    }
}
