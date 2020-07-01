package Entidades;

public class Mensaje {
    private String mensaje;
    private String typeMnesaje;


    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    private  String urlFoto;

    public Mensaje(String mensaje, String typeMnesaje, String urlFoto, String nombre) {
        this.mensaje = mensaje;
        this.typeMnesaje = typeMnesaje;

        this.urlFoto = urlFoto;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String nombre;

    public String getMensaje() {
        return mensaje;
    }

    public Mensaje() {
    }

    public Mensaje(String mensaje, String typeMnesaje, String nombre) {
        this.mensaje = mensaje;
        this.typeMnesaje = typeMnesaje;
        this.nombre = nombre;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTypeMnesaje() {
        return typeMnesaje;
    }

    public void setTypeMnesaje(String typeMnesaje) {
        this.typeMnesaje = typeMnesaje;
    }

}
