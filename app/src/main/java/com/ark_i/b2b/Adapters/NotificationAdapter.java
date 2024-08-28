package com.ark_i.b2b.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ark_i.b2b.Models.NotificationAmModel;
import com.ark_i.b2b.R;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotifivationViewHolder> {


    List<NotificationAmModel> notificationAmModels;

    public NotificationAdapter(List<NotificationAmModel> notificationAmModels) {
        this.notificationAmModels = notificationAmModels;
    }

    @NonNull
    @Override
    public NotifivationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notesdesign,parent,false);
        return new NotifivationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotifivationViewHolder holder, int position) {
        NotificationAmModel notificationAmModel = notificationAmModels.get(position);


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class NotifivationViewHolder extends RecyclerView.ViewHolder{
        TextView ok1,ok2,ok3;

        public NotifivationViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
