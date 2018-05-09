package turnero.modelo;

public class Turno {

    private String numero, fecha, hora, descripcion, numero_modulo, cedula_cliente;

    public Turno() {

        numero = "";
        fecha = "";
        hora = "";
        descripcion = "";
        numero_modulo = "";
        cedula_cliente = "";

    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
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
     * @return the numero_modulo
     */
    public String getNumero_modulo() {
        return numero_modulo;
    }

    /**
     * @param numero_modulo the numero_modulo to set
     */
    public void setNumero_modulo(String numero_modulo) {
        this.numero_modulo = numero_modulo;
    }

    /**
     * @return the cedula_cliente
     */
    public String getCedula_cliente() {
        return cedula_cliente;
    }

    /**
     * @param cedula_cliente the cedula_cliente to set
     */
    public void setCedula_cliente(String cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

}
