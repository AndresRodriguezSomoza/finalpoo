package controlador;

import config.conexionmysql;
import modelos.EntidadRevista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

public class CRevista {
    
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public ArrayList<EntidadRevista> ListarTodos() {
        ArrayList<EntidadRevista> lista = new ArrayList<>();
        
        try {
            conn = conexionmysql.obtenerConexion();
            String sentencia = "select * from revista";
            ps = conn.prepareStatement(sentencia);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                EntidadRevista objEntidad = new EntidadRevista();
                objEntidad.setId(rs.getInt("id"));
                objEntidad.setCdidentificacion(rs.getString("cdidentificacion"));
                objEntidad.setIssn(rs.getString("issn"));
                objEntidad.setStock(rs.getInt("stock"));
                objEntidad.setTitulo(rs.getString("titulo"));
                objEntidad.setEditorial(rs.getString("editorial"));
                objEntidad.setEdicion(rs.getInt("edicion"));
                objEntidad.setYear(rs.getString("year"));
                objEntidad.setPeriocidad(rs.getString("periocidad"));
                objEntidad.setNumpag(rs.getInt("numpag"));
                objEntidad.setEstado(rs.getString("estado"));
                lista.add(objEntidad);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        return lista;
    }
    
    public int registrar(EntidadRevista obj) {
        int result = 0;
        
        try {
            conn = conexionmysql.obtenerConexion();
            String sentencia = "INSERT INTO revista(cdidentificacion,issn,stock,titulo,editorial,edicion,year,periocidad,numpag,estado) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?)";
            Random r = new Random();
            int max = 99999, min = 10000;
            int number = r.nextInt(max - min + 1) + min;
            
            String codREV = "REV" + number;
            ps = conn.prepareStatement(sentencia);
            ps.setString(1, codREV);
            ps.setString(2, obj.getIssn());
            ps.setInt(3, obj.getStock());
            ps.setString(4, obj.getTitulo());
            ps.setString(5, obj.getEditorial());
            ps.setInt(6, obj.getEdicion());
            ps.setString(7, obj.getYear());
            ps.setString(8, obj.getPeriocidad());
            ps.setInt(9, obj.getNumpag());
            ps.setString(10, obj.getEstado());
            
            result = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
                if (ps != null) ps.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        return result;
    }
    
    public int eliminar(int id) {
        int result = 0;
        
        try {
            conn = conexionmysql.obtenerConexion();
            String sentencia = "DELETE FROM revista WHERE id = ?";
            
            ps = conn.prepareStatement(sentencia);
            ps.setInt(1, id);
            result = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
                if (ps != null) ps.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        return result;
    }
    
    public int editar(EntidadRevista obj) {
        int result = 0;
        
        try {
            conn = conexionmysql.obtenerConexion();
            String sentencia = "UPDATE revista SET issn=?, stock=?, titulo=?, editorial=?, edicion=?, year=?, periocidad=?, numpag=?, estado=? "
                    + "WHERE id=?";
            
            ps = conn.prepareStatement(sentencia);
            ps.setString(1, obj.getIssn());
            ps.setInt(2, obj.getStock());
            ps.setString(3, obj.getTitulo());
            ps.setString(4, obj.getEditorial());
            ps.setInt(5, obj.getEdicion());
            ps.setString(6, obj.getYear());
            ps.setString(7, obj.getPeriocidad());
            ps.setInt(8, obj.getNumpag());
            ps.setString(9, obj.getEstado());
            ps.setInt(10, obj.getId());
            
            result = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
                if (ps != null) ps.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        return result;
    }
    
    public EntidadRevista buscarPorId(int id) {
        EntidadRevista objEntidad = null;
        
        try {
            conn = conexionmysql.obtenerConexion();
            String sentencia = "select * from revista where id = ?";
            ps = conn.prepareStatement(sentencia);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                objEntidad = new EntidadRevista();
                objEntidad.setId(rs.getInt("id"));
                objEntidad.setCdidentificacion(rs.getString("cdidentificacion"));
                objEntidad.setIssn(rs.getString("issn"));
                objEntidad.setStock(rs.getInt("stock"));
                objEntidad.setTitulo(rs.getString("titulo"));
                objEntidad.setEditorial(rs.getString("editorial"));
                objEntidad.setEdicion(rs.getInt("edicion"));
                objEntidad.setYear(rs.getString("year"));
                objEntidad.setPeriocidad(rs.getString("periocidad"));
                objEntidad.setNumpag(rs.getInt("numpag"));
                objEntidad.setEstado(rs.getString("estado"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        return objEntidad;
    }
}