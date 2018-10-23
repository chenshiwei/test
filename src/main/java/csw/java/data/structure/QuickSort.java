package csw.java.data.structure;

import java.util.Arrays;

/**
 * 作用:
 *
 * @author chensw
 * @since 2018/9/20
 */
public class QuickSort {
  public static void main(String[] args) {
    int[] arr = {72, 6, 57, 88, 60, 42, 83, 73, 48, 85};
    System.out.println(Arrays.toString(arr));
    quickSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  private static void quickSort(int[] arr) {
    int low = 0;
    int high = arr.length - 1;
    quickSort(arr, low, high);
  }

  private static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      int index = partition(arr, low, high);
      quickSort(arr, low, index - 1);
      quickSort(arr, index + 1, high);
    }
  }

  private static int partition(int[] arr, int low, int high) {
    int i = low;
    int j = high;
    int x = arr[low];
    while (i < j) {
      while (arr[j] >= x && i < j) {
        j--;
      }
      if (i < j) {
        arr[i] = arr[j];
        i++;
      }
      while (arr[i] < x && i < j) {
        i++;
        if (i < j) {
          arr[j] = arr[i];
        }
      }
    }

    arr[i] = x;
    return i;
  }
}
