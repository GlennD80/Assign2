package com.example.sda_as2_part2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button Sendbtn;
    TextView camera;
    TextView gallery;
    TextView callact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        camera=(TextView)findViewById(R.id.OpenCam);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_cam = new Intent();
                intent_cam.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent_cam);
            }
        });

        gallery=(TextView)findViewById(R.id.ViewPic);
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_gal = new Intent();
                intent_gal.setAction(android.content.Intent.ACTION_VIEW);
                intent_gal.setType("image/*");
                intent_gal.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent_gal);
            }
        });

        callact=(TextView)findViewById(R.id.CallAct);
        callact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_callact = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent_callact);
            }
        });

        TextView emailTxt = findViewById(R.id.EmailTxt);

        Intent intent = getIntent();
        String email_To = intent.getStringExtra("NAME");
        String email_subject = intent.getStringExtra("EMAIL");
        String email_compose = intent.getStringExtra("COMPOSE");

        if (email_To != null && email_subject != null && email_compose != null)
            emailTxt.setText("To: " + email_To + "\nSubject: " + email_subject + "\nContent: " + email_compose);

        Button emailSndBtn = findViewById(R.id.Sendbtn);
        emailSndBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEMail();
            }

            private void sendEMail() {
                String[] recipients = email_To.split(",");

                String email_To = intent.getStringExtra("NAME");
                String email_subject = intent.getStringExtra("EMAIL");
                String email_compose = intent.getStringExtra("COMPOSE");

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT, email_subject);
                intent.putExtra(Intent.EXTRA_TEXT, email_compose);

                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent, "Choose an email provider"));
            }
        });
    }
}

