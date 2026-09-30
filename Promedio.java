public class Promedio {

    private String idEstudiante;
    private String nombreEstudiante;
    private double promedio;

    public Promedio() {
    }

    public Promedio(String idEstudiante, String nombreEstudiante, double promedio) {
        this.idEstudiante = idEstudiante;
        this.nombreEstudiante = nombreEstudiante;
        this.promedio = promedio;
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

    @Override
    public String toString() {
        return idEstudiante+";"+nombreEstudiante+";"+promedio+"_Prom";
    }
}
