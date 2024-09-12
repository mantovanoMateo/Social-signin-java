package com.oauth.httpClient;

public record OAuthUserData(String email, String family_name, String given_name, String id, String name, String picture,
                            Boolean verified_email) {
}
