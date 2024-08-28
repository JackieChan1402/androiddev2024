package vn.edu.usth.usthweather;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WeatherActivity extends AppCompatActivity {

    private String TAG = "Application Case";
    ForecastFragment forecastFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"___Created___");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weather);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Create a new Fragment to be placed in the activity
        ForecastFragment firstFragment = new ForecastFragment();

        // add the fragment to the "containner" FrameLayout
        getSupportFragmentManager().beginTransaction().add(R.id.main, firstFragment).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"___Started___");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"___Paused___");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"___Resumed___");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"___Stoped___");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"___Destroyed___");
    }
}