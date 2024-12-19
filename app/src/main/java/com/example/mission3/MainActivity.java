package com.example.mission3;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private TextView textMode, textTemperature;
    private boolean powerStatus = true;
    private int currentMode = 1;
    private int currentTemperature = 24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textMode = findViewById(R.id.textMode);
        textTemperature = findViewById(R.id.textTemperature);
    }

    public void togglePower(View view){
        powerStatus = !powerStatus;
    }

    public void toggleMode(View view) {
        if(powerStatus) {
            if (currentMode == 1) {
                currentMode = 2;
                textMode.setText("Heat");
            } else {
                currentMode = 1;
                textMode.setText("Cool");
            }
        }
    }

    public void decreaseTemperature(View view){
        if(powerStatus) {
            if (currentTemperature > 16) {
                currentTemperature--;
                textTemperature.setText(String.valueOf(currentTemperature));
            } else {
                Toast.makeText(this, "The lowest degree is 16", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void increaseTemperature(View view){
        if(powerStatus) {
            if (currentTemperature < 30) {
                currentTemperature++;
                textTemperature.setText(String.valueOf(currentTemperature));
            } else {
                Toast.makeText(this, "The highest degree is 30", Toast.LENGTH_LONG).show();
            }
        }
    }
}
