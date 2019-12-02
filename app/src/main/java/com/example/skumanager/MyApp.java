package com.example.skumanager;

import android.app.Application;

public class MyApp extends Application {

    SQLiteConnectionHelper connection;

    @Override
    public void onCreate() {
        super.onCreate();

        SQLConnection();
    }

    private void SQLConnection() {
        connection = new SQLiteConnectionHelper(this,"bd_user",null,1);
    }

    public SQLiteConnectionHelper getConnection() {
        return connection;
    }
}
