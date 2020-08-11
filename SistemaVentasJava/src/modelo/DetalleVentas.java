/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Rios
 */
public class DetalleVentas {
    int id;
    int idVentas;
    int idProducto;
    int cantidad;
    double preVenta;

    public DetalleVentas() {
    }

    public DetalleVentas(int id, int idVentas, int idProducto, int cantidad, double preVenta) {
        this.id = id;
        this.idVentas = idVentas;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.preVenta = preVenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPreVenta() {
        return preVenta;
    }

    public void setPreVenta(double preVenta) {
        this.preVenta = preVenta;
    }    
}
