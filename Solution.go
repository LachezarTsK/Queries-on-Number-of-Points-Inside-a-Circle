
package main

import "fmt"

func countPoints(points [][]int, queries [][]int) []int {
	pointsPerCircle := make([]int, len(queries))

	for i := range queries {
		radius := queries[i][2]

		for _, point := range points {
			x := queries[i][0] - point[0]
			y := queries[i][1] - point[1]

			if pointIsInCircle(x, y, radius) {
				pointsPerCircle[i]++
			}
		}
	}

	return pointsPerCircle
}

func pointIsInCircle(x, y, radius int) bool {
	// alternatively:
	// import "math"
	// math.Pow(float64(x), 2)+math.Pow(float64(y), 2) <= math.Pow(float64(radius), 2)
	return (x*x)+(y*y) <= radius*radius
}
