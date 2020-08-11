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
public class VendedorDAO {
    PreparedStatement ps;
    ResultSet rs;
    
    Conexion acceso = new Conexion();
    Connection con;
//LOGIN DE VENDEDOR
    public EntidadVendedor ValidarVendedor(String dni, String user){
        EntidadVendedor ev = new EntidadVendedor();
        String sql="select * from vendedor where Dni=? and User=?";
        try {
            con= acceso.Conectar();
            ps= con.prepareStatement(sql);
            //colocar las consultas sql dentro de los parametros que nos envia
            ps.setString(1, dni);
            ps.setString(2, user);
            rs=ps.executeQuery();
            while(rs.next()){
                ev.setId(rs.getInt(1));
                ev.setDni(rs.getString(2));
                ev.setNom(rs.getString(3));
                ev.setTel(rs.getString(4));
                ev.setEstado(rs.getString(5));
                ev.setUser(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return ev;
    }
    
     public EntidadVendedor listarVendedorId(String dni) {
        EntidadVendedor v=new EntidadVendedor();
        String sql = "select * from vendedor where Dni=" + dni;
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                v.setId(rs.getInt(1));
                v.setDni(rs.getString(2));
                v.setNom(rs.getString(3));
                v.setTel(rs.getString(4));
                v.setEstado(rs.getString(5));
                v.setUser(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return v;
    }
    //********CRUD - Principal**************

    public List listarVendedor() {
        String sql = "select * from vendedor";
        List<EntidadVendedor> listaVendedor = new ArrayList<>();
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                EntidadVendedor ven = new EntidadVendedor();
                ven.setId(rs.getInt(1));
                ven.setDni(rs.getString(2));
                ven.setNom(rs.getString(3));
                ven.setTel(rs.getString(4));
                ven.setEstado(rs.getString(5));
                ven.setUser(rs.getString(6));
                listaVendedor.add(ven);
            }
        } catch (Exception e) {
        }
        return listaVendedor;
    }

    public int agregar(EntidadVendedor v) {
        int r=0;
        String sql = "insert into vendedor(Dni,Nombres,Telefono,Estado,User)values(?,?,?,?,?)";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getDni());
            ps.setString(2, v.getNom());
            ps.setString(3, v.getTel());
            ps.setString(4, v.getEstado());
            ps.setString(5, v.getUser());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public int actualizar(EntidadVendedor v) {
        int r=0;
        String sql = "update vendedor set Dni=?, Nombres=?,Telefono=?,Estado=? Where IdVendedor=?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getDni());
            ps.setString(2, v.getNom());
            ps.setString(3, v.getTel());
            ps.setString(4, v.getEstado());
            ps.setInt(5, v.getId());
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
        } catch (Exception e) {
            System.err.println("" + e);
        }
        return r;
    }

    public int delete(int id) {
        int r=0;
        String sql = "delete from vendedor where IdVendedor=?";
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
