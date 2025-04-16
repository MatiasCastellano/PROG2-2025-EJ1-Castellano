package org.example.service;
import java.util.ArrayList;
import java.util.List;

import org.example.dto.*;

public class LogicaCuenta {
    private static LogicaCuenta instancia;
    public List<Cuenta> cuentas;
    private LogicaCuenta(){
        cuentas= new ArrayList<>();
    }

    public static LogicaCuenta getInstance(){
        if (instancia==null){
            instancia= new LogicaCuenta();
        }
        return instancia;
    }
    public Resultado agregarSaldo(int codCuenta,double monto){
        Cuenta cuentaAgregar= buscarCuenta(codCuenta);
        Resultado resultado= new Resultado();
        if (cuentaAgregar==null){
            resultado.setMessage("no se encontro la cuenta");
            resultado.setSucesso(false);
            return resultado;
        };
        if (cuentaAgregar instanceof CajaAhorro){
            resultado=((CajaAhorro) cuentaAgregar).agregarSaldo(monto);
        }else{
            resultado=((CuentaCorriente)cuentaAgregar).agregarSaldo(monto);
        }
        return resultado;
    }
    public Resultado quitarSaldo(int cod, double monto){
        Cuenta cuentaAgregar= buscarCuenta(cod);
        Resultado resultado= new Resultado();
        if (cuentaAgregar==null){
            resultado.setMessage("no se encontro la cuenta");
            resultado.setSucesso(false);
            return resultado;
        };
        if (cuentaAgregar instanceof CajaAhorro){
            resultado=((CajaAhorro) cuentaAgregar).quitarSaldo(monto);
        }else{
            resultado=((CuentaCorriente)cuentaAgregar).quitarSaldo(monto);
        }
        return resultado;
    }
    public double consultarSaldo(int cod){
        Cuenta cuentaConsultar= buscarCuenta(cod);
        double saldo= 0;
        if (cuentaConsultar==null){
            return saldo;
        };
        if (cuentaConsultar instanceof CajaAhorro){
            saldo=((CajaAhorro) cuentaConsultar).getSaldo();
        }else{
            saldo=((CuentaCorriente)cuentaConsultar).getSaldo();
        }
        return saldo;
    }

    private Cuenta buscarCuenta(int cod){
        for(int i=0; i<cuentas.size();i++){
            if (cuentas.get(i).id==cod){
                return cuentas.get(i);
            }
        }
        return null;
    }
    public void agregarCuenta(Cuenta cuentaNueva){
        cuentas.add(cuentaNueva);
    }

    public void limpiarCuentas(){
        cuentas.clear();
    }
}
