
package Clases;

public enum TipoDePago{
    transferencia("Transferencia"),tarjeta("Tarjeta"),efectivo("Efectivo");
    
    private final String nombre;

    private TipoDePago(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }
}