package me.kazal.app.weatherapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.felipecsl.gifimageview.library.GifImageView;

import java.io.IOException;
import java.io.InputStream;

import Library.Connectivity;
import Library.Permission;

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
    protected void onResume() {
        super.onResume();
        AsyncTask obj = new Checkings().execute();

    }

    @Override
    protected void onStop() {
        super.onStop();
        gifImageView.stopAnimation();
    }

    public class Checkings extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {
            if (Permission.hasInternetPermission(getApplicationContext())) {
                if(Connectivity.isInternetConnected(getApplicationContext())) {
                    return true;
                }
            }
            return false;
        }
    }
}
