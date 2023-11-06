public class Main {

    public static void main(String[] args) {
        Triangle triangle1 = new Triangle(4, 5, 6);
        Triangle triangle2 = new Triangle(4, 5, 5);

        Circle circle1 = new Circle(2, 8, 4);
        Circle circle2 = new Circle(2, 1, 1);

        Square square1 = new Square(1, 1, 3);
        Square square2 = new Square(2, 2, 3); // should intersect with square 1
        Square square3 = new Square(8, 8, 3); // should not intersect with square 1

        Pentagon pentagon1 = new Pentagon(10, 30, 1);
        Pentagon pentagon2 = new Pentagon(23, 5, 9);

        boolean intersects = square1.intersect(square2);
        System.out.println(square1 + " " + (intersects ? "intersects with " : " does not intersect with ") + square2);

        intersects = square3.intersect(pentagon2);
        System.out.println(square3 + " " + (intersects ? "intersects with " : " does not intersect with ") + pentagon2);

        intersects = circle1.intersect(square1);
        System.out.println(circle1 + " " + (intersects ? "intersects with " : " does not intersect with ") + square1);

        intersects = triangle1.intersect(square1);
        System.out.println(triangle1 + " " + (intersects ? "intersects with " : " does not intersect with ") + square1);

        intersects = pentagon2.intersect(circle2);
        System.out.println(pentagon2 + " " + (intersects ? "intersects with " : " does not intersect with ") + circle2);

        intersects = pentagon2.intersect(pentagon1);
        System.out
                .println(pentagon2 + " " + (intersects ? "intersects with " : " does not intersect with ") + pentagon1);

        intersects = pentagon2.intersect(triangle2);
        System.out
                .println(pentagon2 + " " + (intersects ? "intersects with " : " does not intersect with ") + triangle2);

        intersects = triangle2.intersect(triangle2);
        System.out
                .println(triangle2 + " " + (intersects ? "intersects with " : " does not intersect with ") + triangle2);

        intersects = circle1.intersect(triangle2);
        System.out
                .println(circle1 + " " + (intersects ? "intersects with " : " does not intersect with ") + triangle2);

        intersects = circle2.intersect(circle1);
        System.out
                .println(circle2 + " " + (intersects ? "intersects with " : " does not intersect with ") + circle1);

    }

}
