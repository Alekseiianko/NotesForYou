package com.example.notesforyou;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.widget.AdapterView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.util.ArrayList;

public class Notes extends AppCompatActivity {

    FloatingActionButton button;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<NoteForView> arrayList;
    SharedPreferences sPref;
    NoteForView note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

//        Bundle arguments = getIntent().getExtras();
//
//        if(arguments!=null){
//            note = (NoteForView) arguments.getSerializable(NoteForView.class.getSimpleName());
//
//            arrayList.add(note);
//        }
        if (savedInstanceState != null) {
            arrayList = savedInstanceState.getParcelable("Lol");
        }

        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        Gson gson = new Gson();
        String strObj = getIntent().getStringExtra(NoteForView.class.getSimpleName());
        NoteForView obj = gson.fromJson(strObj, NoteForView.class);
        if(obj != null){
            arrayList.add(obj);
        }

        button = findViewById(R.id.floatingActionButton);
        recyclerView = findViewById(R.id.Notes);
        recyclerView.setHasFixedSize(true);
        adapter = new NotesViewAdapter(arrayList, this);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }


    public void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.inflate(R.menu.popup_menu);
        final Intent intent = new Intent (this, WriteNoteActivity.class);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu1:
                                intent.putExtra("note", "");
                                startActivity(intent);
                                Toast.makeText(getApplicationContext(),
                                        "You changed note",
                                        Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.menu2:
                                intent.putExtra("titleAndNote", "");
                                startActivity(intent);
                                Toast.makeText(getApplicationContext(),
                                        "You changed title and note",
                                        Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.menu3:
                                intent.putExtra("deadlineNote", "");
                                startActivity(intent);
                                Toast.makeText(getApplicationContext(),
                                        "You changed note with deadline",
                                        Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                                return false;
                        }
                    }
                });
        popupMenu.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent openSettings = new Intent(this, SettingsActivity.class);
        startActivity(openSettings);
        return super.onOptionsItemSelected(item);
    }

}
