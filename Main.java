import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/*
* Set up the primary stage and scene
*/
public class Main extends Application {
  
  @Override
  public void start (Stage primaryStage) {
    BorderPane root = new BorderPane();
    
    // Create a CharityFeedView to display charities related to animals or any other cause
    CharityFeedView charityFeedView = new CharityFeedView("animals");
    root.setCenter(charityFeedView.getView());
    // Create a new scene with specified dimensions and set it to the primary stage
    Scene scene = new Scene(root, 400, 500);
    primaryStage.setTitle("Charity App");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main (String[] args) {
    launch(args);
  }
}