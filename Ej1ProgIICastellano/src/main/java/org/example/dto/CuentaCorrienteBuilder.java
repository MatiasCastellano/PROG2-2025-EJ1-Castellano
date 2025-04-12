package org.example.dto;

public class CuentaCorrienteBuilder implements Builder{
    public int id;
    public double montoGiroDescubierto;
    @Override
    public void setId(int id) {
        this.id= id;
    }
    public void setMontoGiroDescubierto(double monto){
        this.montoGiroDescubierto=monto;
    }

    public CuentaCorriente getResult(){
        return new CuentaCorriente(id,montoGiroDescubierto);
    }
}
