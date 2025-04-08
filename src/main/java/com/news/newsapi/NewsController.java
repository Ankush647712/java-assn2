package com.news.newsapi;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class NewsController {

    @FXML
    private ListView<String> newsList;

    public void initialize() {
        NewsService service = new NewsService();
        newsList.getItems().addAll(service.fetchHeadlines());
    }
}
