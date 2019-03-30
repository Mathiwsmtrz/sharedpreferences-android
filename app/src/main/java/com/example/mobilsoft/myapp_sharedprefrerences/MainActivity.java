package com.example.mobilsoft.myapp_sharedprefrerences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtUsuario,txtContrasena;
    String usuario,contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        usuario = preferences.getString("user","No registrado");
        contrasena = preferences.getString("pass","No registrado");
        if(!usuario.isEmpty() && !contrasena.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
            Intent Welcome = new Intent(getApplicationContext(), welcome.class);
            startActivity(Welcome);
        }else{
            Toast.makeText(getApplicationContext(), "Debe registrarse para ingresar", Toast.LENGTH_SHORT).show();
        }

    }

    public void ingresarActividad(View view){

        txtUsuario = (EditText) findViewById(R.id.txt_usuario);
        txtContrasena = (EditText) findViewById(R.id.txt_password);
        usuario = txtUsuario.getText().toString();
        contrasena = txtContrasena.getText().toString();

        if(!usuario.isEmpty() && !contrasena.isEmpty()) {

            SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
            SharedPreferences.Editor backInfo = preferences.edit();
            backInfo.putString("user", usuario);
            backInfo.putString("pass", contrasena);
            backInfo.commit();

            txtUsuario.setText("");
            txtContrasena.setText("");

            Intent Welcome = new Intent(getApplicationContext(), welcome.class);
            startActivity(Welcome);
        }else{
            Toast.makeText(getApplicationContext(), "Debe llenar los dos campos", Toast.LENGTH_SHORT).show();
        }
    }
}
