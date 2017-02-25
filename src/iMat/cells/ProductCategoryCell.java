package iMat.cells;

import iMat.controllers.cells.ICellController;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

/**
 * Created by Johan on 2017-02-23.
 */
public class ProductCategoryCell extends AbstractCell {

    private FXMLLoader fxmlLoader;

    private ICellController cellController;
//    private ProductCategoryCellController productCategoryCellController;

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
//        productCategoryCellController = fxmlLoader.getController();
    }

//    public void updateItem(ProductCategory productCategory, boolean empty) {
//        super.updateItem(productCategory, empty);
//
//        if(empty || productCategory == null) {
//            setGraphic(null);
//        } else {
//            setGraphic(cellController.getAnchorPane());
//            System.out.println(cellController.getAnchorPane());
//            cellController.inject(productCategory);
//        }
//    }


//    @Override
//    protected void updateItem(ProductCategory productCategory, boolean empty) {
//        super.updateItem(productCategory, empty);
//
//        if(empty || productCategory == null) {
//            setGraphic(null);
//        } else {
//            setGraphic(productCategoryCellController.getAnchorPane());
//            productCategoryCellController.injectProductCategory(productCategory);
//            productCategoryCellController.setLabels(productCategory);
//        }
//    }
}
