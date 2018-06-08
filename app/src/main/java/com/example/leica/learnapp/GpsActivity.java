package com.example.leica.learnapp;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;


public class GpsActivity extends ActionBarActivity implements LocationListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);


        LocationManager mLocationManager =  (LocationManager) getSystemService(Context.LOCATION_SERVICE);   // LocationManagerを取得

        Criteria criteria = new Criteria();                                  // Criteriaオブジェクトを生成

        criteria.setAccuracy(Criteria.ACCURACY_COARSE);                      // Accuracyを指定(低精度)

        criteria.setPowerRequirement(Criteria.POWER_LOW);                    // PowerRequirementを指定(低消費電力)

        String provider = mLocationManager.getBestProvider(criteria, true);  // ロケーションプロバイダの取得

        TextView tv_provider = (TextView) findViewById(R.id.Provider);       // 取得したロケーションプロバイダを表示
        tv_provider.setText("Provider: " + provider);

        mLocationManager.requestLocationUpdates(provider, 0, 0, this);       // LocationListenerを登録
    }

    @Override
    public void onLocationChanged(Location location) {
        TextView tv_lat = (TextView) findViewById(R.id.Latitude);           // 緯度の表示
        tv_lat.setText("Latitude:" + location.getLatitude() );

        TextView tv_lng = (TextView) findViewById(R.id.Longitude);          // 経度の表示
        tv_lng.setText("Latitude:" + location.getLongitude() );

    }

    @Override
    public void onProviderDisabled(String provider) {    }

    @Override
    public void onProviderEnabled(String provider) {    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {    }
}