package com.example.fragmentapp;

import android.content.res.Configuration;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int orientation = getResources().getConfiguration().orientation;
        int columnCount;

        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.activity_main_dual);
            columnCount = 1;
        }else{
            setContentView(R.layout.activity_main);
            columnCount = 2;
        }


        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragment_parent, ItemFragment.newInstance(columnCount))
                .commit();
    }
}