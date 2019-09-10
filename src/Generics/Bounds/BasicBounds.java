package Generics.Bounds;

//
//        Bounds allow you to place constraints on the parameter types that can be used with generics. Although this
//        allows you to
//        enforce rules about the types that your generics can be applied to, a potentially more important effect is that
//        you can call methods that are in your bound types.
//        Because erasure removes type information, the only methods you can call for an unbounded generic parameter are
//        those available for Object. If, however, you are able to constrain that parameter to be a subset of types, then
//        you can call the methods in that subset. To perform this constraint, Java generics reuse the extends keyword.
//        It’s important for you to *understand* that extends has a significantly different meaning in the context of
//        generic bounds than it does ordinarily

interface HasColor { java.awt.Color getColor(); }

class Colored<T extends HasColor> {
    T item;
    Colored(T item) { this.item = item; }
    T getItem() { return item; }
    // The bound allows you to call a method:
    java.awt.Color color() { return item.getColor(); }
}
class Dimension { public int x, y, z; }
// This won’t work -- class must be first, then interfaces:
// class ColoredDimension<T extends HasColor & Dimension> {
// Multiple bounds:
class ColoredDimension<T extends Dimension & HasColor> {
    T item;
    ColoredDimension(T item) { this.item = item; }
    T getItem() { return item; }
    java.awt.Color color() { return item.getColor(); }
    int getX() { return item.x; }
    int getY() { return item.y; }
    int getZ() { return item.z; }
}
interface Weight { int weight(); }
// As with inheritance, you can have only one
// concrete class but multiple interfaces:
class Solid<T extends Dimension & HasColor & Weight> {
    T item;
    Solid(T item) { this.item = item; }
    T getItem() { return item; }
    java.awt.Color color() { return item.getColor(); }
    int getX() { return item.x; }
    int getY() { return item.y; }
    int getZ() { return item.z; }
    int weight() { return item.weight(); }
}
class Bounded
        extends Dimension implements HasColor, Weight {
    public java.awt.Color getColor() { return null; }

    public int weight() { return 0; }
}
public class BasicBounds {
    public static void main(String[] args) {
        Solid<Bounded> solid =
                new Solid<Bounded>(new Bounded());
        solid.color();
        solid.getY();
        solid.weight();
    }
} ///:~