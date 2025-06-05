public class CountQuadruplets {
    public int countQuadruplets(int[] nums) {
        int count = 0;
        int n = nums.length;

        // Iterate through all possible quadruplets
        for (int a = 0; a < n - 3; a++) {
            for (int b = a + 1; b < n - 2; b++) {
                for (int c = b + 1; c < n - 1; c++) {
                    for (int d = c + 1; d < n; d++) {
                        if (nums[a] + nums[b] + nums[c] == nums[d]) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountQuadruplets sol = new CountQuadruplets();
        int[] nums = {1, 2, 3, 6};
        int result = sol.countQuadruplets(nums);
        System.out.println("Count of valid quadruplets: " + result);
    }
}
