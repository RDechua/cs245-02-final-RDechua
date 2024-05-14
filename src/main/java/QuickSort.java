import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int arr[], int low, int high) {
        int pivot;
        // FILL IN CODE: add a base case
        // Add recursive calls

        pivot = partition(arr, low, high);
        System.out.println("Pivot element used for partition: " + arr[pivot]);

    }


    /**
     * A helper method that partitions the given subarray from low to high (inclusive)
     * so that elements on the left of the pivot are smaller than pivot,
     * elements on the right of the pivot are larger than or equal to pivot
     * @param arr input array
     * @param low low index
     * @param high high index
     * @return index of the pivot that was used for the partition
     */
    private static int partition(int arr[], int low, int high) {
        int pivot;
        int tmp;
        int max = high;
        int mid = (low + high) / 2;

        tmp = arr[mid];
        arr[mid] = arr[high];
        arr[high] = tmp;

        pivot = arr[high];
        while (low <= high) {
            while ((low <= high) && (arr[low] < pivot))
                low++;
            while ((low <= high) && (arr[high] >= pivot))
                high--;
            if (low <= high) {
                tmp = arr[low];
                arr[low] = arr[high];
                arr[high] = tmp;
                low++;
                high--;
            }
        }
        tmp = arr[low];
        arr[low] = arr[max];
        arr[max] = tmp;
        return low;
    }

    public static void quickSort(int arr[]) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr2 = {5, 9, 0, 1, 12, 6, 20, 4, 10, 3, 45};
        System.out.println(Arrays.toString(arr2));
        quickSort(arr2);
        System.out.println(Arrays.toString(arr2)); // should print a sorted array after you complete the code of quick sort

    }
}
