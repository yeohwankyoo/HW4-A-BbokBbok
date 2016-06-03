package com.example.yeohwankyoo.hw4_a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BubblePop view = new BubblePop(this);
        setContentView(view);
    }

}
