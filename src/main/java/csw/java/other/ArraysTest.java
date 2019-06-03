package csw.java.other;

import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {
        fk4();
        int sji = 21;
        System.out.println(sji);
        play(sji);

        int[] num = {1, 5, 6, 4, 98, 2, 1, 544, 93, 3, 6478, 24, 154, 45, 78};
        Arrays.sort(num);
        int index = Arrays.binarySearch(num, 5);
        System.out.println(index);
        System.out.println(Arrays.toString(num));

        int[] arr1 = new int[]{3, -4, 25, 16, 30, 18};

        Arrays.parallelSort(arr1);

        System.out.println(Arrays.toString(arr1));

        int a[] = new int[50];
        for (int i = 0; i < 50; i++) {
            a[i] = (int) (Math.random() * 50);
        }
        int[] arr2 = new int[]{3, -4, 25, 16, 30, 18};

        Arrays.parallelPrefix(arr2, (left, right) -> left + right);

        System.out.println(Arrays.toString(a));
    }

    private static void play(int i) {
        System.out.println(i);
    }

    private static void fk4() {
        System.out.println("bducf");

    }
}
