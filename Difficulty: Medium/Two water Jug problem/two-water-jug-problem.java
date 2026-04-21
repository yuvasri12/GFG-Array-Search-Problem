class Solution {
    public int minSteps(int m, int n, int d) {
        // Basic solvability check
        if (d > Math.max(m, n) || d % gcd(m, n) != 0) return -1;

        // Return the minimum of simulating both starting directions
        return Math.min(solve(m, n, d), solve(n, m, d));
    }

    private int solve(int fromCap, int toCap, int d) {
        int from = fromCap; // Initial fill
        int to = 0;
        int steps = 1; // 1st step: Fill "from" jug

        while (from != d && to != d) {
            // Find how much we can pour
            int temp = Math.min(from, toCap - to);

            // Pour from "from" to "to"
            to += temp;
            from -= temp;
            steps++;

            if (from == d || to == d) break;

            // If "from" jug becomes empty, fill it
            if (from == 0) {
                from = fromCap;
                steps++;
            }

            // If "to" jug becomes full, empty it
            if (to == toCap) {
                to = 0;
                steps++;
            }
        }
        return steps;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}