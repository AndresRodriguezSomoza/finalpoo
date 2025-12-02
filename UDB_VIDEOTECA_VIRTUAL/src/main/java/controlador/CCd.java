package controlador;

import config.conexionmysql;
import modelos.EntidadCd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

public class CCd {
    
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public ArrayList<EntidadCd> ListarTodos() {
        ArrayList<EntidadCd> lista = new ArrayList<>();
        
        try {
            conn = conexionmysql.obtenerConexion();
            String sentencia = "select * from cd";
            ps = conn.prepareStatement(sentencia);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                EntidadCd objEntidad = new EntidadCd();
                objEntidad.setId(rs.getInt("id"));
                objEntidad.setCdidentificacion(rs.getString("cdidentificacion"));
                objEntidad.setStock(rs.getInt("stock"));
                objEntidad.setTitulo(rs.getString("titulo"));
                objEntidad.setArtista(rs.getString("artista"));
                objEntidad.setProductor(rs.getString("productor"));
                objEntidad.setCompositor(rs.getString("compositor"));
                objEntidad.setDiscografia(rs.getString("discografia"));
                objEntidad.setYear(rs.getString("year"));
                objEntidad.setGenero(rs.getString("genero"));
                objEntidad.setIdioma(rs.getString("idioma"));
                objEntidad.setPais(rs.getString("pais"));
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
    
    public int registrar(EntidadCd obj) {
        int result = 0;
        
        try {
            conn = conexionmysql.obtenerConexion();
            String sentencia = "INSERT INTO cd(cdidentificacion,stock,titulo,artista,productor,compositor,discografia,year,genero,idioma,pais) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            Random r = new Random();
            int max = 99999, min = 10000;
            int number = r.nextInt(max - min + 1) + min;
            
            String codCD = "CD" + number;
            ps = conn.prepareStatement(sentencia);
            ps.setString(1, codCD);
            ps.setInt(2, obj.getStock());
            ps.setString(3, obj.getTitulo());
            ps.setString(4, obj.getArtista());
            ps.setString(5, obj.getProductor());
            ps.setString(6, obj.getCompositor());
            ps.setString(7, obj.getDiscografia());
            ps.setString(8, obj.getYear());
            ps.setString(9, obj.getGenero());
            ps.setString(10, obj.getIdioma());
            ps.setString(11, obj.getPais());
            
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
            String sentencia = "DELETE FROM cd WHERE id = ?";
            
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
    
    public int editar(EntidadCd obj) {
        int result = 0;
        
        try {
            conn = conexionmysql.obtenerConexion();
            String sentencia = "UPDATE cd SET stock=?, titulo=?, artista=?, productor=?, compositor=?, discografia=?, year=?, genero=?, idioma=?, pais=? "
                    + "WHERE id=?";
            
            ps = conn.prepareStatement(sentencia);
            ps.setInt(1, obj.getStock());
            ps.setString(2, obj.getTitulo());
            ps.setString(3, obj.getArtista());
            ps.setString(4, obj.getProductor());
            ps.setString(5, obj.getCompositor());
            ps.setString(6, obj.getDiscografia());
            ps.setString(7, obj.getYear());
            ps.setString(8, obj.getGenero());
            ps.setString(9, obj.getIdioma());
            ps.setString(10, obj.getPais());
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
    
    public EntidadCd buscarPorId(int id) {
        EntidadCd objEntidad = null;
        
        try {
            conn = conexionmysql.obtenerConexion();
            String sentencia = "select * from cd where id = ?";
            ps = conn.prepareStatement(sentencia);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                objEntidad = new EntidadCd();
                objEntidad.setId(rs.getInt("id"));
                objEntidad.setCdidentificacion(rs.getString("cdidentificacion"));
                objEntidad.setStock(rs.getInt("stock"));
                objEntidad.setTitulo(rs.getString("titulo"));
                objEntidad.setArtista(rs.getString("artista"));
                objEntidad.setProductor(rs.getString("productor"));
                objEntidad.setCompositor(rs.getString("compositor"));
                objEntidad.setDiscografia(rs.getString("discografia"));
                objEntidad.setYear(rs.getString("year"));
                objEntidad.setGenero(rs.getString("genero"));
                objEntidad.setIdioma(rs.getString("idioma"));
                objEntidad.setPais(rs.getString("pais"));
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