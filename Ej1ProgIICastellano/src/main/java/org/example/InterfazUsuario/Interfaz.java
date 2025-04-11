package org.example.InterfazUsuario;

import org.example.dto.CuentaCorriente;
import org.example.dto.CuentaCorrienteBuilder;
import org.example.service.LogicaCuenta;

import java.util.Random;

public class Interfaz {
    public static void main(String[] args) {
        Random random = new Random();
        LogicaCuenta service= LogicaCuenta.getInstance();
        for (int j=0; j<10; j++){
            int accion = random.nextInt(2);
            if (accion==0){
                CuentaCorrienteBuilder cuentaCorriente= new CuentaCorrienteBuilder();
                cuentaCorriente.setId(j+1);
                cuentaCorriente.setMontoGiroDescubierto(random.nextDouble(15000,50000));
                
            }
        }
    }
}
