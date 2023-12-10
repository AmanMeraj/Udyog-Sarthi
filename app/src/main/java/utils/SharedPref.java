package utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {

    private static final String LOGIN_SHARED_FILE = "sappy_Prefs";
    final public String user_token = "user_token";
    final public String login_status = "login_status";
    final public String user_status = "user_status";
    final public String user_id = "user_id";
    final public String user_name = "user_name";
    final public String user_password = "password";
    final public String user_email = "user_email";
    final public String user_mobile = "user_mobile";
    final public String admin_mobile = "admin_mobile";
    final public String user_dob = "user_dob";
    final public String user_address = "user_address";
    final public String user_image = "user_image";
    final public String user_gender = "gender";
    final public String user_country = "country";
    final public String user_state = "state";
    final public String user_city = "city";
    final public String user_zip = "zip";
    final public String user_country_code = "country_code";
    final public String main_balance = "main_balance";
    final public String bonus_point = "bonus_point";
    final public String cart_item = "cart_item";
    final public String item_no = "item_no";
    final public String userimage = "img";
    final  public  String lati="23.6645";
    final public String longi="86.9326";
    final public String solution_pdf = "pdf";


    final public String language = "lang";

    public void clearAll(Context context){
        if(context!=null) {
            SharedPreferences settings = context.getSharedPreferences(
                    LOGIN_SHARED_FILE, Context.MODE_PRIVATE);
            settings.edit().clear().apply();
        }
    }

    public void setPrefString(Context context, String key, String value){
        if(context!=null) {
            SharedPreferences settings = context.getSharedPreferences(
                    LOGIN_SHARED_FILE, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString(key, value);
            editor.apply();
        }
    }

    public String getPrefString(Context context, String key){
        SharedPreferences settings = context.getSharedPreferences(
                LOGIN_SHARED_FILE, Context.MODE_PRIVATE);
        return settings.getString(key, "");
    }

    public void setPrefInteger(Context context, String key, int value){
        if(context!=null) {
            SharedPreferences settings = context.getSharedPreferences(
                    LOGIN_SHARED_FILE, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt(key, value);
            editor.apply();
        }
    }

    public int getPrefInteger(Context context, String key){
        SharedPreferences settings = context.getSharedPreferences(
                LOGIN_SHARED_FILE, Context.MODE_PRIVATE);
        return settings.getInt(key, 0);
    }

    public void setPrefBoolean(Context context, String key, boolean value){
        if(context!=null) {
            SharedPreferences settings = context.getSharedPreferences(
                    LOGIN_SHARED_FILE, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean(key, value);
            editor.apply();
        }
    }

    public boolean getPrefBoolean(Context context, String key){
        SharedPreferences settings = context.getSharedPreferences(
                LOGIN_SHARED_FILE, Context.MODE_PRIVATE);
        return settings.getBoolean(key, false);
    }



}


