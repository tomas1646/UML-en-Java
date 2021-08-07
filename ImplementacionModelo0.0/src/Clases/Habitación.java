
package Clases;

import java.util.ArrayList;

public class Habitación{
    
    private boolean estado;
    private float precio;
    private TipoDeHabitación tipo;
    private int numero;
    
    private ArrayList<Reserva> esDe = new ArrayList<>();

    public Habitación(boolean estado, float precio, TipoDeHabitación tipoHabitacion, int numero) {
        this.estado = estado;
        this.precio = precio;
        this.tipo = tipoHabitacion;
        this.numero = numero;
    }
    
    public void mostrarFechasOcupada(){
        System.out.println("---------------");
        System.out.println("La habitacion "+numero+" esta ocupada");
        for(int i=0; i < esDe.size(); i++){
        System.out.println("\nDel :"+esDe.get(i).getFechaDeEntrada());
        System.out.println("Hasta el: "+esDe.get(i).getFechaDeSalida());
        }
    }
    
    //Asigna a la habitación una reserva
    public void agregarReserva(Reserva esDe){
        this.esDe.add(esDe);
    }

    public float getPrecio() {
        return precio;
    }

    public TipoDeHabitación getTipo() {
        return tipo;
    }

    public int getNumero() {
        return numero;
    }
}
