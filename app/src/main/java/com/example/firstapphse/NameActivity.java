package com.example.firstapphse;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class NameActivity extends AppCompatActivity {

    private TextView nameBox;
    private TextView dangerIfSizeOverflow;
    private String greetingString;
    private final int maxNameSize = 80;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_name);
        Intent intent = getIntent();
        nameBox = findViewById(R.id.nameBox);
        TextView greeting = findViewById(R.id.savedGreetingText);
        greetingString = intent.getStringExtra("greeting");
        dangerIfSizeOverflow = findViewById(R.id.DangerIfSizeOverflowText);
        greetingString = greetingString.isEmpty() ? "Hello" : greetingString;
        greeting.setText("Greeting: " + greetingString);
    }

    @SuppressLint("SetTextI18n")
    public void GetBackToMainActivity(View view) {
        Intent intent = new Intent();
        String name = nameBox.getText().toString();
        if (name.length() > maxNameSize) {
            dangerIfSizeOverflow.setText("Name length must be less than " + maxNameSize + " symbols");
            return;
        }
        intent.putExtra("full_greeting", greetingString + ", " + name);
        setResult(1, intent);
        finish();
    }
}