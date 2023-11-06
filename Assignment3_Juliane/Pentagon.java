public class Pentagon implements Shape {

    private double x;
    private double y;
    private double side;

    public Pentagon() {
        this.x = 0.0;
        this.y = 0.0;
        this.side = 0.0;
    }

    public Pentagon(double x, double y, double side) {
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
        return 5 * side;
    }

    @Override
    public double area() {
        return (Math.pow(side, 2) * Math.sqrt(5 * (5 + (2 * Math.sqrt(5)))) / 4);
    }

    @Override
    public void moveTo(double x, double y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public String toString() {
        return "Pentagon, centre: (" + this.getX() + "," + this.getY() + "), side:" + this.getSide();
    }

    /**************************************
     * BONUS
     ******************************************/
    // A helper to return an array of 5 points for all the x-coords of the pentagon
    public double[] getXPoints() {
        // Calculate the angle between each vertex
        double angle = 2 * Math.PI / 5;

        // Calculate the coordinates of each vertex
        double pentagonX1 = (double) (this.getX() + this.getSide() * Math.cos(0 * angle - Math.PI / 2));
        double pentagonX2 = (double) (this.getX() + this.getSide() * Math.cos(1 * angle - Math.PI / 2));
        double pentagonX3 = (double) (this.getX() + this.getSide() * Math.cos(2 * angle - Math.PI / 2));
        double pentagonX4 = (double) (this.getX() + this.getSide() * Math.cos(3 * angle - Math.PI / 2));
        double pentagonX5 = (double) (this.getX() + this.getSide() * Math.cos(4 * angle - Math.PI / 2));

        return (new double[] { pentagonX1, pentagonX2, pentagonX3, pentagonX4, pentagonX5 });
    }

    // A helper to return an array of 5 points for all the y-coords of the pentagon
    public double[] getYPoints() {
        // Calculate the angle between each vertex
        double angle = 2 * Math.PI / 5;

        // Calculate the coordinates of each vertex
        double pentagonY1 = (double) (this.getY() + this.getSide() * Math.sin(0 * angle - Math.PI / 2));
        double pentagonY2 = (double) (this.getY() + this.getSide() * Math.sin(1 * angle - Math.PI / 2));
        double pentagonY3 = (double) (this.getY() + this.getSide() * Math.sin(2 * angle - Math.PI / 2));
        double pentagonY4 = (double) (this.getY() + this.getSide() * Math.sin(3 * angle - Math.PI / 2));
        double pentagonY5 = (double) (this.getY() + this.getSide() * Math.sin(4 * angle - Math.PI / 2));

        return (new double[] { pentagonY1, pentagonY2, pentagonY3, pentagonY4, pentagonY5 });
    }

    public boolean intersect(Pentagon pentagon) {

        double[] pentagon1X = this.getXPoints();
        double[] pentagon1Y = this.getYPoints();

        double[] pentagon2X = pentagon.getXPoints();
        double[] pentagon2Y = pentagon.getYPoints();

        // Check if any line segment of pentagon1 intersects with any line segment of
        // pentagon2
        for (int i = 0; i < 5; i++) {
            int j = (i + 1) % 5; // Next vertex in the same pentagon

            // Check if any line segment of pentagon1 intersects with any line segment of
            // pentagon2
            for (int k = 0; k < 5; k++) {
                int l = (k + 1) % 5; // Next vertex in the other pentagon

                if (ShapeUtils.doLineSegmentsIntersect(pentagon1X[i], pentagon1Y[i], pentagon1X[j], pentagon1Y[j],
                        pentagon2X[k], pentagon2Y[k], pentagon2X[l], pentagon2Y[l])) {
                    return true;
                }
            }
        }

        // If no line segments intersect, the pentagons do not intersect
        return false;
    }

    // we use method implemented in class circle
    public boolean intersect(Circle circle) {
        return circle.intersect(this);
    }

    // we use method implemented in class square
    public boolean intersect(Square square) {
        return square.intersect(this);

    }

    // we use method implemented in class triangle
    public boolean intersect(Triangle triangle) {
        return triangle.intersect(this);
    }

}
