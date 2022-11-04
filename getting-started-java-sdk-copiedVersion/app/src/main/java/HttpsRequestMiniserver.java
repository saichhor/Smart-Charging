import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.util.Base64;

public class HttpsRequestMiniserver {
    private static String getBasicAuthenticationHeader(String username, String password) {
        String valueToEncode = username + ":" + password;
        return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
    }

    public static void setBatteryLevel(Integer value) throws URISyntaxException {
        String userName = "Experte";
        String passWord = "Experte1234";

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(new URI("https://dns.loxonecloud.com/504F94A0EC9E/jdev/sps/io/Akkustand/" + value.toString()))
                .header("Authorization", getBasicAuthenticationHeader(userName, passWord))
                .build();
    }

    public static void main(String[] args) throws URISyntaxException {
        setBatteryLevel(75);
    }
}
