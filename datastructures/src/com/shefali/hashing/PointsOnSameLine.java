package com.shefali.hashing;

import java.util.*;

public class PointsOnSameLine {

    public static void computePairs(List<Point> points) {
        Map<Double, Set<Point>> slopes = new HashMap<>();
        for(Point p1 : points) {
            for(Point p2 : points) {
                if(p1 == p2) {
                    continue;
                }
                double slope = (1.0 * (p2.y - p1.y)) / (p2.x - p1.x);
                Set<Point> pointes = slopes.get(slope);
                if (pointes == null) {
                    pointes = new HashSet<>();
                }
                pointes.add(p1);
                pointes.add(p2);
                slopes.put(slope, pointes);
            }
        }
        int maxPoints = 0;
        Set<Point> pointSet = new HashSet<>();
        double slope = 0.0;
        for(Map.Entry<Double, Set<Point>> e : slopes.entrySet()) {
            if(e.getValue().size() > maxPoints) {
                maxPoints = e.getValue().size();
                pointSet = e.getValue();
                slope = e.getKey();
            }
        }
        System.out.println(pointSet + " " + maxPoints + " " + slope);
    }

    public static void main(String[] args) {
        int arr[][] = {{-1, 1}, {0, 0}, {1, 1}, {2, 2},
            {3, 3}, {3, 4}};
        List<Point> points = new ArrayList<>();
        for(int i = 0;i<6;i++) {
            points.add(new Point(arr[i][0], arr[i][1]));
        }
        computePairs(points);
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" + this.x + "," + this.y + "}";
    }
}
