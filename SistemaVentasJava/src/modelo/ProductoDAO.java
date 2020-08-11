/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rios
 */
public class ProductoDAO {
    int r;
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion acceso = new Conexion();
    EntidadProducto pro = new EntidadProducto();
    
   public int actualizarStock(int cant, int idp){
       String sql="update producto set Stock=? where idProducto=?";
       try {
           con=acceso.Conectar();
           ps=con.prepareStatement(sql);
           ps.setInt(1, cant);
           ps.setInt(2, idp);
           ps.executeUpdate();
       } catch (Exception e) {
       }
       return r;
   }
    public EntidadProducto listarID(int id){
        EntidadProducto p=new EntidadProducto();
        String sql="select * from producto where IdProducto=?";
        try {
            con=acceso.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPre(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return p;
    }
   
    //*************MANTENIMIENTO CRUD**************
    public List listarProducto() {
        String sql = "select * from producto";
        List<EntidadProducto> listaprod = new ArrayList<>();
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                EntidadProducto p = new EntidadProducto();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPre(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
                listaprod.add(p);
            }
        } catch (Exception e) {
        }
        return listaprod;
    }

    public int agregar(EntidadProducto p) {
        String sql = "insert into producto(Nombres,Precio,Stock,Estado)values(?,?,?,?)";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setDouble(2, p.getPre());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

//    public int actualizarStock(int cant, int id) {
//        String sql = "update producto set Stock=? where IdProducto=?";
//        try {
//            con = acceso.Conectar();
//            ps = con.prepareStatement(sql);          
//            ps.setInt(1, cant);           
//            ps.setInt(2, id);
//            ps.executeUpdate();
//        } catch (Exception e) {
//        }
//        return r;
//    }
    public int actualizar(EntidadProducto p) {
        String sql = "update producto set Nombres=?,Precio=?,Stock=?,Estado=? where IdProducto=?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setDouble(2, p.getPre());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getEstado());
            ps.setInt(5, p.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public int delete(int id) {
        String sql = "delete from producto where IdProducto=?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }    
}
