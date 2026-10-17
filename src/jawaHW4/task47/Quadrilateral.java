package jawaHW4.task47;


public abstract class Quadrilateral {
    public abstract String getType();

    public abstract double getArea();

    protected static void checkPositive(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Розміри мають бути додатними.");
        }
    }
}

class Square extends Quadrilateral {
    private final double side;

    public Square(double side) {
        checkPositive(side);
        this.side = side;
    }

    @Override
    public String getType() {
        return "Квадрат";
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public String toString() {
        return "Квадрат зі стороною " + side;
    }
}

class Rectangle extends Quadrilateral {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        checkPositive(width);
        checkPositive(height);
        this.width = width;
        this.height = height;
    }

    @Override
    public String getType() {
        return "Прямокутник";
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Прямокутник " + width + " x " + height;
    }
}

class Rhombus extends Quadrilateral {
    private final double diagonal1;
    private final double diagonal2;

    public Rhombus(double diagonal1, double diagonal2) {
        checkPositive(diagonal1);
        checkPositive(diagonal2);
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
    }

    @Override
    public String getType() {
        return "Ромб";
    }

    @Override
    public double getArea() {
        return diagonal1 * diagonal2 / 2;
    }

    @Override
    public String toString() {
        return "Ромб з діагоналями " + diagonal1 + " і " + diagonal2;
    }
}

class ArbitraryQuadrilateral extends Quadrilateral {
    private final double[][] points = new double[4][2];

    public ArbitraryQuadrilateral(double[][] vertices) {
        if (vertices == null || vertices.length != 4) {
            throw new IllegalArgumentException("Потрібно рівно 4 вершини.");
        }

        for (int i = 0; i < 4; i++) {
            if (vertices[i] == null || vertices[i].length != 2) {
                throw new IllegalArgumentException("Вершина має містити x та y.");
            }

            points[i][0] = vertices[i][0];
            points[i][1] = vertices[i][1];
        }

        if (getArea() == 0) {
            throw new IllegalArgumentException("Площа не може дорівнювати нулю.");
        }
    }

    @Override
    public String getType() {
        return "Довільний";
    }

    @Override
    public double getArea() {
        double sum = 0;

        for (int i = 0; i < 4; i++) {
            int next = (i + 1) % 4;

            sum += points[i][0] * points[next][1]
                    - points[next][0] * points[i][1];
        }

        return Math.abs(sum) / 2;
    }

    @Override
    public String toString() {
        return "Довільний чотирикутник з вершинами "
                + java.util.Arrays.deepToString(points);
    }
}