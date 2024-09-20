package com.cm.dibs.ejemplos.models;

import org.junit.jupiter.api.Test;
// este es un import statico para no tener que llamar a las clases a cada rato
import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    // tiene que ser un metodo default o package
    // varios utilizan la siguiente nomenclatura que es utilizando _ para los nombres de los metodos
    @Test
    void test_nombre_cuenta(){
        Cuenta cuenta = new Cuenta();
        cuenta.setPersona("Israel");
        String esperado = "Israel";
        String real = cuenta.getPersona();
        assertEquals(esperado,real);
        cuenta.setPersona("bobadilla");
        assertEquals(esperado,real);
    }
}