package modelo;

import util.conexionBD;
import java.sql.*;

public class UsuarioDAO {

    // Asegúrate de que este método exista con ESTE nombre exacto
    public boolean existeUsuario(String usuario) {
        System.out.println("🔍 [DAO] Verificando si usuario existe: " + usuario);

        String sql = "SELECT id FROM usuarios WHERE usuario = ?";

        try (Connection conn = conexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario);
            ResultSet rs = stmt.executeQuery();

            boolean existe = rs.next();
            System.out.println("🔍 [DAO] Usuario existe: " + existe);
            return existe;

        } catch (SQLException e) {
            System.out.println("💥 Error en existeUsuario:");
            e.printStackTrace();
            return false;
        }
    }

    // Asegúrate de que este método exista con ESTE nombre exacto
    public boolean registrarUsuario(Usuario usuario) {
        System.out.println("🚀 [DAO] Registrando usuario: " + usuario.getUsuario());

        String sql = "INSERT INTO usuarios (identificador, nombre, usuario, contrasena, tipo, tiene_mora) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = conexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getIdentificador());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getUsuario());
            stmt.setString(4, usuario.getContrasena());
            stmt.setString(5, usuario.getTipo());
            stmt.setBoolean(6, false); // Nuevos usuarios no tienen mora

            int filas = stmt.executeUpdate();
            System.out.println("📊 [DAO] Filas afectadas: " + filas);
            return filas > 0;

        } catch (SQLException e) {
            System.out.println("💥 Error en registrarUsuario:");
            e.printStackTrace();
            return false;
        }
    }

    public Usuario autenticarUsuario(String usuario, String contrasena) {
        // ... tu código existente para login
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contrasena = ?";
        Usuario userAutenticado = null;

        try (Connection conn = conexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario);
            stmt.setString(2, contrasena);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                userAutenticado = new Usuario();
                userAutenticado.setId(rs.getInt("id"));
                userAutenticado.setIdentificador(rs.getString("identificador"));
                userAutenticado.setNombre(rs.getString("nombre"));
                userAutenticado.setUsuario(rs.getString("usuario"));
                userAutenticado.setContrasena(rs.getString("contrasena"));
                userAutenticado.setTipo(rs.getString("tipo"));
                userAutenticado.setTieneMora(rs.getBoolean("tiene_mora"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userAutenticado;
    }
}