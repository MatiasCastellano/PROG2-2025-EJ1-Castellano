package org.example.service;
import java.util.ArrayList;
import java.util.List;

import org.example.dto.*;

public class LogicaCuenta {
    private static LogicaCuenta instancia;
    private List<Cuenta> cuentas;
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
            Cuenta cuenta1= new Cuenta();
            if (cuenta1.id==cod){
             if (cuenta1 instanceof CajaAhorro){
                 CajaAhorro ahorro= (CajaAhorro) cuenta1;
                 return ahorro;
             }else{
                 CuentaCorriente corriente= (CuentaCorriente) cuenta1;
                return corriente;
             }
            }
        }
        return null;
    }
    public void agregarCuenta(Cuenta cuentaNueva){
        cuentas.add(cuentaNueva);
    }

}
