 class MissingNumber {
    public static int findMissingNumber(int[] arr, int n) {
        
        int total = n * (n + 1) / 2;
        int arrSum = 0;
        for (int num : arr) {
            arrSum += num;
        }
        return total - arrSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};  
        int n = 5;  

        int missing = findMissingNumber(arr, n);
        System.out.println("Missing number: " + missing);
    }
}
