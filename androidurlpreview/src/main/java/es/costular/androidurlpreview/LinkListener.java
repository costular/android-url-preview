package es.costular.androidurlpreview;

/**
 * Created by costular on 20/12/16.
 */

public interface LinkListener {

    void onWebLoading();
    void onWebFinishedLoading();
    void onWebLoaded(Web web);
    void onWebError(String message);

}
