package com.example.udyogsathi.Service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.speech.tts.TextToSpeech;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.util.Log;
import android.view.KeyEvent;

import androidx.annotation.Nullable;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SpeechService extends Service implements TextToSpeech.OnInitListener,TextToSpeech.OnUtteranceCompletedListener {

    private TextToSpeech tts;
    TelephonyManager mTelephonyMgr;
    String TAG = "tts";
    String speech="";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate() {
        //Toast.makeText(this, "Service Created", Toast.LENGTH_LONG).show();
        tts = new TextToSpeech(this,this);

        mTelephonyMgr = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        mTelephonyMgr.listen(new TeleListener(), PhoneStateListener.LISTEN_CALL_STATE);

        // Create an IntentFilter instance.
        IntentFilter intentFilter = new IntentFilter();

        // Add network connectivity change action.
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");

        // Set broadcast receiver priority.
        intentFilter.setPriority(100);


    }
    @Override
    public void onStart(Intent intent, int startid) {

        try {
            speech = intent.getStringExtra("speech");
            speakOut(speech);
        }catch (Exception e){

        }
        //Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();

    }
    @Override
    public void onDestroy() {

        Log.d(TAG, "onDestroy: ");
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
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
                Log.e(TAG, "This Language is not supported");
            } else {
                Log.d(TAG, "onInit: ");
                speakOut(speech);
            }

        } else {
            Log.e(TAG, "Initilization Failed!");
        }

    }

    public void onUtteranceCompleted(String utteranceId) {
        Log.i(TAG, utteranceId); //utteranceId == "SOME MESSAGE"
        stopSelf();
    }

    private void speakOut(String text) {
      //  if (!getSharedPrefBoolean(this,DONT_SPEAK)) {
            if (mTelephonyMgr.getCallState() == TelephonyManager.CALL_STATE_IDLE) {
                text = stripHtml(text);
                Log.d(TAG, "speakOut: " + text);
                tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            }
        }


    public String stripHtml(String html) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            return Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY).toString();
        } else {
            return Html.fromHtml(html).toString();
        }
    }

    public class TeleListener extends PhoneStateListener {
        public void onCallStateChanged(int state, String incomingNumber) {
            try{

                Log.d(TAG, "onCallStateChanged: "+state);
                switch (state) {


                    case TelephonyManager.CALL_STATE_IDLE:
                        break;
                    case TelephonyManager.CALL_STATE_OFFHOOK:
                        // CALL_STATE_OFFHOOK;
                        tts.shutdown();
                        break;
                    case TelephonyManager.CALL_STATE_RINGING:
                        // CALL_STATE_RINGING
                        tts.shutdown();
                        break;
                }

            }catch(Exception e)
            {
                System.out.println("Exception ::onCallStateChanged::"+e);
            }
        }
    }



}
