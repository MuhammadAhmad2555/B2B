package com.ark_i.b2b;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ark_i.b2b.Adapters.AdapterForAreaList;
import com.ark_i.b2b.Adapters.AdapterForBranchList;
import com.ark_i.b2b.Models.ModelClassForAreaList;
import com.ark_i.b2b.Models.ModelClassForBranchList;
import com.ark_i.b2b.databinding.FragmentBranchListBinding;
import com.ark_i.b2b.databinding.FragmentDashboardBinding;

import java.util.ArrayList;


public class BranchListFragment extends Fragment {
    FragmentBranchListBinding binding;

    RecyclerView recyclerView;
    ArrayList<ModelClassForBranchList> list;
    AdapterForBranchList adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentBranchListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclewViewSetUp(view);


    }

    private void RecyclewViewSetUp(View view) {
        recyclerView = view.findViewById(R.id.BrachListRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        list = new ArrayList<>();
        adapter = new AdapterForBranchList(requireContext(),list);
        recyclerView.setAdapter(adapter);


    }
}