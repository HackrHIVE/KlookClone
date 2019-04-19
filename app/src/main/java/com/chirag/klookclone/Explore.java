package com.chirag.klookclone;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.Transition;

import java.util.ArrayList;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Explore extends Fragment {

    KenBurnsView imageView;
    ArrayList<Integer> imagesShowcase;
    double width,height;
    RecyclerView recyclerView,activitiesRecycler;


    @Override
    public void setArguments(@Nullable Bundle args) {
        super.setArguments(args);
        this.width = args.getDouble("width");
        this.height = args.getDouble("height");
    }

    public Explore(){
        imagesShowcase = new ArrayList<>();
        imagesShowcase.add(R.drawable.slide_1);
        imagesShowcase.add(R.drawable.slide_2);
        imagesShowcase.add(R.drawable.slide_3);
        imagesShowcase.add(R.drawable.slide_5);
        imagesShowcase.add(R.drawable.slide_6);
        imagesShowcase.add(R.drawable.slide_8);
        imagesShowcase.add(R.drawable.slide_9);
        imagesShowcase.add(R.drawable.slide_10);
        imagesShowcase.add(R.drawable.slide_11);
        imagesShowcase.add(R.drawable.slide_12);
        imagesShowcase.add(R.drawable.slide_13);
        imagesShowcase.add(R.drawable.slide_14);
        imagesShowcase.add(R.drawable.slide_15);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate( R.layout.fragment_explore, container, false );
//        switcher = view.findViewById(R.id.switcherExplore);

        imageView = view.findViewById(R.id.imageShowcase);

        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = (int)this.width;
        layoutParams.height = (int)this.width;
        imageView.setLayoutParams(layoutParams);

        recyclerView = view.findViewById(R.id.popular_destinations);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        DestinationAdapter destinationAdapter = new DestinationAdapter(getActivity(),width,height);
        recyclerView.setAdapter(destinationAdapter);

        activitiesRecycler = view.findViewById(R.id.popular_activities);
        activitiesRecycler.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        SnapHelper snapHelper = new SnapHelper();
        snapHelper.attachToRecyclerView(activitiesRecycler);
        ActivitiesAdapter activitiesAdapter = new ActivitiesAdapter(getActivity(),width,height);
        activitiesRecycler.setAdapter(activitiesAdapter);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                if(isAdded()){
                    final Runnable context = this;
                    Random random = new Random();
                    int randomIndex = random.nextInt(imagesShowcase.size());
                    imageView.setImageDrawable(getResources().getDrawable(imagesShowcase.get(randomIndex)));
//                switcher.showNext();
                    imageView.setTransitionListener(new KenBurnsView.TransitionListener() {
                        @Override
                        public void onTransitionStart(Transition transition) {
                        }

                        @Override
                        public void onTransitionEnd(Transition transition) {
                            if(isAdded()){
                                handler.postDelayed(context, 500);
                            }
                        }
                    });
                }
            }
        }, 3000);

        CardView cardView = view.findViewById(R.id.search);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),SearchAct.class));
            }
        });



        return view;
    }


}
