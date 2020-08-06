package com.example.prueba11.presentador;

import android.content.Context;

import com.example.prueba11.BD.ContructorContactos;
import com.example.prueba11.Contacto;
import com.example.prueba11.Fragments.IfragmantMascota;

import java.util.ArrayList;

public class FragmentMascotaPresentador implements IfragmentMascotaPresentador {


    private IfragmantMascota ifragmantMascota;
    private Context context;
    private ContructorContactos contructorContactos;
    private ArrayList<Contacto> mascotas;


    public FragmentMascotaPresentador(IfragmantMascota ifragmantMascota, Context context) {
        this.ifragmantMascota = ifragmantMascota;
        this.context = context;
        obtenerContactos();
    }

    @Override
    public void obtenerContactos() {
        contructorContactos = new ContructorContactos(context);
        mascotas = contructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        ifragmantMascota.inicializarAdaptadorRV(ifragmantMascota.crearAdaptador(mascotas));
        ifragmantMascota.generarLinearLayoutVertical();
    }
}
