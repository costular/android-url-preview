# android-url-preview
A Android library to preview URL's.

![preview](https://raw.githubusercontent.com/costular/android-url-preview/master/preview.png "Preview")


# Usage
The next example shows how to use the library

```java
LinkPreviewTask.generate(new LinkListener() {
  @Override
  public void onWebLoading() {
    // It is executed when is fetching the data
    loadingView.setVisibility(View.VISIBLE);
  }
  
  @Override
  public void onWebFinishedLoading() {
    // It is executed when fetching has been finished
    loadingView.setVisibility(View.GONE);
  }
  
  @Override
  public void onWebLoaded(Web web) {
    // It returns a Web object which contains the metadata
    Picasso.with(getApplicationContext())
    .load(web.getImageURL())
    .fit()
    .centerCrop()
    .into(imagePreview);
    
    titlePreview.setText(web.getTitle());
    descriptionPreview.setText(web.getDescription());
  }
  
  @Override
  public void onWebError(String message) {
    // It is executed when something was wrong
  }
}, "http://costular.com").execute();
```
