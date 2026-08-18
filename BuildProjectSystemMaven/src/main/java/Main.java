import org.apache.commons.lang3.StringUtils;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Main {

    public static String reverse(String str) {
        return StringUtils.reverse(str);
    }

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println(reverse("Hello World !"));
    }
}
