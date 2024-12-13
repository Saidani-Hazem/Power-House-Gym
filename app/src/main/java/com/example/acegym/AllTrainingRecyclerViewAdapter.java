package com.example.acegym;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class AllTrainingRecyclerViewAdapter extends RecyclerView.Adapter<AllTrainingRecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "TrainingRecViewAdapter";
    public static final String TRAINING_KEY = "training";

    private ArrayList<Training> training =  new ArrayList<>();
    private final Context context;

    public AllTrainingRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.training_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Log.d(TAG, "onBindViewHolder: called");
        holder.txtTrainingName.setText(training.get(position).getName());
        holder.txtShortDesc.setText(training.get(position).getShortDescription());

        Glide.with(context)
                .asBitmap()
                .load(training.get(position).getImgUrl())
                .into(holder.imgTraining);

        holder.parent.setOnClickListener(v -> {
            Intent intent = new Intent(context, TrainingActivity.class);
            intent.putExtra(TRAINING_KEY, training.get(position));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return training.size();
    }

    public void setTraining(ArrayList<Training> training) {
        this.training = training;
        notifyDataSetChanged();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        private final MaterialCardView parent;
        private final TextView txtTrainingName;
        private final TextView txtShortDesc;
        private final ImageView imgTraining;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parent = itemView.findViewById(R.id.parent);
            txtTrainingName = itemView.findViewById(R.id.txtTrainingName);
            txtShortDesc = itemView.findViewById(R.id.txtShortDesc);
            imgTraining = itemView.findViewById(R.id.imgTraining);
        }
    }
}
