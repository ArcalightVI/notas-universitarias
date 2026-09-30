public class Promedio {

    private String idEstudiante;
    private String nombreEstudiante;
    private double promedio;
    private String estadoBeca; // "APLICA_BECA" o "NO_APLICA"

    public Promedio() {
    }

    public Promedio(String idEstudiante, String nombreEstudiante, double promedio, String estadoBeca) {
        this.idEstudiante = idEstudiante;
        this.nombreEstudiante = nombreEstudiante;
        this.promedio = promedio;
        this.estadoBeca = estadoBeca;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public String getEstadoBeca() {
        return estadoBeca;
    }

    public void setEstadoBeca(String estadoBeca) {
        this.estadoBeca = estadoBeca;
    }

    @Override
    public String toString() {
        return idEstudiante + ";" + nombreEstudiante + ";" + promedio + "_Prom;" + estadoBeca;
    }
}