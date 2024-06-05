import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

/*
 * Handles fetching charity data from the API.
 */
public class CharityService {
  
  private static final String API_URL = "https://partners.every.org/v0.2/browse/%s?apiKey=%s&take=%d";
  private static final String API_KEY = "pk_live_faa182e4b54fcf5e2aee98403f26a71e";
  
  public List<Charity> fetchCharitiesByCause(String cause, int take) {
    List<Charity> charities = new ArrayList<>();
    String url = String.format(API_URL, cause, API_KEY, take);

    try {
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .build();

      // Send the request and handle the response
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      if (response.statusCode() == 200) {
        String responseBody = response.body();
        JSONObject json = new JSONObject(responseBody);
        JSONArray nonprofits = json.getJSONArray("nonprofits");

        // Parse the response and create Charity objects
        for (int i = 0; i < nonprofits.length(); i++) {
          JSONObject nonprofitJson = nonprofits.getJSONObject(i);
          Charity charity = new Charity();
          charity.setName(nonprofitJson.getString("name"));
          charity.setDescription(nonprofitJson.getString("description"));
          // Set other fields if needed
          charities.add(charity);
        }
      } else {
        System.err.println("Failed to fetch charities: " + response.statusCode());
      }
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }

    return charities;
  }
}