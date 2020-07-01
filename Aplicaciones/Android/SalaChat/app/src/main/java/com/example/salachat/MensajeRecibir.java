package com.example.salachat;

import Entidades.Mensaje;

public class MensajeRecibir extends Mensaje {
    private Long hora;

    public Long getHora() {
        return hora;
    }

    public void setHora(Long hora) {
        this.hora = hora;
    }

    public MensajeRecibir() {
    }

    public MensajeRecibir(String mensaje, String typeMnesaje, String nombre, Long hora) {
        super(mensaje, typeMnesaje, nombre);
        this.hora = hora;
    }

    public MensajeRecibir(String Long) {
        this.hora = hora;
    }
}
