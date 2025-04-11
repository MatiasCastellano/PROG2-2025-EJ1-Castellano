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

    @Override
    public Cuenta builder() {
        return new CuentaCorriente(id,montoGiroDescubierto);
    }
}
