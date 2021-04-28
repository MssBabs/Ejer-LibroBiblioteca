import java.util.List;
import java.util.ArrayList;

/**
 * Lista de libro de una biblioteca
 */
public class ListaLibros {
    Libro primero;

    /**
     * Constructor
     */
    public ListaLibros() {
        this.primero = null;
    }

    /**
     * Incluye un nuevo libro en la lista
     * @param valor -> libro nuevo
     */
    public void pon(Libro valor){
        if (this.primero != null){
            this.primero.ponLibro(valor);
        } else {
            this.primero = valor;
        }
    }

    /**
     * Comprueba que la lista está vacia
     * @return ->True (si esta vacia) o False (si no lo esta)
     */
    public boolean estaVacia(){
        return ( this.primero == null );
    }

    /**
     * Quita un libro de la lista
     * @param id -> id libro devuelto
     * @return -> Libro (si lo encuentra) o null (si no existe)
     */
    public Libro quitar ( int id ) {
        if (this.primero != null){
            if (this.primero.getId() != id){
                this.primero.quitaLibro(id);
            } else {
                Libro auxLibro= this.primero;
                if (this.primero.siguiente != null){
                    this.primero= this.primero.siguiente;
                } else {
                    this.primero= null;
                }
                return auxLibro;
            }
        } else {
            return null;
        }
        System.out.println("No existe libro con id: "+ id);
        return null;
    }

    /**
     * Busca libro en la lista
     * @param titulo -> libro a buscar
     * @return -> id del libro (si lo encuentra) o -1 (si no esta)
     */
    public int buscarId ( String titulo ){
        if (this.primero != null){
            if (!this.primero.getTitulo().equals(titulo)){
                this.primero.buscarLibro(titulo);
            } else {
                return this.primero.getId();
            }
        } else {
            return -1;
        }
        System.out.println("No existe libro con titulo: "+ titulo);
        return -1;
    }

    /**
     * Muestra los libros almacenados
     */
    public void verCatalogo (){
        if (this.primero != null){
            System.out.println(this.primero.toString());
            this.primero.mostrarLibros();
        }
    }
}