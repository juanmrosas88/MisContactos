package com.jmrootkit.miscontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatePicker dpDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dpDate = (DatePicker)findViewById(R.id.dpDate);
        // init
        // dpDate.init(2002, 10, 27, null);

    }

    public void next_onClick(View view) {
        Intent i = new Intent(MainActivity.this, DetalleContactos.class);
        startActivity(i);

        String builder = "Current Date: " +
                (dpDate.getMonth() + 1) + "/" +//month is 0 based
                dpDate.getDayOfMonth() + "/" +
                dpDate.getYear();
        Toast.makeText(this, builder, Toast.LENGTH_SHORT).show();

    }
}