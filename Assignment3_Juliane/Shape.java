public interface Shape {

    public abstract double getX();

    public abstract double getY();

    public abstract void setX(double x);

    public abstract void setY(double y);

    public abstract void moveTo(double x, double y);

    public abstract double perimeter();

    public abstract double area();

    //
    // having an intersect as part of the interface would require an
    // instanceof check in the implementation.
    // Instead we use function overloading in each specific subtype of Shape.
    //
    // public boolean intersect(Shape shape);

    // adding an intersect function for the specific subtypes of shapes would
    // require a priori knowledge of the subtypes
    // which would go against good design principles
    // a new shape called 'blob' would mean we would have to add an intersect(Blob
    // blob) to the interface

}