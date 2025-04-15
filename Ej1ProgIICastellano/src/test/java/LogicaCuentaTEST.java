import org.example.dto.CajaAhorro;
import org.example.dto.CuentaCorriente;
import org.example.dto.Resultado;
import org.example.service.LogicaCuenta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LogicaCuentaTEST {
    LogicaCuenta service;
    @BeforeEach
    public void setUp(){
        service= LogicaCuenta.getInstance();
    }
    @Test
    public void AgregarSaldoOk(){
        service.agregarCuenta(new CajaAhorro(1));
        Resultado resultado= new Resultado();
        resultado= service.agregarSaldo(1,1500);
        assertTrue(resultado.sucesso);
    }
    @Test
    public void AgregarSaldoCuentaInexistente(){
        service.agregarCuenta(new CajaAhorro(1));
        Resultado resultado= new Resultado();
        resultado= service.agregarSaldo(12,1500);
        assertFalse(resultado.sucesso);
    }
    @Test
    public void ConsultarSaldoOk(){

        service.agregarCuenta(new CajaAhorro(1));
        Resultado resultado= new Resultado();
        resultado= service.agregarSaldo(1,3000);
        double saldo= service.consultarSaldo(1);
        assertEquals(saldo,3000);
    }
    @Test
    public void QuitarSaldoOk(){

        service.agregarCuenta(new CajaAhorro(1));
        Resultado resultado= new Resultado();
        service.agregarSaldo(1,3000);
        resultado= service.quitarSaldo(1,2000);
        assertTrue(resultado.sucesso);
    }
    @Test
    public void QuitarSaldoCuentaNoEncontradaOk(){
        service.agregarCuenta(new CajaAhorro(1));
        Resultado resultado= new Resultado();
        service.agregarSaldo(1,3000);
        resultado= service.quitarSaldo(100,2000);
        assertFalse(resultado.sucesso);
    }

    @Test
    public void QuitarSaldoNoPosibleOk(){

        service.agregarCuenta(new CuentaCorriente(1,2000));
        Resultado resultado= service.quitarSaldo(1,5000);
        assertFalse(resultado.sucesso);
    }

}
