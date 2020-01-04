package com.example.unitedremotechallenge;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private ArrayList<Model> mData;
    private Context context;
    public Adapter( Context context,ArrayList<Model> mData) {
        this.mData = mData;
        this.context=context;
    }
    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        CardView v = (CardView) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.linear_view, viewGroup, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder myViewHolder, int i) {
        Model monmodel = mData.get(i);
        String name = monmodel.getRepoName();
        String description = monmodel.getDescription();
        String owner = monmodel.getOwner();
        String stars = monmodel.getStars();

        myViewHolder.text1.setText(name);
        myViewHolder.text3.setText(description);
        myViewHolder.text2.setText(owner);
        myViewHolder.text4.setText(stars);
    }

    @Override
    public int getItemCount() {
        return mData.size();

    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView text1;
        public TextView text2;

        public TextView text3;
        public TextView text4;




        public MyViewHolder(View v) {
            super(v);

            text1 = (TextView) v.findViewById(R.id.name);
            text3 = (TextView) v.findViewById(R.id.description);

            text2 = (TextView) v.findViewById(R.id.owner);
            text4 = (TextView) v.findViewById(R.id.star);

        }
    }
}

