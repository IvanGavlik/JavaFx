package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Source extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("title");
		
		Label l1 = new Label("Label");
		Button b2 = new Button("Click");
		// like inline in web development
		b2.setStyle("-fx-background-color: blue;"); 
		
		VBox box = new VBox();
		box.getChildren().addAll(l1, b2);
		
		Scene sc = new Scene(box, 100, 100);
		// it will look in resource dir and try to find  style.css
		sc.getStylesheets().add("style.css"); 
		stage.setScene(sc);
		stage.show();
	}

}
