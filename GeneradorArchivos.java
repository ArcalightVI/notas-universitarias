import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeneradorArchivos {

    public static final String ARCHIVO_ALUMNOS = "alumnos.csv";
    public static final String ARCHIVO_NOTAS = "notas.txt";
    public static final String ARCHIVO_PROMEDIOS = "promedios.csv";

    private List<Alumno> listaAlumnos = new ArrayList<>();
    private List<Nota> listaNotas = new ArrayList<>();

    public GeneradorArchivos() {
        listaAlumnos.add(new Alumno("A1", "Carlos Perez"));
        listaAlumnos.add(new Alumno("A2", "Maria Lopez"));
        listaAlumnos.add(new Alumno("A3", "Juan Gomez"));

        listaNotas.add(new Nota("A1", "Calculo", 4.5, 3));
        listaNotas.add(new Nota("A1", "Programacion", 4.0, 4));
        listaNotas.add(new Nota("A2", "Calculo", 3.5, 3));
        listaNotas.add(new Nota("A2", "Fisica", 5.0, 2));
        listaNotas.add(new Nota("A3", "Calculo", 2.8, 3));
        listaNotas.add(new Nota("A3", "Programacion", 3.0, 4));
    }

    public void generar() {
        System.out.println("Generando archivos de prueba...");
        try (PrintWriter writerAlumnos = new PrintWriter(ARCHIVO_ALUMNOS);
             PrintWriter writerNotas = new PrintWriter(ARCHIVO_NOTAS)) {

            for (Alumno alumno : listaAlumnos) {
                writerAlumnos.println(alumno.toString());
            }

            for (Nota nota : listaNotas) {
                writerNotas.println(nota.toString());
            }

            System.out.println("Archivos generados correctamente: " + ARCHIVO_ALUMNOS + ", " + ARCHIVO_NOTAS + "\n");
        } catch (Exception e) {
            System.out.println("Error al generar archivos: " + e.getMessage());
        }
    }

    public List<Alumno> leerAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        File file = new File(ARCHIVO_ALUMNOS);
        if (!file.exists()) {
            System.out.println("El archivo " + ARCHIVO_ALUMNOS + " no existe. Ejecuta la opción [1] primero.");
            return alumnos;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine().trim();
                if (!linea.isEmpty()) {
                    String[] partes = linea.split(";");
                    if (partes.length == 2) {
                        alumnos.add(new Alumno(partes[0], partes[1]));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer " + ARCHIVO_ALUMNOS + ": " + e.getMessage());
        }
        return alumnos;
    }

    public List<Nota> leerNotas() {
        List<Nota> notas = new ArrayList<>();
        File file = new File(ARCHIVO_NOTAS);
        if (!file.exists()) {
            System.out.println("El archivo " + ARCHIVO_NOTAS + " no existe. Ejecuta la opción [1] primero.");
            return notas;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine().trim();
                if (!linea.isEmpty()) {
                    String[] partes = linea.split(";");
                    if (partes.length == 4) {
                        String id = partes[0];
                        String materia = partes[1];
                        double notaVal = Double.parseDouble(partes[2]);
                        int creditosVal = Integer.parseInt(partes[3].split("_")[0]);

                        // VALIDACIÓN REGLA DE NEGOCIO (ENTREGA 2)
                        if (notaVal < 0.0 || notaVal > 5.0 || creditosVal <= 0) {
                            System.out.println("⚠️ ALERTA: Nota ignorada por inconsistencia de datos -> Estudiante: " 
                                    + id + " (" + materia + ": " + notaVal + ", " + creditosVal + " créditos)");
                            continue;
                        }

                        notas.add(new Nota(id, materia, notaVal, creditosVal));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer " + ARCHIVO_NOTAS + ": " + e.getMessage());
        }
        return notas;
    }

    public void guardarPromedios(List<Promedio> promedios) {
        try (PrintWriter writer = new PrintWriter(ARCHIVO_PROMEDIOS)) {
            for (Promedio p : promedios) {
                writer.println(p.toString());
            }
            System.out.println("Archivo " + ARCHIVO_PROMEDIOS + " generado exitosamente con el estado de becas.\n");
        } catch (Exception e) {
            System.out.println("Error al guardar " + ARCHIVO_PROMEDIOS + ": " + e.getMessage());
        }
    }
}