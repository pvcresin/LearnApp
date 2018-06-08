package com.example.leica.learnapp;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;


public class SensorActivity extends ActionBarActivity implements SensorEventListener {

    private SensorManager manager;

    private TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        tv1 = (TextView)findViewById(R.id.sensorView1);
        tv2 = (TextView)findViewById(R.id.sensorView2);
        tv3 = (TextView)findViewById(R.id.sensorView3);
        tv4 = (TextView)findViewById(R.id.sensorView4);
        tv5 = (TextView)findViewById(R.id.sensorView5);
        tv6 = (TextView)findViewById(R.id.sensorView6);
        tv7 = (TextView)findViewById(R.id.sensorView7);
        tv8 = (TextView)findViewById(R.id.sensorView8);

        manager = (SensorManager)getSystemService(SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {        // TODO Auto-generated method stub
        super.onResume();

        // Listenerの登録          List<Sensor>  = manager.getSensorList(Sensor.TYPE);
        List<Sensor> accel = manager.getSensorList(Sensor.TYPE_ACCELEROMETER);
        List<Sensor> gyro = manager.getSensorList(Sensor.TYPE_GYROSCOPE);
        List<Sensor> light = manager.getSensorList(Sensor.TYPE_LIGHT);
        List<Sensor> gravity = manager.getSensorList(Sensor.TYPE_GRAVITY);
        List<Sensor> magnet = manager.getSensorList(Sensor.TYPE_MAGNETIC_FIELD);
        List<Sensor> proximate = manager.getSensorList(Sensor.TYPE_PROXIMITY);
        List<Sensor> humid = manager.getSensorList(Sensor.TYPE_RELATIVE_HUMIDITY);

        // resist Listener    if(.size() > 0) manager.registerListener(this, .get(0), SensorManager.SENSOR_DELAY_UI);
        if(accel.size() > 0) manager.registerListener(this, accel.get(0), SensorManager.SENSOR_DELAY_UI);
        if(gyro.size() > 0) manager.registerListener(this, gyro.get(0), SensorManager.SENSOR_DELAY_UI);
        if(light.size() > 0) manager.registerListener(this, light.get(0), SensorManager.SENSOR_DELAY_UI);
        if(gravity.size() > 0) manager.registerListener(this, gravity.get(0), SensorManager.SENSOR_DELAY_UI);
        if(magnet.size() > 0) manager.registerListener(this, magnet.get(0), SensorManager.SENSOR_DELAY_UI);
        if(proximate.size() > 0) manager.registerListener(this, proximate.get(0), SensorManager.SENSOR_DELAY_UI);
        if(humid.size() > 0) manager.registerListener(this, humid.get(0), SensorManager.SENSOR_DELAY_UI);

    }

    @Override
    protected void onStop() {        // TODO Auto-generated method stub
        super.onStop();
        manager.unregisterListener(this);        // Listenerの登録解除
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {        // TODO Auto-generated method stub

    }

    @Override
    public void onSensorChanged(SensorEvent event) {        // TODO Auto-generated method stub
        String str;

        switch(event.sensor.getType()){
            case Sensor.TYPE_ACCELEROMETER:
                str = "加速度:" + "\nX:" + event.values[0] + "\nY:" + event.values[1] + "\nZ:" + event.values[2] + "\n";
                tv1.setText(str);
                break;

            case Sensor.TYPE_GRAVITY:
                str = "重力:" + "\nX:" + event.values[0] + "\nY:" + event.values[1] + "\nZ:" + event.values[2] + "\n";
                tv2.setText(str);
                break;

            case Sensor.TYPE_GYROSCOPE:
                str = "ジャイロ:" + "\nX軸中心:" + event.values[0] + "\nY軸中心:" + event.values[1] + "\nZ軸中心:" + event.values[2] + "\n";
                tv3.setText(str);
                break;

            case Sensor.TYPE_MAGNETIC_FIELD:
                str = "磁場:" + "\nX:" + event.values[0] + "\nY:" + event.values[1] + "\nZ:" + event.values[2] + "\n";
                tv4.setText(str);
                break;

            case Sensor.TYPE_LIGHT:
                str = "照度:" + event.values[0] + "\n";
                tv5.setText(str);
                break;

            case Sensor.TYPE_PROXIMITY:
                str = "近接:" + event.values[0] + "\n";
                tv6.setText(str);
                break;

            case Sensor.TYPE_RELATIVE_HUMIDITY:
                str = "湿度:" + event.values[0] + "\n";
                tv7.setText(str);
                break;

        }

    }
}
