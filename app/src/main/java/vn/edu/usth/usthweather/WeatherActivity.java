package vn.edu.usth.usthweather;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class WeatherActivity extends AppCompatActivity {

    private String TAG = "Application Case";
//    private ForecastFragment forecastFragment;
    private ViewPager2 viewPager;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"___Created___");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weather);

        viewPager = findViewById(R.id.View_page);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        ViewpageAdapter adapterPage = new ViewpageAdapter(getSupportFragmentManager(),getLifecycle());
        viewPager.setAdapter(adapterPage);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
               switch (position)
               {
                   case 0:
                       bottomNavigationView.getMenu().findItem(R.id.menu_tab_1).setChecked(true);
                       break;
                   case 1:
                       bottomNavigationView.getMenu().findItem(R.id.menu_tab_2).setChecked(true);
                       break;
                   case 2:
                       bottomNavigationView.getMenu().findItem(R.id.menu_tab_3).setChecked(true);
                       break;
               }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.menu_tab_1) {
                    viewPager.setCurrentItem(0, true); // Switch to the first fragment
                    return true;
                }
                if (item.getItemId() == R.id.menu_tab_2) {
                    viewPager.setCurrentItem(1, true); // Switch to the first fragment
                    return true;
                }
                if (item.getItemId() == R.id.menu_tab_3) {
                    viewPager.setCurrentItem(2, true); // Switch to the first fragment
                    return true;
                }
                return false;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
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