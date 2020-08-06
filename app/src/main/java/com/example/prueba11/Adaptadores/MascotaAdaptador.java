package com.example.prueba11.Adaptadores;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prueba11.Contacto;
import com.example.prueba11.R;

import java.util.ArrayList;
import java.util.List;


public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{
    List<Contacto> contactoslist;
    Context mContext;

    public MascotaAdaptador(Context mContext,List<Contacto> contactos ) {
        this.mContext = mContext;
        this.contactoslist = contactos;

    }



    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.cardview_perrito,parent,false);
        MascotaViewHolder vHolder = new MascotaViewHolder(v);
        return vHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {

        final Contacto contacto = contactoslist.get(position);
        holder.ImgPerro.setImageResource(contacto.getFoto());
        holder.TextNombre.setText(contacto.getNombre());

    }

    @Override
    public int getItemCount() {
        return contactoslist.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView ImgPerro;
        private TextView TextNombre;
        private  ImageButton BtnRanking;
        private  TextView TextNumero;


        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
        ImgPerro    = (ImageView) itemView.findViewById(R.id.ImgPerro);
        TextNombre  = (TextView) itemView.findViewById(R.id.TexTNombreP);
        BtnRanking = (ImageButton) itemView.findViewById(R.id.BtnRanking);
        TextNumero = (TextView) itemView.findViewById(R.id.TextNumeroP); }



    }




}

