package com.example.salachat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

import Entidades.Mensaje;

public class AdapterMensajes extends RecyclerView.Adapter<HolderMensaje> {

    private List<MensajeRecibir> lisMnesajes = new ArrayList<>();
    private Context c;

    public AdapterMensajes( Context c) {
        this.c = c;
    }

    public void addMnesaje(MensajeRecibir m){
        lisMnesajes.add(m);
        notifyItemInserted(lisMnesajes.size());
    }

    @NonNull
    @Override
    public HolderMensaje onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.card_view_mensajes, parent, false);
        return new HolderMensaje(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderMensaje holder, int position) {
        holder.getTxtNombre().setText(lisMnesajes.get(position).getNombre());
        holder.getTxtMensaje().setText(lisMnesajes.get(position).getMensaje());
        //holder.getTxtHora().setText(lisMnesajes.get(position).getHora());
        if(lisMnesajes.get(position).getTypeMnesaje().equals("2")){
            holder.getImgMensajeEnviado().setVisibility(View.VISIBLE);
            Glide.with(c).load(lisMnesajes.get(position).getUrlFoto()).into(holder.getImgMensajeEnviado());
        }
        else if(lisMnesajes.get(position).getTypeMnesaje().equals("1")){
            holder.getImgMensajeEnviado().setVisibility(View.GONE);
        }

        Long codigoHora = lisMnesajes.get(position).getHora();
        Date d = new Date(codigoHora);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a");
        holder.getTxtHora().setText(simpleDateFormat.format(d));

    }
    @Override
    public int getItemCount() {
        return lisMnesajes.size();
    }
}
