import java.awt.*;

public class Rectangle extends Shape implements Comparable<Rectangle>, ColorDraw {
    private double width;
    private double height;

    public Rectangle(double x, double y) {
        super(x,y);
    }

    public Rectangle(double x, double y, double width, double height) {
        super(x,y);
        this.width = width;
        this.height = height;

    }

    public void checkColor() {
        if (isInBoundary()) {
            super.setColor(ShapeColor.GREEN);
        } else {
            super.setColor(ShapeColor.RED);
        }
    }

    public boolean isInBoundary() {
        if (-1 * Shape.getScreenSize() > super.getX() - this.width / 2 || Shape.getScreenSize() < super.getX() + this.width / 2) {
            return false;
        }
        if (-1 * Shape.getScreenSize() > super.getY() - this.height / 2 || Shape.getScreenSize() < super.getY() + this.height / 2) {
            return false;
        }
        return true;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String toString() {
        return "Rectangle{" + "width=" + width + ", height=" + height + " x=" + super.getX() +
                ", y=" + super.getY() + ", color=" + super.getColor() + "}\n";
    }

    public void draw() {
        StdDraw.setPenColor(super.getColor().getColor());
        StdDraw.filledRectangle(super.getX(), super.getY(), this.width / 2, this.height / 2);
    }

    @Override
    public int compareTo(Rectangle o) {
        double a1 = width * height;
        double a2 = o.width * o.height;
        return a1 == a2 ? (super.getX() < o.getX() ? 1:(super.getX() == o.getX() ? 0:-1)):(a1 < a2 ? 1:(a1 == a2 ? 0:-1));
    }

    @Override
    public void customizedColor(ColorScheme colorScheme, int index) {
        Color[] colorList = colorScheme.getColorScheme();
        if (index < 0){
            index = 0;
        }
        if (index >= colorList.length){
            index = index % colorList.length;
        }
        StdDraw.setPenColor(colorList[index]);
        StdDraw.filledRectangle(super.getX(), super.getY(), this.width / 2, this.height / 2);
    }
}
