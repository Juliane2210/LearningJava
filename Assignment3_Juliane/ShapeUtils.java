
//
// Note: The math behind these functions were derived from Chat GPT and google.
//       The query used to determine these responses from ChatGPT is:
//        " java function to determine intersection between X and Y " 
// these are helper functions for the intersect methods written in each of their respective shape classes
public class ShapeUtils {

    // Check if a point (x, y) is inside a square
    public static boolean isPointInsideSquare(double x, double y, double squareX, double squareY, double squareLength) {
        return x >= squareX && x <= squareX + squareLength && y >= squareY && y <= squareY + squareLength;
    }

    // Check if a point is inside a circle
    public static boolean isPointInsideCircle(double circleX, double circleY, double radius, double pointX,
            double pointY) {
        double distance = Math.sqrt(Math.pow((pointX - circleX), 2) + Math.pow((pointY - circleY), 2));
        return distance <= radius;
    }

    // Check if a point (x, y) is inside a triangle defined by three vertices
    public static boolean isPointInsideTriangle(double x, double y,
            double triangleX1, double triangleY1,
            double triangleX2, double triangleY2,
            double triangleX3, double triangleY3) {
        // Calculate the barycentric coordinates of the point with respect to the
        // triangle
        double alpha = ((triangleY2 - triangleY3) * (x - triangleX3) + (triangleX3 - triangleX2) * (y - triangleY3)) /
                ((triangleY2 - triangleY3) * (triangleX1 - triangleX3)
                        + (triangleX3 - triangleX2) * (triangleY1 - triangleY3));
        double beta = ((triangleY3 - triangleY1) * (x - triangleX3) + (triangleX1 - triangleX3) * (y - triangleY3)) /
                ((triangleY2 - triangleY3) * (triangleX1 - triangleX3)
                        + (triangleX3 - triangleX2) * (triangleY1 - triangleY3));
        double gamma = 1.0 - alpha - beta;

        // Check if the barycentric coordinates are within the valid range
        return alpha >= 0 && beta >= 0 && gamma >= 0;
    }

    public static boolean isPointInsideSegment(double lineX1, double lineY1, double lineX2, double lineY2,
            double pointX, double pointY) {
        double minX = Math.min(lineX1, lineX2);
        double maxX = Math.max(lineX1, lineX2);
        double minY = Math.min(lineY1, lineY2);
        double maxY = Math.max(lineY1, lineY2);

        return pointX >= minX && pointX <= maxX && pointY >= minY && pointY <= maxY;
    }

    // Check if two line segments defined by their endpoints intersect
    public static boolean doLineSegmentsIntersect(double x1, double y1, double x2, double y2,
            double x3, double y3, double x4, double y4) {
        double direction1 = calculateDirection(x3, y3, x4, y4, x1, y1);
        double direction2 = calculateDirection(x3, y3, x4, y4, x2, y2);
        double direction3 = calculateDirection(x1, y1, x2, y2, x3, y3);
        double direction4 = calculateDirection(x1, y1, x2, y2, x4, y4);

        return direction1 != direction2 && direction3 != direction4 ||
                direction1 == 0 && isOnSegment(x3, y3, x4, y4, x1, y1) ||
                direction2 == 0 && isOnSegment(x3, y3, x4, y4, x2, y2) ||
                direction3 == 0 && isOnSegment(x1, y1, x2, y2, x3, y3) ||
                direction4 == 0 && isOnSegment(x1, y1, x2, y2, x4, y4);
    }

    // Calculate the direction of a line segment formed by three points
    public static double calculateDirection(double x1, double y1, double x2, double y2, double x3, double y3) {
        double value = (y3 - y1) * (x2 - x1) - (x3 - x1) * (y2 - y1);

        if (value < 0) {
            return -1; // Right turn
        } else if (value > 0) {
            return 1; // Left turn
        } else {
            return 0; // Collinear
        }
    }

    // Check if a point (x, y) lies on a line segment formed by two other points
    public static boolean isOnSegment(double x1, double y1, double x2, double y2, double x, double y) {
        return x >= Math.min(x1, x2) && x <= Math.max(x1, x2) &&
                y >= Math.min(y1, y2) && y <= Math.max(y1, y2);
    }

    public static boolean doLineSegmentAndCircleIntersect(double lineX1, double lineY1, double lineX2, double lineY2,
            double circleX, double circleY, double radius) {
        double lineLength = Math.sqrt(Math.pow((lineX2 - lineX1), 2) + Math.pow((lineY2 - lineY1), 2));
        double dotProduct = ((circleX - lineX1) * (lineX2 - lineX1) + (circleY - lineY1) * (lineY2 - lineY1))
                / Math.pow(lineLength, 2);
        double closestX = lineX1 + dotProduct * (lineX2 - lineX1);
        double closestY = lineY1 + dotProduct * (lineY2 - lineY1);

        boolean isOnSegment = isPointInsideSegment(lineX1, lineY1, lineX2, lineY2, closestX, closestY);
        boolean isCloseEnough = Math
                .sqrt(Math.pow((closestX - circleX), 2) + Math.pow((closestY - circleY), 2)) <= radius;

        return isOnSegment && isCloseEnough;
    }

}
