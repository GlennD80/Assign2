package com.example.sda_as2_part2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        EditText emailTo = findViewById(R.id.emailTo);
        EditText subject = findViewById(R.id.subject);
        EditText compose = findViewById(R.id.compose);
        Button saveBtn = findViewById(R.id.btnSave);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_To = emailTo.getText().toString();
                String email_subject = subject.getText().toString();
                String email_compose = compose.getText().toString();

                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.putExtra("NAME", email_To);
                intent.putExtra("EMAIL", email_subject);
                intent.putExtra("COMPOSE", email_compose);
                startActivity(intent);
            }
        });



    }
}