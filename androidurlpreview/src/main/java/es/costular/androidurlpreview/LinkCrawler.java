package es.costular.androidurlpreview;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by costular on 20/12/16.
 */

public class LinkCrawler {

    public static Web getWebPreviewFromURL(String url) throws IllegalArgumentException, IOException {
        Connection.Response response = null;
        Web web = null;

        response = Jsoup.connect(url)
                .userAgent("Mozilla/5.0")
                .ignoreHttpErrors(true)
                .execute();

        if (response.statusCode() != 200) {
            return null;
        }
        web = parseWeb(response);

        return web;
    }

    private static Web parseWeb(Connection.Response response) throws IOException {
        Document document = response.parse();

        String imageURL = "";
        String title = "";
        String description = "";
        String url = response.url().toString();

        if (response.url().getHost().contains("twitter")) {
            title = document.select("meta[property=twitter:title]").attr("content");
            imageURL = document.select("meta[property=twitter:image]").attr("content");
            description = document.select("meta[property=twitter:description]").attr("content");

        } else if (response.url().getHost().contains("youtube")) {
            title = document.select("meta[property=title:image]").attr("content");

        } else if (response.url().getHost().contains("spotify")) {

        } else {
            title = document.select("meta[property=og:title]").attr("content");
            imageURL = document.select("meta[property=og:image]").attr("content");
            description = document.select("meta[property=og:description]").attr("content");
            url = document.select("meta[property=og:url]").attr("content");
        }

        Web web = new Web(title, url, description, imageURL);
        return web;
    }

}
