/**
 * Clase de libro.
 */
public class Libro
{
    int id;
    String titulo;
    String autor;
    Genero genero;
    int    edicion;
    Libro siguiente;

    /**
     * Constructor
     */
    public Libro( int id, String titulo, String autor, Genero genero, int edicion)
    {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.edicion = edicion;
        this.siguiente = null;
    }

    public String toString(){
        return titulo+", "+autor+", "+ genero +", "+ edicion + ".";
    }

    /**
     * Guarda libro en el siguiente
     * @param valor -> nuevo libro
     */
    public void ponLibro(Libro valor){
        if (this.siguiente != null){
            this.siguiente.ponLibro(valor);
        } else {
            this.siguiente = valor;
        }
    }

    /**
     * Quita libro
     * @param id -> id libro a eliminar
     * @return -> Libro (si lo encuentra) o null (si no existe)
     */
    public Libro quitaLibro(int id){
        if (this.siguiente != null){
            if (this.siguiente.getId() != id){
                this.siguiente.quitaLibro(id);
            } else {
                Libro auxLibro= this.siguiente;
                if (this.siguiente.siguiente != null){
                    this.siguiente= this.siguiente.siguiente;
                } else {
                    this.siguiente= null;
                }
                return auxLibro;
            }
        } else {
            return null;
        }
        return null;
    }

    /**
     * BuscarLibro
     * @param titulo -> libro buscado
     * @return ->id del libro (si lo encuentra) o -1 (si no esta)
     */
    public int buscarLibro(String titulo){
        if (this.siguiente != null){
            if (!this.siguiente.getTitulo().equals(titulo)){
                this.siguiente.buscarLibro(titulo);
            } else {
                return this.siguiente.getId();
            }
        } else {
            return -1;
        }
        return -1;
    }

    /**
     * mostrar libros
     */
    public void mostrarLibros(){
        if (this.siguiente != null){
            System.out.println(this.siguiente.toString());
            this.siguiente.mostrarLibros();
        }
    }

    /**
     * Id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Titulo
     * @return tirulo
     */
    public String getTitulo() {
        return titulo;
    }

}