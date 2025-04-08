package com.news.newsapi;

import com.google.gson.*;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class NewsService {

    private static final String API_KEY = "becd448239824d9db09f5ab54b4681b8";
    private static final String NEWS_API_URL = "https://newsapi.org/v2/top-headlines?country=us&apiKey=" + API_KEY;

    public List<String> fetchHeadlines() {
        List<String> headlines = new ArrayList<>();
        try {
            URL url = new URL(NEWS_API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            JsonObject response = JsonParser.parseReader(new InputStreamReader(conn.getInputStream())).getAsJsonObject();
            JsonArray articles = response.getAsJsonArray("articles");

            for (JsonElement article : articles) {
                headlines.add(article.getAsJsonObject().get("title").getAsString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            headlines.add("Failed to fetch headlines.");
        }
        return headlines;
    }
}
