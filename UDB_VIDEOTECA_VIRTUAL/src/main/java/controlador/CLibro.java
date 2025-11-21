package controlador;

import config.conexionmysql;
import modelos.EntidadLibro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

public class CLibro {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<EntidadLibro> ListarTodos() {
        ArrayList<EntidadLibro> lista = new ArrayList<>();

        try {
            conn = conexionmysql.obtenerConexion();
            String sentencia = "select * from libro";
            ps = conn.prepareStatement(sentencia);
            rs = ps.executeQuery();

            while (rs.next()) {
                EntidadLibro objEntidad = new EntidadLibro();
                objEntidad.setId(rs.getInt("id"));
                objEntidad.setCdidentificacion(rs.getString("cdidentificacion"));
                objEntidad.setStock(rs.getInt("stock"));
                objEntidad.setIsbn(rs.getString("isbn"));
                objEntidad.setTitulo(rs.getString("titulo"));
                objEntidad.setAutor(rs.getString("autor"));
                objEntidad.setEditorial(rs.getString("editorial"));
                objEntidad.setNumpag(rs.getInt("numpag"));
                objEntidad.setYear(rs.getString("year"));
                objEntidad.setCategoria(rs.getString("categoria"));
                objEntidad.setIdioma(rs.getString("idioma"));
                objEntidad.setFormato(rs.getString("formato"));
                lista.add(objEntidad);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception ex) {

            }
        }

        return lista;
    }

    public int registrar(EntidadLibro obj) {
        int result = 0;

        try {
            conn = conexionmysql.obtenerConexion();
            String sentencia = "INSERT INTO libro(cdidentificacion,stock,isbn,titulo,autor,editorial,numpag,year,categoria,idioma,formato) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            Random r = new Random();
            int max = 99999, min = 10000;

            int number = r.nextInt(max - min + 1) + min;

            String codLIB = "LIB" + number;
            ps = conn.prepareStatement(sentencia);
            ps.setString(1, codLIB);
            ps.setInt(2, obj.getStock());
            ps.setString(3, obj.getIsbn());
            ps.setString(4, obj.getTitulo());
            ps.setString(5, obj.getAutor());
            ps.setString(6, obj.getEditorial());
            ps.setInt(7, obj.getNumpag());
            ps.setString(8, obj.getYear());
            ps.setString(9, obj.getCategoria());
            ps.setString(10, obj.getIdioma());
            ps.setString(11, obj.getFormato());
            
            result = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception ex) {

            }
        }

        return result;
    }
}
