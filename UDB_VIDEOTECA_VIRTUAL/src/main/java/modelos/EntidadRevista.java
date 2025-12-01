package modelos;

public class EntidadRevista {
    int id;
    String cdidentificacion;
    String issn;
    int stock;
    String titulo;
    String editorial;
    int edicion;
    String year;
    String periocidad;
    int numpag;
    String estado;

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

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPeriocidad() {
        return periocidad;
    }

    public void setPeriocidad(String periocidad) {
        this.periocidad = periocidad;
    }

    public int getNumpag() {
        return numpag;
    }

    public void setNumpag(int numpag) {
        this.numpag = numpag;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
