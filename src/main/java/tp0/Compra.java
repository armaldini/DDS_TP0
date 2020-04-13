package tp0;
import java.util.List;
import java.util.stream.Collectors;

public class Compra extends OperacionDeEgreso{

    @Override
    public void cerrarOperacion() {
        this.valor = this.calcularValor();
        this.operacionCerrada = true;
    }

    public void generarRemito() throws RemitoConServiciosException{
        List<Item> serviciosComprados = this.items.stream().filter(item -> item instanceof Servicio).collect(Collectors.toList());
        if(serviciosComprados.size() == 0) {
            this.documentoAsociado = new Remito("PC Store", this.getNombreItems());
        } else {
            throw new RemitoConServiciosException();
        }
    }
}
