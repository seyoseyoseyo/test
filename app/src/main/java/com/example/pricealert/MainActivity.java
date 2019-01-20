package com.example.pricealert;

import org.jsoup.*;
import org.jsoup.nodes.*;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread thread = new Thread(){
            public void run(){
                Document doc = null;
                try {
                    doc = Jsoup.connect("https://www.adidas.co.uk/ultraboost-all-terrain-shoes/CM8256.html")
                            .cookie("auth", "token")
                            .timeout(10 * 1000)
                            .userAgent("Mozilla")
                            .get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
