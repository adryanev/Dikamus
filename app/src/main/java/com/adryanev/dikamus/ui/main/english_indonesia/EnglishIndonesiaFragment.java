package com.adryanev.dikamus.ui.main.english_indonesia;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adryanev.dikamus.R;

public class EnglishIndonesiaFragment extends Fragment {

    private EnglishIndonesiaViewModel mViewModel;

    public static EnglishIndonesiaFragment newInstance() {
        return new EnglishIndonesiaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.english_indonesia_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(EnglishIndonesiaViewModel.class);
        // TODO: Use the ViewModel
    }

}
