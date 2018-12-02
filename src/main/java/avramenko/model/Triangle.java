package main.java.avramenko.model;

public class Triangle {

    private Point point1;
    private Point point2;
    private Point point3;

    Triangle(){
    }

    Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public double getPerimeter() {
        if (isPointsOnOneLine()) {
            return 0;
        } else {
            double length1 = getLength(point1, point2);
            double length2 = getLength(point1, point3);
            double length3 = getLength(point2, point3);
            return length1+length2+length3;
        }
    }

    private boolean isPointsOnOneLine() {
        double error = 1e-20;
        double operation1 = (double) point3.getX() - point1.getX();
        double operation2 = (double) point2.getX() - point1.getX();
        double operation3 = (double) point3.getY() - point1.getY();
        double operation4 = (double) point2.getY() - point1.getY();
        if (Math.pow(operation1 / operation2 - operation3 / operation4, 2) <= error) {
            return true;
        }
        return false;
    }

    private double getLength(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getY(), 2)+Math.pow(p2.getY() - p1.getY(), 2));
    }
}
