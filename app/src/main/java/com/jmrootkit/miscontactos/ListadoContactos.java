package com.jmrootkit.miscontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class ListadoContactos extends AppCompatActivity {

    ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_contactos);

        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.ciro, "Ciro","13-14-14","039393","sjndvvu@mksdm.cc"));
        contactos.add(new Contacto(R.drawable.profile, "Juan","30/09/1988","410004","juanmrosas8@mksdm.cc"));
        contactos.add(new Contacto(R.drawable.ciro, "BENJA","6/3/99","039393","adcdcc@mksdm.cc"));
        contactos.add(new Contacto(R.drawable.profile, "JHON","30/09/1988","987234","amrameerrjnjd@mksdm.cc"));

        ArrayList<String> nombreContacto = new ArrayList<>();
        for (Contacto contacto : contactos){
            nombreContacto.add(contacto.getNombre());
        }


    }
}