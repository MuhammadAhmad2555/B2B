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


    List<NotificationAmModel> notificationAmModelsList;

    public NotificationAdapter(List<NotificationAmModel> notificationAmModelsList) {
        this.notificationAmModelsList = notificationAmModelsList;
    }

    @NonNull
    @Override
    public NotifivationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item,parent,false);
        return new NotifivationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotifivationViewHolder holder, int position) {
        NotificationAmModel notificationAmModel = notificationAmModelsList.get(position);

        holder.tvJobId.setText(notificationAmModel.getJobId());
        holder.tvDescriptionNot.setText(notificationAmModel.getJobDescription());
        holder.tvStatus.setText(notificationAmModel.getJobStatus());


    }

    @Override
    public int getItemCount() {
        return notificationAmModelsList.size();
    }

    static class NotifivationViewHolder extends RecyclerView.ViewHolder{
        TextView tvJobId,tvDescriptionNot,tvStatus;

        public NotifivationViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJobId = itemView.findViewById(R.id.tvJobId);
            tvDescriptionNot = itemView.findViewById(R.id.tvDescriptionNot);
            tvStatus = itemView.findViewById(R.id.tvStatus);
        }

    }
}
