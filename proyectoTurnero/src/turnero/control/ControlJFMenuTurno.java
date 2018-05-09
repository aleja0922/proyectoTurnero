package turnero.control;

import turnero.modelo.Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import turnero.vista.JFMenuTurno;
import turnero.vista.JFRegistroCliente;

public class ControlJFMenuTurno implements ActionListener {

    JFMenuTurno jf;

    Cliente cliente = new Cliente();
    JFRegistroCliente jfrcliente = new JFRegistroCliente();

    @SuppressWarnings("LeakingThisInConstructor")
    public ControlJFMenuTurno(JFMenuTurno jf) {

        this.jf = jf;

        jf.Bregistrocliente.addActionListener(this);
        jf.Bregistroempleado.addActionListener(this);
        jf.Bregistroempleado.setEnabled(false);
        jf.Bmostrar.addActionListener(this);
        jf.Bmostrar.setEnabled(false);
        jf.Bsalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jf.Bregistrocliente) {
            ControlJFRegistroCliente cjfrcliente = new ControlJFRegistroCliente(cliente, jfrcliente);
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
                    + " \nCIUDAD: " + cliente.getCiudad()
                    + " \nESTADO USUARIO: " + cliente.getEstado()
                    + " \nDISCAPACIDAD DE USUARIO: " + cliente.getDiscapacidad()
                    + " \nEDAD USUARIO: " + cliente.getEdad()
                    + " \nESTRATO: " + cliente.getEstrato()
            );
        }
        if (e.getSource() == jf.Bsalir) {
            jf.dispose();
            System.exit(0);
        }

    }
}
