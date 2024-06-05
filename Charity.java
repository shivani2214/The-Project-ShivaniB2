import java.util.List;

/*
 * A class representing a Charity
 */
public class Charity {
  private String id;
  private String name;
  private String primarySlug;
  private String ein;
  private boolean isDisbursable;
  private String description;
  private String descriptionLong;
  private String locationAddress;
  private String nteeCode;
  //private NteeCodeMeaning nteeCodeMeaning;
  private String logoCloudinaryId;
  private String coverImageCloudinaryId;
  private String logoUrl;
  private String coverImageUrl;
  private String profileUrl;
  private String websiteUrl;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getProfileUrl() {
    return profileUrl;
  }

  public void setProfileUrl(String profileUrl) {
    this.profileUrl = profileUrl;
  }

  public String getLogoUrl() {
    return logoUrl;
  }

  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
  }

  public String getCoverImageUrl() {
    return coverImageUrl;
  }

  public void setCoverImageUrl(String coverImageUrl) {
    this.coverImageUrl = coverImageUrl;
  }

  public String getWebsiteUrl() {
    return websiteUrl;
  }

  public void setWebsiteUrl(String websiteUrl) {
    this.websiteUrl = websiteUrl;
  }
}
