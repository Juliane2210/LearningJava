public class Square implements Shape {

    private double x;
    private double y;
    private double side;

    public Square() {
        this.x = 0.0;
        this.y = 0.0;
        this.side = 0.0;
    }

    public Square(double x, double y, double side) {
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
        return 4 * side;
    }

    @Override
    public double area() {
        return Math.pow(side, 2);
    }

    @Override
    public void moveTo(double x, double y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }

    @Override
    public String toString() {
        return "Square, centre: (" + this.getX() + "," + this.getY() + "), side:" + this.getSide();
    }

    /**************************************
     * BONUS
     ******************************************/
    //
    // The function "intersect" is an example of function overloading
    //
    public boolean intersect(Circle circle) {
        double circleX = circle.getX();
        double circleY = circle.getY();
        double circleRadius = circle.getRadius();
        double squareSideLength = this.getSide();

        double halfSideLength = squareSideLength / 2;

        double distanceX = Math.abs(this.getX() - circleX);
        double distanceY = Math.abs(this.getY() - circleY);

        if (distanceX > (halfSideLength + circleRadius) || distanceY > (halfSideLength + circleRadius)) {
            return false;
        }

        if (distanceX <= halfSideLength || distanceY <= halfSideLength) {
            return true;
        }

        double cornerDistance = (distanceX - halfSideLength) * (distanceX - halfSideLength) +
                (distanceY - halfSideLength) * (distanceY - halfSideLength);

        return cornerDistance <= (circleRadius * circleRadius);

    }

    public boolean intersect(Square square2) {

        double halfSquare1SideLength = this.getSide() / 2;
        double halfSquare2SideLength = square2.getSide() / 2;

        double square1Length = this.getSide();
        double square2Length = square2.getSide();
        double square1X = this.getX() - halfSquare1SideLength;
        double square1Y = this.getY() - halfSquare1SideLength;

        double square2X = square2.getX() - halfSquare2SideLength;
        double square2Y = square2.getY() - halfSquare2SideLength;

        // Calculate the coordinates of the four corners of each square
        double square1Right = square1X + square1Length;
        double square1Bottom = square1Y + square1Length;

        double square2Right = square2X + square2Length;
        double square2Bottom = square2Y + square2Length;

        // Check if the squares are disjoint
        if (square1X > square2Right || square2X > square1Right ||
                square1Y > square2Bottom || square2Y > square1Bottom) {
            return false;
        }

        // The squares overlap or intersect
        return true;
    }

    public boolean intersect(Triangle triangle) {
        double squareX = this.getX();
        double squareY = this.getY();
        double squareSideLength = this.getSide();

        double triangleHalfSideLength = triangle.getSide() / 2;

        double triangleCenterX = triangle.getX();
        double triangleCenterY = triangle.getY();

        double triangleX1 = triangleCenterX;
        double triangleY1 = triangleCenterY - triangleHalfSideLength;
        double triangleX2 = triangleCenterX + triangleHalfSideLength;
        double triangleY2 = triangleCenterY + triangleHalfSideLength;
        double triangleX3 = triangleCenterX - triangleHalfSideLength;
        double triangleY3 = triangleCenterY + triangleHalfSideLength;

        if (ShapeUtils.isPointInsideSquare(triangleX1, triangleY1, squareX, squareY, squareSideLength) ||
                ShapeUtils.isPointInsideSquare(triangleX2, triangleY2, squareX, squareY, squareSideLength) ||
                ShapeUtils.isPointInsideSquare(triangleX3, triangleY3, squareX, squareY, squareSideLength)) {
            return true;
        }

        if (ShapeUtils.isPointInsideTriangle(squareX, squareY, triangleX1, triangleY1,
                triangleX2, triangleY2, triangleX3, triangleY3) ||
                ShapeUtils.isPointInsideTriangle(squareX + squareSideLength, squareY, triangleX1, triangleY1,
                        triangleX2, triangleY2, triangleX3, triangleY3)
                ||
                ShapeUtils.isPointInsideTriangle(squareX + squareSideLength, squareY + squareSideLength, triangleX1,
                        triangleY1,
                        triangleX2, triangleY2, triangleX3, triangleY3)
                ||
                ShapeUtils.isPointInsideTriangle(squareX, squareY + squareSideLength, triangleX1, triangleY1,
                        triangleX2, triangleY2, triangleX3, triangleY3)) {
            return true;
        }

        if (ShapeUtils.doLineSegmentsIntersect(triangleX1, triangleY1, triangleX2, triangleY2,
                squareX, squareY, squareX + squareSideLength, squareY) ||
                ShapeUtils.doLineSegmentsIntersect(triangleX2, triangleY2, triangleX3, triangleY3,
                        squareX, squareY, squareX + squareSideLength, squareY)
                ||
                ShapeUtils.doLineSegmentsIntersect(triangleX3, triangleY3, triangleX1, triangleY1,
                        squareX, squareY, squareX + squareSideLength, squareY)
                ||
                ShapeUtils.doLineSegmentsIntersect(triangleX1, triangleY1, triangleX2, triangleY2,
                        squareX + squareSideLength, squareY, squareX + squareSideLength, squareY + squareSideLength)
                ||
                ShapeUtils.doLineSegmentsIntersect(triangleX2, triangleY2, triangleX3, triangleY3,
                        squareX + squareSideLength, squareY, squareX + squareSideLength, squareY + squareSideLength)
                ||
                ShapeUtils.doLineSegmentsIntersect(triangleX3, triangleY3, triangleX1, triangleY1,
                        squareX + squareSideLength, squareY, squareX + squareSideLength, squareY + squareSideLength)
                ||
                ShapeUtils.doLineSegmentsIntersect(triangleX1, triangleY1, triangleX2, triangleY2,
                        squareX, squareY + squareSideLength, squareX + squareSideLength, squareY + squareSideLength)
                ||
                ShapeUtils.doLineSegmentsIntersect(triangleX2, triangleY2, triangleX3, triangleY3,
                        squareX, squareY + squareSideLength, squareX + squareSideLength, squareY + squareSideLength)
                ||
                ShapeUtils.doLineSegmentsIntersect(triangleX3, triangleY3, triangleX1, triangleY1,
                        squareX, squareY + squareSideLength, squareX + squareSideLength, squareY + squareSideLength)) {
            return true;
        }

        return false;
    }

    public boolean intersect(Pentagon pentagon) {

        double[] pentagonX = pentagon.getXPoints();
        double[] pentagonY = pentagon.getYPoints();

        // Calculate the coordinates of each vertex
        double pentagonX1 = pentagonX[0];
        double pentagonY1 = pentagonY[0];

        double pentagonX2 = pentagonX[1];
        double pentagonY2 = pentagonY[1];

        double pentagonX3 = pentagonX[2];
        double pentagonY3 = pentagonY[2];

        double pentagonX4 = pentagonX[3];
        double pentagonY4 = pentagonY[3];

        double pentagonX5 = pentagonX[4];
        double pentagonY5 = pentagonY[4];

        double squareLength = this.getSide();
        double halfSquareSideLength = this.getSide() / 2;
        double squareX = this.getX() - halfSquareSideLength;
        double squareY = this.getY() - halfSquareSideLength;

        // Check if any of the pentagon's line segments intersect with the square
        if (ShapeUtils.doLineSegmentsIntersect(pentagonX1, pentagonY1, pentagonX2, pentagonY2, squareX, squareY,
                squareX + squareLength, squareY)
                || ShapeUtils.doLineSegmentsIntersect(pentagonX2, pentagonY2, pentagonX3, pentagonY3, squareX, squareY,
                        squareX + squareLength, squareY)
                || ShapeUtils.doLineSegmentsIntersect(pentagonX3, pentagonY3, pentagonX4, pentagonY4, squareX, squareY,
                        squareX + squareLength, squareY)
                || ShapeUtils.doLineSegmentsIntersect(pentagonX4, pentagonY4, pentagonX5, pentagonY5, squareX, squareY,
                        squareX + squareLength, squareY)
                || ShapeUtils.doLineSegmentsIntersect(pentagonX5, pentagonY5, pentagonX1, pentagonY1, squareX, squareY,
                        squareX + squareLength, squareY)) {
            return true;
        }

        // Check if any of the pentagon's vertices are inside the square
        if (ShapeUtils.isPointInsideSquare(pentagonX1, pentagonY1, squareX, squareY, squareLength)
                || ShapeUtils.isPointInsideSquare(pentagonX2, pentagonY2, squareX, squareY, squareLength)
                || ShapeUtils.isPointInsideSquare(pentagonX3, pentagonY3, squareX, squareY, squareLength)
                || ShapeUtils.isPointInsideSquare(pentagonX4, pentagonY4, squareX, squareY, squareLength)
                || ShapeUtils.isPointInsideSquare(pentagonX5, pentagonY5, squareX, squareY, squareLength)) {
            return true;
        }

        return false;

    }

}
