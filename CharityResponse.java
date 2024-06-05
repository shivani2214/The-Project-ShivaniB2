import java.util.List;

/*
 * Represents the response containing a list of charities
 */
public class CharityResponse {
  private List<Charity> nonprofits;

  public List<Charity> getNonprofits() {
    return nonprofits;
  }

  public void setNonprofits(List<Charity> nonprofits) {
    this.nonprofits = nonprofits;
  }
}