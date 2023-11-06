public class Triangle implements Shape {

    private double x;
    private double y;
    private double side;

    public Triangle() {
        this.x = 0.0;
        this.y = 0.0;
        this.side = 0.0;

    }

    public Triangle(double x, double y, double side) {
        this.x = x;
        this.y = y;
        this.side = side;

    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    public double getSide() {
        return side;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double perimeter() {
        return 3 * side;
    }

    @Override
    public double area() {
        return (Math.sqrt(3) * side) / 4;
    }

    @Override
    public void moveTo(double x, double y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public String toString() {
        return "Triange, centre: (" + this.getX() + "," + this.getY() + "), side:" + this.getSide();
    }

    /**************************************
     * BONUS
     ******************************************/
    // this is an example of overloading
    public boolean intersect(Pentagon pentagon) {
        // Calculate the angle between each vertex of the pentagon
        double angle = 2 * Math.PI / 5;

        // Calculate the coordinates of each vertex (corner) of the pentagon : given by
        // chatGPT
        double px1 = (double) (pentagon.getX() + pentagon.getSide() * Math.cos(0 * angle - Math.PI / 2));
        double py1 = (double) (pentagon.getY() + pentagon.getSide() * Math.sin(0 * angle - Math.PI / 2));

        double px2 = (double) (pentagon.getX() + pentagon.getSide() * Math.cos(1 * angle - Math.PI / 2));
        double py2 = (double) (pentagon.getY() + pentagon.getSide() * Math.sin(1 * angle - Math.PI / 2));

        double px3 = (double) (pentagon.getX() + pentagon.getSide() * Math.cos(2 * angle - Math.PI / 2));
        double py3 = (double) (pentagon.getY() + pentagon.getSide() * Math.sin(2 * angle - Math.PI / 2));

        double px4 = (double) (pentagon.getX() + pentagon.getSide() * Math.cos(3 * angle - Math.PI / 2));
        double py4 = (double) (pentagon.getY() + pentagon.getSide() * Math.sin(3 * angle - Math.PI / 2));

        double px5 = (double) (pentagon.getX() + pentagon.getSide() * Math.cos(4 * angle - Math.PI / 2));
        double py5 = (double) (pentagon.getY() + pentagon.getSide() * Math.sin(4 * angle - Math.PI / 2));

        double selfHalfSideLength = this.getSide() / 2;

        double selfCenterX = this.getX();
        double selfCenterY = this.getY();
        // Calculate the coordinates of each vertex (corner) of your instance of
        // triangle: given by chatGPT
        double tx1 = selfCenterX;
        double ty1 = selfCenterY - selfHalfSideLength;
        double tx2 = selfCenterX + selfHalfSideLength;
        double ty2 = selfCenterY + selfHalfSideLength;
        double tx3 = selfCenterX - selfHalfSideLength;
        double ty3 = selfCenterY + selfHalfSideLength;

        // Check if any line segment of the pentagon intersects with any line segment of
        // the triangle
        return ShapeUtils.doLineSegmentsIntersect(px1, py1, px2, py2, tx1, ty1, tx2, ty2) ||
                ShapeUtils.doLineSegmentsIntersect(px1, py1, px2, py2, tx2, ty2, tx3, ty3) ||
                ShapeUtils.doLineSegmentsIntersect(px1, py1, px2, py2, tx3, ty3, tx1, ty1) ||
                ShapeUtils.doLineSegmentsIntersect(px2, py2, px3, py3, tx1, ty1, tx2, ty2) ||
                ShapeUtils.doLineSegmentsIntersect(px2, py2, px3, py3, tx2, ty2, tx3, ty3) ||
                ShapeUtils.doLineSegmentsIntersect(px2, py2, px3, py3, tx3, ty3, tx1, ty1) ||
                ShapeUtils.doLineSegmentsIntersect(px3, py3, px4, py4, tx1, ty1, tx2, ty2) ||
                ShapeUtils.doLineSegmentsIntersect(px3, py3, px4, py4, tx2, ty2, tx3, ty3) ||
                ShapeUtils.doLineSegmentsIntersect(px3, py3, px4, py4, tx3, ty3, tx1, ty1) ||
                ShapeUtils.doLineSegmentsIntersect(px4, py4, px5, py5, tx1, ty1, tx2, ty2) ||
                ShapeUtils.doLineSegmentsIntersect(px4, py4, px5, py5, tx2, ty2, tx3, ty3) ||
                ShapeUtils.doLineSegmentsIntersect(px4, py4, px5, py5, tx3, ty3, tx1, ty1) ||
                ShapeUtils.doLineSegmentsIntersect(px5, py5, px1, py1, tx1, ty1, tx2, ty2) ||
                ShapeUtils.doLineSegmentsIntersect(px5, py5, px1, py1, tx2, ty2, tx3, ty3) ||
                ShapeUtils.doLineSegmentsIntersect(px5, py5, px1, py1, tx3, ty3, tx1, ty1);
    }

    // checks if your instance of triangle intersects with a circle
    public boolean intersect(Circle circle) {

        double circleX = circle.getX();
        double circleY = circle.getY();
        double circleRadius = circle.getRadius();

        double selfHalfSideLength = this.getSide() / 2;

        double selfCenterX = this.getX();
        double selfCenterY = this.getY();

        double triangleX1 = selfCenterX;
        double triangleY1 = selfCenterY - selfHalfSideLength;
        double triangleX2 = selfCenterX + selfHalfSideLength;
        double triangleY2 = selfCenterY + selfHalfSideLength;
        double triangleX3 = selfCenterX - selfHalfSideLength;
        double triangleY3 = selfCenterY + selfHalfSideLength;

        // Check if any of the triangle's vertices (corners) is inside the circle
        if (ShapeUtils.isPointInsideCircle(circleX, circleY, circleRadius, triangleX1, triangleY1) ||
                ShapeUtils.isPointInsideCircle(circleX, circleY, circleRadius, triangleX2, triangleY2) ||
                ShapeUtils.isPointInsideCircle(circleX, circleY, circleRadius, triangleX3, triangleY3)) {
            return true;
        }

        // Check if any of the circle's points are inside the triangle
        if (ShapeUtils.isPointInsideTriangle(triangleX1, triangleY1, triangleX2, triangleY2, triangleX3, triangleY3,
                circleX, circleY) ||
                ShapeUtils.isPointInsideTriangle(triangleX2, triangleY2, triangleX3, triangleY3, triangleX1, triangleY1,
                        circleX, circleY)
                ||
                ShapeUtils.isPointInsideTriangle(triangleX3, triangleY3, triangleX1, triangleY1, triangleX2, triangleY2,
                        circleX, circleY)) {
            return true;
        }

        // Check if any of the triangle's edges (sides) intersect with the circle
        if (ShapeUtils.doLineSegmentAndCircleIntersect(triangleX1, triangleY1, triangleX2, triangleY2, circleX, circleY,
                circleRadius) ||
                ShapeUtils.doLineSegmentAndCircleIntersect(triangleX2, triangleY2, triangleX3, triangleY3, circleX,
                        circleY, circleRadius)
                ||
                ShapeUtils.doLineSegmentAndCircleIntersect(triangleX3, triangleY3, triangleX1, triangleY1, circleX,
                        circleY, circleRadius)) {
            return true;
        }

        // If none of the above conditions are met, the triangle and circle do not
        // intersect
        return false;
    }

    // we use the method written in the square class
    public boolean intersect(Square square) {
        return square.intersect(this);
    }

    // Check if 2 triangles intersect
    public boolean intersect(Triangle triangle) {

        double triangleHalfSideLength = triangle.getSide() / 2;

        double triangleCenterX = triangle.getX();
        double triangleCenterY = triangle.getY();

        double x1 = triangleCenterX;
        double y1 = triangleCenterY - triangleHalfSideLength;
        double x2 = triangleCenterX + triangleHalfSideLength;
        double y2 = triangleCenterY + triangleHalfSideLength;
        double x3 = triangleCenterX - triangleHalfSideLength;
        double y3 = triangleCenterY + triangleHalfSideLength;

        double selfHalfSideLength = this.getSide() / 2;

        double selfCenterX = this.getX();
        double selfCenterY = this.getY();

        double x4 = selfCenterX;
        double y4 = selfCenterY - selfHalfSideLength;
        double x5 = selfCenterX + selfHalfSideLength;
        double y5 = selfCenterY + selfHalfSideLength;
        double x6 = selfCenterX - selfHalfSideLength;
        double y6 = selfCenterY + selfHalfSideLength;

        // Check if any line segment of triangle 1 intersects with any line segment of
        // triangle 2
        return ShapeUtils.doLineSegmentsIntersect(x1, y1, x2, y2, x4, y4, x5, y5) ||
                ShapeUtils.doLineSegmentsIntersect(x2, y2, x3, y3, x4, y4, x5, y5) ||
                ShapeUtils.doLineSegmentsIntersect(x3, y3, x1, y1, x4, y4, x5, y5) ||
                ShapeUtils.doLineSegmentsIntersect(x4, y4, x5, y5, x1, y1, x2, y2) ||
                ShapeUtils.doLineSegmentsIntersect(x5, y5, x6, y6, x1, y1, x2, y2) ||
                ShapeUtils.doLineSegmentsIntersect(x6, y6, x4, y4, x1, y1, x2, y2);
    }
}
