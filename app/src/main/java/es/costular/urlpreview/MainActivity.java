package es.costular.urlpreview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.costular.androidurlpreview.LinkListener;
import es.costular.androidurlpreview.LinkPreviewTask;
import es.costular.androidurlpreview.LinkWebPreview;
import es.costular.androidurlpreview.Web;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.action_preview)
    Button actionPreview;

    @BindView(R.id.preview_image)
    ImageView imagePreview;

    @BindView(R.id.preview_title)
    TextView titlePreview;

    @BindView(R.id.preview_description)
    TextView descriptionPreview;

    @BindView(R.id.url)
    EditText urlInput;

    @BindView(R.id.loading)
    ProgressBar loadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        new LinkPreviewTask(new LinkListener() {
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
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        }, "https://dargo.net").execute();

        actionPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LinkPreviewTask(new LinkListener() {
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
                }, urlInput.getText().toString()).execute();
            }
        });
    }
}
