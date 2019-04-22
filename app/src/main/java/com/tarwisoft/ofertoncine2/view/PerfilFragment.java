package com.tarwisoft.ofertoncine2.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tarwisoft.ofertoncine2.LoginActivity;
import com.tarwisoft.ofertoncine2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {


    private Button btnIngresar;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =inflater.inflate(R.layout.fragment_perfil, container, false);

        btnIngresar=(Button) view.findViewById(R.id. btnIngresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0)
            {
                //Creamos el Intent
                Intent intent =
                        new Intent((getActivity()), LoginActivity.class);

                //Creamos la información a pasar entre actividades
                Bundle b = new Bundle();
                b.putString("NOMBRE", "Datos");

                //Añadimos la información al intent
                intent.putExtras(b);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });





        return view;
    }

}
