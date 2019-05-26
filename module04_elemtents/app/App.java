package app;




import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 *	<b> All items in JavaFx are ObservaleList<Type> </b>
	 */
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Elements");
		
		// CheckBoxs
		final CheckBox box1 = new CheckBox("Item 1");
		box1.setSelected(true);
		final CheckBox box2 = new CheckBox("Item 2");
		
		
		//lists there are type of observer list
		//can set types of data
		final ChoiceBox<String> choise = new ChoiceBox<String>();		
		choise.getItems().add("String 1");
		choise.getItems().add("String 2");
		choise.getItems().addAll("String 3", "String 4");
		choise.setValue("String 1"); // set defolut, must be inside list
		
		choise.getSelectionModel()
		.selectedItemProperty().addListener((item, oldValue, newValue) -> 
				System.out.println("Old value:" + oldValue + 
						" new value" + newValue)
		);
		
		//combobox, better than choies
		//generate own acticio use setOnAction method, will be caled on select item
		// can insert your itmes at runtime
		final ComboBox<String> boxSelection = new ComboBox<String>();
		boxSelection.getItems().addAll("box 1", "box 2");
		boxSelection.setPromptText("Chose box"); // this is not item 
		boxSelection.setOnAction(ae -> System.out.println("Box action"));
		boxSelection.setEditable(true); // insert at runtime
		
		
		// listView (can select multiple items, can have sckrollbar)
		final ListView<String> listView = new ListView<String>();
		listView.getItems().addAll("List item 1", "List item 2", "List item 3");
		// can selet multiple items
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); 
		
		//menubar menues and menu tems
		Menu fileMenu = new Menu("File menu");
		MenuItem fileMenuItem1 = new MenuItem("file 1..."); //... means it have submenu
		MenuItem fileMenuItem2 = new MenuItem("file 2");
		fileMenuItem2.setDisable(true);
		MenuItem fileMenuItem3 = new MenuItem("file 3");
		fileMenuItem3.setOnAction(ae -> System.out.println("file 3 click"));
		fileMenu.getItems().add(fileMenuItem1); // add one menu item
		fileMenu.getItems().add(new SeparatorMenuItem()); // add separator
		fileMenu.getItems().addAll(fileMenuItem2, fileMenuItem3); // add one menu item
		
		Menu editMenu = new Menu("_Edit"); // treat as prečac if have _ before name
		editMenu.getItems().add(new MenuItem("edit file 1"));
		editMenu.getItems().add(new MenuItem("edit file 2"));
		
		Menu heplMenu = new Menu("Help");
		final CheckMenuItem checMenuItem = new CheckMenuItem("TODO");
		checMenuItem.setOnAction(ae -> {
			if (checMenuItem.isSelected()) {
				System.out.println("SDelected item true");
			} else {
				System.out.println("SDelected item false");
			}
		});
		checMenuItem.setSelected(true); //default 
		heplMenu.getItems().addAll(checMenuItem);
		
		//Radio menu items, only one item can be selected
		
		MenuBar bar = new MenuBar();
		bar.getMenus().addAll(fileMenu, editMenu, heplMenu);
		
		Button button = new Button("Submit");
		button.setOnAction(el -> {
			String msg = "";
			msg += box1.isSelected() ? box1.getText() + " " : "";
			msg += box2.isSelected() ? box2.getText() + " " : "";

			System.out.println("Chosded Item: " + msg);

			String msg2 = choise.getValue();
			System.out.println("Chosded String: " + msg2);

			String msg3 = boxSelection.getValue();
			System.out.println("Chosded Box: " + msg3);

			String msg4 = "";
			ObservableList<String> selectedItems = listView.getSelectionModel().getSelectedItems();
			for (int i = 0; i < selectedItems.size(); i++) {
				msg4 += selectedItems.get(i) + " ";
			}
			System.out.println("Chosded List: " + msg4);
		});
		
		
		VBox vBox = new VBox();
		vBox.setSpacing(10);
		vBox.getChildren().addAll(bar, box1, box2, choise, boxSelection, listView, button);
		
		stage.setScene(new Scene(vBox, 300, 300));
		stage.show();
	}

	
}
