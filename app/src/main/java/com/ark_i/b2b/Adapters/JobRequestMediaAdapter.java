package com.ark_i.b2b.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ark_i.b2b.Models.JobRequestMediaModelClass;
import com.ark_i.b2b.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class JobRequestMediaAdapter extends RecyclerView.Adapter<JobRequestMediaAdapter.RequestMediaViewHolder> {
    List<JobRequestMediaModelClass> requestMediaModelClassLists;

    public JobRequestMediaAdapter(List<JobRequestMediaModelClass> requestMediaModelClassLists) {
        this.requestMediaModelClassLists = requestMediaModelClassLists;
    }

    @NonNull
    @Override
    public JobRequestMediaAdapter.RequestMediaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.media_item,parent,false);
        return new RequestMediaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobRequestMediaAdapter.RequestMediaViewHolder holder, int position) {
        JobRequestMediaModelClass jobRequestMediaModelClass = requestMediaModelClassLists.get(position);

        Picasso.get()
                .load(jobRequestMediaModelClass.getURL())
                .into(holder.view);




    }

    @Override
    public int getItemCount() {
        return requestMediaModelClassLists.size();
    }

    static class RequestMediaViewHolder extends RecyclerView.ViewHolder{

        ImageView view;

        public RequestMediaViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.ivImages);

        }
    }
}
