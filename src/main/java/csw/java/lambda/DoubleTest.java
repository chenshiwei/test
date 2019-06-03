package csw.java.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * 作用:
 *
 * @author chensw
 * @since 2018/9/14
 */

@SuppressWarnings("unchecked")
public class DoubleTest {
    public static void main(String[] args) {
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(System.out::println);
        features.stream().map((s) -> {
            String[] token = s.split(" ");
            return token.length;
        }).forEach(System.out::println);
    }
}
