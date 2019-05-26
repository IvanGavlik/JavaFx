package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SolutionPropertiesDemo extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("SolutionPropertiesDemo");

		TextField tf = new TextField();
		tf.setPromptText("name");		
		
		Label l = new Label();
		
		//Here is done bind (update)
		l.textProperty().bind(tf.textProperty());
			
		
		VBox vBox = new VBox();
		vBox.getChildren().addAll(tf, l);
		
		
		stage.setScene(new Scene(vBox, 200, 200));
		stage.show();
	}

}
