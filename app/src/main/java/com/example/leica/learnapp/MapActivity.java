package com.example.leica.learnapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.RelativeLayout;

import jp.co.yahoo.android.maps.*;


public class MapActivity extends ActionBarActivity {

    String appID = "dj0zaiZpPWpXN1B1TVduRXNHMSZzPWNvbnN1bWVyc2VjcmV0Jng9ZWI-";  // yahoo application ID

    private MapView mMapView = null;            //MapViewメンバー

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMapView = new MapView( this, appID );  // mapを作成

        mMapView.setBuiltInZoomControls(true);  // map に縮尺バーを追加


        MapController c = mMapView.getMapController();  // map操作

        c.setCenter( new GeoPoint( 35665721, 139731006 ) );     //中心座標
        c.setZoom( 1 ); 			       	                    //縮尺


        RelativeLayout relativeLayout = new RelativeLayout( this );

        relativeLayout.addView( mMapView, 600, 400 );   //画面に map を追加

        setContentView( relativeLayout );
        //setContentView(R.layout.activity_map);
        //setContentView( mMapView );
    }

    @Override
    protected void  onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
    }

}
