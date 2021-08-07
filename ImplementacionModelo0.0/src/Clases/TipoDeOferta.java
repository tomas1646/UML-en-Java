
package Clases;


public enum TipoDeOferta{
    edad("Edad"),grupo("Grupo"),temporadaBaja("Temporada Baja");
    
    private final String nombre;

    private TipoDeOferta(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
}
