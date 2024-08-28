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

import com.ark_i.b2b.Adapters.AdapterForBranchList;
import com.ark_i.b2b.Models.ModelClassForBranchList;

import java.util.ArrayList;


public class BranchListFragment extends Fragment {


    RecyclerView recyclerView;
    ArrayList<ModelClassForBranchList> list;
    AdapterForBranchList adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_branch_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclewViewSetUp(view);
        dataadd();


    }

    private void RecyclewViewSetUp(View view) {

        recyclerView = view.findViewById(R.id.BrachListRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        list = new ArrayList<>();
        adapter = new AdapterForBranchList(requireContext(),list);
        recyclerView.setAdapter(adapter);


    }

    private void dataadd() {
        list.add(new ModelClassForBranchList("KFC - Manchester","13, Main St. Antony, UK"));
        list.add(new ModelClassForBranchList("DFC - Manchester","322, Main St. Antony, UK"));
        list.add(new ModelClassForBranchList("BFC - Manchester","233, Main St. Antony, UK"));
        list.add(new ModelClassForBranchList("SFC - Manchester","173, Main St. Antony, UK"));
    }
}