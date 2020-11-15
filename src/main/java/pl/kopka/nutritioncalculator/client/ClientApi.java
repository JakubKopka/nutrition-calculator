package pl.kopka.nutritioncalculator.client;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import org.apache.http.client.utils.URIBuilder;
import pl.kopka.nutritioncalculator.client.model.Foods;
import pl.kopka.nutritioncalculator.client.model.Query;


import java.net.URI;
import java.net.URISyntaxException;

@Controller
public class ClientApi {

    @Value("${api-key}")
    private String apiKey;

    @Value("${api-id}")
    private String apiId;

    private static final String BASE_API_URL = "https://trackapi.nutritionix.com/v2/natural/nutrients?";

//    @EventListener(ApplicationReadyEvent.class)
//    public void test() {
//        System.out.println(getInfo("100g cucumber, 200g tomato"));
//    }

    public ResponseEntity<Foods> getInfo(String query) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Query> queryUrlHttpEntity = getHttpEntity(query);
        ResponseEntity<Foods> exchange = restTemplate.exchange(getApiUrl(), HttpMethod.POST, queryUrlHttpEntity, Foods.class);
        return exchange;
    }

    private URI getApiUrl() {
        URI uri = null;
        try {
            URIBuilder uriBuilder = new URIBuilder(BASE_API_URL);
            uriBuilder.addParameter("Content-Type", "application/json");
            uriBuilder.addParameter("x-app-id", apiId);
            uriBuilder.addParameter("x-app-key", apiKey);
            uri = uriBuilder.build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return uri;
    }

    private HttpEntity<Query> getHttpEntity(String userQuery) {
        Query query = new Query(userQuery);
        HttpHeaders httpHeaders = getHttpHeaders();
        return new HttpEntity<>(query, httpHeaders);
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        return httpHeaders;
    }


}
