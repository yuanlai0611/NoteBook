package com.example.yuanyuanlai.notebook.utils;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SystemBarUtils {

    static void setTransparentStatusBar(AppCompatActivity activity){
        View view = activity.getWindow().getDecorView();
        int options = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        view.setSystemUiVisibility(options);
        activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
    }

}
