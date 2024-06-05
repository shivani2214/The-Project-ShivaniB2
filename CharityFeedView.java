import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.ListCell;

import java.util.List;

/*
* Manages ListView and displays the list of charities for browsing
*/
public class CharityFeedView {
  
  private VBox view;
  private ListView<Charity> charityListView;
  private ObservableList<Charity> charityList;
  private CharityService charityService;
  private int take = 20;
  private boolean loading = false;
  private int currentIndex = 0;

  public CharityFeedView(String cause) {
    view = new VBox();
      charityListView = new ListView<>();
      charityList = FXCollections.observableArrayList();
      charityService = new CharityService();

      // Set up the ListView to display the list of charities
      charityListView.setItems(charityList);
      charityListView.setCellFactory(param -> new CharityListCell());

      // Load initial set of charities
      loadMoreCharities(cause);

      // Create arrow buttons for navigation
      Button previousButton = new Button("<");
      Button nextButton = new Button(">");

      previousButton.setOnAction(event -> {
        if (currentIndex > 0) {
          currentIndex--;
          displayCurrentCharity();
        }
      });

      nextButton.setOnAction(event -> {
        if (currentIndex < charityList.size() - 1) {
          currentIndex++;
          displayCurrentCharity();
        } else if (!loading) {
          loadMoreCharities(cause);
        }
      });

      HBox buttonBox = new HBox(previousButton, nextButton);
      buttonBox.setSpacing(10);

      // Add buttons and ListView to the view
      view.getChildren().addAll(charityListView, buttonBox);

      // Initial display
      displayCurrentCharity();
  }

  public void loadMoreCharities(String cause) {
    loading = true;
    new Thread(() -> {
      // Fetch more charities from the CharityService
      List<Charity> newCharities = charityService.fetchCharitiesByCause(cause, take);
      Platform.runLater(() -> {
        if (newCharities != null) {
          charityList.addAll(newCharities);
          displayCurrentCharity();
        }
        loading = false;
      });
    }).start();
  }

  public void displayCurrentCharity() {
    if (!charityList.isEmpty()) {
      charityListView.scrollTo(currentIndex);
      charityListView.getSelectionModel().select(currentIndex);
    }
  }

  public VBox getView() {
    return view;
  }
}