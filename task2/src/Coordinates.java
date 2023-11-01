import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Coordinates {
    float x;
    float y;

    Coordinates(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public static List<Coordinates> createCoordinates(String pathFile) {
        List<Coordinates> coordinates = new ArrayList<>();
        File file = new File(pathFile);
        try (Reader reader = new FileReader(file.getPath())) {
            BufferedReader br = new BufferedReader(reader);
            while (br.ready()) {
                String str = br.readLine();
                if (str.isEmpty()) {
                    if (coordinates.size() == 0) {
                        System.out.println("Количество проверяемых точек равняется нулю");
                    }
                    break;
                }
                String[] tokens = str.split(" ");
                float x = Float.parseFloat(tokens[0]);
                float y = Float.parseFloat(tokens[1]);
                Coordinates coord = new Coordinates(x, y);
                coordinates.add(coord);
                if (coordinates.size() == 100) {
                    break;
                }
            }
        } catch (IOException e) {
            throw new SaveException("Ошибка при чтении файла " + file.getName(), e);
        }
        return coordinates;
    }
}
