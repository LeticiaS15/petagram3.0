package com.example.prueba11.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.prueba11.Adaptadores.AdaptadorMascotaFavorita;
import com.example.prueba11.Adaptadores.MascotaAdaptador;
import com.example.prueba11.Contacto;
import com.example.prueba11.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentPerrito extends Fragment {

    private RecyclerView myrecyclerview;
    private ArrayList<Contacto> contactoList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.perro_fragment, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.perro_recyclerview);
        MascotaAdaptador AdaptadorM= new MascotaAdaptador(getContext(),contactoList);
        myrecyclerview.setLayoutManager(new GridLayoutManager(getActivity(),2));
        myrecyclerview.setAdapter(AdaptadorM);
        return v;

        }


            @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

                contactoList= new ArrayList<>();
                contactoList.add(new Contacto(1,"TORPE",R.drawable.ic_mascota,0));
                contactoList.add(new Contacto(2,"mencito",R.drawable.ic_mascota,0));
                contactoList.add(new Contacto(3,"TORPE",R.drawable.ic_mascota,0));
                contactoList.add(new Contacto(4,"mencito",R.drawable.ic_mascota,0));




            }

    }