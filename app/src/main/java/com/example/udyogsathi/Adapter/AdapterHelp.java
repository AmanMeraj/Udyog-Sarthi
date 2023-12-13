package com.example.udyogsathi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.udyogsathi.Model.Help;
import com.example.udyogsathi.databinding.RowJobBinding;
import com.example.udyogsathi.databinding.RowTickectBinding;

import java.util.ArrayList;

public class AdapterHelp extends  RecyclerView.Adapter<AdapterHelp.ViewHolder>{
    public AdapterHelp(Context context, ArrayList<Help> helps) {
        this.context = context;
        this.helps = helps;
    }

    Context context;
ArrayList<Help>helps;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(RowTickectBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.binding.title.setText(helps.get(position).getTitle());
holder.binding.issue.setText(helps.get(position).getIssue());
holder.binding.status.setText(helps.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return helps.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RowTickectBinding binding;

        public ViewHolder(@NonNull RowTickectBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
