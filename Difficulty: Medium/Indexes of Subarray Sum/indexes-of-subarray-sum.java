import java.util.ArrayList;

class Solution {
    // Change the signature to accept only 2 arguments: arr and target
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Calculate n internally instead of requiring it as a parameter
        int n = arr.length;
        long currentSum = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            currentSum += arr[right];

            while (currentSum > target && left < right) {
                currentSum -= arr[left];
                left++;
            }

            if (currentSum == target) {
                result.add(left + 1);  // 1-based index
                result.add(right + 1); // 1-based index
                return result;
            }
        }

        result.add(-1);
        return result;
    }
}