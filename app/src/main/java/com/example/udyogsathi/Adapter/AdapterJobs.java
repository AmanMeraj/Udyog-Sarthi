package com.example.udyogsathi.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.udyogsathi.JobDetail.ActivityJobDetail;
import com.example.udyogsathi.Model.Jobs;
import com.example.udyogsathi.R;
import com.example.udyogsathi.databinding.RowJobBinding;

import java.util.ArrayList;


public class AdapterJobs extends  RecyclerView.Adapter<AdapterJobs.ViewHolder>{
    public AdapterJobs(Context context, ArrayList<Jobs> data) {
        this.context = context;
        this.data = data;
    }

    Context context;
ArrayList<Jobs> data;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(RowJobBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context.getApplicationContext()).load(data.get(position).getImageURL()).placeholder(R.drawable.job_img).into(holder.binding.jobImg);
holder.binding.jobTitle.setText(data.get(position).getTitle());
holder.binding.jobDesc.setText(data.get(position).getDesc());
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i = new Intent(context.getApplicationContext(), ActivityJobDetail.class);
        Bundle b= new Bundle();
        b.putSerializable("KEY",data);
        b.putInt("pos",position);
        i.putExtras(b);
        context.startActivity(i);
    }
});
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RowJobBinding binding;
        public ViewHolder(@NonNull RowJobBinding itemView) {
            super(itemView.getRoot());
            this.binding=itemView;
        }
    }
}
