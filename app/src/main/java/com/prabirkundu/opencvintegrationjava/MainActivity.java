package com.prabirkundu.opencvintegrationjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.InstallCallbackInterface;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (OpenCVLoader.initDebug()) {
            Log.d(TAG, "OpenCV is Configured or Connected successfully.");
            baseLoaderCallback.onManagerConnected(BaseLoaderCallback.SUCCESS);
        } else {
            Log.d(TAG, "OpenCV not Working or Loaded.");
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION, this, baseLoaderCallback);
        }
    }

    private BaseLoaderCallback baseLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case LoaderCallbackInterface.SUCCESS:
                    Log.e(TAG, "onManagerConnected: OpenCV Loaded :)" );
                    //cv_camera_view.enableView(); //TODO MUST CALL (ENABLE CAMERA)
                    break;
                default:{
                    super.onManagerConnected(status);
                }
            }
        }
        @Override
        public void onPackageInstall(int operation, InstallCallbackInterface callback) {
            super.onPackageInstall(operation, callback);
        }
    };
}