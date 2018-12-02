package main.java.avramenko.model;

import java.util.*;

public class Model {

    private Set<Point> pointsSet;
    private Point point;
    private Triangle triangle;

    public Model() {
        triangle = new Triangle();
        pointsSet = new HashSet<>();
    }

    public Set<Point> getPointsSet() {
        return pointsSet;
    }

    public Set<Point> generateSetOfPoints() {
        pointsSet = new HashSet<>();
        for (int i = 0; i < 15; i++) {
            do {
                point = new Point(generateCoordinate(), generateCoordinate());
            } while (pointsSet.contains(point));
            pointsSet.add(point);
        }
        return pointsSet;
    }

    private int generateCoordinate() {
        return (int) (Math.random()*(40+1))-20;
    }

    public String getTriangle() {
        double perimeter = 0;
        double currentPerimeter;
        String result;
        Set<Point> resultSet = new HashSet<>();
        List<Point> pointList = new ArrayList<>(pointsSet);

        for (int i = 0; i < pointList.size() - 2; i++){
            for (int j = i + 1; j < pointList.size() -1; j++){
                for (int k = j +1; k < pointList.size(); k++){
                    triangle = new Triangle(pointList.get(i), pointList.get(j), pointList.get(k));
                    currentPerimeter = triangle.getPerimeter();
                    if (currentPerimeter > perimeter) {
                        perimeter = currentPerimeter;
                        resultSet.clear();
                        resultSet.add(pointList.get(i));
                        resultSet.add(pointList.get(j));
                        resultSet.add(pointList.get(k));
                    }
                }
            }
        }
        result = "Perimeter: " + perimeter + "\nPoints: " + resultSet.toString();
        return result;
    }

}
