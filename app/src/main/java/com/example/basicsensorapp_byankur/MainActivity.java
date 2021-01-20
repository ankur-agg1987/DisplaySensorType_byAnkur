package com.example.basicsensorapp_byankur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    SensorManager sensorManager;
    TextView textView;
    List<Sensor> sensorList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview1);

        // step1: get access to sensor service by sensor manager
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        // step2: access the type of sensor information in list.
        sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        // step3: update the text view with all sensor information avaialble in List
        //textView.setText(String.valueOf(sensorList));

        for(Sensor s: sensorList){
            textView.setText(textView.getText() + "///" +s.getName());
            Log.d("mySensorName","Sensor Name:" +s.getName()+", Sensor Vendor:"+s.getVendor() +", Sensor Type:"+s.getType() + ", Sensor Power:"+s.getPower());
        }
    }
}