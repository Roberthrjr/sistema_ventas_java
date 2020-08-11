
package modelo;

import java.util.List;

public interface CRUD {
    //se declara los metodos que se utilizan en un mantenimiento
    public List listar();
    public int add(Object[] o);
    public int actualizar(Object[] o);
    public void eliminar(int id);
}
