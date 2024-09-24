package com.cm.dibs.ejemplos.models;

import com.cm.dibs.ejemplos.exceptions.DineroInsuficienteException;

import java.math.BigDecimal;

public class Cuenta {

    private String persona;
    private BigDecimal saldo;

    public Cuenta(String persona, BigDecimal saldo) {
        this.persona = persona;
        this.saldo = saldo;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }



    public void debito(BigDecimal monto){
//        this.saldo.subtract(monto);// bigdecimal es inmutable, lo que hace es retornar una nueva instancia con ese saldo

        BigDecimal nuevoSaldo = this.saldo.subtract(monto);
        if(nuevoSaldo.compareTo(BigDecimal.ZERO) < 0){
            throw new DineroInsuficienteException("Dinero insuficiente");
        }
        this.saldo = nuevoSaldo;
    }

    public void credito(BigDecimal monto){
        this.saldo = this.saldo.add(monto);


    }



















    @Override
    public boolean equals(Object object){
        // compara incluso si es null
        if(!(object instanceof  Cuenta)){
            return false;
        }
        Cuenta c = (Cuenta) object;
        if(this.persona == null || this.saldo == null){
            return false;
        }

        return this.persona.equals(c.getPersona()) && this.saldo.equals(c.getSaldo());
    }





}
