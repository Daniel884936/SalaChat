package com.example.salachat;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import Entidades.Mensaje;

public class HolderMensaje extends RecyclerView.ViewHolder {

    private TextView txtNombre;
    private TextView txtHora;
    private TextView txtMensaje;
    private ImageView imgMensajeEnviado;

    public ImageView getImgMensajeEnviado() {
        return imgMensajeEnviado;
    }

    public void setImgMensajeEnviado(ImageView imgMensajeEnviado) {
        this.imgMensajeEnviado = imgMensajeEnviado;
    }

    public HolderMensaje(@NonNull View itemView) {
        super(itemView);
        txtNombre = itemView.findViewById(R.id.txtNombre);
        txtMensaje = itemView.findViewById(R.id.txtMensaje);
        txtHora = itemView.findViewById(R.id.txtHora);
        imgMensajeEnviado = itemView.findViewById(R.id.imgMensaje);
    }

    public TextView getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(TextView txtNombre) {
        this.txtNombre = txtNombre;
    }

    public TextView getTxtHora() {
        return txtHora;
    }

    public void setTxtHora(TextView txtHora) {
        this.txtHora = txtHora;
    }

    public TextView getTxtMensaje() {
        return txtMensaje;
    }

    public void setTxtMensaje(TextView txtMensaje) {
        this.txtMensaje = txtMensaje;
    }
}
