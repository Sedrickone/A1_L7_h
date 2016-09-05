package com.onegmail.sedrick.a1_l7_h.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.onegmail.sedrick.a1_l7_h.objects.Note;
import com.onegmail.sedrick.a1_l7_h.R;

import java.util.List;

/**
 * Created by ОБИ on 04.09.2016.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.NotesViewHolder> {

    private List<Note> notes;

    public RVAdapter(List<Note> notes) {
        this.notes = notes;
    }

    @Override
    public NotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        NotesViewHolder notesViewHolder=new NotesViewHolder(view);

        return notesViewHolder;

    }

    @Override
    public void onBindViewHolder(NotesViewHolder holder, int position) {

        holder.header.setText(notes.get(position).getHeader());
        holder.text.setText(notes.get(position).getText());
        holder.image.setImageResource(notes.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class NotesViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView header;
        TextView text;
        ImageView image;

        public NotesViewHolder(View itemView) {
            super(itemView);

            cv=(CardView)itemView.findViewById(R.id.cv);
            header=(TextView)itemView.findViewById(R.id.note_header);
            text=(TextView)itemView.findViewById(R.id.note_text);
            image=(ImageView)itemView.findViewById(R.id.note_image);
        }
    }
}
