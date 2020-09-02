package com.example.notesforyou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserFullNote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_full_note);
        TextView textView1 = findViewById(R.id.textView1);
        TextView textView2 = findViewById(R.id.textView3);

        Intent intent = getIntent();
        if (intent != null){
            textView1.setText(intent.getStringExtra("textResource"));
            textView2.setText(intent.getStringExtra("textResource3"));
        }
    }

    public void back(View view) {
        Intent intent = new Intent(this, Notes.class);
        startActivity(intent);
    }
}
