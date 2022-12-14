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
                .uri(new URI("http://dns.loxonecloud.com/504f94a03fde/jdev/sps/io/Akkustand/" + value.toString()))
                .header("Authorization", getBasicAuthenticationHeader(userName, passWord))
                .build();

        HttpResponse<String> response = null;

        HttpResponse<String> response2 = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.headers().map().get("location"));

            HttpRequest request2 = HttpRequest.newBuilder()
                    .GET()
                    .uri(new URI(response.headers().map().get("location").get(0)))
                    .header("Authorization", getBasicAuthenticationHeader(userName, passWord))
                    .build();

            response2 = client.send(request2, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(response2.statusCode());
        System.out.println(response2.headers());
        System.out.println(response2.body());
    }

    public static void main(String[] args) throws URISyntaxException {
        //setBatteryLevel(75);
    }
}
