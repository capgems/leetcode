package PracticeProblems;

public class KthLargest {

    public int findKthLargest(int[] nums, int k) {
        nums = quickSort(nums, 0, nums.length - 1);
        return nums[(nums.length) - k];
    }

    int[] quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int partition = partition(nums, start, end);
            quickSort(nums, start, partition - 1);
            quickSort(nums, partition + 1, end);
        }
        return nums;
    }

    int partition(int[] arr, int st, int en) {

        int pivot = en;
        int i = st - 1;
        for (int j = st; j <= en; j++) {
            if (arr[j] <= arr[pivot]) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return i;
    }
}

class TestKth {

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest();
        System.out.println(kthLargest.findKthLargest(new int[]{1, 5, 2, 4, 3, 6}, 2));
    }
}
