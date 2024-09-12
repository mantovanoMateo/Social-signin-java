package com.oauth.httpClient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GoogleOauthClient {

    private final String GOOGLE_OAUTH_URL = "https://www.googleapis.com/userinfo/v2/me";
    private final HttpClient client;
    private final ObjectMapper objectMapper;


    public GoogleOauthClient() {
        client = HttpClient.newHttpClient();
        objectMapper = new ObjectMapper();
    }

    public OAuthUserData findGoogleOAuthUser(String accessToken) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .header("Authorization", "Bearer " + accessToken)
                .uri(URI.create(GOOGLE_OAUTH_URL))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), new TypeReference<>() {
        });
    }

}
