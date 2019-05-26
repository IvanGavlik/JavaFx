import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class App extends Application {

	Stage window;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		window = stage;
		window.setTitle("Embede layouts");
		
		HBox topMenu = new HBox();
		Button b1 = new Button("B1");
		Button b2 = new Button("B2");
		Button b3 = new Button("B3");
		topMenu.getChildren().addAll(b1, b2, b3);
		
		VBox leftMenu = new VBox ();
		Button b4 = new Button("B4");
		Button b5 = new Button("B5");
		Button b6 = new Button("B6");
		leftMenu.getChildren().addAll(b4, b5, b6);

		// main panel that contains other layouts (panels)
		BorderPane bp = new BorderPane();
		bp.setTop(topMenu);
		bp.setLeft(leftMenu);
			
		
		Scene sc = new Scene(bp, 200, 400);
		window.setScene(sc);
		window.show();
	}

}
