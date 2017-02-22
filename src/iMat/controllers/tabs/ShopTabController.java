package iMat.controllers.tabs;

import iMat.cells.ShopProductCell;
import iMat.controllers.TabController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for Shop tab.
 */
public class ShopTabController implements Initializable {

    private TabController tabController;

    @FXML private ListView<Product> shopProductListView;

    private ObservableList<Product> productObservableList;

    private IMatDataHandler dataHandler;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dataHandler = IMatDataHandler.getInstance();

        productObservableList = FXCollections.observableArrayList();
        productObservableList.addAll(dataHandler.getProducts());

        shopProductListView.setItems(productObservableList);
        shopProductListView.setCellFactory(productListView -> new ShopProductCell());
    }

    public void injectTabController(TabController tabController) {
        this.tabController = tabController;
    }
}
