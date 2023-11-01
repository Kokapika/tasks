import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) {
        String pathFile = args[0];
        Integer[] nums = createArray(pathFile);

        double sum = 0;
        for (Integer num : nums) {
            sum += num;
        }

        int roundingSumMin = (int) sum / nums.length;
        int roundingSumMax = roundingSumMin + 1;

        int numberOfStepsWithRoundingSumMin = 0;
        int numberOfStepsWithRoundingSumMax = 0;

        for (Integer num : nums) {
            numberOfStepsWithRoundingSumMin += abs(num - roundingSumMin);
            numberOfStepsWithRoundingSumMax += abs(num - roundingSumMax);
        }

        int steps = Math.min(numberOfStepsWithRoundingSumMin, numberOfStepsWithRoundingSumMax);
        System.out.println(steps);
    }

    public static Integer[] createArray(String pathFile) {
        List<Integer> listNums = new ArrayList<>();
        File file = new File(pathFile);
        try (Reader reader = new FileReader(file.getPath())) {
            BufferedReader br = new BufferedReader(reader);
            while (br.ready()) {
                String str = br.readLine();
                if (str.isEmpty()) {
                    break;
                }
                int num = Integer.parseInt(str);
                listNums.add(num);
            }
        } catch (IOException e) {
            throw new SaveException("Ошибка при чтении файла " + file.getName(), e);
        }
        return listNums.toArray(new Integer[0]);
    }
}