package com.ark_i.b2b.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ark_i.b2b.Models.AreaAmModel;
import com.ark_i.b2b.R;

import java.util.ArrayList;

public class AreaAdapter extends RecyclerView.Adapter<AreaAdapter.MyViewHolder> {



    ArrayList<AreaAmModel> areaAmModels ;

    public AreaAdapter(ArrayList<AreaAmModel> areaAmModels) {
        this.areaAmModels = areaAmModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.area_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AreaAmModel areaAmModel = areaAmModels.get(position);
        holder.tvCountryName.setText(areaAmModel.getCountryName());
        holder.tvCompanyName.setText(areaAmModel.getCompanyName());
        holder.tvLocation.setText(areaAmModel.getLocationName());


    }

    @Override
    public int getItemCount() {
        return areaAmModels.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvCountryName, tvCompanyName, tvLocation;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCountryName = itemView.findViewById(R.id.tvCountryName);
            tvCompanyName = itemView.findViewById(R.id.tvCompanyName);
            tvLocation = itemView.findViewById(R.id.tvLocation);
        }


    }
}
