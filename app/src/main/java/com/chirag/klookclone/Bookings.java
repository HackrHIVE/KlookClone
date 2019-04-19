package com.chirag.klookclone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class Bookings extends Fragment {

    ImageView imageView;
    CardView cardView;
    double width,height;

    @Override
    public void setArguments(@Nullable Bundle args) {
        super.setArguments(args);
        this.width = args.getDouble("width");
        this.height = args.getDouble("height");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_bookings, container, false );

        imageView = view.findViewById(R.id.bookingsCart);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = (int) width*7/10;
        layoutParams.height = (int) width*7/10;
        imageView.setLayoutParams(layoutParams);

        cardView = view.findViewById(R.id.cardHolderButtonBooking);
        layoutParams = (LinearLayout.LayoutParams) cardView.getLayoutParams();
        layoutParams.width = (int) width*3/10;


        return view;
    }
}
