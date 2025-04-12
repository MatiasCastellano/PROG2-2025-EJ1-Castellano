package org.example.dto;

public class CajaAhorro extends Cuenta implements IGestionSaldo{

    public CajaAhorro(int cod){
        this.id=cod;
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
        if(saldo<monto){
            resultado.setSucesso(false);
            resultado.setMessage("no alcanza para retirar, el saldo es menor");
            return  resultado;
        }
        cantOperaciones++;
        saldo=-monto;
        resultado.setMessage("saldo quitado con exito");
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
