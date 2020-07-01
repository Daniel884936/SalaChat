package com.example.salachat;

import java.util.Map;

import Entidades.Mensaje;

public class MnesajeEnviar extends Mensaje {
    private Map hora;

    public MnesajeEnviar() {
    }

    public MnesajeEnviar(String mensaje, String typeMnesaje, String nombre, Map hora) {
        super(mensaje, typeMnesaje, nombre);
        this.hora = hora;
    }

    public MnesajeEnviar(String mensaje, String typeMnesaje, String urlFoto, String nombre, Map hora) {
        super(mensaje, typeMnesaje, urlFoto, nombre);
        this.hora = hora;
    }

    public Map getHora() {
        return hora;
    }

    public void setHora(Map hora) {
        this.hora = hora;
    }

    public MnesajeEnviar(Map hora) {
        this.hora = hora;
    }
}
