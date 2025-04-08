module com.news.newsapi {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.almasb.fxgl.all;
    requires com.google.gson;


    opens com.news.newsapi to javafx.fxml;
    exports com.news.newsapi;
}