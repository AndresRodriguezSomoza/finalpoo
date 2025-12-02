package controlador;

import config.conexionmysql;
import modelos.EntidadObra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

public class CObra {
    
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public ArrayList<EntidadObra> ListarTodos() {
        ArrayList<EntidadObra> lista = new ArrayList<>();
        
        try {
            conn = conexionmysql.obtenerConexion();
            String sentencia = "select * from obra";
            ps = conn.prepareStatement(sentencia);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                EntidadObra objEntidad = new EntidadObra();
                objEntidad.setId(rs.getInt("id"));
                objEntidad.setCdidentificacion(rs.getString("cdidentificacion"));
                objEntidad.setIsbn(rs.getString("isbn"));
                objEntidad.setStock(rs.getInt("stock"));
                objEntidad.setTitulo(rs.getString("titulo"));
                objEntidad.setAutor(rs.getString("autor"));
                objEntidad.setEditorial(rs.getString("editorial"));
                objEntidad.setYear(rs.getString("year"));
                objEntidad.setGenero(rs.getString("genero"));
                objEntidad.setNumpag(rs.getInt("numpag"));
                objEntidad.setSubgenero(rs.getString("subgenero"));
                objEntidad.setTema(rs.getString("tema"));
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
    
    public int registrar(EntidadObra obj) {
        int result = 0;
        
        try {
            conn = conexionmysql.obtenerConexion();
            String sentencia = "INSERT INTO obra(cdidentificacion,isbn,stock,titulo,autor,editorial,year,genero,numpag,subgenero,tema) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            Random r = new Random();
            int max = 99999, min = 10000;
            int number = r.nextInt(max - min + 1) + min;
            
            String codOBRA = "OBR" + number;
            ps = conn.prepareStatement(sentencia);
            ps.setString(1, codOBRA);
            ps.setString(2, obj.getIsbn());
            ps.setInt(3, obj.getStock());
            ps.setString(4, obj.getTitulo());
            ps.setString(5, obj.getAutor());
            ps.setString(6, obj.getEditorial());
            ps.setString(7, obj.getYear());
            ps.setString(8, obj.getGenero());
            ps.setInt(9, obj.getNumpag());
            ps.setString(10, obj.getSubgenero());
            ps.setString(11, obj.getTema());
            
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
            String sentencia = "DELETE FROM obra WHERE id = ?";
            
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
    
    public int editar(EntidadObra obj) {
        int result = 0;
        
        try {
            conn = conexionmysql.obtenerConexion();
            String sentencia = "UPDATE obra SET isbn=?, stock=?, titulo=?, autor=?, editorial=?, year=?, genero=?, numpag=?, subgenero=?, tema=? "
                    + "WHERE id=?";
            
            ps = conn.prepareStatement(sentencia);
            ps.setString(1, obj.getIsbn());
            ps.setInt(2, obj.getStock());
            ps.setString(3, obj.getTitulo());
            ps.setString(4, obj.getAutor());
            ps.setString(5, obj.getEditorial());
            ps.setString(6, obj.getYear());
            ps.setString(7, obj.getGenero());
            ps.setInt(8, obj.getNumpag());
            ps.setString(9, obj.getSubgenero());
            ps.setString(10, obj.getTema());
            ps.setInt(11, obj.getId());
            
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
    
    public EntidadObra buscarPorId(int id) {
        EntidadObra objEntidad = null;
        
        try {
            conn = conexionmysql.obtenerConexion();
            String sentencia = "select * from obra where id = ?";
            ps = conn.prepareStatement(sentencia);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                objEntidad = new EntidadObra();
                objEntidad.setId(rs.getInt("id"));
                objEntidad.setCdidentificacion(rs.getString("cdidentificacion"));
                objEntidad.setIsbn(rs.getString("isbn"));
                objEntidad.setStock(rs.getInt("stock"));
                objEntidad.setTitulo(rs.getString("titulo"));
                objEntidad.setAutor(rs.getString("autor"));
                objEntidad.setEditorial(rs.getString("editorial"));
                objEntidad.setYear(rs.getString("year"));
                objEntidad.setGenero(rs.getString("genero"));
                objEntidad.setNumpag(rs.getInt("numpag"));
                objEntidad.setSubgenero(rs.getString("subgenero"));
                objEntidad.setTema(rs.getString("tema"));
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
