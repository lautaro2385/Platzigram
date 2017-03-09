package com.lautaro.platzigram.adapters;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.text.style.BulletSpan;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lautaro.platzigram.R;
import com.lautaro.platzigram.models.Picture;
import com.lautaro.platzigram.views.PictureDetailActivity;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Gustavo Realpe on 5/03/2017.
 */

public class PictureAdapterRecycleView extends RecyclerView.Adapter<PictureAdapterRecycleView.PictureViewHolder> {

    private ArrayList<Picture> pictures = new ArrayList<>();
    private Activity activity;
    private int resource;

    public PictureAdapterRecycleView(ArrayList<Picture> pictures, Activity activity, int resource) {
        this.pictures = pictures;
        this.activity = activity;
        this.resource = resource;
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {
        Picture picture = pictures.get(position);
        holder.usernameCard.setText(picture.getUsername());
        holder.likesCard.setText(picture.getLike_number());
        holder.timeCard.setText(picture.getTime());

        holder.imageCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, PictureDetailActivity.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Explode explode = new Explode();
                    explode.setDuration(5000);
                    activity.getWindow().setExitTransition(explode);
                    Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, v, activity.getString(R.string.transitionNameImageProfile)).toBundle();
                    activity.startActivity(intent, bundle);
                }else {
                    activity.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    protected class PictureViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageCard;
        private TextView usernameCard;
        private TextView timeCard;
        private TextView likesCard;


        public PictureViewHolder(View itemView) {
            super(itemView);
            imageCard = (ImageView) itemView.findViewById(R.id.imageCard);
            usernameCard = (TextView) itemView.findViewById(R.id.usernameCard);
            timeCard = (TextView) itemView.findViewById(R.id.timeCard);
            likesCard = (TextView) itemView.findViewById(R.id.likesCard);
        }
    }
}
