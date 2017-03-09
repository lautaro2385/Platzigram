package com.lautaro.platzigram.views.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lautaro.platzigram.R;
import com.lautaro.platzigram.adapters.PictureAdapterRecycleView;
import com.lautaro.platzigram.models.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        showActionBar(getResources().getString(R.string.tab_home), false, view);

        RecyclerView pictureRecycler = (RecyclerView) view.findViewById(R.id.pictureRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        pictureRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecycleView agapter = new PictureAdapterRecycleView(buildPictures(), getActivity(), R.layout.cardview_picture);

        pictureRecycler.setAdapter(agapter);

        return view;
    }

    private ArrayList<Picture> buildPictures(){
        ArrayList<Picture> pictures =  new ArrayList<>();
        pictures.add(new Picture("", "Lautaro Realpe", "1 dias", "10"));
        pictures.add(new Picture("", "TAvo Realpe", "1 dias", "10"));
        pictures.add(new Picture("", "Lautaro Fresneda", "1 dias", "10"));
        return pictures;
    }

    public void showActionBar(String title, boolean upButton, View view) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
