package com.example.udyogsathi.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.udyogsathi.Model.Home;
import com.example.udyogsathi.NewsDetails.ActivityNewsDetails;
import com.example.udyogsathi.R;
import com.example.udyogsathi.databinding.RowNewsBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class AdapterNews extends RecyclerView.Adapter<AdapterNews.ViewHolder>{
    public AdapterNews(Context context, ArrayList<Home> news) {
        this.context = context;
        this.news = news;
    }

    Context context;
    ArrayList<Home>news;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(RowNewsBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.binding.tvTitle.setText(news.get(position).getTitle());
    holder.binding.tvDesc.setText(news.get(position).getDesc());
        Glide.with(context.getApplicationContext()).load(news.get(position).getImageUrl()).into(holder.binding.image);
        try {
            DateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
            f.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date d = f.parse(news.get(position).getCreatedAt());
            //  Date d = f.parse("2018-04-04T08:41:21.265185");
            DateFormat date = new SimpleDateFormat("E, MMM dd yyyy", Locale.getDefault());

            TimeZone timeZone=TimeZone.getTimeZone("ASIA/KOLKATA");
            // time.setTimeZone(timeZone);
            String dates =(date.format(d));
            holder.binding.date.setText(dates);
            Log.d("SHR", "getdate: "+ date.format(d));


        } catch (Exception e) {
            e.printStackTrace();
        }
    holder.binding.image.setImageResource(R.drawable.news_img);
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(context.getApplicationContext(), ActivityNewsDetails.class);
            Bundle b= new Bundle();
            b.putSerializable("KEY",news);
            b.putInt("pos",position);
            i.putExtras(b);
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
