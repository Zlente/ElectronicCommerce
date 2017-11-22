package com.bill.electroniccommerce.example;

import android.app.Application;

import com.bill.cappu.app.Cappu;

/**
 *
 */

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Cappu.init(this)
                .withApiHost("http://127.0.0.1/")
                .configure();
    }
}
