/*
 * Proyecto: Notas Universitarias
 * Asignatura: CONCEPTOS FUNDAMENTALES DE PROGRAMACIÓN-[GRUPO B03]
 * Su Grupo: G14
 * Integrantes:
 * - NORVEY PEÑA ROMERO
 * - ANDRES PORTILLO ARIAS
 * - DANIEL QUITIAN ALZATE
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static GeneradorArchivos generador = new GeneradorArchivos();
    private static List<Alumno> alumnos = new ArrayList<>();
    private static List<Nota> notas = new ArrayList<>();
    private static List<Promedio> promedios = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            menu();
            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("La opción debe ser un número entero. Intente de nuevo.\n");
                opcion = 0;
                continue;
            }
            procesarOpcion(opcion);
        } while (opcion != 5);

        scanner.close();
    }

    public static void menu() {
        System.out.println("====== SISTEMA DE NOTAS UNIVERSITARIAS ======");
        System.out.println("[1] Generar Archivos Base (alumnos.csv y notas.txt)");
        System.out.println("[2] Importar/Ver Base de Datos");
        System.out.println("[3] Calcular e Importar/Ver Salida (Cuadro de Honor)");
        System.out.println("[4] Descargar Salida (promedios.csv)");
        System.out.println("[5] Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                generador.generar();
                break;

            case 2:
                alumnos = generador.leerAlumnos();
                notas = generador.leerNotas();

                System.out.println("\n--- ALUMNOS CARGADOS ---");
                for (Alumno a : alumnos) {
                    System.out.println("ID: " + a.getId() + " | Nombre: " + a.getNombre());
                }

                System.out.println("\n--- NOTAS CARGADAS ---");
                for (Nota n : notas) {
                    System.out.println("ID Alumno: " + n.getIdEstudiante() + " | Materia: " + n.getNombreMateria() 
                            + " | Nota: " + n.getNota() + " | Créditos: " + n.getCreditos());
                }
                System.out.println();
                break;

            case 3:
                if (alumnos.isEmpty() || notas.isEmpty()) {
                    System.out.println("Cargando información previa de archivos...");
                    alumnos = generador.leerAlumnos();
                    notas = generador.leerNotas();
                }

                if (alumnos.isEmpty()) {
                    System.out.println("No hay datos para procesar. Ejecute la opción [1] primero.\n");
                    break;
                }

                promedios = calcularPromediosPonderados(alumnos, notas);
                
                // Ordenar de mayor a menor promedio (Ranking / Cuadro de Honor)
                promedios.sort((p1, p2) -> Double.compare(p2.getPromedio(), p1.getPromedio()));

                System.out.println("\n--- CUADRO DE HONOR / RANKING DE PROMEDIOS ---");
                int puesto = 1;
                for (Promedio p : promedios) {
                    System.out.println("#" + puesto + " | ID: " + p.getIdEstudiante() 
                            + " | Nombre: " + p.getNombreEstudiante() 
                            + " | Promedio Ponderado: " + String.format("%.2f", p.getPromedio()));
                    puesto++;
                }
                System.out.println();
                break;

            case 4:
                if (promedios.isEmpty()) {
                    System.out.println("Calculando promedios antes de guardar...");
                    alumnos = generador.leerAlumnos();
                    notas = generador.leerNotas();
                    promedios = calcularPromediosPonderados(alumnos, notas);
                    promedios.sort((p1, p2) -> Double.compare(p2.getPromedio(), p1.getPromedio()));
                }

                if (!promedios.isEmpty()) {
                    generador.guardarPromedios(promedios);
                } else {
                    System.out.println("No fue posible generar la salida. Verifique que existan archivos base.\n");
                }
                break;

            case 5:
                System.out.println("Saliendo del programa...");
                break;

            default:
                System.out.println("Opción inválida. Por favor, intente de nuevo.\n");
        }
    }

    // Método auxiliar para el cálculo del promedio ponderado
    private static List<Promedio> calcularPromediosPonderados(List<Alumno> listaAlumnos, List<Nota> listaNotas) {
        List<Promedio> resultados = new ArrayList<>();

        for (Alumno alumno : listaAlumnos) {
            double sumaPonderada = 0;
            int totalCreditos = 0;

            for (Nota nota : listaNotas) {
                if (nota.getIdEstudiante().equalsIgnoreCase(alumno.getId())) {
                    sumaPonderada += (nota.getNota() * nota.getCreditos());
                    totalCreditos += nota.getCreditos();
                }
            }

            double promedioFinal = (totalCreditos > 0) ? (sumaPonderada / totalCreditos) : 0.0;
            
            // Redondear a 2 decimales
            promedioFinal = Math.round(promedioFinal * 100.0) / 100.0;

            resultados.add(new Promedio(alumno.getId(), alumno.getNombre(), promedioFinal));
        }

        return resultados;
    }
}