package com.a1705551024.list_character_anime;

import java.util.ArrayList;

public class AnimeData {
    public static String[][] data = new String[][]{
            {"Angel Beats","https://cdn.myanimelist.net/images/anime/10/22061l.jpg"},
            {"Boku no Hero Academia","https://cdn.myanimelist.net/images/anime/10/78745l.jpg"},
            {"Captain Tsubasa","https://cdn.myanimelist.net/images/anime/5/75526l.jpg"},
            {"Detective Conan","https://cdn.myanimelist.net/images/anime/2/44233l.jpg"},
            {"Eyeshield 21","https://cdn.myanimelist.net/images/anime/4/24792l.jpg"},
            {"Fullmetal Alchemist: Brotherhood", "https://cdn.myanimelist.net/images/anime/7/74317l.jpg"},
            {"Gintama","https://cdn.myanimelist.net/images/anime/10/73274l.jpg"},
            {"Haikyuu!","https://cdn.myanimelist.net/images/anime/4/60431l.jpg"}
    };

    public static ArrayList<Anime> getListData(){
        Anime anime = null;
        ArrayList<Anime> list = new ArrayList<>();
        for (String[] aData : data){
            anime = new Anime();
            anime.setName(aData[0]);
            anime.setPhoto(aData[1]);

            list.add(anime);
        }

        return list;
    }
}
