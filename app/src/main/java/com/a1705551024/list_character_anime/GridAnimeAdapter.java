package com.a1705551024.list_character_anime;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridAnimeAdapter extends RecyclerView.Adapter<GridAnimeAdapter.GridViewHolder> {
    private static final String TAG = "GridAnimeAdapter";

    public Context context;

    public GridAnimeAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Anime> listAnime;

    public ArrayList<Anime> getListAnime() {
        return listAnime;
    }

    public void setListAnime(ArrayList<Anime> listAnime) {
        this.listAnime = listAnime;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_char_anime, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder : called.");

        Glide.with(context)
                .load(getListAnime().get(position).getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListAnime().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        RecyclerView rv_category;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            rv_category = itemView.findViewById(R.id.rv_category);
        }
    }
}
