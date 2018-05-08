package turnero.control;

import turnero.vista.JFRegistroCliente;
import java.awt.event.*;
import turnero.control.BD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import turnero.modelo.*;
import turnero.vista.*;

public class ControlJFRegistroCliente implements ActionListener {

    BD cn;
    Cliente cliente;
    JFRegistroCliente jfrcliente;

    public ControlJFRegistroCliente() {
        cn = new BD();
    }

    @SuppressWarnings("LeakingThisInConstructor")

    public ControlJFRegistroCliente(Cliente cliente, JFRegistroCliente jfrcliente) {
        cn = new BD();

        this.cliente = cliente;
        this.jfrcliente = jfrcliente;

        jfrcliente.Blimpiar.addActionListener(this);
        jfrcliente.Bregistrar.addActionListener(this);
        jfrcliente.Bsalircliente.addActionListener(this);
        jfrcliente.BConsultar.addActionListener(this);
        jfrcliente.Beliminar.addActionListener(this);
        jfrcliente.Beliminar.setEnabled(false);
        jfrcliente.Bactualizar.addActionListener(this);
        jfrcliente.Bactualizar.setEnabled(false);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == jfrcliente.Bregistrar) {
            guardar();
        }

        if (ae.getSource() == jfrcliente.BConsultar) {

            consultar();
        }

        if (ae.getSource() == jfrcliente.Beliminar) {

            eliminar();
        }
        if (ae.getSource() == jfrcliente.Bactualizar) {

            actualizar();
        }
        if (ae.getSource() == jfrcliente.Blimpiar) {

            clean();
        }

        if (ae.getSource() == jfrcliente.Bsalircliente) {

            jfrcliente.dispose();
        }

    }

    public boolean createCliente(Cliente cliente) {
        String sql = "insert into clientes values('"
                + cliente.getCedula() + "', '"
                + cliente.getNombre() + "', '"
                + cliente.getApellido() + "', "
                + cliente.getEdad() + ", "
                + cliente.getTelefono() + ", '"
                + cliente.getDireccion() + "','"
                + cliente.getCorreo() + "', "
                + cliente.getEstrato() + ", '"
                + cliente.getCiudad() + "','"
                + cliente.getDiscapacidad() + "','"
                + cliente.getEstado() + "')";

        cn.conectar();
        boolean result = cn.ejecutar(sql);
        try {
            cn.CerrarConexion();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(ControlJFRegistroCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean updateClienteByDocument(Cliente cliente) {
        String sql = "update clientes set "
                + "nombre_cliente = '" + cliente.getNombre() + "' , "
                + "apellido_cliente = '" + cliente.getApellido() + "' , "
                + "edad_cliente = '" + cliente.getEdad() + "' , "
                + "telefono_cliente = '" + cliente.getTelefono() + "' , "
                + "direccion_cliente = '" + cliente.getDireccion() + "' , "
                + "email_cliente = '" + cliente.getCorreo() + "' , "
                + "estrato_empleado = '" + cliente.getEstrato() + "' , "
                + "ciudad_cliente = '" + cliente.getCiudad() + "' , "
                + "discapacidad_cliente = '" + cliente.getDiscapacidad() + "' , "
                + "estado_cliente = '" + cliente.getEstado() + "' where "
                + "cedula_cliente = '" + cliente.getCedula() + "' ";
        System.out.println(sql);
        cn.conectar();
        boolean result = cn.ejecutar(sql);
        try {
            cn.CerrarConexion();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(ControlJFRegistroCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Cliente findUserByDocumento(String doc) {
        Cliente cliente = null;
        try {

            String sql = "select * from CLIENTES where cedula_cliente = '" + doc + "' ";
            cn.conectar();
            cn.getBD(sql);

            if (cn.getRegistro().next()) {
                cliente = new Cliente();

                cliente.setCedula(cn.getRegistro().getString("cedula_cliente"));
                cliente.setNombre(cn.getRegistro().getString("nombre_cliente"));
                cliente.setApellido(cn.getRegistro().getString("apellido_cliente"));
                cliente.setTelefono(cn.getRegistro().getString("telefono_cliente"));
                cliente.setDireccion(cn.getRegistro().getString("direccion_cliente"));
                cliente.setCorreo(cn.getRegistro().getString("email_cliente"));
                cliente.setCiudad(cn.getRegistro().getString("ciudad_cliente"));
                cliente.setEstado(cn.getRegistro().getString("estado_cliente"));
                cliente.setDiscapacidad(cn.getRegistro().getString("discapacidad_cliente"));
                cliente.setEdad(cn.getRegistro().getInt("edad_cliente"));
                cliente.setEstrato(cn.getRegistro().getInt("estrato_empleado"));
            }

            cn.CerrarConexion();
            return cliente;
        } catch (SQLException ex) {
            Logger.getLogger(ControlJFRegistroCliente.class.getName()).log(Level.SEVERE, null, ex);
            return cliente;
        }
    }

    public boolean deleteCliente(String doc) {

        try {

            String sql = "delete from CLIENTES where cedula_cliente = '" + doc + "' ";
            cn.conectar();
            boolean result = cn.ejecutar(sql);

            cn.CerrarConexion();

            return result;

        } catch (SQLException ex) {
            Logger.getLogger(ControlJFRegistroCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void actualizar() {
        if (validateFormulario()) {
            Cliente objeto = new Cliente();
            objeto.setCedula(jfrcliente.Tnumero.getText().toUpperCase());
            objeto.setNombre(jfrcliente.Tnombre.getText().toUpperCase());
            objeto.setApellido(jfrcliente.Tapellido.getText().toUpperCase());
            objeto.setTelefono(jfrcliente.Ttelefono.getText().toUpperCase());
            objeto.setDireccion(jfrcliente.Tdireccion.getText().toUpperCase());
            objeto.setCorreo(jfrcliente.Temail.getText().toUpperCase());
            objeto.setCiudad(jfrcliente.Tciudad.getText().toUpperCase());
            objeto.setEstado(jfrcliente.Cestado.getSelectedItem().toString().toUpperCase());
            objeto.setDiscapacidad(jfrcliente.Tdiscapacidad.getText().toUpperCase());
            objeto.setEdad(Integer.parseInt(jfrcliente.Tedad.getText().toUpperCase()));
            objeto.setEstrato(Integer.parseInt(jfrcliente.Cestrato.getSelectedItem().toString().toUpperCase()));

            if (updateClienteByDocument(objeto)) {
                IO.mostrar("Cliente Actualizado");
                clean();
            } else {
                IO.mostrar("Cliente no Actualizado");
            }
        } else {
            IO.mostrar("Diligencie todos los campos obligatorios.");
        }
    }

    public void eliminar() {

        if ("".equalsIgnoreCase(jfrcliente.Tnumero.getText().trim())) {

            IO.mostrar("Digite un numero de documento.");
            clean();
            jfrcliente.Beliminar.setEnabled(false);
            jfrcliente.Bactualizar.setEnabled(false);
        } else if (deleteCliente(jfrcliente.Tnumero.getText().trim())) {
            IO.mostrar("Cliente Eliminado.");
            jfrcliente.Beliminar.setEnabled(false);
            jfrcliente.Bactualizar.setEnabled(false);
            clean();
        } else {
            IO.mostrar("No se pudo Eliminar el Cliente.");
            jfrcliente.Beliminar.setEnabled(false);
            jfrcliente.Bactualizar.setEnabled(false);
            clean();
        }
    }

    public void consultar() {
        if ("".equalsIgnoreCase(jfrcliente.Tnumero.getText().trim())) {

            IO.mostrar("Digite un numero de documento.");
            clean();
        } else {
            Cliente result = findUserByDocumento(jfrcliente.Tnumero.getText().trim());
            if (result != null) {
                jfrcliente.Tnumero.setText(result.getCedula());
                jfrcliente.Tnombre.setText(result.getNombre());
                jfrcliente.Tapellido.setText(result.getApellido());
                jfrcliente.Ttelefono.setText(result.getTelefono());
                jfrcliente.Tdireccion.setText(result.getDireccion());
                jfrcliente.Temail.setText(result.getCorreo());
                jfrcliente.Tciudad.setText(result.getCiudad());
                jfrcliente.Cestado.setSelectedItem(result.getEstado());
                jfrcliente.Tdiscapacidad.setText(result.getDiscapacidad());
                jfrcliente.Tedad.setText(String.valueOf(result.getEdad()));
                jfrcliente.Cestrato.setSelectedItem(String.valueOf(result.getEstrato()));
                jfrcliente.Beliminar.setEnabled(true);
                jfrcliente.Bactualizar.setEnabled(true);
                jfrcliente.Bregistrar.setEnabled(false);
                jfrcliente.Tnumero.setEditable(false);
            } else {
                IO.mostrar("Usuario no encontrado.");
                clean();
            }

        }

    }

    public void guardar() {
        if (validateFormulario()) {
            Cliente objeto = new Cliente();
            objeto.setCedula(jfrcliente.Tnumero.getText().toUpperCase());
            objeto.setNombre(jfrcliente.Tnombre.getText().toUpperCase());
            objeto.setApellido(jfrcliente.Tapellido.getText().toUpperCase());
            objeto.setTelefono(jfrcliente.Ttelefono.getText().toUpperCase());
            objeto.setDireccion(jfrcliente.Tdireccion.getText().toUpperCase());
            objeto.setCorreo(jfrcliente.Temail.getText().toUpperCase());
            objeto.setCiudad(jfrcliente.Tciudad.getText().toUpperCase());
            objeto.setEstado(jfrcliente.Cestado.getSelectedItem().toString().toUpperCase());
            objeto.setDiscapacidad(jfrcliente.Tdiscapacidad.getText().toUpperCase());
            objeto.setEdad(Integer.parseInt(jfrcliente.Tedad.getText().toUpperCase()));
            objeto.setEstrato(Integer.parseInt(jfrcliente.Cestrato.getSelectedItem().toString().toUpperCase()));

            if (createCliente(objeto)) {
                IO.mostrar("Cliente Creado");
                clean();
            } else {
                IO.mostrar("Cliente no Creado");
            }
        } else {
            IO.mostrar("Diligencie todos los campos obligatorios.");
        }
    }

    public void clean() {
        jfrcliente.Tnumero.setEditable(true);
        jfrcliente.Bactualizar.setEnabled(false);
        jfrcliente.Beliminar.setEnabled(false);
        jfrcliente.Bregistrar.setEnabled(true);
        jfrcliente.Tnumero.setText("");
        jfrcliente.Tnombre.setText("");
        jfrcliente.Tapellido.setText("");
        jfrcliente.Ttelefono.setText("");
        jfrcliente.Tdireccion.setText("");
        jfrcliente.Temail.setText("");
        jfrcliente.Tciudad.setText("");
        jfrcliente.Cestado.setSelectedItem("Seleccione");
        jfrcliente.Tdiscapacidad.setText("");
        jfrcliente.Tedad.setText("");
        jfrcliente.Cestrato.setSelectedItem("Seleccione");
        //jfrcliente.setEnableTrue();
    }

    public boolean validateFormulario() {

        return !("".equalsIgnoreCase(jfrcliente.Tnumero.getText().toUpperCase())
                || "".equalsIgnoreCase(jfrcliente.Tnombre.getText().toUpperCase())
                || "".equalsIgnoreCase(jfrcliente.Ttelefono.getText().toUpperCase())
                || "".equalsIgnoreCase(jfrcliente.Tdireccion.getText().toUpperCase())
                || "".equalsIgnoreCase(jfrcliente.Temail.getText().toUpperCase())
                || "".equalsIgnoreCase(jfrcliente.Tciudad.getText().toUpperCase())
                || "".equalsIgnoreCase(jfrcliente.Tdiscapacidad.getText().toUpperCase())
                || "".equalsIgnoreCase(jfrcliente.Tedad.getText().toUpperCase()));

    }

}
