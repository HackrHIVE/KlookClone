package com.chirag.klookclone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ActivitiesAdapter extends RecyclerView.Adapter<ActivitiesAdapter.ViewHolder>{

    String rupeesSymbol = "\u20B9";

    ArrayList<String>names;
    ArrayList<Integer>drawables;
    ArrayList<String>prices;
    ArrayList<String>reviews;
    ArrayList<Integer>booked;
    ArrayList<Double>ratings;
    Context context;
    double width , height;

    ActivitiesAdapter(Context context , double width , double height){
        this.context = context;
        this.height = height;
        this.width = width;
        names = new ArrayList<>();
        drawables = new ArrayList<>();
        prices = new ArrayList<>();
        reviews = new ArrayList<>();
        booked = new ArrayList<>();
        ratings = new ArrayList<>();
        names.add("Gardens by the Bay Ticket Singapore");
        drawables.add(R.drawable.gardens_by_the_bay);
        ratings.add(4.7);
        booked.add(523);
        reviews.add("18,991");
        prices.add("1,180");
        names.add("Hong Kong Disneyland Meal Coupon");
        drawables.add(R.drawable.hongkon_disneyland_meal);
        ratings.add(4.7);
        booked.add(635);
        reviews.add("22,709");
        prices.add("1,230");
        names.add("Taipei 101 Observatory E-Ticket");
        drawables.add(R.drawable.taipei_observ);
        ratings.add(4.6);
        booked.add(592);
        reviews.add("9,910");
        prices.add("1,149");
        names.add("Lotte World 1 Day Pass");
        drawables.add(R.drawable.lotte_world);
        ratings.add(4.5);
        booked.add(314);
        reviews.add("8,925");
        prices.add("1,839");
        names.add("Singapore Cable Car");
        drawables.add(R.drawable.singapore_cable_car);
        ratings.add(4.7);
        booked.add(237);
        reviews.add("7,841");
        prices.add("1,257");

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activities_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) holder.cardView.getLayoutParams();
//        layoutParams.height = (int) height*2/5;
        layoutParams.width = (int) width*9/10;
//        layoutParams.width = (int) height*7/15*5/4;
        holder.cardView.setLayoutParams(layoutParams);

        LinearLayout.LayoutParams layoutParams1 = (LinearLayout.LayoutParams) holder.headerImage.getLayoutParams();
        layoutParams1.width = (int) width*9/10;
        layoutParams1.height = (int) width*9/10*6/7*2/3;
        holder.headerImage.setLayoutParams(layoutParams1);

        holder.headerImage.setImageDrawable(context.getResources().getDrawable(drawables.get(position)));
        holder.headerText.setText(names.get(position));
        holder.booked.setText(booked.get(position)+"K Booked");
        holder.price.setText(prices.get(position));
        String temprev = "("+reviews.get(position)+")";
        holder.review.setText(temprev);
        holder.rating.setText(String.valueOf(ratings.get(position)));

    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView headerText,rating,review,price,booked;
        CardView cardView;
        ImageView headerImage ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.containerActivities);
            headerImage = itemView.findViewById(R.id.activityCover);
            headerText = itemView.findViewById(R.id.activityHeader);
            rating = itemView.findViewById(R.id.rating);
            review = itemView.findViewById(R.id.reviews);
            price = itemView.findViewById(R.id.priceActivity);
            booked = itemView.findViewById(R.id.bookings);
        }
    }

}
