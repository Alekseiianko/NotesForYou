package com.example.notesforyou;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class WriteNoteActivity extends AppCompatActivity {

    EditText editTitle;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_note);

        editTitle = findViewById(R.id.editTitle);
        editText = findViewById(R.id.editText);

        Bundle arguments = getIntent().getExtras();
        if(arguments.equals("note")){
            editTitle.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.save_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String title = editTitle.getText().toString();
        String text = editText.getText().toString();
        Intent save = new Intent(this, Notes.class);
        NoteForView noteForView = new NoteForView(title, text);
        save.putExtra(NoteForView.class.getSimpleName(), noteForView);
        startActivity(save);
        return super.onOptionsItemSelected(item);
    }
}
