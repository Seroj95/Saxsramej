package com.photo.note2;

import android.support.annotation.NonNull;
import android.support.v4.app.NavUtils;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {
    private ArrayList<Note>notes;
private OnNoteClickListener onNoteClickListener;
    public NotesAdapter(ArrayList<Note> notes) {
        this.notes = notes;
    }
interface  OnNoteClickListener{
        void onNoteClick (int position);
void onLogClick(int position);
}

    public void setOnNoteClickListener(OnNoteClickListener onNoteClickListener) {
        this.onNoteClickListener = onNoteClickListener;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.note_item, viewGroup, false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder notesViewHolder, int i) {
        Note note=notes.get(i);
        notesViewHolder.textViewTitle.setText(note.getTitle());
        notesViewHolder.textViewDescreption.setText(note.getDescreption());
        notesViewHolder.textViewDayOfWeek.setText(Note.getDayAsString(note.getDayOfWeak()+1));
//        notesViewHolder.textViewPriorety.setText(String.format("%s",note.getProreti()));
        int colorId = 0;
        int prorety=note.getProreti();
        switch (prorety){
            case 1:
                colorId=notesViewHolder.itemView.getResources().getColor(android.R.color.holo_red_dark);
                break;
            case 2:
                colorId=notesViewHolder.itemView.getResources().getColor(android.R.color.holo_orange_light);
                break;
            case 3:
                colorId=notesViewHolder.itemView.getResources().getColor(android.R.color.holo_green_light);
                break;
        }
notesViewHolder.textViewTitle.setBackgroundColor(colorId);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NotesViewHolder extends RecyclerView.ViewHolder{
 private  TextView textViewTitle;
 private  TextView textViewDescreption;
 private  TextView textViewDayOfWeek;
 private  TextView textViewPriorety;
        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle=itemView.findViewById(R.id.textViewTitle);
            textViewDescreption=itemView.findViewById(R.id.textViewDescreption);
            textViewDayOfWeek=itemView.findViewById(R.id.textViewDayOfWeek);
//            textViewPriorety=itemView.findViewById(R.id.textViewProrety);
itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (onNoteClickListener!=null){
            onNoteClickListener.onNoteClick(getAdapterPosition());
        }
    }
});
itemView.setOnLongClickListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View v) {
        if (onNoteClickListener!=null){
            onNoteClickListener.onLogClick(getAdapterPosition());
        }
        return true;
    }
});
        }
    }
}
