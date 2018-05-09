package turnero.modelo;

public class Modulo {

    private String numero_modulo;
    private String numero_servicio;
    private String cedula_empleado;

    public Modulo() {

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
     * @return the numero_servicio
     */
    public String getNumero_servicio() {
        return numero_servicio;
    }

    /**
     * @param numero_servicio the numero_servicio to set
     */
    public void setNumero_servicio(String numero_servicio) {
        this.numero_servicio = numero_servicio;
    }

    /**
     * @return the cedula_empleado
     */
    public String getCedula_empleado() {
        return cedula_empleado;
    }

    /**
     * @param cedula_empleado the cedula_empleado to set
     */
    public void setCedula_empleado(String cedula_empleado) {
        this.cedula_empleado = cedula_empleado;
    }

}
