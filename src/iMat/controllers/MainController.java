package iMat.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML private AnchorPane search;
    @FXML private AnchorPane categories;
    @FXML private TabPane tab;
    @FXML private AnchorPane shopping;
    @FXML private AnchorPane tabsAnchorPane;

    @FXML private SearchController searchController;
    @FXML private ShoppingCartController shoppingCartController;
    @FXML private TabController tabController;
    @FXML private CategoriesController categoriesController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        searchController.injectMainController(this);
        shoppingCartController.injectMainController(this);
        tabController.injectMainController(this);
        categoriesController.injectMainController(this);

        setSizes();

        tab.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            @Override
            public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {
                if (tab.getTabs().size() == 5) {
                    if (oldValue == tab.getTabs().get(4)) {
                        tab.getTabs().remove(4);
                    }
                }
            }
        });

        tab.getTabs().remove(4);

    }

    private void setSizes() {
        search.setMinHeight(100);
        search.setMaxHeight(100);
        categories.setMinWidth(256);
        categories.setMaxWidth(256);
        shopping.setMinWidth(256);
        shopping.setMaxWidth(256);
        tabsAnchorPane.setMinSize(524,628);
    }

    public TabController getTabController() {
        return tabController;
    }

    public TabPane getTabPane() {
        return tab;
    }

}
