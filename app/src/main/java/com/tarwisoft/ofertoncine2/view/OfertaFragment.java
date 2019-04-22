package com.tarwisoft.ofertoncine2.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.tarwisoft.ofertoncine2.R;
import com.tarwisoft.ofertoncine2.adapter.PictureAdapterRecycleView;
import com.tarwisoft.ofertoncine2.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class OfertaFragment extends Fragment {


    public OfertaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_oferta, container, false);
        showToolbar("CineOferta",false,view);
        RecyclerView pictureRecycle=(RecyclerView) view.findViewById(R.id.pictureRecycle);

        LinearLayoutManager linearLayoutManger= new LinearLayoutManager(getContext());
        linearLayoutManger.setOrientation(LinearLayoutManager.VERTICAL);

        pictureRecycle.setLayoutManager(linearLayoutManger);
        PictureAdapterRecycleView pictureAdapterRecycleView=
                new PictureAdapterRecycleView(buidPicture() ,R.layout.cine_cardview,getActivity());

        pictureRecycle.setAdapter(pictureAdapterRecycleView);
        return view;
    }

    private ArrayList<Picture> buidPicture(){

        ArrayList<Picture> picturess=new ArrayList<>();

        picturess.add(new Picture("https://boygeniusreport.files.wordpress.com/2019/03/avengers-endgame-poster-bottom-half.jpg","Advenges","Cines de comas","S","10 me gusta",1005));
        picturess.add(new Picture("http://es.web.img3.acsta.net/c_215_290/pictures/19/02/25/13/00/0265979.jpg","La Llorona","Cine de Lince","S","200 me gusta",1006));
        picturess.add(new Picture("http://es.web.img3.acsta.net/c_215_290/pictures/19/02/25/13/00/0265979.jpg","Juego de Tronos","Cine de Planet","S","500 me gusta",1007));

        return picturess;

    }

    public void showToolbar(String title, boolean upButton, View view){
        android.support.v7.widget.Toolbar toolbar=(android.support.v7.widget.Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }
}
