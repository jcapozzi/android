package com.example.problemsolver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FarmerMainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.problemsolver.Message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_main);
    }

    public void farmerScreen(View view) {
        Intent intent = new Intent(this, ProblemActivity.class);
        startActivity(intent);
    }
}
