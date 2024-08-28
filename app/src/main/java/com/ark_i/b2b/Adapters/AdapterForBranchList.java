package com.ark_i.b2b.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ark_i.b2b.Models.ModelClassForBranchList;
import com.ark_i.b2b.R;

import java.util.ArrayList;

public class AdapterForBranchList extends RecyclerView.Adapter<AdapterForBranchList.MyViewHolder> {

    public AdapterForBranchList(Context context, ArrayList<ModelClassForBranchList> list) {
        this.context = context;
        this.list = list;

    }



    Context context;
    ArrayList<ModelClassForBranchList> list;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.brachlistdesign,parent,false);
        return new AdapterForBranchList.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelClassForBranchList model = list.get(position);


        holder.branch.setText(model.getBranchaddress());
        holder.location.setText(model.getLocationaddress());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView branch,location;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            branch = itemView.findViewById(R.id.TvCountryName);
            location = itemView.findViewById(R.id.TvLocation);
        }
    }
}
