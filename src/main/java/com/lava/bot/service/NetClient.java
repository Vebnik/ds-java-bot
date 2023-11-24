package com.lava.bot.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public class NetClient {
    private static HttpClient client = HttpClient.newHttpClient();

    public static String get(String url) throws Exception {; 
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();

        return client.send(request, BodyHandlers.ofString()).body();
    }
}
