package hans.algorithm;

import hans.algorithm.utils.SortUtils;

public class Practices {


    public static void quickSort(int[] arr, int low, int high) {

        if (low>=high) return;
        int l = low;
        int h = high;
        int pivot = arr[low];

        while (l<h) {
            while (l<h && arr[h]>pivot) h--;
            arr[l] = arr[h];
            while (l<h && arr[l]<pivot) l++;
            arr[h] = arr[l];
        }

        arr[h] = pivot;
        quickSort(arr, low, l-1);
        quickSort(arr, l+1, high);

    }


    public static void heapSort(int[] arr) {
        buildHeap(arr);

        for (int i=arr.length-1; i>0; i--) {
            SortUtils.swap(arr, i, 0);
            maxHeap(arr, 0, i);
        }
    }
    public static void buildHeap(int[] arr) {
        for (int i=arr.length/2; i>=0; i--) {
            maxHeap(arr, i, arr.length);
        }
    }
    public static void maxHeap(int[] arr, int root, int high) {
        if (root >= high) return;
        int left = root*2 + 1;
        int right = root*2 + 2;
        int maxIndex = root;

        if (left<high && arr[left]>arr[maxIndex]) {
            maxIndex = left;
        }
        if (right<high && arr[right]>arr[maxIndex]) {
            maxIndex = right;
        }
        if (root!=maxIndex) {
            SortUtils.swap(arr, root, maxIndex);
            maxHeap(arr, maxIndex, high);
        }
    }
}
