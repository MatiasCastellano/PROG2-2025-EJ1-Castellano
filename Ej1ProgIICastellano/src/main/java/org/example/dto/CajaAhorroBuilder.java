package org.example.dto;

public class CajaAhorroBuilder implements Builder{
    public int id;
    @Override
    public void setId(int id) {
        this.id=id;
    }

    public CajaAhorro getResult(){
        return new CajaAhorro(id);
    }
}
