/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Random;

/**
 *
 * @author CRISTIANR
 */
public class Cajero {
     private boolean ocupado;
    private int tiempoTransaccion;
    private int tiempoAcumulado;

    public Cajero(int tiempoMinimo, int tiempoMaximo){
        Random random = new Random();
        this.tiempoTransaccion = random.nextInt(tiempoMaximo - tiempoMinimo + 1) + tiempoMinimo;
        this.ocupado = false;
        this.tiempoAcumulado = 0;
    }
    
    public void atenderCliente(){
        if(!ocupado){
            ocupado = true;
            // No necesitas hacer nada aquí si no estás usando tiempoRestante
        }
    }
    
    public void avanzarTiempo(){
        if(ocupado){
            // Asumiendo que avanzarTiempo se llama una vez por unidad de tiempo
            tiempoAcumulado++;
            if(tiempoAcumulado >= tiempoTransaccion){
                ocupado = false;
                tiempoAcumulado = 0; // Restablecer tiempoAcumulado después de completar una transacción
            }
        }
    }
    
    public boolean estaOcupado(){
        return ocupado;
    }
    
    public int getTiempoTransaccion(){
        return tiempoTransaccion;
    }
    
    public int getTiempoAcumulado(){
        return tiempoAcumulado;
    }
}
