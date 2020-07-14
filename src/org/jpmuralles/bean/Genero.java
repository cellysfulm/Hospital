
package org.jpmuralles.bean;


public class Genero {
    private String idGenero;

    public Genero(String idGenero) {
        this.idGenero = idGenero;
    }
    public Genero(){
    
    }

    public String getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(String idGenero) {
        this.idGenero = idGenero;
    }

    @Override
    public String toString() {
        return "" + idGenero ;
    }
    
}
