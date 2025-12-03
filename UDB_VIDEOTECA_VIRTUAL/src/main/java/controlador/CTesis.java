package controlador;

import config.conexionmysql;
import modelos.EntidadTesis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

public class CTesis {
    
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public ArrayList<EntidadTesis> ListarTodos() {
        ArrayList<EntidadTesis> lista = new ArrayList<>();
        
        try {
            conn = conexionmysql.obtenerConexion();
            String sentencia = "select * from tesis";
            ps = conn.prepareStatement(sentencia);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                EntidadTesis objEntidad = new EntidadTesis();
                objEntidad.setId(rs.getInt("id"));
                objEntidad.setCdidentificacion(rs.getString("cdidentificacion"));
                objEntidad.setIsbn(rs.getString("isbn"));
                objEntidad.setTitulo(rs.getString("titulo"));
                objEntidad.setAutor(rs.getString("autor"));
                objEntidad.setDirector(rs.getString("director"));
                objEntidad.setInstitucion(rs.getString("institucion"));
                objEntidad.setYear(rs.getString("year"));
                objEntidad.setGradoacademico(rs.getString("gradoacademico"));
                objEntidad.setNumpag(rs.getInt("numpag"));
                objEntidad.setCalificacion(rs.getString("calificacion"));
                objEntidad.setIdioma(rs.getString("idioma"));
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
    
    public int registrar(EntidadTesis obj) {
        int result = 0;
        
        try {
            conn = conexionmysql.obtenerConexion();
            String sentencia = "INSERT INTO tesis(cdidentificacion,isbn,titulo,autor,director,institucion,year,gradoacademico,numpag,calificacion,idioma) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            Random r = new Random();
            int max = 99999, min = 10000;
            int number = r.nextInt(max - min + 1) + min;
            
            String codTESIS = "TES" + number;
            ps = conn.prepareStatement(sentencia);
            ps.setString(1, codTESIS);
            ps.setString(2, obj.getIsbn());
            ps.setString(3, obj.getTitulo());
            ps.setString(4, obj.getAutor());
            ps.setString(5, obj.getDirector());
            ps.setString(6, obj.getInstitucion());
            ps.setString(7, obj.getYear());
            ps.setString(8, obj.getGradoacademico());
            ps.setInt(9, obj.getNumpag());
            ps.setString(10, obj.getCalificacion());
            ps.setString(11, obj.getIdioma());
            
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
            String sentencia = "DELETE FROM tesis WHERE id = ?";
            
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
    
    public int editar(EntidadTesis obj) {
        int result = 0;
        
        try {
            conn = conexionmysql.obtenerConexion();
            String sentencia = "UPDATE tesis SET isbn=?, titulo=?, autor=?, director=?, institucion=?, year=?, gradoacademico=?, numpag=?, calificacion=?, idioma=? "
                    + "WHERE id=?";
            
            ps = conn.prepareStatement(sentencia);
            ps.setString(1, obj.getIsbn());
            ps.setString(2, obj.getTitulo());
            ps.setString(3, obj.getAutor());
            ps.setString(4, obj.getDirector());
            ps.setString(5, obj.getInstitucion());
            ps.setString(6, obj.getYear());
            ps.setString(7, obj.getGradoacademico());
            ps.setInt(8, obj.getNumpag());
            ps.setString(9, obj.getCalificacion());
            ps.setString(10, obj.getIdioma());
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
    
    public EntidadTesis buscarPorId(int id) {
        EntidadTesis objEntidad = null;
        
        try {
            conn = conexionmysql.obtenerConexion();
            String sentencia = "select * from tesis where id = ?";
            ps = conn.prepareStatement(sentencia);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                objEntidad = new EntidadTesis();
                objEntidad.setId(rs.getInt("id"));
                objEntidad.setCdidentificacion(rs.getString("cdidentificacion"));
                objEntidad.setIsbn(rs.getString("isbn"));
                objEntidad.setTitulo(rs.getString("titulo"));
                objEntidad.setAutor(rs.getString("autor"));
                objEntidad.setDirector(rs.getString("director"));
                objEntidad.setInstitucion(rs.getString("institucion"));
                objEntidad.setYear(rs.getString("year"));
                objEntidad.setGradoacademico(rs.getString("gradoacademico"));
                objEntidad.setNumpag(rs.getInt("numpag"));
                objEntidad.setCalificacion(rs.getString("calificacion"));
                objEntidad.setIdioma(rs.getString("idioma"));
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