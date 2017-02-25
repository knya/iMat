package iMat.controllers.tabs;

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
        productObservableList.addAll(dataHandler.getProducts());

        shopProductListView.setItems(productObservableList);
        shopProductListView.setCellFactory(productListView -> new ShopProductCell());
    }

    public ObservableList<Product> setProductObservableList(ProductCategory productCategory) {
        productObservableList.clear();

        productCategoryLabel.setText(String.valueOf(productCategory));
        productObservableList.addAll(dataHandler.getProducts(productCategory));

        return productObservableList;
    }

    public void injectTabController(TabController tabController) {
        this.tabController = tabController;
    }
}
