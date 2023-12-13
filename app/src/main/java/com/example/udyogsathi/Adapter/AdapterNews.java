package com.example.udyogsathi.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.udyogsathi.Model.News;
import com.example.udyogsathi.NewsDetails.ActivityNewsDetails;
import com.example.udyogsathi.R;
import com.example.udyogsathi.databinding.RowDisabilityBinding;
import com.example.udyogsathi.databinding.RowNewsBinding;

import java.util.ArrayList;

public class AdapterNews extends RecyclerView.Adapter<AdapterNews.ViewHolder>{
    public AdapterNews(Context context, ArrayList<News> news) {
        this.context = context;
        this.news = news;
    }

    Context context;
    ArrayList<News>news;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(RowNewsBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.binding.tvTitle.setText(news.get(position).getTitle());
    holder.binding.tvDesc.setText(news.get(position).getDescription());
    holder.binding.date.setText(news.get(position).getTime());
    holder.binding.image.setImageResource(R.drawable.news_img);
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(context.getApplicationContext(), ActivityNewsDetails.class);
            context.startActivity(i);
        }
    });
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RowNewsBinding binding;
        public ViewHolder(@NonNull RowNewsBinding itemView) {
            super(itemView.getRoot());
            this.binding=itemView;
        }
    }
}
