
package Clases;

import java.util.ArrayList;


public class Reserva implements Operación{

    private TipoDeReserva tipo;
    private TipoDeHabitación habitación;
    private String fechaDeEntrada;
    private String fechaDeSalida;
    private String cliente;
    private TipoDeOferta oferta;
    private TipoDePago pago;
    private float precioTotal;
    
    private ArrayList<Habitación> correspondeA = new ArrayList<>();
    private Oferta corresponde;
    private final Empleado esDel;

    public Reserva(TipoDeReserva tipoReserva, TipoDeHabitación tipoHabitación, String fechaDeEntrada,
            String fechaDeSalida, String cliente, TipoDeOferta tipoOferta, TipoDePago tipoPago,
            Empleado esDel) {
        this.tipo = tipoReserva;
        this.habitación = tipoHabitación;
        this.fechaDeEntrada = fechaDeEntrada;
        this.fechaDeSalida = fechaDeSalida;
        this.cliente = cliente;
        if(tipoOferta != null){
            this.oferta = tipoOferta;
            this.corresponde = new Oferta(oferta);
        }
        this.pago = tipoPago;
        this.esDel = esDel;
        this.esDel.RealizaReserva(this);
    }
    
    @Override
    public void mostrarTodosLosDatos(){
        System.out.println("\n\n--------------DATOS DE LA RESERVA--------------");
        System.out.println("Tipo de Reserva: "+tipo.getNombre());
        System.out.println("Tipo de Habitación: "+habitación.getNombre());
        System.out.println("Fecha de Entrada prevista: "+fechaDeEntrada);
        System.out.println("Fecha de Salida prevista: "+fechaDeSalida);
        if(oferta != null){
            System.out.println("Tipo de Oferta: "+oferta.getNombre());
        }else{
            System.out.println("Tipo de Oferta: No se realizo Oferta");
        }
        System.out.println("Forma de Pago: "+pago.getNombre());
        System.out.println("Habitación a nombre de: "+cliente);
        System.out.println("Esta reserva es para "+correspondeA.size()+" habitaciones: \n");
        
        if(correspondeA.size()>0){
            for(int i=0 ; i<correspondeA.size() ; i++){
                Habitación hb = correspondeA.get(i);
                System.out.println("Habitación Número: "+hb.getNumero());
                System.out.println("Precio de la Habitación: "+hb.getPrecio());
                System.out.println("Tipo de la Habitación: "+hb.getTipo().getNombre()+"\n");
            }
        }else{
            System.out.println("Debe asignar habitaciones a la reserva\n");
        }
        System.out.println("El precio total de la reserva es: "+precioTotal);
        if(oferta != null){
            System.out.println("Se le aplico un descuento de "+corresponde.getDescuento()+"%");
        }else{
            System.out.println("No se le aplicó descuento");
        }
        System.out.println("La reserva la realizo el empleado: "+esDel.getApellido()+
                " "+esDel.getNombre());
        System.out.println("Este empleado ha realizado un total de "+esDel.getCantReservas()+" reservas");
    }
    
    //Calcula precio total de la reserva, sumando los precios de las habitaciones y aplicando el descuento
    public void calcularPrecio(){
        precioTotal = 0;
        for(int i=0 ; i<correspondeA.size() ; i++){
            precioTotal += correspondeA.get(i).getPrecio();
        }
        if(this.oferta != null){
            precioTotal -= (precioTotal * corresponde.getDescuento())/100;
        }
    }

    //Agrego una habitación a la reserva, cardinalidad *
    public void asignarHabitación(Habitación habitación){
        correspondeA.add(habitación);
        correspondeA.get(correspondeA.size()-1).agregarReserva(this);
        calcularPrecio();
    }

    public String getFechaDeEntrada() {
        return fechaDeEntrada;
    }

    public String getFechaDeSalida() {
        return fechaDeSalida;
    }
}


