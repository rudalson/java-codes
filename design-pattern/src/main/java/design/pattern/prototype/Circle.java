package design.pattern.prototype;

public class Circle extends Shape {

    private int x, y, r;

    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public Circle copy() throws CloneNotSupportedException {
        Circle circle = (Circle) clone();
        return circle;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Circle circle1 = new Circle(1, 2, 3);
        Circle circle2 = circle1.copy();

        System.out.println(circle1.getX() + ", " + circle1.getY() + ", " + circle1.getR());
        System.out.println(circle2.getX() + ", " + circle2.getY() + ", " + circle2.getR());
    }
}
