/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package congruencialmixto;

import java.util.Scanner;

/**
 *
 * @author Walter MaldonadodeE
 */
import javax.swing.JOptionPane;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class CongruencialMixto {

    //METODO PARA VERIFICAR EL NUMERO PRIMO
    public static boolean primo(int num) {
        int cont = 2;
        boolean n_primo = true;
        while ((n_primo) && (cont != num)) {
            if (num % cont == 0) {
                n_primo = false;
            }
            cont++;
        }
        return n_primo;
    }

    //METODO PARA ESCOGER EL NUMERO PRIMO RELATIVO A M
    public static double numero_Primo_Cercano(double num) {
        int cont = 2;
        boolean n_primo = true;

        while ((n_primo) && (cont != num)) {
            if (num % cont == 0) {
                n_primo = false;
            }
            cont++;
        }

        if (n_primo) {
            return num;
        } else {
            return numero_Primo_Cercano(num - 1);
        }

    }

    public static void main(String[] args) {
        double x_semilla = 0;
        int k, a_multiplicador, c_aditiva;

        double g = 0, n = 0, m_modulo, x;

        boolean entero = true;
        //SELECCIONAR EL MODULO
        int n_validacion = 0;
        while (entero) {
            try {
                n_validacion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor de g", "MODULO \nm=2^g", JOptionPane.INFORMATION_MESSAGE));
                entero = false;
            } catch (NumberFormatException e) {

            }
        }
        g = n_validacion;

        m_modulo = Math.pow(2, g);

        //SELECCIONAR EL VALOR DEL MULTIPLICADOR
        //a = 1 + 4k
        entero = true;
        n_validacion = 0;
        while (entero) {
            try {
                n_validacion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese k para el calculo del Multiplicador:", "MULTIPLICADOR\na=1+4k", JOptionPane.INFORMATION_MESSAGE));
                entero = false;
            } catch (NumberFormatException e) {

            }
        }
        k = n_validacion;

        a_multiplicador = 1 + (4 * k);
        //SELECCIONAR EL VALOR DE LA CONSTANTE ADITIVA
        c_aditiva = (int) CongruencialMixto.numero_Primo_Cercano(m_modulo);

        JOptionPane.showMessageDialog(null, "El valor primo relativo a M es: " + CongruencialMixto.numero_Primo_Cercano(c_aditiva));
        x = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el valor de X", "SEMILLA", JOptionPane.INFORMATION_MESSAGE));

        boolean validar_X = true;
        while (validar_X) {
            if (x > 0) {
                validar_X = false;
            } else {
                x = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el valor de X", "SEMILLA", JOptionPane.INFORMATION_MESSAGE));
            }
        }

        JOptionPane.showMessageDialog(null, "**SERIE GENERADA**");
        System.out.println("Contador (i)" + "\t\t" + "Semilla (x)" + "\t\t" + "n" + "\t\t" + "(n/modulo)");
        double periodo = x / m_modulo;

        for (int i = 0; i < m_modulo; i++) {
            int cont = 1;
            n = (a_multiplicador * x + c_aditiva) % m_modulo;
            System.out.println(i + "\t\t\t" + x + "\t\t\t" + n + "\t\t" + n + "/" + m_modulo);
            x = n;
            if (periodo == n / m_modulo) {
                System.out.println("LA SERIE GENERA " + cont + " PERIODOS");
                cont++;
            }
        }

    }
}


