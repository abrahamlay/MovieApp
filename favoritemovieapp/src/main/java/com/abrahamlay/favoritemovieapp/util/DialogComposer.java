package com.abrahamlay.favoritemovieapp.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.abrahamlay.movieapp.R;
import com.abrahamlay.movieapp.language_preferance.LanguagePrefUtil;

public class DialogComposer {


    public static void showLanguageChangeDialog(final Activity activity){
        int checkedItem=0;
        final String[] languages = {"en", "id"};
        final String[] languagesUI = {"English", "Bahasa"};
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(activity.getString(R.string.select_language));
        builder.setSingleChoiceItems(languagesUI, checkedItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LanguagePrefUtil.updateLangWithRecreateActivity(activity,activity, languages[which]);
                    }
                });
        builder.create().show();
    }
}
