public class Nota {

    private String idEstudiante;
    private String nombreMateria;
    private double nota;
    private int creditos;

    public Nota() {
    }

    public Nota(String idEstudiante, String nombreMateria, double nota, int creditos) {
        this.creditos = creditos;
        this.idEstudiante = idEstudiante;
        this.nombreMateria = nombreMateria;
        this.nota = nota;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return idEstudiante + ";" + nombreMateria + ";" + nota + ";" + creditos+"_creditos";
    }
}
