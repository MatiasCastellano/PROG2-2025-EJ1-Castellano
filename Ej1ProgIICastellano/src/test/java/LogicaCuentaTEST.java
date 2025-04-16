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
        service.limpiarCuentas();
        service.agregarCuenta(new CajaAhorro(1));
        service.agregarCuenta(new CuentaCorriente(2,1500));

    }
    @Test
    public void AgregarSaldoCajaAhorroOk(){
        Resultado resultado= service.agregarSaldo(1,1500);
        assertTrue(resultado.sucesso);
    }
    @Test
    public void AgregarSaldoCuentaInexistente(){
        Resultado resultado= service.agregarSaldo(12,1500);
        assertFalse(resultado.sucesso);
    }
    @Test
    public void ConsultarSaldoCajaAhorroOk(){
        Resultado resultado= service.agregarSaldo(1,3000);
        double saldo= service.consultarSaldo(1);
        assertEquals(saldo,3000);
    }
    @Test
    public void QuitarSaldoCajaAhorroOk(){
        service.agregarSaldo(1,3000);
        Resultado resultado= service.quitarSaldo(1,2000);
        assertTrue(resultado.sucesso);
    }
    @Test
    public void CantOperacionesCajaAhorroOk(){
        service.agregarSaldo(1,200);
        int cant= service.cuentas.get(0).cantOperaciones;
        assertEquals(cant,1);
    }
    @Test
    public void AgregarSaldoCuentaCorrienteOk(){
        Resultado resultado= service.agregarSaldo(2,3000);
        assertTrue(resultado.sucesso);
    }
    @Test
    public void QuitarSaldoCuentaNoEncontradaOk(){
        service.agregarSaldo(2,3000);
        Resultado resultado= service.quitarSaldo(100,2000);
        assertFalse(resultado.sucesso);
    }
    @Test
    public void QuitarSaldoCuentaCorrienteOk(){
        Resultado resultado= service.quitarSaldo(2,1000);
        assertTrue(resultado.sucesso);
    }

    @Test
    public void QuitarSaldoCajaAhorroNoPosibleOk(){
        Resultado resultado= service.quitarSaldo(1,5000);
        assertFalse(resultado.sucesso);
    }
    @Test
    public void QuitarSaldoCuentaCorrienteNoPosibleOk(){
        Resultado resultado= service.quitarSaldo(2,150000);
        assertFalse(resultado.sucesso);
    }

}
