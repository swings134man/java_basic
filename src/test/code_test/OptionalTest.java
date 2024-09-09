package test.code_test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Optional Test
 */
public class OptionalTest {

    public static void main(String[] args) {
        Optional.ofNullable(getNamesPresent()).ifPresent(names -> {
            for (String name : names) {
                System.out.println("Name: " + name);
            }
        });
    }


    private static List<String> getNamesPresent() {
        List<String> list = Arrays.asList("Hello", "World", "Java");

        return list;
    }
}
