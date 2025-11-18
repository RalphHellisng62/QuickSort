import java.io.BufferedReader;
import java.io.FileReader;
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
        }

}
