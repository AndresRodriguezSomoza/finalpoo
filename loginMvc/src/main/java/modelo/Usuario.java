package modelo;

public class Usuario {
    private int id;
    private String identificador;
    private String nombre;
    private String usuario;
    private String contrasena;
    private String tipo;
    private boolean tieneMora;
    
    // Constructores
    public Usuario() {}
    
    public Usuario(String identificador, String nombre, String usuario, String contrasena, String tipo) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.tipo = tipo;
        this.tieneMora = false;
    }
    
    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getIdentificador() { return identificador; }
    public void setIdentificador(String identificador) { this.identificador = identificador; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    
    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    
    public boolean isTieneMora() { return tieneMora; }
    public void setTieneMora(boolean tieneMora) { this.tieneMora = tieneMora; }
}