package turnero.modelo;

public class Servicio {

    private String id_servicio, nombre_servicio, descripcion, tiempo;

    public Servicio() {

        id_servicio = "";
        nombre_servicio = "";
        descripcion = "";
        tiempo = "";
    }

    /**
     * @return the id_servicio
     */
    public String getId_servicio() {
        return id_servicio;
    }

    /**
     * @param id_servicio the id_servicio to set
     */
    public void setId_servicio(String id_servicio) {
        this.id_servicio = id_servicio;
    }

    /**
     * @return the nombre_servicio
     */
    public String getNombre_servicio() {
        return nombre_servicio;
    }

    /**
     * @param nombre_servicio the nombre_servicio to set
     */
    public void setNombre_servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the tiempo
     */
    public String getTiempo() {
        return tiempo;
    }

    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

}
