package com.tarwisoft.ofertoncine2.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
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
import com.tarwisoft.ofertoncine2.Common.Constante;
import com.tarwisoft.ofertoncine2.R;
import com.tarwisoft.ofertoncine2.Response.CineRes;
import com.tarwisoft.ofertoncine2.Response.ResponseCine;
import com.tarwisoft.ofertoncine2.adapter.CineAdapter;
import com.tarwisoft.ofertoncine2.model.Cine;
import com.tarwisoft.ofertoncine2.model.ClaseGlobal;
import org.json.JSONException;
import org.json.JSONObject;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

  private  ListView listCine;
  private Cine[] cines;

  public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_home, container, false);
        obtener_cines_servicio();
        return view;
    }

    private void cargar_cine(Cine[] cines){
        listCine = (ListView) ((AppCompatActivity)getActivity()).findViewById(R.id.listCine);
        CineAdapter adaptador = new CineAdapter(((AppCompatActivity)getActivity()), cines);
        listCine.setAdapter(adaptador);
    }

    private void obtener_cines_servicio(){
        RequestQueue queue = Volley.newRequestQueue((AppCompatActivity)getActivity());
        String url_api = Constante.URL_SERVICIO_CINE;
        JsonObjectRequest jsonobj = new JsonObjectRequest(Request.Method.GET, url_api,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Gson gson = new Gson();
                        ResponseCine responseCine = gson.fromJson(response.toString(), ResponseCine.class);
                        if(responseCine.cines.length>0)
                        {
                            int count = 0;
                            cines = new Cine[responseCine.cines.length];
                            for (CineRes item : responseCine.cines) {
                                cines[count]=new Cine(item.nombre_cine,
                                        item.descripcion_cine,
                                        item.estado_abierto,
                                        item.foto_cine,
                                        item.tiene_entrada);
                                count++;
                            }
                            cargar_cine(cines);
                        }
                        else
                        {
                            Toast.makeText(((AppCompatActivity)getActivity()), "No se pudo obtener informacion de cines", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(((AppCompatActivity)getActivity()), "Error de conexion, vuelva intentar en unos segundos", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        queue.add(jsonobj);
    }
}