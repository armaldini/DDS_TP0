package tp0;

public class RemitoConServiciosException extends Exception {
    public RemitoConServiciosException(){
        super("No se puede generar el remito porque hay servicios en la lista de items.");
    }
}
