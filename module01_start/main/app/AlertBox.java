package main.app;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Create custom AlertBox
 */
public class AlertBox {

	
	public static void display(String msg, String title) {
		// because is enteire new window we need stage
		final Stage stage = new Stage();
		stage.setTitle(title);
		
		// bock other app, focus on this 
		stage.initModality(Modality.APPLICATION_MODAL);
		
		Label l = new Label(msg);
		Button close = new Button("Close");
		close.setOnAction( el -> stage.close() );
		
		VBox vBox = new VBox();
		vBox.getChildren().addAll(l, close);
		Scene sc = new Scene(vBox, 200, 300);
		
		stage.setScene(sc);
		stage.showAndWait(); // display, need to be close before doint other staf
	}

}
