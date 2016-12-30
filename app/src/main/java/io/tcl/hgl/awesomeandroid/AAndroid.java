package io.tcl.hgl.awesomeandroid;

import android.app.Application;

import io.tcl.hgl.awesomeandroid.network.Aapi;

/**
 * Created by swd1 on 16-12-30.
 */

public class AAndroid extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Aapi.getMainPage();
    }
}
