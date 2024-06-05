import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/*
* Customizes the display of each charity in the ListView
*/
public class CharityListCell extends ListCell<Charity> {
  
  @Override
  protected void updateItem(Charity charity, boolean empty) {
    super.updateItem(charity, empty);
    
    if (empty || charity == null) {
      setText(null);
      setGraphic(null);
    } else {
      HBox cellLayout = new HBox(10);
      VBox charityInfo = new VBox(5);

      // Display the name and description of the charity
      Text charityName = new Text(charity.getName());
      Text charityDescription = new Text(charity.getDescription());
      charityDescription.setWrappingWidth(200);
      
      //add more graphic formatting here if time
      
      charityInfo.getChildren().addAll(charityName, charityDescription);
      cellLayout.getChildren().add(charityName);
      setGraphic(cellLayout);
    }
  }
}