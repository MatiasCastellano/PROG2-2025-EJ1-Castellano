package org.example.dto;

public interface IGestionSaldo {
    Resultado agregarSaldo(double monto);
    Resultado quitarSaldo(double monto);
    double getSaldo();
    int getOperaciones();
}
