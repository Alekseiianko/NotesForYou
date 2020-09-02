package com.example.notesforyou;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotesViewAdapter extends RecyclerView.Adapter<NotesViewAdapter.NotesViewHolder>{

    private ArrayList <NoteForView> notes;
    private Context context;

    class NotesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView title;
        TextView note;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.titleOfNote);
            note = itemView.findViewById(R.id.textOfNote);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            NoteForView arrayListPosition = notes.get(position);
            Intent intent = new Intent(context, UserFullNote.class); // сделать класс для отображения заметки
            intent.putExtra("textResource", arrayListPosition.getTitle());
            intent.putExtra("textResource2", arrayListPosition.getText());
            context.startActivity(intent);
        }
    }

    public NotesViewAdapter(ArrayList<NoteForView> arrayList, Context context) {
        this.notes = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_view, parent, false);
        NotesViewHolder notesViewHolder = new NotesViewHolder(view);
        return notesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        NoteForView noteForView = notes.get(position);
        holder.title.setText(noteForView.getTitle());
        holder.note.setText(noteForView.getText());
    }

    @Override
    public int getItemCount() {
        int size = notes.size();
        return size;
    }
}
