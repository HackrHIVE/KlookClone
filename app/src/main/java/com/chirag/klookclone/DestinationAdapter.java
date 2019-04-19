package com.chirag.klookclone;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class DestinationAdapter extends RecyclerView.Adapter<DestinationAdapter.ViewHolder>{

    ArrayList<String> names;
    ArrayList<Integer> drawables;
    Context context;
    double height,width;

    DestinationAdapter(Context context, double width,double height){
        this.context = context;
        this.width = width;
        this.height = height;
        this.names = new ArrayList<>();
        this.drawables = new ArrayList<>();
        this.names.add("HONG KONG");
        this.drawables.add(R.drawable.hongkong);
        this.names.add("MACAU");
        this.drawables.add(R.drawable.macau);
        this.names.add("SINGAPORE");
        this.drawables.add(R.drawable.singapore);
        this.names.add("SEOUL");
        this.drawables.add(R.drawable.seoul);
        this.names.add("BEIJING");
        this.drawables.add(R.drawable.beijing);
        this.names.add("TOKYO");
        this.drawables.add(R.drawable.tokyo);
        this.names.add("TAIPEI");
        this.drawables.add(R.drawable.taipei);
        this.names.add("More Destinations");
        this.drawables.add(R.drawable.destinations_more);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.destinations_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) holder.cardView.getLayoutParams();
        double wi = height/4;
        wi = wi*4/5;
        layoutParams2.height = (int)height/4;
        layoutParams2.width = (int)wi;
        holder.cardView.setLayoutParams(layoutParams2);

        Log.i("Name",names.get(position));
        holder.headerText.setText(names.get(position));
        holder.headerImage.setImageDrawable(context.getResources().getDrawable(drawables.get(position)));
        holder.headerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.i("Size",String.valueOf(names.size()));
        return names.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView headerText;
        RelativeLayout relativeLayout;
        CardView cardView;
        ImageView headerImage ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.parentCard);
            headerImage = itemView.findViewById(R.id.destinationCover);
            headerText = itemView.findViewById(R.id.destinationHeader);
            relativeLayout = itemView.findViewById(R.id.holderCard);
        }
    }

}
