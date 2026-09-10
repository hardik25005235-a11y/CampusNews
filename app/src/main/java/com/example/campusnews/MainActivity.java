package com.example.campusnews;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button academicButton;
    Button eventsButton;
    Button placementButton;

    LinearLayout homeLayout;
    View fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        academicButton = findViewById(R.id.academicButton);
        eventsButton = findViewById(R.id.eventsButton);
        placementButton = findViewById(R.id.placementButton);

        homeLayout = findViewById(R.id.homeLayout);
        fragmentContainer = findViewById(R.id.fragmentContainer);

        academicButton.setOnClickListener(v -> {
            openFragment("Academic");
        });

        eventsButton.setOnClickListener(v -> {
            openFragment("Events");
        });

        placementButton.setOnClickListener(v -> {
            openFragment("Placements");
        });
    }

    private void openFragment(String category) {

        homeLayout.setVisibility(View.GONE);
        fragmentContainer.setVisibility(View.VISIBLE);

        NewsFragment fragment = new NewsFragment(category);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }

    @Override
    public void onBackPressed() {

        if (fragmentContainer.getVisibility() == View.VISIBLE) {

            fragmentContainer.setVisibility(View.GONE);
            homeLayout.setVisibility(View.VISIBLE);

        } else {
            super.onBackPressed();
        }
    }
}
