package com.jmrootkit.miscontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    DatePicker dpDate;
    Contacto contacto;

    private TextInputLayout tilNombre, tilTelefono, tilCorreo, tilDesc;
    String nombre, fecha, phone, email, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tilNombre = (TextInputLayout) findViewById(R.id.til_nombre);
        dpDate = (DatePicker) findViewById(R.id.dpDate);
        dpDate.init(2000, 10, 27, null);
        tilTelefono = (TextInputLayout) findViewById(R.id.til_phone);
        tilCorreo = (TextInputLayout) findViewById(R.id.til_email);
        tilDesc = (TextInputLayout) findViewById(R.id.til_desc);
        if(   tilDesc.getEditText() != null){
            tilDesc.getEditText().setText("");
        }
        traerDatosyllenar();


    }

    public void next_onClick(View view) {

        validarDatos();

    }


    public void traerDatosyllenar() {
        Bundle parametros = getIntent().getExtras();

        if (parametros != null) {
            nombre = parametros.getString(getString(R.string.pNombre));
            fecha = parametros.getString(getString(R.string.pFecha));
            phone = parametros.getString(getString(R.string.pTelefono));
            email = parametros.getString(getString(R.string.pEmail));
            descripcion = parametros.getString(getString(R.string.pDescripcion));

            cargarEditText(nombre, fecha, phone, email, descripcion);
        }
    }

    private void cargarEditText(String nombre, String fecha, String phone, String email, String descripcion) {

        String[] textElements = fecha.split("/");
        int dia, mes, anio;
        dia =  Integer.parseInt(textElements[2]);
        mes = Integer.parseInt(textElements[1]);
        anio =  Integer.parseInt(textElements[0]);

        try {
            tilNombre.getEditText().setText(nombre);
            dpDate.init(anio, mes - 1, dia, null);
            tilTelefono.getEditText().setText(phone);
            tilCorreo.getEditText().setText(email);
            tilDesc.getEditText().setText(descripcion);
        } catch (NumberFormatException e) {
            e.printStackTrace();

        }


    }

    private boolean esNombreValido(String nombre) {
        Pattern patron = Pattern.compile("^[a-zA-Z ]+$");
        if (!patron.matcher(nombre).matches() || nombre.length() > 30) {
            tilNombre.setError("Nombre inválido");
            return false;
        } else {
            tilNombre.setError(null);
        }

        return true;
    }

    private boolean esTelefonoValido(String telefono) {
        if (!Patterns.PHONE.matcher(telefono).matches()) {
            tilTelefono.setError("Teléfono inválido");
            return false;
        } else {
            tilTelefono.setError(null);
        }

        return true;
    }

    private boolean esCorreoValido(String correo) {
        if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            tilCorreo.setError("Email inválido");
            return false;
        } else {
            tilCorreo.setError(null);
        }

        return true;
    }

    private void validarDatos() {



        nombre = tilNombre.getEditText().getText().toString();
        fecha = (dpDate.getDayOfMonth() + "/" + (dpDate.getMonth() + 1) + "/" + dpDate.getYear());
        phone = tilTelefono.getEditText().getText().toString();
        email = tilCorreo.getEditText().getText().toString();
        descripcion = getString(R.string.sin_datos);

        if (tilDesc.getEditText() != null) {
            if (!tilDesc.getEditText().getText().toString().equals("")) {
                descripcion = tilDesc.getEditText().getText().toString();
            }
        }

        boolean a = esNombreValido(nombre);
        boolean b = esTelefonoValido(phone);
        boolean c = esCorreoValido(email);

        if (a && b && c) {
            // OK, se pasa a la siguiente acción
            enviarDatos(nombre, fecha, phone, email, descripcion);
        }

    }

    public void enviarDatos(String nom, String fe, String ph, String email, String desc) {
        contacto = new Contacto(nom, fe, ph, email, desc);

        Intent i = new Intent(MainActivity.this, DetalleContactos.class);
        i.putExtra(getString(R.string.pNombre), contacto.getNombre());
        i.putExtra(getString(R.string.pFecha), contacto.getFecha());
        i.putExtra(getString(R.string.pTelefono), contacto.getPhone());
        i.putExtra(getString(R.string.pEmail), contacto.getEmail());
        i.putExtra(getString(R.string.pDescripcion), contacto.getDescripcion());

        startActivity(i);


    }
}