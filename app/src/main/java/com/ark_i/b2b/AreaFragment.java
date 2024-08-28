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

import com.ark_i.b2b.Adapters.AreaAdapter;
import com.ark_i.b2b.Models.AreaAmModel;

import java.util.ArrayList;

public class AreaFragment extends Fragment {


    AreaAdapter areaAdapter;
    ArrayList<AreaAmModel> areaAmModels;
    RecyclerView recyclerView;
    NavController navController ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_area_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);


        RecyclewViewSetUp(view);
        dataadd();








    }

    void initializations(View view){

    }

    void RecyclewViewSetUp(View view){
        recyclerView = view.findViewById(R.id.areaRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        areaAmModels = new ArrayList<>();
        areaAdapter = new AreaAdapter(areaAmModels);
        recyclerView.setAdapter(areaAdapter);


    }

    private void dataadd() {
        areaAmModels.add(new AreaAmModel("London","KFC - Manchester","13, Main St. Antony, UK"));
        areaAmModels.add(new AreaAmModel("UK","DFC - Manchester","322, Main St. Antony, UK"));
        areaAmModels.add(new AreaAmModel("Pairs","BFC - Manchester","233, Main St. Antony, UK"));
        areaAmModels.add(new AreaAmModel("Lhaore","SFC - Manchester","173, Main St. Antony, UK"));
    }



}