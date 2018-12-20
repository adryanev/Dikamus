package com.adryanev.dikamus.ui.main.indonesia_english;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adryanev.dikamus.R;

public class IndonesiaEnglishFragment extends Fragment {

    private IndonesiaEnglishViewModel mViewModel;

    public static IndonesiaEnglishFragment newInstance() {
        return new IndonesiaEnglishFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.indonesia_english_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(IndonesiaEnglishViewModel.class);
        // TODO: Use the ViewModel
    }

}
