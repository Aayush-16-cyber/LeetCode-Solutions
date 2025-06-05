public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        SearchInsertPosition sol = new SearchInsertPosition();

        int[] nums = {1, 3, 5, 6};
        int target = 5;

        int result = sol.searchInsert(nums, target);

        System.out.println("Insert position for target " + target + " is: " + result);
        // Expected Output: 2
    }
}
