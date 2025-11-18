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

}
