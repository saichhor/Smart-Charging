import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Test {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                .authenticator(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("postman", "password".toCharArray());
                    }
                })
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(new URI("https://postman-echo.com/basic-auth"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}



