package tp0;
import java.time.LocalDateTime;
import java.util.List;

public abstract class DocumentoComercial{
    protected char letra;
    protected LocalDateTime fecha;
    protected String razonSocialEmisor;
    protected List<String> items;
}
