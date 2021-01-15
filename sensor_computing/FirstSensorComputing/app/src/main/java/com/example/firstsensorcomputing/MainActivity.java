package com.example.firstsensorcomputing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    Sensor accelerometer;

    TextView Xvalue, Yvalue,Zvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // register sensors
        Xvalue = (TextView) findViewById(R.id.text1);
        Yvalue = (TextView) findViewById(R.id.text2);
        Zvalue = (TextView) findViewById(R.id.text3);

        sensorManager = (SensorManager)  getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(MainActivity.this,accelerometer,sensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void  onAccuracyChanged(Sensor sensor, int i){

    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent){
        TextView text1= (TextView)findViewById(R.id.text1);
        text1.setText(" X: "+sensorEvent.values[0]+" Y: " +sensorEvent.values[1]+" Z: "+sensorEvent.values[2]);

        Xvalue.setText("xValue: " + sensorEvent.values[0]);
        Yvalue.setText("yValue: " + sensorEvent.values[1]);
        Zvalue.setText("zValue: " + sensorEvent.values[2]);
    }
}
