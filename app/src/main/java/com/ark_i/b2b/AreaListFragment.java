package com.ark_i.b2b;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ark_i.b2b.Adapters.AdapterForAreaList;
import com.ark_i.b2b.Models.ModelClassForAreaList;
import com.ark_i.b2b.databinding.FragmentAreaListBinding;
import com.ark_i.b2b.databinding.FragmentBranchListBinding;

import java.util.ArrayList;

public class AreaListFragment extends Fragment {

    FragmentAreaListBinding binding;
    AdapterForAreaList adapter;
    ArrayList<ModelClassForAreaList> list;
    RecyclerView recyclerView;
    NavController navController ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAreaListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);


        RecyclewViewSetUp(view);

        binding.BtnMenu.setOnClickListener(v ->  navController.navigate(R.id.action_areaListFragment_to_branchListFragment));





    }

    void RecyclewViewSetUp(View view){
        recyclerView = view.findViewById(R.id.AreaListRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        list = new ArrayList<>();
        adapter = new AdapterForAreaList(requireContext(),list);
        recyclerView.setAdapter(adapter);


    }
}