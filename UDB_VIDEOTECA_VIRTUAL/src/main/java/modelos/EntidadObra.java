package modelos;

public class EntidadObra {
    int id;
    String cdidentificacion;
    String isbn;
    int stock;
    String titulo;
    String autor;
    String editorial;
    String year;
    String genero;
    int numpag;
    String subgenero;
    String tema;

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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNumpag() {
        return numpag;
    }

    public void setNumpag(int numpag) {
        this.numpag = numpag;
    }

    public String getSubgenero() {
        return subgenero;
    }

    public void setSubgenero(String subgenero) {
        this.subgenero = subgenero;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
}
