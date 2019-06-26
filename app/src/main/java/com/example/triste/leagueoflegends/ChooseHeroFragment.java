package com.example.triste.leagueoflegends;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import db.Hero;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import util.HttpUtil;

public class ChooseHeroFragment extends Fragment {

    private RecyclerView recyclerView;

    private ImageView imageView;

    private List<Hero> heroList = new ArrayList<>();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.choose_hero,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.hero_list);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        initHero();
        HeroAdapter adapter = new HeroAdapter(heroList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void initHero() {
        String requestHeroPic = "https://ossweb-img.qq.com/images/lol/img/champion/Aatrox.png";
        for(int i = 0; i < 50 ;i++){
            Hero hero = new Hero(requestHeroPic,"暗裔剑魔","亚托克斯","Aatrox");
            heroList.add(hero);
        }
    }

}
