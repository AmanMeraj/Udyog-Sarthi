package com.example.udyogsathi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.udyogsathi.Model.DisabilityType;
import com.example.udyogsathi.databinding.RowDisabilityBinding;

import java.util.ArrayList;

public class AdapterDisability extends RecyclerView.Adapter<AdapterDisability.ViewHolder>{
    public AdapterDisability(Context context, ArrayList<DisabilityType> disabilityTypes) {
        this.context = context;
        this.disabilityTypes = disabilityTypes;
    }

    Context context;
ArrayList<DisabilityType> disabilityTypes;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(RowDisabilityBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.binding.tvDisplay.setText(disabilityTypes.get(position).getDisability());
    }

    @Override
    public int getItemCount() {
        return disabilityTypes.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        RowDisabilityBinding binding;
        public ViewHolder(@NonNull RowDisabilityBinding itemView) {
            super(itemView.getRoot());
            this.binding=itemView;
        }
    }
}
