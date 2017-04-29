package es.costular.androidurlpreview;

/**
 * Created by costular on 20/12/16.
 */

public class Web {

    private String title;
    private String url;
    private String description;
    private String imageURL;

    public Web(String title, String url, String description, String imageURL) {
        this.title = title;
        this.url = url;
        this.description = description;
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public String getImageURL() {
        return imageURL;
    }
}
