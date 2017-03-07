package iMat.controllers.stages;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by JOHAN on 2017-03-01.
 */
public class ConfirmationStageController implements Initializable {

    @FXML private Label presentationLabel;
    @FXML private Button placeOrderButton;
    @FXML private ListView<Product> receiptListView;

    IMatDataHandler dataHandler = IMatDataHandler.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        presentationLabel.setText("Hej " + dataHandler.getCustomer().getFirstName() + "!");

        ObservableList<ShoppingItem> shoppingItemObservableList = FXCollections.observableArrayList();
        shoppingItemObservableList.addAll(dataHandler.getShoppingCart().getItems());
        ObservableList<Product> productObservableList = FXCollections.observableArrayList();
        for(int i = 0; i < shoppingItemObservableList.size();i++){
            productObservableList.add(shoppingItemObservableList.get(i).getProduct());
        }
        receiptListView.setItems(productObservableList);
    }

    @FXML
    private void placeOrderActionPerformed(ActionEvent event) {
        dataHandler.placeOrder(true);
    }
}
