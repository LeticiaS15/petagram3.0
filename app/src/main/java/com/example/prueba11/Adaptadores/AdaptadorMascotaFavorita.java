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


import com.example.prueba11.BD.ContructorContactos;
import com.example.prueba11.Contacto;
import com.example.prueba11.Fragments.FragmentMascota;
import com.example.prueba11.R;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorMascotaFavorita extends RecyclerView.Adapter<AdaptadorMascotaFavorita.MascotaFavViewHolder> {
    ArrayList<Contacto> mascotas;
    Activity activity;


    public AdaptadorMascotaFavorita(ArrayList<Contacto> mascotas,Activity activity ) {
        this.mascotas= mascotas;
        this.activity= activity;
    }

    @NonNull
    @Override
    public MascotaFavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_favmascotas,null,false);
        MascotaFavViewHolder vHolder = new MascotaFavViewHolder(v);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaFavViewHolder holder, int position) {
        final Contacto mascota = mascotas.get(position);
        holder.TextNombreM.setText(mascota.getNombre());
        holder.ImgFotoM.setImageResource(mascota.getFoto());
        holder.tvLikes.setText(String.valueOf(mascota.getLikes()) + " " + activity.getString(R.string.likes));
       holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContructorContactos constructorContactos = new ContructorContactos(activity);
                constructorContactos.darLikeContacto(mascota);
               holder.tvLikes.setText( constructorContactos.obtenerLikesContacto(mascota) + " " + activity.getString(R.string.likes));
            }
        });

    }

    @Override
    public int getItemCount(){
        return mascotas.size();

    }


    public class MascotaFavViewHolder extends RecyclerView.ViewHolder {


        private ImageView ImgFotoM;
        private TextView TextNombreM;
        private ImageButton btnLike;
       private TextView tvLikes;


        public MascotaFavViewHolder(@NonNull View itemView) {
            super(itemView);
            ImgFotoM     = (ImageView) itemView.findViewById(R.id.ImgFotoM);
            TextNombreM  = (TextView) itemView.findViewById(R.id.TexTNombreM);
           btnLike     = (ImageButton) itemView.findViewById(R.id.BtnLike);
           tvLikes     = (TextView) itemView.findViewById(R.id.tvLikes);

        }
    }
}
