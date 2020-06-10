package com.example.viewpager;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;

public abstract class BaseActivity extends AppCompatActivity {


    @BindView(R.id.tv_data)TextView tv_data;

    String TAG = "dd";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindlayout());
        Log.d(TAG,"onCreate");

        initailView();

    }


    protected abstract Integer bindlayout();

    protected void initailView(){
    }

    protected abstract void initailData();

    protected abstract void initailEvnet();


    @Override
    protected void onResume() {
        Log.d(TAG,"onResume");
        super.onResume();
    }


    @Override
    protected void onStop() {
        Log.d(TAG,"onStop");
        super.onStop();
    }


    @Override
    protected void onPause() {
        Log.d(TAG,"onPause");
        super.onPause();
    }


    @Override
    protected void onDestroy() {
        Log.d(TAG,"onDestroy");
        super.onDestroy();
    }
}
