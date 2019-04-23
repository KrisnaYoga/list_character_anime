package com.a1705551024.list_character_anime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Anime> list = new ArrayList<>();
    private static final String TAG = "mainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list.addAll(AnimeData.getListData());
        showRecyclerGrid();
    }

    private void showSelectedAnime(Anime anime) {
        Toast.makeText(this, "You Choose " + anime.getName(), Toast.LENGTH_SHORT).show();
    }

    private void showRecyclerGrid(){
        Log.d(TAG,"ShowRecyclerGrid : ");

        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridAnimeAdapter gridAnimeAdapter = new GridAnimeAdapter(this);
        gridAnimeAdapter.setListAnime(list);
        rvCategory.setAdapter(gridAnimeAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Log.d(TAG,"onClick: Clickedon.");

                showSelectedAnime(list.get(position));
                Intent intent = new Intent(MainActivity.this, AnimeListChar.class);

                intent.putExtra("namechar",AnimeData.getListData().get(position).getName());
                intent.putExtra("chardesc",AnimeData.getListData().get(position).getDescription());
                intent.putExtra("imgchar",AnimeData.getListData().get(position).getHerocostum());
                intent.putExtra("quirkchar",AnimeData.getListData().get(position).getQuirks());

                //Content Table
                intent.putExtra("powerchar",AnimeData.getListData().get(position).getPower());
                intent.putExtra("speedchar",AnimeData.getListData().get(position).getSpeed());
                intent.putExtra("techniquechar",AnimeData.getListData().get(position).getTechnique());
                intent.putExtra("intelligencechar",AnimeData.getListData().get(position).getIntelligence());
                intent.putExtra("cooperativenesschar",AnimeData.getListData().get(position).getCooperativeness());

                intent.putExtra("directto",AnimeData.getListData().get(position).getDirectlink());

                startActivity(intent);
            }
        });

    }

    private void showRecyclerList(){
        Log.d(TAG,"ShowRecyclerList : ");
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListAnimeAdapter listAnimeAdapter = new ListAnimeAdapter(this);
        listAnimeAdapter.setListAnime(list);
        rvCategory.setAdapter(listAnimeAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_list:
                showRecyclerList();
                break;
            case R.id.action_grid:
                showRecyclerGrid();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
