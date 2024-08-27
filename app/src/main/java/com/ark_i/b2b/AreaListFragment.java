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
import android.widget.TextView;

import com.ark_i.b2b.Adapters.AdapterForAreaList;
import com.ark_i.b2b.Models.ModelClassForAreaList;
import com.ark_i.b2b.databinding.FragmentAreaListBinding;
import com.ark_i.b2b.databinding.FragmentBranchListBinding;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AreaListFragment extends Fragment {


    AdapterForAreaList adapter;
    ArrayList<ModelClassForAreaList> list;
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
        recyclerView = view.findViewById(R.id.AreaListRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        list = new ArrayList<>();
        adapter = new AdapterForAreaList(requireContext(),list);
        recyclerView.setAdapter(adapter);


    }

    private void dataadd() {
        list.add(new ModelClassForAreaList("London","KFC - Manchester","13, Main St. Antony, UK"));
        list.add(new ModelClassForAreaList("UK","DFC - Manchester","322, Main St. Antony, UK"));
        list.add(new ModelClassForAreaList("Pairs","BFC - Manchester","233, Main St. Antony, UK"));
        list.add(new ModelClassForAreaList("Lhaore","SFC - Manchester","173, Main St. Antony, UK"));
    }



}