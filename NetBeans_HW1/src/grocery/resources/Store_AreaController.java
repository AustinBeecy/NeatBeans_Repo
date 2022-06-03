/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocery.resources;

import grocery.StoreArea;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 */
public class Store_AreaController implements Initializable {

    @FXML
    private TableView<StoreArea> area_table;
    @FXML
    private TableColumn<StoreArea, String> col_area_id;
    @FXML
    private TableColumn<StoreArea, String> col_area_name;
    @FXML
    private TableColumn<StoreArea, String> col_aisle;
    @FXML
    private TableColumn<StoreArea, String> col_area_desc;

    ObservableList<StoreArea> alist = FXCollections.observableArrayList();
    Connection conn;
    Statement stmt;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        OracleInterface oracle = new OracleInterface();
        conn = oracle.getConnection();
        stmt = oracle.getStatement();
        ResultSet rs;
//         String queryString = "select * from storearea where storearea.product_id in " +
//            "(select inventory.product_id from inventory where inventory.area_id in " +
//            "(select storeArea.area_id from storeArea where storeArea.store_id in " +
//            "(select store_id from store where store.city = '" + Store.currentStore + "')))";
//         System.out.println(queryString);

        String queryString = "select * from StoreArea where storearea.store_id in "
                + "(select store.store_ID from store where store.city = '" + Store.currentStore + "')";

        try {
            rs = stmt.executeQuery(queryString);

            while (rs.next()) {
                alist.add(new StoreArea(rs.getString("AREA_ID"), rs.getString("AREA_NAME"), rs.getInt("AISLE_NUM"), rs.getString("AREA_DESC")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        col_area_id.setCellValueFactory(new PropertyValueFactory<>("areaID"));
        col_area_name.setCellValueFactory(new PropertyValueFactory<>("areaName"));
        col_aisle.setCellValueFactory(new PropertyValueFactory<>("aisleNum"));
        col_area_desc.setCellValueFactory(new PropertyValueFactory<>("areaDescription"));
        area_table.setItems(alist);
    }
}
