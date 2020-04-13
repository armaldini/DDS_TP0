package tp0;
import java.util.*;
import java.util.stream.Collectors;

public abstract class OperacionDeEgreso {
    protected double valor = 0;
    protected List<Item> items;
    protected boolean operacionCerrada = false;
    protected DocumentoComercial documentoAsociado;

    public OperacionDeEgreso() {
        this.items = new ArrayList<>();
    }

    public void agregarItem(Item nuevoItem){
        if(!this.operacionCerrada){
            this.items.add(nuevoItem);
        }
    }

    public double calcularValor(){
        double valorCalculado = 0;
        if(this.operacionCerrada){
            valorCalculado = this.valor;
        } else {
            valorCalculado = this.items.stream().mapToDouble(item -> item.getPrecio()).sum();
        }

        return valorCalculado;
    }

    public List<String> getNombreItems() {
        List<String> nombres = this.items.stream().map(item -> item.getNombre()).collect(Collectors.toList());
        return nombres;
    }

    public boolean isOperacionCerrada() {
        return operacionCerrada;
    }

    public abstract void cerrarOperacion();

    public DocumentoComercial getDocumentoAsociado() {
        return documentoAsociado;
    }
}
