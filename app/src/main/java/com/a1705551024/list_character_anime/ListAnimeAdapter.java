package com.a1705551024.list_character_anime;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListAnimeAdapter extends RecyclerView.Adapter<ListAnimeAdapter.CategoryViewHolder> {
    private static final String TAG = "ListAnimeAdapter";

    public ListAnimeAdapter(Context context) {
        this.context = context;
    }

    public Context context;

    public ArrayList<Anime> getListAnime() {
        return listAnime;
    }

    public void setListAnime(ArrayList<Anime> listAnime) {
        this.listAnime = listAnime;
    }

    public ArrayList<Anime> listAnime;

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_char_anime, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, final int position) {
        Log.d(TAG, "onBindViewHolder : called.");

        categoryViewHolder.tvName.setText(getListAnime().get(position).getName());
        categoryViewHolder.tvRemarks.setText(getListAnime().get(position).getHeroname());
        Glide.with(context)
                .load(getListAnime().get(position).getHeadhero())
                .apply(new RequestOptions().override(200, 200))
                .into(categoryViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListAnime().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}