public class OrdenamientoQuickSort {
    
    public static void quickSort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int pi = partition(arr, inicio, fin);
            quickSort(arr, inicio, pi -1);
            quickSort(arr, pi + 1, fin);
        }
    }

}
