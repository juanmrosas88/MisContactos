package com.jmrootkit.miscontactos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdapter extends  RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder>{


    public ContactoAdapter(ArrayList<Contacto> contactos){
        this.contactos = contactos;
    }
    ArrayList<Contacto> contactos;
    @NonNull
    @Override //Inflar el layout y pasarlo al viewholder para que obtenga los views
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto,parent, false);

        return new ContactoViewHolder(v);
    }

    @Override //asocia cada elemento de nuestra lista con cada view
    public void onBindViewHolder(@NonNull ContactoViewHolder contactoViewHolder, int position) {

        Contacto contacto = contactos.get(position);
        contactoViewHolder.imgFotoA.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreA.setText(contacto.getNombre());
        contactoViewHolder.tvDateA.setText(contacto.getFecha());
        contactoViewHolder.tvTelefonoA.setText(contacto.getPhone());
        contactoViewHolder.tvEmailA.setText(contacto.getEmail());
        contactoViewHolder.tvDescripcionA.setText(contacto.getDescripcion());

    }

    @Override
    public int getItemCount() {//cantidad de elementos que tiene mi lista
        return contactos.size() ;
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFotoA;
        private TextView tvNombreA;
        private TextView tvDateA;
        private TextView tvTelefonoA;
        private TextView tvEmailA;
        private TextView tvDescripcionA;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFotoA = (ImageView) itemView.findViewById(R.id.imgFotoCV);
            tvNombreA = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvDateA = (TextView) itemView.findViewById(R.id.tvFechaCV);
            tvTelefonoA = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
            tvEmailA = (TextView) itemView.findViewById(R.id.tvEmailCV);
            tvDescripcionA = (TextView) itemView.findViewById(R.id.tvDescripcionCV);
        }



    }

}
