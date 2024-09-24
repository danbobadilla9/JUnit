package com.cm.dibs.ejemplos.models;

import com.cm.dibs.ejemplos.exceptions.DineroInsuficienteException;
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

    @Test
    void testReferenciaCuenta() {
        Cuenta cuenta = new Cuenta("John Doe", new BigDecimal("8900.9997"));
        Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("8900.9997"));

        //assertNotEquals(cuenta,cuenta2);
        assertEquals(cuenta,cuenta2);

    }

    @Test
    void testDebitoCuenta(){
        Cuenta cuenta = new Cuenta("Israel", new BigDecimal("1000.12345"));
        cuenta.debito(new BigDecimal("100")); // se va a restar
        assertNotNull(cuenta.getSaldo());
        assertEquals(900,cuenta.getSaldo().intValue());
        assertEquals("900.12345",cuenta.getSaldo().toPlainString());
    }


    @Test
    void testCreditoCuenta(){
        Cuenta cuenta = new Cuenta("Israel", new BigDecimal("1000.12345"));
        cuenta.credito(new BigDecimal("100")); // se va a sumar
        assertNotNull(cuenta.getSaldo());
        assertEquals(1100,cuenta.getSaldo().intValue());
        assertEquals("1100.12345",cuenta.getSaldo().toPlainString());
    }

    @Test
    void testDineroInsuficienteException(){
        Cuenta cuenta = new Cuenta("Israel", new BigDecimal("1000.12345"));
        // este metodo regresa el tipo de exception
        Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
            cuenta.debito(new BigDecimal("1000000"));
        } );
        String actual = exception.getMessage();
        String esperado = "Dinero insuficiente";
        assertEquals(esperado,actual);
    }






















}