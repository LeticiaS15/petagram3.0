package com.example.prueba11.Fragments;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prueba11.Adaptadores.AdaptadorMascotaFavorita;
import com.example.prueba11.BD.ConexionSQLitebd;
import com.example.prueba11.BD.SQLITE_bd;
import com.example.prueba11.Contacto;
import com.example.prueba11.R;
import com.example.prueba11.presentador.FragmentMascotaPresentador;
import com.example.prueba11.presentador.IfragmentMascotaPresentador;

import java.util.ArrayList;


public class FragmentMascota extends Fragment implements IfragmantMascota {

    private RecyclerView myrecyclerview;
    Context context;
    private ArrayList<Contacto> mascotas;

     private IfragmentMascotaPresentador presentador;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.mascota_fragment, container, false);


        myrecyclerview = (RecyclerView) v.findViewById(R.id.contact_recyclerview);
        presentador = new FragmentMascotaPresentador(this, getContext());
        return v;
    }


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        myrecyclerview.setLayoutManager(llm);

    }

    @Override
    public AdaptadorMascotaFavorita crearAdaptador(ArrayList<Contacto> mascotas) {
        AdaptadorMascotaFavorita adaptador= new AdaptadorMascotaFavorita(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(AdaptadorMascotaFavorita adaptador) {
            myrecyclerview.setAdapter(adaptador);
    }
}