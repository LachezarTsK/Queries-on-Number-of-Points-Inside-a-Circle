
public class Solution {

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] pointsPerCircle = new int[queries.length];

        for (int i = 0; i < queries.length; ++i) {
            int radius = queries[i][2];

            for (int[] point : points) {
                int x = queries[i][0] - point[0];
                int y = queries[i][1] - point[1];

                if (pointIsInCircle(x, y, radius)) {
                    ++pointsPerCircle[i];
                }
            }
        }

        return pointsPerCircle;
    }

    private boolean pointIsInCircle(int x, int y, int radius) {
        // Alternatively:
        // Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(radius, 2)
        return (x * x) + (y * y) <= radius * radius;
    }
}
