package modelos;

public class EntidadPatentes {
    int id;
    String cdidentificacion;
    String titulo;
    String inventor;
    String titular;
    String fecha_registro;
    String fecha_vencimiento;
    String pais;
    String patente;
    String estado;
    String extension_regional;
    String campo_tecnologico;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCdidentificacion() {
        return cdidentificacion;
    }

    public void setCdidentificacion(String cdidentificacion) {
        this.cdidentificacion = cdidentificacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInventor() {
        return inventor;
    }

    public void setInventor(String inventor) {
        this.inventor = inventor;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getExtension_regional() {
        return extension_regional;
    }

    public void setExtension_regional(String extension_regional) {
        this.extension_regional = extension_regional;
    }

    public String getCampo_tecnologico() {
        return campo_tecnologico;
    }

    public void setCampo_tecnologico(String campo_tecnologico) {
        this.campo_tecnologico = campo_tecnologico;
    }
}
