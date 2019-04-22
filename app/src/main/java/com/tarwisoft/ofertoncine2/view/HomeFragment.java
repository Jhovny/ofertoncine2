package com.tarwisoft.ofertoncine2.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.tarwisoft.ofertoncine2.R;
import com.tarwisoft.ofertoncine2.adapter.CineAdapter;
import com.tarwisoft.ofertoncine2.model.Cine;
import com.tarwisoft.ofertoncine2.model.ClaseGlobal;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


  private  ListView listCine;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_home, container, false);


        cargar_cine(view);

        return view;
    }


    private void cargar_cine(View view){

        JSONObject seguridadObj = new JSONObject();
        JSONObject filtroObj = new JSONObject();


        try {
            filtroObj.put("ql_REGISTRO_INICIO",1);
            filtroObj.put("ql_REGISTRO_FIN",10);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        ArrayList<Cine> cines = new ArrayList<Cine>();

        cines.add(new Cine("Cine Planet","Cine en todo lima","Abierto","http://www.google.com/fotos.jps",true));
        cines.add(new Cine("UVK","Cine en todo lima","Cerrado","http://www.google.com/fotos.jps",true));
        cines.add(new Cine("Cine Mark","Cine en todo lima","Abierto","http://www.google.com/fotos.jps",true));

        listCine = (ListView) view.findViewById(R.id.listCine);

        CineAdapter adaptador = new CineAdapter(view.getContext(), cines);

        listCine.setAdapter(adaptador);





    }


}
