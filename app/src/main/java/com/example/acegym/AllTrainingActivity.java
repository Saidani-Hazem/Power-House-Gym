package com.example.acegym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class AllTrainingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_training);

        Utils.getInstance();

        RecyclerView trainingRecyclerView = findViewById(R.id.trainingRecView);
        AllTrainingRecyclerViewAdapter adapter = new AllTrainingRecyclerViewAdapter(this);
        trainingRecyclerView.setAdapter(adapter);

        if(null != Utils.getInstance().getTraining()){
            adapter.setTraining(Utils.getInstance().getTraining());
        }

        trainingRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

    }
}