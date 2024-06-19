package about_11_version;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/************
 * @info : HttpClientTest
 * @name : HttpClientTest
 * @date : 2024. 6. 14. 오후 10:50
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : Java 11 ADD: HttpClient
 ************/
public class HttpClientTest {
    public static void main(String[] args) {
        try {
            HttpResponse httpResponse = get();

            System.out.println("code: " + httpResponse.statusCode());
            System.out.println("header: " + httpResponse.headers());
            System.out.println("body: " + httpResponse.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static HttpResponse get() throws IOException, InterruptedException {
        // Client 객체
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        // Header
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", "application/json");
        headerMap.put("Accept", "application/json");
        headerMap.put("Authorization", "Bearer token");

        String[] headersArray = headerMap.entrySet().stream()
                .flatMap(entry -> Stream.of(entry.getKey(), entry.getValue()))
                .toArray(String[]::new);
        System.out.println("headersArray = " + Arrays.toString(headersArray));

        // Request 객체
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .headers(headersArray)
                .uri(URI.create("https://www.google.com"))
                .build();

        // Response 객체
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response;
    }
}
