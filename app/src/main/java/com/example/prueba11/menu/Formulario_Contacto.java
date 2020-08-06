package com.example.prueba11.menu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.prueba11.R;

import static android.content.Intent.ACTION_SEND;

public class Formulario_Contacto extends AppCompatActivity {

    Button button;
    EditText correo, mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario__contacto);

        correo = (EditText) findViewById(R.id.EditCorreo);
        mensaje = (EditText) findViewById(R.id.EditMensaje);
        button = findViewById(R.id.btn_enviar);


      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String enviarcorreo = correo.getText().toString();
              String enviarmensaje = mensaje.getText().toString();

              // Defino mi Intent y hago uso del objeto ACTION_SEND
              Intent intent = new Intent(ACTION_SEND);
              intent.setData(Uri.parse("mailto"));

              // Defino los Strings Email, Asunto y Mensaje con la función putExtra
              intent.putExtra(Intent.EXTRA_EMAIL,new String[]{enviarcorreo});
              intent.putExtra(Intent.EXTRA_TEXT, enviarmensaje);

              // Establezco el tipo de Intent
              intent.setType("message/rfc822");

              // Lanzo el selector de cliente de Correo
              startActivity(Intent.createChooser(intent, "Elije un cliente de Correo:"));



          }
      });


    }
}