package com.example.acegym;

import static com.example.acegym.AllTrainingRecyclerViewAdapter.TRAINING_KEY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class TrainingActivity extends AppCompatActivity implements PlanDetailDialog.PassPlanInterface {
    private static final String TAG = "Training Started";
    private Button btnAddToPlan;
    private TextView txtTrainingName, txtLongDesc;
    private ImageView imgTrainingImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        initView();

        Intent intent = getIntent();
        if(intent != null) {
            Training training = intent.getParcelableExtra(TRAINING_KEY);
            if(training != null){

                txtTrainingName.setText(training.getName());
                txtLongDesc.setText(training.getLongDescription());

                Glide.with(this)
                        .asBitmap()
                        .load(training.getImgUrl())
                        .into(imgTrainingImg);

                btnAddToPlan.setOnClickListener(v -> {
                    PlanDetailDialog detailDialog = new PlanDetailDialog();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(TRAINING_KEY, training);
                    detailDialog.setArguments(bundle);
                    detailDialog.show(getSupportFragmentManager(), "plan detail dialog");
                });
            }
        }
    }

    public void initView() {
        //NestedScrollView nestedScrollView = findViewById(R.id.nestedScrollView);
        btnAddToPlan = findViewById(R.id.btnAddToPlan);
        txtTrainingName = findViewById(R.id.txtTrainingName);
        txtLongDesc = findViewById(R.id.txtLongDesc);
        imgTrainingImg = findViewById(R.id.imgTrainingImg);
    }

    @Override
    public void getPlan(Plan plan) {
        if(Utils.addPlan(plan)){
            Log.d(TAG, "getPlan: started");
            Toast.makeText(this, "Plan added successfully", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, PlanActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }
    }
}