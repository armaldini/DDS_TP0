package tp0;

public class Articulo extends Item{
    public Articulo(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public void cambiarPrecio(double nuevoPrecio){
        this.precio = nuevoPrecio;
    }
}