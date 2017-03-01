package iMat.controllers.tabs;

import iMat.cells.OrderCartCell;
import iMat.controllers.TabController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by JOHAN on 2017-02-25.
 */
public class OrderTabController implements Initializable {

    private TabController tabController;

    @FXML private ListView<ShoppingItem> shoppingItemListView;
    @FXML private Label nameLabel;
    @FXML private Label amountLabel;
    @FXML private Label priceLabel;
    @FXML private Label sumLabel;
    @FXML private Button placeOrderButton;

    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        shoppingItemListView.setItems(refreshItemListView());
        shoppingItemListView.setCellFactory(shoppingItemListView -> new OrderCartCell());

        dataHandler.getShoppingCart().addShoppingCartListener(cartEvent -> {
            shoppingItemListView.setItems(refreshItemListView());
        });
    }

    public void inject(TabController tabController) {
        this.tabController = tabController;
    }

    private ObservableList<ShoppingItem> refreshItemListView() {
        ObservableList<ShoppingItem> shoppingItemObservableList = FXCollections.observableArrayList();
        shoppingItemObservableList.addAll(dataHandler.getShoppingCart().getItems());

        return shoppingItemObservableList;
    }

    @FXML
    private void placeOrderActionPerformed(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/iMat/fxmls/stages/ConfirmationStage.fxml"));
        Stage confirmationStage = new Stage();
        confirmationStage.setScene(new Scene(root));
        confirmationStage.initModality(Modality.APPLICATION_MODAL);
        confirmationStage.setTitle("Bekräfta beställning");
        confirmationStage.setResizable(false);
        confirmationStage.showAndWait();
    }
}
