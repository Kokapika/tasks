import java.util.List;

public class Main {
    public static void main(String[] args) {
        String pathFileCircle = args[0];
        String pathFileCoordinates = args[1];

        Circle circle = Circle.createCircle(pathFileCircle);
        List<Coordinates> coordinates = Coordinates.createCoordinates(pathFileCoordinates);

        System.out.println("Окружность с координатами: x = " + circle.x + ", y = " + circle.y + "." + " Радиус r = " + circle.r + '\n');

        for (Coordinates coord : coordinates) {
            if ((coord.x - circle.x) * (coord.x - circle.x) + (coord.y - circle.y) * (coord.y - circle.y) < circle.r * circle.r) {
                System.out.println("Точка: x = " + coord.x + ", y = " + coord.y);
                System.out.println("1 - точка внутри окружности" + '\n');
            } else if ((coord.x - circle.x) * (coord.x - circle.x) + (coord.y - circle.y) * (coord.y - circle.y) == circle.r * circle.r) {
                System.out.println("Точка: x = " + coord.x + ", y = " + coord.y);
                System.out.println("0 - точка лежит на окружности" + '\n');
            } else {
                System.out.println("Точка: x = " + coord.x + ", y = " + coord.y);
                System.out.println("2 - точка снаружи окружности" + '\n');
            }
        }
    }
}