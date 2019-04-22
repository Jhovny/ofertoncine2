package com.tarwisoft.ofertoncine2.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tarwisoft.ofertoncine2.ContainterActivity;
import com.tarwisoft.ofertoncine2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductoFragment extends Fragment {

private Button btnCancelar;


    public ProductoFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_producto, container, false);

        btnCancelar=(Button)view.findViewById(R.id.btnCancelar);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =
                        new Intent((getActivity()), ContainterActivity.class);

                startActivity(intent);

            }
        });



        return view;
    }


    public static ProductoFragment newInstance(String text) {
        ProductoFragment f = new ProductoFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);
        f.setArguments(b);

        return f;
    }

}
