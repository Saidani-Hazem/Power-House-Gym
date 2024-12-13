package com.example.acegym;

import static com.example.acegym.AllTrainingRecyclerViewAdapter.TRAINING_KEY;


import android.app.Dialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class PlanDetailDialog extends DialogFragment {
    private TextView trainingName;
    private Spinner spnDay;
    private EditText edtMinutes;
    private Button btnAdd, btnDismiss;

    public interface PassPlanInterface {
        void getPlan(Plan plan);
    }

    private PassPlanInterface passPlanInterface;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialogue_box_layout, null);
        intiView(view);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setView(view);

        Bundle bundle = getArguments();
        if(null != bundle){
            Training training = bundle.getParcelable(TRAINING_KEY);
            if(null != training){
                trainingName.setText(training.getName());
                btnDismiss.setOnClickListener(v -> dismiss());
//                if(edtMinutes.getText().length() > 0){
//                    //btnAdd.setEnabled(true);
                    btnAdd.setOnClickListener(v -> {
                        int minutes = Integer.parseInt(edtMinutes.getText().toString());
                        String day = spnDay.getSelectedItem().toString();
                        Plan plan = new Plan(training.getName(), day, minutes, false);

                        try {
                            passPlanInterface = (PassPlanInterface) getActivity();
                            passPlanInterface.getPlan(plan);
                            dismiss();
                        }catch (ClassCastException e){
                            e.printStackTrace();
                            dismiss();
                        }
                    });
//                }

            }
        }
        return builder.create();
    }

    public void intiView(View view){
        trainingName = view.findViewById(R.id.txtTrainingName);
        spnDay = view.findViewById(R.id.spnDayOfWeek);
        edtMinutes = view.findViewById(R.id.edtMinute);
        btnAdd = view.findViewById(R.id.btnAdd);
        btnDismiss = view.findViewById(R.id.btnDismiss);
    }
}
