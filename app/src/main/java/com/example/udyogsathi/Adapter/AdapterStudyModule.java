package com.example.udyogsathi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
holder.binding.tvModule.setText(data.get(position).getModule());
holder.binding.arrow.setImageResource(data.get(position).getArrow());
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
