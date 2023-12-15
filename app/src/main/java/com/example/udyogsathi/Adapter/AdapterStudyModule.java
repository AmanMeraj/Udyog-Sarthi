package com.example.udyogsathi.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.udyogsathi.Learning.ActivityLearning;
import com.example.udyogsathi.Model.Module;
import com.example.udyogsathi.databinding.RowModuleBinding;
import com.example.udyogsathi.databinding.RowNewsBinding;

import java.util.ArrayList;

public class AdapterStudyModule extends RecyclerView.Adapter<AdapterStudyModule.ViewHolder>{
    public AdapterStudyModule(Context context, ArrayList<Module> data) {
        this.context = context;
        this.data = data;
    }

    Context context;
ArrayList<Module> data;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(RowModuleBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      holder.binding.tvModule.setText(data.get(position).getTitle());
      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent i = new Intent(context.getApplicationContext(), ActivityLearning.class);
              Bundle b= new Bundle();
              b.putSerializable("KEY",data);
              b.putInt("pos",position);
              i.putExtras(b);;
              context.startActivity(i);

          }
      });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RowModuleBinding binding;
        public ViewHolder(@NonNull RowModuleBinding itemView) {
            super(itemView.getRoot());
            this.binding=itemView;
        }
    }
}
