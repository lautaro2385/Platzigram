package com.lautaro.platzigram.views.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
public class SearchFragment extends Fragment {


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        RecyclerView pictureRecycler = (RecyclerView) view.findViewById(R.id.recyclerViewSearch);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);

        pictureRecycler.setLayoutManager(gridLayoutManager);

        PictureAdapterRecycleView agapter = new PictureAdapterRecycleView(buildPictures(), getActivity(), R.layout.cardview_picture);

        pictureRecycler.setAdapter(agapter);

        return view;
    }

    private ArrayList<Picture> buildPictures() {
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("", "Lautaro Realpe", "1 dias", "10"));
        pictures.add(new Picture("", "TAvo Realpe", "1 dias", "10"));
        pictures.add(new Picture("", "Lautaro Fresneda", "1 dias", "10"));
        return pictures;
    }

}
