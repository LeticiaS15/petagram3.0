package com.example.prueba11.Fragments;

import com.example.prueba11.Adaptadores.AdaptadorMascotaFavorita;
import com.example.prueba11.Contacto;

import java.util.ArrayList;

public interface IfragmantMascota {


    public void generarLinearLayoutVertical();

    public AdaptadorMascotaFavorita crearAdaptador(ArrayList<Contacto> mascotas);

    public void inicializarAdaptadorRV(AdaptadorMascotaFavorita adaptador);
}
