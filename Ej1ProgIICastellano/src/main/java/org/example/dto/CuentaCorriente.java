package org.example.dto;

public class CuentaCorriente extends Cuenta implements IGestionSaldo {
    public double montoGiro;

    public void setMontoGiro(double monto){
        this.montoGiro= monto;
    }
    @Override
    public synchronized Resultado agregarSaldo(double monto) {
        saldo+=monto;
        boolean sucesso= true;
        String mensaje= "Se agrego con exito";
        Resultado resultado= new Resultado();
        resultado.setMessage(mensaje);
        resultado.setSucesso(sucesso);
        cantOperaciones++;
        return resultado;
    }

    @Override
    public synchronized Resultado quitarSaldo(double monto) {
        Resultado resultado= new Resultado();
        double saldoDisponible= saldo+montoGiro;
        if(saldoDisponible<monto){
            resultado.setSucesso(false);
            resultado.setMessage("no alcanza para retirar, el saldo incluido el giro descubierto es menor");
            return  resultado;
        }
        cantOperaciones++;
        saldo+=monto;
        resultado.setMessage("se quito con exito");
        resultado.setSucesso(true);
        return resultado;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    @Override
    public int getOperaciones() {
        return cantOperaciones;
    }
}
