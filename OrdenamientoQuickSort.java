import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OrdenamientoQuickSort {

    public static void quickSort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int pi = partition(arr, inicio, fin);
            quickSort(arr, inicio, pi -1);
            quickSort(arr, pi + 1, fin);
        }
    }

    public static int partition(int[] arr, int inicio, int fin) {
        int pivot = arr[fin];
        int i = (inicio - 1);

        for (int j = inicio; j < fin; j++) {
            if (arr[j] < pivot) {
                i++;
                // Aqui se hace el intercambio dentro del arreglo
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Aqui se intercambian arr[i+1] y arr[fin]
        int temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;

        return i + 1;
    }

    // Use bufferReader e importaciones para leer los archivos.txt
    public static int[] leerArchivo(String nombreArchivo) {
        ArrayList<Integer> numeros = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Permitimos números separados por comas, espacios o saltos
                String[] partes = linea.split("[,\\s]+");
                for (String p : partes) {
                    if (!p.trim().isEmpty()) {
                        numeros.add(Integer.parseInt(p.trim()));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            System.exit(1);
        } catch (NumberFormatException e) {
            System.out.println("El archivo contiene valores no numéricos.");
            System.exit(1);
        }
        return numeros.stream().mapToInt(i -> i).toArray();

    }

    // Aqui se guardara el arreglo ordenado en un nuevo archivo
    public static void guardarArchivo(String nombreArchivo, int[] datos) {
        try (FileWriter fw = new FileWriter(nombreArchivo)) {
            for (int num : datos) {
                fw.write(num + " ");
            }
            System.out.println("Archivo '" + nombreArchivo + "' guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar archivo: " + e.getMessage());
        }
    }

    // Creación del main
    public static void main(String[] args) {
        String archivoEntrada = "numeros.txt";
        String archivoSalida = "numeros_ordenados.txt";

        System.out.println("Leyendo archivo: " + archivoEntrada);
        int[] numeros = leerArchivo(archivoEntrada);

        System.out.println("Números originales:");
        for (int n : numeros) System.out.print(n + " ");

        quickSort(numeros, 0, numeros.length - 1);

        System.out.println("\n\nNúmeros ordenados:");
        for (int n : numeros) System.out.print(n + " ");

        guardarArchivo(archivoSalida, numeros);
    }
}
