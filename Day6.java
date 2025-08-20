import java.util.*;

class Day6 {
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int prefixSum = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            
            if (prefixSum == 0) {
                result.add(new int[]{0, i});
            }

            if (map.containsKey(prefixSum)) {
                for (int startIndex : map.get(prefixSum)) {
                    result.add(new int[]{startIndex + 1, i});
                }
            }

            map.computeIfAbsent(prefixSum, k -> new ArrayList<>()).add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 3, -1, 2};
        List<int[]> subarrays = findZeroSumSubarrays(arr);

        System.out.print("Zero-sum subarrays: ");
        for (int[] pair : subarrays) {
            System.out.print("(" + pair[0] + "," + pair[1] + ") ");
        }
    }
}
