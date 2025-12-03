package controlador;

import config.conexionmysql;
import modelos.EntidadPatentes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class CPatentes {
    
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public ArrayList<EntidadPatentes> ListarTodos() {
        ArrayList<EntidadPatentes> lista = new ArrayList<>();
        
        try {
            conn = conexionmysql.obtenerConexion();
            String sentencia = "select * from patentes";
            ps = conn.prepareStatement(sentencia);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                EntidadPatentes objEntidad = new EntidadPatentes();
                objEntidad.setId(rs.getInt("id"));
                objEntidad.setCdidentificacion(rs.getString("cdidentificacion"));
                objEntidad.setTitulo(rs.getString("titulo"));
                objEntidad.setInventor(rs.getString("inventor"));
                objEntidad.setTitular(rs.getString("titular"));
                objEntidad.setFecha_registro(rs.getString("fecha_registro"));
                objEntidad.setFecha_vencimiento(rs.getString("fecha_vencimiento"));
                objEntidad.setPais(rs.getString("pais"));
                objEntidad.setPatente(rs.getString("patente"));
                objEntidad.setEstado(rs.getString("estado"));
                objEntidad.setExtension_regional(rs.getString("extension_regional"));
                objEntidad.setCampo_tecnologico(rs.getString("campo_tecnologico"));
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
    
    public int registrar(EntidadPatentes obj) {
        int result = 0;
        
        try {
            conn = conexionmysql.obtenerConexion();
            String sentencia = "INSERT INTO patentes(cdidentificacion,titulo,inventor,titular,fecha_registro,fecha_vencimiento,pais,patente,estado,extension_regional,campo_tecnologico) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            Random r = new Random();
            int max = 99999, min = 10000;
            int number = r.nextInt(max - min + 1) + min;
            
            String codPAT = "PAT" + number;
            
            LocalDate fecha_vencimiento = LocalDate.parse(obj.getFecha_registro());
            LocalDate year_deadline = fecha_vencimiento.plusYears(20);
            final DateTimeFormatter vencimiento = DateTimeFormatter.ofPattern("yyyy/MM/dd", Locale.ENGLISH);
            String stringdeadline = vencimiento.format(year_deadline);
            
            ps = conn.prepareStatement(sentencia);
            ps.setString(1, codPAT);
            ps.setString(2, obj.getTitulo());
            ps.setString(3, obj.getInventor());
            ps.setString(4, obj.getTitular());
            ps.setString(5, obj.getFecha_registro());
            ps.setString(6, stringdeadline);
            ps.setString(7, obj.getPais());
            ps.setString(8, obj.getPatente());
            ps.setString(9, obj.getEstado());
            ps.setString(10, obj.getExtension_regional());
            ps.setString(11, obj.getCampo_tecnologico());
            
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
            String sentencia = "DELETE FROM patentes WHERE id = ?";
            
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
    
    public int editar(EntidadPatentes obj) {
        int result = 0;
        
        try {
            conn = conexionmysql.obtenerConexion();
            String sentencia = "UPDATE patentes SET titulo=?, inventor=?, titular=?, fecha_registro=?, fecha_vencimiento=?, pais=?, patente=?, estado=?, extension_regional=?, campo_tecnologico=? "
                    + "WHERE id=?";
            
            LocalDate fecha_vencimiento = LocalDate.parse(obj.getFecha_registro());
            LocalDate year_deadline = fecha_vencimiento.plusYears(20);
            final DateTimeFormatter vencimiento = DateTimeFormatter.ofPattern("yyyy/MM/dd", Locale.ENGLISH);
            String stringdeadline = vencimiento.format(year_deadline);
            
            ps = conn.prepareStatement(sentencia);
            ps.setString(1, obj.getTitulo());
            ps.setString(2, obj.getInventor());
            ps.setString(3, obj.getTitular());
            ps.setString(4, obj.getFecha_registro());
            ps.setString(5, stringdeadline);
            ps.setString(6, obj.getPais());
            ps.setString(7, obj.getPatente());
            ps.setString(8, obj.getEstado());
            ps.setString(9, obj.getExtension_regional());
            ps.setString(10, obj.getCampo_tecnologico());
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
    
    public EntidadPatentes buscarPorId(int id) {
        EntidadPatentes objEntidad = null;
        
        try {
            conn = conexionmysql.obtenerConexion();
            String sentencia = "select * from patentes where id = ?";
            ps = conn.prepareStatement(sentencia);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                objEntidad = new EntidadPatentes();
                objEntidad.setId(rs.getInt("id"));
                objEntidad.setCdidentificacion(rs.getString("cdidentificacion"));
                objEntidad.setTitulo(rs.getString("titulo"));
                objEntidad.setInventor(rs.getString("inventor"));
                objEntidad.setTitular(rs.getString("titular"));
                objEntidad.setFecha_registro(rs.getString("fecha_registro"));
                objEntidad.setFecha_vencimiento(rs.getString("fecha_vencimiento"));
                objEntidad.setPais(rs.getString("pais"));
                objEntidad.setPatente(rs.getString("patente"));
                objEntidad.setEstado(rs.getString("estado"));
                objEntidad.setExtension_regional(rs.getString("extension_regional"));
                objEntidad.setCampo_tecnologico(rs.getString("campo_tecnologico"));
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