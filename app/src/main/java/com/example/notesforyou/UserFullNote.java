package com.example.notesforyou;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class UserFullNote extends AppCompatActivity {

    EditText textView1;
    EditText textView2;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_full_note);

        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView3);

        Intent intent = getIntent();
        if (intent != null){
            textView1.setText(intent.getStringExtra("textResource"));
            textView2.setText(intent.getStringExtra("textResource2"));
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, Notes.class);
        if(item.getItemId() == R.id.action_save){
            String title = textView1.getText().toString();
            String text = textView2.getText().toString();
            NoteForView noteForView = new NoteForView(title, text);
            intent.putExtra(NoteForView.class.getSimpleName(), noteForView);
        } else { }
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.save_menu, menu);
        return true;
    }

}
