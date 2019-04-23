package com.tarwisoft.ofertoncine2.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tarwisoft.ofertoncine2.R;
import com.tarwisoft.ofertoncine2.model.Cine;

import java.util.ArrayList;

public class CineAdapter  extends ArrayAdapter<Cine> {

    public CineAdapter(Context context, Cine[] datos) {
        super(context, R.layout.listitem_cine, datos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;
        ViewHolder holder;
        if (item == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            item = inflater.inflate(R.layout.listitem_cine, null);
            holder = new ViewHolder();
            holder.txtNombreCine = (TextView) item.findViewById(R.id.txtNombreCine);
            holder.txtDescripcionCine = (TextView) item.findViewById(R.id.txtDescripcionCine);
            holder.txtEstadoAbierto = (TextView) item.findViewById(R.id.txtEstadoAbierto);
            holder.imagenCine = (ImageView) item.findViewById(R.id.imagenCine);
            holder.imagenTicketDispo = (ImageView) item.findViewById(R.id.imagenTicketDispo);
            holder.linearLayout = (LinearLayout) item.findViewById(R.id.listaCine);
            item.setTag(holder);
        } else {
            holder = (ViewHolder) item.getTag();
        }

        Cine cine = getItem(position);

        if (cine != null) {
            holder.txtNombreCine.setText(cine.getNombreCine());
            holder.txtDescripcionCine.setText(cine.getDescripcion());
            holder.txtEstadoAbierto.setText(cine.getEstado_abierto());
        }
        if (position % 2 == 0) {
            holder.linearLayout.setBackgroundColor(getContext().getResources().getColor(R.color.white));
        } else
            {
            holder.linearLayout.setBackgroundColor(getContext().getResources().getColor(R.color.colorLista));
        }
        return (item);
    }

    static class ViewHolder {
        TextView txtNombreCine;
        TextView txtDescripcionCine;
        TextView txtEstadoAbierto;
        ImageView imagenCine;
        ImageView imagenTicketDispo;
        LinearLayout linearLayout;
    }
}