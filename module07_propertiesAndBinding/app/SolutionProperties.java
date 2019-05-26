package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Person;

public class SolutionProperties extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("title");
		
		final Person p = new Person();
		// will be call evry time  name is changed 
		p.nameStringProperty().addListener((el, oldValue, newValue) -> {
					System.out.println("Old: " + oldValue + " new "+ newValue);
					System.out.println("getAddress " + p.getAddress());
				}
		);
		
		//bind two properties
		//whaen chan one property anoder get also changed with same value
		p.addressStringProperty().bind(p.nameStringProperty().concat(" heheh"));
		
		Button b = new Button("Test");
		b.setOnAction(el -> p.setName("test 2")); 
		
		StackPane sp = new StackPane();
		sp.getChildren().add(b);
		stage.setScene(new Scene(sp, 200, 200));
		stage.show();
	}

}
