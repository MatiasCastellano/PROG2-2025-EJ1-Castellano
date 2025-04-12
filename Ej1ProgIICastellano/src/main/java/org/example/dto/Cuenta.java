package org.example.dto;

public class Cuenta  {
    public int id;
    protected double saldo;
    public int cantOperaciones;

    public void imprimirDetalleCuenta(){
        System.out.println("La cuenta numero "+id+"tuvo "+cantOperaciones+"operaciones y tiene un saldo de: "+saldo);
    }
}
