package app;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {

	Stage window;
	Scene scene1, scene2;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Scene is like new page in web developemnt
	 */
	public void start(Stage stage) throws Exception {
		window = stage;
		window.setTitle("switch");
		initScene1();
		initScene2();
		window.setScene(scene1);
		window.show();
	}
	
	private void initScene1() {
		// add elements
		Label l = new Label("Scenne 1");
		Button b = new Button("go to Scenne 1");
		//on click chage scene
		b.setOnAction(el -> window.setScene(scene2));

		// create panel 
		VBox vBoxLPanel= new VBox();
		vBoxLPanel.getChildren().addAll(l,b);
		

		scene1 = new Scene(vBoxLPanel, 200, 200);
	} 
	
	private void initScene2() {
		// add elements
		Label l = new Label("Scenne 2");
		Button b = new Button("Go Back");
		//on click chage scene
		b.setOnAction(ev -> window.setScene(scene1));

		// create panel 
		HBox hBoxPanel = new HBox();
		hBoxPanel.getChildren().addAll(l,b);
		

		scene2 = new Scene(hBoxPanel, 200, 200);
	} 
}
