package es.costular.androidurlpreview;

/**
 * Created by costular on 20/12/16.
 */

public class LinkWebPreview {

    public static void previewWebsite(String url, LinkListener listener) {
        LinkWebPreview linkCrawer = new LinkWebPreview(listener, url);
        linkCrawer.startPreviewWebsite();
    }

    private LinkListener listener;
    private String url;

    public LinkWebPreview(LinkListener listener, String url) {
        this.listener = listener;
        this.url = url;

        if (listener == null) {
            throw new IllegalArgumentException("LinkListener should be not null");
        }
        startPreviewWebsite();
    }

    private void startPreviewWebsite() {
        LinkPreviewTask task = new LinkPreviewTask(listener, url);
        task.execute();
    }

}
