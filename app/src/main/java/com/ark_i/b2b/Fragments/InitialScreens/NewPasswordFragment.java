package com.ark_i.b2b.Fragments.InitialScreens;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ark_i.b2b.R;
import com.ark_i.b2b.databinding.FragmentNewPasswordBinding;


public class NewPasswordFragment extends Fragment {
    FragmentNewPasswordBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentNewPasswordBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.SePaBt.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_newPasswordFragment_to_passwordChangeSuccessFragment));
    }
}