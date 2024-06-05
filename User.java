public class User {
  private String username;
  private String password;
  private List<Charity> favoriteCharities;

  public User (String username, String password) {
    this.username = username;
    this.password = password;
    this.favoriteCharities = new ArrayList<>();
  }
}