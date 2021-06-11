package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    TextView textView;
    EditText userNameEditText;
    Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create own Code Start
        textView = (TextView)findViewById(R.id.showTextView)  ;
        userNameEditText = (EditText)findViewById(R.id.userInputText);
        okButton = (Button)findViewById(R.id.ok);


        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameString = userNameEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, LastActivity.class);

                intent.putExtra("personName", nameString);

                startActivity(intent);
            }
        });



        //create own code End


    }
}