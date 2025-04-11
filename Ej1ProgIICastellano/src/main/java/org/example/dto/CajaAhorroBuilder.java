package org.example.dto;

public class CajaAhorroBuilder implements Builder{
    public int id;
    @Override
    public void setId(int id) {
        this.id=id;
    }

    @Override
    public Cuenta builder() {
        return new CajaAhorro(id);
    }
}
