package main.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class App extends Application {

	Button button;
	Button button2;
	public static void main(String[] args) {
		// Set app as JavaFX
		launch(args);
	}

	/**
	 * program star find main, main set it as Java FX
	 * then call start
	 */
	public void start(Stage stage) throws Exception {
		// entire window is stage
		// scene is where things are in window
		stage.setTitle("Tile");
		
		button = new Button();
		button.setText("Click me");
		handleEvenetButtonClick();
		
		button2 = new Button();
		button2.setText("Click me ALert");
		// alert box
		handleEvenetButtonClick2();

		
		// to put things on scene must create layout
		HBox hBoxLayout = new HBox();
		hBoxLayout.getChildren().addAll(button, button2);
		
		// add scene to stage
		// scene have layout and sets the size of entire window 
		Scene scene = new Scene(hBoxLayout, 200, 200);
		stage.setScene(scene);
		
		// call this on exit program 
		stage.setOnCloseRequest(el -> {
			AlertBox.display("Test", "Test tile");	
		});
		stage.show();
	}
	
	private void handleEvenetButtonClick() {
		if(button == null) {
			return;
		}
		button.setOnAction(event -> {
			if(event.getSource().equals(button)) {
				System.out.println("cLICKED");
			}
			
		});
	}
	
	private void handleEvenetButtonClick2() {
		if(button2 == null) {
			return;
		}
		
		button2.setOnAction(el -> {
			
		});
		
		button2.setOnAction(event ->  AlertBox.display("Test", "Test tile") );
	}
}
