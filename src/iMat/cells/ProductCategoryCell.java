package iMat.cells;

import iMat.controllers.cells.ICellController;
import iMat.controllers.cells.ProductCategoryCellController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import se.chalmers.ait.dat215.project.ProductCategory;

import java.io.IOException;

/**
 * Created by Johan on 2017-02-23.
 */
public class ProductCategoryCell extends ListCell<ProductCategory> {

    private FXMLLoader fxmlLoader;

    private ICellController cellController;

    public ProductCategoryCell() {
        if (fxmlLoader == null) {
            fxmlLoader = new FXMLLoader(getClass().getResource("/iMat/fxmls/cells/ProductCategoryCell.fxml"));

            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        cellController = fxmlLoader.getController();
    }

    @Override
    protected void updateItem(ProductCategory productCategory, boolean empty) {

        super.updateItem(productCategory, empty);

        if(empty || productCategory == null) {
            setGraphic(null);
        } else {
            setGraphic(cellController.getAnchorPane());
            cellController.inject(productCategory);
            cellController.setLabels();
        }
    }
}
