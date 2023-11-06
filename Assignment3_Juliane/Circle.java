public class Circle implements Shape {

    private double x;
    private double y;
    private double radius;

    public Circle() {
        this.x = 0.0;
        this.y = 0.0;
        this.radius = 0.0;
    }

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public void moveTo(double x, double y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public String toString() {
        return "Circle, centre: (" + this.getX() + "," + this.getY() + "), radius:" + this.getRadius();
    }

    /**************************************
     * BONUS
     ******************************************/
    //
    // This is an example of function overloading
    //
    public boolean intersect(Pentagon pentagon) {

        double circleX = this.getX();
        double circleY = this.getY();

        double radius = this.getRadius();

        double[] pentagonX = pentagon.getXPoints();
        double[] pentagonY = pentagon.getYPoints();

        // Check if any line segment of the pentagon intersects with the circle
        for (int i = 0; i < 5; i++) {
            int j = (i + 1) % 5;

            if (ShapeUtils.doLineSegmentAndCircleIntersect(pentagonX[i], pentagonY[i], pentagonX[j], pentagonY[j],
                    circleX, circleY, radius)) {
                return true;
            }
        }

        // If no line segments intersect, the circle and pentagon do not intersect
        return false;
    }

    public boolean intersect(Circle circle) {
        double dx = circle.getX() - this.getX();
        double dy = circle.getY() - this.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance <= this.getRadius() + circle.getRadius();
    }

    //
    // The "other" shape already implements the intersect:

    // we use the method written in the square class
    public boolean intersect(Square square) {
        return square.intersect(this);
    }

    // we use the method written in the triangle class
    public boolean intersect(Triangle triangle) {
        return triangle.intersect(this);

    }

}
