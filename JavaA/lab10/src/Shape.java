public abstract class Shape {
    private double x;
    private double y;
    private ShapeColor color = ShapeColor.GRAY;
    private static int screenSize = 10;
    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setColor(ShapeColor color) {
        this.color = color;
    }

    public static void setScreenSize(int screenSize) {
        Shape.screenSize = screenSize;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public static int getScreenSize() {
        return screenSize;
    }

    public ShapeColor getColor() {
        return color;
    }

    public void checkColor(){}

    public abstract void draw();

    @Override
    public String toString() {
        return " x=" + x + ", y=" + y + ", color=" + color;
    }

}
