package modelos;

import config.conexionmysql;
import java.sql.*;

public class UsuarioDAO {

    public boolean registrarUsuario(Usuario usuario) {
        System.out.println("🚀 [DAO] Iniciando registro de usuario: " + usuario.getEmail());
        System.out.println("📋 [DAO] Datos recibidos:");
        System.out.println("   👤 Nombre: " + usuario.getNombre());
        System.out.println("   📧 Email: " + usuario.getEmail());
        System.out.println("   🔑 Contraseña: " + (usuario.getContrasena() != null ? "[PROTEGIDA]" : "NULL"));
        System.out.println("   🏷️ Tipo: " + usuario.getTipoUsuario());

        String sql = "INSERT INTO Usuarios (Nombre, Email, Contrasena, TipoUsuario) VALUES (?, ?, ?, ?)";
        System.out.println("📝 [DAO] SQL: " + sql);

        try (Connection conn = conexionmysql.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            System.out.println("✅ [DAO] Conexión y PreparedStatement creados");

            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getContrasena());
            stmt.setString(4, usuario.getTipoUsuario());

            System.out.println("🔄 [DAO] Ejecutando executeUpdate...");
            int filas = stmt.executeUpdate();
            System.out.println("📊 [DAO] Filas afectadas: " + filas);

            boolean resultado = filas > 0;
            if (resultado) {
                System.out.println("🎉 [DAO] Usuario registrado EXITOSAMENTE");
            } else {
                System.out.println("⚠️ [DAO] No se insertó ningún registro");
            }

            return resultado;

        } catch (SQLException e) {
            System.err.println("💥 [DAO] Error SQL en registrarUsuario:");
            System.err.println("💥 SQL State: " + e.getSQLState());
            System.err.println("💥 Error Code: " + e.getErrorCode());
            System.err.println("💥 Mensaje: " + e.getMessage());
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            System.err.println("💥 [DAO] Error inesperado en registrarUsuario:");
            e.printStackTrace();
            return false;
        }
    }

    public boolean existeEmail(String email) {
        System.out.println("🔍 [DAO] Verificando si email existe: " + email);

        String sql = "SELECT Id FROM Usuarios WHERE Email = ?";
        System.out.println("📝 [DAO] SQL: " + sql);

        try (Connection conn = conexionmysql.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            System.out.println("✅ [DAO] Conexión establecida para existeEmail");
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();
            boolean existe = rs.next();
            
            System.out.println("🔍 [DAO] Email existe: " + existe);
            return existe;

        } catch (SQLException e) {
            System.err.println("💥 [DAO] Error SQL en existeEmail:");
            System.err.println("💥 SQL State: " + e.getSQLState());
            System.err.println("💥 Error Code: " + e.getErrorCode());
            System.err.println("💥 Mensaje: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public Usuario autenticarUsuario(String email, String contrasena) {
        System.out.println("🔐 [DAO] Autenticando usuario: " + email);

        String sql = "SELECT * FROM Usuarios WHERE Email = ? AND Contrasena = ?";
        Usuario usuario = null;

        try (Connection conn = conexionmysql.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, contrasena);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("Id"));
                usuario.setNombre(rs.getString("Nombre"));
                usuario.setEmail(rs.getString("Email"));
                usuario.setContrasena(rs.getString("Contrasena"));
                usuario.setTipoUsuario(rs.getString("TipoUsuario"));
                System.out.println("✅ [DAO] Usuario autenticado: " + usuario.getNombre());
            } else {
                System.out.println("❌ [DAO] Autenticación fallida para: " + email);
            }

        } catch (SQLException e) {
            System.err.println("💥 [DAO] Error en autenticarUsuario:");
            e.printStackTrace();
        }

        return usuario;
    }
}