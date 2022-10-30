package JavaCore.Algorithms;

import java.util.Arrays;

public class MergeTest {

    public static void main(String[] args) {
        int[][][] data = {
                {{}, {}}, {{0}, {1}}, {{1}, {0}}, {{0, 2}, {1, 3}}, {{0, 2, 7, 9, 123}, {1, 3, 4, 5, 6}},
        };

        for (int[][] origin : data) {
            int[] firstArray = origin[0];
            int[] secondArray = origin[1];
            int[] merged = MergeSortedArrays.mergeSortedArrays(firstArray, secondArray);

            System.out.println(Arrays.toString(firstArray) + " + " + Arrays.toString(secondArray) + " -> " + Arrays.toString(merged));
        }
    }

}
