package com.ark_i.b2b.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ark_i.b2b.Models.ModelClassForAreaList;
import com.ark_i.b2b.R;

import java.util.ArrayList;

public class AdapterForAreaList extends RecyclerView.Adapter<AdapterForAreaList.MyViewHolder> {

    public AdapterForAreaList(Context context, ArrayList<ModelClassForAreaList> list) {
        this.context = context;
        this.list = list;

    }



    Context context;
    ArrayList<ModelClassForAreaList> list;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.arealistdesign,parent,false);
        return new AdapterForAreaList.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelClassForAreaList model = list.get(position);
        holder.country.setText(model.getCountryadress());
        holder.branch.setText(model.getBranchaddress());
        holder.location.setText(model.getLocationaddress());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView country,branch,location;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            country = itemView.findViewById(R.id.TvCountryName);
            branch = itemView.findViewById(R.id.TvBranchName);
            location = itemView.findViewById(R.id.TvLocation);
        }


    }
}
