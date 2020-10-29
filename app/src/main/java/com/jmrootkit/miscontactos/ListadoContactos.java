package com.jmrootkit.miscontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ListadoContactos extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listadecontactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_contactos);
        listadecontactos = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
/*
        GridLayoutManager glm = new GridLayoutManager(this, 2); //le paso el contexto y cuantas columnas quiero
*/

        listadecontactos.setLayoutManager(llm);

        inicializar_lista_de_contactos();

        inicializa_adaptador();

    }

    private void inicializa_adaptador() {
        ContactoAdapter adapter = new ContactoAdapter(contactos);
        listadecontactos.setAdapter(adapter);

    }

    public void inicializar_lista_de_contactos() {
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.ciro, "Ciro", "13-14-14", "039393", "sjndvvu@mksdm.cc", "Esto es una descripcion"));
        contactos.add(new Contacto(R.drawable.profile, "Juan", "30/09/1988", "410004", "juanmrosas8@mksdm.cc", "conocido por ahi"));
        contactos.add(new Contacto(R.drawable.yoperfil, "BENJA", "6/3/99", "039393", "adcdcc@mksdm.cc", "ollakease"));
        contactos.add(new Contacto(R.drawable.profile, "JHON", "30/09/1988", "987234", "amrameerrjnjd@mksdm.cc", "blablbalaejand"));

    }
}