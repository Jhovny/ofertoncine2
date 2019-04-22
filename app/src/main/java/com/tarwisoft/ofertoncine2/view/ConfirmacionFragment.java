package com.tarwisoft.ofertoncine2.view;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import com.tarwisoft.ofertoncine2.CompraRealizadaActivity;
import com.tarwisoft.ofertoncine2.ContainterActivity;
import com.tarwisoft.ofertoncine2.LoginActivity;
import com.tarwisoft.ofertoncine2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConfirmacionFragment extends Fragment {

    private Button btnPagar;
    private Button btnCancelar;

    public ConfirmacionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_confirmacion, container, false);
        btnPagar = (Button) view.findViewById(R.id.btnPagar);
        btnCancelar = (Button) view.findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =
                        new Intent((getActivity()), ContainterActivity.class);
                startActivity(intent);
            }
        });

        btnPagar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(arg0.getContext(), R.style.AlertDialog);
                alertDialogBuilder.setTitle("Confirmar pago..!!!");
                alertDialogBuilder.setIcon(R.drawable.ic_info_outline_black_information_24dp);
                alertDialogBuilder.setMessage("Realizar mi pago");
                alertDialogBuilder.setCancelable(false);


                alertDialogBuilder.setPositiveButton("SI", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent intent =
                                new Intent((getActivity()), CompraRealizadaActivity.class);
                        Bundle b = new Bundle();
                        b.putString("CODIGO_COMPRA", "COM00011");
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                });

                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
        });

        return view;
    }

    public static ConfirmacionFragment newInstance(String text) {
        ConfirmacionFragment f = new ConfirmacionFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);
        f.setArguments(b);
        return f;
    }


}