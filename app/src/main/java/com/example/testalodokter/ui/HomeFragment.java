package com.example.testalodokter.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testalodokter.R;
import com.example.testalodokter.adapter.AdapterMenu;
import com.example.testalodokter.utils.DummyData;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView rvMenu = v.findViewById(R.id.rvMenu);

        int[] listImage = DummyData.imagesMenu();

        rvMenu.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rvMenu.setLayoutManager(linearLayoutManager);
        AdapterMenu adapterMenu = new AdapterMenu(getActivity(), listImage);
        rvMenu.setAdapter(adapterMenu);

        return v;
    }
}