
# Sistema de Notas Universitarias (Java CLI)

Aplicación de consola desarrollada en Java para la materia **Conceptos Fundamentales de Programación** (Politécnico Grancolombiano).

## Descripción del Proyecto
El sistema procesa registros de estudiantes y calificaciones por asignaturas para calcular el **promedio académico ponderado** según la cantidad de créditos de cada materia. Finalmente, genera un ranking ordenado de mayor a menor promedio e identifica a los estudiantes aptos para becas académicas.

## Funcionalidades
- **Lectura y Escritura de Archivos:** Procesa archivos de origen (`alumnos.csv` y `notas.txt`) y exporta el informe final a `promedios.csv`.
- **Cálculo Ponderado:** Aplica la fórmula $\frac{\sum (\text{Nota} \times \text{Créditos})}{\sum \text{Créditos}}$.
- **Validación de Datos:** Filtra notas fuera del rango $0.0 - 5.0$ y créditos inválidos ($\le 0$) avisando por consola.
- **Clasificación de Becas:** Asigna automáticamente el estado `APLICA_BECA` a promedios $\ge 4.0$.
- **Menú Interactivo CLI:** Navegación por opciones numéricas mediante teclado.

## Tecnologías y Conceptos Aplicados
- **Lenguaje:** Java
- **Paradigma:** Programación Orientada a Objetos (POO)
- **Conceptos:** Encapsulamiento, lectura/escritura I/O (`Scanner`, `PrintWriter`), manipulación de cadenas (`split`), manejo de excepciones (`try-catch`) y expresiones Lambda para ordenamiento.

## 📁 Estructura del Código (`src/`)
- `Alumno.java`: Modelo de entidad del estudiante.
- `Nota.java`: Modelo de calificación, asignatura y créditos.
- `Promedio.java`: Modelo del resultado calculado y estado de beca.
- `GeneradorArchivos.java`: Servicio encargado del procesamiento I/O de archivos.
- `Main.java`: Controlador del menú interactivo y punto de entrada.
