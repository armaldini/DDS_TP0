package tp0;
import java.time.LocalDateTime;
import java.util.List;

public class Remito extends DocumentoComercial {
    public Remito(String emisor, List<String> items){
        this.letra = 'R';
        this.fecha = LocalDateTime.now();
        this.razonSocialEmisor = emisor;
        this.items = items;
    }
}
