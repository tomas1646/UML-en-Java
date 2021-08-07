
package Clases;

import java.util.ArrayList;

public class Empleado{
    
    private static int contadorInstancias;
    
    private final String nombre;
    private final String apellido;
    private final int dni;
    private float sueldo;
    
    private ArrayList<Reserva> realiza = new ArrayList<>();

    public Empleado(String nombre, String apellido, int dni, float sueldo) throws ErrorObjeto{
        if(contadorInstancias >= 3){
            throw new ErrorObjeto(this.getClass().getSimpleName());
        }else{
            contadorInstancias +=1;
            this.nombre = nombre;
            this.apellido = apellido;
            this.dni = dni;
            this.sueldo = sueldo;
        }
    }

    //Asigna al empleado, una reserva que realizó
    public void RealizaReserva(Reserva R) {
        this.realiza.add(R);
    }
    
    //Se usa para mostrar cuantas reservas ha realizado el empleado
    public int getCantReservas(){
        return this.realiza.size();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
