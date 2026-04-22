import java.util.*;

class Solution {
    // Change return type from List to ArrayList
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        int n = arr.length;
        long[] prefixSum = new long[n];
        
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        
        // Initialize as ArrayList
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            long rangeSum = (l == 0) ? prefixSum[r] : prefixSum[r] - prefixSum[l - 1];
            int numElements = r - l + 1;
            result.add((int) (rangeSum / numElements));
        }
        
        return result;
    }
}