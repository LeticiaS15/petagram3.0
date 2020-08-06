package com.example.prueba11.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.prueba11.Contacto;

import java.util.ArrayList;

public class SQLITE_bd extends SQLiteOpenHelper {
    Context context;
    private ArrayList<Contacto> mascotas;


    public SQLITE_bd(Context context) {
        super(context, ConexionSQLitebd.DATABASE_NAME, null, ConexionSQLitebd.DATABASE_VERSION);
        this.context= context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


      String  queryCrearTablaMascota = "CREATE TABLE " + ConexionSQLitebd.TABLA_MASCOTA +"(" +
                 ConexionSQLitebd.CAMPO_ID_MASCOTA + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                 ConexionSQLitebd.CAMPO_NOMBRE_MASCOTA+" TEXT," + ConexionSQLitebd.CAMPO_FOTO_MASCOTA +"INTEGER )";

      String queryCrearTablaLikesMascota= String.format("CREATE TABLE %s (%sINTEGER PRIMARY KEY AUTOINCREMENT,%sINTEGER, %sINTEGER FOREIGN KEY (%s)REFERENCES %s(%s))", ConexionSQLitebd.TABLA_LIKES_MASCOTA, ConexionSQLitebd.TABLA_LIKES_MASCOTA_ID, ConexionSQLitebd.TABLA_LIKES_MASCOTA_ID_CONTACTO, ConexionSQLitebd.TABLA_LIKES_MASCOTA_NUMERO_LIKES, ConexionSQLitebd.TABLA_LIKES_MASCOTA_ID_CONTACTO, ConexionSQLitebd.TABLA_MASCOTA, ConexionSQLitebd.CAMPO_ID_MASCOTA);



        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS " + ConexionSQLitebd.TABLA_MASCOTA);
        db.execSQL("DROP TABLE IF EXISTS " + ConexionSQLitebd.TABLA_LIKES_MASCOTA);
        onCreate(db);

    }
    public ArrayList<Contacto> ConsultarListaMascotas() {
        SQLiteDatabase db=this.getReadableDatabase();

        Contacto mascota = null;

        Cursor cursor = db.rawQuery(" SELECT * FROM " + ConexionSQLitebd.TABLA_MASCOTA,null );

        while (cursor.moveToNext()){
            mascota = new Contacto();
            mascota.setId(cursor.getInt(0));
            mascota.setNombre(cursor.getString(1));
            mascota.setFoto(cursor.getInt(2));

            String queryLikes   = String.format(" SELECT COUNT( %s) as likes  FROM %sWHERE %s= %d", ConexionSQLitebd.TABLA_LIKES_MASCOTA_NUMERO_LIKES, ConexionSQLitebd.TABLA_LIKES_MASCOTA, ConexionSQLitebd.TABLA_LIKES_MASCOTA_ID_CONTACTO, mascota.getId());

            Cursor cursorLikes = db.rawQuery(queryLikes,null);
            if (cursorLikes.moveToNext()){
                mascota.setLikes(cursorLikes.getInt(0));
            }else{
                mascota.setLikes(0);
            }

            mascotas.add(mascota);

        }
        db.close();

        return mascotas;
    }




    public ArrayList<Contacto> InsertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConexionSQLitebd.TABLA_MASCOTA,null, contentValues);
        db.close();
        return null;
    }

    public void insertarLikeContacto(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConexionSQLitebd.TABLA_LIKES_MASCOTA, null, contentValues);
        db.close();
    }

    public int obtenerLikesContacto(Contacto mascotas){
        int likes = 0;

        String query = String.format("SELECT COUNT(%s) FROM %s WHERE %s=%d", ConexionSQLitebd.TABLA_LIKES_MASCOTA_NUMERO_LIKES, ConexionSQLitebd.TABLA_LIKES_MASCOTA, ConexionSQLitebd.TABLA_LIKES_MASCOTA_ID_CONTACTO, mascotas.getId());

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }


}
