package modelos;

public class EntidadTesis {
    int id;
    String cdidentificacion;
    String isbn;
    String titulo;
    String autor;
    String director;
    String institucion;
    String year;
    String gradoacademico;
    int numpag;
    String calificacion;
    String idioma;

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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGradoacademico() {
        return gradoacademico;
    }

    public void setGradoacademico(String gradoacademico) {
        this.gradoacademico = gradoacademico;
    }

    public int getNumpag() {
        return numpag;
    }

    public void setNumpag(int numpag) {
        this.numpag = numpag;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
}
