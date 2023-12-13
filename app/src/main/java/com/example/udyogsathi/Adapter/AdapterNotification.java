package com.example.udyogsathi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.udyogsathi.Model.Notification;
import com.example.udyogsathi.databinding.RowDisabilityBinding;
import com.example.udyogsathi.databinding.RowModuleBinding;
import com.example.udyogsathi.databinding.RowNotificationBinding;

import java.util.ArrayList;

public class AdapterNotification extends RecyclerView.Adapter<AdapterNotification.ViewHolder>{
    public AdapterNotification(Context context, ArrayList<Notification> notifications) {
        this.context = context;
        this.notifications = notifications;
    }

    Context context;
ArrayList<Notification> notifications;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(RowNotificationBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.binding.tvTitle.setText(notifications.get(position).getTitle());
        holder.binding.tvDes.setText(notifications.get(position).getDesc());
        holder.binding.tvDate.setText(notifications.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RowNotificationBinding binding;
        public ViewHolder(@NonNull RowNotificationBinding itemView) {
            super(itemView.getRoot());
            this.binding=itemView;
        }
    }
}
