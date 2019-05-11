/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package congruencialmultiplicativo;

import java.util.Scanner;

/**
 *
 * @author Walter MaldonadodeE
 */
public class CongruencialMultiplicativo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        int semilla, cmultiplicativa, caditiva, modulo;
        int i, numero;
        double numero2;

        System.out.print("Escriba una semilla: ");
        semilla = entrada.nextInt();
        System.out.print("Escriba una constante multiplicativa: ");
        cmultiplicativa = entrada.nextInt();
        System.out.print("Escriba el módulo: ");
        modulo = entrada.nextInt();

        for (i = 1; i <= 20; i++) {
            numero = (cmultiplicativa * semilla) % modulo;
            numero2 = (double) numero / (double) (modulo - 1);
            System.out.printf("%d. %d (%.4f)\n", i, numero, numero2);
            semilla = numero;
        }
    }
    
}
