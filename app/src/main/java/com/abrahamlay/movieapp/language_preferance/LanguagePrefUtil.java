package com.abrahamlay.movieapp.language_preferance;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import com.abrahamlay.movieapp.util.app.MyApplication;

import java.util.Locale;


public class LanguagePrefUtil {
    public static final String LANG_SETTINGS ="language" ;
    private static SharedPreferences.Editor editor;
    private static Locale locale;
    private static Configuration config;

    private static void setLang(Activity activity, String language) {
        locale = new Locale(language);
        Locale.setDefault(locale);
        config = new Configuration();
        config.locale = locale;
        activity.getResources().updateConfiguration(config, null);
    }

    public static void initLanguage(Activity activity) {
        String language = MyApplication.getInstance().getPreference().getString(LANG_SETTINGS,"en");
        setLang(activity,language);
    }

    public static void updateLangWithRecreateActivity(Activity currentActivity, Activity destinationActivity, String langPrefToLoad) {
        setLang(destinationActivity,langPrefToLoad);
        editor= MyApplication.getInstance().getPreference().edit();
        editor.putString(LANG_SETTINGS,langPrefToLoad);
        editor.apply();

        Intent intent= new Intent(currentActivity,destinationActivity.getClass());
        destinationActivity.startActivity(intent);
        currentActivity.finish();
    }


    public static void updateLang(Activity activity, String langPrefToLoad) {
        setLang(activity,langPrefToLoad);
        editor= MyApplication.getInstance().getPreference().edit();
        editor.putString(LANG_SETTINGS,langPrefToLoad);
        editor.apply();

    }
}
