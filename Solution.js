
/**
 * @param {number[][]} points
 * @param {number[][]} queries
 * @return {number[]}
 */
var countPoints = function (points, queries) {
    const pointsPerCircle = new Array(queries.length).fill(0);
    for (let i = 0; i < queries.length; ++i) {
        const radius = queries[i][2];

        for (let point of points) {
            let x = queries[i][0] - point[0];
            let y = queries[i][1] - point[1];

            if (pointIsInCircle(x, y, radius)) {
                ++pointsPerCircle[i];
            }
        }
    }

    return pointsPerCircle;
};

/**
 * @param {number} x
 * @param {number} y
 * @param {number} radius
 * @return {boolean}
 */
function pointIsInCircle(x, y, radius) {
    // Alternatively:
    // Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(radius, 2);
    return (x * x) + (y * y) <= radius * radius;
}
