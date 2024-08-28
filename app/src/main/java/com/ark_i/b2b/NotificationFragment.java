package com.ark_i.b2b;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ark_i.b2b.Adapters.AreaAdapter;
import com.ark_i.b2b.Adapters.NotificationAdapter;
import com.ark_i.b2b.Models.AreaAmModel;
import com.ark_i.b2b.Models.NotificationAmModel;

import java.util.ArrayList;
import java.util.List;


public class NotificationFragment extends Fragment {
    NotificationAdapter notificationAdapter;
    ArrayList<NotificationAmModel> notificationAmModelList;
    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_notification, container, false);
        RecyclewViewSetUp(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    void RecyclewViewSetUp(View view){
        recyclerView = view.findViewById(R.id.notificationRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        notificationAmModelList = new ArrayList<>();
        notificationAdapter = new NotificationAdapter(notificationAmModelList);
        dataadd();
        recyclerView.setAdapter(notificationAdapter);


    }



    private void dataadd() {
        notificationAmModelList.add(new NotificationAmModel("17285","Just Now","Lorem ipsum dolor sit amet consectetur."));
        notificationAmModelList.add(new NotificationAmModel("128473U","Just Now","Lorem ipsum dolor sit amet consectetur."));
        notificationAmModelList.add(new NotificationAmModel("2839461","5 min ago","Lorem ipsum dolor sit amet consectetur."));
        notificationAmModelList.add(new NotificationAmModel("371826","2 min ago","Lorem ipsum dolor sit amet consectetur."));
    }
}