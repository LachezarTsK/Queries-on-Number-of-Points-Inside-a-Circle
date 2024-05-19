
using System;

public class Solution
{
    public int[] CountPoints(int[][] points, int[][] queries)
    {
        int[] pointsPerCircle = new int[queries.Length];

        for (int i = 0; i < queries.Length; ++i)
        {
            int radius = queries[i][2];

            foreach (int[] point in points)
            {
                int x = queries[i][0] - point[0];
                int y = queries[i][1] - point[1];

                if (PointIsInCircle(x, y, radius))
                {
                    ++pointsPerCircle[i];
                }
            }
        }

        return pointsPerCircle;
    }

    private bool PointIsInCircle(int x, int y, int radius)
    {   // Alternatively:
        // Math.Pow(x, 2) + Math.Pow(y, 2) <= Math.Pow(radius, 2);
        return (x * x) + (y * y) <= radius * radius;
    }
}
