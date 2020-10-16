package com.jmrootkit.miscontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetalleContactos extends AppCompatActivity {

    String Nombre, FechaNacimiento, Telefono, Email, Descripcion;
    TextView tv_Nombre, tv_Fecha, tv_Telefono, tv_Email, tv_Descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contactos);

        traerDatos();
        referenciarDatos();
        cargarTextViews();


    }

    private void cargarTextViews() {
        tv_Nombre.setText(Nombre);
        tv_Fecha.setText(FechaNacimiento);
        tv_Telefono.setText(Telefono);
        tv_Email.setText(Email);
        tv_Descripcion.setText(Descripcion);

    }

    private void referenciarDatos() {
        tv_Nombre = findViewById(R.id.tv_nombre);
        tv_Fecha = findViewById(R.id.tv_nacim);
        tv_Telefono = findViewById(R.id.tv_phone);
        tv_Email = findViewById(R.id.tv_email);
        tv_Descripcion = findViewById(R.id.tv_desc);

    }

    public void traerDatos() {
        Bundle parametros = getIntent().getExtras();

        if (parametros != null) {
            Nombre = parametros.getString(getString(R.string.pNombre));
            FechaNacimiento = parametros.getString(getString(R.string.pFecha));
            Telefono = parametros.getString(getString(R.string.pTelefono));
            Email = parametros.getString(getString(R.string.pEmail));
            Descripcion = parametros.getString(getString(R.string.pDescripcion));

        }
    }

    public void edicion_onClick(View view) {
        Intent i = new Intent(DetalleContactos.this, MainActivity.class);
        i.putExtra(getString(R.string.pNombre), Nombre);
        i.putExtra(getString(R.string.pFecha), FechaNacimiento);
        i.putExtra(getString(R.string.pTelefono), Telefono);
        i.putExtra(getString(R.string.pEmail), Email);
        i.putExtra(getString(R.string.pDescripcion), Descripcion);
        startActivity(i);
    }

    public void llamar(View v) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(DetalleContactos.this, new String[]{Manifest.permission.CALL_PHONE}, 101);

            return;
        }
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + Telefono));
        startActivity(callIntent);
    }

    public void enviarEmail(View v) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.enviado_desde));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{Email});
        startActivity(intent);

    }
}