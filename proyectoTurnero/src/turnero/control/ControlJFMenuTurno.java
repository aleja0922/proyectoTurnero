
package turnero.control;

import turnero.modelo.Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import turnero.control.ControlJFRegistroCliente;
import turnero.control.IO;
import turnero.vista.JFRegistroClienteTurno;
import vista.JFMenuTurno;
import vista.JFRegistroCliente;

public class ControlJFMenuTurno implements ActionListener{
    JFMenuTurno jf;
    
    Cliente cliente=new Cliente ();
    JFRegistroCliente jfrcliente=new JFRegistroCliente();
    
    @SuppressWarnings("LeakingThisInConstructor")
    public ControlJFMenuTurno (JFMenuTurno jf){
        
        this.jf = jf;
        
        jf.Bregistrocliente.addActionListener(this);
        jf.Bregistroempleado.addActionListener(this);
        jf.Bmostrar.addActionListener(this);
        jf.Bsalir.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jf.Bregistrocliente){
            ControlJFRegistroCliente cjfrcliente=new ControlJFRegistroCliente(cliente, jfrcliente);
            jfrcliente.setVisible(true);
            jfrcliente.setLocationRelativeTo(null);
            
        }
        if (e.getSource() == jf.Bmostrar) {
            IO.mostrar("CREAR CLIENTE\n\nNUMERO DOC. DE IDENTIDAD: " + cliente.getCedula()
            + "\nNOMBRE USUARIO: " + cliente.getNombre() 
            + "\nAPELLIDO USUARIO: " + cliente.getApellido()
            + "\nTELEFONO: " + cliente.getTelefono()
            + " \nDIRECCIÓN: " + cliente.getDireccion()
            + " \nEMAIL: " + cliente.getCorreo()
            +  " \nCIUDAD: " + cliente.getCiudad()
            +  " \nESTADO USUARIO: " + cliente.getEstado()
            +  " \nDISCAPACIDAD DE USUARIO: " + cliente.getDiscapacidad()
            +  " \nEDAD USUARIO: " + cliente.getEdad()
            +  " \nESTRATO: " + cliente.getEstrato()
            );
        }
        if (e.getSource() == jf.Bsalir) {
            System.exit(0);
        }
        
    }
}
