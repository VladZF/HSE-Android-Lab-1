package com.example.firstapphse;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView greetingBox;
    private TextView greetingNameText;
    private final int maxGreetingSize = 80;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        greetingBox = findViewById(R.id.greetingBox);
        greetingNameText = findViewById(R.id.greetingNameText);
    }

    @SuppressLint("SetTextI18n")
    public void goToNameActivity(View view) {
        Intent intent = new Intent(this, NameActivity.class);
        String greeting = greetingBox.getText().toString();
        if (greeting.length() > maxGreetingSize) {
            greetingNameText.setText("Greeting length must be less than " + maxGreetingSize + " symbols");
            return;
        }
        intent.putExtra("greeting", greeting);
        startActivityForResult(intent, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) return;
        String fullGreeting = data.getStringExtra("full_greeting");
        greetingNameText.setText(fullGreeting);
        super.onActivityResult(requestCode, resultCode, data);
    }
}