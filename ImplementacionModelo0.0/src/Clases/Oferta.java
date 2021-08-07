
package Clases;

public class Oferta {
    
    private float descuento;
    private TipoDeOferta tipo;

    public Oferta(TipoDeOferta tipoOferta) {
        this.tipo = tipoOferta;
        calcularDescuento();
    }
    
    //Calculo el descuento dependiendo del tipo de oferta
    public final void calcularDescuento(){
        switch (tipo.name()){
            case "edad":
                descuento = 2.1f;
                break;
            case "grupo":
                descuento = 4.1f;
                break;
            case "temporadaBaja":
                descuento = 5;
                break;
            default:
                descuento = 0;
                break;
        }
    }
    
    public float getDescuento(){
        return descuento;
    }
}
