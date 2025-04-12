package org.example.InterfazUsuario;

import org.example.dto.*;
import org.example.service.LogicaCuenta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Interfaz {
    public static void main(String[] args)throws ExecutionException,InterruptedException {
        Random random = new Random();
        LogicaCuenta service= LogicaCuenta.getInstance();
        CuentaCorrienteBuilder builderCC= new CuentaCorrienteBuilder();
        CajaAhorroBuilder builderCA= new CajaAhorroBuilder();
        for (int j=0; j<10; j++){
            int accion = random.nextInt(2);
            if (accion==0){
                builderCC.setId(j+1);
                builderCC.setMontoGiroDescubierto(random.nextDouble(15000,50000));
                CuentaCorriente cuenta= builderCC.getResult();
                service.agregarCuenta(cuenta);
            }else{
                builderCA.setId(j+1);
                CajaAhorro caja= builderCA.getResult();
                service.agregarCuenta(caja);
            }
        }
        ExecutorService executor= Executors.newFixedThreadPool(5);
        List<Future<Resultado>> futures = new ArrayList<Future<Resultado>>();
        long star= System.currentTimeMillis();
        for(int j=0; j<10000; j++){
            Callable<Resultado> tarea= null;
            int num= random.nextInt(11);
            int numAccion= random.nextInt(2);
            double monto= random.nextDouble(500,1000);
            if (numAccion==0){
                tarea= new Callable<Resultado>() {
                    public  Resultado call() throws InterruptedException {
                        Thread.sleep(10);
                        return service.agregarSaldo(num,monto);
                    };
                };
            }else{
                tarea= new Callable<Resultado>() {
                    public  Resultado call() throws InterruptedException {
                        Thread.sleep(10);
                        return service.quitarSaldo(num,monto);
                    };
                };
            }
            futures.add(executor.submit(tarea));
        }
        for (int i=0; i<futures.size();i++){
            Resultado resultado= futures.get(i).get();
        }
            executor.shutdown();
        long end= System.currentTimeMillis();

        for(int i=0; i<service.cuentas.size();i++){
            Cuenta cuenta= service.cuentas.get(i);
            cuenta.imprimirDetalleCuenta();
        }
        System.out.println("demoro:"+(end-star)/1000+ " s");
    }
}
