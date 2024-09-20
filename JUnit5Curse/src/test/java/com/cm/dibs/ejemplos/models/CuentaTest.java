package com.cm.dibs.ejemplos.models;

import org.junit.jupiter.api.Test;
// este es un import statico para no tener que llamar a las clases a cada rato
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    // tiene que ser un metodo default o package
    // varios utilizan la siguiente nomenclatura que es utilizando _ para los nombres de los metodos
    @Test
    void test_nombre_cuenta(){
        Cuenta cuenta = new Cuenta("israel",new BigDecimal("1000.12345"));
        cuenta.setPersona("Israel");
        String esperado = "Israel";
        String real = cuenta.getPersona();
        assertEquals(esperado,real);
        cuenta.setPersona("bobadilla");
        real = cuenta.getPersona();
        assertEquals(esperado,real);
        assertTrue(real.equals("bobadilla"));
    }
    // cada instancia del metodo son aisladas, el orden no importa
    @Test
    void testSaldoCuenta(){
        Cuenta cuenta = new Cuenta("Israel", new BigDecimal("1000.12345"));
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
    }
}