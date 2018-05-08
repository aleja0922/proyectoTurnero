
package turnero.control;
import vista.JFRegistroCliente;
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

public class ControlJFRegistroCliente implements ActionListener{
        BD cn;
    Cliente cliente;
    JFRegistroCliente jfrcliente;
    
    public ControlJFRegistroCliente() {
        cn = new BD();
    }
    @SuppressWarnings("LeakingThisInConstructor")
    
    public ControlJFRegistroCliente (Cliente cliente, JFRegistroCliente jfrcliente ){
         cn = new BD();
        
        this.cliente=cliente;
        this.jfrcliente= jfrcliente;
        
        jfrcliente.Bregistrar.addActionListener(this);
        jfrcliente.Bsalircliente.addActionListener(this);
        
    }
    public boolean crearCliente(Cliente cliente) {
        String sql = "insert into clientes values('"
                 
                + cliente.getCedula()+"', '"
                + cliente.getNombre()+"', '"
                + cliente.getApellido()+ "', "
                + cliente.getEdad() +", " 
                + cliente.getTelefono() + ", '"
                + cliente.getDireccion() + "','" 
                 + cliente.getCorreo() + "', "
                 + cliente.getEstrato() + ", '" 
                 +cliente.getCiudad() + "','" 
                 + cliente.getDiscapacidad()+  "','" 
           + cliente.getEstado() +  "')";
                 
                
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
               
                cliente.setCedula(cn.getRegistro().getInt("cedula_cliente"));
               cliente.setNombre(cn.getRegistro().getString("nombre_cliente"));
                cliente.setApellido(cn.getRegistro().getString("apellido_cliente"));
                cliente.setTelefono(cn.getRegistro().getString("telefono_cliente"));
                cliente.setDireccion(cn.getRegistro().getString("direccion_cliente"));
                cliente.setCorreo(cn.getRegistro().getString("email_cliente"));
                cliente.setCiudad(cn.getRegistro().getString("ciudad_cliente "));
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
     @Override
     public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jfrcliente.Bregistrar) {
            if (validateFormulario()) {
                Cliente cliente=new  Cliente();
                cliente.setCedula(Integer.parseInt(jfrcliente.Tnumero.getText().toUpperCase()));
                cliente.setNombre(jfrcliente.Tnombre.getText().toUpperCase());
                cliente.setApellido(jfrcliente.Tapellido.getText().toUpperCase());
                cliente.setTelefono(jfrcliente.Ttelefono.getText().toUpperCase());
                cliente.setDireccion(jfrcliente.Tdireccion.getText().toUpperCase());
                cliente.setCorreo(jfrcliente.Temail.getText().toUpperCase());
                cliente.setCiudad(jfrcliente.Tciudad.getText().toUpperCase());
                cliente.setEstado(jfrcliente.Cestado.getSelectedItem().toString().toUpperCase());
                 cliente.setDiscapacidad(jfrcliente.Tdiscapacidad.getText().toUpperCase());
                cliente.setEdad(Integer.parseInt(jfrcliente.Tedad.getText().toUpperCase()));
                cliente.setEstrato(Integer.parseInt(jfrcliente.Cestrato.getSelectedItem().toString().toUpperCase()));

                if (crearCliente(cliente)) {
                    IO.mostrar("Cliente Creado");
                    clean();
                } else {
                    IO.mostrar("Cliente no Creado");
                }
            }
        } else {
            IO.mostrar("Diligencie todos los campos obligatorios.");
        }

    }
     

    public void clean() {
         
       jfrcliente.Tnumero.setText("");
       jfrcliente.Tnombre.setText("");
        jfrcliente.Tapellido.setText("");
        jfrcliente.Ttelefono.setText("");
        jfrcliente.Tdireccion.setText("");
        jfrcliente.Temail.setText("");
        jfrcliente.Tciudad.setText("");
        jfrcliente.Cestado.setSelectedItem("SELECCIONE");
        jfrcliente.Tdiscapacidad.setText("");
        jfrcliente.Tedad.setText("");
        jfrcliente.Cestrato.setSelectedItem("SELECCIONE");
        jfrcliente.setEnableTrue();
    }

    public boolean validateFormulario() {

        return !("".equalsIgnoreCase(jfrcliente.Tnumero.getText().toUpperCase())
                || "".equalsIgnoreCase(jfrcliente.Tnombre.getText().toUpperCase())
                || "".equalsIgnoreCase(jfrcliente.Ttelefono.getText().toUpperCase())
                || "".equalsIgnoreCase(jfrcliente.Tdireccion.getText().toUpperCase())
                || "".equalsIgnoreCase(jfrcliente.Temail.getText().toUpperCase())
                || "".equalsIgnoreCase(jfrcliente.Tciudad.getText().toUpperCase())
                || "".equalsIgnoreCase(jfrcliente.Tdiscapacidad.getText().toUpperCase())
                || "".equalsIgnoreCase(jfrcliente.Tedad.getText().toUpperCase())
                
                
                
                
                );

    }

}
