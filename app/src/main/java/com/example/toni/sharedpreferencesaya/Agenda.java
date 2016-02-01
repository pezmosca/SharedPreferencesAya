package com.example.toni.sharedpreferencesaya;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Agenda extends AppCompatActivity {

    private EditText et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        et1 = (EditText) findViewById(R.id.etnombre);
        et2 = (EditText) findViewById(R.id.etdatos);
    }

    public void grabar(View v) {
        SharedPreferences preferencias=getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferencias.edit();
        editor.putString(et1.getText().toString(), et2.getText().toString());
        editor.commit();
    }

    public void recuperar(View v) {
        SharedPreferences preferencias=getSharedPreferences("agenda", Context.MODE_PRIVATE);
        et2.setText(preferencias.getString(et1.getText().toString(),""));
    }
}
