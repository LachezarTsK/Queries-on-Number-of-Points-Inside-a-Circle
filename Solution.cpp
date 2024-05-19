
#include <cmath>
#include <vector>
using namespace std;

class Solution {

public:
    vector<int> countPoints(const vector<vector<int>>& points, const vector<vector<int>>& queries) const {
    vector<int> pointsPerCircle(queries.size());

    for (size_t i = 0; i < queries.size(); ++i) {
        int radius = queries[i][2];

        for (const auto& point : points) {
            int x = queries[i][0] - point[0];
            int y = queries[i][1] - point[1];

            if (pointIsInCircle(x, y, radius)) {
                ++pointsPerCircle[i];
            }
        }
    }

    return pointsPerCircle;
    }

private:
    bool pointIsInCircle(int x, int y, int radius) const {
        // Alternatively:
        // pow(x, 2) + pow(y, 2) <= pow(radius, 2)
        return (x*x) + (y*y) <= radius*radius;
    }
};
