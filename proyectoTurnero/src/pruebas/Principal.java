/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import turnero.control.ControlJFMenuTurno;
import turnero.vista.JFMenuTurno;

/**
 *
 * @author Usuario
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
/*
        String[] abecedario = new String[27];
        abecedario[0] = "A";
        abecedario[1] = "B";
        abecedario[2] = "C";
        abecedario[3] = "D";
        abecedario[4] = "E";
        abecedario[5] = "F";
        abecedario[6] = "G";
        abecedario[7] = "H";
        abecedario[8] = "I";
        abecedario[9] = "J";
        abecedario[10] = "K";
        abecedario[11] = "L";
        abecedario[12] = "M";
        abecedario[13] = "N";
        abecedario[14] = "Ñ";
        abecedario[15] = "O";
        abecedario[16] = "P";
        abecedario[17] = "Q";
        abecedario[18] = "R";
        abecedario[19] = "S";
        abecedario[20] = "T";
        abecedario[21] = "U";
        abecedario[22] = "V";
        abecedario[23] = "W";
        abecedario[24] = "X";
        abecedario[25] = "Y";
        abecedario[26] = "Z";

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        if (n % 2 == 0) {
            String cadena = "A";
            int letra = 1;
            int contador = 1;
            for (int i = 6; i < 100; i++) {
                

                if (contador != 5) {
                    if (i % 2 == 0) {
                        cadena += "-" + i;
                        contador++;
                    } else {
                        cadena += "" + i;
                        contador++;
                    }
                    
                } else {
                    contador = 1;
                    cadena += abecedario[letra];
                    letra++;
                }
                
                if(abecedario[letra].equalsIgnoreCase("z")){
                    break;
                    
                }

            }
            System.out.println(cadena);
        } else {
            String cadena = "Z";
            int letra = abecedario.length-2;
            int contador = 1;
            for (int i = 6; i < 100; i++) {
                

                if (contador != 5) {
                    if (i % 2 == 0) {
                        cadena += "-" + i;
                        contador++;
                    } else {
                        cadena += "" + i;
                        contador++;
                    }
                    
                } else {
                    contador=1;
                    cadena += abecedario[letra];
                    letra--;
                }
                
                if(abecedario[letra].equalsIgnoreCase("z")){
                    break;
                    
                }

            }
            System.out.println(cadena);

        }

    }*/
        JFMenuTurno jf = new JFMenuTurno();
        ControlJFMenuTurno cjfmturno = new ControlJFMenuTurno(jf);

        jf.setVisible(true);
        jf.setLocationRelativeTo(null); //centrar ventana

    }
}
