package com.example.acegym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.squareup.picasso.Picasso;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity Started";
    private Button btnSeeYourPlans, btnSeeAllTrainings, btnAboutUs, chron;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: started");


        img = findViewById(R.id.imageView);
        Picasso.get()
                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRmgZX67tf58iVVXhGNhngEo_S55joj4C2JnQbK2BPPd7pJzv5MmOb7iKEkLnEAOrTqipg&usqp=CAU")
                .into(img);

        initViews();
        Utils.getInstance();


        btnSeeAllTrainings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllTrainingActivity.class);
                startActivity(intent);
            }
        });

        btnSeeYourPlans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlanActivity.class);
                startActivity(intent);
            }
        });

        chron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, chrono.class);
                startActivity(intent);
            }
        });





    }


    private void initViews() {
        btnSeeYourPlans = findViewById(R.id.btnSeeYourPlan);
        btnSeeAllTrainings = findViewById(R.id.btnSeeAllActivities);
        btnAboutUs = findViewById(R.id.btnAbout);
        chron = findViewById(R.id.chrno);
    }
}
