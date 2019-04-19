package com.chirag.klookclone;

import android.graphics.Point;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import it.sephiroth.android.library.bottomnavigation.BottomNavigation;

import android.view.Display;
import android.view.MenuItem;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    BottomNavigation navigation;
    Explore explore;
    Cart cart;
    Bookings bookings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        navigation = findViewById(R.id.navigation);


        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        double width = size.x;
        double height = size.y;
        explore = new Explore();
        final Bundle bundle = new Bundle();
        bundle.putDouble("width",width);
        bundle.putDouble("height",height);
        explore.setArguments(bundle);
        setFragment(explore);

        navigation.setMenuItemSelectionListener(new BottomNavigation.OnMenuItemSelectionListener() {
            @Override
            public void onMenuItemSelect(int i, int i1, boolean b) {
                switch (i){
                    case R.id.explore:
                        setFragment(explore);
                        Toast.makeText(Main2Activity.this, "Explore!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.destinations:
                        Toast.makeText(Main2Activity.this, "Destinations!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.cart:
                        cart = new Cart();
                        cart.setArguments(bundle);
                        setFragment(cart);
                        Toast.makeText(Main2Activity.this, "Cart!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bookings:
                        bookings = new Bookings();
                        bookings.setArguments(bundle);
                        setFragment(bookings);
                        Toast.makeText(Main2Activity.this, "Bookings!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.account:
                        Toast.makeText(Main2Activity.this, "Account!", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onMenuItemReselect(int i, int i1, boolean b) {

            }
        });

    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace( R.id.main_frame , fragment );
        fragmentTransaction.commit();
    }

    public void setHome(MenuItem item) {
        Toast.makeText(this, "Setting Home!", Toast.LENGTH_SHORT).show();
    }
}
