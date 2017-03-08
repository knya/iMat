package iMat.controllers.cells;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.ProductCategory;

import java.util.List;

import static se.chalmers.ait.dat215.project.ProductCategory.*;


/**
 * Created by Johan on 2017-02-23.
 */
public class ProductCategoryCellController extends AbstractCellController {

    @FXML private AnchorPane productCategoryCellPane;
    @FXML private Label nameLabel;
    @FXML private ImageView categoryImage;

    private List<ProductCategory> productCategoryList;

    public AnchorPane getAnchorPane() {
        return productCategoryCellPane;
    }

    private Image food = new Image("Imat/Images/groceries.png");
    private Image fruit = new Image("Imat/Images/apple.png");
    private Image bread = new Image("Imat/Images/baguette.png");
    private Image candy = new Image ("Imat/Images/candy.png");
    private Image milk = new Image("Imat/Images/milk.png");
    private Image pasta = new Image("Imat/Images/spaguetti.png");
    private Image steakAndFish = new Image("Imat/Images/steak.png");
    private Image vegetables = new Image("Imat/Images/carrot.png");
    private Image drinks = new Image("Imat/Images/water.png");
    private Image baking = new Image("Imat/Images/rolling-pin.png");


    public void setLabels() {
            if (productCategoryList.get(0) == POD) {
                nameLabel.setText("Alla produkter");
                categoryImage.setImage(food);

            }

            if (productCategoryList.get(0) == CITRUS_FRUIT) {
                nameLabel.setText("Frukt och bär");
                categoryImage.setImage(fruit);
            }

            if (productCategoryList.get(0) == BREAD) {
                nameLabel.setText("Bröd");
                categoryImage.setImage(bread);
            }

            if (productCategoryList.get(0) == CABBAGE) {
                nameLabel.setText("Grönsaker");
                categoryImage.setImage(vegetables);
            }

            if (productCategoryList.get(0) == FISH) {
                nameLabel.setText("Kött och fisk");
                categoryImage.setImage(steakAndFish);
            }

            if (productCategoryList.get(0) == HOT_DRINKS) {
                nameLabel.setText("Skafferi");
                categoryImage.setImage(baking);
            }

            if (productCategoryList.get(0) == DAIRIES) {
                nameLabel.setText("Mjölkprodukter");
                categoryImage.setImage(milk);
            }

            if (productCategoryList.get(0) == COLD_DRINKS) {
                nameLabel.setText("Drycker");
                categoryImage.setImage(drinks);
            }

            if (productCategoryList.get(0) == SWEET) {
                nameLabel.setText("Godis");
                categoryImage.setImage(candy);
            }

            if (productCategoryList.get(0) == PASTA) {
                nameLabel.setText("Pasta/Ris/Potatis");
                categoryImage.setImage(pasta);
            }
    }

    public void inject(List<ProductCategory> productCategoryList) {
        this.productCategoryList = productCategoryList;
    }

}
