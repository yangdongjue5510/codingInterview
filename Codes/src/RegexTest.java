import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static final String REGEX = "^//(.*)\n.*";

    public static void main(String[] args) {
        String input = "//;\n1;2";

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(input);

        System.out.println(Pattern.matches(REGEX, input));
        System.out.println(matcher.find());
    }
}
