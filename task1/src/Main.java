import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] circularVariableArray;
        List<int[]> intervals = new ArrayList<>();
        int circularVariable = 1;
        StringBuilder way = new StringBuilder();

        while (true) {
            circularVariableArray = new int[Integer.parseInt(args[1])];

            for (int i = 0; i < Integer.parseInt(args[1]); i++) {
                if (circularVariable > Integer.parseInt(args[0])) {
                    circularVariable = 1;
                }
                circularVariableArray[i] = circularVariable++;
            }
            circularVariable--;
            if (!intervals.isEmpty()) {
                if (intervals.get(0)[0] == circularVariableArray[0]) {
                    break;
                }
            }
            intervals.add(circularVariableArray);
        }

        for (int[] interval : intervals) {
                way.append(interval[0]);
        }

        System.out.println("Полученный путь: " + way);
    }
}