package com.example.pol.sesion10;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class proximity extends AppCompatActivity implements SensorEventListener{
    Sensor proximity;
    SensorManager sm;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);

        proximity = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sm.registerListener(this, proximity, SensorManager.SENSOR_DELAY_NORMAL);
        text = (TextView) findViewById(R.id.proximdata);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        text.setText("cm: "+sensorEvent.values[0]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
