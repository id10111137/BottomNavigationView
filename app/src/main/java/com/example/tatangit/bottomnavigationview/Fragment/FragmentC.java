package com.example.tatangit.bottomnavigationview.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tatangit.bottomnavigationview.R;

import butterknife.ButterKnife;

public class FragmentC extends Fragment {

    View root;
    public FragmentC(){
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_c, container, false);
        ButterKnife.bind(this, root);
        return root;
    }



}
