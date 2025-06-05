import java.util.Arrays;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        ProductExceptSelf sol = new ProductExceptSelf();

        int[] nums = {1, 2, 3, 4};
        int[] result = sol.productExceptSelf(nums);

        System.out.println("Product Except Self: " + Arrays.toString(result));
        // Expected Output: [24, 12, 8, 6]
    }
}
