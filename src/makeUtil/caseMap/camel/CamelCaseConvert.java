package makeUtil.caseMap.camel;

import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/************
 * @info : Java -
 * @name : CamelCaseConvert
 * @date : 2023/05/20 6:43 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class CamelCaseConvert {

    /**
     * Convert String
     * @return
     */
    private String convertString(Matcher matcher, Function<MatchResult, String> replacer) {
        StringBuffer sb = new StringBuffer();

        while (matcher.find()) {
            MatchResult matchResult = matcher.toMatchResult();
            String format = replacer.apply(matchResult);
            matcher.appendReplacement(sb,format);
        }

        StringBuffer stringBuffer = matcher.appendTail(sb);
        return stringBuffer.toString();
    }


    /**
     * snake To Camel
     * @return
     */
    public String toCamel(String param) {
        Matcher matcher = Pattern.compile("([a-z])_([a-z])").matcher(param);

        String convert = convertString(matcher, matchResult -> {
            return String.format(
                    "%s%s",
                    matcher.group(1).toLowerCase(),
                    matcher.group(2).toUpperCase()
            );
        });

        return convert;
    }

    /**
     * camel To Snake (Lower Case)
     * @param param
     * @return
     */
    public String toSnake(String param) {
        Matcher matcher = Pattern.compile("([a-z])([A-Z])").matcher(param);

        String convert = convertString(matcher, matchResult -> {
            return String.format(
                    "%s_%s",
                    matcher.group(1).toLowerCase(),
                    matcher.group(2).toLowerCase()
            );
        });

        return convert;
    }




    public static void main(String[] args) {
        String snake = "tabe_basic_param";
        String camel = "testExampleString";
        CamelCaseConvert ccc = new CamelCaseConvert();

        String s = ccc.toCamel(snake);
        String s1 = ccc.toSnake(camel);
        System.out.println("s = " + s);
        System.out.println("s1 = " + s1);
    }
}
