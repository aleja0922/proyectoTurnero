package turnero.control;

import javax.swing.*;

public class IO {

    public static double leerDecimal(String mensaje) {
        double numero = 0.0;
        numero = Double.parseDouble(JOptionPane.showInputDialog(null, mensaje));
        return numero;
    }

    public static int leerEntero(String mensaje) {
        int numero = 0;
        numero = Integer.parseInt(JOptionPane.showInputDialog(null,
                mensaje));
        return numero;
    }

    public static String leerPalabra(String mensaje) {
        String cadena = "";
        cadena = JOptionPane.showInputDialog(null,mensaje);
        return cadena;
    }

    public static void escribir(String mensaje) {
        JOptionPane.showMessageDialog(null, new JTextArea(mensaje));
    }

    public static int leerConfirmacion(String mensaje) {
        int numero = 0;
        numero = JOptionPane.showConfirmDialog(null, mensaje,
                "TURNERO", JOptionPane.YES_NO_OPTION);
        return numero;
    }
     public static void mostrar(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

}