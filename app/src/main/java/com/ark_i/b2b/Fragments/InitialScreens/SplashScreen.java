package com.ark_i.b2b.Fragments.InitialScreens;

import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ark_i.b2b.R;
import com.ark_i.b2b.databinding.FragmentSplashScreenBinding;

public class SplashScreen extends Fragment {

    private FragmentSplashScreenBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSplashScreenBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        // Navigate after a delay
        new Handler().postDelayed(() -> {
            if (navController.getCurrentDestination() != null) {
                navController.navigate(R.id.action_splashScreen_to_notificationFragment);
            } else {
                Log.e("NavigationError", "NavController has no current destination.");
            }
        }, 1000);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TAG", "onResumeSplash"); // Log to ensure onResume is called
    }


}
