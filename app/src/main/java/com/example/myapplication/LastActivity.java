package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LastActivity extends AppCompatActivity {


    TextView finalTextView;
    Button goToWishListButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);


        //Start My Code
        finalTextView = (TextView)findViewById(R.id.finalTextView);
        goToWishListButton = (Button) findViewById(R.id.gotoWishListButton);


        // Button Listener
        goToWishListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LastActivity.this, WishListActivity.class);

                startActivity(intent);
            }
        });


        finalTextView.setText("WELCOME!!\n" + getIntent().getStringExtra("personName"));



        //End My Code
    }
}