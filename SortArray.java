import java.util.ArrayList;
import java.util.List;

public class SortArray {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    void mergeSort(int[] nums, int low, int high) {
        if (low >= high) return;

        int mid = low + (high - low) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    void merge(int[] nums, int low, int mid, int high) {
        int leftPtr = low;
        int rightPtr = mid + 1;
        List<Integer> temp = new ArrayList<>();

        while (leftPtr <= mid && rightPtr <= high) {
            if (nums[leftPtr] <= nums[rightPtr]) {
                temp.add(nums[leftPtr++]);
            } else {
                temp.add(nums[rightPtr++]);
            }
        }

        while (leftPtr <= mid) {
            temp.add(nums[leftPtr++]);
        }

        while (rightPtr <= high) {
            temp.add(nums[rightPtr++]);
        }

        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
    }

    public static void main(String[] args) {
        SortArray sorter = new SortArray();
        int[] nums = {5, 2, 3, 1};

        int[] sorted = sorter.sortArray(nums);

        System.out.print("Sorted array: ");
        for (int num : sorted) {
            System.out.print(num + " ");
        }
        System.out.println(); // new line after output
    }
}
