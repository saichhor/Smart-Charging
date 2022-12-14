import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

public class HttpsRequestMiniserver {
    private String getBasicAuthenticationHeader(String username, String password) {
        String valueToEncode = username + ":" + password;
        return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
    }

    public void setBatteryLevel(Integer value) throws URISyntaxException {
        String userName = "Experte";
        String passWord = "Experte1234";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(new URI("https://168-119-185-175.504F94A0EC9E.dyndns.loxonecloud.com:20948/jdev/sps/io/Akkustand/" + value.toString()))
                .header("Authorization", getBasicAuthenticationHeader(userName, passWord))
                .build();

        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(response.statusCode());
        System.out.println(response.headers());
        System.out.println(response.body());
    }

    public static void main(String[] args) throws URISyntaxException {
        //setBatteryLevel(75);
    }
}