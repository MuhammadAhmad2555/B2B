package com.ark_i.b2b.Fragments.InitialScreens;

import static com.ark_i.b2b.R.id.action_loginFragment_to_forgotPasswordFragment;
import static com.ark_i.b2b.R.id.action_loginFragment_to_homeFragment;
import static com.ark_i.b2b.R.id.action_loginFragment_to_jobDescriptionFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.ark_i.b2b.databinding.FragmentLoginBinding;


public class loginFragment extends Fragment {
    FragmentLoginBinding binding;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding  =  FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.FoPaBt.setOnClickListener(v -> Navigation.findNavController(v).navigate(action_loginFragment_to_forgotPasswordFragment));
        binding.BtLo.setOnClickListener(v -> Navigation.findNavController(v).navigate(action_loginFragment_to_jobDescriptionFragment));






    }
}