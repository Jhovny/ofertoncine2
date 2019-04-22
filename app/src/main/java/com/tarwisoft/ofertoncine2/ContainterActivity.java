package com.tarwisoft.ofertoncine2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.tarwisoft.ofertoncine2.view.BenificioFragment;
import com.tarwisoft.ofertoncine2.view.HomeFragment;
import com.tarwisoft.ofertoncine2.view.OfertaFragment;
import com.tarwisoft.ofertoncine2.view.PerfilFragment;

public class ContainterActivity extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_containter);
        BottomNavigationView botonBar =(BottomNavigationView) findViewById(R.id.navigation);
        botonBar.getMenu().findItem(R.id.navigation_oferta).setChecked(true);
        setupDrawerContent(botonBar);

        OfertaFragment ofertaFragment = new OfertaFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.btnContainer, ofertaFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null).commit();
    }

    private void setupDrawerContent(BottomNavigationView navigationView) {
        navigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.navigation_home:

                                HomeFragment homeFragment = new HomeFragment();
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.btnContainer, homeFragment)
                                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                        .addToBackStack(null).commit();

                                break;
                            case R.id.navigation_Benificio:

                                BenificioFragment benificioFragment = new BenificioFragment();
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.btnContainer, benificioFragment)
                                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                        .addToBackStack(null).commit();


                                break;
                            case R.id.navigation_oferta:

                                OfertaFragment ofertaFragment = new OfertaFragment();
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.btnContainer, ofertaFragment)
                                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                        .addToBackStack(null).commit();

                                break;
                            case R.id.navigation_perfil:
                                PerfilFragment perfilragment = new PerfilFragment();
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.btnContainer, perfilragment)
                                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                        .addToBackStack(null).commit();
                                break;
                        }

                        return true;
                    }
                }
        );
    }
}
