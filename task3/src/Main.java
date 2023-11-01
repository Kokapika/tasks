import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        Tests tests = gson.fromJson(new FileReader(args[0]), Tests.class);
        Values values = gson.fromJson(new FileReader(args[1]), Values.class);

        for (Test test : tests.tests) {
            if (test.values == null) {
                for (Value value : values.values) {
                    if (value.id == test.id) {
                        test.value = value.value;
                    }
                }
            } else {
                for (Test t : test.values) {
                    if (t.values == null) {
                        for (Value value : values.values) {
                            if (value.id == t.id) {
                                t.value = value.value;
                            }
                            if (value.id == test.id) {
                                test.value = value.value;
                            }
                        }
                    } else {
                        for (Test t1 : t.values) {
                            for (Test t2 : t1.values) {
                                if (t2.values == null) {
                                    for (Value value : values.values) {
                                        if (value.id == t2.id) {
                                            t2.value = value.value;
                                        }
                                        if (value.id == t1.id) {
                                            t1.value = value.value;
                                        }
                                        if (value.id == t.id) {
                                            t.value = value.value;
                                        }
                                        if (value.id == test.id) {
                                            test.value = value.value;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        try (FileWriter fw = new FileWriter(args[2])) {
            gson.toJson(tests, fw);
            String json = gson.toJson(tests);
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Tests {
        public List<Test> tests;
    }

    public static class Test {
        public int id;
        public String title;
        public String value;
        public List<Test> values;
    }

    public static class Values {
        public List<Value> values;
    }

    public static class Value {
        public int id;
        public String value;
    }
}