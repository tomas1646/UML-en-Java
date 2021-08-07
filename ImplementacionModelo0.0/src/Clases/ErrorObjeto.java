
package Clases;

public class ErrorObjeto extends Exception{
    
    public ErrorObjeto(String nombreClaseError){
        System.out.println("\nLa Excepción se produjo en la clase: "+nombreClaseError);
    }
}
