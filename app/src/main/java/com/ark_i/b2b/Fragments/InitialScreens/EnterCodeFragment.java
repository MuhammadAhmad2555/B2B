package com.ark_i.b2b.Fragments.InitialScreens;




import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import android.widget.Toast;

import com.ark_i.b2b.R;
import com.ark_i.b2b.databinding.FragmentEnterCodeBinding;

public class EnterCodeFragment extends Fragment {
    FragmentEnterCodeBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentEnterCodeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);






        binding.EdFoEnCo1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count==1){
                    binding.EdFoEnCo2.requestFocus();

                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.EdFoEnCo2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count==1){
                    binding.EdFoEnCo3.requestFocus();

                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.EdFoEnCo3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count==1){

                    binding.EdFoEnCo4.requestFocus();



                }


            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });
        binding.EdFoEnCo4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count==1){
                    hideInputWindow(binding.EdFoEnCo4);

                }


            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });
        binding.btCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  code1,code2,code3,code4;
                code1 = String.valueOf(binding.EdFoEnCo1.getText());
                code2 = String.valueOf(binding.EdFoEnCo2.getText());
                code3 = String.valueOf(binding.EdFoEnCo3.getText());
                code4 = String.valueOf(binding.EdFoEnCo4.getText());

                if(!code1.isEmpty() && !code2.isEmpty() &&!code3.isEmpty() && !code4.isEmpty() ){
                    Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT).show();
                    Navigation.findNavController(view).navigate(R.id.action_enterCodeFragment_to_newPasswordFragment);
                }else {
                    Toast.makeText(requireContext(), "EMPTY", Toast.LENGTH_SHORT).show();

                }
            }
        });










    }

    void  hideInputWindow(EditText editText){
        InputMethodManager imm = (InputMethodManager) requireContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }
}