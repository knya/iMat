package iMat.controllers.tabs;

import iMat.cells.CellFactory;
import iMat.cells.ShopProductCell;
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

/**
 * Controller for Shop tab.
 */
public class ShopTabController implements Initializable {

    private TabController tabController;

    @FXML private ListView<Product> shopProductListView;
    @FXML private Label productCategoryLabel;

    private ObservableList<Product> productObservableList;

    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        productObservableList = FXCollections.observableArrayList();
//        setProductObservableList(dataHandler.getProducts());
        shopProductListView.setItems(productObservableList);
        shopProductListView.setCellFactory(productListView -> new CellFactory().createShopProductCell());
    }

    public ObservableList<Product> setProductObservableList(List<Product> productList) {
        productObservableList.clear();

        productCategoryLabel.setText("Sökresultat");
        productObservableList.addAll(productList);

        return productObservableList;
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
        return productObservableList;
    }
}
