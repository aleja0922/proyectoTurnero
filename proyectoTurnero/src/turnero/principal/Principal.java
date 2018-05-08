
package turnero.principal;
import turnero.control.ControlJFMenuTurno;
import turnero.vista.*;
import vista.JFMenuTurno;

public class Principal {
    public static void main(String[] args) {
    JFMenuTurno jf=new JFMenuTurno();
    ControlJFMenuTurno cjfmturno=new ControlJFMenuTurno(jf);
    
    jf.setVisible(true);
        jf.setLocationRelativeTo(null); //centrar ventana

}
}
