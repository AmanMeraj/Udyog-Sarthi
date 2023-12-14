package com.example.udyogsathi.NewsDetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.Html;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.udyogsathi.Model.Home;
import com.example.udyogsathi.R;
import com.example.udyogsathi.Service.SpeechService;
import com.example.udyogsathi.databinding.ActivityNewsDetailsBinding;

import java.util.ArrayList;
import java.util.Locale;

import utils.Utility;

public class ActivityNewsDetails extends Utility implements TextToSpeech.OnInitListener,TextToSpeech.OnUtteranceCompletedListener {
ActivityNewsDetailsBinding binding;
ArrayList<Home>news;
    private TextToSpeech tts;
int position;
    String speech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityNewsDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        tts = new TextToSpeech(this,this);

        Bundle b= new Bundle();
        b=getIntent().getExtras();
        if(b!=null){
            position=b.getInt("pos");

            news=(ArrayList<Home>) getIntent().getSerializableExtra("KEY");

            Glide.with(this).load(news.get(position).getImageUrl()).placeholder(R.drawable.news_img).into(binding.image);
            binding.title.setText(news.get(position).getTitle());
            binding.tvDesc.setText(news.get(position).getDesc());

             speech =  news.get(position).getTitle() + " " + news.get(position).getDesc();

           // speakOut(speech);
//            Intent i = new Intent(this, SpeechService.class);
//            i.putExtra("speech", speech);
//            startService(i);
        }


    }
    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.ENGLISH);

            tts.setPitch(0.8f);
            tts.setSpeechRate(0.8f);
            //int result = tts.setLanguage(new Locale("hi"));

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TAG", "This Language is not supported");
            } else {
                speakOut(speech);
                Log.d("TAG", "onInit: ");

            }

        } else {
            Log.e("TAG", "Initilization Failed!");
        }

    }

    @Override
    public void onUtteranceCompleted(String s) {

    }

    public void speakOut(String text) {
        //  if (!getSharedPrefBoolean(this,DONT_SPEAK)) {

        text = stripHtml(text);
        Log.d("TAG", "speakOut: " + text);
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);

    }

    public String stripHtml(String html) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            return Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY).toString();
        } else {
            return Html.fromHtml(html).toString();
        }
    }
}