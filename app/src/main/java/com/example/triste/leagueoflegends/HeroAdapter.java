package com.example.triste.leagueoflegends;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import db.Hero;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {

    private List<Hero> heroList;

    static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView heroImage;
        TextView heroName;
        TextView designNation;
        TextView heroEnglishName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            heroImage = (ImageView) itemView.findViewById(R.id.hero_image);
            designNation = (TextView) itemView.findViewById(R.id.hero_designNation);
            heroName = (TextView) itemView.findViewById(R.id.hero_name);
            heroEnglishName = (TextView) itemView.findViewById(R.id.hero_english_name);
        }
    }


    public HeroAdapter(List<Hero> heroList){
        this.heroList = heroList;
    }

    @NonNull
    @Override
    public HeroAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hero_item,viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HeroAdapter.ViewHolder viewHolder, int i) {
        final Hero hero = heroList.get(i);

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                final Bitmap bitmap = returnBitMap(hero.getImageUrl());
                viewHolder.heroImage.post(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        viewHolder.heroImage.setImageBitmap(bitmap);
                    }
                });
            }
        }).start();
        viewHolder.designNation.setText(hero.getDesignNation());
        viewHolder.heroName.setText(hero.getName());
        viewHolder.heroEnglishName.setText(hero.getEnglishName());
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    private Bitmap returnBitMap(String url) {
        URL myFileUrl = null;
        Bitmap bitmap = null;
        try {
            myFileUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            HttpURLConnection conn = (HttpURLConnection) myFileUrl
                    .openConnection();
            conn.setDoInput(true);
            conn.connect();
            InputStream is = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
