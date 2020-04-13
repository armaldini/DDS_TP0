package tests;
import org.junit.Assert;
import org.junit.Test;
import tp0.*;

public class Tester {

    @Test
    public void crearItem(){
        Item teclado = new Articulo("Masterkeys Pro S", 5999);
        Assert.assertEquals("Masterkeys Pro S", teclado.getNombre());
    }

    @Test
    public void agregarItems(){
        Item teclado = new Articulo("Masterkeys Pro S", 5999);
        Item mouse = new Articulo("Logitech M280", 699);
        Compra compra = new Compra();
        compra.agregarItem(teclado);
        compra.agregarItem(mouse);

        Assert.assertArrayEquals(compra.getNombreItems().toArray(), new String[]{"Masterkeys Pro S", "Logitech M280"});
    }

    @Test
    public void calcularValor(){
        Articulo lampara = new Articulo("Lampara de escritorio", 1200);
        Articulo cd = new Articulo("CD virgen", 34.56);
        Compra compra = new Compra();
        compra.agregarItem(lampara);
        compra.agregarItem(cd);

        Assert.assertEquals(1234.56, compra.calcularValor(), 0);
    }

    @Test
    public void calcularValorOperacionVacia(){
        Compra compra = new Compra();

        Assert.assertEquals(0, compra.calcularValor(), 0);
    }

    @Test
    public void cambiarPrecio(){
        Articulo teclado = new Articulo("Masterkeys Pro S", 5999);
        Articulo mouse = new Articulo("Logitech M280", 699);
        Compra compra = new Compra();
        compra.agregarItem(teclado);
        compra.agregarItem(mouse);

        teclado.cambiarPrecio(5000);
        Assert.assertEquals(5699, compra.calcularValor(), 0);
    }

    @Test
    public void cerrarOperacion(){
        Articulo monitor = new Articulo("Samsung C27F390", 9876.54);
        Compra compra = new Compra();
        compra.agregarItem(monitor);
        compra.cerrarOperacion();

        Assert.assertEquals(true, compra.isOperacionCerrada());
    }

    @Test
    public void cambiarPrecioOperacionCerrada(){
        Articulo teclado = new Articulo("Masterkeys Pro S", 5000);
        Articulo mouse = new Articulo("Logitech M280", 699);
        Compra compra = new Compra();
        compra.agregarItem(teclado);
        compra.agregarItem(mouse);
        compra.cerrarOperacion();
        teclado.cambiarPrecio(5678);
        Assert.assertEquals(5699, compra.calcularValor(), 0);
    }

    @Test
    public void getRemitoOperacionSinServicios() throws RemitoConServiciosException {
        Articulo monitor = new Articulo("Samsung C27F390", 9876.54);
        Articulo cd = new Articulo("CD virgen", 34.56);
        Compra compra = new Compra();
        compra.agregarItem(monitor);
        compra.agregarItem(cd);
        compra.generarRemito();
    }

    @Test(expected = RemitoConServiciosException.class)
    public void getRemitoOperacionConServicios() throws RemitoConServiciosException {
        Servicio internet = new Servicio("Claro 50mb", 500);
        Articulo mouse = new Articulo("Logitech M280", 699);
        Compra compra = new Compra();
        compra.agregarItem(internet);
        compra.agregarItem(mouse);
        compra.generarRemito();
    }

}
