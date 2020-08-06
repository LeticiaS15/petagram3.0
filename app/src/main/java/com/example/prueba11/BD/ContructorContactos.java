package com.example.prueba11.BD;

import android.content.ContentValues;
import android.content.Context;

import com.example.prueba11.Contacto;
import com.example.prueba11.Fragments.FragmentMascota;
import com.example.prueba11.R;

import java.util.ArrayList;

public class ContructorContactos {
    private static final int LIKE = 1;
    private Context context;

    public ContructorContactos(Context context) { this.context = context; }



    public ArrayList<Contacto> obtenerDatos() {
       SQLITE_bd db = new SQLITE_bd(context);
        insertarTresContactos(db);
        return  db.ConsultarListaMascotas();
    }

    private void insertarTresContactos(SQLITE_bd db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConexionSQLitebd.CAMPO_NOMBRE_MASCOTA, "Bicho");
        contentValues.put(ConexionSQLitebd.CAMPO_FOTO_MASCOTA, R.drawable.perro);

        db.InsertarMascota(contentValues);

    }
    public void darLikeContacto(Contacto mascota){
        SQLITE_bd db = new SQLITE_bd(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConexionSQLitebd.TABLA_LIKES_MASCOTA_ID_CONTACTO, mascota.getId());
        contentValues.put(ConexionSQLitebd.TABLA_LIKES_MASCOTA_NUMERO_LIKES, LIKE);
        db.insertarLikeContacto(contentValues);
    }


    public int obtenerLikesContacto(Contacto mascota) {
        SQLITE_bd db = new SQLITE_bd(context);
        return db.obtenerLikesContacto(mascota);
    }
}
