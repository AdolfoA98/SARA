/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fei.domain;

import java.util.Random;

/**
 *
 * @author dell
 */
public class Banco {
    
    public static boolean realizarPagoTarjeta(TarjetaCredito credit, double montoPago){
        double creditoTarjeta = obtenerNumeroEnRango(200, montoPago + 2000);
        
        return creditoTarjeta > montoPago;
    }
    
    private static double obtenerNumeroEnRango(double min, double max) {
        if (min >= max) {
                throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((int) ((max - min) + 1)) + min;
    }  
}
