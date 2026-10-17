package jawaHW4.task47;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Quadrilateral> shapes = new ArrayList<>();

        shapes.add(new Square(3));
        shapes.add(new Square(5));

        shapes.add(new Rectangle(2, 6));
        shapes.add(new Rectangle(3, 7));

        shapes.add(new Rhombus(6, 4));
        shapes.add(new Rhombus(10, 8));

        shapes.add(new ArbitraryQuadrilateral(new double[][]{
                {0, 0}, {5, 0}, {4, 2}, {0, 3}
        }));

        shapes.add(new ArbitraryQuadrilateral(new double[][]{
                {0, 0}, {4, 0}, {3, 2}, {0, 2}
        }));

        Map<String, List<Quadrilateral>> groups = new LinkedHashMap<>();

        for (Quadrilateral shape : shapes) {
            groups.computeIfAbsent(shape.getType(), key -> new ArrayList<>())
                    .add(shape);
        }

        for (Map.Entry<String, List<Quadrilateral>> entry : groups.entrySet()) {
            List<Quadrilateral> group = entry.getValue();

            Quadrilateral min = group.get(0);
            Quadrilateral max = group.get(0);

            for (Quadrilateral shape : group) {
                if (shape.getArea() < min.getArea()) {
                    min = shape;
                }

                if (shape.getArea() > max.getArea()) {
                    max = shape;
                }
            }

            System.out.println(entry.getKey() + ": кількість = " + group.size());

            System.out.printf("Найменший: %s (площа %.2f)%n",
                    min, min.getArea());

            System.out.printf("Найбільший: %s (площа %.2f)%n",
                    max, max.getArea());

            System.out.println();
        }
    }
}
