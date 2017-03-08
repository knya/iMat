package iMat.controllers.tabs;

import iMat.cells.CellFactory;
import iMat.controllers.TabController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;

import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

import static se.chalmers.ait.dat215.project.ProductCategory.*;

/**
 * Controller for Shop tab.
 */
public class ShopTabController implements Initializable {

    private TabController tabController;

    @FXML private ListView<Product> shopProductListView;
    @FXML private Label productCategoryLabel;
    @FXML private Label productCategoryAmountLabel;

    private ObservableList<Product> productObservableList;

    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        productObservableList = FXCollections.observableArrayList();
//        productObservableList.addAll(productCategories.getAllCategories());
//        setProductCategoryObservableList();
        shopProductListView.setItems(productObservableList);
        shopProductListView.setCellFactory(productListView -> new CellFactory().createShopProductCell());

    }

    public void inject(TabController tabController) {
        this.tabController = tabController;
    }

    public ObservableList<Product> setProductCategoryObservableList(List<ProductCategory> productCategoryList) {
        productObservableList.clear();

        Comparator<Product> comparator = Comparator.comparingInt(Product::getProductId);

        for (ProductCategory i : productCategoryList) {
            productObservableList.addAll(dataHandler.getProducts(i));
        }
        productObservableList.sort(comparator);

        setLabels(productCategoryList);

        return productObservableList;
    }

    public ObservableList<Product> getProductObservableList(){
        return this.productObservableList;
    }
    public ListView<Product> getShopProductListView(){
        return this.shopProductListView;
    }



    private void setLabels(List<ProductCategory> productCategoryList) {
        productCategoryAmountLabel.setText(String.valueOf(productObservableList.size()) + " st produkter");

        if (productCategoryList.get(0) == POD) {
            productCategoryLabel.setText("Alla produkter");
        }

        if (productCategoryList.get(0) == CITRUS_FRUIT) {
            productCategoryLabel.setText("Frukt och bär");
        }

        if (productCategoryList.get(0) == BREAD) {
            productCategoryLabel.setText("Bröd");
        }

        if (productCategoryList.get(0) == CABBAGE) {
            productCategoryLabel.setText("Grönsaker");
        }

        if (productCategoryList.get(0) == FISH) {
            productCategoryLabel.setText("Kött och fisk");
        }

        if (productCategoryList.get(0) == HOT_DRINKS) {
            productCategoryLabel.setText("Skafferi");
        }

        if (productCategoryList.get(0) == DAIRIES) {
            productCategoryLabel.setText("Mjölkprodukter");
        }

        if (productCategoryList.get(0) == COLD_DRINKS) {
            productCategoryLabel.setText("Drycker");
        }

        if (productCategoryList.get(0) == SWEET) {
            productCategoryLabel.setText("Godis");
        }

        if (productCategoryList.get(0) == PASTA) {
            productCategoryLabel.setText("Pasta/Ris/Potatis");
        }
    }
}
