# android-url-preview
A Android library to preview URL's.

![preview](https://raw.githubusercontent.com/costular/android-url-preview/master/preview.png "Preview")


# Usage
The next example shows how to use the library

```java
LinkPreviewTask.generate(new LinkListener() {
  @Override
  public void onWebLoading() {
    loadingView.setVisibility(View.VISIBLE);
  }
  
  @Override
  public void onWebFinishedLoading() {
    loadingView.setVisibility(View.GONE);
  }
  
  @Override
  public void onWebLoaded(Web web) {
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
    
  }
}, "http://costular.com").execute();
```
