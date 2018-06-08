package com.example.leica.learnapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;


public class OpenCVActivity extends ActionBarActivity implements CameraBridgeViewBase.CvCameraViewListener2 {

    int doGray = 0, doEdge = 0, doReverse = 0;

    private CameraBridgeViewBase mCameraView;
    private Mat mOutputFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_cv);

        getSupportActionBar().hide();

        mCameraView = (CameraBridgeViewBase)findViewById(R.id.camera_view);
        mCameraView.setCvCameraViewListener(this);
    }


    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {

            switch (status) {
                case LoaderCallbackInterface.SUCCESS:
                    mCameraView.enableView();
                    break;
                default:
                    super.onManagerConnected(status);
                    break;
            }
        }
    };


    @Override
    public void onPause() {
        if (mCameraView != null) {
            mCameraView.disableView();
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_2_4_4, this, mLoaderCallback);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mCameraView != null) {
            mCameraView.disableView();
        }
    }

    @Override
    public void onCameraViewStarted(int width, int height) {
        // Mat(int rows, int cols, int type)
        // rows(行): height, cols(列): width
        mOutputFrame = new Mat(height, width, CvType.CV_8UC1);
    }

    @Override
    public void onCameraViewStopped() {
        mOutputFrame.release();
    }

    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {   // Filter

        if (doGray == 1) {
            mOutputFrame = inputFrame.gray();                                       // gray or rgb color
            //Imgproc.cvtColor(inputFrame.rgba(), temp, Imgproc.COLOR_RGB2GRAY);    // the same rgba -> gray
        } else {
            mOutputFrame = inputFrame.rgba();
        }

        // Cannyフィルタをかける (Edge)
        if (doEdge == 1) Imgproc.Canny(mOutputFrame, mOutputFrame, 80, 100); // default threshold 80 , 100

        // ビット反転
        if (doReverse == 1) Core.bitwise_not(mOutputFrame, mOutputFrame);

        return mOutputFrame;
    }

    public void onCVbuttonClicked(View v){
        int cvID = v.getId();

        if (cvID == R.id.cvRGB){
            doGray = 0;
        } else if (cvID == R.id.cvGRAY) {
            doGray = 1;
        } else if (cvID == R.id.cvREVERSE) {
            doReverse = 1 - doReverse;
        } else if (cvID == R.id.cvEDGE) {
            doEdge = 1 - doEdge;
        }
    }
}