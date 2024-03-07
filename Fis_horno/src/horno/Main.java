/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package horno;

import java.util.Scanner;

/**
 *
 * @author sofia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Interfaz inter = new Interfaz();
        inter.setVisible(true);
        
        /*
        Scanner scan = new Scanner(System.in);
        FIS_System fis = new FIS_System();

        System.out.println("Ingrese la humedad en una escala de 0 a 10");
        double humedad = scan.nextDouble();

        System.out.println("Ingrese la intensidad en una escala de 0 a 10");
        double intensidad = scan.nextDouble();

        System.out.println("Ingrese el volumen en una escala de 0 a 10");
        double volumen = scan.nextDouble();

        String result = fis.evaluar(humedad, intensidad, volumen);

        System.out.println(result);
        System.out.println(fis.get_CD());
        */
    }
    
}
