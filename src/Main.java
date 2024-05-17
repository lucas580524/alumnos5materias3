import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] datos = new String[3][5]; // 3 alumnos y 5 materias
        String[] nombresAlumnos = new String[3];
        String nombreArchivo = "datosAlumnos.txt";
        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese el nombre del alumno " + (i + 1) + ": ");
            nombresAlumnos[i] = scanner.nextLine();
            for (int j = 0; j < 5; j++) {
                System.out.println("Ingrese la materia " + (j + 1) + " del alumno " + (i + 1) + ": ");
                datos[i][j] = scanner.nextLine();
            }
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            for (int i = 0; i < 3; i++) {
                writer.println("Alumno: " + nombresAlumnos[i]);
                for (int j = 0; j < 5; j++) {
                    writer.println("Materia " + (j + 1) + ": " + datos[i][j]);
                }
                writer.println();
            }
            System.out.println("Los datos se han guardado correctamente en el archivo " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}
