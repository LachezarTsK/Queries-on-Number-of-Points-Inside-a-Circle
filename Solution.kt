
class Solution {
    fun countPoints(points: Array<IntArray>, queries: Array<IntArray>): IntArray {
        val pointsPerCircle = IntArray(queries.size);

        for (i in queries.indices) {
            val radius = queries[i][2];

            for (point in points) {
                val x = queries[i][0] - point[0];
                val y = queries[i][1] - point[1];

                if (pointIsInCircle(x, y, radius)) {
                    ++pointsPerCircle[i];
                }
            }
        }

        return pointsPerCircle
    }

    private fun pointIsInCircle(x: Int, y: Int, radius: Int): Boolean {
        // Alternatively: 
        // import kotlin.math.pow
        // x.toDouble().pow(2) + y.toDouble().pow(2) <= radius.toDouble().pow(2)
        return (x * x) + (y * y) <= radius * radius
    }
}
