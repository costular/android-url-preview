package es.costular.androidurlpreview;

import android.os.AsyncTask;
import java.io.IOException;

/**
 * Created by costular on 20/12/16.
 */

public class LinkPreviewTask extends AsyncTask<Void, Void, Web> {

    private LinkListener linkListener;
    private String url;

    public LinkPreviewTask(LinkListener linkListener, String url) {
        this.linkListener = linkListener;
        this.url = url;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        linkListener.onWebLoading();
    }

    @Override
    protected Web doInBackground(Void... voids) {
        try{
            return LinkCrawler.getWebPreviewFromURL(url);
        } catch (IllegalArgumentException malformed) {
            linkListener.onWebError("La URL debe ser válida");
        } catch (IOException exception) {
            linkListener.onWebError(exception.getMessage());
        }
        return null;
    }

    @Override
    protected void onPostExecute(Web result) {
        super.onPostExecute(result);
        linkListener.onWebFinishedLoading();

        if (result != null && !result.getImageURL().isEmpty()) {
            linkListener.onWebLoaded(result);
        }
    }
}
