
package Clases;


public enum TipoDeHabitación{
    individual("Individual"),doble("Doble"),familiar("Familiar");
    
    String nombre;

    private TipoDeHabitación(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    } 
}
