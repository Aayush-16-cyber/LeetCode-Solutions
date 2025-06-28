public class armstrong {
    public static void main(String[] args) {
        int num = 153;
        int originalNum = num;
        int sum = 0;

        while (num != 0) {
            int singleDigit = num % 10;
            sum = sum + (int)Math.pow(singleDigit, 3);
            num = num / 10;
        }

        if (sum == originalNum) {
            System.out.println(originalNum + " is an Armstrong number.");
        } else {
            System.out.println(originalNum + " is not an Armstrong number.");
        }
    }
}
