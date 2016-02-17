package me.kazal.app.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.felipecsl.gifimageview.library.GifImageView;

import java.io.IOException;
import java.io.InputStream;

public class LoadingActivity extends AppCompatActivity {
    private static final String TAG = "LoadingActivity";
    private static GifImageView gifImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        gifImageView = (GifImageView) findViewById(R.id.loading_image);
        try {
            InputStream inputStream = getAssets().open("loading_image.gif");
            byte[] gifImageInBytes = new byte[inputStream.available()];
            inputStream.read(gifImageInBytes);
            gifImageView.setBytes(gifImageInBytes);
            inputStream.close();
        } catch (IOException e) {
            Log.e(TAG, "onCreate: ", e);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        gifImageView.startAnimation();
    }

    @Override
    protected void onStop() {
        super.onStop();
        gifImageView.stopAnimation();
    }
}
