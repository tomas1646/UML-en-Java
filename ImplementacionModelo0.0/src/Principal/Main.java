
package Principal;

import Clases.ErrorObjeto;
import Clases.Habitación;
import Clases.Reserva;
import Clases.TipoDeHabitación;
import Clases.TipoDeOferta;
import Clases.TipoDePago;
import Clases.TipoDeReserva;
import Clases.Empleado;
import java.util.ArrayList;


public class Main {
    
    public static void main(String[] args){
        
        //Llevo lista de empleados
        ArrayList<Empleado> Empleados = new ArrayList<>();

        try{

            Empleado em1 = new Empleado("Tomás", "Espinosa", 43416880, 6552.50f);
            System.out.println("Se registro el empleado "+em1.getApellido());
            Empleados.add(em1);

            Empleado em2 = new Empleado("Mariano", "Morata", 42969543, 5000);
            System.out.println("Se registro el empleado "+em2.getApellido());
            Empleados.add(em2);

            Empleado em3 = new Empleado("Juan", "Martinez", 42366987, 5000);
            System.out.println("Se registro el empleado "+em3.getApellido());
            Empleados.add(em3);

            //Si creo mas de 3 empleados, lanza la excepción ErrorObjeto
            Empleado em4 = new Empleado("Alejandra", "Gutierrez", 42969543, 5000);
            System.out.println("Se registro el empleado "+em4.getApellido());
            Empleados.add(em4);

        }catch(ErrorObjeto ob){
            System.out.println("No se pueden crear mas de 3 objetos");
        }
        
        
        Habitación hb1 = new Habitación(true, 500, TipoDeHabitación.valueOf("doble"), 1);
        Habitación hb2 = new Habitación(true, 600, TipoDeHabitación.valueOf("individual"), 2);
        Habitación hb3 = new Habitación(true, 700, TipoDeHabitación.valueOf("familiar"), 3);


        
        Reserva res1 = new Reserva(TipoDeReserva.valueOf("presencial"), TipoDeHabitación.valueOf("doble"),
                "20/03/2020", "06/04/2020", "Sergio Ariel", TipoDeOferta.valueOf("edad"),
                TipoDePago.valueOf("transferencia"), Empleados.get(0));
        
        res1.asignarHabitación(hb1);
        res1.asignarHabitación(hb3);
        
        
        Reserva res2 = new Reserva(TipoDeReserva.valueOf("internet"), TipoDeHabitación.valueOf("individual"),
                "09/04/2020", "28/04/2020", "Louis Hemsy", TipoDeOferta.valueOf("grupo"),
                TipoDePago.valueOf("efectivo"), Empleados.get(0));
        //Reserva puede no tener asignadas habitaciones cardinalidad *
        
        
        //Reserva puede no tener oferta. Cardinalidad 0..1
        Reserva res3 = new Reserva(TipoDeReserva.valueOf("teléfono"), TipoDeHabitación.valueOf("familiar"),
                "10/05/2020", "16/05/2020", "Javier Ambrosini", null,
                TipoDePago.valueOf("tarjeta"), Empleados.get(2));
        
        res3.asignarHabitación(hb1);
        res3.asignarHabitación(hb2);
        res3.asignarHabitación(hb3);
        
        
        res1.mostrarTodosLosDatos();
        res2.mostrarTodosLosDatos();
        res3.mostrarTodosLosDatos();
        
        
        hb1.mostrarFechasOcupada();
        hb2.mostrarFechasOcupada();
        hb3.mostrarFechasOcupada();
        
        //Verifico la cardinalidad * de empleados con reserva, este empleado debe tener 0 reservas
        System.out.println("\n\nEl empleado "+Empleados.get(1).getApellido()+
                ", realizó un total de "+Empleados.get(1).getCantReservas()+
                " reservas");
    }
}
