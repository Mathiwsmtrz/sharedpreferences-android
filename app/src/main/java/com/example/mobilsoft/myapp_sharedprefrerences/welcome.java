package com.example.mobilsoft.myapp_sharedprefrerences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class welcome extends AppCompatActivity {

    String usuario,contrasena;
    TextView text_usuario,text_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        cargarInfo();
    }

    public void cargarInfo(){
        text_usuario = (TextView) findViewById(R.id.text_nombre);
        text_password = (TextView) findViewById(R.id.text_constrasena);

        SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        usuario = preferences.getString("user","No registrado");
        contrasena = preferences.getString("pass","No registrado");

        text_usuario.setText(usuario);
        text_password.setText(contrasena);
    }

    public void clearInfo(View view){
        SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        SharedPreferences.Editor backInfo = preferences.edit();
        backInfo.putString("user","");
        backInfo.putString("pass","");
        backInfo.commit();

        super.onBackPressed();
    }
}
