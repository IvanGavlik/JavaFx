package app;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.app.AlertBox;
import model.Product;

public class Solution extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Data table");
		
		// table use Observeble list 
		// load data into list
		ObservableList<Product> products = FXCollections.observableArrayList();
		products.add(new Product("P1", 12.0, 1));
		products.add(new Product("P2", 1.0, 2));
		products.add(new Product("P3", 23.0, 3));
		products.add(new Product("P4", 2.9, 1));
		
		//create table
		final TableView<Product> dataTable = new TableView<>();
		// setColumns, hader
		//Prpduct class. String datatype in the colum (String because name is String id Product)
		TableColumn<Product, String> nameColumn= new TableColumn<>("First Name");
		nameColumn.setMinWidth(200);
		// look for getter name in the Product object
		nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
		
		TableColumn<Product, Double> priceColumn= new TableColumn<>("Price");
		priceColumn.setMinWidth(100);
		priceColumn.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
		
		TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
		quantityColumn.setMinWidth(100);
		quantityColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantity"));
		
		// set items and and columns
		dataTable.setItems(products);
		dataTable.getColumns().addAll(nameColumn, priceColumn, quantityColumn);
		
		// add, delete, edit items in dataTable functionality
		final TextField name = new TextField();
		name.setPromptText("name");
	
		final TextField price = new TextField();
		price.setPromptText("price");
	
		final TextField quantity = new TextField();
		quantity.setPromptText("quantity");
	
		Button add = new Button("add");
		add.setOnAction(el -> {
				try {
					String pName = name.getText();
					Double pPrice = Double.valueOf(price.getText());
					Integer pQuntity = Integer.valueOf(quantity.getText());
					Product p = new Product(pName, pPrice, pQuntity);
					dataTable.getItems().add(p);
				} catch(Exception ex) {
					AlertBox.display("Wrong inputs", "Info");
				}
			}
		);
		
		Button remove = new Button("remove");
		remove.setOnAction(el -> {
				dataTable.getItems().removeAll(
						dataTable.getSelectionModel().getSelectedItems());
			}
		);
		
		HBox  box = new HBox();
		box.getChildren().addAll(name, price, quantity);
		
		HBox box2 = new HBox();
		box2.getChildren().addAll(add, remove);
		
		VBox pane = new VBox();
		pane.getChildren().addAll(dataTable, box, box2);
		
		
		stage.setScene(new Scene(pane, 420, 250));
		stage.show();
	}

}
