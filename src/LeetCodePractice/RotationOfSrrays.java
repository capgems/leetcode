package LeetCodePractice;

public class RotationOfSrrays {

    public static void main(String[] args) {
      /*  int [] a1 = {1,2,3,4,5,6,7};
        int [] a2 = {4,5,6,7,1,2,3};*/

        int[] array1 = {1, 2, 3, 4, 5, 6, 7};
        int[] array2a = {4, 5, 6, 7, 8, 1, 2, 3};
        // isRotation(array1, array2a) should return false.
        int[] array2b = {4, 5, 6, 7, 1, 2, 3};
        // isRotation(array1, array2b) should return true.
        int[] array2c = {4, 5, 6, 9, 1, 2, 3};
        // isRotation(array1, array2c) should return false.
        int[] array2d = {4, 6, 5, 7, 1, 2, 3};
        // isRotation(array1, array2d) should return false.
        int[] array2e = {4, 5, 6, 7, 0, 2, 3};
        // isRotation(array1, array2e) should return false.
        int[] array2f = {1, 2, 3, 4, 5, 6, 7};
        // isRotation(array1, array2f) should return true.

        //System.out.println(checkRotationStatus(array1, array2a));
        System.out.println(checkRotationStatus(array1, array2c));
        /*System.out.println(checkRotationStatus(array1, array2c));
        System.out.println(checkRotationStatus(array1, array2d));
        System.out.println(checkRotationStatus(array1, array2e));
        System.out.println(checkRotationStatus(array1, array2f));*/
    }

    static boolean checkRotationStatus(int arr[], int target[]) {

        if (arr.length != target.length) {
            return false;
        }

        int match = 0;
        int i = 0, j = 0;
        while (j < target.length && i < arr.length) {
            if (target[j] == arr[i]) {
                match++;
                i++;
                j++;
                if (j == arr.length) {
                    j = 0;
                }
            } else {
                j++;
            }
        }

        return match == arr.length;
    }
}
