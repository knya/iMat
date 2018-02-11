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

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by JOHAN on 2017-03-04.
 */
public class SearchTabController implements Initializable {

    private TabController tabController;

    @FXML private ListView<Product> searchListView;
    @FXML private Label searchLabel;

    private ObservableList<Product> productObservableList;
    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        productObservableList = FXCollections.observableArrayList();
        searchListView.setItems(productObservableList);
        searchListView.setCellFactory(productListView -> new CellFactory().createShopProductCell());
    }

    public void inject(TabController tabController) {
        this.tabController = tabController;
    }

    public ObservableList<Product> setProductObservableList(List<Product> productList) {
        productObservableList.clear();
        productObservableList.addAll(productList);

        return productObservableList;
    }

    public void setSearchText(String s) {
        if (s == null) {
            searchLabel.setText("Tom sökning. Visar alla " + productObservableList.size() + " produkter i iMat");
        } else {
            searchLabel.setText(productObservableList.size() + " träffar på " + "\"" + s + "\"");
        }

    }
}
