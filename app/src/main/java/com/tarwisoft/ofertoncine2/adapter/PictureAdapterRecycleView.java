package com.tarwisoft.ofertoncine2.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.tarwisoft.ofertoncine2.CompraActivity;
import com.tarwisoft.ofertoncine2.PeliculaActivity;
import com.tarwisoft.ofertoncine2.R;
import com.tarwisoft.ofertoncine2.model.Picture;

import java.util.ArrayList;

import static android.app.PendingIntent.getActivity;

public class PictureAdapterRecycleView extends RecyclerView.Adapter<PictureAdapterRecycleView.PictureViewHold> {

    private ArrayList<Picture> pictures;
    private int resource;
    private Activity actividad;
    private Picture picture;

    public PictureAdapterRecycleView(ArrayList<Picture> pictures, int resource, Activity actividad) {
        this.pictures = pictures;
        this.resource = resource;
        this.actividad = actividad;
    }

    @NonNull
    @Override
    public PictureViewHold onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(resource,viewGroup,false );

        return new PictureViewHold(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PictureViewHold pictureViewHold, final int i) {
         picture =pictures.get(i);
        pictureViewHold.txtTituloPelicula_card.setText(picture.getTitulo_pelicula());
        pictureViewHold.txtDescripcion.setText(picture.getDecripcion());
        pictureViewHold.txtLineNumberCard.setText(picture.getLine_number());

        Picasso.get().load(picture.getPicture()).into(pictureViewHold.imagen_card);

        pictureViewHold.btnFuncion1_card.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view)
            {

              Intent intent =
                        new Intent(view.getContext(), PeliculaActivity.class);

                Bundle b = new Bundle();
                b.putString("codigo_oferta",Integer.toString(picture.getCodigoOferta()));

                intent.putExtras(b);

                view.getContext().startActivity(intent);



            }
        });

    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public class PictureViewHold extends RecyclerView.ViewHolder  {


        private ImageView imagen_card;
        private TextView txtTituloPelicula_card;
        private TextView txtDescripcion;
        private CheckBox chkLike;
        private TextView txtLineNumberCard;
        private Button btnFuncion1_card;



        public PictureViewHold(@NonNull View itemView) {
            super(itemView);

            imagen_card=(ImageView) itemView.findViewById(R.id.imagen_card);
            txtTituloPelicula_card=(TextView) itemView.findViewById(R.id.txtTituloPelicula_card);
            txtDescripcion=(TextView) itemView.findViewById(R.id.txtDescripcion);
            chkLike=(CheckBox) itemView.findViewById(R.id.chkLike);
            txtLineNumberCard=(TextView) itemView.findViewById(R.id.txtLineNumberCard);
            btnFuncion1_card=(Button) itemView.findViewById(R.id.btnFuncion1_card);

        }
    }
}
