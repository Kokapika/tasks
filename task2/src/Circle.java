import java.io.*;

public class Circle {
    float x;
    float y;
    float r;

    Circle(float x, float y, float r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public static Circle createCircle(String pathFile) {
        File file = new File(pathFile);
        try (Reader reader = new FileReader(file.getPath())) {
            BufferedReader br = new BufferedReader(reader);
            String token = br.readLine();
            String[] tokens = token.split(" ");
            float x = Float.parseFloat(tokens[0]);
            float y = Float.parseFloat(tokens[1]);
            float r = Float.parseFloat(br.readLine());
            return new Circle(x, y, r);
        } catch (IOException e) {
            throw new SaveException("Ошибка при чтении файла " + file.getName(), e);
        }
    }
}
