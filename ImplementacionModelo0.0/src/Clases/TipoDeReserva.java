
package Clases;


public enum TipoDeReserva{
    presencial("Presencial"),internet("Internet"),teléfono("Teléfono");
    
    private final String nombre;

    private TipoDeReserva(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
