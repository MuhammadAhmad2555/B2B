package com.ark_i.b2b.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ark_i.b2b.Models.ModelClassForNotes;
import com.ark_i.b2b.R;

import java.util.ArrayList;

public class AdapterForNotes extends RecyclerView.Adapter<AdapterForNotes.MyViewHolder> {
    Context context;
    ArrayList<ModelClassForNotes> list;
    public AdapterForNotes(Context context, ArrayList<ModelClassForNotes> list) {
        this.context = context;
        this.list = list;
        addDefaultData();
    }

    private void addDefaultData() {
        list.add(new ModelClassForNotes("Lorem ipsum dolor sit amet consectetur. Porta nulla vel integer nulla viverra integer. Nisl lectus ut semper nunc quam pulvinar nec tortor. ","10:00 03-09-2024"));
        list.add(new ModelClassForNotes("Lorem ipsum dolor sit amet consectetur. Porta nulla vel integer nulla viverra integer. Nisl lectus ut semper nunc quam pulvinar nec tortor. ","12:00 04-09-2024"));
        list.add(new ModelClassForNotes("Lorem ipsum dolor sit amet consectetur. Porta nulla vel integer nulla viverra integer. Nisl lectus ut semper nunc quam pulvinar nec tortor. ","11:00 05-09-2024"));
        list.add(new ModelClassForNotes("Lorem ipsum dolor sit amet consectetur. Porta nulla vel integer nulla viverra integer. Nisl lectus ut semper nunc quam pulvinar nec tortor. ","09:00 06-09-2024"));
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notesdesign,parent,false);
        return new AdapterForNotes.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelClassForNotes model = list.get(position);


        holder.text.setText(model.getText());
        holder.dateTime.setText(model.getDateTime());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView text,dateTime;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.TvNoteData);
            dateTime = itemView.findViewById(R.id.TvDateTime);


        }
    }
}
